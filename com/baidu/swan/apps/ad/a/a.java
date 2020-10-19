package com.baidu.swan.apps.ad.a;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.console.debugger.a.e;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.apps.u.c.c;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes10.dex */
public final class a {
    private static com.baidu.swan.apps.storage.c.a cWI;
    private static final boolean DEBUG = b.DEBUG;
    private static final Set<String> cWJ = new HashSet();

    static {
        cWJ.add("aiapps_websafe_debug_key");
        cWJ.add("aiapps_server_domains_debug_key");
        cWJ.add("aiapps_use_extension_debug_key");
        cWJ.add("aiapps_emit_live_debug_key");
        cWJ.add("aiapps_emit_https_debug_key");
        cWJ.add("aiapps_emit_wss_debug_key");
        cWJ.add("aiapps_load_cts_debug_key");
        cWJ.add("aiapps_env_data");
        cWJ.add("aiapps_js_native_switch_key");
        cWJ.add("aiapps_emit_game_core_debug_key");
        cWJ.add("aiapps_emit_game_launch_mode_key");
    }

    public static com.baidu.swan.apps.storage.c.a aAf() {
        if (cWI == null) {
            synchronized (a.class) {
                if (cWI == null) {
                    cWI = new com.baidu.swan.apps.storage.c.a("swan_app_debug");
                    cWI.dmq.addAll(cWJ);
                }
            }
        }
        return cWI;
    }

    public static boolean aAg() {
        return aAf().getBoolean("swan_debug_force_ab", false);
    }

    public static boolean ayH() {
        return aAf().getBoolean("swan_debug_forbid_sample", true);
    }

    public static boolean aAh() {
        return getBoolean("aiapps_websafe_debug_key", true);
    }

    public static boolean aAi() {
        return getBoolean("aiapps_server_domains_debug_key", true);
    }

    public static void fx(boolean z) {
        setBoolean("aiapps_websafe_debug_key", z);
    }

    public static void fy(boolean z) {
        setBoolean("aiapps_server_domains_debug_key", z);
    }

    public static boolean aAj() {
        return getBoolean("aiapps_close_view_disable_debug_key", false);
    }

    public static boolean aAk() {
        return getBoolean("aiapps_dashboard_enable_debug_key", false);
    }

    public static boolean aAl() {
        return getBoolean("swan_game_fps_debug_key", false);
    }

    public static boolean aAm() {
        return getBoolean("aiapps_sconsole_scan_mode_debug_key", false);
    }

    public static boolean aAn() {
        return getBoolean("aiapps_use_extension_debug_key", false);
    }

    public static void fz(boolean z) {
        setBoolean("aiapps_use_extension_debug_key", z);
    }

    public static boolean aAo() {
        return getBoolean("aiapps_use_game_extension_debug_key", false);
    }

    public static boolean aAp() {
        return getBoolean("aiapps_emit_live_debug_key", false);
    }

    public static void fA(boolean z) {
        setBoolean("aiapps_emit_live_debug_key", z);
    }

    public static boolean aAq() {
        return getBoolean("aiapps_emit_https_debug_key", false);
    }

    public static void fB(boolean z) {
        setBoolean("aiapps_emit_https_debug_key", z);
    }

    public static boolean aAr() {
        return com.baidu.swan.apps.swancore.b.aGB();
    }

    public static void fC(boolean z) {
        com.baidu.swan.apps.swancore.b.gp(z);
    }

    public static boolean aAs() {
        return getBoolean("aiapps_emit_game_core_debug_key", false);
    }

    public static void fD(boolean z) {
        setBoolean("aiapps_emit_game_core_debug_key", z);
    }

    public static boolean aAt() {
        return getBoolean("aiapps_emit_game_launch_mode_key", false);
    }

    public static void fE(boolean z) {
        setBoolean("aiapps_emit_game_launch_mode_key", z);
    }

    public static boolean aAu() {
        return getBoolean("aiapps_emit_wss_debug_key", false);
    }

    public static void fF(boolean z) {
        setBoolean("aiapps_emit_wss_debug_key", z);
    }

    public static void fG(boolean z) {
        setBoolean("aiapps_load_cts_debug_key", z);
    }

