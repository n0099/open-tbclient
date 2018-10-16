package com.baidu.android.pushservice.j;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.ar.statistic.StatisticConstants;
import java.util.List;
/* loaded from: classes3.dex */
public class j {
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
            edit.putString("channel_id", str2);
            if (!TextUtils.isEmpty(str3)) {
                edit.putString("new_channel_id", str3);
            }
            edit.putString(StatisticConstants.REQUEST_ID, str4);
            edit.putString("user_id", str5);
            edit.putBoolean("bind_status", true);
            edit.putLong("version_code", m.d(context, context.getPackageName()));
            edit.apply();
        } catch (Exception e) {
        }
    }

    public static void a(Context context, List<String> list) {
        if (list == null || list.size() == 0 || list.size() > 20) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("com.baidu.pushservice.app_stat", 0).edit();
            edit.putString("pkg_list", TextUtils.join(":", list));
            edit.putLong("last_save", System.currentTimeMillis());
            for (String str : list) {
                PackageInfo a = m.a(context, str);
                if (a != null) {
                    edit.putString(str, a.versionCode + ":" + a.versionName);
                }
            }
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
}
