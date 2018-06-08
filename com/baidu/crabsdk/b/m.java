package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes2.dex */
public final class m {
    private static SharedPreferences ST;
    private static SharedPreferences.Editor SU;
    private static long SV = StatisticConfig.MIN_UPLOAD_INTERVAL;

    public static void clear() {
        if (SU != null) {
            SU.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(SU, false);
        }
    }

    public static void d(Context context) {
        if (ST == null) {
            ST = context.getSharedPreferences("crab_app_life", 0);
        }
        if (SU == null) {
            SU = ST.edit();
        }
    }

    public static void onPause(Context context) {
        d(context);
        if (ST == null || SU == null) {
            return;
        }
        SU.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(SU, false);
    }

    public static void onResume(Context context) {
        d(context);
        if (ST == null || SU == null) {
            com.baidu.crabsdk.c.a.ce("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.cb("MobclickAgent init success!");
        if (System.currentTimeMillis() - ST.getLong("used_last_time", 0L) > SV) {
            SU.putInt("used_count", pa() + 1);
            com.baidu.crabsdk.c.c.a(SU, false);
            com.baidu.crabsdk.sender.h.n(context);
        }
    }

    public static int pa() {
        return ST.getInt("used_count", 0);
    }
}
