package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes5.dex */
public final class n {
    private static SharedPreferences apb;
    private static SharedPreferences.Editor apc;
    private static long apd = 30000;

    public static void F() {
        apc.putInt("used_count", G() + 1);
        com.baidu.crabsdk.c.c.a(apc, false);
    }

    public static int G() {
        return apb.getInt("used_count", 0);
    }

    public static void clear() {
        if (apc != null) {
            apc.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(apc, false);
        }
    }

    public static void e(Context context) {
        if (apb == null) {
            apb = context.getSharedPreferences("crab_app_life", 0);
        }
        if (apc == null) {
            apc = apb.edit();
        }
    }

    public static void onPause(Context context) {
        e(context);
        if (apb == null || apc == null) {
            return;
        }
        apc.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(apc, false);
    }

    public static void onResume(Context context) {
        e(context);
        if (com.baidu.crabsdk.a.N) {
            return;
        }
        if (apb == null || apc == null) {
            com.baidu.crabsdk.c.a.w("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.ds("MobclickAgent init success!");
        if (System.currentTimeMillis() - apb.getLong("used_last_time", 0L) > apd) {
            F();
            com.baidu.crabsdk.sender.k.m(context);
        }
    }
}
