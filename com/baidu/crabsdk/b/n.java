package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes8.dex */
public final class n {
    private static SharedPreferences amv;
    private static SharedPreferences.Editor amw;
    private static long amx = 30000;

    public static void F() {
        amw.putInt("used_count", G() + 1);
        com.baidu.crabsdk.c.c.a(amw, false);
    }

    public static int G() {
        return amv.getInt("used_count", 0);
    }

    public static void clear() {
        if (amw != null) {
            amw.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(amw, false);
        }
    }

    public static void e(Context context) {
        if (amv == null) {
            amv = context.getSharedPreferences("crab_app_life", 0);
        }
        if (amw == null) {
            amw = amv.edit();
        }
    }

    public static void onPause(Context context) {
        e(context);
        if (amv == null || amw == null) {
            return;
        }
        amw.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(amw, false);
    }

    public static void onResume(Context context) {
        e(context);
        if (com.baidu.crabsdk.a.N) {
            return;
        }
        if (amv == null || amw == null) {
            com.baidu.crabsdk.c.a.w("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.di("MobclickAgent init success!");
        if (System.currentTimeMillis() - amv.getLong("used_last_time", 0L) > amx) {
            F();
            com.baidu.crabsdk.sender.k.ab(context);
        }
    }
}
