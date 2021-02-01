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
/* loaded from: classes9.dex */
public final class a {
    private static com.baidu.swan.apps.storage.c.a dsS;
    private static final boolean DEBUG = b.DEBUG;
    private static final Set<String> dsT = new HashSet();

    static {
        dsT.add("aiapps_websafe_debug_key");
        dsT.add("aiapps_server_domains_debug_key");
        dsT.add("aiapps_use_extension_debug_key");
        dsT.add("aiapps_emit_live_debug_key");
        dsT.add("aiapps_emit_https_debug_key");
        dsT.add("aiapps_emit_wss_debug_key");
        dsT.add("aiapps_load_cts_debug_key");
        dsT.add("aiapps_env_data");
        dsT.add("aiapps_js_native_switch_key");
        dsT.add("aiapps_emit_game_core_debug_key");
        dsT.add("aiapps_emit_game_launch_mode_key");
    }

    public static com.baidu.swan.apps.storage.c.a aEU() {
        if (dsS == null) {
            synchronized (a.class) {
                if (dsS == null) {
                    dsS = new com.baidu.swan.apps.storage.c.a("swan_app_debug");
                    dsS.dLY.addAll(dsT);
                }
            }
        }
        return dsS;
    }

    public static boolean aEV() {
        return aEU().getBoolean("swan_debug_force_ab", false);
    }

    public static boolean aDz() {
        return aEU().getBoolean("swan_debug_forbid_sample", true);
    }

    public static boolean aEW() {
        return getBoolean("aiapps_websafe_debug_key", true);
    }

    public static boolean aEX() {
        return getBoolean("aiapps_server_domains_debug_key", true);
    }

    public static void gs(boolean z) {
        setBoolean("aiapps_websafe_debug_key", z);
    }

    public static void gt(boolean z) {
        setBoolean("aiapps_server_domains_debug_key", z);
    }

    public static boolean aEY() {
        return getBoolean("aiapps_close_view_disable_debug_key", false);
    }

    public static boolean aEZ() {
        return getBoolean("aiapps_dashboard_enable_debug_key", false);
    }

    public static boolean aFa() {
        return getBoolean("swan_game_fps_debug_key", false);
    }

    public static boolean aFb() {
        return getBoolean("aiapps_sconsole_scan_mode_debug_key", false);
    }

    public static boolean aFc() {
        return getBoolean("aiapps_use_extension_debug_key", false);
    }

    public static void gu(boolean z) {
        setBoolean("aiapps_use_extension_debug_key", z);
    }

    public static boolean aFd() {
        return getBoolean("aiapps_use_game_extension_debug_key", false);
    }

    public static boolean aFe() {
        return getBoolean("aiapps_emit_live_debug_key", false);
    }

    public static void gv(boolean z) {
        setBoolean("aiapps_emit_live_debug_key", z);
    }

    public static boolean aFf() {
        return getBoolean("aiapps_emit_https_debug_key", false);
    }

    public static void gw(boolean z) {
        setBoolean("aiapps_emit_https_debug_key", z);
    }

    public static boolean aFg() {
        return com.baidu.swan.apps.swancore.b.aMk();
    }

    public static void gx(boolean z) {
        com.baidu.swan.apps.swancore.b.ht(z);
    }

    public static boolean aFh() {
        return getBoolean("aiapps_emit_game_core_debug_key", false);
    }

    public static void gy(boolean z) {
        setBoolean("aiapps_emit_game_core_debug_key", z);
    }

    public static boolean aFi() {
        return getBoolean("aiapps_emit_game_launch_mode_key", false);
    }

    public static void gz(boolean z) {
        setBoolean("aiapps_emit_game_launch_mode_key", z);
    }

    public static boolean aFj() {
        return getBoolean("aiapps_emit_wss_debug_key", false);
    }

    public static void gA(boolean z) {
        setBoolean("aiapps_emit_wss_debug_key", z);
    }

    public static void gB(boolean z) {
        setBoolean("aiapps_load_cts_debug_key", z);
    }

    public static boolean aFk() {
        return getBoolean("aiapps_load_cts_debug_key", false);
    }

