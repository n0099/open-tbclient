package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes14.dex */
public final class n {
    private static SharedPreferences apm;
    private static SharedPreferences.Editor apn;
    private static long apo = 30000;

    public static void F() {
        apn.putInt("used_count", G() + 1);
        com.baidu.crabsdk.c.c.a(apn, false);
    }

    public static int G() {
        return apm.getInt("used_count", 0);
    }

    public static void clear() {
        if (apn != null) {
            apn.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(apn, false);
        }
    }

    public static void e(Context context) {
        if (apm == null) {
            apm = context.getSharedPreferences("crab_app_life", 0);
        }
        if (apn == null) {
            apn = apm.edit();
        }
    }

    public static void onPause(Context context) {
        e(context);
        if (apm == null || apn == null) {
            return;
        }
        apn.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(apn, false);
    }

    public static void onResume(Context context) {
        e(context);
        if (com.baidu.crabsdk.a.N) {
            return;
        }
        if (apm == null || apn == null) {
            com.baidu.crabsdk.c.a.w("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.ds("MobclickAgent init success!");
        if (System.currentTimeMillis() - apm.getLong("used_last_time", 0L) > apo) {
            F();
            com.baidu.crabsdk.sender.k.m(context);
        }
    }
}
