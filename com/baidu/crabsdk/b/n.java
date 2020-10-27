package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes11.dex */
public final class n {
    private static SharedPreferences aoG;
    private static SharedPreferences.Editor aoH;
    private static long aoI = 30000;

    public static void F() {
        aoH.putInt("used_count", vn() + 1);
        com.baidu.crabsdk.c.c.a(aoH, false);
    }

    public static void clear() {
        if (aoH != null) {
            aoH.putInt("used_count", 0);
            com.baidu.crabsdk.c.c.a(aoH, false);
        }
    }

    public static void e(Context context) {
        if (aoG == null) {
            aoG = context.getSharedPreferences("crab_app_life", 0);
        }
        if (aoH == null) {
            aoH = aoG.edit();
        }
    }

    public static void onPause(Context context) {
        e(context);
        if (aoG == null || aoH == null) {
            return;
        }
        aoH.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.a(aoH, false);
    }

    public static void onResume(Context context) {
        e(context);
        if (com.baidu.crabsdk.a.N) {
            return;
        }
        if (aoG == null || aoH == null) {
            com.baidu.crabsdk.c.a.w("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.dA("MobclickAgent init success!");
        if (System.currentTimeMillis() - aoG.getLong("used_last_time", 0L) > aoI) {
            F();
            com.baidu.crabsdk.sender.k.ag(context);
        }
    }

    public static int vn() {
        return aoG.getInt("used_count", 0);
    }
}
