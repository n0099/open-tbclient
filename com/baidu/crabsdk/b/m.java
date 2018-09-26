package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes2.dex */
public final class m {
    private static SharedPreferences Vv;
    private static SharedPreferences.Editor Vw;
    private static long Vx = StatisticConfig.MIN_UPLOAD_INTERVAL;

    public static void clear() {
        if (Vw != null) {
            Vw.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(Vw, false);
        }
    }

    public static void d(Context context) {
        if (Vv == null) {
            Vv = context.getSharedPreferences("crab_app_life", 0);
        }
        if (Vw == null) {
            Vw = Vv.edit();
        }
    }

    public static void onPause(Context context) {
        d(context);
        if (Vv == null || Vw == null) {
            return;
        }
        Vw.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(Vw, false);
    }

    public static void onResume(Context context) {
        d(context);
        if (Vv == null || Vw == null) {
            com.baidu.crabsdk.c.a.cy("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.cv("MobclickAgent init success!");
        if (System.currentTimeMillis() - Vv.getLong("used_last_time", 0L) > Vx) {
            Vw.putInt("used_count", qh() + 1);
            com.baidu.crabsdk.c.c.a(Vw, false);
            com.baidu.crabsdk.sender.h.n(context);
        }
    }

    public static int qh() {
        return Vv.getInt("used_count", 0);
    }
}
