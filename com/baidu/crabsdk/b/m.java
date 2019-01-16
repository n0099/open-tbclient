package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes6.dex */
public final class m {
    private static SharedPreferences Yq;
    private static SharedPreferences.Editor Yr;
    private static long Ys = StatisticConfig.MIN_UPLOAD_INTERVAL;

    public static void C() {
        Yr.putInt("used_count", D() + 1);
        com.baidu.crabsdk.c.c.a(Yr, false);
    }

    public static int D() {
        return Yq.getInt("used_count", 0);
    }

    public static void clear() {
        if (Yr != null) {
            Yr.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(Yr, false);
        }
    }

    public static void d(Context context) {
        if (Yq == null) {
            Yq = context.getSharedPreferences("crab_app_life", 0);
        }
        if (Yr == null) {
            Yr = Yq.edit();
        }
    }

    public static void onPause(Context context) {
        d(context);
        if (Yq == null || Yr == null) {
            return;
        }
        Yr.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(Yr, false);
    }

    public static void onResume(Context context) {
        d(context);
        if (com.baidu.crabsdk.a.M) {
            return;
        }
        if (Yq == null || Yr == null) {
            com.baidu.crabsdk.c.a.cK("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.cH("MobclickAgent init success!");
        if (System.currentTimeMillis() - Yq.getLong("used_last_time", 0L) > Ys) {
            C();
            com.baidu.crabsdk.sender.h.n(context);
        }
    }
}
