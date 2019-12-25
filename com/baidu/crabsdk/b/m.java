package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes5.dex */
public final class m {
    private static SharedPreferences Qk;
    private static SharedPreferences.Editor Ql;
    private static long Qm = 30000;

    public static void B() {
        Ql.putInt("used_count", ny() + 1);
        com.baidu.crabsdk.c.c.a(Ql, false);
    }

    public static void clear() {
        if (Ql != null) {
            Ql.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(Ql, false);
        }
    }

    public static void e(Context context) {
        if (Qk == null) {
            Qk = context.getSharedPreferences("crab_app_life", 0);
        }
        if (Ql == null) {
            Ql = Qk.edit();
        }
    }

    public static int ny() {
        return Qk.getInt("used_count", 0);
    }

    public static void onPause(Context context) {
        e(context);
        if (Qk == null || Ql == null) {
            return;
        }
        Ql.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(Ql, false);
    }

    public static void onResume(Context context) {
        e(context);
        if (com.baidu.crabsdk.a.M) {
            return;
        }
        if (Qk == null || Ql == null) {
            com.baidu.crabsdk.c.a.w("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.cb("MobclickAgent init success!");
        if (System.currentTimeMillis() - Qk.getLong("used_last_time", 0L) > Qm) {
            B();
            com.baidu.crabsdk.sender.k.n(context);
        }
    }
}
