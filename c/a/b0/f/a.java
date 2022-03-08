package c.a.b0.f;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.WebView;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1950350978, "Lc/a/b0/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1950350978, "Lc/a/b0/f/a;");
                return;
            }
        }
        a = new String[]{"tel:", UrlSchemaHelper.SCHEMA_TYPE_SMS, "smsto:", WebView.SCHEME_MAILTO, "file:"};
    }

    public static String a(String str) {
        InterceptResult invokeL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            int indexOf2 = str.indexOf(63);
            if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SMS)) {
                indexOf = str.indexOf(UrlSchemaHelper.SCHEMA_TYPE_SMS) + 4;
            } else {
                indexOf = str.startsWith("smsto:") ? str.indexOf("smsto:") + 6 : 0;
            }
            boolean z = indexOf2 - indexOf > 1;
            if (indexOf2 > -1) {
                return z ? str.substring(indexOf, indexOf2) : "";
            }
            return str.substring(indexOf);
        }
        return (String) invokeL.objValue;
    }

    public static boolean b(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, context, str, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String e2 = e(str);
            if (z || c(e2)) {
                if (e2.startsWith("tel:")) {
                    return h(context, e2);
                }
                if (!e2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SMS) && !e2.startsWith("smsto:")) {
                    if (e2.startsWith(WebView.SCHEME_MAILTO)) {
                        return f(context, e2);
                    }
                    if (e2.startsWith("file:")) {
                        return d(context, e2);
                    }
                    return false;
                }
                return g(context, e2);
            }
            return false;
        }
        return invokeLLZ.booleanValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            for (String str2 : c.a.b0.f.g.a.a().c() != null ? c.a.b0.f.g.a.a().c() : a) {
                if (str.startsWith(str2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            try {
                Intent parseUri = Intent.parseUri(str, 1);
                if (Build.VERSION.SDK_INT >= 24) {
                    String path = Uri.parse(str).getPath();
                    if (path == null) {
                        return false;
                    }
                    c.a.b0.h0.a.a(context, new File(path), parseUri);
                }
                return c.a.b0.h0.a.c(context, parseUri);
            } catch (IllegalArgumentException | URISyntaxException unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static String e(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (!str.startsWith("wtai://") || str.length() <= 13) {
                return str;
            }
            return "tel:" + str.substring(13);
        }
        return (String) invokeL.objValue;
    }

    public static boolean f(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            if (context == null || str == null) {
                return false;
            }
            return c.a.b0.h0.a.c(context, new Intent("android.intent.action.SENDTO", Uri.parse(str)));
        }
        return invokeLL.booleanValue;
    }

    public static boolean g(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            String str2 = UrlSchemaHelper.SCHEMA_TYPE_SMS;
            try {
                int indexOf = str.indexOf("body=");
                String str3 = null;
                if (!str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SMS)) {
                    str2 = str.startsWith("smsto:") ? "smsto:" : null;
                }
                String a2 = a(str);
                if (indexOf > -1) {
                    str3 = str.substring(indexOf + 5);
                    if (!TextUtils.isEmpty(str3)) {
                        str3 = URLDecoder.decode(str3, "UTF-8");
                    }
                }
                Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(str2 + a2));
                intent.putExtra("sms_body", str3);
                c.a.b0.h0.a.c(context, intent);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean h(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(str));
            intent.setFlags(268435456);
            return c.a.b0.h0.a.c(context, intent);
        }
        return invokeLL.booleanValue;
    }
}
