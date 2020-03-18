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
/* loaded from: classes11.dex */
public final class a {
    private static com.baidu.swan.apps.storage.c.a bJa;
    private static final boolean DEBUG = b.DEBUG;
    private static final Set<String> bJb = new HashSet();

    static {
        bJb.add("aiapps_websafe_debug_key");
        bJb.add("aiapps_server_domains_debug_key");
        bJb.add("aiapps_use_extension_debug_key");
        bJb.add("aiapps_emit_live_debug_key");
        bJb.add("aiapps_emit_https_debug_key");
        bJb.add("aiapps_emit_wss_debug_key");
        bJb.add("aiapps_load_cts_debug_key");
        bJb.add("aiapps_env_data");
        bJb.add("aiapps_js_native_switch_key");
        bJb.add("aiapps_emit_game_core_debug_key");
        bJb.add("aiapps_emit_game_launch_mode_key");
    }

    public static com.baidu.swan.apps.storage.c.a aao() {
        if (bJa == null) {
            synchronized (a.class) {
                if (bJa == null) {
                    bJa = new com.baidu.swan.apps.storage.c.a("swan_app_debug");
                    bJa.bVV.addAll(bJb);
                }
            }
        }
        return bJa;
    }

    public static boolean aap() {
        return aao().getBoolean("swan_debug_force_ab", false);
    }

    public static boolean Zv() {
        return aao().getBoolean("swan_debug_forbid_sample", true);
    }

    public static boolean aaq() {
        return getBoolean("aiapps_websafe_debug_key", true);
    }

    public static boolean aar() {
        return getBoolean("aiapps_server_domains_debug_key", true);
    }

    public static void di(boolean z) {
        setBoolean("aiapps_websafe_debug_key", z);
    }

    public static void dj(boolean z) {
        setBoolean("aiapps_server_domains_debug_key", z);
    }

    public static boolean aas() {
        return getBoolean("aiapps_close_view_disable_debug_key", false);
    }

    public static boolean aat() {
        return getBoolean("aiapps_dashboard_enable_debug_key", false);
    }

    public static boolean aau() {
        return getBoolean("swan_game_fps_debug_key", false);
    }

    public static boolean aav() {
        return getBoolean("aiapps_sconsole_scan_mode_debug_key", false);
    }

    public static boolean aaw() {
        return getBoolean("aiapps_use_extension_debug_key", false);
    }

    public static void dk(boolean z) {
        setBoolean("aiapps_use_extension_debug_key", z);
    }

    public static boolean aax() {
        return getBoolean("aiapps_use_game_extension_debug_key", false);
    }

    public static boolean aay() {
        return getBoolean("aiapps_emit_live_debug_key", false);
    }

    public static void dl(boolean z) {
        setBoolean("aiapps_emit_live_debug_key", z);
    }

    public static boolean aaz() {
        return getBoolean("aiapps_emit_https_debug_key", false);
    }

    public static void dm(boolean z) {
        setBoolean("aiapps_emit_https_debug_key", z);
    }

    public static boolean aaA() {
        return com.baidu.swan.apps.swancore.b.afx();
    }

    public static void dn(boolean z) {
        com.baidu.swan.apps.swancore.b.dX(z);
    }

    public static boolean aaB() {
        return getBoolean("aiapps_emit_game_core_debug_key", false);
    }

    /* renamed from: do  reason: not valid java name */
    public static void m25do(boolean z) {
        setBoolean("aiapps_emit_game_core_debug_key", z);
    }

    public static boolean aaC() {
        return getBoolean("aiapps_emit_game_launch_mode_key", false);
    }

    public static void dp(boolean z) {
        setBoolean("aiapps_emit_game_launch_mode_key", z);
    }

    public static boolean aaD() {
        return getBoolean("aiapps_emit_wss_debug_key", false);
    }

    public static void dq(boolean z) {
        setBoolean("aiapps_emit_wss_debug_key", z);
    }

    public static void dr(boolean z) {
        setBoolean("aiapps_load_cts_debug_key", z);
    }

