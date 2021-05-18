package com.baidu.apollon.heartbeat;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3745a = c.class.getClass().getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static final String f3746b = "last_cfg_request_time";

    /* renamed from: c  reason: collision with root package name */
    public static final String f3747c = "heartbeat_cfg_fingerprint";

    /* renamed from: d  reason: collision with root package name */
    public static final int f3748d = 300;

    /* renamed from: e  reason: collision with root package name */
    public static final String f3749e = "HeartBeatSP";

    /* renamed from: f  reason: collision with root package name */
    public static SharedPreferences f3750f;

    /* renamed from: g  reason: collision with root package name */
    public static SharedPreferences.Editor f3751g;

    public static void a(Context context) {
        if (f3750f == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f3749e, 0);
            f3750f = sharedPreferences;
            f3751g = sharedPreferences.edit();
        }
    }

    public static long b(Context context, String str, long j) {
        a(context);
        return f3750f.getLong(str, j);
    }

    public static String b(Context context, String str, String str2) {
        a(context);
        return f3750f.getString(str, str2);
    }

    public static void a(Context context, String str, long j) {
        a(context);
        f3751g.putLong(str, j);
        f3751g.commit();
    }

    public static void a(Context context, String str, String str2) {
        a(context);
        f3751g.putString(str, str2);
        f3751g.commit();
    }

    public static void a(Context context, String str) {
        a(context);
        f3751g.remove(str);
        f3751g.commit();
    }
}
