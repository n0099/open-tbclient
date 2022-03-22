package c.a.n0.a.k1;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.m;
import c.a.n0.a.v0.e.b;
import c.a.n0.a.x.t.a;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public static long a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1214834598, "Lc/a/n0/a/k1/i;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1214834598, "Lc/a/n0/a/k1/i;");
        }
    }

    public static void a(String str, @Nullable c.a.n0.a.c1.b bVar) {
        c.a.n0.a.t1.e L;
        b.a X;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, str, bVar) == null) || (L = c.a.n0.a.t1.e.L()) == null || (X = L.X()) == null) {
            return;
        }
        HybridUbcFlow q = h.q("route", str);
        q.D("appid", X.H());
        q.D("swan", c.a.n0.a.g2.b.i(X.j0(), X.G()));
        q.D("net", SwanAppNetworkUtils.f().type);
        q.D("appversion", X.v1());
        q.D("thirdversion", X.w1());
        q.D("mobile", m.c());
        q.D("scheme", X.W());
        q.D("launchid", X.V());
        q.E("from", "swan");
        q.D("web_widget_state", "0");
        q.A();
        if (bVar != null) {
            q.E("na_multi_jump_dst_path", bVar.a());
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            c.a.n0.a.d1.g.j(true);
            h.s("route", str);
            HybridUbcFlow q = h.q("route", str);
            q.F(new UbcFlowEvent("na_first_receive_action"));
            q.D("sub_state", "0");
            a = System.currentTimeMillis();
        }
    }

    public static void c(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, null, i, str) == null) {
            c.a.n0.a.o0.k.f.b.c(i);
            HybridUbcFlow q = h.q("route", str);
            if (i != 6 && i != 4 && i != 1) {
                q.I(HybridUbcFlow.SubmitStrategy.ROUTE);
            } else {
                q.I(HybridUbcFlow.SubmitStrategy.ROUTE_NA);
            }
            q.E("type", Integer.valueOf(i));
            c.a.n0.a.x.g.f H = c.a.n0.a.w0.f.U().H();
            q.E("na_multi_jump_src_path", H != null ? H.k3().a() : "");
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) && TextUtils.equals(h.q("route", str).h("sub_state"), "1")) {
            h.q("route", str).F(new UbcFlowEvent("na_end_sub_package_download"));
        }
    }

    public static void e(a.e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, eVar, str) == null) {
            h.q("route", str).F(new UbcFlowEvent("na_pre_load_slave_ok"));
            if (eVar == null) {
                return;
            }
            c.a.n0.a.f.e.b bVar = eVar.a;
            if (bVar != null) {
                bVar.x(str);
            }
            HybridUbcFlow q = h.q("route", str);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_pre_load_slave_start");
            ubcFlowEvent.h(eVar.f7450d);
            q.F(ubcFlowEvent);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_pre_load_slave_end");
            ubcFlowEvent2.h(eVar.f7451e);
            q.F(ubcFlowEvent2);
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, str) == null) {
            HybridUbcFlow q = h.q("route", str);
            q.F(new UbcFlowEvent("web_widget_first_screen_finish"));
            q.D("web_widget_state", "1");
            q.T();
        }
    }
}
