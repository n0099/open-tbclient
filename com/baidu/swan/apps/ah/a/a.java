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
    private static com.baidu.swan.apps.storage.c.a chJ;
    private static final boolean DEBUG = b.DEBUG;
    private static final Set<String> chK = new HashSet();

    static {
        chK.add("aiapps_websafe_debug_key");
        chK.add("aiapps_server_domains_debug_key");
        chK.add("aiapps_use_extension_debug_key");
        chK.add("aiapps_emit_live_debug_key");
        chK.add("aiapps_emit_https_debug_key");
        chK.add("aiapps_emit_wss_debug_key");
        chK.add("aiapps_load_cts_debug_key");
        chK.add("aiapps_env_data");
        chK.add("aiapps_js_native_switch_key");
        chK.add("aiapps_emit_game_core_debug_key");
        chK.add("aiapps_emit_game_launch_mode_key");
    }

    public static com.baidu.swan.apps.storage.c.a ait() {
        if (chJ == null) {
            synchronized (a.class) {
                if (chJ == null) {
                    chJ = new com.baidu.swan.apps.storage.c.a("swan_app_debug");
                    chJ.cuN.addAll(chK);
                }
            }
        }
        return chJ;
    }

    public static boolean aiu() {
        return ait().getBoolean("swan_debug_force_ab", false);
    }

    public static boolean ahA() {
        return ait().getBoolean("swan_debug_forbid_sample", true);
    }

    public static boolean aiv() {
        return getBoolean("aiapps_websafe_debug_key", true);
    }

    public static boolean aiw() {
        return getBoolean("aiapps_server_domains_debug_key", true);
    }

    public static void ee(boolean z) {
        setBoolean("aiapps_websafe_debug_key", z);
    }

    public static void ef(boolean z) {
        setBoolean("aiapps_server_domains_debug_key", z);
    }

    public static boolean aix() {
        return getBoolean("aiapps_close_view_disable_debug_key", false);
    }

    public static boolean aiy() {
        return getBoolean("aiapps_dashboard_enable_debug_key", false);
    }

    public static boolean aiz() {
        return getBoolean("swan_game_fps_debug_key", false);
    }

    public static boolean aiA() {
        return getBoolean("aiapps_sconsole_scan_mode_debug_key", false);
    }

    public static boolean aiB() {
        return getBoolean("aiapps_use_extension_debug_key", false);
    }

    public static void eg(boolean z) {
        setBoolean("aiapps_use_extension_debug_key", z);
    }

    public static boolean aiC() {
        return getBoolean("aiapps_use_game_extension_debug_key", false);
    }

    public static boolean aiD() {
        return getBoolean("aiapps_emit_live_debug_key", false);
    }

    public static void eh(boolean z) {
        setBoolean("aiapps_emit_live_debug_key", z);
    }

    public static boolean aiE() {
        return getBoolean("aiapps_emit_https_debug_key", false);
    }

    public static void ei(boolean z) {
        setBoolean("aiapps_emit_https_debug_key", z);
    }

    public static boolean aiF() {
        return com.baidu.swan.apps.swancore.b.anC();
    }

    public static void ej(boolean z) {
        com.baidu.swan.apps.swancore.b.eT(z);
    }

    public static boolean aiG() {
        return getBoolean("aiapps_emit_game_core_debug_key", false);
    }

    public static void ek(boolean z) {
        setBoolean("aiapps_emit_game_core_debug_key", z);
    }

    public static boolean aiH() {
        return getBoolean("aiapps_emit_game_launch_mode_key", false);
    }

    public static void el(boolean z) {
        setBoolean("aiapps_emit_game_launch_mode_key", z);
    }

    public static boolean aiI() {
        return getBoolean("aiapps_emit_wss_debug_key", false);
    }

    public static void em(boolean z) {
        setBoolean("aiapps_emit_wss_debug_key", z);
    }

    public static void en(boolean z) {
        setBoolean("aiapps_load_cts_debug_key", z);
    }

    public static boolean aiJ() {
        return getBoolean("aiapps_load_cts_debug_key", false);
    }

    public static void lz(String str) {
        ait().putString("aiapps_env_data", str);
    }

    public static String aiK() {
        return ait().getString("aiapps_env_data", "");
    }

    private static void setBoolean(String str, boolean z) {
        ait().putBoolean(str, z);
    }

    private static boolean getBoolean(String str, boolean z) {
        return ait().getBoolean(str, z);
    }

    private static boolean c(c cVar) {
        return (DEBUG && cVar.isDebug()) || lA(cVar.adQ()) || com.baidu.swan.apps.console.debugger.b.Tr() || com.baidu.swan.apps.console.debugger.b.Ts() || (aiH() && cVar.adz());
    }

    public static boolean k(com.baidu.swan.apps.x.b.b bVar) {
        return (DEBUG && bVar.isDebug()) || lA(bVar.adQ()) || com.baidu.swan.apps.console.debugger.b.Tr() || com.baidu.swan.apps.console.debugger.b.Ts() || (aiH() && bVar.adz());
    }

    public static boolean aiL() {
        return com.baidu.swan.apps.console.debugger.b.Tr() || com.baidu.swan.apps.console.debugger.b.Ts();
    }

    public static boolean lA(String str) {
        return !TextUtils.isEmpty(str) || e.TG();
    }

    public static boolean aiM() {
        return getBoolean("aiapps_force_authorized_key", false);
    }

    public static boolean aiN() {
        return getBoolean("aiapps_js_native_switch_key", true);
    }

    public static e.f a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.as.a.b bVar2) {
        if (DEBUG && bVar.isDebug()) {
            return e.a.a(bVar, bVar2);
        }
        if (lA(bVar.adQ())) {
            return e.C0332e.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.Tr()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.Ts()) {
            return com.baidu.swan.apps.console.debugger.b.b.d(bVar);
        }
        return null;
    }

    public static Bundle d(c cVar) {
        if (c(cVar)) {
            b.a aiP = aiP();
            aiP.jK(cVar.getAppId());
            aiP.jN(cVar.adB());
            aiP.jP(cVar.getPage());
            aiP.dJ(cVar.isDebug());
            aiP.jQ(cVar.adI());
            aiP.E(cVar.adH());
            aiP.jO(cVar.adD());
            aiP.jR(cVar.adJ());
            aiP.b(cVar.YI());
            aiP.c(cVar.YJ());
            aiP.jS(cVar.adM());
            aiP.jT(cVar.adQ());
            aiP.jF("0");
            aiP.fo(cVar.getAppFrameType());
            aiP.fn(cVar.getOrientation());
            if (lA(cVar.adQ()) || aiL()) {
                aiP.jL(cVar.getAppId());
            }
            return aiP.toBundle();
        }
        return null;
    }

    public static String l(com.baidu.swan.apps.x.b.b bVar) {
        if (DEBUG && bVar.isDebug()) {
            return e.a.abH().getPath();
        }
        if (lA(bVar.adQ())) {
            return e.C0332e.Tt().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.Tr()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.Tt().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.Ts()) {
            return com.baidu.swan.apps.console.debugger.b.b.Tt().getPath();
        }
        return "";
    }

    public static void Vv() {
        com.baidu.swan.apps.core.d.b We;
        com.baidu.swan.apps.core.d.e Ou = f.aeK().Ou();
        if (Ou != null && (We = Ou.We()) != null) {
            We.Vv();
        }
    }

    public static boolean aiO() {
        return aiJ() || aiD() || aiE() || aiB() || !aiv() || aiF() || aiG() || aiI() || aiH();
    }

    public static b.a aiP() {
        return ((b.a) ((b.a) ((b.a) new b.a().g(new PMSAppInfo())).jM("小程序测试").jK("10985873").aO(Color.parseColor("#FF308EF0"))).jN("1230000000000000")).jI("小程序简介").jH("测试服务类目").jG("测试主体信息").jL("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N").jF("1.0").jJ("https://b.bdstatic.com/searchbox/mappconsole/image/20180502/1525250801121271.png");
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
