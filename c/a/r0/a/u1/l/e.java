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
    public static Boolean f9408c = null;

    /* renamed from: d  reason: collision with root package name */
    public static int f9409d = -1;

    /* renamed from: e  reason: collision with root package name */
    public static int f9410e = -1;

    /* renamed from: f  reason: collision with root package name */
    public static int f9411f = -1;

    /* renamed from: g  reason: collision with root package name */
    public static int f9412g = -1;

    /* renamed from: h  reason: collision with root package name */
    public static int f9413h = -1;

    /* renamed from: i  reason: collision with root package name */
    public static int f9414i = -1;

    /* renamed from: j  reason: collision with root package name */
    public static int f9415j = -1;
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
            if (f9411f == -1) {
                f9411f = b("swanswitch_file_res_cache_option");
            }
            return f9411f == 1;
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
            if (f9414i == -1) {
                f9414i = b("swan_http_interceptor_opt");
            }
            return f9414i > 0;
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
            if (f9415j == -1) {
                f9415j = b("swan_js_thread_opt");
            }
            return f9415j;
        }
        return invokeV.intValue;
    }

    public static int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f9413h == -1) {
                f9413h = b("swan_preload_slave_opt");
            }
            return f9413h;
        }
        return invokeV.intValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (f9409d == -1) {
                f9409d = b("swan_http_thread_opt");
            }
            return f9409d > 0;
        }
        return invokeV.booleanValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f9409d == -1) {
                f9409d = b("swan_http_thread_opt");
            }
            int i2 = f9409d;
            return i2 > 0 && i2 != 2;
        }
        return invokeV.booleanValue;
    }

    public static int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (f9412g == -1) {
                f9412g = b("swan_ubc_samping_opt");
            }
            return f9412g;
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
            if (f9408c == null) {
                f9408c = Boolean.valueOf(d("swan_js_thread_dispatch"));
            }
            return f9408c.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (f9410e == -1) {
                f9410e = b("swan_webview_ssl_opt");
            }
            return f9410e > 0;
        }
        return invokeV.booleanValue;
    }
}
