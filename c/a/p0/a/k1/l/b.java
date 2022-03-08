package c.a.p0.a.k1.l;

import androidx.core.view.InputDeviceCompat;
import c.a.p0.q.j.i.o;
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
    public static boolean f6371b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f6372c;

    /* renamed from: d  reason: collision with root package name */
    public static int f6373d;

    /* renamed from: e  reason: collision with root package name */
    public static int f6374e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f6375f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f6376g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-516809458, "Lc/a/p0/a/k1/l/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-516809458, "Lc/a/p0/a/k1/l/b;");
                return;
            }
        }
        a = c.a.p0.a.a.a;
        f6373d = -1;
        f6374e = -1;
        f6371b = f("swan_get_swan_id_cache");
        c.a.p0.a.s0.a.g0().getSwitch("swan_pms_use_outback_switch", 0);
        c.a.p0.a.s0.a.g0().getSwitch("swan_preload_game_strategy", 0);
        f6372c = 0;
        f6375f = f("swan_670_append_request_info");
        c.a.p0.a.s0.a.g0().getSwitch("swan_description_online_control", 0);
        o.a = 0;
        c.a.p0.a.s0.a.g0().getSwitch("swan_bdtls_use_cache", false);
        f6376g = false;
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f6374e == -1) {
                c.a.p0.a.s0.a.g0().getSwitch("swan_use_extra_connect_pool", 0);
                f6374e = 0;
            }
            return f6374e;
        }
        return invokeV.intValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f6373d == -1) {
                c.a.p0.a.s0.a.g0().getSwitch("swan_upgrade_js_thread_priority", 0);
                f6373d = 0;
            }
            return f6373d;
        }
        return invokeV.intValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f6376g : invokeV.booleanValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f6372c : invokeV.intValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? f6371b : invokeV.booleanValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            c.a.p0.a.s0.a.g0().getSwitch(str, 0);
            if (a) {
                String str2 = str + " value : 0";
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
