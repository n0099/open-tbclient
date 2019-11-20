package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes3.dex */
public final class m {
    private static SharedPreferences JH;
    private static SharedPreferences.Editor JI;
    private static long JJ = StatisticConfig.MIN_UPLOAD_INTERVAL;

    public static void B() {
        JI.putInt("used_count", mp() + 1);
        com.baidu.crabsdk.c.c.a(JI, false);
    }

    public static void clear() {
        if (JI != null) {
            JI.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(JI, false);
        }
    }

    public static void e(Context context) {
        if (JH == null) {
            JH = context.getSharedPreferences("crab_app_life", 0);
        }
        if (JI == null) {
            JI = JH.edit();
        }
    }

    public static int mp() {
        return JH.getInt("used_count", 0);
    }

    public static void onPause(Context context) {
        e(context);
        if (JH == null || JI == null) {
            return;
        }
        JI.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(JI, false);
    }

    public static void onResume(Context context) {
        e(context);
        if (com.baidu.crabsdk.a.M) {
            return;
        }
        if (JH == null || JI == null) {
            com.baidu.crabsdk.c.a.w("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.bu("MobclickAgent init success!");
        if (System.currentTimeMillis() - JH.getLong("used_last_time", 0L) > JJ) {
            B();
            com.baidu.crabsdk.sender.k.n(context);
        }
    }
}
