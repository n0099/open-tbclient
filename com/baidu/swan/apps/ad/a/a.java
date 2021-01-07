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
    private static com.baidu.swan.apps.storage.c.a dvv;
    private static final boolean DEBUG = b.DEBUG;
    private static final Set<String> dvw = new HashSet();

    static {
        dvw.add("aiapps_websafe_debug_key");
        dvw.add("aiapps_server_domains_debug_key");
        dvw.add("aiapps_use_extension_debug_key");
        dvw.add("aiapps_emit_live_debug_key");
        dvw.add("aiapps_emit_https_debug_key");
        dvw.add("aiapps_emit_wss_debug_key");
        dvw.add("aiapps_load_cts_debug_key");
        dvw.add("aiapps_env_data");
        dvw.add("aiapps_js_native_switch_key");
        dvw.add("aiapps_emit_game_core_debug_key");
        dvw.add("aiapps_emit_game_launch_mode_key");
    }

    public static com.baidu.swan.apps.storage.c.a aIt() {
        if (dvv == null) {
            synchronized (a.class) {
                if (dvv == null) {
                    dvv = new com.baidu.swan.apps.storage.c.a("swan_app_debug");
                    dvv.dOG.addAll(dvw);
                }
            }
        }
        return dvv;
    }

    public static boolean aIu() {
        return aIt().getBoolean("swan_debug_force_ab", false);
    }

    public static boolean aGX() {
        return aIt().getBoolean("swan_debug_forbid_sample", true);
    }

    public static boolean aIv() {
        return getBoolean("aiapps_websafe_debug_key", true);
    }

    public static boolean aIw() {
        return getBoolean("aiapps_server_domains_debug_key", true);
    }

    public static void gu(boolean z) {
        setBoolean("aiapps_websafe_debug_key", z);
    }

    public static void gv(boolean z) {
        setBoolean("aiapps_server_domains_debug_key", z);
    }

    public static boolean aIx() {
        return getBoolean("aiapps_close_view_disable_debug_key", false);
    }

    public static boolean aIy() {
        return getBoolean("aiapps_dashboard_enable_debug_key", false);
    }

    public static boolean aIz() {
        return getBoolean("swan_game_fps_debug_key", false);
    }

    public static boolean aIA() {
        return getBoolean("aiapps_sconsole_scan_mode_debug_key", false);
    }

    public static boolean aIB() {
        return getBoolean("aiapps_use_extension_debug_key", false);
    }

    public static void gw(boolean z) {
        setBoolean("aiapps_use_extension_debug_key", z);
    }

    public static boolean aIC() {
        return getBoolean("aiapps_use_game_extension_debug_key", false);
    }

    public static boolean aID() {
        return getBoolean("aiapps_emit_live_debug_key", false);
    }

    public static void gx(boolean z) {
        setBoolean("aiapps_emit_live_debug_key", z);
    }

    public static boolean aIE() {
        return getBoolean("aiapps_emit_https_debug_key", false);
    }

    public static void gy(boolean z) {
        setBoolean("aiapps_emit_https_debug_key", z);
    }

    public static boolean aIF() {
        return com.baidu.swan.apps.swancore.b.aPL();
    }

    public static void gz(boolean z) {
        com.baidu.swan.apps.swancore.b.hv(z);
    }

    public static boolean aIG() {
        return getBoolean("aiapps_emit_game_core_debug_key", false);
    }

    public static void gA(boolean z) {
        setBoolean("aiapps_emit_game_core_debug_key", z);
    }

    public static boolean aIH() {
        return getBoolean("aiapps_emit_game_launch_mode_key", false);
    }

    public static void gB(boolean z) {
        setBoolean("aiapps_emit_game_launch_mode_key", z);
    }

    public static boolean aII() {
        return getBoolean("aiapps_emit_wss_debug_key", false);
    }

    public static void gC(boolean z) {
        setBoolean("aiapps_emit_wss_debug_key", z);
    }

    public static void gD(boolean z) {
        setBoolean("aiapps_load_cts_debug_key", z);
    }

    public static boolean aIJ() {
        return getBoolean("aiapps_load_cts_debug_key", false);
    }

    public static void rK(String str) {
        aIt().putString("aiapps_env_data", str);
    }

    public static String aIK() {
        return aIt().getString("aiapps_env_data", "");
    }

    public static void setBoolean(String str, boolean z) {
        aIt().putBoolean(str, z);
    }

    public static boolean getBoolean(String str, boolean z) {
        return aIt().getBoolean(str, z);
    }

    private static boolean c(c cVar) {
        return (DEBUG && cVar.isDebug()) || rL(cVar.aCL()) || com.baidu.swan.apps.console.debugger.b.aps() || com.baidu.swan.apps.console.debugger.b.apt() || (aIH() && cVar.aCu());
    }

    public static boolean j(com.baidu.swan.apps.u.c.b bVar) {
        return (DEBUG && bVar.isDebug()) || rL(bVar.aCL()) || com.baidu.swan.apps.console.debugger.b.aps() || com.baidu.swan.apps.console.debugger.b.apt() || (aIH() && bVar.aCu());
    }

    public static boolean aIL() {
        return com.baidu.swan.apps.console.debugger.b.aps() || com.baidu.swan.apps.console.debugger.b.apt();
    }

    public static boolean rL(String str) {
        return !TextUtils.isEmpty(str) || e.apH();
    }

    public static boolean aIM() {
        return getBoolean("aiapps_force_authorized_key", false);
    }

    public static boolean aIN() {
        return getBoolean("aiapps_js_native_switch_key", true);
    }

    public static void gE(boolean z) {
        setBoolean("aiapps_js_native_switch_key", z);
    }

    public static d.f a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ao.a.b bVar2) {
        if (DEBUG && bVar.isDebug()) {
            return d.a.a(bVar, bVar2);
        }
        if (rL(bVar.aCL())) {
            return d.e.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.aps()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.apt()) {
            return com.baidu.swan.apps.console.debugger.b.b.d(bVar);
        }
        return null;
    }

    public static Bundle d(c cVar) {
        if (c(cVar)) {
            b.a aIP = aIP();
            aIP.pK(cVar.getAppId());
            aIP.pN(cVar.aCw());
            aIP.pP(cVar.getPage());
            aIP.fW(cVar.isDebug());
            aIP.pQ(cVar.aCD());
            aIP.G(cVar.aCC());
            aIP.pO(cVar.aCy());
            aIP.pR(cVar.aCE());
            aIP.b(cVar.avW());
            aIP.c(cVar.avX());
            aIP.pS(cVar.aCH());
            aIP.pT(cVar.aCL());
            aIP.pF("0");
            aIP.jt(cVar.getAppFrameType());
            aIP.js(cVar.getOrientation());
            if (rL(cVar.aCL()) || aIL()) {
                aIP.pL(cVar.getAppId());
            }
            return aIP.toBundle();
        }
        return null;
    }

    public static String k(com.baidu.swan.apps.u.c.b bVar) {
        if (DEBUG && bVar.isDebug()) {
            return d.a.aAl().getPath();
        }
        if (rL(bVar.aCL())) {
            return d.e.apu().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.aps()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.apu().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.apt()) {
            return com.baidu.swan.apps.console.debugger.b.b.apu().getPath();
        }
        return "";
    }

    public static void arY() {
        com.baidu.swan.apps.core.d.c asU;
        f ajt = com.baidu.swan.apps.v.f.aDH().ajt();
        if (ajt != null && (asU = ajt.asU()) != null) {
            asU.arY();
        }
    }

    public static boolean aIO() {
        return aIJ() || aID() || aIE() || aIB() || !aIv() || aIF() || aIG() || aII() || aIH();
    }

    public static b.a aIP() {
        return ((b.a) ((b.a) ((b.a) new b.a().k(new PMSAppInfo())).pM("小程序测试").pK("10985873").cl(Color.parseColor("#FF308EF0"))).pN("1230000000000000")).pI("小程序简介").pH("测试服务类目").pG("测试主体信息").pL("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N").pF("1.0").pJ("https://b.bdstatic.com/searchbox/mappconsole/image/20180502/1525250801121271.png");
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
