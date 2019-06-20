package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes3.dex */
public final class m {
    private static SharedPreferences ZJ;
    private static SharedPreferences.Editor ZK;
    private static long ZL = StatisticConfig.MIN_UPLOAD_INTERVAL;

    public static void B() {
        ZK.putInt("used_count", qN() + 1);
        com.baidu.crabsdk.c.c.a(ZK, false);
    }

    public static void clear() {
        if (ZK != null) {
            ZK.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(ZK, false);
        }
    }

    public static void e(Context context) {
        if (ZJ == null) {
            ZJ = context.getSharedPreferences("crab_app_life", 0);
        }
        if (ZK == null) {
            ZK = ZJ.edit();
        }
    }

    public static void onPause(Context context) {
        e(context);
        if (ZJ == null || ZK == null) {
            return;
        }
        ZK.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(ZK, false);
    }

    public static void onResume(Context context) {
        e(context);
        if (com.baidu.crabsdk.a.M) {
            return;
        }
        if (ZJ == null || ZK == null) {
            com.baidu.crabsdk.c.a.w("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.cf("MobclickAgent init success!");
        if (System.currentTimeMillis() - ZJ.getLong("used_last_time", 0L) > ZL) {
            B();
            com.baidu.crabsdk.sender.k.n(context);
        }
    }

    public static int qN() {
        return ZJ.getInt("used_count", 0);
    }
}
