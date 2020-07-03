package com.baidu.swan.apps.af.a;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.console.debugger.a.e;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.r.e;
import com.baidu.swan.apps.v.b.b;
import com.baidu.swan.apps.v.b.c;
import com.baidu.swan.apps.w.f;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes11.dex */
public final class a {
    private static com.baidu.swan.apps.storage.c.a cxT;
    private static final boolean DEBUG = b.DEBUG;
    private static final Set<String> cxU = new HashSet();

    static {
        cxU.add("aiapps_websafe_debug_key");
        cxU.add("aiapps_server_domains_debug_key");
        cxU.add("aiapps_use_extension_debug_key");
        cxU.add("aiapps_emit_live_debug_key");
        cxU.add("aiapps_emit_https_debug_key");
        cxU.add("aiapps_emit_wss_debug_key");
        cxU.add("aiapps_load_cts_debug_key");
        cxU.add("aiapps_env_data");
        cxU.add("aiapps_js_native_switch_key");
        cxU.add("aiapps_emit_game_core_debug_key");
        cxU.add("aiapps_emit_game_launch_mode_key");
    }

    public static com.baidu.swan.apps.storage.c.a anf() {
        if (cxT == null) {
            synchronized (a.class) {
                if (cxT == null) {
                    cxT = new com.baidu.swan.apps.storage.c.a("swan_app_debug");
                    cxT.cLE.addAll(cxU);
                }
            }
        }
        return cxT;
    }

    public static boolean ang() {
        return anf().getBoolean("swan_debug_force_ab", false);
    }

    public static boolean alZ() {
        return anf().getBoolean("swan_debug_forbid_sample", true);
    }

    public static boolean anh() {
        return getBoolean("aiapps_websafe_debug_key", true);
    }

    public static boolean ani() {
        return getBoolean("aiapps_server_domains_debug_key", true);
    }

    public static void eA(boolean z) {
        setBoolean("aiapps_websafe_debug_key", z);
    }

    public static void eB(boolean z) {
        setBoolean("aiapps_server_domains_debug_key", z);
    }

    public static boolean anj() {
        return getBoolean("aiapps_close_view_disable_debug_key", false);
    }

    public static boolean ank() {
        return getBoolean("aiapps_dashboard_enable_debug_key", false);
    }

    public static boolean anl() {
        return getBoolean("swan_game_fps_debug_key", false);
    }

    public static boolean anm() {
        return getBoolean("aiapps_sconsole_scan_mode_debug_key", false);
    }

    public static boolean ann() {
        return getBoolean("aiapps_use_extension_debug_key", false);
    }

    public static void eC(boolean z) {
        setBoolean("aiapps_use_extension_debug_key", z);
    }

    public static boolean ano() {
        return getBoolean("aiapps_use_game_extension_debug_key", false);
    }

    public static boolean anp() {
        return getBoolean("aiapps_emit_live_debug_key", false);
    }

    public static void eD(boolean z) {
        setBoolean("aiapps_emit_live_debug_key", z);
    }

    public static boolean anq() {
        return getBoolean("aiapps_emit_https_debug_key", false);
    }

    public static void eE(boolean z) {
        setBoolean("aiapps_emit_https_debug_key", z);
    }

    public static boolean anr() {
        return com.baidu.swan.apps.swancore.b.asY();
    }

    public static void eF(boolean z) {
        com.baidu.swan.apps.swancore.b.fs(z);
    }

    public static boolean ans() {
        return getBoolean("aiapps_emit_game_core_debug_key", false);
    }

    public static void eG(boolean z) {
        setBoolean("aiapps_emit_game_core_debug_key", z);
    }

    public static boolean ant() {
        return getBoolean("aiapps_emit_game_launch_mode_key", false);
    }

    public static void eH(boolean z) {
        setBoolean("aiapps_emit_game_launch_mode_key", z);
    }

    public static boolean anu() {
        return getBoolean("aiapps_emit_wss_debug_key", false);
    }

    public static void eI(boolean z) {
        setBoolean("aiapps_emit_wss_debug_key", z);
    }

    public static void eJ(boolean z) {
        setBoolean("aiapps_load_cts_debug_key", z);
    }

