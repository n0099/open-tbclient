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
/* loaded from: classes9.dex */
public final class a {
    private static com.baidu.swan.apps.storage.c.a bDX;
    private static final boolean DEBUG = b.DEBUG;
    private static final Set<String> bDY = new HashSet();

    static {
        bDY.add("aiapps_websafe_debug_key");
        bDY.add("aiapps_server_domains_debug_key");
        bDY.add("aiapps_use_extension_debug_key");
        bDY.add("aiapps_emit_live_debug_key");
        bDY.add("aiapps_emit_https_debug_key");
        bDY.add("aiapps_emit_wss_debug_key");
        bDY.add("aiapps_load_cts_debug_key");
        bDY.add("aiapps_env_data");
        bDY.add("aiapps_js_native_switch_key");
        bDY.add("aiapps_emit_game_core_debug_key");
        bDY.add("aiapps_emit_game_launch_mode_key");
    }

    public static com.baidu.swan.apps.storage.c.a Xy() {
        if (bDX == null) {
            synchronized (a.class) {
                if (bDX == null) {
                    bDX = new com.baidu.swan.apps.storage.c.a("swan_app_debug");
                    bDX.bQT.addAll(bDY);
                }
            }
        }
        return bDX;
    }

    public static boolean Xz() {
        return Xy().getBoolean("swan_debug_force_ab", false);
    }

    public static boolean WF() {
        return Xy().getBoolean("swan_debug_forbid_sample", true);
    }

    public static boolean XA() {
        return getBoolean("aiapps_websafe_debug_key", true);
    }

    public static boolean XB() {
        return getBoolean("aiapps_server_domains_debug_key", true);
    }

    public static void cV(boolean z) {
        setBoolean("aiapps_websafe_debug_key", z);
    }

    public static void cW(boolean z) {
        setBoolean("aiapps_server_domains_debug_key", z);
    }

    public static boolean XC() {
        return getBoolean("aiapps_close_view_disable_debug_key", false);
    }

    public static boolean XD() {
        return getBoolean("aiapps_dashboard_enable_debug_key", false);
    }

    public static boolean XE() {
        return getBoolean("swan_game_fps_debug_key", false);
    }

    public static boolean XF() {
        return getBoolean("aiapps_sconsole_scan_mode_debug_key", false);
    }

    public static boolean XG() {
        return getBoolean("aiapps_use_extension_debug_key", false);
    }

    public static void cX(boolean z) {
        setBoolean("aiapps_use_extension_debug_key", z);
    }

    public static boolean XH() {
        return getBoolean("aiapps_use_game_extension_debug_key", false);
    }

    public static boolean XI() {
        return getBoolean("aiapps_emit_live_debug_key", false);
    }

    public static void cY(boolean z) {
        setBoolean("aiapps_emit_live_debug_key", z);
    }

    public static boolean XJ() {
        return getBoolean("aiapps_emit_https_debug_key", false);
    }

    public static void cZ(boolean z) {
        setBoolean("aiapps_emit_https_debug_key", z);
    }

    public static boolean XK() {
        return com.baidu.swan.apps.swancore.b.acH();
    }

    public static void da(boolean z) {
        com.baidu.swan.apps.swancore.b.dK(z);
    }

    public static boolean XL() {
        return getBoolean("aiapps_emit_game_core_debug_key", false);
    }

    public static void db(boolean z) {
        setBoolean("aiapps_emit_game_core_debug_key", z);
    }

    public static boolean XM() {
        return getBoolean("aiapps_emit_game_launch_mode_key", false);
    }

    public static void dc(boolean z) {
        setBoolean("aiapps_emit_game_launch_mode_key", z);
    }

    public static boolean XN() {
        return getBoolean("aiapps_emit_wss_debug_key", false);
    }

    public static void dd(boolean z) {
        setBoolean("aiapps_emit_wss_debug_key", z);
    }

    public static void de(boolean z) {
        setBoolean("aiapps_load_cts_debug_key", z);
    }

