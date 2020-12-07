package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes8.dex */
public final class n {
    private static SharedPreferences apE;
    private static SharedPreferences.Editor apF;
    private static long apG = 30000;

    public static void F() {
        apF.putInt("used_count", vb() + 1);
        com.baidu.crabsdk.c.c.a(apF, false);
    }

    public static void clear() {
        if (apF != null) {
            apF.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(apF, false);
        }
    }

    public static void e(Context context) {
        if (apE == null) {
            apE = context.getSharedPreferences("crab_app_life", 0);
        }
        if (apF == null) {
            apF = apE.edit();
        }
    }

    public static void onPause(Context context) {
        e(context);
        if (apE == null || apF == null) {
            return;
        }
        apF.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(apF, false);
    }

    public static void onResume(Context context) {
        e(context);
        if (com.baidu.crabsdk.a.N) {
            return;
        }
        if (apE == null || apF == null) {
            com.baidu.crabsdk.c.a.w("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.dE("MobclickAgent init success!");
        if (System.currentTimeMillis() - apE.getLong("used_last_time", 0L) > apG) {
            F();
            com.baidu.crabsdk.sender.k.ah(context);
        }
    }

    public static int vb() {
        return apE.getInt("used_count", 0);
    }
}
