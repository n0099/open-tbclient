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
    private static com.baidu.swan.apps.storage.c.a chP;
    private static final boolean DEBUG = b.DEBUG;
    private static final Set<String> chQ = new HashSet();

    static {
        chQ.add("aiapps_websafe_debug_key");
        chQ.add("aiapps_server_domains_debug_key");
        chQ.add("aiapps_use_extension_debug_key");
        chQ.add("aiapps_emit_live_debug_key");
        chQ.add("aiapps_emit_https_debug_key");
        chQ.add("aiapps_emit_wss_debug_key");
        chQ.add("aiapps_load_cts_debug_key");
        chQ.add("aiapps_env_data");
        chQ.add("aiapps_js_native_switch_key");
        chQ.add("aiapps_emit_game_core_debug_key");
        chQ.add("aiapps_emit_game_launch_mode_key");
    }

    public static com.baidu.swan.apps.storage.c.a ais() {
        if (chP == null) {
            synchronized (a.class) {
                if (chP == null) {
                    chP = new com.baidu.swan.apps.storage.c.a("swan_app_debug");
                    chP.cuT.addAll(chQ);
                }
            }
        }
        return chP;
    }

    public static boolean ait() {
        return ais().getBoolean("swan_debug_force_ab", false);
    }

    public static boolean ahz() {
        return ais().getBoolean("swan_debug_forbid_sample", true);
    }

    public static boolean aiu() {
        return getBoolean("aiapps_websafe_debug_key", true);
    }

    public static boolean aiv() {
        return getBoolean("aiapps_server_domains_debug_key", true);
    }

    public static void ee(boolean z) {
        setBoolean("aiapps_websafe_debug_key", z);
    }

    public static void ef(boolean z) {
        setBoolean("aiapps_server_domains_debug_key", z);
    }

    public static boolean aiw() {
        return getBoolean("aiapps_close_view_disable_debug_key", false);
    }

    public static boolean aix() {
        return getBoolean("aiapps_dashboard_enable_debug_key", false);
    }

    public static boolean aiy() {
        return getBoolean("swan_game_fps_debug_key", false);
    }

    public static boolean aiz() {
        return getBoolean("aiapps_sconsole_scan_mode_debug_key", false);
    }

    public static boolean aiA() {
        return getBoolean("aiapps_use_extension_debug_key", false);
    }

    public static void eg(boolean z) {
        setBoolean("aiapps_use_extension_debug_key", z);
    }

    public static boolean aiB() {
        return getBoolean("aiapps_use_game_extension_debug_key", false);
    }

    public static boolean aiC() {
        return getBoolean("aiapps_emit_live_debug_key", false);
    }

    public static void eh(boolean z) {
        setBoolean("aiapps_emit_live_debug_key", z);
    }

    public static boolean aiD() {
        return getBoolean("aiapps_emit_https_debug_key", false);
    }

    public static void ei(boolean z) {
        setBoolean("aiapps_emit_https_debug_key", z);
    }

    public static boolean aiE() {
        return com.baidu.swan.apps.swancore.b.anB();
    }

    public static void ej(boolean z) {
        com.baidu.swan.apps.swancore.b.eT(z);
    }

    public static boolean aiF() {
        return getBoolean("aiapps_emit_game_core_debug_key", false);
    }

    public static void ek(boolean z) {
        setBoolean("aiapps_emit_game_core_debug_key", z);
    }

    public static boolean aiG() {
        return getBoolean("aiapps_emit_game_launch_mode_key", false);
    }

    public static void el(boolean z) {
        setBoolean("aiapps_emit_game_launch_mode_key", z);
    }

    public static boolean aiH() {
        return getBoolean("aiapps_emit_wss_debug_key", false);
    }

    public static void em(boolean z) {
        setBoolean("aiapps_emit_wss_debug_key", z);
    }

    public static void en(boolean z) {
        setBoolean("aiapps_load_cts_debug_key", z);
    }

    public static boolean aiI() {
        return getBoolean("aiapps_load_cts_debug_key", false);
    }

    public static void lz(String str) {
        ais().putString("aiapps_env_data", str);
    }

    public static String aiJ() {
        return ais().getString("aiapps_env_data", "");
    }

    private static void setBoolean(String str, boolean z) {
        ais().putBoolean(str, z);
    }

    private static boolean getBoolean(String str, boolean z) {
        return ais().getBoolean(str, z);
    }

    private static boolean c(c cVar) {
        return (DEBUG && cVar.isDebug()) || lA(cVar.adP()) || com.baidu.swan.apps.console.debugger.b.Tq() || com.baidu.swan.apps.console.debugger.b.Tr() || (aiG() && cVar.ady());
    }

    public static boolean k(com.baidu.swan.apps.x.b.b bVar) {
        return (DEBUG && bVar.isDebug()) || lA(bVar.adP()) || com.baidu.swan.apps.console.debugger.b.Tq() || com.baidu.swan.apps.console.debugger.b.Tr() || (aiG() && bVar.ady());
    }

    public static boolean aiK() {
        return com.baidu.swan.apps.console.debugger.b.Tq() || com.baidu.swan.apps.console.debugger.b.Tr();
    }

    public static boolean lA(String str) {
        return !TextUtils.isEmpty(str) || e.TF();
    }

    public static boolean aiL() {
        return getBoolean("aiapps_force_authorized_key", false);
    }

    public static boolean aiM() {
        return getBoolean("aiapps_js_native_switch_key", true);
    }

    public static e.f a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.as.a.b bVar2) {
        if (DEBUG && bVar.isDebug()) {
            return e.a.a(bVar, bVar2);
        }
        if (lA(bVar.adP())) {
            return e.C0353e.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.Tq()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.Tr()) {
            return com.baidu.swan.apps.console.debugger.b.b.d(bVar);
        }
        return null;
    }

    public static Bundle d(c cVar) {
        if (c(cVar)) {
            b.a aiO = aiO();
            aiO.jK(cVar.getAppId());
            aiO.jN(cVar.adA());
            aiO.jP(cVar.getPage());
            aiO.dJ(cVar.isDebug());
            aiO.jQ(cVar.adH());
            aiO.E(cVar.adG());
            aiO.jO(cVar.adC());
            aiO.jR(cVar.adI());
            aiO.b(cVar.YH());
            aiO.c(cVar.YI());
            aiO.jS(cVar.adL());
            aiO.jT(cVar.adP());
            aiO.jF("0");
            aiO.fo(cVar.getAppFrameType());
            aiO.fn(cVar.getOrientation());
            if (lA(cVar.adP()) || aiK()) {
                aiO.jL(cVar.getAppId());
            }
            return aiO.toBundle();
        }
        return null;
    }

    public static String l(com.baidu.swan.apps.x.b.b bVar) {
        if (DEBUG && bVar.isDebug()) {
            return e.a.abG().getPath();
        }
        if (lA(bVar.adP())) {
            return e.C0353e.Ts().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.Tq()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.Ts().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.Tr()) {
            return com.baidu.swan.apps.console.debugger.b.b.Ts().getPath();
        }
        return "";
    }

    public static void Vu() {
        com.baidu.swan.apps.core.d.b Wd;
        com.baidu.swan.apps.core.d.e Ot = f.aeJ().Ot();
        if (Ot != null && (Wd = Ot.Wd()) != null) {
            Wd.Vu();
        }
    }

    public static boolean aiN() {
        return aiI() || aiC() || aiD() || aiA() || !aiu() || aiE() || aiF() || aiH() || aiG();
    }

    public static b.a aiO() {
        return ((b.a) ((b.a) ((b.a) new b.a().g(new PMSAppInfo())).jM("小程序测试").jK("10985873").aO(Color.parseColor("#FF308EF0"))).jN("1230000000000000")).jI("小程序简介").jH("测试服务类目").jG("测试主体信息").jL("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N").jF("1.0").jJ("https://b.bdstatic.com/searchbox/mappconsole/image/20180502/1525250801121271.png");
    }

    public static ExtensionCore d(ExtensionCore extensionCore) {
        if (extensionCore == null) {
            return null;
        }
        extensionCore.extensionCoreVersionCode = 4294967297L;
        extensionCore.extensionCoreVersionName = "1.0.1";
        return extensionCore;
    }
}
