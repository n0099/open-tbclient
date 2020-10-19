package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes11.dex */
public final class n {
    private static SharedPreferences aoF;
    private static SharedPreferences.Editor aoG;
    private static long aoH = 30000;

    public static void F() {
        aoG.putInt("used_count", vn() + 1);
        com.baidu.crabsdk.c.c.a(aoG, false);
    }

    public static void clear() {
        if (aoG != null) {
            aoG.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(aoG, false);
        }
    }

    public static void e(Context context) {
        if (aoF == null) {
            aoF = context.getSharedPreferences("crab_app_life", 0);
        }
        if (aoG == null) {
            aoG = aoF.edit();
        }
    }

    public static void onPause(Context context) {
        e(context);
        if (aoF == null || aoG == null) {
            return;
        }
        aoG.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(aoG, false);
    }

    public static void onResume(Context context) {
        e(context);
        if (com.baidu.crabsdk.a.N) {
            return;
        }
        if (aoF == null || aoG == null) {
            com.baidu.crabsdk.c.a.w("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.dA("MobclickAgent init success!");
        if (System.currentTimeMillis() - aoF.getLong("used_last_time", 0L) > aoH) {
            F();
            com.baidu.crabsdk.sender.k.ag(context);
        }
    }

    public static int vn() {
        return aoF.getInt("used_count", 0);
    }
}
