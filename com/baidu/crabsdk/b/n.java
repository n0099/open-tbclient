package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes3.dex */
public final class n {
    private static SharedPreferences aqa;
    private static SharedPreferences.Editor aqb;
    private static long aqc = 30000;

    public static void F() {
        aqb.putInt("used_count", G() + 1);
        com.baidu.crabsdk.c.c.a(aqb, false);
    }

    public static int G() {
        return aqa.getInt("used_count", 0);
    }

    public static void clear() {
        if (aqb != null) {
            aqb.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(aqb, false);
        }
    }

    public static void e(Context context) {
        if (aqa == null) {
            aqa = context.getSharedPreferences("crab_app_life", 0);
        }
        if (aqb == null) {
            aqb = aqa.edit();
        }
    }

    public static void onPause(Context context) {
        e(context);
        if (aqa == null || aqb == null) {
            return;
        }
        aqb.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(aqb, false);
    }

    public static void onResume(Context context) {
        e(context);
        if (com.baidu.crabsdk.a.N) {
            return;
        }
        if (aqa == null || aqb == null) {
            com.baidu.crabsdk.c.a.w("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.dx("MobclickAgent init success!");
        if (System.currentTimeMillis() - aqa.getLong("used_last_time", 0L) > aqc) {
            F();
            com.baidu.crabsdk.sender.k.m(context);
        }
    }
}
