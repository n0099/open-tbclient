package com.baidu.swan.apps.ac.a;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.console.a.d;
import com.baidu.swan.apps.install.c;
import com.baidu.swan.apps.storage.b.f;
import com.baidu.swan.apps.v.b.b;
import java.util.UUID;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = c.DEBUG;

    public static boolean Gb() {
        return getBoolean("aiapps_websafe_debug_key", true);
    }

    public static boolean Gc() {
        return getBoolean("aiapps_server_domains_debug_key", true);
    }

    public static void bu(boolean z) {
        setBoolean("aiapps_websafe_debug_key", z);
    }

    public static void bv(boolean z) {
        setBoolean("aiapps_server_domains_debug_key", z);
    }

    public static boolean Gd() {
        return getBoolean("aiapps_close_view_disable_debug_key", false);
    }

    public static boolean Ge() {
        return getBoolean("aiapps_sconsole_scan_mode_debug_key", false);
    }

    public static boolean Gf() {
        return getBoolean("aiapps_use_extension_debug_key", false);
    }

    public static void bw(boolean z) {
        setBoolean("aiapps_use_extension_debug_key", z);
    }

    public static boolean Gg() {
        return getBoolean("aiapps_emit_live_debug_key", false);
    }

    public static void bx(boolean z) {
        setBoolean("aiapps_emit_live_debug_key", z);
    }

    public static boolean Gh() {
        return getBoolean("aiapps_emit_https_debug_key", false);
    }

    public static void by(boolean z) {
        setBoolean("aiapps_emit_https_debug_key", z);
    }

    public static void bz(boolean z) {
        setBoolean("aiapps_load_cts_debug_key", z);
    }

    public static boolean Gi() {
        return getBoolean("aiapps_load_cts_debug_key", false);
    }

    private static void setBoolean(String str, boolean z) {
        f.KL().putBoolean(str, z);
    }

    private static boolean getBoolean(String str, boolean z) {
        return f.KL().getBoolean(str, z);
    }

    private static boolean b(com.baidu.swan.apps.v.b.c cVar) {
        return (DEBUG && cVar.axR) || fL(cVar.ayb);
    }

    public static boolean l(b bVar) {
        return (DEBUG && bVar.axR) || fL(bVar.ayb);
    }

    public static boolean fL(String str) {
        return !TextUtils.isEmpty(str) || d.wP();
    }

    public static boolean Gj() {
        return getBoolean("aiapps_force_authorized_key", false);
    }

    public static c.g a(b bVar, com.baidu.swan.apps.an.a.b bVar2) {
        if (DEBUG && bVar.axR) {
            return c.a.a(bVar, bVar2);
        }
        if (fL(bVar.ayb)) {
            return c.e.j(bVar);
        }
        return null;
    }

    public static boolean d(Context context, com.baidu.swan.apps.v.b.c cVar) {
        if (b(cVar)) {
            b DD = DD();
            cVar.DC().putLong("aiapp_start_timestamp", System.currentTimeMillis());
            DD.mAppId = cVar.mAppId;
            DD.axF = cVar.mFrom;
            DD.axH = cVar.axH;
            DD.axR = cVar.axR;
            DD.axQ = cVar.axQ;
            DD.axP = cVar.DC();
            DD.axG = cVar.axG;
            DD.axS = cVar.axS;
            DD.atp = cVar.atp;
            DD.atq = cVar.atq;
            DD.axV = cVar.axV;
            DD.ayb = cVar.ayb;
            DD.mVersion = "0";
            DD.axW = cVar.axW;
            DD.orientation = cVar.ayd;
            SwanAppLauncherActivity.a(context, DD, UUID.randomUUID().toString());
            return true;
        }
        return false;
    }

    public static String m(b bVar) {
        if (DEBUG && bVar.axR) {
            return c.a.Cr().getPath();
        }
        if (fL(bVar.ayb)) {
            return c.e.Cs().getPath();
        }
        return "";
    }

    public static b DD() {
        b bVar = new b();
        bVar.axC = "小程序测试";
        bVar.mAppId = "10985873";
        bVar.axE = Color.parseColor("#FF308EF0");
        bVar.axF = "1230000000000000";
        bVar.mDescription = "小程序简介";
        bVar.axM = "测试服务类目";
        bVar.axN = "测试主体信息";
        bVar.mAppKey = "CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N";
        bVar.mVersion = "1.0";
        bVar.axD = "https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg";
        return bVar;
    }
}
