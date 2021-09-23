package c.a.p0.a.r1;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.f1.e.b;
import c.a.p0.a.h0.t.a;
import c.a.p0.a.v2.m;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
/* loaded from: classes.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, @Nullable c.a.p0.a.l1.b bVar) {
        c.a.p0.a.a2.e i2;
        b.a N;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, str, bVar) == null) || (i2 = c.a.p0.a.a2.e.i()) == null || (N = i2.N()) == null) {
            return;
        }
        HybridUbcFlow q = h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
        q.A("appid", N.H());
        q.A("swan", c.a.p0.a.m2.b.i(N.i0(), N.G()));
        q.A("net", SwanAppNetworkUtils.f().type);
        q.A("appversion", N.u1());
        q.A("thirdversion", N.v1());
        q.A("mobile", m.c());
        q.A("scheme", N.W());
        q.A("launchid", N.V());
        q.B("from", "swan");
        q.A("web_widget_state", "0");
        q.x();
        if (bVar != null) {
            q.B("na_multi_jump_dst_path", bVar.d());
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            c.a.p0.a.m1.f.j(true);
            h.s(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            HybridUbcFlow q = h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.C(new UbcFlowEvent("na_first_receive_action"));
            q.A("sub_state", "0");
        }
    }

    public static void c(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65538, null, i2, str) == null) {
            c.a.p0.a.y0.k.f.b.c(i2);
            HybridUbcFlow q = h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            if (i2 != 6 && i2 != 4 && i2 != 1) {
                q.F(HybridUbcFlow.SubmitStrategy.ROUTE);
            } else {
                q.F(HybridUbcFlow.SubmitStrategy.ROUTE_NA);
            }
            q.B("type", Integer.valueOf(i2));
            c.a.p0.a.h0.g.f J = c.a.p0.a.g1.f.V().J();
            q.B("na_multi_jump_src_path", J != null ? J.X2().d() : "");
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, str) == null) && TextUtils.equals(h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).g("sub_state"), "1")) {
            h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_end_sub_package_download"));
        }
    }

    public static void e(a.d dVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, dVar, str) == null) {
            h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_pre_load_slave_ok"));
            if (dVar == null) {
                return;
            }
            c.a.p0.a.p.e.b bVar = dVar.f6445a;
            if (bVar != null) {
                bVar.w(str);
            }
            HybridUbcFlow q = h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_pre_load_slave_start");
            ubcFlowEvent.h(dVar.f6448d);
            q.C(ubcFlowEvent);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_pre_load_slave_end");
            ubcFlowEvent2.h(dVar.f6449e);
            q.C(ubcFlowEvent2);
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
            HybridUbcFlow q = h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            q.C(new UbcFlowEvent("web_widget_first_screen_finish"));
            q.A("web_widget_state", "1");
            q.Q();
        }
    }
}
