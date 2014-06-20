package com.baidu.android.defense.push;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
public final class g {
    private static final String a = g.class.getSimpleName();

    private g() {
    }

    public static void a(Context context, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences("moplus_psetting", 0).edit();
        edit.putInt("push_bind", i);
        edit.commit();
    }

    public static void a(Context context, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences("moplus_psetting", 0).edit();
        edit.putLong("register_time", j);
        edit.commit();
    }

    public static void a(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("moplus_psetting", 0).edit();
        edit.putString("push_access_token", str);
        edit.commit();
    }

    public static void a(Context context, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences("moplus_psetting", 0).edit();
        edit.putBoolean("registered", z);
        edit.commit();
    }

    public static boolean a(Context context) {
        return context.getSharedPreferences("moplus_psetting", 0).getInt("push_bind", 0) != 0;
    }

    public static int b(Context context) {
        return context.getSharedPreferences("moplus_psetting", 0).getInt("push_bind", 0);
    }

    public static void b(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("moplus_psetting", 0).edit();
        edit.putString("channel_id", str);
        edit.commit();
    }

    public static String c(Context context) {
        return context.getSharedPreferences("moplus_psetting", 0).getString("push_access_token", "");
    }

    public static void c(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("moplus_psetting", 0).edit();
        edit.putString(com.baidu.tbadk.core.frameworkData.a.USER_ID, str);
        edit.commit();
    }

    public static String d(Context context) {
        return context.getSharedPreferences("moplus_psetting", 0).getString("channel_id", "");
    }

    public static String e(Context context) {
        return context.getSharedPreferences("moplus_psetting", 0).getString(com.baidu.tbadk.core.frameworkData.a.USER_ID, "");
    }

    public static long f(Context context) {
        return context.getSharedPreferences("moplus_psetting", 0).getLong("register_time", 0L);
    }

    public static boolean g(Context context) {
        return context.getSharedPreferences("moplus_psetting", 0).getBoolean("registered", false);
    }

    public static void h(Context context) {
        a(context, true);
        a(context, System.currentTimeMillis());
    }

    public static long i(Context context) {
        return context.getSharedPreferences("moplus_psetting", 0).getLong("last_bind_time", 0L);
    }

    public static void j(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("moplus_psetting", 0).edit();
        edit.putLong("last_bind_time", System.currentTimeMillis());
        edit.commit();
    }
}
