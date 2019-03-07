package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes3.dex */
public final class m {
    private static SharedPreferences abS;
    private static SharedPreferences.Editor abT;
    private static long abU = StatisticConfig.MIN_UPLOAD_INTERVAL;

    public static void C() {
        abT.putInt("used_count", rS() + 1);
        com.baidu.crabsdk.c.c.a(abT, false);
    }

    public static void clear() {
        if (abT != null) {
            abT.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(abT, false);
        }
    }

    public static void d(Context context) {
        if (abS == null) {
            abS = context.getSharedPreferences("crab_app_life", 0);
        }
        if (abT == null) {
            abT = abS.edit();
        }
    }

    public static void onPause(Context context) {
        d(context);
        if (abS == null || abT == null) {
            return;
        }
        abT.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(abT, false);
    }

    public static void onResume(Context context) {
        d(context);
        if (com.baidu.crabsdk.a.M) {
            return;
        }
        if (abS == null || abT == null) {
            com.baidu.crabsdk.c.a.cy("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.cv("MobclickAgent init success!");
        if (System.currentTimeMillis() - abS.getLong("used_last_time", 0L) > abU) {
            C();
            com.baidu.crabsdk.sender.h.n(context);
        }
    }

    public static int rS() {
        return abS.getInt("used_count", 0);
    }
}
