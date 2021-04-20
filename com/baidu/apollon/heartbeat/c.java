package com.baidu.apollon.heartbeat;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3698a = c.class.getClass().getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static final String f3699b = "last_cfg_request_time";

    /* renamed from: c  reason: collision with root package name */
    public static final String f3700c = "heartbeat_cfg_fingerprint";

    /* renamed from: d  reason: collision with root package name */
    public static final int f3701d = 300;

    /* renamed from: e  reason: collision with root package name */
    public static final String f3702e = "HeartBeatSP";

    /* renamed from: f  reason: collision with root package name */
    public static SharedPreferences f3703f;

    /* renamed from: g  reason: collision with root package name */
    public static SharedPreferences.Editor f3704g;

    public static void a(Context context) {
        if (f3703f == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f3702e, 0);
            f3703f = sharedPreferences;
            f3704g = sharedPreferences.edit();
        }
    }

    public static long b(Context context, String str, long j) {
        a(context);
        return f3703f.getLong(str, j);
    }

    public static String b(Context context, String str, String str2) {
        a(context);
        return f3703f.getString(str, str2);
    }

    public static void a(Context context, String str, long j) {
        a(context);
        f3704g.putLong(str, j);
        f3704g.commit();
    }

    public static void a(Context context, String str, String str2) {
        a(context);
        f3704g.putString(str, str2);
        f3704g.commit();
    }

    public static void a(Context context, String str) {
        a(context);
        f3704g.remove(str);
        f3704g.commit();
    }
}
