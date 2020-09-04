package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes6.dex */
public final class n {
    private static SharedPreferences anu;
    private static SharedPreferences.Editor anv;
    private static long anw = 30000;

    public static void F() {
        anv.putInt("used_count", uQ() + 1);
        com.baidu.crabsdk.c.c.a(anv, false);
    }

    public static void clear() {
        if (anv != null) {
            anv.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(anv, false);
        }
    }

    public static void e(Context context) {
        if (anu == null) {
            anu = context.getSharedPreferences("crab_app_life", 0);
        }
        if (anv == null) {
            anv = anu.edit();
        }
    }

    public static void onPause(Context context) {
        e(context);
        if (anu == null || anv == null) {
            return;
        }
        anv.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(anv, false);
    }

    public static void onResume(Context context) {
        e(context);
        if (com.baidu.crabsdk.a.N) {
            return;
        }
        if (anu == null || anv == null) {
            com.baidu.crabsdk.c.a.w("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.dt("MobclickAgent init success!");
        if (System.currentTimeMillis() - anu.getLong("used_last_time", 0L) > anw) {
            F();
            com.baidu.crabsdk.sender.k.ad(context);
        }
    }

    public static int uQ() {
        return anu.getInt("used_count", 0);
    }
}
