package b.a.p0.a.u1.l;

import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import b.a.p0.q.k.i.o;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f9057a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f9058b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f9059c;

    /* renamed from: d  reason: collision with root package name */
    public static int f9060d;

    /* renamed from: e  reason: collision with root package name */
    public static int f9061e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f9062f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f9063g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(278826937, "Lb/a/p0/a/u1/l/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(278826937, "Lb/a/p0/a/u1/l/b;");
                return;
            }
        }
        f9057a = k.f6863a;
        f9060d = -1;
        f9061e = -1;
        f9058b = f("swan_get_swan_id_cache");
        b.a.p0.a.c1.a.g0().getSwitch("swan_pms_use_outback_switch", 0);
        b.a.p0.a.c1.a.g0().getSwitch("swan_preload_game_strategy", 0);
        f9059c = 0;
        f9062f = f("swan_670_append_request_info");
        b.a.p0.a.c1.a.g0().getSwitch("swan_description_online_control", 0);
        o.f11934a = 0;
        b.a.p0.a.c1.a.g0().getSwitch("swan_bdtls_use_cache", false);
        f9063g = false;
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f9061e == -1) {
                b.a.p0.a.c1.a.g0().getSwitch("swan_use_extra_connect_pool", 0);
                f9061e = 0;
            }
            return f9061e;
        }
        return invokeV.intValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f9060d == -1) {
                b.a.p0.a.c1.a.g0().getSwitch("swan_upgrade_js_thread_priority", 0);
                f9060d = 0;
            }
            return f9060d;
        }
        return invokeV.intValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f9063g : invokeV.booleanValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f9059c : invokeV.intValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f9058b : invokeV.booleanValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            b.a.p0.a.c1.a.g0().getSwitch(str, 0);
            if (f9057a) {
                String str2 = str + " value : 0";
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
