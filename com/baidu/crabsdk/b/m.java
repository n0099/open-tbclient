package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes3.dex */
public final class m {
    private static SharedPreferences abT;
    private static SharedPreferences.Editor abU;
    private static long abV = StatisticConfig.MIN_UPLOAD_INTERVAL;

    public static void C() {
        abU.putInt("used_count", rS() + 1);
        com.baidu.crabsdk.c.c.a(abU, false);
    }

    public static void clear() {
        if (abU != null) {
            abU.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(abU, false);
        }
    }

    public static void d(Context context) {
        if (abT == null) {
            abT = context.getSharedPreferences("crab_app_life", 0);
        }
        if (abU == null) {
            abU = abT.edit();
        }
    }

    public static void onPause(Context context) {
        d(context);
        if (abT == null || abU == null) {
            return;
        }
        abU.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(abU, false);
    }

    public static void onResume(Context context) {
        d(context);
        if (com.baidu.crabsdk.a.M) {
            return;
        }
        if (abT == null || abU == null) {
            com.baidu.crabsdk.c.a.cy("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.cv("MobclickAgent init success!");
        if (System.currentTimeMillis() - abT.getLong("used_last_time", 0L) > abV) {
            C();
            com.baidu.crabsdk.sender.h.n(context);
        }
    }

    public static int rS() {
        return abT.getInt("used_count", 0);
    }
}
