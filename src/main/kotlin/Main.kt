import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

// Цветовые схемы для светлой и темной тем
private val LightColors = lightColors(
    primary = Color(0xFF6200EE),    // Основной цвет для светлой темы
    primaryVariant = Color(0xFF3700B3),
    secondary = Color(0xFF03DAC5),
    background = Color(0xFFFFFFFF), // Белый фон для светлой темы
    surface = Color(0xFFFFFFFF),
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
)

private val DarkColors = darkColors(
    primary = Color(0xFFBB86FC),    // Основной цвет для темной темы
    primaryVariant = Color(0xFF3700B3),
    secondary = Color(0xFF03DAC5),
    background = Color(0xFF121212), // Темный фон
    surface = Color(0xFF121212),
    onPrimary = Color.Black,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
)

@Composable
fun MyApp() {
    var isDarkTheme by remember { mutableStateOf(false) }  // Переменная для хранения текущей темы

    // Применяем выбранную цветовую схему
    MaterialTheme(
        colors = if (isDarkTheme) DarkColors else LightColors,
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "So if you ready...",
                    color = MaterialTheme.colors.onBackground,
                    style = MaterialTheme.typography.h5
                )
                Spacer(Modifier.height(16.dp))

                Button(onClick = { isDarkTheme = !isDarkTheme }) {
                    Text("And if you let me")
                }
            }
        }
    }


}

@Composable
@Preview
fun AppPreview() {
    MyApp()
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        MyApp()
    }
}