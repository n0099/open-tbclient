package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.TbEnum;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a  reason: collision with root package name */
    public static Context f4735a;

    /* renamed from: b  reason: collision with root package name */
    public static SharedPreferences f4736b;

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<String, String> f4737c;

    public static String a() {
        if (!TextUtils.isEmpty(com.baidu.crabsdk.a.f4672c)) {
            com.baidu.crabsdk.c.a.b("uid is which user setted " + com.baidu.crabsdk.a.f4672c);
            return com.baidu.crabsdk.a.f4672c;
        }
        Context context = f4735a;
        if (context == null) {
            com.baidu.crabsdk.c.a.d("get SharedPreferences error because context is null for unknown reasons!!!");
            return "N/A";
        }
        if (f4736b == null) {
            f4736b = context.getSharedPreferences("crab_user_info", 0);
        }
        String string = f4736b.getString("userId", "");
        if (TextUtils.isEmpty(string)) {
            string = UUID.randomUUID().toString();
            com.baidu.crabsdk.c.c.c(f4736b.edit().putString("userId", string), false);
        }
        com.baidu.crabsdk.c.a.b("uid is UUID " + string);
        return string;
    }

    public static HashMap<String, String> b() {
        if (f4737c == null) {
            f4737c = new HashMap<>();
        }
        return f4737c;
    }

    public static String c() {
        HashMap<String, String> hashMap = f4737c;
        return hashMap != null ? com.baidu.crabsdk.sender.i.f(hashMap) : "";
    }

    public static void d(HashMap<String, String> hashMap) {
        HashMap<String, String> hashMap2 = f4737c;
        if (hashMap2 == null) {
            f4737c = hashMap;
        } else if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
    }

    public static void e(String str) {
        Context context;
        com.baidu.crabsdk.a.f4672c = str;
        if (f4736b == null && (context = f4735a) != null) {
            f4736b = context.getSharedPreferences("crab_user_info", 0);
        }
        if (f4736b == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.crabsdk.c.c.c(f4736b.edit().putString("userId", str), false);
    }

    public static void f(Context context) {
        if (f4735a == null) {
            f4735a = context;
            f4736b = context.getSharedPreferences("crab_user_info", 0);
        }
    }

    public static String g() {
        SharedPreferences sharedPreferences = f4736b;
        return sharedPreferences != null ? sharedPreferences.getString(TbEnum.SystemMessage.KEY_USER_NAME, "") : "";
    }

    public static void h(String str) {
        SharedPreferences sharedPreferences = f4736b;
        if (sharedPreferences != null) {
            com.baidu.crabsdk.c.c.c(sharedPreferences.edit().putString(TbEnum.SystemMessage.KEY_USER_NAME, str), false);
        }
    }
}
