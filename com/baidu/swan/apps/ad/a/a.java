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
/* loaded from: classes7.dex */
public final class a {
    private static com.baidu.swan.apps.storage.c.a djx;
    private static final boolean DEBUG = b.DEBUG;
    private static final Set<String> djy = new HashSet();

    static {
        djy.add("aiapps_websafe_debug_key");
        djy.add("aiapps_server_domains_debug_key");
        djy.add("aiapps_use_extension_debug_key");
        djy.add("aiapps_emit_live_debug_key");
        djy.add("aiapps_emit_https_debug_key");
        djy.add("aiapps_emit_wss_debug_key");
        djy.add("aiapps_load_cts_debug_key");
        djy.add("aiapps_env_data");
        djy.add("aiapps_js_native_switch_key");
        djy.add("aiapps_emit_game_core_debug_key");
        djy.add("aiapps_emit_game_launch_mode_key");
    }

    public static com.baidu.swan.apps.storage.c.a aDR() {
        if (djx == null) {
            synchronized (a.class) {
                if (djx == null) {
                    djx = new com.baidu.swan.apps.storage.c.a("swan_app_debug");
                    djx.dzd.addAll(djy);
                }
            }
        }
        return djx;
    }

    public static boolean aDS() {
        return aDR().getBoolean("swan_debug_force_ab", false);
    }

    public static boolean aCt() {
        return aDR().getBoolean("swan_debug_forbid_sample", true);
    }

    public static boolean aDT() {
        return getBoolean("aiapps_websafe_debug_key", true);
    }

    public static boolean aDU() {
        return getBoolean("aiapps_server_domains_debug_key", true);
    }

    public static void fW(boolean z) {
        setBoolean("aiapps_websafe_debug_key", z);
    }

    public static void fX(boolean z) {
        setBoolean("aiapps_server_domains_debug_key", z);
    }

    public static boolean aDV() {
        return getBoolean("aiapps_close_view_disable_debug_key", false);
    }

    public static boolean aDW() {
        return getBoolean("aiapps_dashboard_enable_debug_key", false);
    }

    public static boolean aDX() {
        return getBoolean("swan_game_fps_debug_key", false);
    }

    public static boolean aDY() {
        return getBoolean("aiapps_sconsole_scan_mode_debug_key", false);
    }

    public static boolean aDZ() {
        return getBoolean("aiapps_use_extension_debug_key", false);
    }

    public static void fY(boolean z) {
        setBoolean("aiapps_use_extension_debug_key", z);
    }

    public static boolean aEa() {
        return getBoolean("aiapps_use_game_extension_debug_key", false);
    }

    public static boolean aEb() {
        return getBoolean("aiapps_emit_live_debug_key", false);
    }

    public static void fZ(boolean z) {
        setBoolean("aiapps_emit_live_debug_key", z);
    }

    public static boolean aEc() {
        return getBoolean("aiapps_emit_https_debug_key", false);
    }

    public static void ga(boolean z) {
        setBoolean("aiapps_emit_https_debug_key", z);
    }

    public static boolean aEd() {
        return com.baidu.swan.apps.swancore.b.aKn();
    }

    public static void gb(boolean z) {
        com.baidu.swan.apps.swancore.b.gO(z);
    }

    public static boolean aEe() {
        return getBoolean("aiapps_emit_game_core_debug_key", false);
    }

    public static void gc(boolean z) {
        setBoolean("aiapps_emit_game_core_debug_key", z);
    }

    public static boolean aEf() {
        return getBoolean("aiapps_emit_game_launch_mode_key", false);
    }

    public static void gd(boolean z) {
        setBoolean("aiapps_emit_game_launch_mode_key", z);
    }

    public static boolean aEg() {
        return getBoolean("aiapps_emit_wss_debug_key", false);
    }

    public static void ge(boolean z) {
        setBoolean("aiapps_emit_wss_debug_key", z);
    }

    public static void gf(boolean z) {
        setBoolean("aiapps_load_cts_debug_key", z);
    }

    public static boolean aEh() {
        return getBoolean("aiapps_load_cts_debug_key", false);
    }

