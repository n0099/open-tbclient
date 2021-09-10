package c.a.p0.a.v2;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes.dex */
public class l0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f9359a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(22078235, "Lc/a/p0/a/v2/l0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(22078235, "Lc/a/p0/a/v2/l0;");
                return;
            }
        }
        f9359a = c.a.p0.a.k.f7077a;
    }

    public static boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) ? b(str) > b(str2) : invokeLL.booleanValue;
    }

    public static long b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String[] g2 = g(str);
            if (g2 == null) {
                return 0L;
            }
            long j2 = 0;
            for (int i2 = 0; i2 < g2.length; i2++) {
                try {
                    j2 += Integer.parseInt(g2[i2]) * ((long) Math.pow(1000.0d, (g2.length - i2) - 1));
                } catch (NumberFormatException e2) {
                    c.a.p0.a.e0.d.i("SwanAppSwanCoreUtils", "getVersionCode exception", e2);
                    return 0L;
                }
            }
            c.a.p0.a.e0.d.a("SwanAppSwanCoreUtils", "getVersion version: ", str, " ,versionCode: ", Long.valueOf(j2));
            return j2;
        }
        return invokeL.longValue;
    }

    @Deprecated
    public static long c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            String[] g2 = g(str);
            if (g2 == null) {
                return 0L;
            }
            int i2 = 0;
            long j2 = 0;
            while (i2 < 3) {
                try {
                    j2 = (j2 << 16) | (i2 < g2.length ? Integer.parseInt(g2[i2]) : 0L);
                    i2++;
                } catch (NumberFormatException e2) {
                    if (f9359a) {
                        throw e2;
                    }
                    return 0L;
                }
            }
            if (f9359a) {
                String str2 = "getVersion version: " + str + " ,versionCode: " + j2;
            }
            return j2;
        }
        return invokeL.longValue;
    }

    public static String d(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, null, j2)) == null) {
            if (j2 < 0) {
                c.a.p0.a.e0.d.h("SwanAppSwanCoreUtils", "versionCode < 0, versionCode = " + j2);
                return "0";
            }
            StringBuilder sb = new StringBuilder();
            long j3 = j2;
            for (int i2 = 2; i2 >= 0; i2--) {
                if (i2 > 0) {
                    long pow = (long) Math.pow(1000.0d, i2);
                    sb.append(j3 / pow);
                    sb.append(".");
                    j3 %= pow;
                } else {
                    sb.append(j3);
                }
            }
            String sb2 = sb.toString();
            c.a.p0.a.e0.d.a("SwanAppSwanCoreUtils", "getVersionName version code: ", Long.valueOf(j2), " ,version name: ", sb2);
            return sb2;
        }
        return (String) invokeJ.objValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        String[] list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            return file.isDirectory() && (list = file.list()) != null && list.length > 0;
        }
        return invokeL.booleanValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            long b2 = b(str);
            SwanCoreVersion V = c.a.p0.a.h0.u.g.N().V();
            long b3 = V != null ? b(V.swanCoreVersionName) : 0L;
            c.a.p0.a.e0.d.g("SwanAppSwanCoreUtils", "targetSwanVersionCode =" + b2 + ";curSwanVersionCode: " + b3);
            return b3 < b2;
        }
        return invokeL.booleanValue;
    }

    public static String[] g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            if (split.length != 3) {
                return null;
            }
            return split;
        }
        return (String[]) invokeL.objValue;
    }
}
