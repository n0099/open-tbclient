package com.baidu.android.pushservice.i;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes3.dex */
public class j {
    public static long a(Context context) {
        return context.getSharedPreferences("push_client_self_info", 4).getLong("token_save_time", System.currentTimeMillis());
    }

    public static synchronized void a(Context context, int i, String str) {
        SharedPreferences.Editor edit;
        synchronized (j.class) {
            int i2 = 5;
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("push_client_self_info", 4);
                do {
                    edit = sharedPreferences.edit();
                    i2--;
                    if (edit != null) {
                        break;
                    }
                } while (i2 > 0);
                if (edit != null) {
                    switch (i) {
                        case 5:
                            edit.putString("bd_use_huawei_token", str).commit();
                            break;
                        case 6:
                            edit.putString("bd_use_xiaomi_regid", str).commit();
                            break;
                        case 7:
                            edit.putString("bd_use_meizu_pushid", str).commit();
                            break;
                        case 9:
                            edit.putString("bd_use_vivo_regid", str).commit();
                            break;
                    }
                    edit.putLong("token_save_time", System.currentTimeMillis()).commit();
                }
            } catch (Exception e) {
            }
        }
    }

    public static void a(Context context, String str, boolean z) {
        SharedPreferences.Editor edit;
        int i = 20;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("push_client_self_info", 4);
            do {
                edit = sharedPreferences.edit();
                i--;
                if (edit != null) {
                    break;
                }
            } while (i > 0);
            if (edit != null) {
                edit.putBoolean(str, z).commit();
            }
        } catch (Exception e) {
        }
    }

    public static String b(Context context) {
        return context.getSharedPreferences("push_client_self_info", 4).getString("bd_use_huawei_token", null);
    }

    public static String c(Context context) {
        return context.getSharedPreferences("push_client_self_info", 4).getString("bd_use_xiaomi_regid", null);
    }

    public static String d(Context context) {
        return context.getSharedPreferences("push_client_self_info", 4).getString("bd_use_meizu_pushid", null);
    }
}
