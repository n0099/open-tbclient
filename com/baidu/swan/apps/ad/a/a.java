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
    private static com.baidu.swan.apps.storage.c.a dfj;
    private static final boolean DEBUG = b.DEBUG;
    private static final Set<String> dfk = new HashSet();

    static {
        dfk.add("aiapps_websafe_debug_key");
        dfk.add("aiapps_server_domains_debug_key");
        dfk.add("aiapps_use_extension_debug_key");
        dfk.add("aiapps_emit_live_debug_key");
        dfk.add("aiapps_emit_https_debug_key");
        dfk.add("aiapps_emit_wss_debug_key");
        dfk.add("aiapps_load_cts_debug_key");
        dfk.add("aiapps_env_data");
        dfk.add("aiapps_js_native_switch_key");
        dfk.add("aiapps_emit_game_core_debug_key");
        dfk.add("aiapps_emit_game_launch_mode_key");
    }

    public static com.baidu.swan.apps.storage.c.a aBZ() {
        if (dfj == null) {
            synchronized (a.class) {
                if (dfj == null) {
                    dfj = new com.baidu.swan.apps.storage.c.a("swan_app_debug");
                    dfj.duS.addAll(dfk);
                }
            }
        }
        return dfj;
    }

    public static boolean aCa() {
        return aBZ().getBoolean("swan_debug_force_ab", false);
    }

    public static boolean aAB() {
        return aBZ().getBoolean("swan_debug_forbid_sample", true);
    }

    public static boolean aCb() {
        return getBoolean("aiapps_websafe_debug_key", true);
    }

    public static boolean aCc() {
        return getBoolean("aiapps_server_domains_debug_key", true);
    }

    public static void fK(boolean z) {
        setBoolean("aiapps_websafe_debug_key", z);
    }

    public static void fL(boolean z) {
        setBoolean("aiapps_server_domains_debug_key", z);
    }

    public static boolean aCd() {
        return getBoolean("aiapps_close_view_disable_debug_key", false);
    }

    public static boolean aCe() {
        return getBoolean("aiapps_dashboard_enable_debug_key", false);
    }

    public static boolean aCf() {
        return getBoolean("swan_game_fps_debug_key", false);
    }

    public static boolean aCg() {
        return getBoolean("aiapps_sconsole_scan_mode_debug_key", false);
    }

    public static boolean aCh() {
        return getBoolean("aiapps_use_extension_debug_key", false);
    }

    public static void fM(boolean z) {
        setBoolean("aiapps_use_extension_debug_key", z);
    }

    public static boolean aCi() {
        return getBoolean("aiapps_use_game_extension_debug_key", false);
    }

    public static boolean aCj() {
        return getBoolean("aiapps_emit_live_debug_key", false);
    }

    public static void fN(boolean z) {
        setBoolean("aiapps_emit_live_debug_key", z);
    }

    public static boolean aCk() {
        return getBoolean("aiapps_emit_https_debug_key", false);
    }

    public static void fO(boolean z) {
        setBoolean("aiapps_emit_https_debug_key", z);
    }

    public static boolean aCl() {
        return com.baidu.swan.apps.swancore.b.aIv();
    }

    public static void fP(boolean z) {
        com.baidu.swan.apps.swancore.b.gC(z);
    }

    public static boolean aCm() {
        return getBoolean("aiapps_emit_game_core_debug_key", false);
    }

    public static void fQ(boolean z) {
        setBoolean("aiapps_emit_game_core_debug_key", z);
    }

    public static boolean aCn() {
        return getBoolean("aiapps_emit_game_launch_mode_key", false);
    }

    public static void fR(boolean z) {
        setBoolean("aiapps_emit_game_launch_mode_key", z);
    }

    public static boolean aCo() {
        return getBoolean("aiapps_emit_wss_debug_key", false);
    }

    public static void fS(boolean z) {
        setBoolean("aiapps_emit_wss_debug_key", z);
    }

    public static void fT(boolean z) {
        setBoolean("aiapps_load_cts_debug_key", z);
    }

    public static boolean aCp() {
        return getBoolean("aiapps_load_cts_debug_key", false);
    }

    public static void rc(String str) {
        aBZ().putString("aiapps_env_data", str);
    }

    public static String aCq() {
        return aBZ().getString("aiapps_env_data", "");
    }

    public static void setBoolean(String str, boolean z) {
        aBZ().putBoolean(str, z);
    }

    public static boolean getBoolean(String str, boolean z) {
        return aBZ().getBoolean(str, z);
    }

    private static boolean c(c cVar) {
        return (DEBUG && cVar.isDebug()) || rd(cVar.aws()) || com.baidu.swan.apps.console.debugger.b.aje() || com.baidu.swan.apps.console.debugger.b.ajf() || (aCn() && cVar.awb());
    }

    public static boolean j(com.baidu.swan.apps.u.c.b bVar) {
        return (DEBUG && bVar.isDebug()) || rd(bVar.aws()) || com.baidu.swan.apps.console.debugger.b.aje() || com.baidu.swan.apps.console.debugger.b.ajf() || (aCn() && bVar.awb());
    }

    public static boolean aCr() {
        return com.baidu.swan.apps.console.debugger.b.aje() || com.baidu.swan.apps.console.debugger.b.ajf();
    }

    public static boolean rd(String str) {
        return !TextUtils.isEmpty(str) || e.ajt();
    }

    public static boolean aCs() {
        return getBoolean("aiapps_force_authorized_key", false);
    }

    public static boolean aCt() {
        return getBoolean("aiapps_js_native_switch_key", true);
    }

    public static void fU(boolean z) {
        setBoolean("aiapps_js_native_switch_key", z);
    }

    public static d.f a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ap.a.b bVar2) {
        if (DEBUG && bVar.isDebug()) {
            return d.a.a(bVar, bVar2);
        }
        if (rd(bVar.aws())) {
            return d.e.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.aje()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.ajf()) {
            return com.baidu.swan.apps.console.debugger.b.b.d(bVar);
        }
        return null;
    }

    public static Bundle d(c cVar) {
        if (c(cVar)) {
            b.a aCv = aCv();
            aCv.pc(cVar.getAppId());
            aCv.pf(cVar.awd());
            aCv.ph(cVar.getPage());
            aCv.fm(cVar.isDebug());
            aCv.pi(cVar.awk());
            aCv.G(cVar.awj());
            aCv.pg(cVar.awf());
            aCv.pj(cVar.awl());
            aCv.b(cVar.apD());
            aCv.c(cVar.apE());
            aCv.pk(cVar.awo());
            aCv.pl(cVar.aws());
            aCv.oX("0");
            aCv.iU(cVar.getAppFrameType());
            aCv.iT(cVar.getOrientation());
            if (rd(cVar.aws()) || aCr()) {
                aCv.pd(cVar.getAppId());
            }
            return aCv.toBundle();
        }
        return null;
    }

    public static String k(com.baidu.swan.apps.u.c.b bVar) {
        if (DEBUG && bVar.isDebug()) {
            return d.a.atT().getPath();
        }
        if (rd(bVar.aws())) {
            return d.e.ajg().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.aje()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.ajg().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.ajf()) {
            return com.baidu.swan.apps.console.debugger.b.b.ajg().getPath();
        }
        return "";
    }

    public static void alL() {
        com.baidu.swan.apps.core.d.c amB;
        f adm = com.baidu.swan.apps.v.f.axo().adm();
        if (adm != null && (amB = adm.amB()) != null) {
            amB.alL();
        }
    }

    public static boolean aCu() {
        return aCp() || aCj() || aCk() || aCh() || !aCb() || aCl() || aCm() || aCo() || aCn();
    }

    public static b.a aCv() {
        return ((b.a) ((b.a) ((b.a) new b.a().k(new PMSAppInfo())).pe("小程序测试").pc("10985873").bp(Color.parseColor("#FF308EF0"))).pf("1230000000000000")).pa("小程序简介").oZ("测试服务类目").oY("测试主体信息").pd("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N").oX("1.0").pb("https://b.bdstatic.com/searchbox/mappconsole/image/20180502/1525250801121271.png");
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
