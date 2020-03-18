package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes8.dex */
public final class n {
    private static SharedPreferences RW;
    private static SharedPreferences.Editor RX;
    private static long RY = 30000;

    public static void F() {
        RX.putInt("used_count", G() + 1);
        com.baidu.crabsdk.c.c.a(RX, false);
    }

    public static int G() {
        return RW.getInt("used_count", 0);
    }

    public static void clear() {
        if (RX != null) {
            RX.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(RX, false);
        }
    }

    public static void e(Context context) {
        if (RW == null) {
            RW = context.getSharedPreferences("crab_app_life", 0);
        }
        if (RX == null) {
            RX = RW.edit();
        }
    }

    public static void onPause(Context context) {
        e(context);
        if (RW == null || RX == null) {
            return;
        }
        RX.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(RX, false);
    }

    public static void onResume(Context context) {
        e(context);
        if (com.baidu.crabsdk.a.N) {
            return;
        }
        if (RW == null || RX == null) {
            com.baidu.crabsdk.c.a.w("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.cj("MobclickAgent init success!");
        if (System.currentTimeMillis() - RW.getLong("used_last_time", 0L) > RY) {
            F();
            com.baidu.crabsdk.sender.k.m(context);
        }
    }
}
