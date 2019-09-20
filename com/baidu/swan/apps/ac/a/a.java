package com.baidu.swan.apps.ac.a;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.console.a.d;
import com.baidu.swan.apps.install.e;
import com.baidu.swan.apps.storage.b.f;
import com.baidu.swan.apps.v.b.c;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.UUID;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;

    public static boolean IY() {
        return f.Ob().getBoolean("swan_debug_force_ab", false);
    }

    public static boolean IZ() {
        return getBoolean("aiapps_websafe_debug_key", true);
    }

    public static boolean Ja() {
        return getBoolean("aiapps_server_domains_debug_key", false);
    }

    public static void bF(boolean z) {
        s("aiapps_websafe_debug_key", z);
    }

    public static void bG(boolean z) {
        s("aiapps_server_domains_debug_key", z);
    }

    public static boolean Jb() {
        return getBoolean("aiapps_close_view_disable_debug_key", false);
    }

    public static boolean Jc() {
        return getBoolean("aiapps_sconsole_scan_mode_debug_key", false);
    }

    public static boolean Jd() {
        return getBoolean("aiapps_use_extension_debug_key", false);
    }

    public static void bH(boolean z) {
        s("aiapps_use_extension_debug_key", z);
    }

    public static boolean Je() {
        return getBoolean("aiapps_emit_live_debug_key", false);
    }

    public static void bI(boolean z) {
        s("aiapps_emit_live_debug_key", z);
    }

    public static boolean Jf() {
        return getBoolean("aiapps_emit_https_debug_key", false);
    }

    public static void bJ(boolean z) {
        s("aiapps_emit_https_debug_key", z);
    }

    public static boolean Jg() {
        return getBoolean("aiapps_emit_wss_debug_key", false);
    }

    public static void bK(boolean z) {
        s("aiapps_emit_wss_debug_key", z);
    }

    public static void bL(boolean z) {
        s("aiapps_load_cts_debug_key", z);
    }

    public static boolean Jh() {
        return getBoolean("aiapps_load_cts_debug_key", false);
    }

    public static void gi(String str) {
        f.Ob().putString("aiapps_env_data", str);
    }

    public static String Ji() {
        return f.Ob().getString("aiapps_env_data", "");
    }

    private static void s(String str, boolean z) {
        f.Ob().putBoolean(str, z);
    }

    private static boolean getBoolean(String str, boolean z) {
        return f.Ob().getBoolean(str, z);
    }

    private static boolean b(c cVar) {
        return (DEBUG && cVar.azR) || gj(cVar.azZ);
    }

    public static boolean l(com.baidu.swan.apps.v.b.b bVar) {
        return (DEBUG && bVar.isDebug()) || gj(bVar.FZ());
    }

    public static boolean gj(String str) {
        return !TextUtils.isEmpty(str) || d.yp();
    }

    public static boolean Jj() {
        return getBoolean("aiapps_force_authorized_key", false);
    }

    public static boolean Jk() {
        return getBoolean("aiapps_pay_channel_key", false);
    }

    public static e.g a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.an.a.b bVar2) {
        if (DEBUG && bVar.isDebug()) {
            return e.a.a(bVar, bVar2);
        }
        if (gj(bVar.FZ())) {
            return e.C0160e.j(bVar);
        }
        return null;
    }

    public static boolean d(Context context, c cVar) {
        if (b(cVar)) {
            com.baidu.swan.apps.v.b.b Fw = Fw();
            cVar.Fy().putLong("aiapp_start_timestamp", System.currentTimeMillis());
            Fw.setAppId(cVar.mAppId);
            Fw.eO(cVar.mFrom);
            Fw.setPage(cVar.azQ);
            Fw.setDebug(cVar.azR);
            Fw.eS(cVar.azT);
            Fw.p(cVar.Fy());
            Fw.eP(cVar.azU);
            Fw.eT(cVar.azV);
            Fw.a(cVar.auL);
            Fw.a(cVar.auM);
            Fw.eW(cVar.azW);
            Fw.eX(cVar.azZ);
            Fw.setVersion("0");
            Fw.cs(cVar.azX);
            Fw.setOrientation(cVar.azY);
            SwanAppLauncherActivity.a(context, Fw, UUID.randomUUID().toString());
            return true;
        }
        return false;
    }

    public static String m(com.baidu.swan.apps.v.b.b bVar) {
        if (DEBUG && bVar.isDebug()) {
            return e.a.Ee().getPath();
        }
        if (gj(bVar.FZ())) {
            return e.C0160e.Ef().getPath();
        }
        return "";
    }

    public static com.baidu.swan.apps.v.b.b Fw() {
        com.baidu.swan.apps.v.b.b bVar = new com.baidu.swan.apps.v.b.b();
        bVar.e(new PMSAppInfo());
        bVar.ef("小程序测试");
        bVar.setAppId("10985873");
        bVar.F(Color.parseColor("#FF308EF0"));
        bVar.eO("1230000000000000");
        bVar.eL("小程序简介");
        bVar.eM("测试服务类目");
        bVar.eN("测试主体信息");
        bVar.setAppKey("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N");
        bVar.setVersion("1.0");
        bVar.setIconUrl("https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg");
        return bVar;
    }
}
