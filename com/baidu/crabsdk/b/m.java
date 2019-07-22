package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes3.dex */
public final class m {
    private static SharedPreferences aae;
    private static SharedPreferences.Editor aaf;
    private static long aag = StatisticConfig.MIN_UPLOAD_INTERVAL;

    public static void B() {
        aaf.putInt("used_count", rk() + 1);
        com.baidu.crabsdk.c.c.a(aaf, false);
    }

    public static void clear() {
        if (aaf != null) {
            aaf.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(aaf, false);
        }
    }

    public static void e(Context context) {
        if (aae == null) {
            aae = context.getSharedPreferences("crab_app_life", 0);
        }
        if (aaf == null) {
            aaf = aae.edit();
        }
    }

    public static void onPause(Context context) {
        e(context);
        if (aae == null || aaf == null) {
            return;
        }
        aaf.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(aaf, false);
    }

    public static void onResume(Context context) {
        e(context);
        if (com.baidu.crabsdk.a.M) {
            return;
        }
        if (aae == null || aaf == null) {
            com.baidu.crabsdk.c.a.w("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.ch("MobclickAgent init success!");
        if (System.currentTimeMillis() - aae.getLong("used_last_time", 0L) > aag) {
            B();
            com.baidu.crabsdk.sender.k.aw(context);
        }
    }

    public static int rk() {
        return aae.getInt("used_count", 0);
    }
}
