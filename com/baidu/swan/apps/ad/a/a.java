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
/* loaded from: classes3.dex */
public final class a {
    private static com.baidu.swan.apps.storage.c.a cKF;
    private static final boolean DEBUG = b.DEBUG;
    private static final Set<String> cKG = new HashSet();

    static {
        cKG.add("aiapps_websafe_debug_key");
        cKG.add("aiapps_server_domains_debug_key");
        cKG.add("aiapps_use_extension_debug_key");
        cKG.add("aiapps_emit_live_debug_key");
        cKG.add("aiapps_emit_https_debug_key");
        cKG.add("aiapps_emit_wss_debug_key");
        cKG.add("aiapps_load_cts_debug_key");
        cKG.add("aiapps_env_data");
        cKG.add("aiapps_js_native_switch_key");
        cKG.add("aiapps_emit_game_core_debug_key");
        cKG.add("aiapps_emit_game_launch_mode_key");
    }

    public static com.baidu.swan.apps.storage.c.a axu() {
        if (cKF == null) {
            synchronized (a.class) {
                if (cKF == null) {
                    cKF = new com.baidu.swan.apps.storage.c.a("swan_app_debug");
                    cKF.dag.addAll(cKG);
                }
            }
        }
        return cKF;
    }

    public static boolean axv() {
        return axu().getBoolean("swan_debug_force_ab", false);
    }

    public static boolean avW() {
        return axu().getBoolean("swan_debug_forbid_sample", true);
    }

    public static boolean axw() {
        return getBoolean("aiapps_websafe_debug_key", true);
    }

    public static boolean axx() {
        return getBoolean("aiapps_server_domains_debug_key", true);
    }

    public static void fb(boolean z) {
        setBoolean("aiapps_websafe_debug_key", z);
    }

    public static void fc(boolean z) {
        setBoolean("aiapps_server_domains_debug_key", z);
    }

    public static boolean axy() {
        return getBoolean("aiapps_close_view_disable_debug_key", false);
    }

    public static boolean axz() {
        return getBoolean("aiapps_dashboard_enable_debug_key", false);
    }

    public static boolean axA() {
        return getBoolean("swan_game_fps_debug_key", false);
    }

    public static boolean axB() {
        return getBoolean("aiapps_sconsole_scan_mode_debug_key", false);
    }

    public static boolean axC() {
        return getBoolean("aiapps_use_extension_debug_key", false);
    }

    public static void fd(boolean z) {
        setBoolean("aiapps_use_extension_debug_key", z);
    }

    public static boolean axD() {
        return getBoolean("aiapps_use_game_extension_debug_key", false);
    }

    public static boolean axE() {
        return getBoolean("aiapps_emit_live_debug_key", false);
    }

    public static void fe(boolean z) {
        setBoolean("aiapps_emit_live_debug_key", z);
    }

    public static boolean axF() {
        return getBoolean("aiapps_emit_https_debug_key", false);
    }

    public static void ff(boolean z) {
        setBoolean("aiapps_emit_https_debug_key", z);
    }

    public static boolean axG() {
        return com.baidu.swan.apps.swancore.b.aDS();
    }

    public static void fg(boolean z) {
        com.baidu.swan.apps.swancore.b.fT(z);
    }

    public static boolean axH() {
        return getBoolean("aiapps_emit_game_core_debug_key", false);
    }

    public static void fh(boolean z) {
        setBoolean("aiapps_emit_game_core_debug_key", z);
    }

    public static boolean axI() {
        return getBoolean("aiapps_emit_game_launch_mode_key", false);
    }

    public static void fi(boolean z) {
        setBoolean("aiapps_emit_game_launch_mode_key", z);
    }

    public static boolean axJ() {
        return getBoolean("aiapps_emit_wss_debug_key", false);
    }

    public static void fj(boolean z) {
        setBoolean("aiapps_emit_wss_debug_key", z);
    }

    public static void fk(boolean z) {
        setBoolean("aiapps_load_cts_debug_key", z);
    }

    public static boolean axK() {
        return getBoolean("aiapps_load_cts_debug_key", false);
    }

