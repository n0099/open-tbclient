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
/* loaded from: classes10.dex */
public final class a {
    private static com.baidu.swan.apps.storage.c.a dle;
    private static final boolean DEBUG = b.DEBUG;
    private static final Set<String> dlf = new HashSet();

    static {
        dlf.add("aiapps_websafe_debug_key");
        dlf.add("aiapps_server_domains_debug_key");
        dlf.add("aiapps_use_extension_debug_key");
        dlf.add("aiapps_emit_live_debug_key");
        dlf.add("aiapps_emit_https_debug_key");
        dlf.add("aiapps_emit_wss_debug_key");
        dlf.add("aiapps_load_cts_debug_key");
        dlf.add("aiapps_env_data");
        dlf.add("aiapps_js_native_switch_key");
        dlf.add("aiapps_emit_game_core_debug_key");
        dlf.add("aiapps_emit_game_launch_mode_key");
    }

    public static com.baidu.swan.apps.storage.c.a aEz() {
        if (dle == null) {
            synchronized (a.class) {
                if (dle == null) {
                    dle = new com.baidu.swan.apps.storage.c.a("swan_app_debug");
                    dle.dAK.addAll(dlf);
                }
            }
        }
        return dle;
    }

    public static boolean aEA() {
        return aEz().getBoolean("swan_debug_force_ab", false);
    }

    public static boolean aDb() {
        return aEz().getBoolean("swan_debug_forbid_sample", true);
    }

    public static boolean aEB() {
        return getBoolean("aiapps_websafe_debug_key", true);
    }

    public static boolean aEC() {
        return getBoolean("aiapps_server_domains_debug_key", true);
    }

    public static void fT(boolean z) {
        setBoolean("aiapps_websafe_debug_key", z);
    }

    public static void fU(boolean z) {
        setBoolean("aiapps_server_domains_debug_key", z);
    }

    public static boolean aED() {
        return getBoolean("aiapps_close_view_disable_debug_key", false);
    }

    public static boolean aEE() {
        return getBoolean("aiapps_dashboard_enable_debug_key", false);
    }

    public static boolean aEF() {
        return getBoolean("swan_game_fps_debug_key", false);
    }

    public static boolean aEG() {
        return getBoolean("aiapps_sconsole_scan_mode_debug_key", false);
    }

    public static boolean aEH() {
        return getBoolean("aiapps_use_extension_debug_key", false);
    }

    public static void fV(boolean z) {
        setBoolean("aiapps_use_extension_debug_key", z);
    }

    public static boolean aEI() {
        return getBoolean("aiapps_use_game_extension_debug_key", false);
    }

    public static boolean aEJ() {
        return getBoolean("aiapps_emit_live_debug_key", false);
    }

    public static void fW(boolean z) {
        setBoolean("aiapps_emit_live_debug_key", z);
    }

    public static boolean aEK() {
        return getBoolean("aiapps_emit_https_debug_key", false);
    }

    public static void fX(boolean z) {
        setBoolean("aiapps_emit_https_debug_key", z);
    }

    public static boolean aEL() {
        return com.baidu.swan.apps.swancore.b.aKV();
    }

    public static void fY(boolean z) {
        com.baidu.swan.apps.swancore.b.gL(z);
    }

    public static boolean aEM() {
        return getBoolean("aiapps_emit_game_core_debug_key", false);
    }

    public static void fZ(boolean z) {
        setBoolean("aiapps_emit_game_core_debug_key", z);
    }

    public static boolean aEN() {
        return getBoolean("aiapps_emit_game_launch_mode_key", false);
    }

    public static void ga(boolean z) {
        setBoolean("aiapps_emit_game_launch_mode_key", z);
    }

    public static boolean aEO() {
        return getBoolean("aiapps_emit_wss_debug_key", false);
    }

    public static void gb(boolean z) {
        setBoolean("aiapps_emit_wss_debug_key", z);
    }

    public static void gc(boolean z) {
        setBoolean("aiapps_load_cts_debug_key", z);
    }

    public static boolean aEP() {
        return getBoolean("aiapps_load_cts_debug_key", false);
    }

