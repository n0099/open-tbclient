package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.imagepipeline.memory.PoolStatsTracker;
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static SharedPreferences f4691a = null;

    /* renamed from: b  reason: collision with root package name */
    public static SharedPreferences.Editor f4692b = null;

    /* renamed from: c  reason: collision with root package name */
    public static long f4693c = 30000;

    public static void a() {
        f4692b.putInt(PoolStatsTracker.USED_COUNT, b() + 1);
        com.baidu.crabsdk.c.c.c(f4692b, false);
    }

    public static int b() {
        return f4691a.getInt(PoolStatsTracker.USED_COUNT, 0);
    }

    public static void c() {
        SharedPreferences.Editor editor = f4692b;
        if (editor != null) {
            editor.putInt(PoolStatsTracker.USED_COUNT, 0);
            com.baidu.crabsdk.c.c.c(f4692b, false);
        }
    }

    public static void d(Context context) {
        if (f4691a == null) {
            f4691a = context.getSharedPreferences("crab_app_life", 0);
        }
        if (f4692b == null) {
            f4692b = f4691a.edit();
        }
    }

    public static void e(Context context) {
        d(context);
        if (f4691a == null || f4692b == null) {
            return;
        }
        f4692b.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.c(f4692b, false);
    }

    public static void f(Context context) {
        d(context);
        if (com.baidu.crabsdk.a.N) {
            return;
        }
        if (f4691a == null || f4692b == null) {
            com.baidu.crabsdk.c.a.d("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.b("MobclickAgent init success!");
        if (System.currentTimeMillis() - f4691a.getLong("used_last_time", 0L) > f4693c) {
            a();
            com.baidu.crabsdk.sender.k.k(context);
        }
    }
}
