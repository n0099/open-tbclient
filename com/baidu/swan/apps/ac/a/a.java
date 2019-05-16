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

    public static boolean Ih() {
        return f.Ni().getBoolean("swan_debug_force_ab", false);
    }

    public static boolean Ii() {
        return getBoolean("aiapps_websafe_debug_key", true);
    }

    public static boolean Ij() {
        return getBoolean("aiapps_server_domains_debug_key", false);
    }

    public static void bC(boolean z) {
        setBoolean("aiapps_websafe_debug_key", z);
    }

    public static void bD(boolean z) {
        setBoolean("aiapps_server_domains_debug_key", z);
    }

    public static boolean Ik() {
        return getBoolean("aiapps_close_view_disable_debug_key", false);
    }

    public static boolean Il() {
        return getBoolean("aiapps_sconsole_scan_mode_debug_key", false);
    }

    public static boolean Im() {
        return getBoolean("aiapps_use_extension_debug_key", false);
    }

    public static void bE(boolean z) {
        setBoolean("aiapps_use_extension_debug_key", z);
    }

    public static boolean In() {
        return getBoolean("aiapps_emit_live_debug_key", false);
    }

    public static void bF(boolean z) {
        setBoolean("aiapps_emit_live_debug_key", z);
    }

    public static boolean Io() {
        return getBoolean("aiapps_emit_https_debug_key", false);
    }

    public static void bG(boolean z) {
        setBoolean("aiapps_emit_https_debug_key", z);
    }

    public static boolean Ip() {
        return getBoolean("aiapps_emit_wss_debug_key", false);
    }

    public static void bH(boolean z) {
        setBoolean("aiapps_emit_wss_debug_key", z);
    }

    public static void bI(boolean z) {
        setBoolean("aiapps_load_cts_debug_key", z);
    }

    public static boolean Iq() {
        return getBoolean("aiapps_load_cts_debug_key", false);
    }

    public static void gb(String str) {
        f.Ni().putString("aiapps_env_data", str);
    }

    public static String Ir() {
        return f.Ni().getString("aiapps_env_data", "");
    }

    private static void setBoolean(String str, boolean z) {
        f.Ni().putBoolean(str, z);
    }

    private static boolean getBoolean(String str, boolean z) {
        return f.Ni().getBoolean(str, z);
    }

    private static boolean b(c cVar) {
        return (DEBUG && cVar.ayM) || gc(cVar.ayU);
    }

    public static boolean l(com.baidu.swan.apps.v.b.b bVar) {
        return (DEBUG && bVar.isDebug()) || gc(bVar.Fl());
    }

    public static boolean gc(String str) {
        return !TextUtils.isEmpty(str) || d.xG();
    }

    public static boolean Is() {
        return getBoolean("aiapps_force_authorized_key", false);
    }

    public static boolean It() {
        return getBoolean("aiapps_pay_channel_key", false);
    }

    public static e.g a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.an.a.b bVar2) {
        if (DEBUG && bVar.isDebug()) {
            return e.a.a(bVar, bVar2);
        }
        if (gc(bVar.Fl())) {
            return e.C0149e.j(bVar);
        }
        return null;
    }

    public static boolean d(Context context, c cVar) {
        if (b(cVar)) {
            com.baidu.swan.apps.v.b.b EI = EI();
            cVar.EK().putLong("aiapp_start_timestamp", System.currentTimeMillis());
            EI.setAppId(cVar.mAppId);
            EI.eI(cVar.mFrom);
            EI.setPage(cVar.ayL);
            EI.setDebug(cVar.ayM);
            EI.eM(cVar.ayO);
            EI.p(cVar.EK());
            EI.eJ(cVar.ayP);
            EI.eN(cVar.ayQ);
            EI.a(cVar.atK);
            EI.a(cVar.atL);
            EI.eQ(cVar.ayR);
            EI.eR(cVar.ayU);
            EI.setVersion("0");
            EI.cr(cVar.ayS);
            EI.setOrientation(cVar.ayT);
            SwanAppLauncherActivity.a(context, EI, UUID.randomUUID().toString());
            return true;
        }
        return false;
    }

    public static String m(com.baidu.swan.apps.v.b.b bVar) {
        if (DEBUG && bVar.isDebug()) {
            return e.a.Dr().getPath();
        }
        if (gc(bVar.Fl())) {
            return e.C0149e.Ds().getPath();
        }
        return "";
    }

    public static com.baidu.swan.apps.v.b.b EI() {
        com.baidu.swan.apps.v.b.b bVar = new com.baidu.swan.apps.v.b.b();
        bVar.e(new PMSAppInfo());
        bVar.dZ("小程序测试");
        bVar.setAppId("10985873");
        bVar.F(Color.parseColor("#FF308EF0"));
        bVar.eI("1230000000000000");
        bVar.eF("小程序简介");
        bVar.eG("测试服务类目");
        bVar.eH("测试主体信息");
        bVar.setAppKey("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N");
        bVar.setVersion("1.0");
        bVar.setIconUrl("https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg");
        return bVar;
    }
}
