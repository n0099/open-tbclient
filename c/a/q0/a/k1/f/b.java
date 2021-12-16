package c.a.q0.a.k1.f;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.h0.g.d;
import c.a.q0.a.h0.g.f;
import c.a.q0.a.h0.g.k;
import c.a.q0.a.h0.u.g;
import c.a.q0.a.y1.b.e;
import c.a.q0.a.z2.l0;
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

    public static int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        return i2 != 3 ? 100 : 118;
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
        HashMap<String, c.a.q0.a.p.e.d> V;
        c.a.q0.a.p.e.d dVar2;
        c.a.q0.a.p.e.c t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dVar)) == null) {
            if (dVar instanceof f) {
                c.a.q0.a.p.e.b p3 = ((f) dVar).p3();
                if (p3 == null || p3.l() == null) {
                    if (p3 != null) {
                        return (NgWebView) p3.t();
                    }
                    return null;
                }
                return (NgWebView) p3.l().t();
            } else if (!(dVar instanceof k) || (V = g.U().V()) == null || V.size() <= 0 || (dVar2 = V.get(c.a.q0.a.b3.b.c().h())) == null || !(dVar2 instanceof SwanWebModeWidget) || (t = dVar2.t()) == null || !(t instanceof NgWebView)) {
                return null;
            } else {
                return (NgWebView) t;
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
            SwanAppConfigData s = c.a.q0.a.g1.f.U().s();
            if (s == null) {
                return false;
            }
            return TextUtils.equals("none", s.f40550e.q);
        }
        return invokeV.booleanValue;
    }

    public static void g(int i2, int i3) {
        SwanAppActivity x;
        c.a.q0.a.h0.g.g swanAppFragmentManager;
        d m;
        NgWebView c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(65542, null, i2, i3) == null) || (x = c.a.q0.a.d2.d.J().x()) == null || (swanAppFragmentManager = x.getSwanAppFragmentManager()) == null || (m = swanAppFragmentManager.m()) == null || (c2 = c(m)) == null) {
            return;
        }
        if (!f()) {
            c2.getSettings().setTextZoom(a(i2));
            a.a(Integer.valueOf(i2 + 1), String.valueOf(i3));
        }
        h(i2);
    }

    public static void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, null, i2) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt(QuickPersistConfigConst.KEY_TEXT_SIZE, i2);
            c.a.q0.a.y1.c.a.e().h(new c.a.q0.a.y1.c.c(22, bundle));
        }
    }
}
