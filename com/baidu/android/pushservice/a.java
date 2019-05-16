package com.baidu.android.pushservice;

import android.content.Context;
import android.content.SharedPreferences;
import com.vivo.push.util.NotifyAdapterUtil;
/* loaded from: classes3.dex */
public final class a {
    public static short a() {
        return (short) 80;
    }

    public static void a(Context context, boolean z) {
        int i = z ? 0 : 80;
        SharedPreferences.Editor edit = context.getSharedPreferences("pst", 4).edit();
        edit.putInt("com.baidu.push.nd_restart", i);
        edit.commit();
    }

    public static boolean a(Context context) {
        return PushSettings.d(context);
    }

    public static boolean a(String str) {
        return "com.baidu.searchbox".equals(str) || "com.baidu.BaiduMap".equals(str) || "com.baidu.searchbox.lite".equals(str) || "com.baidu.haokan".equals(str) || "com.baidu.minivideo".equals(str) || "com.baidu.push.qa".equals(str) || "com.baidu.push.salon".equals(str);
    }

    public static void b(Context context, boolean z) {
        String str;
        SharedPreferences sharedPreferences = context.getSharedPreferences("pst", 4);
        if (z) {
            if ("disabled".equals(c(context))) {
                a(context, true);
            }
            str = "enabled";
        } else {
            str = "disabled";
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("s_e", str);
        edit.commit();
    }

    public static boolean b(Context context) {
        return 80 > context.getSharedPreferences("pst", 4).getInt("com.baidu.push.nd_restart", 0);
    }

    public static String c(Context context) {
        return context.getSharedPreferences("pst", 4).getString("s_e", NotifyAdapterUtil.PRIMARY_CHANNEL);
    }

    public static void c(Context context, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.baidu.pushservice.single_conn", 0).edit();
        edit.putBoolean("single_enable", z);
        edit.apply();
    }

    public static boolean d(Context context) {
        return a(context.getPackageName()) && context.getSharedPreferences("com.baidu.pushservice.single_conn", 0).getBoolean("single_enable", false);
    }
}
