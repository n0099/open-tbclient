package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes3.dex */
public final class m {
    private static SharedPreferences Kh;
    private static SharedPreferences.Editor Ki;
    private static long Kj = StatisticConfig.MIN_UPLOAD_INTERVAL;

    public static void B() {
        Ki.putInt("used_count", mp() + 1);
        com.baidu.crabsdk.c.c.a(Ki, false);
    }

    public static void clear() {
        if (Ki != null) {
            Ki.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(Ki, false);
        }
    }

    public static void e(Context context) {
        if (Kh == null) {
            Kh = context.getSharedPreferences("crab_app_life", 0);
        }
        if (Ki == null) {
            Ki = Kh.edit();
        }
    }

    public static int mp() {
        return Kh.getInt("used_count", 0);
    }

    public static void onPause(Context context) {
        e(context);
        if (Kh == null || Ki == null) {
            return;
        }
        Ki.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(Ki, false);
    }

    public static void onResume(Context context) {
        e(context);
        if (com.baidu.crabsdk.a.M) {
            return;
        }
        if (Kh == null || Ki == null) {
            com.baidu.crabsdk.c.a.w("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.bu("MobclickAgent init success!");
        if (System.currentTimeMillis() - Kh.getLong("used_last_time", 0L) > Kj) {
            B();
            com.baidu.crabsdk.sender.k.n(context);
        }
    }
}
