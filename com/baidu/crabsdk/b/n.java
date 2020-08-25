package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes6.dex */
public final class n {
    private static SharedPreferences ans;
    private static SharedPreferences.Editor ant;
    private static long anu = 30000;

    public static void F() {
        ant.putInt("used_count", uQ() + 1);
        com.baidu.crabsdk.c.c.a(ant, false);
    }

    public static void clear() {
        if (ant != null) {
            ant.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(ant, false);
        }
    }

    public static void e(Context context) {
        if (ans == null) {
            ans = context.getSharedPreferences("crab_app_life", 0);
        }
        if (ant == null) {
            ant = ans.edit();
        }
    }

    public static void onPause(Context context) {
        e(context);
        if (ans == null || ant == null) {
            return;
        }
        ant.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(ant, false);
    }

    public static void onResume(Context context) {
        e(context);
        if (com.baidu.crabsdk.a.N) {
            return;
        }
        if (ans == null || ant == null) {
            com.baidu.crabsdk.c.a.w("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.ds("MobclickAgent init success!");
        if (System.currentTimeMillis() - ans.getLong("used_last_time", 0L) > anu) {
            F();
            com.baidu.crabsdk.sender.k.ad(context);
        }
    }

    public static int uQ() {
        return ans.getInt("used_count", 0);
    }
}
