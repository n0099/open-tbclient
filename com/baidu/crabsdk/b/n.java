package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes8.dex */
public final class n {
    private static SharedPreferences akv;
    private static SharedPreferences.Editor akw;
    private static long akx = 30000;

    public static void F() {
        akw.putInt("used_count", G() + 1);
        com.baidu.crabsdk.c.c.a(akw, false);
    }

    public static int G() {
        return akv.getInt("used_count", 0);
    }

    public static void clear() {
        if (akw != null) {
            akw.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(akw, false);
        }
    }

    public static void e(Context context) {
        if (akv == null) {
            akv = context.getSharedPreferences("crab_app_life", 0);
        }
        if (akw == null) {
            akw = akv.edit();
        }
    }

    public static void onPause(Context context) {
        e(context);
        if (akv == null || akw == null) {
            return;
        }
        akw.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(akw, false);
    }

    public static void onResume(Context context) {
        e(context);
        if (com.baidu.crabsdk.a.N) {
            return;
        }
        if (akv == null || akw == null) {
            com.baidu.crabsdk.c.a.w("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.de("MobclickAgent init success!");
        if (System.currentTimeMillis() - akv.getLong("used_last_time", 0L) > akx) {
            F();
            com.baidu.crabsdk.sender.k.m(context);
        }
    }
}
