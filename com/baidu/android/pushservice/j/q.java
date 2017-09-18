package com.baidu.android.pushservice.j;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes2.dex */
public class q {
    public static String a(Context context, String str, String str2) {
        return context.getSharedPreferences(str, 5).getString(str2, "");
    }

    public static void a(Context context, String str, String str2, String str3) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 5).edit();
            edit.putString(str2, str3);
            edit.commit();
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("WorldReadableParams", e);
        }
    }
}