    public static boolean aaE() {
        return getBoolean("aiapps_load_cts_debug_key", false);
    }

    public static void km(String str) {
        aao().putString("aiapps_env_data", str);
    }

    public static String aaF() {
        return aao().getString("aiapps_env_data", "");
    }

    private static void setBoolean(String str, boolean z) {
        aao().putBoolean(str, z);
    }

    private static boolean getBoolean(String str, boolean z) {
        return aao().getBoolean(str, z);
    }

    private static boolean c(c cVar) {
        return (DEBUG && cVar.isDebug()) || kn(cVar.Wb()) || com.baidu.swan.apps.console.debugger.b.LD() || com.baidu.swan.apps.console.debugger.b.LE() || (aaC() && cVar.VK());
    }

    public static boolean k(com.baidu.swan.apps.x.b.b bVar) {
        return (DEBUG && bVar.isDebug()) || kn(bVar.Wb()) || com.baidu.swan.apps.console.debugger.b.LD() || com.baidu.swan.apps.console.debugger.b.LE() || (aaC() && bVar.VK());
    }

    public static boolean aaG() {
        return com.baidu.swan.apps.console.debugger.b.LD() || com.baidu.swan.apps.console.debugger.b.LE();
    }

    public static boolean kn(String str) {
        return !TextUtils.isEmpty(str) || e.LS();
    }

    public static boolean aaH() {
        return getBoolean("aiapps_force_authorized_key", false);
    }

    public static boolean aaI() {
        return getBoolean("aiapps_js_native_switch_key", true);
    }

    public static e.f a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.as.a.b bVar2) {
        if (DEBUG && bVar.isDebug()) {
            return e.a.a(bVar, bVar2);
        }
        if (kn(bVar.Wb())) {
            return e.C0302e.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.LD()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.LE()) {
            return com.baidu.swan.apps.console.debugger.b.b.d(bVar);
        }
        return null;
    }

    public static Bundle d(c cVar) {
        if (c(cVar)) {
            b.a aaK = aaK();
            aaK.ix(cVar.getAppId());
            aaK.iA(cVar.VM());
            aaK.iC(cVar.getPage());
            aaK.cN(cVar.isDebug());
            aaK.iD(cVar.VT());
            aaK.E(cVar.VS());
            aaK.iB(cVar.VO());
            aaK.iE(cVar.VU());
            aaK.b(cVar.QT());
            aaK.c(cVar.QU());
            aaK.iF(cVar.VX());
            aaK.iG(cVar.Wb());
            aaK.is("0");
            aaK.fj(cVar.getAppFrameType());
            aaK.fi(cVar.getOrientation());
            if (kn(cVar.Wb()) || aaG()) {
                aaK.iy(cVar.getAppId());
            }
            return aaK.toBundle();
        }
        return null;
    }

    public static String l(com.baidu.swan.apps.x.b.b bVar) {
        if (DEBUG && bVar.isDebug()) {
            return e.a.TS().getPath();
        }
        if (kn(bVar.Wb())) {
            return e.C0302e.LF().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.LD()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.LF().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.LE()) {
            return com.baidu.swan.apps.console.debugger.b.b.LF().getPath();
        }
        return "";
    }

    public static void NI() {
        com.baidu.swan.apps.core.d.b Oq;
        com.baidu.swan.apps.core.d.e GH = f.WV().GH();
        if (GH != null && (Oq = GH.Oq()) != null) {
            Oq.NI();
        }
    }

    public static boolean aaJ() {
        return aaE() || aay() || aaz() || aaw() || !aaq() || aaA() || aaB() || aaD() || aaC();
    }

    public static b.a aaK() {
        return ((b.a) ((b.a) ((b.a) new b.a().g(new PMSAppInfo())).iz("小程序测试").ix("10985873").ak(Color.parseColor("#FF308EF0"))).iA("1230000000000000")).iv("小程序简介").iu("测试服务类目").it("测试主体信息").iy("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N").is("1.0").iw("https://b.bdstatic.com/searchbox/mappconsole/image/20180502/1525250801121271.png");
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
