package com.baidu.android.pushservice.j;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes2.dex */
public class n {
    public static String a(Context context) {
        return context.getSharedPreferences("push_client_self_info", 4).getString("bd_use_huawei_token", null);
    }

    public static synchronized void a(Context context, int i, String str) {
        SharedPreferences.Editor edit;
        synchronized (n.class) {
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
                    }
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
            edit.putBoolean(str, z).commit();
        } catch (Exception e) {
        }
    }

    public static String b(Context context) {
        return context.getSharedPreferences("push_client_self_info", 4).getString("bd_use_xiaomi_regid", null);
    }

    public static String c(Context context) {
        return context.getSharedPreferences("push_client_self_info", 4).getString("bd_use_meizu_pushid", null);
    }
}
