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
    public static Context f4847a;

    /* renamed from: b  reason: collision with root package name */
    public static SharedPreferences f4848b;

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<String, String> f4849c;

    public static String a() {
        if (!TextUtils.isEmpty(com.baidu.crabsdk.a.f4781c)) {
            com.baidu.crabsdk.c.a.b("uid is which user setted " + com.baidu.crabsdk.a.f4781c);
            return com.baidu.crabsdk.a.f4781c;
        }
        Context context = f4847a;
        if (context == null) {
            com.baidu.crabsdk.c.a.d("get SharedPreferences error because context is null for unknown reasons!!!");
            return "N/A";
        }
        if (f4848b == null) {
            f4848b = context.getSharedPreferences("crab_user_info", 0);
        }
        String string = f4848b.getString("userId", "");
        if (TextUtils.isEmpty(string)) {
            string = UUID.randomUUID().toString();
            com.baidu.crabsdk.c.c.c(f4848b.edit().putString("userId", string), false);
        }
        com.baidu.crabsdk.c.a.b("uid is UUID " + string);
        return string;
    }

    public static HashMap<String, String> b() {
        if (f4849c == null) {
            f4849c = new HashMap<>();
        }
        return f4849c;
    }

    public static String c() {
        HashMap<String, String> hashMap = f4849c;
        return hashMap != null ? com.baidu.crabsdk.sender.i.f(hashMap) : "";
    }

    public static void d(HashMap<String, String> hashMap) {
        HashMap<String, String> hashMap2 = f4849c;
        if (hashMap2 == null) {
            f4849c = hashMap;
        } else if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
    }

    public static void e(String str) {
        Context context;
        com.baidu.crabsdk.a.f4781c = str;
        if (f4848b == null && (context = f4847a) != null) {
            f4848b = context.getSharedPreferences("crab_user_info", 0);
        }
        if (f4848b == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.crabsdk.c.c.c(f4848b.edit().putString("userId", str), false);
    }

    public static void f(Context context) {
        if (f4847a == null) {
            f4847a = context;
            f4848b = context.getSharedPreferences("crab_user_info", 0);
        }
    }

    public static String g() {
        SharedPreferences sharedPreferences = f4848b;
        return sharedPreferences != null ? sharedPreferences.getString(TbEnum.SystemMessage.KEY_USER_NAME, "") : "";
    }

    public static void h(String str) {
        SharedPreferences sharedPreferences = f4848b;
        if (sharedPreferences != null) {
            com.baidu.crabsdk.c.c.c(sharedPreferences.edit().putString(TbEnum.SystemMessage.KEY_USER_NAME, str), false);
        }
    }
}