    public static boolean aAv() {
        return getBoolean("aiapps_load_cts_debug_key", false);
    }

    public static void qJ(String str) {
        aAf().putString("aiapps_env_data", str);
    }

    public static String aAw() {
        return aAf().getString("aiapps_env_data", "");
    }

    public static void setBoolean(String str, boolean z) {
        aAf().putBoolean(str, z);
    }

    public static boolean getBoolean(String str, boolean z) {
        return aAf().getBoolean(str, z);
    }

    private static boolean c(c cVar) {
        return (DEBUG && cVar.isDebug()) || qK(cVar.auy()) || com.baidu.swan.apps.console.debugger.b.ahk() || com.baidu.swan.apps.console.debugger.b.ahl() || (aAt() && cVar.auh());
    }

    public static boolean j(com.baidu.swan.apps.u.c.b bVar) {
        return (DEBUG && bVar.isDebug()) || qK(bVar.auy()) || com.baidu.swan.apps.console.debugger.b.ahk() || com.baidu.swan.apps.console.debugger.b.ahl() || (aAt() && bVar.auh());
    }

    public static boolean aAx() {
        return com.baidu.swan.apps.console.debugger.b.ahk() || com.baidu.swan.apps.console.debugger.b.ahl();
    }

    public static boolean qK(String str) {
        return !TextUtils.isEmpty(str) || e.ahz();
    }

    public static boolean aAy() {
        return getBoolean("aiapps_force_authorized_key", false);
    }

    public static boolean aAz() {
        return getBoolean("aiapps_js_native_switch_key", true);
    }

    public static void fH(boolean z) {
        setBoolean("aiapps_js_native_switch_key", z);
    }

    public static d.f a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ap.a.b bVar2) {
        if (DEBUG && bVar.isDebug()) {
            return d.a.a(bVar, bVar2);
        }
        if (qK(bVar.auy())) {
            return d.e.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.ahk()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.ahl()) {
            return com.baidu.swan.apps.console.debugger.b.b.d(bVar);
        }
        return null;
    }

    public static Bundle d(c cVar) {
        if (c(cVar)) {
            b.a aAB = aAB();
            aAB.oJ(cVar.getAppId());
            aAB.oM(cVar.auj());
            aAB.oO(cVar.getPage());
            aAB.eZ(cVar.isDebug());
            aAB.oP(cVar.auq());
            aAB.G(cVar.aup());
            aAB.oN(cVar.aul());
            aAB.oQ(cVar.aur());
            aAB.b(cVar.anI());
            aAB.c(cVar.anJ());
            aAB.oR(cVar.auu());
            aAB.oS(cVar.auy());
            aAB.oE("0");
            aAB.iJ(cVar.getAppFrameType());
            aAB.iI(cVar.getOrientation());
            if (qK(cVar.auy()) || aAx()) {
                aAB.oK(cVar.getAppId());
            }
            return aAB.toBundle();
        }
        return null;
    }

    public static String k(com.baidu.swan.apps.u.c.b bVar) {
        if (DEBUG && bVar.isDebug()) {
            return d.a.arY().getPath();
        }
        if (qK(bVar.auy())) {
            return d.e.ahm().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.ahk()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.ahm().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.ahl()) {
            return com.baidu.swan.apps.console.debugger.b.b.ahm().getPath();
        }
        return "";
    }

    public static void ajR() {
        com.baidu.swan.apps.core.d.c akH;
        f abs = com.baidu.swan.apps.v.f.avu().abs();
        if (abs != null && (akH = abs.akH()) != null) {
            akH.ajR();
        }
    }

    public static boolean aAA() {
        return aAv() || aAp() || aAq() || aAn() || !aAh() || aAr() || aAs() || aAu() || aAt();
    }

    public static b.a aAB() {
        return ((b.a) ((b.a) ((b.a) new b.a().k(new PMSAppInfo())).oL("小程序测试").oJ("10985873").bn(Color.parseColor("#FF308EF0"))).oM("1230000000000000")).oH("小程序简介").oG("测试服务类目").oF("测试主体信息").oK("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N").oE("1.0").oI("https://b.bdstatic.com/searchbox/mappconsole/image/20180502/1525250801121271.png");
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