    public static void qR(String str) {
        aEU().putString("aiapps_env_data", str);
    }

    public static String aFl() {
        return aEU().getString("aiapps_env_data", "");
    }

    public static void setBoolean(String str, boolean z) {
        aEU().putBoolean(str, z);
    }

    public static boolean getBoolean(String str, boolean z) {
        return aEU().getBoolean(str, z);
    }

    private static boolean c(c cVar) {
        return (DEBUG && cVar.isDebug()) || qS(cVar.azp()) || com.baidu.swan.apps.console.debugger.b.alV() || com.baidu.swan.apps.console.debugger.b.alW() || (aFi() && cVar.ayY());
    }

    public static boolean j(com.baidu.swan.apps.u.c.b bVar) {
        return (DEBUG && bVar.isDebug()) || qS(bVar.azp()) || com.baidu.swan.apps.console.debugger.b.alV() || com.baidu.swan.apps.console.debugger.b.alW() || (aFi() && bVar.ayY());
    }

    public static boolean aFm() {
        return com.baidu.swan.apps.console.debugger.b.alV() || com.baidu.swan.apps.console.debugger.b.alW();
    }

    public static boolean qS(String str) {
        return !TextUtils.isEmpty(str) || e.amk();
    }

    public static boolean aFn() {
        return getBoolean("aiapps_force_authorized_key", false);
    }

    public static boolean aFo() {
        return getBoolean("aiapps_js_native_switch_key", true);
    }

    public static void gC(boolean z) {
        setBoolean("aiapps_js_native_switch_key", z);
    }

    public static d.f a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ao.a.b bVar2) {
        if (DEBUG && bVar.isDebug()) {
            return d.a.a(bVar, bVar2);
        }
        if (qS(bVar.azp())) {
            return d.e.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.alV()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.alW()) {
            return com.baidu.swan.apps.console.debugger.b.b.d(bVar);
        }
        return null;
    }

    public static Bundle d(c cVar) {
        if (c(cVar)) {
            b.a aFq = aFq();
            aFq.oR(cVar.getAppId());
            aFq.oU(cVar.aza());
            aFq.oW(cVar.getPage());
            aFq.fU(cVar.isDebug());
            aFq.oX(cVar.azh());
            aFq.G(cVar.azg());
            aFq.oV(cVar.azc());
            aFq.oY(cVar.azi());
            aFq.b(cVar.asA());
            aFq.c(cVar.asB());
            aFq.oZ(cVar.azl());
            aFq.pa(cVar.azp());
            aFq.oM("0");
            aFq.hQ(cVar.getAppFrameType());
            aFq.hP(cVar.getOrientation());
            if (qS(cVar.azp()) || aFm()) {
                aFq.oS(cVar.getAppId());
            }
            return aFq.toBundle();
        }
        return null;
    }

    public static String k(com.baidu.swan.apps.u.c.b bVar) {
        if (DEBUG && bVar.isDebug()) {
            return d.a.awP().getPath();
        }
        if (qS(bVar.azp())) {
            return d.e.alX().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.alV()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.alX().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.alW()) {
            return com.baidu.swan.apps.console.debugger.b.b.alX().getPath();
        }
        return "";
    }

    public static void aoB() {
        com.baidu.swan.apps.core.d.c apx;
        f afX = com.baidu.swan.apps.v.f.aAl().afX();
        if (afX != null && (apx = afX.apx()) != null) {
            apx.aoB();
        }
    }

    public static boolean aFp() {
        return aFk() || aFe() || aFf() || aFc() || !aEW() || aFg() || aFh() || aFj() || aFi();
    }

    public static b.a aFq() {
        return ((b.a) ((b.a) ((b.a) new b.a().k(new PMSAppInfo())).oT("小程序测试").oR("10985873").cr(Color.parseColor("#FF308EF0"))).oU("1230000000000000")).oP("小程序简介").oO("测试服务类目").oN("测试主体信息").oS("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N").oM("1.0").oQ("https://b.bdstatic.com/searchbox/mappconsole/image/20180502/1525250801121271.png");
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
