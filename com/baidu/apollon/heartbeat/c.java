package com.baidu.apollon.heartbeat;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3662a = c.class.getClass().getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static final String f3663b = "last_cfg_request_time";

    /* renamed from: c  reason: collision with root package name */
    public static final String f3664c = "heartbeat_cfg_fingerprint";

    /* renamed from: d  reason: collision with root package name */
    public static final int f3665d = 300;

    /* renamed from: e  reason: collision with root package name */
    public static final String f3666e = "HeartBeatSP";

    /* renamed from: f  reason: collision with root package name */
    public static SharedPreferences f3667f;

    /* renamed from: g  reason: collision with root package name */
    public static SharedPreferences.Editor f3668g;

    public static void a(Context context) {
        if (f3667f == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f3666e, 0);
            f3667f = sharedPreferences;
            f3668g = sharedPreferences.edit();
        }
    }

    public static long b(Context context, String str, long j) {
        a(context);
        return f3667f.getLong(str, j);
    }

    public static String b(Context context, String str, String str2) {
        a(context);
        return f3667f.getString(str, str2);
    }

    public static void a(Context context, String str, long j) {
        a(context);
        f3668g.putLong(str, j);
        f3668g.commit();
    }

    public static void a(Context context, String str, String str2) {
        a(context);
        f3668g.putString(str, str2);
        f3668g.commit();
    }

    public static void a(Context context, String str) {
        a(context);
        f3668g.remove(str);
        f3668g.commit();
    }
}
