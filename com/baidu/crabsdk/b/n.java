package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.imagepipeline.memory.PoolStatsTracker;
/* loaded from: classes2.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static SharedPreferences f4689a = null;

    /* renamed from: b  reason: collision with root package name */
    public static SharedPreferences.Editor f4690b = null;

    /* renamed from: c  reason: collision with root package name */
    public static long f4691c = 30000;

    public static void a() {
        f4690b.putInt(PoolStatsTracker.USED_COUNT, b() + 1);
        com.baidu.crabsdk.c.c.c(f4690b, false);
    }

    public static int b() {
        return f4689a.getInt(PoolStatsTracker.USED_COUNT, 0);
    }

    public static void c() {
        SharedPreferences.Editor editor = f4690b;
        if (editor != null) {
            editor.putInt(PoolStatsTracker.USED_COUNT, 0);
            com.baidu.crabsdk.c.c.c(f4690b, false);
        }
    }

    public static void d(Context context) {
        if (f4689a == null) {
            f4689a = context.getSharedPreferences("crab_app_life", 0);
        }
        if (f4690b == null) {
            f4690b = f4689a.edit();
        }
    }

    public static void e(Context context) {
        d(context);
        if (f4689a == null || f4690b == null) {
            return;
        }
        f4690b.putLong("used_last_time", System.currentTimeMillis());
        com.baidu.crabsdk.c.c.c(f4690b, false);
    }

    public static void f(Context context) {
        d(context);
        if (com.baidu.crabsdk.a.N) {
            return;
        }
        if (f4689a == null || f4690b == null) {
            com.baidu.crabsdk.c.a.d("MobclickAgent init error!! applife upload failed!");
            return;
        }
        com.baidu.crabsdk.c.a.b("MobclickAgent init success!");
        if (System.currentTimeMillis() - f4689a.getLong("used_last_time", 0L) > f4691c) {
            a();
            com.baidu.crabsdk.sender.k.k(context);
        }
    }
}
