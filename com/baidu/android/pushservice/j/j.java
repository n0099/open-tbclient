package com.baidu.android.pushservice.j;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
/* loaded from: classes.dex */
public class j {
    public static long a(Context context) {
        return context.getSharedPreferences("push_client_self_info", 4).getLong("token_save_time", System.currentTimeMillis());
    }

    public static synchronized void a(Context context, int i2, String str) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putString;
        synchronized (j.class) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("push_client_self_info", 4);
                int i3 = 5;
                do {
                    edit = sharedPreferences.edit();
                    i3--;
                    if (edit != null) {
                        break;
                    }
                } while (i3 > 0);
                if (edit != null) {
                    if (i2 == 5) {
                        putString = edit.putString("bd_use_huawei_token", str);
                    } else if (i2 == 6) {
                        putString = edit.putString("bd_use_xiaomi_regid", str);
                    } else if (i2 == 7) {
                        putString = edit.putString("bd_use_meizu_pushid", str);
                    } else if (i2 != 9) {
                        edit.putLong("token_save_time", System.currentTimeMillis()).commit();
                    } else {
                        putString = edit.putString("bd_use_vivo_regid", str);
                    }
                    putString.commit();
                    edit.putLong("token_save_time", System.currentTimeMillis()).commit();
                }
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
            }
        }
    }

    public static void a(Context context, String str, boolean z) {
        SharedPreferences.Editor edit;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("push_client_self_info", 4);
            int i2 = 2;
            do {
                edit = sharedPreferences.edit();
                i2--;
                if (edit != null) {
                    break;
                }
            } while (i2 > 0);
            if (edit != null) {
                edit.putBoolean(str, z).commit();
            }
        } catch (Exception e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
        }
    }

    public static String b(Context context) {
        return context.getSharedPreferences("push_client_self_info", 4).getString("bd_use_huawei_token", null);
    }

    public static boolean b(Context context, String str, boolean z) {
        return context.getSharedPreferences("push_client_self_info", 4).getBoolean(str, z);
    }

    public static String c(Context context) {
        return context.getSharedPreferences("push_client_self_info", 4).getString("bd_use_xiaomi_regid", null);
    }

    public static String d(Context context) {
        return context.getSharedPreferences("push_client_self_info", 4).getString("bd_use_meizu_pushid", null);
    }
}
