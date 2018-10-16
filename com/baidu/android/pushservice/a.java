package com.baidu.android.pushservice;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.webkit.internal.GlobalConstants;
/* loaded from: classes3.dex */
public final class a {
    private static int a = 0;

    public static short a() {
        return (short) 68;
    }

    public static void a(Context context, boolean z) {
        int i = z ? 0 : 68;
        SharedPreferences.Editor edit = context.getSharedPreferences("pst", 4).edit();
        edit.putInt("com.baidu.push.nd_restart", i);
        edit.commit();
    }

    public static boolean a(Context context) {
        return PushSettings.d(context);
    }

    public static int b() {
        if (a != 0 && System.currentTimeMillis() - 1516197236582L > 0) {
            a = 0;
        }
        return a;
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
        return 68 > context.getSharedPreferences("pst", 4).getInt("com.baidu.push.nd_restart", 0);
    }

    public static String c(Context context) {
        return context.getSharedPreferences("pst", 4).getString("s_e", "default");
    }

    public static void c(Context context, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.baidu.pushservice.single_conn", 0).edit();
        edit.putBoolean("single_enable", z);
        edit.apply();
    }

    public static boolean d(Context context) {
        return context.getPackageName().equals(GlobalConstants.SEARCHBOX_PACKAGE_NAME) && context.getSharedPreferences("com.baidu.pushservice.single_conn", 0).getBoolean("single_enable", false);
    }
}
