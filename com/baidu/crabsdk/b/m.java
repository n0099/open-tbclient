package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes6.dex */
public final class m {
    private static SharedPreferences Yh;
    private static SharedPreferences.Editor Yi;
    private static long Yj = StatisticConfig.MIN_UPLOAD_INTERVAL;

    public static void C() {
        Yi.putInt("used_count", rr() + 1);
        com.baidu.crabsdk.c.c.a(Yi, false);
    }

    public static void clear() {
        if (Yi != null) {
            Yi.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(Yi, false);
        }
    }

    public static void d(Context context) {
        if (Yh == null) {
            Yh = context.getSharedPreferences("crab_app_life", 0);
        }
        if (Yi == null) {
            Yi = Yh.edit();
        }
    }

    public static void onPause(Context context) {
        d(context);
        if (Yh == null || Yi == null) {
            return;
        }
        Yi.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(Yi, false);
    }

    public static void onResume(Context context) {
        d(context);
        if (com.baidu.crabsdk.a.M) {
            return;
        }
        if (Yh == null || Yi == null) {
            com.baidu.crabsdk.c.a.cJ("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.cG("MobclickAgent init success!");
        if (System.currentTimeMillis() - Yh.getLong("used_last_time", 0L) > Yj) {
            C();
            com.baidu.crabsdk.sender.h.n(context);
        }
    }

    public static int rr() {
        return Yh.getInt("used_count", 0);
    }
}
