package c.a.h0.a.l;

import androidx.core.view.InputDeviceCompat;
import c.a.h0.a.k.g;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (str == null) {
                return null;
            }
            return (c(str).booleanValue() || d(str).booleanValue()) ? str.split("\\?")[0] : str;
        }
        return (String) invokeL.objValue;
    }

    public static HttpURLConnection b(URL url) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, url)) == null) {
            if (url.getProtocol().toLowerCase().equals("https")) {
                g.a();
                return (HttpsURLConnection) url.openConnection();
            }
            return (HttpURLConnection) url.openConnection();
        }
        return (HttpURLConnection) invokeL.objValue;
    }

    public static Boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? e(str, UrlSchemaHelper.SCHEMA_TYPE_HTTP) : (Boolean) invokeL.objValue;
    }

    public static Boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? e(str, UrlSchemaHelper.SCHEMA_TYPE_HTTPS) : (Boolean) invokeL.objValue;
    }

    public static Boolean e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            boolean z = false;
            if (str != null && str.trim().toLowerCase(Locale.getDefault()).indexOf(str2) == 0) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
        return (Boolean) invokeLL.objValue;
    }
}
