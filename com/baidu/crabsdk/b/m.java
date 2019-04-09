package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes3.dex */
public final class m {
    private static SharedPreferences abU;
    private static SharedPreferences.Editor abV;
    private static long abW = StatisticConfig.MIN_UPLOAD_INTERVAL;

    public static void B() {
        abV.putInt("used_count", rS() + 1);
        com.baidu.crabsdk.c.c.a(abV, false);
    }

    public static void clear() {
        if (abV != null) {
            abV.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(abV, false);
        }
    }

    public static void e(Context context) {
        if (abU == null) {
            abU = context.getSharedPreferences("crab_app_life", 0);
        }
        if (abV == null) {
            abV = abU.edit();
        }
    }

    public static void onPause(Context context) {
        e(context);
        if (abU == null || abV == null) {
            return;
        }
        abV.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(abV, false);
    }

    public static void onResume(Context context) {
        e(context);
        if (com.baidu.crabsdk.a.M) {
            return;
        }
        if (abU == null || abV == null) {
            com.baidu.crabsdk.c.a.w("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.cv("MobclickAgent init success!");
        if (System.currentTimeMillis() - abU.getLong("used_last_time", 0L) > abW) {
            B();
            com.baidu.crabsdk.sender.k.n(context);
        }
    }

    public static int rS() {
        return abU.getInt("used_count", 0);
    }
}
