package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes7.dex */
public final class n {
    private static SharedPreferences aoM;
    private static SharedPreferences.Editor aoN;
    private static long aoO = 30000;

    public static void F() {
        aoN.putInt("used_count", vm() + 1);
        com.baidu.crabsdk.c.c.a(aoN, false);
    }

    public static void clear() {
        if (aoN != null) {
            aoN.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(aoN, false);
        }
    }

    public static void e(Context context) {
        if (aoM == null) {
            aoM = context.getSharedPreferences("crab_app_life", 0);
        }
        if (aoN == null) {
            aoN = aoM.edit();
        }
    }

    public static void onPause(Context context) {
        e(context);
        if (aoM == null || aoN == null) {
            return;
        }
        aoN.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(aoN, false);
    }

    public static void onResume(Context context) {
        e(context);
        if (com.baidu.crabsdk.a.N) {
            return;
        }
        if (aoM == null || aoN == null) {
            com.baidu.crabsdk.c.a.w("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.dC("MobclickAgent init success!");
        if (System.currentTimeMillis() - aoM.getLong("used_last_time", 0L) > aoO) {
            F();
            com.baidu.crabsdk.sender.k.ag(context);
        }
    }

    public static int vm() {
        return aoM.getInt("used_count", 0);
    }
}
