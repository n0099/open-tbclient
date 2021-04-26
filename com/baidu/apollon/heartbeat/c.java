package com.baidu.apollon.heartbeat;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3744a = c.class.getClass().getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static final String f3745b = "last_cfg_request_time";

    /* renamed from: c  reason: collision with root package name */
    public static final String f3746c = "heartbeat_cfg_fingerprint";

    /* renamed from: d  reason: collision with root package name */
    public static final int f3747d = 300;

    /* renamed from: e  reason: collision with root package name */
    public static final String f3748e = "HeartBeatSP";

    /* renamed from: f  reason: collision with root package name */
    public static SharedPreferences f3749f;

    /* renamed from: g  reason: collision with root package name */
    public static SharedPreferences.Editor f3750g;

    public static void a(Context context) {
        if (f3749f == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f3748e, 0);
            f3749f = sharedPreferences;
            f3750g = sharedPreferences.edit();
        }
    }

    public static long b(Context context, String str, long j) {
        a(context);
        return f3749f.getLong(str, j);
    }

    public static String b(Context context, String str, String str2) {
        a(context);
        return f3749f.getString(str, str2);
    }

    public static void a(Context context, String str, long j) {
        a(context);
        f3750g.putLong(str, j);
        f3750g.commit();
    }

    public static void a(Context context, String str, String str2) {
        a(context);
        f3750g.putString(str, str2);
        f3750g.commit();
    }

    public static void a(Context context, String str) {
        a(context);
        f3750g.remove(str);
        f3750g.commit();
    }
}
