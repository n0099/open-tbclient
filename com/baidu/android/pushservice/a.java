package com.baidu.android.pushservice;

import android.content.Context;
import android.content.SharedPreferences;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes2.dex */
public final class a {
    private static int a = 1;

    public static short a() {
        return (short) 60;
    }

    public static void a(Context context, boolean z) {
        int i = z ? 0 : 60;
        SharedPreferences.Editor edit = context.getSharedPreferences("pst", 4).edit();
        edit.putInt("com.baidu.push.nd_restart", i);
        edit.commit();
    }

    public static boolean a(Context context) {
        return PushSettings.c(context);
    }

    public static int b() {
        if (a != 0) {
            try {
                if (new Date().getTime() - new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-06-13 02:29:22").getTime() > 0) {
                    a = 0;
                }
            } catch (Exception e) {
                a = 0;
                com.baidu.android.pushservice.g.a.a("Constants", e);
            }
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
        return 60 > context.getSharedPreferences("pst", 4).getInt("com.baidu.push.nd_restart", 0);
    }

    public static String c(Context context) {
        return context.getSharedPreferences("pst", 4).getString("s_e", "default");
    }
}
