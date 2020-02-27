package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes8.dex */
public final class m {
    private static SharedPreferences RU;
    private static SharedPreferences.Editor RV;
    private static long RW = 30000;

    public static void B() {
        RV.putInt("used_count", oi() + 1);
        com.baidu.crabsdk.c.c.a(RV, false);
    }

    public static void clear() {
        if (RV != null) {
            RV.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(RV, false);
        }
    }

    public static void e(Context context) {
        if (RU == null) {
            RU = context.getSharedPreferences("crab_app_life", 0);
        }
        if (RV == null) {
            RV = RU.edit();
        }
    }

    public static int oi() {
        return RU.getInt("used_count", 0);
    }

    public static void onPause(Context context) {
        e(context);
        if (RU == null || RV == null) {
            return;
        }
        RV.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(RV, false);
    }

    public static void onResume(Context context) {
        e(context);
        if (com.baidu.crabsdk.a.M) {
            return;
        }
        if (RU == null || RV == null) {
            com.baidu.crabsdk.c.a.w("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.cj("MobclickAgent init success!");
        if (System.currentTimeMillis() - RU.getLong("used_last_time", 0L) > RW) {
            B();
            com.baidu.crabsdk.sender.k.n(context);
        }
    }
}
