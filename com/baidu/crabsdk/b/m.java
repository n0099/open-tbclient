package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes2.dex */
public final class m {
    private static SharedPreferences SV;
    private static SharedPreferences.Editor SW;
    private static long SX = StatisticConfig.MIN_UPLOAD_INTERVAL;

    public static void clear() {
        if (SW != null) {
            SW.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(SW, false);
        }
    }

    public static void d(Context context) {
        if (SV == null) {
            SV = context.getSharedPreferences("crab_app_life", 0);
        }
        if (SW == null) {
            SW = SV.edit();
        }
    }

    public static void onPause(Context context) {
        d(context);
        if (SV == null || SW == null) {
            return;
        }
        SW.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(SW, false);
    }

    public static void onResume(Context context) {
        d(context);
        if (SV == null || SW == null) {
            com.baidu.crabsdk.c.a.cg("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.cd("MobclickAgent init success!");
        if (System.currentTimeMillis() - SV.getLong("used_last_time", 0L) > SX) {
            SW.putInt("used_count", pa() + 1);
            com.baidu.crabsdk.c.c.a(SW, false);
            com.baidu.crabsdk.sender.h.n(context);
        }
    }

    public static int pa() {
        return SV.getInt("used_count", 0);
    }
}
