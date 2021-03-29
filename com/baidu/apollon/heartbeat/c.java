package com.baidu.apollon.heartbeat;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3663a = c.class.getClass().getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static final String f3664b = "last_cfg_request_time";

    /* renamed from: c  reason: collision with root package name */
    public static final String f3665c = "heartbeat_cfg_fingerprint";

    /* renamed from: d  reason: collision with root package name */
    public static final int f3666d = 300;

    /* renamed from: e  reason: collision with root package name */
    public static final String f3667e = "HeartBeatSP";

    /* renamed from: f  reason: collision with root package name */
    public static SharedPreferences f3668f;

    /* renamed from: g  reason: collision with root package name */
    public static SharedPreferences.Editor f3669g;

    public static void a(Context context) {
        if (f3668f == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f3667e, 0);
            f3668f = sharedPreferences;
            f3669g = sharedPreferences.edit();
        }
    }

    public static long b(Context context, String str, long j) {
        a(context);
        return f3668f.getLong(str, j);
    }

    public static String b(Context context, String str, String str2) {
        a(context);
        return f3668f.getString(str, str2);
    }

    public static void a(Context context, String str, long j) {
        a(context);
        f3669g.putLong(str, j);
        f3669g.commit();
    }

    public static void a(Context context, String str, String str2) {
        a(context);
        f3669g.putString(str, str2);
        f3669g.commit();
    }

    public static void a(Context context, String str) {
        a(context);
        f3669g.remove(str);
        f3669g.commit();
    }
}
