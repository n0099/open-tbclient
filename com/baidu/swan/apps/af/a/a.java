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
    private static com.baidu.swan.apps.storage.c.a ctf;
    private static final boolean DEBUG = b.DEBUG;
    private static final Set<String> ctg = new HashSet();

    static {
        ctg.add("aiapps_websafe_debug_key");
        ctg.add("aiapps_server_domains_debug_key");
        ctg.add("aiapps_use_extension_debug_key");
        ctg.add("aiapps_emit_live_debug_key");
        ctg.add("aiapps_emit_https_debug_key");
        ctg.add("aiapps_emit_wss_debug_key");
        ctg.add("aiapps_load_cts_debug_key");
        ctg.add("aiapps_env_data");
        ctg.add("aiapps_js_native_switch_key");
        ctg.add("aiapps_emit_game_core_debug_key");
        ctg.add("aiapps_emit_game_launch_mode_key");
    }

    public static com.baidu.swan.apps.storage.c.a alZ() {
        if (ctf == null) {
            synchronized (a.class) {
                if (ctf == null) {
                    ctf = new com.baidu.swan.apps.storage.c.a("swan_app_debug");
                    ctf.cGU.addAll(ctg);
                }
            }
        }
        return ctf;
    }

    public static boolean ama() {
        return alZ().getBoolean("swan_debug_force_ab", false);
    }

    public static boolean akT() {
        return alZ().getBoolean("swan_debug_forbid_sample", true);
    }

    public static boolean amb() {
        return getBoolean("aiapps_websafe_debug_key", true);
    }

    public static boolean amc() {
        return getBoolean("aiapps_server_domains_debug_key", true);
    }

    public static void ev(boolean z) {
        setBoolean("aiapps_websafe_debug_key", z);
    }

    public static void ew(boolean z) {
        setBoolean("aiapps_server_domains_debug_key", z);
    }

    public static boolean amd() {
        return getBoolean("aiapps_close_view_disable_debug_key", false);
    }

    public static boolean ame() {
        return getBoolean("aiapps_dashboard_enable_debug_key", false);
    }

    public static boolean amf() {
        return getBoolean("swan_game_fps_debug_key", false);
    }

    public static boolean amg() {
        return getBoolean("aiapps_sconsole_scan_mode_debug_key", false);
    }

    public static boolean amh() {
        return getBoolean("aiapps_use_extension_debug_key", false);
    }

    public static void ex(boolean z) {
        setBoolean("aiapps_use_extension_debug_key", z);
    }

    public static boolean ami() {
        return getBoolean("aiapps_use_game_extension_debug_key", false);
    }

    public static boolean amj() {
        return getBoolean("aiapps_emit_live_debug_key", false);
    }

    public static void ey(boolean z) {
        setBoolean("aiapps_emit_live_debug_key", z);
    }

    public static boolean amk() {
        return getBoolean("aiapps_emit_https_debug_key", false);
    }

    public static void ez(boolean z) {
        setBoolean("aiapps_emit_https_debug_key", z);
    }

    public static boolean aml() {
        return com.baidu.swan.apps.swancore.b.arR();
    }

    public static void eA(boolean z) {
        com.baidu.swan.apps.swancore.b.fn(z);
    }

    public static boolean amm() {
        return getBoolean("aiapps_emit_game_core_debug_key", false);
    }

    public static void eB(boolean z) {
        setBoolean("aiapps_emit_game_core_debug_key", z);
    }

    public static boolean amn() {
        return getBoolean("aiapps_emit_game_launch_mode_key", false);
    }

    public static void eC(boolean z) {
        setBoolean("aiapps_emit_game_launch_mode_key", z);
    }

    public static boolean amo() {
        return getBoolean("aiapps_emit_wss_debug_key", false);
    }

    public static void eD(boolean z) {
        setBoolean("aiapps_emit_wss_debug_key", z);
    }

    public static void eE(boolean z) {
        setBoolean("aiapps_load_cts_debug_key", z);
    }

    public static boolean amp() {
        return getBoolean("aiapps_load_cts_debug_key", false);
    }

    public static void mQ(String str) {
        alZ().putString("aiapps_env_data", str);
    }

    public static String amq() {
        return alZ().getString("aiapps_env_data", "");
    }

    public static void setBoolean(String str, boolean z) {
        alZ().putBoolean(str, z);
    }

    public static boolean getBoolean(String str, boolean z) {
        return alZ().getBoolean(str, z);
    }

    private static boolean c(c cVar) {
        return (DEBUG && cVar.isDebug()) || mR(cVar.agZ()) || com.baidu.swan.apps.console.debugger.b.VX() || com.baidu.swan.apps.console.debugger.b.VY() || (amn() && cVar.agI());
    }

    public static boolean m(com.baidu.swan.apps.v.b.b bVar) {
        return (DEBUG && bVar.isDebug()) || mR(bVar.agZ()) || com.baidu.swan.apps.console.debugger.b.VX() || com.baidu.swan.apps.console.debugger.b.VY() || (amn() && bVar.agI());
    }

    public static boolean amr() {
        return com.baidu.swan.apps.console.debugger.b.VX() || com.baidu.swan.apps.console.debugger.b.VY();
    }

    public static boolean mR(String str) {
        return !TextUtils.isEmpty(str) || e.Wm();
    }

    public static boolean ams() {
        return getBoolean("aiapps_force_authorized_key", false);
    }

    public static boolean amt() {
        return getBoolean("aiapps_js_native_switch_key", true);
    }

    public static void eF(boolean z) {
        setBoolean("aiapps_js_native_switch_key", z);
    }

    public static e.f a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.aq.a.b bVar2) {
        if (DEBUG && bVar.isDebug()) {
            return e.a.a(bVar, bVar2);
        }
        if (mR(bVar.agZ())) {
            return e.C0371e.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.VX()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.VY()) {
            return com.baidu.swan.apps.console.debugger.b.b.d(bVar);
        }
        return null;
    }

    public static Bundle d(c cVar) {
        if (c(cVar)) {
            b.a amv = amv();
            amv.kW(cVar.getAppId());
            amv.kZ(cVar.agK());
            amv.lb(cVar.getPage());
            amv.dZ(cVar.isDebug());
            amv.lc(cVar.agR());
            amv.H(cVar.agQ());
            amv.la(cVar.agM());
            amv.ld(cVar.agS());
            amv.b(cVar.abG());
            amv.c(cVar.abH());
            amv.le(cVar.agV());
            amv.lf(cVar.agZ());
            amv.kR("0");
            amv.fD(cVar.getAppFrameType());
            amv.fC(cVar.getOrientation());
            if (mR(cVar.agZ()) || amr()) {
                amv.kX(cVar.getAppId());
            }
            return amv.toBundle();
        }
        return null;
    }

    public static String n(com.baidu.swan.apps.v.b.b bVar) {
        if (DEBUG && bVar.isDebug()) {
            return e.a.aeK().getPath();
        }
        if (mR(bVar.agZ())) {
            return e.C0371e.VZ().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.VX()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.VZ().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.VY()) {
            return com.baidu.swan.apps.console.debugger.b.b.VZ().getPath();
        }
        return "";
    }

    public static void Yc() {
        com.baidu.swan.apps.core.d.b YP;
        com.baidu.swan.apps.core.d.e QH = f.ahV().QH();
        if (QH != null && (YP = QH.YP()) != null) {
            YP.Yc();
        }
    }

    public static boolean amu() {
        return amp() || amj() || amk() || amh() || !amb() || aml() || amm() || amo() || amn();
    }

    public static b.a amv() {
        return ((b.a) ((b.a) ((b.a) new b.a().h(new PMSAppInfo())).kY("小程序测试").kW("10985873").aV(Color.parseColor("#FF308EF0"))).kZ("1230000000000000")).kU("小程序简介").kT("测试服务类目").kS("测试主体信息").kX("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N").kR("1.0").kV("https://b.bdstatic.com/searchbox/mappconsole/image/20180502/1525250801121271.png");
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
