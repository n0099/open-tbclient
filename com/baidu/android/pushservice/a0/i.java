package com.baidu.android.pushservice.a0;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.kuaishou.weapon.p0.u;
/* loaded from: classes.dex */
public class i {
    public static int a(Context context, String str, int i) {
        return context.getSharedPreferences(u.x, 0).getInt(str, i);
    }

    public static long a(Context context, String str, long j) {
        return context.getSharedPreferences(u.x, 0).getLong(str, j);
    }

    public static String a(Context context, String str) {
        return context.getSharedPreferences("pst_bdservice_v1", 0).getString(str, "");
    }

    public static void a(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("pst_bdservice_v1", 0).edit();
            edit.putString(str, str2);
            edit.apply();
        } catch (Exception unused) {
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, long j, String str6, String str7) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).edit();
            if (j != 0) {
                edit.putLong("currbindtime", j);
            }
            if (!TextUtils.isEmpty(str6)) {
                edit.putString("access_token", str6);
            }
            if (!TextUtils.isEmpty(str7)) {
                edit.putString("secret_key", str7);
            }
            edit.putString("appid", str);
            edit.putString("channel_id", str2);
            if (!TextUtils.isEmpty(str3)) {
                edit.putString("new_channel_id", str3);
            }
            edit.putString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, str4);
            edit.putString("user_id", str5);
            edit.putBoolean("bind_status", true);
            Utility.a = 1;
            edit.putLong("version_code", Utility.k(context, context.getPackageName()));
            edit.apply();
        } catch (Exception unused) {
        }
    }

    public static long b(Context context, String str) {
        return context.getSharedPreferences(u.x, 0).getLong(str, 0L);
    }

    public static void b(Context context, String str, int i) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(u.x, 0).edit();
            edit.putInt(str, i);
            edit.commit();
        } catch (Exception unused) {
        }
    }

    public static void b(Context context, String str, long j) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(u.x, 0).edit();
            edit.putLong(str, j);
            edit.commit();
        } catch (Exception unused) {
        }
    }

    public static boolean b(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(u.x, 0).edit();
            edit.putString(str, str2);
            edit.commit();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String c(Context context, String str) {
        return context.getSharedPreferences(u.x, 0).getString(str, "");
    }

    public static void c(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(u.x, 0).edit();
            edit.putString(str, str2);
            edit.apply();
        } catch (Exception unused) {
        }
    }

    public static void d(Context context, String str) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).edit();
            edit.putString("appid", str);
            edit.apply();
        } catch (Exception unused) {
        }
    }
}
