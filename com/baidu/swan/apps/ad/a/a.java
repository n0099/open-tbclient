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
/* loaded from: classes8.dex */
public final class a {
    private static com.baidu.swan.apps.storage.c.a cIF;
    private static final boolean DEBUG = b.DEBUG;
    private static final Set<String> cIG = new HashSet();

    static {
        cIG.add("aiapps_websafe_debug_key");
        cIG.add("aiapps_server_domains_debug_key");
        cIG.add("aiapps_use_extension_debug_key");
        cIG.add("aiapps_emit_live_debug_key");
        cIG.add("aiapps_emit_https_debug_key");
        cIG.add("aiapps_emit_wss_debug_key");
        cIG.add("aiapps_load_cts_debug_key");
        cIG.add("aiapps_env_data");
        cIG.add("aiapps_js_native_switch_key");
        cIG.add("aiapps_emit_game_core_debug_key");
        cIG.add("aiapps_emit_game_launch_mode_key");
    }

    public static com.baidu.swan.apps.storage.c.a awL() {
        if (cIF == null) {
            synchronized (a.class) {
                if (cIF == null) {
                    cIF = new com.baidu.swan.apps.storage.c.a("swan_app_debug");
                    cIF.cYg.addAll(cIG);
                }
            }
        }
        return cIF;
    }

    public static boolean awM() {
        return awL().getBoolean("swan_debug_force_ab", false);
    }

    public static boolean avn() {
        return awL().getBoolean("swan_debug_forbid_sample", true);
    }

    public static boolean awN() {
        return getBoolean("aiapps_websafe_debug_key", true);
    }

    public static boolean awO() {
        return getBoolean("aiapps_server_domains_debug_key", true);
    }

    public static void fd(boolean z) {
        setBoolean("aiapps_websafe_debug_key", z);
    }

    public static void fe(boolean z) {
        setBoolean("aiapps_server_domains_debug_key", z);
    }

    public static boolean awP() {
        return getBoolean("aiapps_close_view_disable_debug_key", false);
    }

    public static boolean awQ() {
        return getBoolean("aiapps_dashboard_enable_debug_key", false);
    }

    public static boolean awR() {
        return getBoolean("swan_game_fps_debug_key", false);
    }

    public static boolean awS() {
        return getBoolean("aiapps_sconsole_scan_mode_debug_key", false);
    }

    public static boolean awT() {
        return getBoolean("aiapps_use_extension_debug_key", false);
    }

    public static void ff(boolean z) {
        setBoolean("aiapps_use_extension_debug_key", z);
    }

    public static boolean awU() {
        return getBoolean("aiapps_use_game_extension_debug_key", false);
    }

    public static boolean awV() {
        return getBoolean("aiapps_emit_live_debug_key", false);
    }

    public static void fg(boolean z) {
        setBoolean("aiapps_emit_live_debug_key", z);
    }

    public static boolean awW() {
        return getBoolean("aiapps_emit_https_debug_key", false);
    }

    public static void fh(boolean z) {
        setBoolean("aiapps_emit_https_debug_key", z);
    }

    public static boolean awX() {
        return com.baidu.swan.apps.swancore.b.aDi();
    }

    public static void fi(boolean z) {
        com.baidu.swan.apps.swancore.b.fV(z);
    }

    public static boolean awY() {
        return getBoolean("aiapps_emit_game_core_debug_key", false);
    }

    public static void fj(boolean z) {
        setBoolean("aiapps_emit_game_core_debug_key", z);
    }

    public static boolean awZ() {
        return getBoolean("aiapps_emit_game_launch_mode_key", false);
    }

    public static void fk(boolean z) {
        setBoolean("aiapps_emit_game_launch_mode_key", z);
    }

    public static boolean axa() {
        return getBoolean("aiapps_emit_wss_debug_key", false);
    }

    public static void fl(boolean z) {
        setBoolean("aiapps_emit_wss_debug_key", z);
    }

    public static void fm(boolean z) {
        setBoolean("aiapps_load_cts_debug_key", z);
    }