    public static void pX(String str) {
        axu().putString("aiapps_env_data", str);
    }

    public static String axL() {
        return axu().getString("aiapps_env_data", "");
    }

    public static void setBoolean(String str, boolean z) {
        axu().putBoolean(str, z);
    }

    public static boolean getBoolean(String str, boolean z) {
        return axu().getBoolean(str, z);
    }

    private static boolean c(c cVar) {
        return (DEBUG && cVar.isDebug()) || pY(cVar.arM()) || com.baidu.swan.apps.console.debugger.b.aez() || com.baidu.swan.apps.console.debugger.b.aeA() || (axI() && cVar.arv());
    }

    public static boolean j(com.baidu.swan.apps.u.c.b bVar) {
        return (DEBUG && bVar.isDebug()) || pY(bVar.arM()) || com.baidu.swan.apps.console.debugger.b.aez() || com.baidu.swan.apps.console.debugger.b.aeA() || (axI() && bVar.arv());
    }

    public static boolean axM() {
        return com.baidu.swan.apps.console.debugger.b.aez() || com.baidu.swan.apps.console.debugger.b.aeA();
    }

    public static boolean pY(String str) {
        return !TextUtils.isEmpty(str) || e.aeO();
    }

    public static boolean axN() {
        return getBoolean("aiapps_force_authorized_key", false);
    }

    public static boolean axO() {
        return getBoolean("aiapps_js_native_switch_key", true);
    }

    public static void fl(boolean z) {
        setBoolean("aiapps_js_native_switch_key", z);
    }

    public static d.f a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ap.a.b bVar2) {
        if (DEBUG && bVar.isDebug()) {
            return d.a.a(bVar, bVar2);
        }
        if (pY(bVar.arM())) {
            return d.e.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.aez()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.aeA()) {
            return com.baidu.swan.apps.console.debugger.b.b.d(bVar);
        }
        return null;
    }

    public static Bundle d(c cVar) {
        if (c(cVar)) {
            b.a axQ = axQ();
            axQ.nV(cVar.getAppId());
            axQ.nY(cVar.arx());
            axQ.oa(cVar.getPage());
            axQ.eD(cVar.isDebug());
            axQ.ob(cVar.arE());
            axQ.G(cVar.arD());
            axQ.nZ(cVar.arz());
            axQ.oc(cVar.arF());
            axQ.b(cVar.akX());
            axQ.c(cVar.akY());
            axQ.od(cVar.arI());
            axQ.oe(cVar.arM());
            axQ.nQ("0");
            axQ.im(cVar.getAppFrameType());
            axQ.il(cVar.getOrientation());
            if (pY(cVar.arM()) || axM()) {
                axQ.nW(cVar.getAppId());
            }
            return axQ.toBundle();
        }
        return null;
    }

    public static String k(com.baidu.swan.apps.u.c.b bVar) {
        if (DEBUG && bVar.isDebug()) {
            return d.a.apn().getPath();
        }
        if (pY(bVar.arM())) {
            return d.e.aeB().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.aez()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.aeB().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.aeA()) {
            return com.baidu.swan.apps.console.debugger.b.b.aeB().getPath();
        }
        return "";
    }

    public static void ahg() {
        com.baidu.swan.apps.core.d.c ahW;
        f YG = com.baidu.swan.apps.v.f.asJ().YG();
        if (YG != null && (ahW = YG.ahW()) != null) {
            ahW.ahg();
        }
    }

    public static boolean axP() {
        return axK() || axE() || axF() || axC() || !axw() || axG() || axH() || axJ() || axI();
    }

    public static b.a axQ() {
        return ((b.a) ((b.a) ((b.a) new b.a().k(new PMSAppInfo())).nX("小程序测试").nV("10985873").bf(Color.parseColor("#FF308EF0"))).nY("1230000000000000")).nT("小程序简介").nS("测试服务类目").nR("测试主体信息").nW("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N").nQ("1.0").nU("https://b.bdstatic.com/searchbox/mappconsole/image/20180502/1525250801121271.png");
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
