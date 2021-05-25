package com.baidu.apollon.heartbeat;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3748a = c.class.getClass().getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static final String f3749b = "last_cfg_request_time";

    /* renamed from: c  reason: collision with root package name */
    public static final String f3750c = "heartbeat_cfg_fingerprint";

    /* renamed from: d  reason: collision with root package name */
    public static final int f3751d = 300;

    /* renamed from: e  reason: collision with root package name */
    public static final String f3752e = "HeartBeatSP";

    /* renamed from: f  reason: collision with root package name */
    public static SharedPreferences f3753f;

    /* renamed from: g  reason: collision with root package name */
    public static SharedPreferences.Editor f3754g;

    public static void a(Context context) {
        if (f3753f == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f3752e, 0);
            f3753f = sharedPreferences;
            f3754g = sharedPreferences.edit();
        }
    }

    public static long b(Context context, String str, long j) {
        a(context);
        return f3753f.getLong(str, j);
    }

    public static String b(Context context, String str, String str2) {
        a(context);
        return f3753f.getString(str, str2);
    }

    public static void a(Context context, String str, long j) {
        a(context);
        f3754g.putLong(str, j);
        f3754g.commit();
    }

    public static void a(Context context, String str, String str2) {
        a(context);
        f3754g.putString(str, str2);
        f3754g.commit();
    }

    public static void a(Context context, String str) {
        a(context);
        f3754g.remove(str);
        f3754g.commit();
    }
}
