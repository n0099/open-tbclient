package c.a.n0.a.a1.f;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.o1.b.e;
import c.a.n0.a.p2.l0;
import c.a.n0.a.x.g.d;
import c.a.n0.a.x.g.f;
import c.a.n0.a.x.g.k;
import c.a.n0.a.x.u.g;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.slave.SwanWebModeWidget;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return i != 3 ? 100 : 118;
                    }
                    return 112;
                }
                return 100;
            }
            return 82;
        }
        return invokeI.intValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            Bundle b2 = e.b(c.class, null);
            if (b2 == null) {
                return 1;
            }
            return b2.getInt("font_size_level", 1);
        }
        return invokeV.intValue;
    }

    public static NgWebView c(d dVar) {
        InterceptResult invokeL;
        HashMap<String, c.a.n0.a.f.e.d> V;
        c.a.n0.a.f.e.d dVar2;
        c.a.n0.a.f.e.c u;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dVar)) == null) {
            if (dVar instanceof f) {
                c.a.n0.a.f.e.b m3 = ((f) dVar).m3();
                if (m3 == null || m3.m() == null) {
                    if (m3 != null) {
                        return (NgWebView) m3.u();
                    }
                    return null;
                }
                return (NgWebView) m3.m().u();
            } else if (!(dVar instanceof k) || (V = g.U().V()) == null || V.size() <= 0 || (dVar2 = V.get(c.a.n0.a.r2.b.c().h())) == null || !(dVar2 instanceof SwanWebModeWidget) || (u = dVar2.u()) == null || !(u instanceof NgWebView)) {
                return null;
            } else {
                return (NgWebView) u;
            }
        }
        return (NgWebView) invokeL.objValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b() + 1 : invokeV.intValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? l0.f("3.200.101") : invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            SwanAppConfigData s = c.a.n0.a.w0.f.U().s();
            if (s == null) {
                return false;
            }
            return TextUtils.equals("none", s.f29239e.q);
        }
        return invokeV.booleanValue;
    }

    public static void g(int i, int i2) {
        SwanAppActivity x;
        c.a.n0.a.x.g.g swanAppFragmentManager;
        d m;
        NgWebView c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(65542, null, i, i2) == null) || (x = c.a.n0.a.t1.d.J().x()) == null || (swanAppFragmentManager = x.getSwanAppFragmentManager()) == null || (m = swanAppFragmentManager.m()) == null || (c2 = c(m)) == null) {
            return;
        }
        if (!f()) {
            c2.getSettings().setTextZoom(a(i));
            a.a(Integer.valueOf(i + 1), String.valueOf(i2));
        }
        h(i);
    }

    public static void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, null, i) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt(QuickPersistConfigConst.KEY_TEXT_SIZE, i);
            c.a.n0.a.o1.c.a.e().h(new c.a.n0.a.o1.c.c(22, bundle));
        }
    }
}
