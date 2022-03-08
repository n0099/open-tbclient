package c.a.p0.a.b2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.e2.g.h;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(@NonNull String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, str2)) == null) {
            return str + str2;
        }
        return (String) invokeLL.objValue;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            String appId = c.a.p0.a.t1.d.J().getAppId();
            c.a.p0.a.e2.g.b a = h.a();
            a.remove(a("SwanAppStabilitySp-obtainData", appId));
            a.remove(a("SwanAppStabilitySp-autoObtain", appId));
            a.remove(a("SwanAppStabilitySp-swanStartupStability", appId));
            a.remove(a("SwanAppStabilitySp-obtainIntervalMs", appId));
            a.remove(a("SwanAppStabilitySp-autoObtainDataLen", appId));
            a.remove(a("SwanAppStabilitySp-stabilityProfile", appId));
        }
    }

    public static int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? h.a().getInt(a("SwanAppStabilitySp-autoObtainDataLen", c.a.p0.a.t1.d.J().getAppId()), i2) : invokeI.intValue;
    }

    public static int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? h.a().getInt(a("SwanAppStabilitySp-obtainIntervalMs", c.a.p0.a.t1.d.J().getAppId()), i2) : invokeI.intValue;
    }

    public static int e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? h.a().getInt(a("SwanAppStabilitySp-swanStartupStability", c.a.p0.a.t1.d.J().getAppId()), i2) : invokeI.intValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? h.a().getBoolean(a("SwanAppStabilitySp-autoObtain", c.a.p0.a.t1.d.J().getAppId()), false) : invokeV.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? h.a().getBoolean(a("SwanAppStabilitySp-obtainData", c.a.p0.a.t1.d.J().getAppId()), false) : invokeV.booleanValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? h.a().getBoolean(a("SwanAppStabilitySp-stabilityProfile", c.a.p0.a.t1.d.J().getAppId()), false) : invokeV.booleanValue;
    }

    public static void i(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65544, null, str, z) == null) {
            h.a().putBoolean(a("SwanAppStabilitySp-autoObtain", str), z);
        }
    }

    public static void j(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65545, null, str, i2) == null) {
            h.a().putInt(a("SwanAppStabilitySp-autoObtainDataLen", str), i2);
        }
    }

    public static void k(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65546, null, str, i2) == null) {
            h.a().putInt(a("SwanAppStabilitySp-obtainIntervalMs", str), i2);
        }
    }

    public static void l(boolean z, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65547, null, z, str) == null) {
            h.a().putBoolean(a("SwanAppStabilitySp-obtainData", str), z);
        }
    }

    public static void m(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65548, null, z, str) == null) {
            h.a().putBoolean(a("SwanAppStabilitySp-stabilityProfile", str), z);
        }
    }

    public static void n(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65549, null, str, i2) == null) {
            h.a().putInt(a("SwanAppStabilitySp-swanStartupStability", str), i2);
        }
    }
}
