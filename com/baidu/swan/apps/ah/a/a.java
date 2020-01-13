package com.baidu.swan.apps.ah.a;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.console.debugger.a.e;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.apps.x.b.b;
import com.baidu.swan.apps.x.b.c;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes10.dex */
public final class a {
    private static com.baidu.swan.apps.storage.c.a bEI;
    private static final boolean DEBUG = b.DEBUG;
    private static final Set<String> bEJ = new HashSet();

    static {
        bEJ.add("aiapps_websafe_debug_key");
        bEJ.add("aiapps_server_domains_debug_key");
        bEJ.add("aiapps_use_extension_debug_key");
        bEJ.add("aiapps_emit_live_debug_key");
        bEJ.add("aiapps_emit_https_debug_key");
        bEJ.add("aiapps_emit_wss_debug_key");
        bEJ.add("aiapps_load_cts_debug_key");
        bEJ.add("aiapps_env_data");
        bEJ.add("aiapps_js_native_switch_key");
        bEJ.add("aiapps_emit_game_core_debug_key");
        bEJ.add("aiapps_emit_game_launch_mode_key");
    }

    public static com.baidu.swan.apps.storage.c.a XV() {
        if (bEI == null) {
            synchronized (a.class) {
                if (bEI == null) {
                    bEI = new com.baidu.swan.apps.storage.c.a("swan_app_debug");
                    bEI.bRD.addAll(bEJ);
                }
            }
        }
        return bEI;
    }

    public static boolean XW() {
        return XV().getBoolean("swan_debug_force_ab", false);
    }

    public static boolean Xc() {
        return XV().getBoolean("swan_debug_forbid_sample", true);
    }

    public static boolean XX() {
        return getBoolean("aiapps_websafe_debug_key", true);
    }

    public static boolean XY() {
        return getBoolean("aiapps_server_domains_debug_key", true);
    }

    public static void da(boolean z) {
        setBoolean("aiapps_websafe_debug_key", z);
    }

    public static void db(boolean z) {
        setBoolean("aiapps_server_domains_debug_key", z);
    }

    public static boolean XZ() {
        return getBoolean("aiapps_close_view_disable_debug_key", false);
    }

    public static boolean Ya() {
        return getBoolean("aiapps_dashboard_enable_debug_key", false);
    }

    public static boolean Yb() {
        return getBoolean("swan_game_fps_debug_key", false);
    }

    public static boolean Yc() {
        return getBoolean("aiapps_sconsole_scan_mode_debug_key", false);
    }

    public static boolean Yd() {
        return getBoolean("aiapps_use_extension_debug_key", false);
    }

    public static void dc(boolean z) {
        setBoolean("aiapps_use_extension_debug_key", z);
    }

    public static boolean Ye() {
        return getBoolean("aiapps_use_game_extension_debug_key", false);
    }

    public static boolean Yf() {
        return getBoolean("aiapps_emit_live_debug_key", false);
    }

    public static void dd(boolean z) {
        setBoolean("aiapps_emit_live_debug_key", z);
    }

    public static boolean Yg() {
        return getBoolean("aiapps_emit_https_debug_key", false);
    }

    public static void de(boolean z) {
        setBoolean("aiapps_emit_https_debug_key", z);
    }

    public static boolean Yh() {
        return com.baidu.swan.apps.swancore.b.ade();
    }

    public static void df(boolean z) {
        com.baidu.swan.apps.swancore.b.dP(z);
    }

    public static boolean Yi() {
        return getBoolean("aiapps_emit_game_core_debug_key", false);
    }

    public static void dg(boolean z) {
        setBoolean("aiapps_emit_game_core_debug_key", z);
    }

    public static boolean Yj() {
        return getBoolean("aiapps_emit_game_launch_mode_key", false);
    }

    public static void dh(boolean z) {
        setBoolean("aiapps_emit_game_launch_mode_key", z);
    }

    public static boolean Yk() {
        return getBoolean("aiapps_emit_wss_debug_key", false);
    }

    public static void di(boolean z) {
        setBoolean("aiapps_emit_wss_debug_key", z);
    }

    public static void dj(boolean z) {
        setBoolean("aiapps_load_cts_debug_key", z);
    }

    public static boolean Yl() {
        return getBoolean("aiapps_load_cts_debug_key", false);
    }

