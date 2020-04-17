package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes8.dex */
public final class n {
    private static SharedPreferences akp;
    private static SharedPreferences.Editor akq;
    private static long akr = 30000;

    public static void F() {
        akq.putInt("used_count", G() + 1);
        com.baidu.crabsdk.c.c.a(akq, false);
    }

    public static int G() {
        return akp.getInt("used_count", 0);
    }

    public static void clear() {
        if (akq != null) {
            akq.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(akq, false);
        }
    }

    public static void e(Context context) {
        if (akp == null) {
            akp = context.getSharedPreferences("crab_app_life", 0);
        }
        if (akq == null) {
            akq = akp.edit();
        }
    }

    public static void onPause(Context context) {
        e(context);
        if (akp == null || akq == null) {
            return;
        }
        akq.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(akq, false);
    }

    public static void onResume(Context context) {
        e(context);
        if (com.baidu.crabsdk.a.N) {
            return;
        }
        if (akp == null || akq == null) {
            com.baidu.crabsdk.c.a.w("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.de("MobclickAgent init success!");
        if (System.currentTimeMillis() - akp.getLong("used_last_time", 0L) > akr) {
            F();
            com.baidu.crabsdk.sender.k.m(context);
        }
    }
}
