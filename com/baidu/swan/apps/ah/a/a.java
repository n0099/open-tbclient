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
    private static com.baidu.swan.apps.storage.c.a bIN;
    private static final boolean DEBUG = b.DEBUG;
    private static final Set<String> bIO = new HashSet();

    static {
        bIO.add("aiapps_websafe_debug_key");
        bIO.add("aiapps_server_domains_debug_key");
        bIO.add("aiapps_use_extension_debug_key");
        bIO.add("aiapps_emit_live_debug_key");
        bIO.add("aiapps_emit_https_debug_key");
        bIO.add("aiapps_emit_wss_debug_key");
        bIO.add("aiapps_load_cts_debug_key");
        bIO.add("aiapps_env_data");
        bIO.add("aiapps_js_native_switch_key");
        bIO.add("aiapps_emit_game_core_debug_key");
        bIO.add("aiapps_emit_game_launch_mode_key");
    }

    public static com.baidu.swan.apps.storage.c.a aaj() {
        if (bIN == null) {
            synchronized (a.class) {
                if (bIN == null) {
                    bIN = new com.baidu.swan.apps.storage.c.a("swan_app_debug");
                    bIN.bVI.addAll(bIO);
                }
            }
        }
        return bIN;
    }

    public static boolean aak() {
        return aaj().getBoolean("swan_debug_force_ab", false);
    }

    public static boolean Zq() {
        return aaj().getBoolean("swan_debug_forbid_sample", true);
    }

    public static boolean aal() {
        return getBoolean("aiapps_websafe_debug_key", true);
    }

    public static boolean aam() {
        return getBoolean("aiapps_server_domains_debug_key", true);
    }

    public static void dh(boolean z) {
        setBoolean("aiapps_websafe_debug_key", z);
    }

    public static void di(boolean z) {
        setBoolean("aiapps_server_domains_debug_key", z);
    }

    public static boolean aan() {
        return getBoolean("aiapps_close_view_disable_debug_key", false);
    }

    public static boolean aao() {
        return getBoolean("aiapps_dashboard_enable_debug_key", false);
    }

    public static boolean aap() {
        return getBoolean("swan_game_fps_debug_key", false);
    }

    public static boolean aaq() {
        return getBoolean("aiapps_sconsole_scan_mode_debug_key", false);
    }

    public static boolean aar() {
        return getBoolean("aiapps_use_extension_debug_key", false);
    }

    public static void dj(boolean z) {
        setBoolean("aiapps_use_extension_debug_key", z);
    }

    public static boolean aas() {
        return getBoolean("aiapps_use_game_extension_debug_key", false);
    }

    public static boolean aat() {
        return getBoolean("aiapps_emit_live_debug_key", false);
    }

    public static void dk(boolean z) {
        setBoolean("aiapps_emit_live_debug_key", z);
    }

    public static boolean aau() {
        return getBoolean("aiapps_emit_https_debug_key", false);
    }

    public static void dl(boolean z) {
        setBoolean("aiapps_emit_https_debug_key", z);
    }

    public static boolean aav() {
        return com.baidu.swan.apps.swancore.b.afs();
    }

    public static void dm(boolean z) {
        com.baidu.swan.apps.swancore.b.dW(z);
    }

    public static boolean aaw() {
        return getBoolean("aiapps_emit_game_core_debug_key", false);
    }

    public static void dn(boolean z) {
        setBoolean("aiapps_emit_game_core_debug_key", z);
    }

    public static boolean aax() {
        return getBoolean("aiapps_emit_game_launch_mode_key", false);
    }

    /* renamed from: do  reason: not valid java name */
    public static void m25do(boolean z) {
        setBoolean("aiapps_emit_game_launch_mode_key", z);
    }

    public static boolean aay() {
        return getBoolean("aiapps_emit_wss_debug_key", false);
    }

    public static void dp(boolean z) {
        setBoolean("aiapps_emit_wss_debug_key", z);
    }

    public static void dq(boolean z) {
        setBoolean("aiapps_load_cts_debug_key", z);
    }

    public static boolean aaz() {
        return getBoolean("aiapps_load_cts_debug_key", false);
    }

    public static void kn(String str) {
        aaj().putString("aiapps_env_data", str);
    }

    public static String aaA() {
        return aaj().getString("aiapps_env_data", "");
    }

    private static void setBoolean(String str, boolean z) {
        aaj().putBoolean(str, z);
    }

    private static boolean getBoolean(String str, boolean z) {
        return aaj().getBoolean(str, z);
    }

    private static boolean c(c cVar) {
        return (DEBUG && cVar.isDebug()) || ko(cVar.VW()) || com.baidu.swan.apps.console.debugger.b.Ly() || com.baidu.swan.apps.console.debugger.b.Lz() || (aax() && cVar.VF());
    }

    public static boolean k(com.baidu.swan.apps.x.b.b bVar) {
        return (DEBUG && bVar.isDebug()) || ko(bVar.VW()) || com.baidu.swan.apps.console.debugger.b.Ly() || com.baidu.swan.apps.console.debugger.b.Lz() || (aax() && bVar.VF());
    }

    public static boolean aaB() {
        return com.baidu.swan.apps.console.debugger.b.Ly() || com.baidu.swan.apps.console.debugger.b.Lz();
    }

    public static boolean ko(String str) {
        return !TextUtils.isEmpty(str) || e.LN();
    }

    public static boolean aaC() {
        return getBoolean("aiapps_force_authorized_key", false);
    }

    public static boolean aaD() {
        return getBoolean("aiapps_js_native_switch_key", true);
    }

    public static e.f a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.as.a.b bVar2) {
        if (DEBUG && bVar.isDebug()) {
            return e.a.a(bVar, bVar2);
        }
        if (ko(bVar.VW())) {
            return e.C0302e.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.Ly()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.Lz()) {
            return com.baidu.swan.apps.console.debugger.b.b.d(bVar);
        }
        return null;
    }

    public static Bundle d(c cVar) {
        if (c(cVar)) {
            b.a aaF = aaF();
            aaF.iy(cVar.getAppId());
            aaF.iB(cVar.VH());
            aaF.iD(cVar.getPage());
            aaF.cM(cVar.isDebug());
            aaF.iE(cVar.VO());
            aaF.E(cVar.VN());
            aaF.iC(cVar.VJ());
            aaF.iF(cVar.VP());
            aaF.b(cVar.QO());
            aaF.c(cVar.QP());
            aaF.iG(cVar.VS());
            aaF.iH(cVar.VW());
            aaF.it("0");
            aaF.fj(cVar.getAppFrameType());
            aaF.fi(cVar.getOrientation());
            if (ko(cVar.VW()) || aaB()) {
                aaF.iz(cVar.getAppId());
            }
            return aaF.toBundle();
        }
        return null;
    }

    public static String l(com.baidu.swan.apps.x.b.b bVar) {
        if (DEBUG && bVar.isDebug()) {
            return e.a.TN().getPath();
        }
        if (ko(bVar.VW())) {
            return e.C0302e.LA().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.Ly()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.LA().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.Lz()) {
            return com.baidu.swan.apps.console.debugger.b.b.LA().getPath();
        }
        return "";
    }

    public static void ND() {
        com.baidu.swan.apps.core.d.b Ol;
        com.baidu.swan.apps.core.d.e GA = f.WQ().GA();
        if (GA != null && (Ol = GA.Ol()) != null) {
            Ol.ND();
        }
    }

    public static boolean aaE() {
        return aaz() || aat() || aau() || aar() || !aal() || aav() || aaw() || aay() || aax();
    }

    public static b.a aaF() {
        return ((b.a) ((b.a) ((b.a) new b.a().g(new PMSAppInfo())).iA("小程序测试").iy("10985873").ak(Color.parseColor("#FF308EF0"))).iB("1230000000000000")).iw("小程序简介").iv("测试服务类目").iu("测试主体信息").iz("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N").it("1.0").ix("https://b.bdstatic.com/searchbox/mappconsole/image/20180502/1525250801121271.png");
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