    public static void jY(String str) {
        XV().putString("aiapps_env_data", str);
    }

    public static String Ym() {
        return XV().getString("aiapps_env_data", "");
    }

    private static void setBoolean(String str, boolean z) {
        XV().putBoolean(str, z);
    }

    private static boolean getBoolean(String str, boolean z) {
        return XV().getBoolean(str, z);
    }

    private static boolean c(c cVar) {
        return (DEBUG && cVar.isDebug()) || jZ(cVar.TI()) || com.baidu.swan.apps.console.debugger.b.Jj() || com.baidu.swan.apps.console.debugger.b.Jk() || (Yj() && cVar.Tr());
    }

    public static boolean k(com.baidu.swan.apps.x.b.b bVar) {
        return (DEBUG && bVar.isDebug()) || jZ(bVar.TI()) || com.baidu.swan.apps.console.debugger.b.Jj() || com.baidu.swan.apps.console.debugger.b.Jk() || (Yj() && bVar.Tr());
    }

    public static boolean Yn() {
        return com.baidu.swan.apps.console.debugger.b.Jj() || com.baidu.swan.apps.console.debugger.b.Jk();
    }

    public static boolean jZ(String str) {
        return !TextUtils.isEmpty(str) || e.Jy();
    }

    public static boolean Yo() {
        return getBoolean("aiapps_force_authorized_key", false);
    }

    public static boolean Yp() {
        return getBoolean("aiapps_js_native_switch_key", true);
    }

    public static e.f a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.as.a.b bVar2) {
        if (DEBUG && bVar.isDebug()) {
            return e.a.a(bVar, bVar2);
        }
        if (jZ(bVar.TI())) {
            return e.C0292e.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.Jj()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.Jk()) {
            return com.baidu.swan.apps.console.debugger.b.b.d(bVar);
        }
        return null;
    }

    public static Bundle d(c cVar) {
        if (c(cVar)) {
            b.a Yr = Yr();
            Yr.ij(cVar.getAppId());
            Yr.im(cVar.Tt());
            Yr.io(cVar.getPage());
            Yr.cF(cVar.isDebug());
            Yr.ip(cVar.TA());
            Yr.E(cVar.Tz());
            Yr.in(cVar.Tv());
            Yr.iq(cVar.TB());
            Yr.b(cVar.OA());
            Yr.c(cVar.OB());
            Yr.ir(cVar.TE());
            Yr.is(cVar.TI());
            Yr.ie("0");
            Yr.eT(cVar.getAppFrameType());
            Yr.eS(cVar.getOrientation());
            if (jZ(cVar.TI()) || Yn()) {
                Yr.ik(cVar.getAppId());
            }
            return Yr.toBundle();
        }
        return null;
    }

    public static String l(com.baidu.swan.apps.x.b.b bVar) {
        if (DEBUG && bVar.isDebug()) {
            return e.a.Rz().getPath();
        }
        if (jZ(bVar.TI())) {
            return e.C0292e.Jl().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.Jj()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.Jl().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.Jk()) {
            return com.baidu.swan.apps.console.debugger.b.b.Jl().getPath();
        }
        return "";
    }

    public static void Lp() {
        com.baidu.swan.apps.core.d.b LX;
        com.baidu.swan.apps.core.d.e El = f.UC().El();
        if (El != null && (LX = El.LX()) != null) {
            LX.Lp();
        }
    }

    public static boolean Yq() {
        return Yl() || Yf() || Yg() || Yd() || !XX() || Yh() || Yi() || Yk() || Yj();
    }

    public static b.a Yr() {
        return ((b.a) ((b.a) ((b.a) new b.a().g(new PMSAppInfo())).il("小程序测试").ij("10985873").ag(Color.parseColor("#FF308EF0"))).im("1230000000000000")).ih("小程序简介").ig("测试服务类目").mo23if("测试主体信息").ik("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N").ie("1.0").ii("https://b.bdstatic.com/searchbox/mappconsole/image/20180502/1525250801121271.png");
    }

    public static ExtensionCore d(ExtensionCore extensionCore) {
        if (extensionCore == null) {
            return null;
        }
        extensionCore.extensionCoreVersionCode = 4294967297L;
        extensionCore.extensionCoreVersionName = com.coloros.mcssdk.a.f;
        return extensionCore;
    }
}
