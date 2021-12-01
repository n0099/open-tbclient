package c.a.p0.a.u1.l;

import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
import c.a.p0.q.k.i.o;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f8566b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f8567c;

    /* renamed from: d  reason: collision with root package name */
    public static int f8568d;

    /* renamed from: e  reason: collision with root package name */
    public static int f8569e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f8570f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f8571g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-231707240, "Lc/a/p0/a/u1/l/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-231707240, "Lc/a/p0/a/u1/l/b;");
                return;
            }
        }
        a = k.a;
        f8568d = -1;
        f8569e = -1;
        f8566b = f("swan_get_swan_id_cache");
        c.a.p0.a.c1.a.g0().getSwitch("swan_pms_use_outback_switch", 0);
        c.a.p0.a.c1.a.g0().getSwitch("swan_preload_game_strategy", 0);
        f8567c = 0;
        f8570f = f("swan_670_append_request_info");
        c.a.p0.a.c1.a.g0().getSwitch("swan_description_online_control", 0);
        o.a = 0;
        c.a.p0.a.c1.a.g0().getSwitch("swan_bdtls_use_cache", false);
        f8571g = false;
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f8569e == -1) {
                c.a.p0.a.c1.a.g0().getSwitch("swan_use_extra_connect_pool", 0);
                f8569e = 0;
            }
            return f8569e;
        }
        return invokeV.intValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f8568d == -1) {
                c.a.p0.a.c1.a.g0().getSwitch("swan_upgrade_js_thread_priority", 0);
                f8568d = 0;
            }
            return f8568d;
        }
        return invokeV.intValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f8571g : invokeV.booleanValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f8567c : invokeV.intValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? f8566b : invokeV.booleanValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            c.a.p0.a.c1.a.g0().getSwitch(str, 0);
            if (a) {
                String str2 = str + " value : 0";
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
