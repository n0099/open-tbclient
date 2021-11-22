package b.a.p0.a.l2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.o2.g.h;
import com.baidu.mobads.container.util.AdIconUtil;
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
            String appId = b.a.p0.a.d2.d.J().getAppId();
            b.a.p0.a.o2.g.b a2 = h.a();
            a2.remove(a("SwanAppStabilitySp-obtainData", appId));
            a2.remove(a("SwanAppStabilitySp-autoObtain", appId));
            a2.remove(a("SwanAppStabilitySp-swanStartupStability", appId));
            a2.remove(a("SwanAppStabilitySp-obtainIntervalMs", appId));
            a2.remove(a("SwanAppStabilitySp-autoObtainDataLen", appId));
            a2.remove(a("SwanAppStabilitySp-stabilityProfile", appId));
        }
    }

    public static int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? h.a().getInt(a("SwanAppStabilitySp-autoObtainDataLen", b.a.p0.a.d2.d.J().getAppId()), i2) : invokeI.intValue;
    }

    public static int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? h.a().getInt(a("SwanAppStabilitySp-obtainIntervalMs", b.a.p0.a.d2.d.J().getAppId()), i2) : invokeI.intValue;
    }

    public static int e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? h.a().getInt(a("SwanAppStabilitySp-swanStartupStability", b.a.p0.a.d2.d.J().getAppId()), i2) : invokeI.intValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? h.a().getBoolean(a("SwanAppStabilitySp-autoObtain", b.a.p0.a.d2.d.J().getAppId()), false) : invokeV.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? h.a().getBoolean(a("SwanAppStabilitySp-obtainData", b.a.p0.a.d2.d.J().getAppId()), false) : invokeV.booleanValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? h.a().getBoolean(a("SwanAppStabilitySp-stabilityProfile", b.a.p0.a.d2.d.J().getAppId()), false) : invokeV.booleanValue;
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
