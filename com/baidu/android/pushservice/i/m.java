package com.baidu.android.pushservice.i;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes8.dex */
public class m {
    public static String a(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences(str, 5).getString(str2, "");
        } catch (Exception e) {
            return null;
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 5).edit();
            edit.putString(str2, str3);
            edit.commit();
        } catch (Exception e) {
        }
    }
}
