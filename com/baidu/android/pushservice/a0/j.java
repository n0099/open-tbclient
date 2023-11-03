package com.baidu.android.pushservice.a0;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
public class j {
    public static String a(Context context) {
        return context.getSharedPreferences("push_client_self_info", 4).getString("bd_use_honor_regid", null);
    }

    public static synchronized void a(Context context, int i, String str) {
        SharedPreferences.Editor edit;
        String str2;
        synchronized (j.class) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("push_client_self_info", 0);
                int i2 = 5;
                do {
                    edit = sharedPreferences.edit();
                    i2--;
                    if (edit != null) {
                        break;
                    }
                } while (i2 > 0);
                if (edit != null) {
                    if (i == 5) {
                        str2 = "bd_use_huawei_token";
                    } else if (i == 6) {
                        str2 = "bd_use_xiaomi_regid";
                    } else if (i == 7) {
                        str2 = "bd_use_meizu_pushid";
                    } else if (i != 9) {
                        if (i == 10) {
                            edit.putString("bd_use_honor_regid", str).commit();
                        }
                        edit.putLong("token_save_time", System.currentTimeMillis()).apply();
                    } else {
                        str2 = "bd_use_vivo_regid";
                    }
                    edit.putString(str2, str).apply();
                    edit.putLong("token_save_time", System.currentTimeMillis()).apply();
                }
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(Context context, String str, boolean z) {
        return context.getSharedPreferences("push_client_self_info", 4).getBoolean(str, z);
    }

    public static String b(Context context) {
        return context.getSharedPreferences("push_client_self_info", 4).getString("bd_use_huawei_token", null);
    }

    public static void b(Context context, String str, boolean z) {
        SharedPreferences.Editor edit;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("push_client_self_info", 4);
            int i = 2;
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
        } catch (Exception unused) {
        }
    }

    public static String c(Context context) {
        return context.getSharedPreferences("push_client_self_info", 4).getString("bd_use_meizu_pushid", null);
    }

    public static long d(Context context) {
        return context.getSharedPreferences("push_client_self_info", 4).getLong("token_save_time", System.currentTimeMillis());
    }

    public static String e(Context context) {
        return context.getSharedPreferences("push_client_self_info", 4).getString("bd_use_xiaomi_regid", null);
    }

    public static boolean f(Context context) {
        return context.getSharedPreferences("push_client_self_info", 4).contains("token_save_time") && com.baidu.android.pushservice.l.d.i(context).b() != 0;
    }
}
