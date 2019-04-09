package com.baidu.swan.apps.ac.a;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.console.a.d;
import com.baidu.swan.apps.install.c;
import com.baidu.swan.apps.storage.b.f;
import com.baidu.swan.apps.v.b.c;
import java.util.UUID;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;

    public static boolean FZ() {
        return getBoolean("aiapps_websafe_debug_key", true);
    }

    public static boolean Ga() {
        return getBoolean("aiapps_server_domains_debug_key", true);
    }

    public static void bu(boolean z) {
        setBoolean("aiapps_websafe_debug_key", z);
    }

    public static void bv(boolean z) {
        setBoolean("aiapps_server_domains_debug_key", z);
    }

    public static boolean Gb() {
        return getBoolean("aiapps_close_view_disable_debug_key", false);
    }

    public static boolean Gc() {
        return getBoolean("aiapps_sconsole_scan_mode_debug_key", false);
    }

    public static boolean Gd() {
        return getBoolean("aiapps_use_extension_debug_key", false);
    }

    public static void bw(boolean z) {
        setBoolean("aiapps_use_extension_debug_key", z);
    }

    public static boolean Ge() {
        return getBoolean("aiapps_emit_live_debug_key", false);
    }

    public static void bx(boolean z) {
        setBoolean("aiapps_emit_live_debug_key", z);
    }

    public static boolean Gf() {
        return getBoolean("aiapps_emit_https_debug_key", false);
    }

    public static void by(boolean z) {
        setBoolean("aiapps_emit_https_debug_key", z);
    }

    public static void bz(boolean z) {
        setBoolean("aiapps_load_cts_debug_key", z);
    }

    public static boolean Gg() {
        return getBoolean("aiapps_load_cts_debug_key", false);
    }

    private static void setBoolean(String str, boolean z) {
        f.KJ().putBoolean(str, z);
    }

    private static boolean getBoolean(String str, boolean z) {
        return f.KJ().getBoolean(str, z);
    }

    private static boolean b(c cVar) {
        return (DEBUG && cVar.axW) || fM(cVar.ayg);
    }

    public static boolean l(com.baidu.swan.apps.v.b.b bVar) {
        return (DEBUG && bVar.axW) || fM(bVar.ayg);
    }

    public static boolean fM(String str) {
        return !TextUtils.isEmpty(str) || d.wO();
    }

    public static boolean Gh() {
        return getBoolean("aiapps_force_authorized_key", false);
    }

    public static c.g a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.an.a.b bVar2) {
        if (DEBUG && bVar.axW) {
            return c.a.a(bVar, bVar2);
        }
        if (fM(bVar.ayg)) {
            return c.e.j(bVar);
        }
        return null;
    }

    public static boolean d(Context context, com.baidu.swan.apps.v.b.c cVar) {
        if (b(cVar)) {
            com.baidu.swan.apps.v.b.b DB = DB();
            cVar.DA().putLong("aiapp_start_timestamp", System.currentTimeMillis());
            DB.mAppId = cVar.mAppId;
            DB.axK = cVar.mFrom;
            DB.axM = cVar.axM;
            DB.axW = cVar.axW;
            DB.axV = cVar.axV;
            DB.axU = cVar.DA();
            DB.axL = cVar.axL;
            DB.axX = cVar.axX;
            DB.atv = cVar.atv;
            DB.atw = cVar.atw;
            DB.aya = cVar.aya;
            DB.ayg = cVar.ayg;
            DB.mVersion = "0";
            DB.ayb = cVar.ayb;
            DB.orientation = cVar.ayi;
            SwanAppLauncherActivity.a(context, DB, UUID.randomUUID().toString());
            return true;
        }
        return false;
    }

    public static String m(com.baidu.swan.apps.v.b.b bVar) {
        if (DEBUG && bVar.axW) {
            return c.a.Cp().getPath();
        }
        if (fM(bVar.ayg)) {
            return c.e.Cq().getPath();
        }
        return "";
    }

    public static com.baidu.swan.apps.v.b.b DB() {
        com.baidu.swan.apps.v.b.b bVar = new com.baidu.swan.apps.v.b.b();
        bVar.axH = "小程序测试";
        bVar.mAppId = "10985873";
        bVar.axJ = Color.parseColor("#FF308EF0");
        bVar.axK = "1230000000000000";
        bVar.mDescription = "小程序简介";
        bVar.axR = "测试服务类目";
        bVar.axS = "测试主体信息";
        bVar.mAppKey = "CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N";
        bVar.mVersion = "1.0";
        bVar.axI = "https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg";
        return bVar;
    }
}