    public static void rk(String str) {
        aDR().putString("aiapps_env_data", str);
    }

    public static String aEi() {
        return aDR().getString("aiapps_env_data", "");
    }

    public static void setBoolean(String str, boolean z) {
        aDR().putBoolean(str, z);
    }

    public static boolean getBoolean(String str, boolean z) {
        return aDR().getBoolean(str, z);
    }

    private static boolean c(c cVar) {
        return (DEBUG && cVar.isDebug()) || rl(cVar.ayk()) || com.baidu.swan.apps.console.debugger.b.akW() || com.baidu.swan.apps.console.debugger.b.akX() || (aEf() && cVar.axT());
    }

    public static boolean j(com.baidu.swan.apps.u.c.b bVar) {
        return (DEBUG && bVar.isDebug()) || rl(bVar.ayk()) || com.baidu.swan.apps.console.debugger.b.akW() || com.baidu.swan.apps.console.debugger.b.akX() || (aEf() && bVar.axT());
    }

    public static boolean aEj() {
        return com.baidu.swan.apps.console.debugger.b.akW() || com.baidu.swan.apps.console.debugger.b.akX();
    }

    public static boolean rl(String str) {
        return !TextUtils.isEmpty(str) || e.all();
    }

    public static boolean aEk() {
        return getBoolean("aiapps_force_authorized_key", false);
    }

    public static boolean aEl() {
        return getBoolean("aiapps_js_native_switch_key", true);
    }

    public static void gg(boolean z) {
        setBoolean("aiapps_js_native_switch_key", z);
    }

    public static d.f a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ap.a.b bVar2) {
        if (DEBUG && bVar.isDebug()) {
            return d.a.a(bVar, bVar2);
        }
        if (rl(bVar.ayk())) {
            return d.e.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.akW()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.akX()) {
            return com.baidu.swan.apps.console.debugger.b.b.d(bVar);
        }
        return null;
    }

    public static Bundle d(c cVar) {
        if (c(cVar)) {
            b.a aEn = aEn();
            aEn.pk(cVar.getAppId());
            aEn.pn(cVar.axV());
            aEn.pp(cVar.getPage());
            aEn.fy(cVar.isDebug());
            aEn.pq(cVar.ayc());
            aEn.G(cVar.ayb());
            aEn.po(cVar.axX());
            aEn.pr(cVar.ayd());
            aEn.b(cVar.arv());
            aEn.c(cVar.arw());
            aEn.ps(cVar.ayg());
            aEn.pt(cVar.ayk());
            aEn.pf("0");
            aEn.ja(cVar.getAppFrameType());
            aEn.iZ(cVar.getOrientation());
            if (rl(cVar.ayk()) || aEj()) {
                aEn.pl(cVar.getAppId());
            }
            return aEn.toBundle();
        }
        return null;
    }

    public static String k(com.baidu.swan.apps.u.c.b bVar) {
        if (DEBUG && bVar.isDebug()) {
            return d.a.avL().getPath();
        }
        if (rl(bVar.ayk())) {
            return d.e.akY().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.akW()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.akY().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.akX()) {
            return com.baidu.swan.apps.console.debugger.b.b.akY().getPath();
        }
        return "";
    }

    public static void anD() {
        com.baidu.swan.apps.core.d.c aot;
        f afe = com.baidu.swan.apps.v.f.azg().afe();
        if (afe != null && (aot = afe.aot()) != null) {
            aot.anD();
        }
    }

    public static boolean aEm() {
        return aEh() || aEb() || aEc() || aDZ() || !aDT() || aEd() || aEe() || aEg() || aEf();
    }

    public static b.a aEn() {
        return ((b.a) ((b.a) ((b.a) new b.a().k(new PMSAppInfo())).pm("小程序测试").pk("10985873").bL(Color.parseColor("#FF308EF0"))).pn("1230000000000000")).pi("小程序简介").ph("测试服务类目").pg("测试主体信息").pl("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N").pf("1.0").pj("https://b.bdstatic.com/searchbox/mappconsole/image/20180502/1525250801121271.png");
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
