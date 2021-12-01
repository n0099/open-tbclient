package c.a.p0.a.x1.a;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.a1.d;
import c.a.p0.a.d2.e;
import c.a.p0.a.f1.e.b;
import c.a.p0.a.f1.e.c;
import c.a.p0.a.g1.f;
import c.a.p0.a.h0.g.d;
import c.a.p0.a.h0.g.g;
import c.a.p0.a.k;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static c.a.p0.a.o2.g.a f8747b;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f8748c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1864491225, "Lc/a/p0/a/x1/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1864491225, "Lc/a/p0/a/x1/a/a;");
                return;
            }
        }
        a = k.a;
        HashSet hashSet = new HashSet();
        f8748c = hashSet;
        hashSet.add("aiapps_websafe_debug_key");
        f8748c.add("aiapps_server_domains_debug_key");
        f8748c.add("aiapps_use_extension_debug_key");
        f8748c.add("aiapps_emit_live_debug_key");
        f8748c.add("aiapps_emit_https_debug_key");
        f8748c.add("aiapps_emit_wss_debug_key");
        f8748c.add("aiapps_load_cts_debug_key");
        f8748c.add("aiapps_env_data");
        f8748c.add("aiapps_js_native_switch_key");
        f8748c.add("aiapps_emit_game_core_debug_key");
        f8748c.add("aiapps_emit_game_launch_mode_key");
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? d("aiapps_websafe_debug_key", true) : invokeV.booleanValue;
    }

    public static boolean B(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bVar)) == null) ? (a && bVar.n0()) || F(bVar.g0()) || c.a.p0.a.e0.f.b.e() || c.a.p0.a.e0.f.b.f() || bVar.p0() || (x() && bVar.R()) : invokeL.booleanValue;
    }

    public static boolean C(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cVar)) == null) ? (a && cVar.n0()) || F(cVar.g0()) || c.a.p0.a.e0.f.b.e() || c.a.p0.a.e0.f.b.f() || cVar.p0() || (x() && cVar.R()) : invokeL.booleanValue;
    }

    public static boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            e a0 = e.a0();
            if (a0 != null) {
                return a0.V().p0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? s() || r() || o() || y() || !A() || k() || h() || q() || x() || c.a.p0.a.p0.f.a.b(t()) : invokeV.booleanValue;
    }

    public static boolean F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? !TextUtils.isEmpty(str) || c.a.p0.a.e0.f.e.e.d() : invokeL.booleanValue;
    }

    public static Boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? Boolean.valueOf(d("KEY_SWAN_APP_DEBUG_INSPECT", false)) : (Boolean) invokeV.objValue;
    }

    public static boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? c.a.p0.a.e0.f.b.e() || c.a.p0.a.e0.f.b.f() : invokeV.booleanValue;
    }

    public static Bundle I(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, cVar)) == null) {
            if (C(cVar)) {
                b.a b2 = b();
                b2.v0(cVar.H());
                b2.I0(cVar.T());
                b2.R0(cVar.e0());
                b2.A0(cVar.n0());
                b2.L0(cVar.p0());
                b2.y0(cVar.L());
                b2.D0(cVar.s0());
                b2.K0(cVar.W());
                b2.P0(cVar.c0());
                b2.Z0(cVar.j0());
                b2.C0(cVar.O());
                b2.a1(cVar.k0());
                b2.T0(cVar.g0());
                b2.H1("0");
                b2.u0(cVar.G());
                b2.Q0(cVar.d0());
                if (F(cVar.g0()) || H() || cVar.p0()) {
                    b2.A1(cVar.H());
                }
                return b2.D();
            }
            return null;
        }
        return (Bundle) invokeL.objValue;
    }

    public static void J(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65547, null, str, z) == null) {
            u().putBoolean(str, z);
        }
    }

    public static void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, str) == null) {
            u().putString("aiapps_env_data", str);
        }
    }

    public static void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65549, null, z) == null) {
            J("aiapps_emit_game_core_debug_key", z);
        }
    }

    public static void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, null, z) == null) {
            c.a.p0.a.q2.b.q(z);
        }
    }

    public static void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65551, null, z) == null) {
            J("aiapps_emit_https_debug_key", z);
        }
    }

    public static void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65552, null, z) == null) {
            J("aiapps_js_native_switch_key", z);
        }
    }

    public static void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65553, null, z) == null) {
            J("aiapps_emit_wss_debug_key", z);
        }
    }

    public static void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65554, null, z) == null) {
            J("aiapps_emit_live_debug_key", z);
        }
    }

    public static void R(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65555, null, z) == null) {
            J("aiapps_load_cts_debug_key", z);
        }
    }

    public static void S(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65556, null, i2) == null) {
            u().putInt("aiapps_pms_host_env", i2);
        }
    }

    public static void T(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65557, null, z) == null) {
            J("aiapps_server_domains_debug_key", z);
        }
    }

    public static void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65558, null, z) == null) {
            J("aiapps_emit_game_launch_mode_key", z);
        }
    }

    public static void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65559, null, z) == null) {
            J("aiapps_use_extension_debug_key", z);
        }
    }

    public static void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65560, null, z) == null) {
            J("aiapps_websafe_debug_key", z);
        }
    }

    public static boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) ? u().getBoolean("swan_debug_forbid_sample", true) : invokeV.booleanValue;
    }

    public static boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) ? u().getBoolean("swan_debug_force_ab", false) : invokeV.booleanValue;
    }

    public static void Z() {
        g V;
        d m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65563, null) == null) || (V = f.U().V()) == null || (m = V.m()) == null) {
            return;
        }
        m.T2();
    }

    public static ExtensionCore a(ExtensionCore extensionCore) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, extensionCore)) == null) {
            if (extensionCore == null) {
                return null;
            }
            extensionCore.extensionCoreVersionCode = 4294967297L;
            extensionCore.extensionCoreVersionName = com.baidu.fsg.face.base.b.b.f34497e;
            return extensionCore;
        }
        return (ExtensionCore) invokeL.objValue;
    }

    @SuppressLint({"BDOfflineUrl"})
    public static b.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) ? ((b.a) ((b.a) ((b.a) new b.a().S0(new PMSAppInfo())).B1("小程序测试").v0("10985873").O0(Color.parseColor("#FF308EF0"))).I0("1230000000000000")).y1("小程序简介").E1("测试服务类目").F1("测试主体信息").A1("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N").H1("1.0").C1("https://b.bdstatic.com/searchbox/mappconsole/image/20180502/1525250801121271.png") : (b.a) invokeV.objValue;
    }

    public static d.g c(b bVar, c.a.p0.a.z2.b1.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, bVar, bVar2)) == null) {
            if (a && bVar.n0()) {
                return d.b.a(bVar, bVar2);
            }
            if (F(bVar.g0())) {
                return d.f.a(bVar);
            }
            if (c.a.p0.a.e0.f.b.e()) {
                return c.a.p0.a.e0.f.c.a.a(bVar);
            }
            if (c.a.p0.a.e0.f.b.f()) {
                return c.a.p0.a.e0.f.f.b.a(bVar);
            }
            if (bVar.p0()) {
                return c.a.p0.a.e0.f.d.b.a(bVar);
            }
            return null;
        }
        return (d.g) invokeLL.objValue;
    }

    public static boolean d(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65567, null, str, z)) == null) ? u().getBoolean(str, z) : invokeLZ.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) ? d("aiapps_close_view_disable_debug_key", false) : invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) ? d("aiapps_dashboard_enable_debug_key", false) : invokeV.booleanValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) ? u().getString("aiapps_env_data", "") : (String) invokeV.objValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) ? d("aiapps_emit_game_core_debug_key", false) : invokeV.booleanValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) ? u().getString("swan_debug_so_url_key", "") : (String) invokeV.objValue;
    }

    public static int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) ? u().getInt("swan_debug_open_so_key", -1) : invokeV.intValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) ? c.a.p0.a.q2.b.j() : invokeV.booleanValue;
    }

    public static String l(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, bVar)) == null) {
            if (a && bVar.n0()) {
                return d.b.g().getPath();
            }
            if (F(bVar.g0())) {
                return d.f.e().getPath();
            }
            if (c.a.p0.a.e0.f.b.e()) {
                return c.a.p0.a.e0.f.c.a.b().getPath();
            }
            if (c.a.p0.a.e0.f.b.f()) {
                return c.a.p0.a.e0.f.f.b.e().getPath();
            }
            return bVar.p0() ? c.a.p0.a.e0.f.d.b.d().getPath() : "";
        }
        return (String) invokeL.objValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) ? d("aiapps_force_authorized_key", false) : invokeV.booleanValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) ? d("swan_game_fps_debug_key", false) : invokeV.booleanValue;
    }

    public static boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) ? d("aiapps_emit_https_debug_key", false) : invokeV.booleanValue;
    }

    public static boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65579, null)) == null) ? d("aiapps_js_native_switch_key", true) : invokeV.booleanValue;
    }

    public static boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) ? d("aiapps_emit_wss_debug_key", false) : invokeV.booleanValue;
    }

    public static boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65581, null)) == null) ? d("aiapps_emit_live_debug_key", false) : invokeV.booleanValue;
    }

    public static boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) ? d("aiapps_load_cts_debug_key", false) : invokeV.booleanValue;
    }

    public static int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) ? u().getInt("aiapps_pms_host_env", 0) : invokeV.intValue;
    }

    public static c.a.p0.a.o2.g.a u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) {
            if (f8747b == null) {
                synchronized (a.class) {
                    if (f8747b == null) {
                        c.a.p0.a.o2.g.a aVar = new c.a.p0.a.o2.g.a("swan_app_debug");
                        f8747b = aVar;
                        aVar.f7201f.addAll(f8748c);
                    }
                }
            }
            return f8747b;
        }
        return (c.a.p0.a.o2.g.a) invokeV.objValue;
    }

    public static boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) ? d("aiapps_sconsole_scan_mode_debug_key", false) : invokeV.booleanValue;
    }

    public static boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65586, null)) == null) ? d("aiapps_server_domains_debug_key", true) : invokeV.booleanValue;
    }

    public static boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65587, null)) == null) ? d("aiapps_emit_game_launch_mode_key", false) : invokeV.booleanValue;
    }

    public static boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65588, null)) == null) ? d("aiapps_use_extension_debug_key", false) : invokeV.booleanValue;
    }

    public static boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65589, null)) == null) ? d("aiapps_use_game_extension_debug_key", false) : invokeV.booleanValue;
    }
}