    public static boolean anv() {
        return getBoolean("aiapps_load_cts_debug_key", false);
    }

    public static void mY(String str) {
        anf().putString("aiapps_env_data", str);
    }

    public static String anw() {
        return anf().getString("aiapps_env_data", "");
    }

    public static void setBoolean(String str, boolean z) {
        anf().putBoolean(str, z);
    }

    public static boolean getBoolean(String str, boolean z) {
        return anf().getBoolean(str, z);
    }

    private static boolean c(c cVar) {
        return (DEBUG && cVar.isDebug()) || mZ(cVar.aif()) || com.baidu.swan.apps.console.debugger.b.Xd() || com.baidu.swan.apps.console.debugger.b.Xe() || (ant() && cVar.ahO());
    }

    public static boolean m(com.baidu.swan.apps.v.b.b bVar) {
        return (DEBUG && bVar.isDebug()) || mZ(bVar.aif()) || com.baidu.swan.apps.console.debugger.b.Xd() || com.baidu.swan.apps.console.debugger.b.Xe() || (ant() && bVar.ahO());
    }

    public static boolean anx() {
        return com.baidu.swan.apps.console.debugger.b.Xd() || com.baidu.swan.apps.console.debugger.b.Xe();
    }

    public static boolean mZ(String str) {
        return !TextUtils.isEmpty(str) || e.Xs();
    }

    public static boolean any() {
        return getBoolean("aiapps_force_authorized_key", false);
    }

    public static boolean anz() {
        return getBoolean("aiapps_js_native_switch_key", true);
    }

    public static void eK(boolean z) {
        setBoolean("aiapps_js_native_switch_key", z);
    }

    public static e.f a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.aq.a.b bVar2) {
        if (DEBUG && bVar.isDebug()) {
            return e.a.a(bVar, bVar2);
        }
        if (mZ(bVar.aif())) {
            return e.C0377e.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.Xd()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.Xe()) {
            return com.baidu.swan.apps.console.debugger.b.b.d(bVar);
        }
        return null;
    }

    public static Bundle d(c cVar) {
        if (c(cVar)) {
            b.a anB = anB();
            anB.le(cVar.getAppId());
            anB.lh(cVar.ahQ());
            anB.lj(cVar.getPage());
            anB.ee(cVar.isDebug());
            anB.lk(cVar.ahX());
            anB.H(cVar.ahW());
            anB.li(cVar.ahS());
            anB.ll(cVar.ahY());
            anB.b(cVar.acM());
            anB.c(cVar.acN());
            anB.lm(cVar.aib());
            anB.ln(cVar.aif());
            anB.kZ("0");
            anB.fO(cVar.getAppFrameType());
            anB.fN(cVar.getOrientation());
            if (mZ(cVar.aif()) || anx()) {
                anB.lf(cVar.getAppId());
            }
            return anB.toBundle();
        }
        return null;
    }

    public static String n(com.baidu.swan.apps.v.b.b bVar) {
        if (DEBUG && bVar.isDebug()) {
            return e.a.afQ().getPath();
        }
        if (mZ(bVar.aif())) {
            return e.C0377e.Xf().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.Xd()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.Xf().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.Xe()) {
            return com.baidu.swan.apps.console.debugger.b.b.Xf().getPath();
        }
        return "";
    }

    public static void Zi() {
        com.baidu.swan.apps.core.d.b ZV;
        com.baidu.swan.apps.core.d.e RN = f.ajb().RN();
        if (RN != null && (ZV = RN.ZV()) != null) {
            ZV.Zi();
        }
    }

    public static boolean anA() {
        return anv() || anp() || anq() || ann() || !anh() || anr() || ans() || anu() || ant();
    }

    public static b.a anB() {
        return ((b.a) ((b.a) ((b.a) new b.a().h(new PMSAppInfo())).lg("小程序测试").le("10985873").aV(Color.parseColor("#FF308EF0"))).lh("1230000000000000")).lc("小程序简介").lb("测试服务类目").la("测试主体信息").lf("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N").kZ("1.0").ld("https://b.bdstatic.com/searchbox/mappconsole/image/20180502/1525250801121271.png");
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
