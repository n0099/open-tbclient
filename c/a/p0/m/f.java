package c.a.p0.m;

import android.webkit.WebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.PrintStream;
@Deprecated
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, str, webView) == null) {
            String url = webView != null ? webView.getUrl() : "";
            PrintStream printStream = System.out;
            printStream.println("WebViewChecker: " + str + " " + url);
        }
    }
}
