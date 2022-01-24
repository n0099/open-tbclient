package c.a.r0.a.u1.l;

import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class e implements c.a.r0.a.f1.f.a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static Boolean f9550c = null;

    /* renamed from: d  reason: collision with root package name */
    public static int f9551d = -1;

    /* renamed from: e  reason: collision with root package name */
    public static int f9552e = -1;

    /* renamed from: f  reason: collision with root package name */
    public static int f9553f = -1;

    /* renamed from: g  reason: collision with root package name */
    public static int f9554g = -1;

    /* renamed from: h  reason: collision with root package name */
    public static int f9555h = -1;

    /* renamed from: i  reason: collision with root package name */
    public static int f9556i = -1;

    /* renamed from: j  reason: collision with root package name */
    public static int f9557j = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(26458291, "Lc/a/r0/a/u1/l/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(26458291, "Lc/a/r0/a/u1/l/e;");
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f9553f == -1) {
                f9553f = b("swanswitch_file_res_cache_option");
            }
            return f9553f == 1;
        }
        return invokeV.booleanValue;
    }

    public static int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            c.a.r0.a.c1.a.g0().getSwitch(str, 0);
            if (c.a.r0.a.f1.f.a.a) {
                String str2 = "packing[" + str + " = 0" + PreferencesUtil.RIGHT_MOUNT;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f9556i == -1) {
                f9556i = b("swan_http_interceptor_opt");
            }
            return f9556i > 0;
        }
        return invokeV.booleanValue;
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? b(str) != 0 : invokeL.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? f() > 0 : invokeV.booleanValue;
    }

    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (f9557j == -1) {
                f9557j = b("swan_js_thread_opt");
            }
            return f9557j;
        }
        return invokeV.intValue;
    }

    public static int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f9555h == -1) {
                f9555h = b("swan_preload_slave_opt");
            }
            return f9555h;
        }
        return invokeV.intValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (f9551d == -1) {
                f9551d = b("swan_http_thread_opt");
            }
            return f9551d > 0;
        }
        return invokeV.booleanValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f9551d == -1) {
                f9551d = b("swan_http_thread_opt");
            }
            int i2 = f9551d;
            return i2 > 0 && i2 != 2;
        }
        return invokeV.booleanValue;
    }

    public static int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (f9554g == -1) {
                f9554g = b("swan_ubc_samping_opt");
            }
            return f9554g;
        }
        return invokeV.intValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? j() > 0 : invokeV.booleanValue;
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (f9550c == null) {
                f9550c = Boolean.valueOf(d("swan_js_thread_dispatch"));
            }
            return f9550c.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (f9552e == -1) {
                f9552e = b("swan_webview_ssl_opt");
            }
            return f9552e > 0;
        }
        return invokeV.booleanValue;
    }
}
