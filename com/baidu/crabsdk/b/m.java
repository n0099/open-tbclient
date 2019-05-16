package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes3.dex */
public final class m {
    private static SharedPreferences ZK;
    private static SharedPreferences.Editor ZL;
    private static long ZM = StatisticConfig.MIN_UPLOAD_INTERVAL;

    public static void B() {
        ZL.putInt("used_count", qN() + 1);
        com.baidu.crabsdk.c.c.a(ZL, false);
    }

    public static void clear() {
        if (ZL != null) {
            ZL.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(ZL, false);
        }
    }

    public static void e(Context context) {
        if (ZK == null) {
            ZK = context.getSharedPreferences("crab_app_life", 0);
        }
        if (ZL == null) {
            ZL = ZK.edit();
        }
    }

    public static void onPause(Context context) {
        e(context);
        if (ZK == null || ZL == null) {
            return;
        }
        ZL.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(ZL, false);
    }

    public static void onResume(Context context) {
        e(context);
        if (com.baidu.crabsdk.a.M) {
            return;
        }
        if (ZK == null || ZL == null) {
            com.baidu.crabsdk.c.a.w("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.cf("MobclickAgent init success!");
        if (System.currentTimeMillis() - ZK.getLong("used_last_time", 0L) > ZM) {
            B();
            com.baidu.crabsdk.sender.k.n(context);
        }
    }

    public static int qN() {
        return ZK.getInt("used_count", 0);
    }
}
