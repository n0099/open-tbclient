package com.baidu.android.pushservice.j;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class n {
    public static String a(Context context, String str) {
        return context.getSharedPreferences("pst", 0).getString(str, "");
    }

    public static void a(Context context, String str, int i) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("pst", 0).edit();
            edit.putInt(str, i);
            edit.apply();
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("PrivateParams", e);
        }
    }

    public static void a(Context context, String str, long j) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("pst", 0).edit();
            edit.putLong(str, j);
            edit.apply();
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("PrivateParams", e);
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, boolean z, int i, long j, String str5, String str6) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).edit();
            if (j != 0) {
                edit.putLong("currbindtime", j);
            }
            if (!TextUtils.isEmpty(str5)) {
                edit.putString("access_token", str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                edit.putString("secret_key", str6);
            }
            edit.putString("appid", str);
            edit.putString("channel_id", str2);
            edit.putString("request_id", str3);
            edit.putString("user_id", str4);
            edit.putBoolean("bind_status", true);
            edit.putLong("version_code", q.d(context, context.getPackageName()));
            edit.apply();
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("PrivateParams", e);
        }
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("pst", 4).edit();
            edit.putString(str, str2);
            edit.apply();
            return true;
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("PrivateParams", e);
            return false;
        }
    }

    public static int b(Context context, String str, int i) {
        return context.getSharedPreferences("pst", 0).getInt(str, i);
    }

    public static String b(Context context, String str) {
        return context.getSharedPreferences("pst", 4).getString(str, "");
    }

    public static boolean b(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("pst", 4).edit();
            edit.putString(str, str2);
            edit.apply();
            return true;
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("PrivateParams", e);
            return false;
        }
    }

    public static long c(Context context, String str) {
        return context.getSharedPreferences("pst", 0).getLong(str, 0L);
    }

    public static void c(Context context, String str, int i) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("pst", 4).edit();
            edit.putInt(str, i);
            edit.apply();
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("PrivateParams", e);
        }
    }

    public static int d(Context context, String str, int i) {
        return context.getSharedPreferences("pst", 4).getInt(str, i);
    }
}
