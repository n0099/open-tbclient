package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes6.dex */
public final class m {
    private static SharedPreferences Qo;
    private static SharedPreferences.Editor Qp;
    private static long Qq = 30000;

    public static void B() {
        Qp.putInt("used_count", nz() + 1);
        com.baidu.crabsdk.c.c.a(Qp, false);
    }

    public static void clear() {
        if (Qp != null) {
            Qp.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(Qp, false);
        }
    }

    public static void e(Context context) {
        if (Qo == null) {
            Qo = context.getSharedPreferences("crab_app_life", 0);
        }
        if (Qp == null) {
            Qp = Qo.edit();
        }
    }

    public static int nz() {
        return Qo.getInt("used_count", 0);
    }

    public static void onPause(Context context) {
        e(context);
        if (Qo == null || Qp == null) {
            return;
        }
        Qp.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(Qp, false);
    }

    public static void onResume(Context context) {
        e(context);
        if (com.baidu.crabsdk.a.M) {
            return;
        }
        if (Qo == null || Qp == null) {
            com.baidu.crabsdk.c.a.w("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.cb("MobclickAgent init success!");
        if (System.currentTimeMillis() - Qo.getLong("used_last_time", 0L) > Qq) {
            B();
            com.baidu.crabsdk.sender.k.n(context);
        }
    }
}
