package com.baidu.swan.apps.ae.a;

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
/* loaded from: classes7.dex */
public final class a {
    private static com.baidu.swan.apps.storage.c.a cAs;
    private static final boolean DEBUG = b.DEBUG;
    private static final Set<String> cAt = new HashSet();

    static {
        cAt.add("aiapps_websafe_debug_key");
        cAt.add("aiapps_server_domains_debug_key");
        cAt.add("aiapps_use_extension_debug_key");
        cAt.add("aiapps_emit_live_debug_key");
        cAt.add("aiapps_emit_https_debug_key");
        cAt.add("aiapps_emit_wss_debug_key");
        cAt.add("aiapps_load_cts_debug_key");
        cAt.add("aiapps_env_data");
        cAt.add("aiapps_js_native_switch_key");
        cAt.add("aiapps_emit_game_core_debug_key");
        cAt.add("aiapps_emit_game_launch_mode_key");
    }

    public static com.baidu.swan.apps.storage.c.a aoO() {
        if (cAs == null) {
            synchronized (a.class) {
                if (cAs == null) {
                    cAs = new com.baidu.swan.apps.storage.c.a("swan_app_debug");
                    cAs.cOZ.addAll(cAt);
                }
            }
        }
        return cAs;
    }

    public static boolean aoP() {
        return aoO().getBoolean("swan_debug_force_ab", false);
    }

    public static boolean ans() {
        return aoO().getBoolean("swan_debug_forbid_sample", true);
    }

    public static boolean aoQ() {
        return getBoolean("aiapps_websafe_debug_key", true);
    }

    public static boolean aoR() {
        return getBoolean("aiapps_server_domains_debug_key", true);
    }

    public static void eJ(boolean z) {
        setBoolean("aiapps_websafe_debug_key", z);
    }

    public static void eK(boolean z) {
        setBoolean("aiapps_server_domains_debug_key", z);
    }

    public static boolean aoS() {
        return getBoolean("aiapps_close_view_disable_debug_key", false);
    }

    public static boolean aoT() {
        return getBoolean("aiapps_dashboard_enable_debug_key", false);
    }

    public static boolean aoU() {
        return getBoolean("swan_game_fps_debug_key", false);
    }

    public static boolean aoV() {
        return getBoolean("aiapps_sconsole_scan_mode_debug_key", false);
    }

    public static boolean aoW() {
        return getBoolean("aiapps_use_extension_debug_key", false);
    }

    public static void eL(boolean z) {
        setBoolean("aiapps_use_extension_debug_key", z);
    }

    public static boolean aoX() {
        return getBoolean("aiapps_use_game_extension_debug_key", false);
    }

    public static boolean aoY() {
        return getBoolean("aiapps_emit_live_debug_key", false);
    }

    public static void eM(boolean z) {
        setBoolean("aiapps_emit_live_debug_key", z);
    }

    public static boolean aoZ() {
        return getBoolean("aiapps_emit_https_debug_key", false);
    }

    public static void eN(boolean z) {
        setBoolean("aiapps_emit_https_debug_key", z);
    }

    public static boolean apa() {
        return com.baidu.swan.apps.swancore.b.auZ();
    }

    public static void eO(boolean z) {
        com.baidu.swan.apps.swancore.b.fB(z);
    }

    public static boolean apb() {
        return getBoolean("aiapps_emit_game_core_debug_key", false);
    }

    public static void eP(boolean z) {
        setBoolean("aiapps_emit_game_core_debug_key", z);
    }

    public static boolean apc() {
        return getBoolean("aiapps_emit_game_launch_mode_key", false);
    }

    public static void eQ(boolean z) {
        setBoolean("aiapps_emit_game_launch_mode_key", z);
    }

    public static boolean apd() {
        return getBoolean("aiapps_emit_wss_debug_key", false);
    }

    public static void eR(boolean z) {
        setBoolean("aiapps_emit_wss_debug_key", z);
    }

    public static void eS(boolean z) {
        setBoolean("aiapps_load_cts_debug_key", z);
    }

    public static boolean ape() {
        return getBoolean("aiapps_load_cts_debug_key", false);
    }

