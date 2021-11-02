package b.a.p0.a.u1.a;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a1.e;
import b.a.p0.a.a2.e;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.f1.e.c;
import b.a.p0.a.g1.f;
import b.a.p0.a.h0.g.d;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.k;
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f8435a;

    /* renamed from: b  reason: collision with root package name */
    public static b.a.p0.a.k2.g.a f8436b;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f8437c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(278499205, "Lb/a/p0/a/u1/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(278499205, "Lb/a/p0/a/u1/a/a;");
                return;
            }
        }
        f8435a = k.f6397a;
        HashSet hashSet = new HashSet();
        f8437c = hashSet;
        hashSet.add("aiapps_websafe_debug_key");
        f8437c.add("aiapps_server_domains_debug_key");
        f8437c.add("aiapps_use_extension_debug_key");
        f8437c.add("aiapps_emit_live_debug_key");
        f8437c.add("aiapps_emit_https_debug_key");
        f8437c.add("aiapps_emit_wss_debug_key");
        f8437c.add("aiapps_load_cts_debug_key");
        f8437c.add("aiapps_env_data");
        f8437c.add("aiapps_js_native_switch_key");
        f8437c.add("aiapps_emit_game_core_debug_key");
        f8437c.add("aiapps_emit_game_launch_mode_key");
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

    public static boolean A(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bVar)) == null) ? (f8435a && bVar.l0()) || E(bVar.f0()) || b.a.p0.a.e0.f.b.e() || b.a.p0.a.e0.f.b.f() || bVar.n0() || (w() && bVar.Q()) : invokeL.booleanValue;
    }

    public static boolean B(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cVar)) == null) ? (f8435a && cVar.l0()) || E(cVar.f0()) || b.a.p0.a.e0.f.b.e() || b.a.p0.a.e0.f.b.f() || cVar.n0() || (w() && cVar.Q()) : invokeL.booleanValue;
    }

    public static boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            e P = e.P();
            if (P != null) {
                return P.K().n0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? s() || r() || o() || x() || !z() || k() || h() || q() || w() : invokeV.booleanValue;
    }

    public static boolean E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? !TextUtils.isEmpty(str) || b.a.p0.a.e0.f.e.e.d() : invokeL.booleanValue;
    }

    public static Boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? Boolean.valueOf(d("KEY_SWAN_APP_DEBUG_INSPECT", false)) : (Boolean) invokeV.objValue;
    }

    public static boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? b.a.p0.a.e0.f.b.e() || b.a.p0.a.e0.f.b.f() : invokeV.booleanValue;
    }

    public static Bundle H(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cVar)) == null) {
            if (B(cVar)) {
                b.a b2 = b();
                b2.t0(cVar.G());
                b2.G0(cVar.S());
                b2.P0(cVar.d0());
                b2.y0(cVar.l0());
                b2.J0(cVar.n0());
                b2.w0(cVar.K());
                b2.B0(cVar.q0());
                b2.I0(cVar.V());
                b2.N0(cVar.b0());
                b2.W0(cVar.h0());
                b2.A0(cVar.N());
                b2.X0(cVar.i0());
                b2.R0(cVar.f0());
                b2.E1("0");
                b2.s0(cVar.F());
                b2.O0(cVar.c0());
                if (E(cVar.f0()) || G() || cVar.n0()) {
                    b2.x1(cVar.G());
                }
                return b2.C();
            }
            return null;
        }
        return (Bundle) invokeL.objValue;
    }

    public static void I(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65546, null, str, z) == null) {
            t().putBoolean(str, z);
        }
    }

    public static void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            t().putString("aiapps_env_data", str);
        }
    }

    public static void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            I("aiapps_emit_game_core_debug_key", z);
        }
    }

    public static void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65549, null, z) == null) {
            b.a.p0.a.m2.b.q(z);
        }
    }

    public static void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, null, z) == null) {
            I("aiapps_emit_https_debug_key", z);
        }
    }

    public static void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65551, null, z) == null) {
            I("aiapps_js_native_switch_key", z);
        }
    }

    public static void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65552, null, z) == null) {
            I("aiapps_emit_wss_debug_key", z);
        }
    }

    public static void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65553, null, z) == null) {
            I("aiapps_emit_live_debug_key", z);
        }
    }

    public static void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65554, null, z) == null) {
            I("aiapps_load_cts_debug_key", z);
        }
    }

    public static void R(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65555, null, z) == null) {
            I("aiapps_server_domains_debug_key", z);
        }
    }

    public static void S(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65556, null, z) == null) {
            I("aiapps_emit_game_launch_mode_key", z);
        }
    }

    public static void T(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65557, null, z) == null) {
            I("aiapps_use_extension_debug_key", z);
        }
    }

    public static void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65558, null, z) == null) {
            I("aiapps_websafe_debug_key", z);
        }
    }

    public static boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? t().getBoolean("swan_debug_forbid_sample", true) : invokeV.booleanValue;
    }

    public static boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? t().getBoolean("swan_debug_force_ab", false) : invokeV.booleanValue;
    }

    public static void X() {
        g U;
        d m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65561, null) == null) || (U = f.T().U()) == null || (m = U.m()) == null) {
            return;
        }
        m.A2();
    }

    public static ExtensionCore a(ExtensionCore extensionCore) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, extensionCore)) == null) {
            if (extensionCore == null) {
                return null;
            }
            extensionCore.extensionCoreVersionCode = 4294967297L;
            extensionCore.extensionCoreVersionName = com.baidu.fsg.face.base.b.b.f37758e;
            return extensionCore;
        }
        return (ExtensionCore) invokeL.objValue;
    }

    @SuppressLint({"BDOfflineUrl"})
    public static b.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) ? ((b.a) ((b.a) ((b.a) new b.a().Q0(new PMSAppInfo())).y1("小程序测试").t0("10985873").M0(Color.parseColor("#FF308EF0"))).G0("1230000000000000")).v1("小程序简介").B1("测试服务类目").C1("测试主体信息").x1("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N").E1("1.0").z1("https://b.bdstatic.com/searchbox/mappconsole/image/20180502/1525250801121271.png") : (b.a) invokeV.objValue;
    }

    public static e.g c(b bVar, b.a.p0.a.v2.a1.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, bVar, bVar2)) == null) {
            if (f8435a && bVar.l0()) {
                return e.b.a(bVar, bVar2);
            }
            if (E(bVar.f0())) {
                return e.f.a(bVar);
            }
            if (b.a.p0.a.e0.f.b.e()) {
                return b.a.p0.a.e0.f.c.a.a(bVar);
            }
            if (b.a.p0.a.e0.f.b.f()) {
                return b.a.p0.a.e0.f.f.b.a(bVar);
            }
            if (bVar.n0()) {
                return b.a.p0.a.e0.f.d.b.a(bVar);
            }
            return null;
        }
        return (e.g) invokeLL.objValue;
    }

    public static boolean d(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65565, null, str, z)) == null) ? t().getBoolean(str, z) : invokeLZ.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) ? d("aiapps_close_view_disable_debug_key", false) : invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) ? d("aiapps_dashboard_enable_debug_key", false) : invokeV.booleanValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) ? t().getString("aiapps_env_data", "") : (String) invokeV.objValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) ? d("aiapps_emit_game_core_debug_key", false) : invokeV.booleanValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) ? t().getString("swan_debug_so_url_key", "") : (String) invokeV.objValue;
    }

    public static int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) ? t().getInt("swan_debug_open_so_key", -1) : invokeV.intValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) ? b.a.p0.a.m2.b.j() : invokeV.booleanValue;
    }

    public static String l(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, bVar)) == null) {
            if (f8435a && bVar.l0()) {
                return e.b.g().getPath();
            }
            if (E(bVar.f0())) {
                return e.f.e().getPath();
            }
            if (b.a.p0.a.e0.f.b.e()) {
                return b.a.p0.a.e0.f.c.a.b().getPath();
            }
            if (b.a.p0.a.e0.f.b.f()) {
                return b.a.p0.a.e0.f.f.b.e().getPath();
            }
            return bVar.n0() ? b.a.p0.a.e0.f.d.b.d().getPath() : "";
        }
        return (String) invokeL.objValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) ? d("aiapps_force_authorized_key", false) : invokeV.booleanValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) ? d("swan_game_fps_debug_key", false) : invokeV.booleanValue;
    }

    public static boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) ? d("aiapps_emit_https_debug_key", false) : invokeV.booleanValue;
    }

    public static boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) ? d("aiapps_js_native_switch_key", true) : invokeV.booleanValue;
    }

    public static boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) ? d("aiapps_emit_wss_debug_key", false) : invokeV.booleanValue;
    }

    public static boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65579, null)) == null) ? d("aiapps_emit_live_debug_key", false) : invokeV.booleanValue;
    }

    public static boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) ? d("aiapps_load_cts_debug_key", false) : invokeV.booleanValue;
    }

    public static b.a.p0.a.k2.g.a t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65581, null)) == null) {
            if (f8436b == null) {
                synchronized (a.class) {
                    if (f8436b == null) {
                        b.a.p0.a.k2.g.a aVar = new b.a.p0.a.k2.g.a("swan_app_debug");
                        f8436b = aVar;
                        aVar.f6440f.addAll(f8437c);
                    }
                }
            }
            return f8436b;
        }
        return (b.a.p0.a.k2.g.a) invokeV.objValue;
    }

    public static boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) ? d("aiapps_sconsole_scan_mode_debug_key", false) : invokeV.booleanValue;
    }

    public static boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) ? d("aiapps_server_domains_debug_key", true) : invokeV.booleanValue;
    }

    public static boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) ? d("aiapps_emit_game_launch_mode_key", false) : invokeV.booleanValue;
    }

    public static boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) ? d("aiapps_use_extension_debug_key", false) : invokeV.booleanValue;
    }

    public static boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65586, null)) == null) ? d("aiapps_use_game_extension_debug_key", false) : invokeV.booleanValue;
    }

    public static boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65587, null)) == null) ? d("aiapps_websafe_debug_key", true) : invokeV.booleanValue;
    }
}