    public static boolean XO() {
        return getBoolean("aiapps_load_cts_debug_key", false);
    }

    public static void jV(String str) {
        Xy().putString("aiapps_env_data", str);
    }

    public static String XP() {
        return Xy().getString("aiapps_env_data", "");
    }

    private static void setBoolean(String str, boolean z) {
        Xy().putBoolean(str, z);
    }

    private static boolean getBoolean(String str, boolean z) {
        return Xy().getBoolean(str, z);
    }

    private static boolean c(c cVar) {
        return (DEBUG && cVar.isDebug()) || jW(cVar.Tl()) || com.baidu.swan.apps.console.debugger.b.IN() || com.baidu.swan.apps.console.debugger.b.IO() || (XM() && cVar.SU());
    }

    public static boolean k(com.baidu.swan.apps.x.b.b bVar) {
        return (DEBUG && bVar.isDebug()) || jW(bVar.Tl()) || com.baidu.swan.apps.console.debugger.b.IN() || com.baidu.swan.apps.console.debugger.b.IO() || (XM() && bVar.SU());
    }

    public static boolean XQ() {
        return com.baidu.swan.apps.console.debugger.b.IN() || com.baidu.swan.apps.console.debugger.b.IO();
    }

    public static boolean jW(String str) {
        return !TextUtils.isEmpty(str) || e.Jc();
    }

    public static boolean XR() {
        return getBoolean("aiapps_force_authorized_key", false);
    }

    public static boolean XS() {
        return getBoolean("aiapps_js_native_switch_key", true);
    }

    public static e.f a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.as.a.b bVar2) {
        if (DEBUG && bVar.isDebug()) {
            return e.a.a(bVar, bVar2);
        }
        if (jW(bVar.Tl())) {
            return e.C0290e.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.IN()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.IO()) {
            return com.baidu.swan.apps.console.debugger.b.b.d(bVar);
        }
        return null;
    }

    public static Bundle d(c cVar) {
        if (c(cVar)) {
            b.a XU = XU();
            XU.ig(cVar.getAppId());
            XU.ij(cVar.SW());
            XU.il(cVar.getPage());
            XU.cA(cVar.isDebug());
            XU.im(cVar.Td());
            XU.E(cVar.Tc());
            XU.ik(cVar.SY());
            XU.in(cVar.Te());
            XU.b(cVar.Oe());
            XU.c(cVar.Of());
            XU.io(cVar.Th());
            XU.ip(cVar.Tl());
            XU.ia("0");
            XU.eS(cVar.getAppFrameType());
            XU.eR(cVar.getOrientation());
            if (jW(cVar.Tl()) || XQ()) {
                XU.ih(cVar.getAppId());
            }
            return XU.toBundle();
        }
        return null;
    }

    public static String l(com.baidu.swan.apps.x.b.b bVar) {
        if (DEBUG && bVar.isDebug()) {
            return e.a.Rd().getPath();
        }
        if (jW(bVar.Tl())) {
            return e.C0290e.IP().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.IN()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.IP().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.IO()) {
            return com.baidu.swan.apps.console.debugger.b.b.IP().getPath();
        }
        return "";
    }

    public static void KT() {
        com.baidu.swan.apps.core.d.b LB;
        com.baidu.swan.apps.core.d.e DP = f.Uf().DP();
        if (DP != null && (LB = DP.LB()) != null) {
            LB.KT();
        }
    }

    public static boolean XT() {
        return XO() || XI() || XJ() || XG() || !XA() || XK() || XL() || XN() || XM();
    }

    public static b.a XU() {
        return ((b.a) ((b.a) ((b.a) new b.a().g(new PMSAppInfo())).ii("小程序测试").ig("10985873").ad(Color.parseColor("#FF308EF0"))).ij("1230000000000000")).ie("小程序简介").ic("测试服务类目").ib("测试主体信息").ih("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N").ia("1.0").mo20if("https://b.bdstatic.com/searchbox/mappconsole/image/20180502/1525250801121271.png");
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