    public static void rq(String str) {
        aEz().putString("aiapps_env_data", str);
    }

    public static String aEQ() {
        return aEz().getString("aiapps_env_data", "");
    }

    public static void setBoolean(String str, boolean z) {
        aEz().putBoolean(str, z);
    }

    public static boolean getBoolean(String str, boolean z) {
        return aEz().getBoolean(str, z);
    }

    private static boolean c(c cVar) {
        return (DEBUG && cVar.isDebug()) || rr(cVar.ayS()) || com.baidu.swan.apps.console.debugger.b.alE() || com.baidu.swan.apps.console.debugger.b.alF() || (aEN() && cVar.ayB());
    }

    public static boolean j(com.baidu.swan.apps.u.c.b bVar) {
        return (DEBUG && bVar.isDebug()) || rr(bVar.ayS()) || com.baidu.swan.apps.console.debugger.b.alE() || com.baidu.swan.apps.console.debugger.b.alF() || (aEN() && bVar.ayB());
    }

    public static boolean aER() {
        return com.baidu.swan.apps.console.debugger.b.alE() || com.baidu.swan.apps.console.debugger.b.alF();
    }

    public static boolean rr(String str) {
        return !TextUtils.isEmpty(str) || e.alT();
    }

    public static boolean aES() {
        return getBoolean("aiapps_force_authorized_key", false);
    }

    public static boolean aET() {
        return getBoolean("aiapps_js_native_switch_key", true);
    }

    public static void gd(boolean z) {
        setBoolean("aiapps_js_native_switch_key", z);
    }

    public static d.f a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ap.a.b bVar2) {
        if (DEBUG && bVar.isDebug()) {
            return d.a.a(bVar, bVar2);
        }
        if (rr(bVar.ayS())) {
            return d.e.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.alE()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.alF()) {
            return com.baidu.swan.apps.console.debugger.b.b.d(bVar);
        }
        return null;
    }

    public static Bundle d(c cVar) {
        if (c(cVar)) {
            b.a aEV = aEV();
            aEV.pq(cVar.getAppId());
            aEV.pt(cVar.ayD());
            aEV.pv(cVar.getPage());
            aEV.fv(cVar.isDebug());
            aEV.pw(cVar.ayK());
            aEV.G(cVar.ayJ());
            aEV.pu(cVar.ayF());
            aEV.px(cVar.ayL());
            aEV.b(cVar.asd());
            aEV.c(cVar.ase());
            aEV.py(cVar.ayO());
            aEV.pz(cVar.ayS());
            aEV.pl("0");
            aEV.je(cVar.getAppFrameType());
            aEV.jd(cVar.getOrientation());
            if (rr(cVar.ayS()) || aER()) {
                aEV.pr(cVar.getAppId());
            }
            return aEV.toBundle();
        }
        return null;
    }

    public static String k(com.baidu.swan.apps.u.c.b bVar) {
        if (DEBUG && bVar.isDebug()) {
            return d.a.awt().getPath();
        }
        if (rr(bVar.ayS())) {
            return d.e.alG().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.alE()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.alG().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.alF()) {
            return com.baidu.swan.apps.console.debugger.b.b.alG().getPath();
        }
        return "";
    }

    public static void aol() {
        com.baidu.swan.apps.core.d.c apb;
        f afM = com.baidu.swan.apps.v.f.azO().afM();
        if (afM != null && (apb = afM.apb()) != null) {
            apb.aol();
        }
    }

    public static boolean aEU() {
        return aEP() || aEJ() || aEK() || aEH() || !aEB() || aEL() || aEM() || aEO() || aEN();
    }

    public static b.a aEV() {
        return ((b.a) ((b.a) ((b.a) new b.a().k(new PMSAppInfo())).ps("小程序测试").pq("10985873").bL(Color.parseColor("#FF308EF0"))).pt("1230000000000000")).po("小程序简介").pn("测试服务类目").pm("测试主体信息").pr("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N").pl("1.0").pp("https://b.bdstatic.com/searchbox/mappconsole/image/20180502/1525250801121271.png");
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