    public static void nF(String str) {
        aoO().putString("aiapps_env_data", str);
    }

    public static String apf() {
        return aoO().getString("aiapps_env_data", "");
    }

    public static void setBoolean(String str, boolean z) {
        aoO().putBoolean(str, z);
    }

    public static boolean getBoolean(String str, boolean z) {
        return aoO().getBoolean(str, z);
    }

    private static boolean c(c cVar) {
        return (DEBUG && cVar.isDebug()) || nG(cVar.ajv()) || com.baidu.swan.apps.console.debugger.b.XJ() || com.baidu.swan.apps.console.debugger.b.XK() || (apc() && cVar.aje());
    }

    public static boolean j(com.baidu.swan.apps.u.c.b bVar) {
        return (DEBUG && bVar.isDebug()) || nG(bVar.ajv()) || com.baidu.swan.apps.console.debugger.b.XJ() || com.baidu.swan.apps.console.debugger.b.XK() || (apc() && bVar.aje());
    }

    public static boolean apg() {
        return com.baidu.swan.apps.console.debugger.b.XJ() || com.baidu.swan.apps.console.debugger.b.XK();
    }

    public static boolean nG(String str) {
        return !TextUtils.isEmpty(str) || e.XY();
    }

    public static boolean aph() {
        return getBoolean("aiapps_force_authorized_key", false);
    }

    public static boolean apj() {
        return getBoolean("aiapps_js_native_switch_key", true);
    }

    public static void eT(boolean z) {
        setBoolean("aiapps_js_native_switch_key", z);
    }

    public static d.f a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.aq.a.b bVar2) {
        if (DEBUG && bVar.isDebug()) {
            return d.a.a(bVar, bVar2);
        }
        if (nG(bVar.ajv())) {
            return d.e.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.XJ()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.XK()) {
            return com.baidu.swan.apps.console.debugger.b.b.d(bVar);
        }
        return null;
    }

    public static Bundle d(c cVar) {
        if (c(cVar)) {
            b.a apl = apl();
            apl.lE(cVar.getAppId());
            apl.lH(cVar.ajg());
            apl.lJ(cVar.getPage());
            apl.em(cVar.isDebug());
            apl.lK(cVar.ajn());
            apl.I(cVar.ajm());
            apl.lI(cVar.aji());
            apl.lL(cVar.ajo());
            apl.b(cVar.adQ());
            apl.c(cVar.adR());
            apl.lM(cVar.ajr());
            apl.lN(cVar.ajv());
            apl.lz("0");
            apl.fY(cVar.getAppFrameType());
            apl.fX(cVar.getOrientation());
            if (nG(cVar.ajv()) || apg()) {
                apl.lF(cVar.getAppId());
            }
            return apl.toBundle();
        }
        return null;
    }

    public static String k(com.baidu.swan.apps.u.c.b bVar) {
        if (DEBUG && bVar.isDebug()) {
            return d.a.ahc().getPath();
        }
        if (nG(bVar.ajv())) {
            return d.e.XL().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.XJ()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.XL().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.XK()) {
            return com.baidu.swan.apps.console.debugger.b.b.XL().getPath();
        }
        return "";
    }

    public static void aam() {
        com.baidu.swan.apps.core.d.c aaZ;
        f Sc = com.baidu.swan.apps.v.f.akr().Sc();
        if (Sc != null && (aaZ = Sc.aaZ()) != null) {
            aaZ.aam();
        }
    }

    public static boolean apk() {
        return ape() || aoY() || aoZ() || aoW() || !aoQ() || apa() || apb() || apd() || apc();
    }

    public static b.a apl() {
        return ((b.a) ((b.a) ((b.a) new b.a().k(new PMSAppInfo())).lG("小程序测试").lE("10985873").aZ(Color.parseColor("#FF308EF0"))).lH("1230000000000000")).lC("小程序简介").lB("测试服务类目").lA("测试主体信息").lF("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N").lz("1.0").lD("https://b.bdstatic.com/searchbox/mappconsole/image/20180502/1525250801121271.png");
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
