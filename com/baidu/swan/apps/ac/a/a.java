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

    public static boolean NT() {
        return f.ST().getBoolean("swan_debug_force_ab", false);
    }

    public static boolean NU() {
        return getBoolean("aiapps_websafe_debug_key", true);
    }

    public static boolean NV() {
        return getBoolean("aiapps_server_domains_debug_key", false);
    }

    public static void bW(boolean z) {
        v("aiapps_websafe_debug_key", z);
    }

    public static void bX(boolean z) {
        v("aiapps_server_domains_debug_key", z);
    }

    public static boolean NW() {
        return getBoolean("aiapps_close_view_disable_debug_key", false);
    }

    public static boolean NX() {
        return getBoolean("aiapps_sconsole_scan_mode_debug_key", false);
    }

    public static boolean NY() {
        return getBoolean("aiapps_use_extension_debug_key", false);
    }

    public static void bY(boolean z) {
        v("aiapps_use_extension_debug_key", z);
    }

    public static boolean NZ() {
        return getBoolean("aiapps_emit_live_debug_key", false);
    }

    public static void bZ(boolean z) {
        v("aiapps_emit_live_debug_key", z);
    }

    public static boolean Oa() {
        return getBoolean("aiapps_emit_https_debug_key", false);
    }

    public static void ca(boolean z) {
        v("aiapps_emit_https_debug_key", z);
    }

    public static boolean Ob() {
        return getBoolean("aiapps_emit_wss_debug_key", false);
    }

    public static void cb(boolean z) {
        v("aiapps_emit_wss_debug_key", z);
    }

    public static void cc(boolean z) {
        v("aiapps_load_cts_debug_key", z);
    }

    public static boolean Oc() {
        return getBoolean("aiapps_load_cts_debug_key", false);
    }

    public static void gN(String str) {
        f.ST().putString("aiapps_env_data", str);
    }

    public static String Od() {
        return f.ST().getString("aiapps_env_data", "");
    }

    private static void v(String str, boolean z) {
        f.ST().putBoolean(str, z);
    }

    private static boolean getBoolean(String str, boolean z) {
        return f.ST().getBoolean(str, z);
    }

    private static boolean b(c cVar) {
        return (DEBUG && cVar.aSN) || gO(cVar.aSV);
    }

    public static boolean l(com.baidu.swan.apps.v.b.b bVar) {
        return (DEBUG && bVar.isDebug()) || gO(bVar.KU());
    }

    public static boolean gO(String str) {
        return !TextUtils.isEmpty(str) || d.Dl();
    }

    public static boolean Oe() {
        return getBoolean("aiapps_force_authorized_key", false);
    }

    public static boolean Of() {
        return getBoolean("aiapps_pay_channel_key", false);
    }

    public static e.g a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.an.a.b bVar2) {
        if (DEBUG && bVar.isDebug()) {
            return e.a.a(bVar, bVar2);
        }
        if (gO(bVar.KU())) {
            return e.C0192e.j(bVar);
        }
        return null;
    }

    public static boolean d(Context context, c cVar) {
        if (b(cVar)) {
            com.baidu.swan.apps.v.b.b Kr = Kr();
            cVar.Kt().putLong("aiapp_start_timestamp", System.currentTimeMillis());
            Kr.setAppId(cVar.mAppId);
            Kr.fv(cVar.mFrom);
            Kr.setPage(cVar.aSM);
            Kr.setDebug(cVar.aSN);
            Kr.fz(cVar.aSP);
            Kr.p(cVar.Kt());
            Kr.fw(cVar.aSQ);
            Kr.fA(cVar.aSR);
            Kr.a(cVar.aNK);
            Kr.a(cVar.aNL);
            Kr.fD(cVar.aSS);
            Kr.fE(cVar.aSV);
            Kr.setVersion("0");
            Kr.m19do(cVar.aST);
            Kr.setOrientation(cVar.aSU);
            SwanAppLauncherActivity.a(context, Kr, UUID.randomUUID().toString());
            return true;
        }
        return false;
    }

    public static String m(com.baidu.swan.apps.v.b.b bVar) {
        if (DEBUG && bVar.isDebug()) {
            return e.a.IZ().getPath();
        }
        if (gO(bVar.KU())) {
            return e.C0192e.Ja().getPath();
        }
        return "";
    }

    public static com.baidu.swan.apps.v.b.b Kr() {
        com.baidu.swan.apps.v.b.b bVar = new com.baidu.swan.apps.v.b.b();
        bVar.e(new PMSAppInfo());
        bVar.eM("小程序测试");
        bVar.setAppId("10985873");
        bVar.X(Color.parseColor("#FF308EF0"));
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
