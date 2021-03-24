package com.baidu.crabsdk.lite.a;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes2.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static SharedPreferences f4734a;

    /* renamed from: b  reason: collision with root package name */
    public static SharedPreferences.Editor f4735b;

    public static void a(Context context) {
        if (f4734a == null) {
            f4734a = context.getSharedPreferences("crablite_app_life", 0);
        }
        if (f4735b == null) {
            f4735b = f4734a.edit();
        }
    }

    public static void b(String str) {
        SharedPreferences.Editor editor = f4735b;
        if (editor != null) {
            editor.putInt("used_count_" + str, 0);
            com.baidu.crabsdk.lite.b.c.c(f4735b, false);
        }
    }

    public static void c(String str) {
        SharedPreferences.Editor editor = f4735b;
        editor.putInt("used_count_" + str, d(str) + 1);
        com.baidu.crabsdk.lite.b.c.c(f4735b, false);
    }

    public static int d(String str) {
        SharedPreferences sharedPreferences = f4734a;
        return sharedPreferences.getInt("used_count_" + str, 0);
    }
}
