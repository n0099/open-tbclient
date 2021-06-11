package com.baidu.apollon.heartbeat;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3767a = c.class.getClass().getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static final String f3768b = "last_cfg_request_time";

    /* renamed from: c  reason: collision with root package name */
    public static final String f3769c = "heartbeat_cfg_fingerprint";

    /* renamed from: d  reason: collision with root package name */
    public static final int f3770d = 300;

    /* renamed from: e  reason: collision with root package name */
    public static final String f3771e = "HeartBeatSP";

    /* renamed from: f  reason: collision with root package name */
    public static SharedPreferences f3772f;

    /* renamed from: g  reason: collision with root package name */
    public static SharedPreferences.Editor f3773g;

    public static void a(Context context) {
        if (f3772f == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f3771e, 0);
            f3772f = sharedPreferences;
            f3773g = sharedPreferences.edit();
        }
    }

    public static long b(Context context, String str, long j) {
        a(context);
        return f3772f.getLong(str, j);
    }

    public static String b(Context context, String str, String str2) {
        a(context);
        return f3772f.getString(str, str2);
    }

    public static void a(Context context, String str, long j) {
        a(context);
        f3773g.putLong(str, j);
        f3773g.commit();
    }

    public static void a(Context context, String str, String str2) {
        a(context);
        f3773g.putString(str, str2);
        f3773g.commit();
    }

    public static void a(Context context, String str) {
        a(context);
        f3773g.remove(str);
        f3773g.commit();
    }
}
