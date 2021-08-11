package c.a.n0.a.r1.l;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class e implements c.a.n0.a.f1.f.a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static Integer f8164b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Integer f8165c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Integer f8166d = null;

    /* renamed from: e  reason: collision with root package name */
    public static Boolean f8167e = null;

    /* renamed from: f  reason: collision with root package name */
    public static Integer f8168f = null;

    /* renamed from: g  reason: collision with root package name */
    public static Boolean f8169g = null;

    /* renamed from: h  reason: collision with root package name */
    public static int f8170h = -1;

    /* renamed from: i  reason: collision with root package name */
    public static int f8171i = -1;

    /* renamed from: j  reason: collision with root package name */
    public static int f8172j = -1;
    public static int k = -1;
    public static int l = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1142583668, "Lc/a/n0/a/r1/l/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1142583668, "Lc/a/n0/a/r1/l/e;");
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f8167e == null) {
                f8167e = Boolean.valueOf(h("swan_api_callback_opt"));
            }
            return f8167e.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public static int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            c.a.n0.a.c1.a.Z().getSwitch(str, 0);
            if (c.a.n0.a.f1.f.a.f5428a) {
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
            if (f8165c == null) {
                f8165c = Integer.valueOf(e() % 10000);
            }
            return f8165c.intValue();
        }
        return invokeV.intValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f8166d == null) {
                f8166d = Integer.valueOf(e() / 10000);
            }
            return f8166d.intValue();
        }
        return invokeV.intValue;
    }

    public static int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (f8164b == null) {
                f8164b = Integer.valueOf(b("swan_launch_api_trigger"));
            }
            return f8164b.intValue();
        }
        return invokeV.intValue;
    }

    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (f8171i == -1) {
                f8171i = b("swan_idle_handler_opt");
            }
            return f8171i;
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
            if (f8168f == null) {
                f8168f = Integer.valueOf(b("swan_launch_thread_dispatch"));
            }
            return f8168f.intValue();
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
            if (f8170h == -1) {
                f8170h = b("swan_optimize_launch_cpu");
            }
            return f8170h;
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
            if (f8169g == null) {
                f8169g = Boolean.valueOf(h("swan_js_thread_dispatch"));
            }
            return f8169g.booleanValue();
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
            if (f8172j == -1) {
                f8172j = b("swan_mmap_loger_opt");
            }
            return f8172j;
        }
        return invokeV.intValue;
    }
}
