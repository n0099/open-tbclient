package c.a.n0.a.k1.l;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class e implements c.a.n0.a.v0.f.a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static Boolean f5361c = null;

    /* renamed from: d  reason: collision with root package name */
    public static int f5362d = -1;

    /* renamed from: e  reason: collision with root package name */
    public static int f5363e = -1;

    /* renamed from: f  reason: collision with root package name */
    public static int f5364f = -1;

    /* renamed from: g  reason: collision with root package name */
    public static int f5365g = -1;

    /* renamed from: h  reason: collision with root package name */
    public static int f5366h = -1;
    public static int i = -1;
    public static int j = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-774974803, "Lc/a/n0/a/k1/l/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-774974803, "Lc/a/n0/a/k1/l/e;");
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f5364f == -1) {
                f5364f = b("swanswitch_file_res_cache_option");
            }
            return f5364f == 1;
        }
        return invokeV.booleanValue;
    }

    public static int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            c.a.n0.a.s0.a.g0().getSwitch(str, 0);
            if (c.a.n0.a.v0.f.a.a) {
                Log.d("SwanPerformance", "packing[" + str + " = 0" + PreferencesUtil.RIGHT_MOUNT);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (i == -1) {
                i = b("swan_http_interceptor_opt");
            }
            return i > 0;
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
            if (j == -1) {
                j = b("swan_js_thread_opt");
            }
            return j;
        }
        return invokeV.intValue;
    }

    public static int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f5366h == -1) {
                f5366h = b("swan_preload_slave_opt");
            }
            return f5366h;
        }
        return invokeV.intValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (f5362d == -1) {
                f5362d = b("swan_http_thread_opt");
            }
            return f5362d > 0;
        }
        return invokeV.booleanValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f5362d == -1) {
                f5362d = b("swan_http_thread_opt");
            }
            int i2 = f5362d;
            return i2 > 0 && i2 != 2;
        }
        return invokeV.booleanValue;
    }

    public static int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (f5365g == -1) {
                f5365g = b("swan_ubc_samping_opt");
            }
            return f5365g;
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
            if (f5361c == null) {
                f5361c = Boolean.valueOf(d("swan_js_thread_dispatch"));
            }
            return f5361c.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (f5363e == -1) {
                f5363e = b("swan_webview_ssl_opt");
            }
            return f5363e > 0;
        }
        return invokeV.booleanValue;
    }
}
