package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes5.dex */
public final class n {
    private static SharedPreferences aqC;
    private static SharedPreferences.Editor aqD;
    private static long aqE = 30000;

    public static void F() {
        aqD.putInt("used_count", G() + 1);
        com.baidu.crabsdk.c.c.a(aqD, false);
    }

    public static int G() {
        return aqC.getInt("used_count", 0);
    }

    public static void clear() {
        if (aqD != null) {
            aqD.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(aqD, false);
        }
    }

    public static void e(Context context) {
        if (aqC == null) {
            aqC = context.getSharedPreferences("crab_app_life", 0);
        }
        if (aqD == null) {
            aqD = aqC.edit();
        }
    }

    public static void onPause(Context context) {
        e(context);
        if (aqC == null || aqD == null) {
            return;
        }
        aqD.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(aqD, false);
    }

    public static void onResume(Context context) {
        e(context);
        if (com.baidu.crabsdk.a.N) {
            return;
        }
        if (aqC == null || aqD == null) {
            com.baidu.crabsdk.c.a.w("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.dw("MobclickAgent init success!");
        if (System.currentTimeMillis() - aqC.getLong("used_last_time", 0L) > aqE) {
            F();
            com.baidu.crabsdk.sender.k.m(context);
        }
    }
}
