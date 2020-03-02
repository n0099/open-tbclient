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
/* loaded from: classes11.dex */
public final class a {
    private static com.baidu.swan.apps.storage.c.a bIO;
    private static final boolean DEBUG = b.DEBUG;
    private static final Set<String> bIP = new HashSet();

    static {
        bIP.add("aiapps_websafe_debug_key");
        bIP.add("aiapps_server_domains_debug_key");
        bIP.add("aiapps_use_extension_debug_key");
        bIP.add("aiapps_emit_live_debug_key");
        bIP.add("aiapps_emit_https_debug_key");
        bIP.add("aiapps_emit_wss_debug_key");
        bIP.add("aiapps_load_cts_debug_key");
        bIP.add("aiapps_env_data");
        bIP.add("aiapps_js_native_switch_key");
        bIP.add("aiapps_emit_game_core_debug_key");
        bIP.add("aiapps_emit_game_launch_mode_key");
    }

    public static com.baidu.swan.apps.storage.c.a aal() {
        if (bIO == null) {
            synchronized (a.class) {
                if (bIO == null) {
                    bIO = new com.baidu.swan.apps.storage.c.a("swan_app_debug");
                    bIO.bVJ.addAll(bIP);
                }
            }
        }
        return bIO;
    }

    public static boolean aam() {
        return aal().getBoolean("swan_debug_force_ab", false);
    }

    public static boolean Zs() {
        return aal().getBoolean("swan_debug_forbid_sample", true);
    }

    public static boolean aan() {
        return getBoolean("aiapps_websafe_debug_key", true);
    }

    public static boolean aao() {
        return getBoolean("aiapps_server_domains_debug_key", true);
    }

    public static void dh(boolean z) {
        setBoolean("aiapps_websafe_debug_key", z);
    }

    public static void di(boolean z) {
        setBoolean("aiapps_server_domains_debug_key", z);
    }

    public static boolean aap() {
        return getBoolean("aiapps_close_view_disable_debug_key", false);
    }

    public static boolean aaq() {
        return getBoolean("aiapps_dashboard_enable_debug_key", false);
    }

    public static boolean aar() {
        return getBoolean("swan_game_fps_debug_key", false);
    }

    public static boolean aas() {
        return getBoolean("aiapps_sconsole_scan_mode_debug_key", false);
    }

    public static boolean aat() {
        return getBoolean("aiapps_use_extension_debug_key", false);
    }

    public static void dj(boolean z) {
        setBoolean("aiapps_use_extension_debug_key", z);
    }

    public static boolean aau() {
        return getBoolean("aiapps_use_game_extension_debug_key", false);
    }

    public static boolean aav() {
        return getBoolean("aiapps_emit_live_debug_key", false);
    }

    public static void dk(boolean z) {
        setBoolean("aiapps_emit_live_debug_key", z);
    }

    public static boolean aaw() {
        return getBoolean("aiapps_emit_https_debug_key", false);
    }

    public static void dl(boolean z) {
        setBoolean("aiapps_emit_https_debug_key", z);
    }

    public static boolean aax() {
        return com.baidu.swan.apps.swancore.b.afu();
    }

    public static void dm(boolean z) {
        com.baidu.swan.apps.swancore.b.dW(z);
    }

    public static boolean aay() {
        return getBoolean("aiapps_emit_game_core_debug_key", false);
    }

    public static void dn(boolean z) {
        setBoolean("aiapps_emit_game_core_debug_key", z);
    }

    public static boolean aaz() {
        return getBoolean("aiapps_emit_game_launch_mode_key", false);
    }

    /* renamed from: do  reason: not valid java name */
    public static void m25do(boolean z) {
        setBoolean("aiapps_emit_game_launch_mode_key", z);
    }

    public static boolean aaA() {
        return getBoolean("aiapps_emit_wss_debug_key", false);
    }

    public static void dp(boolean z) {
        setBoolean("aiapps_emit_wss_debug_key", z);
    }

    public static void dq(boolean z) {
        setBoolean("aiapps_load_cts_debug_key", z);
    }

    public static boolean aaB() {
        return getBoolean("aiapps_load_cts_debug_key", false);
    }

