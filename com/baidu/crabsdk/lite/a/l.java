package com.baidu.crabsdk.lite.a;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static SharedPreferences f4660a;

    /* renamed from: b  reason: collision with root package name */
    public static SharedPreferences.Editor f4661b;

    public static void a(Context context) {
        if (f4660a == null) {
            f4660a = context.getSharedPreferences("crablite_app_life", 0);
        }
        if (f4661b == null) {
            f4661b = f4660a.edit();
        }
    }

    public static void b(String str) {
        SharedPreferences.Editor editor = f4661b;
        if (editor != null) {
            editor.putInt("used_count_" + str, 0);
            com.baidu.crabsdk.lite.b.c.c(f4661b, false);
        }
    }

    public static void c(String str) {
        SharedPreferences.Editor editor = f4661b;
        editor.putInt("used_count_" + str, d(str) + 1);
        com.baidu.crabsdk.lite.b.c.c(f4661b, false);
    }

    public static int d(String str) {
        SharedPreferences sharedPreferences = f4660a;
        return sharedPreferences.getInt("used_count_" + str, 0);
    }
}
