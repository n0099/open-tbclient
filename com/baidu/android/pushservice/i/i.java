package com.baidu.android.pushservice.i;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes6.dex */
public class i {
    public static String a(Context context, String str) {
        return context.getSharedPreferences("pst", 0).getString(str, "");
    }

    public static void a(Context context, String str, int i) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("pst", 0).edit();
            edit.putInt(str, i);
            edit.commit();
        } catch (Exception e) {
        }
    }

    public static void a(Context context, String str, long j) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("pst", 0).edit();
            edit.putLong(str, j);
            edit.commit();
        } catch (Exception e) {
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, boolean z, int i, long j, String str6, String str7) {
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
            edit.putString(SharedPrefConfig.CHANNEL_ID, str2);
            if (!TextUtils.isEmpty(str3)) {
                edit.putString("new_channel_id", str3);
            }
            edit.putString("request_id", str4);
            edit.putString("user_id", str5);
            edit.putBoolean("bind_status", true);
            edit.putLong("version_code", l.d(context, context.getPackageName()));
            edit.apply();
        } catch (Exception e) {
        }
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("pst", 0).edit();
            edit.putString(str, str2);
            edit.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static int b(Context context, String str, int i) {
        return context.getSharedPreferences("pst", 0).getInt(str, i);
    }

    public static long b(Context context, String str) {
        return context.getSharedPreferences("pst", 0).getLong(str, 0L);
    }

    public static void b(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("pst", 0).edit();
            edit.putString(str, str2);
            edit.apply();
        } catch (Exception e) {
        }
    }
}
