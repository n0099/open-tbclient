package cn.com.chinatelecom.gateway.lib.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
/* loaded from: classes.dex */
public final class b {
    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences(b(context), 0);
    }

    public static void a(Context context, String str, int i2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            a(context).edit().putInt(str, i2).commit();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            a(context).edit().putString(str, str2).commit();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static int b(Context context, String str, int i2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                return a(context).getInt(str, i2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return i2;
    }

    public static String b(Context context) {
        return "ct_account_api_sdk";
    }

    public static String b(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                return a(context).getString(str, str2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return str2;
    }
}
