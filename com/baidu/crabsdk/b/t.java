package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.TbEnum;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes2.dex */
public final class t {

    /* renamed from: a  reason: collision with root package name */
    public static Context f4699a;

    /* renamed from: b  reason: collision with root package name */
    public static SharedPreferences f4700b;

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<String, String> f4701c;

    public static String a() {
        if (!TextUtils.isEmpty(com.baidu.crabsdk.a.f4636c)) {
            com.baidu.crabsdk.c.a.b("uid is which user setted " + com.baidu.crabsdk.a.f4636c);
            return com.baidu.crabsdk.a.f4636c;
        }
        Context context = f4699a;
        if (context == null) {
            com.baidu.crabsdk.c.a.d("get SharedPreferences error because context is null for unknown reasons!!!");
            return "N/A";
        }
        if (f4700b == null) {
            f4700b = context.getSharedPreferences("crab_user_info", 0);
        }
        String string = f4700b.getString("userId", "");
        if (TextUtils.isEmpty(string)) {
            string = UUID.randomUUID().toString();
            com.baidu.crabsdk.c.c.c(f4700b.edit().putString("userId", string), false);
        }
        com.baidu.crabsdk.c.a.b("uid is UUID " + string);
        return string;
    }

    public static HashMap<String, String> b() {
        if (f4701c == null) {
            f4701c = new HashMap<>();
        }
        return f4701c;
    }

    public static String c() {
        HashMap<String, String> hashMap = f4701c;
        return hashMap != null ? com.baidu.crabsdk.sender.i.f(hashMap) : "";
    }

    public static void d(HashMap<String, String> hashMap) {
        HashMap<String, String> hashMap2 = f4701c;
        if (hashMap2 == null) {
            f4701c = hashMap;
        } else if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
    }

    public static void e(String str) {
        Context context;
        com.baidu.crabsdk.a.f4636c = str;
        if (f4700b == null && (context = f4699a) != null) {
            f4700b = context.getSharedPreferences("crab_user_info", 0);
        }
        if (f4700b == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.crabsdk.c.c.c(f4700b.edit().putString("userId", str), false);
    }

    public static void f(Context context) {
        if (f4699a == null) {
            f4699a = context;
            f4700b = context.getSharedPreferences("crab_user_info", 0);
        }
    }

    public static String g() {
        SharedPreferences sharedPreferences = f4700b;
        return sharedPreferences != null ? sharedPreferences.getString(TbEnum.SystemMessage.KEY_USER_NAME, "") : "";
    }

    public static void h(String str) {
        SharedPreferences sharedPreferences = f4700b;
        if (sharedPreferences != null) {
            com.baidu.crabsdk.c.c.c(sharedPreferences.edit().putString(TbEnum.SystemMessage.KEY_USER_NAME, str), false);
        }
    }
}
