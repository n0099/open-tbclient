package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes8.dex */
public final class n {
    private static SharedPreferences anW;
    private static SharedPreferences.Editor anX;
    private static long anY = 30000;

    public static void F() {
        anX.putInt("used_count", ve() + 1);
        com.baidu.crabsdk.c.c.a(anX, false);
    }

    public static void clear() {
        if (anX != null) {
            anX.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(anX, false);
        }
    }

    public static void e(Context context) {
        if (anW == null) {
            anW = context.getSharedPreferences("crab_app_life", 0);
        }
        if (anX == null) {
            anX = anW.edit();
        }
    }

    public static void onPause(Context context) {
        e(context);
        if (anW == null || anX == null) {
            return;
        }
        anX.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(anX, false);
    }

    public static void onResume(Context context) {
        e(context);
        if (com.baidu.crabsdk.a.N) {
            return;
        }
        if (anW == null || anX == null) {
            com.baidu.crabsdk.c.a.w("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.dv("MobclickAgent init success!");
        if (System.currentTimeMillis() - anW.getLong("used_last_time", 0L) > anY) {
            F();
            com.baidu.crabsdk.sender.k.ad(context);
        }
    }

    public static int ve() {
        return anW.getInt("used_count", 0);
    }
}
