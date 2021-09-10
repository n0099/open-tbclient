package c.a.p0.a.r1.l;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class e implements c.a.p0.a.f1.f.a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static Integer f8438b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Integer f8439c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Integer f8440d = null;

    /* renamed from: e  reason: collision with root package name */
    public static Boolean f8441e = null;

    /* renamed from: f  reason: collision with root package name */
    public static Integer f8442f = null;

    /* renamed from: g  reason: collision with root package name */
    public static Boolean f8443g = null;

    /* renamed from: h  reason: collision with root package name */
    public static int f8444h = -1;

    /* renamed from: i  reason: collision with root package name */
    public static int f8445i = -1;

    /* renamed from: j  reason: collision with root package name */
    public static int f8446j = -1;
    public static int k = -1;
    public static int l = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1400749106, "Lc/a/p0/a/r1/l/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1400749106, "Lc/a/p0/a/r1/l/e;");
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f8441e == null) {
                f8441e = Boolean.valueOf(h("swan_api_callback_opt"));
            }
            return f8441e.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public static int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            c.a.p0.a.c1.a.Z().getSwitch(str, 0);
            if (c.a.p0.a.f1.f.a.f5702a) {
                String str2 = "packing[" + str + " = 0" + PreferencesUtil.RIGHT_MOUNT;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f8439c == null) {
                f8439c = Integer.valueOf(e() % 10000);
            }
            return f8439c.intValue();
        }
        return invokeV.intValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f8440d == null) {
                f8440d = Integer.valueOf(e() / 10000);
            }
            return f8440d.intValue();
        }
        return invokeV.intValue;
    }

    public static int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (f8438b == null) {
                f8438b = Integer.valueOf(b("swan_launch_api_trigger"));
            }
            return f8438b.intValue();
        }
        return invokeV.intValue;
    }

    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (f8445i == -1) {
                f8445i = b("swan_idle_handler_opt");
            }
            return f8445i;
        }
        return invokeV.intValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f() > 0 : invokeV.booleanValue;
    }

    public static boolean h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? b(str) != 0 : invokeL.booleanValue;
    }

    public static int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f8442f == null) {
                f8442f = Integer.valueOf(b("swan_launch_thread_dispatch"));
            }
            return f8442f.intValue();
        }
        return invokeV.intValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? i() > 0 : invokeV.booleanValue;
    }

    public static int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f8444h == -1) {
                f8444h = b("swan_optimize_launch_cpu");
            }
            return f8444h;
        }
        return invokeV.intValue;
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (k == -1) {
                k = b("swan_http_thread_opt");
            }
            return k > 0;
        }
        return invokeV.booleanValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (f8443g == null) {
                f8443g = Boolean.valueOf(h("swan_js_thread_dispatch"));
            }
            return f8443g.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (l == -1) {
                l = b("swan_webview_ssl_opt");
            }
            return l > 0;
        }
        return invokeV.booleanValue;
    }

    public static int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            if (f8446j == -1) {
                f8446j = b("swan_mmap_loger_opt");
            }
            return f8446j;
        }
        return invokeV.intValue;
    }
}
