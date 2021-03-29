package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.imagepipeline.memory.PoolStatsTracker;
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static SharedPreferences f4690a = null;

    /* renamed from: b  reason: collision with root package name */
    public static SharedPreferences.Editor f4691b = null;

    /* renamed from: c  reason: collision with root package name */
    public static long f4692c = 30000;

    public static void a() {
        f4691b.putInt(PoolStatsTracker.USED_COUNT, b() + 1);
        com.baidu.crabsdk.c.c.c(f4691b, false);
    }

    public static int b() {
        return f4690a.getInt(PoolStatsTracker.USED_COUNT, 0);
    }

    public static void c() {
        SharedPreferences.Editor editor = f4691b;
        if (editor != null) {
            editor.putInt(PoolStatsTracker.USED_COUNT, 0);
            com.baidu.crabsdk.c.c.c(f4691b, false);
        }
    }

    public static void d(Context context) {
        if (f4690a == null) {
            f4690a = context.getSharedPreferences("crab_app_life", 0);
        }
        if (f4691b == null) {
            f4691b = f4690a.edit();
        }
    }

    public static void e(Context context) {
        d(context);
        if (f4690a == null || f4691b == null) {
            return;
        }
        f4691b.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.c(f4691b, false);
    }

    public static void f(Context context) {
        d(context);
        if (com.baidu.crabsdk.a.N) {
            return;
        }
        if (f4690a == null || f4691b == null) {
            com.baidu.crabsdk.c.a.d("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.b("MobclickAgent init success!");
        if (System.currentTimeMillis() - f4690a.getLong("used_last_time", 0L) > f4692c) {
            a();
            com.baidu.crabsdk.sender.k.k(context);
        }
    }
}
