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
    private static com.baidu.swan.apps.storage.c.a dqG;
    private static final boolean DEBUG = b.DEBUG;
    private static final Set<String> dqH = new HashSet();

    static {
        dqH.add("aiapps_websafe_debug_key");
        dqH.add("aiapps_server_domains_debug_key");
        dqH.add("aiapps_use_extension_debug_key");
        dqH.add("aiapps_emit_live_debug_key");
        dqH.add("aiapps_emit_https_debug_key");
        dqH.add("aiapps_emit_wss_debug_key");
        dqH.add("aiapps_load_cts_debug_key");
        dqH.add("aiapps_env_data");
        dqH.add("aiapps_js_native_switch_key");
        dqH.add("aiapps_emit_game_core_debug_key");
        dqH.add("aiapps_emit_game_launch_mode_key");
    }

    public static com.baidu.swan.apps.storage.c.a aEz() {
        if (dqG == null) {
            synchronized (a.class) {
                if (dqG == null) {
                    dqG = new com.baidu.swan.apps.storage.c.a("swan_app_debug");
                    dqG.dJU.addAll(dqH);
                }
            }
        }
        return dqG;
    }

    public static boolean aEA() {
        return aEz().getBoolean("swan_debug_force_ab", false);
    }

    public static boolean aDd() {
        return aEz().getBoolean("swan_debug_forbid_sample", true);
    }

    public static boolean aEB() {
        return getBoolean("aiapps_websafe_debug_key", true);
    }

    public static boolean aEC() {
        return getBoolean("aiapps_server_domains_debug_key", true);
    }

    public static void gq(boolean z) {
        setBoolean("aiapps_websafe_debug_key", z);
    }

    public static void gr(boolean z) {
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

    public static void gs(boolean z) {
        setBoolean("aiapps_use_extension_debug_key", z);
    }

    public static boolean aEI() {
        return getBoolean("aiapps_use_game_extension_debug_key", false);
    }

    public static boolean aEJ() {
        return getBoolean("aiapps_emit_live_debug_key", false);
    }

    public static void gt(boolean z) {
        setBoolean("aiapps_emit_live_debug_key", z);
    }

    public static boolean aEK() {
        return getBoolean("aiapps_emit_https_debug_key", false);
    }

    public static void gu(boolean z) {
        setBoolean("aiapps_emit_https_debug_key", z);
    }

    public static boolean aEL() {
        return com.baidu.swan.apps.swancore.b.aLR();
    }

    public static void gv(boolean z) {
        com.baidu.swan.apps.swancore.b.hr(z);
    }

    public static boolean aEM() {
        return getBoolean("aiapps_emit_game_core_debug_key", false);
    }

    public static void gw(boolean z) {
        setBoolean("aiapps_emit_game_core_debug_key", z);
    }

    public static boolean aEN() {
        return getBoolean("aiapps_emit_game_launch_mode_key", false);
    }

    public static void gx(boolean z) {
        setBoolean("aiapps_emit_game_launch_mode_key", z);
    }

    public static boolean aEO() {
        return getBoolean("aiapps_emit_wss_debug_key", false);
    }

    public static void gy(boolean z) {
        setBoolean("aiapps_emit_wss_debug_key", z);
    }

    public static void gz(boolean z) {
        setBoolean("aiapps_load_cts_debug_key", z);
    }

    public static boolean aEP() {
        return getBoolean("aiapps_load_cts_debug_key", false);
    }

    public static void qz(String str) {
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
        return (DEBUG && cVar.isDebug()) || qA(cVar.ayR()) || com.baidu.swan.apps.console.debugger.b.alx() || com.baidu.swan.apps.console.debugger.b.aly() || (aEN() && cVar.ayA());
    }

    public static boolean j(com.baidu.swan.apps.u.c.b bVar) {
        return (DEBUG && bVar.isDebug()) || qA(bVar.ayR()) || com.baidu.swan.apps.console.debugger.b.alx() || com.baidu.swan.apps.console.debugger.b.aly() || (aEN() && bVar.ayA());
    }

    public static boolean aER() {
        return com.baidu.swan.apps.console.debugger.b.alx() || com.baidu.swan.apps.console.debugger.b.aly();
    }

    public static boolean qA(String str) {
        return !TextUtils.isEmpty(str) || e.alM();
    }

    public static boolean aES() {
        return getBoolean("aiapps_force_authorized_key", false);
    }

    public static boolean aET() {
        return getBoolean("aiapps_js_native_switch_key", true);
    }

    public static void gA(boolean z) {
        setBoolean("aiapps_js_native_switch_key", z);
    }

    public static d.f a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ao.a.b bVar2) {
        if (DEBUG && bVar.isDebug()) {
            return d.a.a(bVar, bVar2);
        }
        if (qA(bVar.ayR())) {
            return d.e.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.alx()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.aly()) {
            return com.baidu.swan.apps.console.debugger.b.b.d(bVar);
        }
        return null;
    }

    public static Bundle d(c cVar) {
        if (c(cVar)) {
            b.a aEV = aEV();
            aEV.oz(cVar.getAppId());
            aEV.oC(cVar.ayC());
            aEV.oE(cVar.getPage());
            aEV.fS(cVar.isDebug());
            aEV.oF(cVar.ayJ());
            aEV.G(cVar.ayI());
            aEV.oD(cVar.ayE());
            aEV.oG(cVar.ayK());
            aEV.b(cVar.asb());
            aEV.c(cVar.asc());
            aEV.oH(cVar.ayN());
            aEV.oI(cVar.ayR());
            aEV.ou("0");
            aEV.hN(cVar.getAppFrameType());
            aEV.hM(cVar.getOrientation());
            if (qA(cVar.ayR()) || aER()) {
                aEV.oA(cVar.getAppId());
            }
            return aEV.toBundle();
        }
        return null;
    }

    public static String k(com.baidu.swan.apps.u.c.b bVar) {
        if (DEBUG && bVar.isDebug()) {
            return d.a.awr().getPath();
        }
        if (qA(bVar.ayR())) {
            return d.e.alz().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.alx()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.alz().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.aly()) {
            return com.baidu.swan.apps.console.debugger.b.b.alz().getPath();
        }
        return "";
    }

    public static void aod() {
        com.baidu.swan.apps.core.d.c aoY;
        f afz = com.baidu.swan.apps.v.f.azN().afz();
        if (afz != null && (aoY = afz.aoY()) != null) {
            aoY.aod();
        }
    }

    public static boolean aEU() {
        return aEP() || aEJ() || aEK() || aEH() || !aEB() || aEL() || aEM() || aEO() || aEN();
    }

    public static b.a aEV() {
        return ((b.a) ((b.a) ((b.a) new b.a().k(new PMSAppInfo())).oB("小程序测试").oz("10985873").cl(Color.parseColor("#FF308EF0"))).oC("1230000000000000")).ox("小程序简介").ow("测试服务类目").ov("测试主体信息").oA("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N").ou("1.0").oy("https://b.bdstatic.com/searchbox/mappconsole/image/20180502/1525250801121271.png");
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
