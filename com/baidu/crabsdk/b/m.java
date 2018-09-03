package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes2.dex */
public final class m {
    private static SharedPreferences SS;
    private static SharedPreferences.Editor ST;
    private static long SU = StatisticConfig.MIN_UPLOAD_INTERVAL;

    public static void clear() {
        if (ST != null) {
            ST.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(ST, false);
        }
    }

    public static void d(Context context) {
        if (SS == null) {
            SS = context.getSharedPreferences("crab_app_life", 0);
        }
        if (ST == null) {
            ST = SS.edit();
        }
    }

    public static void onPause(Context context) {
        d(context);
        if (SS == null || ST == null) {
            return;
        }
        ST.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(ST, false);
    }

    public static void onResume(Context context) {
        d(context);
        if (SS == null || ST == null) {
            com.baidu.crabsdk.c.a.ch("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.ce("MobclickAgent init success!");
        if (System.currentTimeMillis() - SS.getLong("used_last_time", 0L) > SU) {
            ST.putInt("used_count", pb() + 1);
            com.baidu.crabsdk.c.c.a(ST, false);
            com.baidu.crabsdk.sender.h.n(context);
        }
    }

    public static int pb() {
        return SS.getInt("used_count", 0);
    }
}
