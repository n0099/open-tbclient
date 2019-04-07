package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes3.dex */
public final class m {
    private static SharedPreferences abT;
    private static SharedPreferences.Editor abU;
    private static long abV = StatisticConfig.MIN_UPLOAD_INTERVAL;

    public static void B() {
        abU.putInt("used_count", rS() + 1);
        com.baidu.crabsdk.c.c.a(abU, false);
    }

    public static void clear() {
        if (abU != null) {
            abU.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(abU, false);
        }
    }

    public static void e(Context context) {
        if (abT == null) {
            abT = context.getSharedPreferences("crab_app_life", 0);
        }
        if (abU == null) {
            abU = abT.edit();
        }
    }

    public static void onPause(Context context) {
        e(context);
        if (abT == null || abU == null) {
            return;
        }
        abU.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(abU, false);
    }

    public static void onResume(Context context) {
        e(context);
        if (com.baidu.crabsdk.a.M) {
            return;
        }
        if (abT == null || abU == null) {
            com.baidu.crabsdk.c.a.w("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.cv("MobclickAgent init success!");
        if (System.currentTimeMillis() - abT.getLong("used_last_time", 0L) > abV) {
            B();
            com.baidu.crabsdk.sender.k.n(context);
        }
    }

    public static int rS() {
        return abT.getInt("used_count", 0);
    }
}
