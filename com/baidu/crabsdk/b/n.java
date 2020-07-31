package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes12.dex */
public final class n {
    private static SharedPreferences amq;
    private static SharedPreferences.Editor amr;
    private static long ams = 30000;

    public static void F() {
        amr.putInt("used_count", G() + 1);
        com.baidu.crabsdk.c.c.a(amr, false);
    }

    public static int G() {
        return amq.getInt("used_count", 0);
    }

    public static void clear() {
        if (amr != null) {
            amr.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(amr, false);
        }
    }

    public static void e(Context context) {
        if (amq == null) {
            amq = context.getSharedPreferences("crab_app_life", 0);
        }
        if (amr == null) {
            amr = amq.edit();
        }
    }

    public static void onPause(Context context) {
        e(context);
        if (amq == null || amr == null) {
            return;
        }
        amr.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(amr, false);
    }

    public static void onResume(Context context) {
        e(context);
        if (com.baidu.crabsdk.a.N) {
            return;
        }
        if (amq == null || amr == null) {
            com.baidu.crabsdk.c.a.w("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.dh("MobclickAgent init success!");
        if (System.currentTimeMillis() - amq.getLong("used_last_time", 0L) > ams) {
            F();
            com.baidu.crabsdk.sender.k.ab(context);
        }
    }
}
