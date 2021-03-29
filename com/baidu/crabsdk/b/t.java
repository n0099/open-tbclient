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
    public static Context f4700a;

    /* renamed from: b  reason: collision with root package name */
    public static SharedPreferences f4701b;

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<String, String> f4702c;

    public static String a() {
        if (!TextUtils.isEmpty(com.baidu.crabsdk.a.f4637c)) {
            com.baidu.crabsdk.c.a.b("uid is which user setted " + com.baidu.crabsdk.a.f4637c);
            return com.baidu.crabsdk.a.f4637c;
        }
        Context context = f4700a;
        if (context == null) {
            com.baidu.crabsdk.c.a.d("get SharedPreferences error because context is null for unknown reasons!!!");
            return "N/A";
        }
        if (f4701b == null) {
            f4701b = context.getSharedPreferences("crab_user_info", 0);
        }
        String string = f4701b.getString("userId", "");
        if (TextUtils.isEmpty(string)) {
            string = UUID.randomUUID().toString();
            com.baidu.crabsdk.c.c.c(f4701b.edit().putString("userId", string), false);
        }
        com.baidu.crabsdk.c.a.b("uid is UUID " + string);
        return string;
    }

    public static HashMap<String, String> b() {
        if (f4702c == null) {
            f4702c = new HashMap<>();
        }
        return f4702c;
    }

    public static String c() {
        HashMap<String, String> hashMap = f4702c;
        return hashMap != null ? com.baidu.crabsdk.sender.i.f(hashMap) : "";
    }

    public static void d(HashMap<String, String> hashMap) {
        HashMap<String, String> hashMap2 = f4702c;
        if (hashMap2 == null) {
            f4702c = hashMap;
        } else if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
    }

    public static void e(String str) {
        Context context;
        com.baidu.crabsdk.a.f4637c = str;
        if (f4701b == null && (context = f4700a) != null) {
            f4701b = context.getSharedPreferences("crab_user_info", 0);
        }
        if (f4701b == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.crabsdk.c.c.c(f4701b.edit().putString("userId", str), false);
    }

    public static void f(Context context) {
        if (f4700a == null) {
            f4700a = context;
            f4701b = context.getSharedPreferences("crab_user_info", 0);
        }
    }

    public static String g() {
        SharedPreferences sharedPreferences = f4701b;
        return sharedPreferences != null ? sharedPreferences.getString(TbEnum.SystemMessage.KEY_USER_NAME, "") : "";
    }

    public static void h(String str) {
        SharedPreferences sharedPreferences = f4701b;
        if (sharedPreferences != null) {
            com.baidu.crabsdk.c.c.c(sharedPreferences.edit().putString(TbEnum.SystemMessage.KEY_USER_NAME, str), false);
        }
    }
}
