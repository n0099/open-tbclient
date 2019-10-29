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

    public static boolean NS() {
        return f.SR().getBoolean("swan_debug_force_ab", false);
    }

    public static boolean NT() {
        return getBoolean("aiapps_websafe_debug_key", true);
    }

    public static boolean NU() {
        return getBoolean("aiapps_server_domains_debug_key", false);
    }

    public static void bW(boolean z) {
        v("aiapps_websafe_debug_key", z);
    }

    public static void bX(boolean z) {
        v("aiapps_server_domains_debug_key", z);
    }

    public static boolean NV() {
        return getBoolean("aiapps_close_view_disable_debug_key", false);
    }

    public static boolean NW() {
        return getBoolean("aiapps_sconsole_scan_mode_debug_key", false);
    }

    public static boolean NX() {
        return getBoolean("aiapps_use_extension_debug_key", false);
    }

    public static void bY(boolean z) {
        v("aiapps_use_extension_debug_key", z);
    }

    public static boolean NY() {
        return getBoolean("aiapps_emit_live_debug_key", false);
    }

    public static void bZ(boolean z) {
        v("aiapps_emit_live_debug_key", z);
    }

    public static boolean NZ() {
        return getBoolean("aiapps_emit_https_debug_key", false);
    }

    public static void ca(boolean z) {
        v("aiapps_emit_https_debug_key", z);
    }

    public static boolean Oa() {
        return getBoolean("aiapps_emit_wss_debug_key", false);
    }

    public static void cb(boolean z) {
        v("aiapps_emit_wss_debug_key", z);
    }

    public static void cc(boolean z) {
        v("aiapps_load_cts_debug_key", z);
    }

    public static boolean Ob() {
        return getBoolean("aiapps_load_cts_debug_key", false);
    }

    public static void gN(String str) {
        f.SR().putString("aiapps_env_data", str);
    }

    public static String Oc() {
        return f.SR().getString("aiapps_env_data", "");
    }

    private static void v(String str, boolean z) {
        f.SR().putBoolean(str, z);
    }

    private static boolean getBoolean(String str, boolean z) {
        return f.SR().getBoolean(str, z);
    }

    private static boolean b(c cVar) {
        return (DEBUG && cVar.aTf) || gO(cVar.aTn);
    }

    public static boolean l(com.baidu.swan.apps.v.b.b bVar) {
        return (DEBUG && bVar.isDebug()) || gO(bVar.KT());
    }

    public static boolean gO(String str) {
        return !TextUtils.isEmpty(str) || d.Dk();
    }

    public static boolean Od() {
        return getBoolean("aiapps_force_authorized_key", false);
    }

    public static boolean Oe() {
        return getBoolean("aiapps_pay_channel_key", false);
    }

    public static e.g a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.an.a.b bVar2) {
        if (DEBUG && bVar.isDebug()) {
            return e.a.a(bVar, bVar2);
        }
        if (gO(bVar.KT())) {
            return e.C0192e.j(bVar);
        }
        return null;
    }

    public static boolean d(Context context, c cVar) {
        if (b(cVar)) {
            com.baidu.swan.apps.v.b.b Kq = Kq();
            cVar.Ks().putLong("aiapp_start_timestamp", System.currentTimeMillis());
            Kq.setAppId(cVar.mAppId);
            Kq.fv(cVar.mFrom);
            Kq.setPage(cVar.aTe);
            Kq.setDebug(cVar.aTf);
            Kq.fz(cVar.aTh);
            Kq.p(cVar.Ks());
            Kq.fw(cVar.aTi);
            Kq.fA(cVar.aTj);
            Kq.a(cVar.aOc);
            Kq.a(cVar.aOd);
            Kq.fD(cVar.aTk);
            Kq.fE(cVar.aTn);
            Kq.setVersion("0");
            Kq.m19do(cVar.aTl);
            Kq.setOrientation(cVar.aTm);
            SwanAppLauncherActivity.a(context, Kq, UUID.randomUUID().toString());
            return true;
        }
        return false;
    }

    public static String m(com.baidu.swan.apps.v.b.b bVar) {
        if (DEBUG && bVar.isDebug()) {
            return e.a.IY().getPath();
        }
        if (gO(bVar.KT())) {
            return e.C0192e.IZ().getPath();
        }
        return "";
    }

    public static com.baidu.swan.apps.v.b.b Kq() {
        com.baidu.swan.apps.v.b.b bVar = new com.baidu.swan.apps.v.b.b();
        bVar.e(new PMSAppInfo());
        bVar.eM("小程序测试");
        bVar.setAppId("10985873");
        bVar.Y(Color.parseColor("#FF308EF0"));
        bVar.fv("1230000000000000");
        bVar.fs("小程序简介");
        bVar.ft("测试服务类目");
        bVar.fu("测试主体信息");
        bVar.setAppKey("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N");
        bVar.setVersion("1.0");
        bVar.setIconUrl("https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg");
        return bVar;
    }
}