    public static boolean axb() {
        return getBoolean("aiapps_load_cts_debug_key", false);
    }

    public static void pE(String str) {
        awL().putString("aiapps_env_data", str);
    }

    public static String axc() {
        return awL().getString("aiapps_env_data", "");
    }

    public static void setBoolean(String str, boolean z) {
        awL().putBoolean(str, z);
    }

    public static boolean getBoolean(String str, boolean z) {
        return awL().getBoolean(str, z);
    }

    private static boolean c(c cVar) {
        return (DEBUG && cVar.isDebug()) || pF(cVar.arc()) || com.baidu.swan.apps.console.debugger.b.adP() || com.baidu.swan.apps.console.debugger.b.adQ() || (awZ() && cVar.aqL());
    }

    public static boolean j(com.baidu.swan.apps.u.c.b bVar) {
        return (DEBUG && bVar.isDebug()) || pF(bVar.arc()) || com.baidu.swan.apps.console.debugger.b.adP() || com.baidu.swan.apps.console.debugger.b.adQ() || (awZ() && bVar.aqL());
    }

    public static boolean axd() {
        return com.baidu.swan.apps.console.debugger.b.adP() || com.baidu.swan.apps.console.debugger.b.adQ();
    }

    public static boolean pF(String str) {
        return !TextUtils.isEmpty(str) || e.aee();
    }

    public static boolean axe() {
        return getBoolean("aiapps_force_authorized_key", false);
    }

    public static boolean axf() {
        return getBoolean("aiapps_js_native_switch_key", true);
    }

    public static void fn(boolean z) {
        setBoolean("aiapps_js_native_switch_key", z);
    }

    public static d.f a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ap.a.b bVar2) {
        if (DEBUG && bVar.isDebug()) {
            return d.a.a(bVar, bVar2);
        }
        if (pF(bVar.arc())) {
            return d.e.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.adP()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.adQ()) {
            return com.baidu.swan.apps.console.debugger.b.b.d(bVar);
        }
        return null;
    }

    public static Bundle d(c cVar) {
        if (c(cVar)) {
            b.a axh = axh();
            axh.nC(cVar.getAppId());
            axh.nF(cVar.aqN());
            axh.nH(cVar.getPage());
            axh.eF(cVar.isDebug());
            axh.nI(cVar.aqU());
            axh.G(cVar.aqT());
            axh.nG(cVar.aqP());
            axh.nJ(cVar.aqV());
            axh.b(cVar.akn());
            axh.c(cVar.ako());
            axh.nK(cVar.aqY());
            axh.nL(cVar.arc());
            axh.nx("0");
            axh.ic(cVar.getAppFrameType());
            axh.ib(cVar.getOrientation());
            if (pF(cVar.arc()) || axd()) {
                axh.nD(cVar.getAppId());
            }
            return axh.toBundle();
        }
        return null;
    }

    public static String k(com.baidu.swan.apps.u.c.b bVar) {
        if (DEBUG && bVar.isDebug()) {
            return d.a.aoC().getPath();
        }
        if (pF(bVar.arc())) {
            return d.e.adR().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.adP()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.adR().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.adQ()) {
            return com.baidu.swan.apps.console.debugger.b.b.adR().getPath();
        }
        return "";
    }

    public static void agw() {
        com.baidu.swan.apps.core.d.c ahm;
        f XX = com.baidu.swan.apps.v.f.arY().XX();
        if (XX != null && (ahm = XX.ahm()) != null) {
            ahm.agw();
        }
    }

    public static boolean axg() {
        return axb() || awV() || awW() || awT() || !awN() || awX() || awY() || axa() || awZ();
    }

    public static b.a axh() {
        return ((b.a) ((b.a) ((b.a) new b.a().k(new PMSAppInfo())).nE("小程序测试").nC("10985873").be(Color.parseColor("#FF308EF0"))).nF("1230000000000000")).nA("小程序简介").nz("测试服务类目").ny("测试主体信息").nD("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N").nx("1.0").nB("https://b.bdstatic.com/searchbox/mappconsole/image/20180502/1525250801121271.png");
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