    public static void kn(String str) {
        aal().putString("aiapps_env_data", str);
    }

    public static String aaC() {
        return aal().getString("aiapps_env_data", "");
    }

    private static void setBoolean(String str, boolean z) {
        aal().putBoolean(str, z);
    }

    private static boolean getBoolean(String str, boolean z) {
        return aal().getBoolean(str, z);
    }

    private static boolean c(c cVar) {
        return (DEBUG && cVar.isDebug()) || ko(cVar.VY()) || com.baidu.swan.apps.console.debugger.b.LA() || com.baidu.swan.apps.console.debugger.b.LB() || (aaz() && cVar.VH());
    }

    public static boolean k(com.baidu.swan.apps.x.b.b bVar) {
        return (DEBUG && bVar.isDebug()) || ko(bVar.VY()) || com.baidu.swan.apps.console.debugger.b.LA() || com.baidu.swan.apps.console.debugger.b.LB() || (aaz() && bVar.VH());
    }

    public static boolean aaD() {
        return com.baidu.swan.apps.console.debugger.b.LA() || com.baidu.swan.apps.console.debugger.b.LB();
    }

    public static boolean ko(String str) {
        return !TextUtils.isEmpty(str) || e.LP();
    }

    public static boolean aaE() {
        return getBoolean("aiapps_force_authorized_key", false);
    }

    public static boolean aaF() {
        return getBoolean("aiapps_js_native_switch_key", true);
    }

    public static e.f a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.as.a.b bVar2) {
        if (DEBUG && bVar.isDebug()) {
            return e.a.a(bVar, bVar2);
        }
        if (ko(bVar.VY())) {
            return e.C0302e.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.LA()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.d(bVar);
        }
        if (com.baidu.swan.apps.console.debugger.b.LB()) {
            return com.baidu.swan.apps.console.debugger.b.b.d(bVar);
        }
        return null;
    }

    public static Bundle d(c cVar) {
        if (c(cVar)) {
            b.a aaH = aaH();
            aaH.iy(cVar.getAppId());
            aaH.iB(cVar.VJ());
            aaH.iD(cVar.getPage());
            aaH.cM(cVar.isDebug());
            aaH.iE(cVar.VQ());
            aaH.E(cVar.VP());
            aaH.iC(cVar.VL());
            aaH.iF(cVar.VR());
            aaH.b(cVar.QQ());
            aaH.c(cVar.QR());
            aaH.iG(cVar.VU());
            aaH.iH(cVar.VY());
            aaH.it("0");
            aaH.fj(cVar.getAppFrameType());
            aaH.fi(cVar.getOrientation());
            if (ko(cVar.VY()) || aaD()) {
                aaH.iz(cVar.getAppId());
            }
            return aaH.toBundle();
        }
        return null;
    }

    public static String l(com.baidu.swan.apps.x.b.b bVar) {
        if (DEBUG && bVar.isDebug()) {
            return e.a.TP().getPath();
        }
        if (ko(bVar.VY())) {
            return e.C0302e.LC().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.LA()) {
            return com.baidu.swan.apps.console.debugger.adbdebug.a.LC().getPath();
        }
        if (com.baidu.swan.apps.console.debugger.b.LB()) {
            return com.baidu.swan.apps.console.debugger.b.b.LC().getPath();
        }
        return "";
    }

    public static void NF() {
        com.baidu.swan.apps.core.d.b On;
        com.baidu.swan.apps.core.d.e GC = f.WS().GC();
        if (GC != null && (On = GC.On()) != null) {
            On.NF();
        }
    }

    public static boolean aaG() {
        return aaB() || aav() || aaw() || aat() || !aan() || aax() || aay() || aaA() || aaz();
    }

    public static b.a aaH() {
        return ((b.a) ((b.a) ((b.a) new b.a().g(new PMSAppInfo())).iA("小程序测试").iy("10985873").ak(Color.parseColor("#FF308EF0"))).iB("1230000000000000")).iw("小程序简介").iv("测试服务类目").iu("测试主体信息").iz("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N").it("1.0").ix("https://b.bdstatic.com/searchbox/mappconsole/image/20180502/1525250801121271.png");
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
