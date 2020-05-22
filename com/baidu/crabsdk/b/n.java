package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes8.dex */
public final class n {
    private static SharedPreferences alb;
    private static SharedPreferences.Editor alc;
    private static long ald = 30000;

    public static void F() {
        alc.putInt("used_count", G() + 1);
        com.baidu.crabsdk.c.c.a(alc, false);
    }

    public static int G() {
        return alb.getInt("used_count", 0);
    }

    public static void clear() {
        if (alc != null) {
            alc.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(alc, false);
        }
    }

    public static void e(Context context) {
        if (alb == null) {
            alb = context.getSharedPreferences("crab_app_life", 0);
        }
        if (alc == null) {
            alc = alb.edit();
        }
    }

    public static void onPause(Context context) {
        e(context);
        if (alb == null || alc == null) {
            return;
        }
        alc.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(alc, false);
    }

    public static void onResume(Context context) {
        e(context);
        if (com.baidu.crabsdk.a.N) {
            return;
        }
        if (alb == null || alc == null) {
            com.baidu.crabsdk.c.a.w("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.dg("MobclickAgent init success!");
        if (System.currentTimeMillis() - alb.getLong("used_last_time", 0L) > ald) {
            F();
            com.baidu.crabsdk.sender.k.Z(context);
        }
    }
}
