package c.a.r0.a.d0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.l;
import c.a.r0.a.u1.l.d;
import c.a.r0.a.z2.n0;
import c.a.r0.a.z2.q0;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f5513b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(422285954, "Lc/a/r0/a/d0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(422285954, "Lc/a/r0/a/d0/c;");
                return;
            }
        }
        a = a.b();
        f5513b = new String[]{a.c(), a.b(), "https://ossapi.baidu.com", "https://ext.baidu.com"};
    }

    public static String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        StringBuilder sb;
        StringBuilder sb2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String str4 = str2 + "=";
            int indexOf = str.indexOf("?");
            String str5 = null;
            if (indexOf < 0) {
                int indexOf2 = str.indexOf("#");
                if (indexOf2 < 0) {
                    sb2 = new StringBuilder(str);
                } else {
                    str5 = str.substring(indexOf2);
                    sb2 = new StringBuilder(str.substring(0, indexOf2));
                }
                sb2.append("?");
                sb2.append(str4);
                sb2.append(str3);
                if (str5 != null) {
                    sb2.append(str5);
                }
                return sb2.toString();
            }
            if (str.indexOf("&" + str4, indexOf) < 0) {
                if (str.indexOf("?" + str4, indexOf) < 0) {
                    int indexOf3 = str.indexOf("#");
                    if (indexOf3 < 0) {
                        sb = new StringBuilder(str);
                    } else {
                        str5 = str.substring(indexOf3);
                        str = str.substring(0, indexOf3);
                        sb = new StringBuilder(str);
                    }
                    if (!str.endsWith("&") && !str.endsWith("?")) {
                        sb.append("&");
                    }
                    sb.append(str4);
                    sb.append(str3);
                    if (str5 != null) {
                        sb.append(str5);
                    }
                    return sb.toString();
                }
                return str;
            }
            return str;
        }
        return (String) invokeLLL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String b2 = d.b();
            return b2 != null ? a(str, "launchid", b2) : str;
        }
        return (String) invokeL.objValue;
    }

    public static int c() {
        InterceptResult invokeV;
        NetworkInfo networkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            String str = null;
            try {
                networkInfo = ((ConnectivityManager) c.a.r0.a.c1.a.c().getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (NullPointerException unused) {
                networkInfo = null;
            }
            if (networkInfo != null) {
                str = "wifi".equals(networkInfo.getTypeName().toLowerCase()) ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : networkInfo.getExtraInfo();
            }
            if (str != null) {
                String upperCase = str.toUpperCase();
                if (CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING.equals(upperCase)) {
                    return 1;
                }
                if ("3GNET".equals(upperCase)) {
                    return 21;
                }
                if ("3GWAP".equals(upperCase)) {
                    return 22;
                }
                if ("CMNET".equals(upperCase)) {
                    return 31;
                }
                if ("UNINET".equals(upperCase)) {
                    return 32;
                }
                if ("CTNET".equals(upperCase)) {
                    return 33;
                }
                if ("CMWAP".equals(upperCase)) {
                    return 41;
                }
                if ("UNIWAP".equals(upperCase)) {
                    return 42;
                }
                return "CTWAP".equals(upperCase) ? 43 : 5;
            }
            return 5;
        }
        return invokeV.intValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? c.a.r0.a.c1.a.n().a() : (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? "a0" : (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            String g2 = g();
            String h2 = h();
            int i2 = Build.VERSION.SDK_INT;
            String i3 = i();
            return g2 + "_" + h2 + "_" + i2 + "_" + i3;
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            String str = Build.MODEL;
            return TextUtils.isEmpty(str) ? "NUL" : str.replace("_", "-");
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            String str = Build.VERSION.RELEASE;
            return TextUtils.isEmpty(str) ? "0.0" : str.replace("_", "-");
        }
        return (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            String str = Build.MANUFACTURER;
            return TextUtils.isEmpty(str) ? "NUL" : str.replace("_", "-");
        }
        return (String) invokeV.objValue;
    }

    public static String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                return URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? j(s()) : (String) invokeV.objValue;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? j(t()) : (String) invokeV.objValue;
    }

    public static String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? j(f()) : (String) invokeV.objValue;
    }

    public static int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            NetworkInfo c2 = SwanAppNetworkUtils.c(c.a.r0.a.c1.a.c());
            if (c2 == null) {
                return 0;
            }
            return c2.getSubtype();
        }
        return invokeV.intValue;
    }

    public static String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            return c() + "_" + n();
        }
        return (String) invokeV.objValue;
    }

    public static String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? AppRuntime.getApplication().getPackageName() : (String) invokeV.objValue;
    }

    public static String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? "android" : (String) invokeV.objValue;
    }

    public static String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? l.a() : (String) invokeV.objValue;
    }

    public static String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            Context appContext = AppRuntime.getAppContext();
            int o = n0.o(appContext);
            int n = n0.n(appContext);
            int m = n0.m(appContext);
            String q = q();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(o);
            stringBuffer.append("_");
            stringBuffer.append(n);
            stringBuffer.append("_");
            stringBuffer.append(q);
            stringBuffer.append("_");
            stringBuffer.append(q0.D());
            stringBuffer.append("_");
            stringBuffer.append(m);
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? c.a.r0.a.c1.a.h0().i(AppRuntime.getAppContext()) : (String) invokeV.objValue;
    }

    public static boolean u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            for (String str2 : f5513b) {
                if (str.startsWith(str2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) ? w(str, false) : (String) invokeL.objValue;
    }

    public static String w(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65559, null, str, z)) == null) {
            String a2 = a(a(a(a(a(a(a(a(a(a(str, "uid", l()), "ua", k()), "ut", m()), "osbranch", e()), "pkgname", p()), "network", o()), "appname", d()), "hostname", d()), "swan_sdk_version", r()), "mnpunion", String.valueOf(SwanAppAllianceLoginHelper.f38633d.f() ? 2 : 0));
            return z ? b(a2) : a2;
        }
        return (String) invokeLZ.objValue;
    }
}
