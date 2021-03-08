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
    private static com.baidu.swan.apps.storage.c.a duu;
    private static final boolean DEBUG = b.DEBUG;
    private static final Set<String> duv = new HashSet();

    static {
        duv.add("aiapps_websafe_debug_key");
        duv.add("aiapps_server_domains_debug_key");
        duv.add("aiapps_use_extension_debug_key");
        duv.add("aiapps_emit_live_debug_key");
        duv.add("aiapps_emit_https_debug_key");
        duv.add("aiapps_emit_wss_debug_key");
        duv.add("aiapps_load_cts_debug_key");
        duv.add("aiapps_env_data");
        duv.add("aiapps_js_native_switch_key");
        duv.add("aiapps_emit_game_core_debug_key");
        duv.add("aiapps_emit_game_launch_mode_key");
    }

    public static com.baidu.swan.apps.storage.c.a aEX() {
        if (duu == null) {
            synchronized (a.class) {
                if (duu == null) {
                    duu = new com.baidu.swan.apps.storage.c.a("swan_app_debug");
                    duu.dNz.addAll(duv);
                }
            }
        }
        return duu;
    }

    public static boolean aEY() {
        return aEX().getBoolean("swan_debug_force_ab", false);
    }

    public static boolean aDC() {
        return aEX().getBoolean("swan_debug_forbid_sample", true);
    }

    public static boolean aEZ() {
        return getBoolean("aiapps_websafe_debug_key", true);
    }

    public static boolean aFa() {
        return getBoolean("aiapps_server_domains_debug_key", true);
    }

    public static void gs(boolean z) {
        setBoolean("aiapps_websafe_debug_key", z);
    }

    public static void gt(boolean z) {
        setBoolean("aiapps_server_domains_debug_key", z);
    }

    public static boolean aFb() {
        return getBoolean("aiapps_close_view_disable_debug_key", false);
    }

    public static boolean aFc() {
        return getBoolean("aiapps_dashboard_enable_debug_key", false);
    }

    public static boolean aFd() {
        return getBoolean("swan_game_fps_debug_key", false);
    }

    public static boolean aFe() {
        return getBoolean("aiapps_sconsole_scan_mode_debug_key", false);
    }

    public static boolean aFf() {
        return getBoolean("aiapps_use_extension_debug_key", false);
    }

    public static void gu(boolean z) {
        setBoolean("aiapps_use_extension_debug_key", z);
    }

    public static boolean aFg() {
        return getBoolean("aiapps_use_game_extension_debug_key", false);
    }

    public static boolean aFh() {
        return getBoolean("aiapps_emit_live_debug_key", false);
    }

    public static void gv(boolean z) {
        setBoolean("aiapps_emit_live_debug_key", z);
    }

    public static boolean aFi() {
        return getBoolean("aiapps_emit_https_debug_key", false);
    }

    public static void gw(boolean z) {
        setBoolean("aiapps_emit_https_debug_key", z);
    }

    public static boolean aFj() {
        return com.baidu.swan.apps.swancore.b.aMn();
    }

    public static void gx(boolean z) {
        com.baidu.swan.apps.swancore.b.ht(z);
    }

    public static boolean aFk() {
        return getBoolean("aiapps_emit_game_core_debug_key", false);
    }

    public static void gy(boolean z) {
        setBoolean("aiapps_emit_game_core_debug_key", z);
    }

    public static boolean aFl() {
        return getBoolean("aiapps_emit_game_launch_mode_key", false);
    }

    public static void gz(boolean z) {
        setBoolean("aiapps_emit_game_launch_mode_key", z);
    }

    public static boolean aFm() {
        return getBoolean("aiapps_emit_wss_debug_key", false);
    }

    public static void gA(boolean z) {
        setBoolean("aiapps_emit_wss_debug_key", z);
    }

    public static void gB(boolean z) {
        setBoolean("aiapps_load_cts_debug_key", z);
    }

    public static boolean aFn() {
        return getBoolean("aiapps_load_cts_debug_key", false);
    }

    public static void qY(String str) {
        aEX().putString("aiapps_env_data", str);
    }

    public static String aFo() {
        return aEX().getString("aiapps_env_data", "");
    }

    public static void setBoolean(String str, boolean z) {
        aEX().putBoolean(str, z);
    }

    public static boolean getBoolean(String str, boolean z) {
        return aEX().getBoolean(str, z);
    }

    private static boolean c(c cVar) {
        return (DEBUG && cVar.isDebug()) || qZ(cVar.azs()) || com.baidu.swan.apps.console.debugger.b.alY() || com.baidu.swan.apps.console.debugger.b.alZ() || (aFl() && cVar.azb());
    }

    public static boolean j(com.baidu.swan.apps.u.c.b bVar) {
        return (DEBUG && bVar.isDebug()) || qZ(bVar.azs()) || com.baidu.swan.apps.console.debugger.b.alY() || com.baidu.swan.apps.console.debugger.b.alZ() || (aFl() && bVar.azb());
    }

    public static boolean aFp() {
        return com.baidu.swan.apps.console.debugger.b.alY() || com.baidu.swan.apps.console.debugger.b.alZ();
    }

    public static boolean qZ(String str) {
        return !TextUtils.isEmpty(str) || e.amn();
    }

    public static boolean aFq() {
        return getBoolean("aiapps_force_authorized_key", false);
    }

    public static boolean aFr() {
        return getBoolean("aiapps_js_native_switch_key", true);
    }

    public static void gC(boolean z) {
        setBoolean("aiapps_js_native_switch_key", z);
    }

    public static d.f a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ao.a.b bVar2) {
        if (DEBUG && bVar.isDebug()) {
            return d.a.a(bVar, bVar2);
        }
        if (qZ(bVar.azs())) {
            return d.e.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.alY()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.alZ()) {
            return com.baidu.swan.apps.console.debugger.b.b.d(bVar);
        }
        return null;
    }

    public static Bundle d(c cVar) {
        if (c(cVar)) {
            b.a aFt = aFt();
            aFt.oY(cVar.getAppId());
            aFt.pb(cVar.azd());
            aFt.pd(cVar.getPage());
            aFt.fU(cVar.isDebug());
            aFt.pe(cVar.azk());
            aFt.G(cVar.azj());
            aFt.pc(cVar.azf());
            aFt.pf(cVar.azl());
            aFt.b(cVar.asD());
            aFt.c(cVar.asE());
            aFt.pg(cVar.azo());
            aFt.ph(cVar.azs());
            aFt.oT("0");
            aFt.hR(cVar.getAppFrameType());
            aFt.hQ(cVar.getOrientation());
            if (qZ(cVar.azs()) || aFp()) {
                aFt.oZ(cVar.getAppId());
            }
            return aFt.toBundle();
        }
        return null;
    }

    public static String k(com.baidu.swan.apps.u.c.b bVar) {
        if (DEBUG && bVar.isDebug()) {
            return d.a.awS().getPath();
        }
        if (qZ(bVar.azs())) {
            return d.e.ama().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.alY()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.ama().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.alZ()) {
            return com.baidu.swan.apps.console.debugger.b.b.ama().getPath();
        }
        return "";
    }

    public static void aoE() {
        com.baidu.swan.apps.core.d.c apA;
        f aga = com.baidu.swan.apps.v.f.aAo().aga();
        if (aga != null && (apA = aga.apA()) != null) {
            apA.aoE();
        }
    }

    public static boolean aFs() {
        return aFn() || aFh() || aFi() || aFf() || !aEZ() || aFj() || aFk() || aFm() || aFl();
    }

    public static b.a aFt() {
        return ((b.a) ((b.a) ((b.a) new b.a().k(new PMSAppInfo())).pa("小程序测试").oY("10985873").cr(Color.parseColor("#FF308EF0"))).pb("1230000000000000")).oW("小程序简介").oV("测试服务类目").oU("测试主体信息").oZ("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N").oT("1.0").oX("https://b.bdstatic.com/searchbox/mappconsole/image/20180502/1525250801121271.png");
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
