package c.a.p0.b.l;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.z2.o0;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.CookieManager;
import com.baidu.webkit.sdk.CookieSyncManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.SimpleTimeZone;
/* loaded from: classes5.dex */
public class y {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1330304133, "Lc/a/p0/b/l/y;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1330304133, "Lc/a/p0/b/l/y;");
                return;
            }
        }
        a = c.a.p0.a.k.a;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) ? b(str, HttpRequest.BDUSS, str2) : (String) invokeLL.objValue;
    }

    public static String b(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, str3)) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(1, TextUtils.isEmpty(str3) ? -8 : 8);
            return c(str, str2, str3, calendar.getTime(), false);
        }
        return (String) invokeLLL.objValue;
    }

    public static String c(String str, String str2, String str3, Date date, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, str2, str3, date, Boolean.valueOf(z)})) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append("=");
            sb.append(str3);
            sb.append(";domain=");
            sb.append(str);
            sb.append(";path=/;expires=");
            sb.append(simpleDateFormat.format(date));
            sb.append(";httponly");
            sb.append(z ? ";secure" : "");
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static String d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) ? b(str, "PTOKEN", str2) : (String) invokeLL.objValue;
    }

    public static List<String> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("baidu.com");
            arrayList.add("hao123.com");
            arrayList.add("nuomi.com");
            arrayList.add("baifubao.com");
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public static void f(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65542, null, str, str2, z) == null) {
            CookieManager.getInstance().setCookie(str, str2);
            if (z) {
                CookieSyncManager.getInstance().sync();
            }
        }
    }

    public static void g(Context context, String str, List<String> list) {
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, context, str, list) == null) {
            if (list == null) {
                boolean z = a;
                return;
            }
            for (String str2 : list) {
                if (TextUtils.isEmpty(str)) {
                    a2 = o0.k(str2, HttpRequest.BDUSS, "deleted", 0L);
                } else {
                    a2 = a(str2, str);
                }
                f("http://www." + str2, a2, false);
            }
        }
    }

    public static void h(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, context) == null) || context == null) {
            return;
        }
        String i2 = a.i(context);
        String r = a.r(context);
        g(context, i2, e());
        j(context, r, e());
    }

    public static void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, context) == null) {
            h(context);
        }
    }

    public static void j(Context context, String str, List<String> list) {
        String d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, context, str, list) == null) {
            if (list == null) {
                boolean z = a;
                return;
            }
            for (String str2 : list) {
                if (TextUtils.isEmpty(str)) {
                    d2 = o0.k(str2, "PTOKEN", "deleted", 0L);
                } else {
                    d2 = d(str2, str);
                }
                f("http://www." + str2, d2, false);
            }
        }
    }
}
