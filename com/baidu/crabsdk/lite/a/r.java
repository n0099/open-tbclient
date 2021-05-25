package com.baidu.crabsdk.lite.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    public static Context f4669a;

    /* renamed from: b  reason: collision with root package name */
    public static SharedPreferences f4670b;

    public static void a(String str, HashMap<String, String> hashMap) {
        if (f4670b == null || hashMap == null) {
            SharedPreferences sharedPreferences = f4670b;
            if (sharedPreferences == null || hashMap != null) {
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            com.baidu.crabsdk.lite.b.c.c(edit.putString("users_custom_" + str, ""), false);
            return;
        }
        try {
            String c2 = com.baidu.crabsdk.lite.sender.d.c(hashMap);
            SharedPreferences.Editor edit2 = f4670b.edit();
            com.baidu.crabsdk.lite.b.c.c(edit2.putString("users_custom_" + str, c2), false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void b(Context context) {
        if (f4669a == null) {
            f4669a = context;
            f4670b = context.getSharedPreferences("crablite_user_info", 0);
        }
    }

    public static String c(String str) {
        Object obj;
        String str2 = com.baidu.crabsdk.lite.a.f4640b;
        if (str2 != null && str2.length() > 0) {
            com.baidu.crabsdk.lite.b.a.f(str, "uid is which user setted");
            HashMap<String, Object> hashMap = com.baidu.crabsdk.lite.a.f4639a.get(str);
            if (hashMap != null && (obj = hashMap.get("sdk_uid")) != null) {
                return (String) obj;
            }
        }
        Context context = f4669a;
        if (context == null) {
            com.baidu.crabsdk.lite.b.a.d(str, "get SharedPreferences error because context is null for unknown reasons!!!");
            return "N/A";
        }
        if (f4670b == null) {
            f4670b = context.getSharedPreferences("crablite_user_info", 0);
        }
        SharedPreferences sharedPreferences = f4670b;
        String string = sharedPreferences.getString("userId_" + str, "");
        if (string == null || string.length() == 0) {
            string = UUID.randomUUID().toString();
            SharedPreferences.Editor edit = f4670b.edit();
            com.baidu.crabsdk.lite.b.c.c(edit.putString("userId_" + str, string), false);
        }
        com.baidu.crabsdk.lite.b.a.f(str, "uid is UUID " + string);
        return string;
    }

    public static String d(String str) {
        SharedPreferences sharedPreferences = f4670b;
        if (sharedPreferences != null) {
            return sharedPreferences.getString("userName_" + str, "");
        }
        return "";
    }

    public static HashMap<String, String> e(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        SharedPreferences sharedPreferences = f4670b;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString("users_custom_" + str, "");
            if (string != null && string.length() > 0) {
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject.getString(next));
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return hashMap;
    }

    public static String f(String str) {
        SharedPreferences sharedPreferences = f4670b;
        if (sharedPreferences != null) {
            return sharedPreferences.getString("users_custom_" + str, "");
        }
        return "";
    }

    public static void g(String str, String str2) {
        SharedPreferences sharedPreferences = f4670b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            com.baidu.crabsdk.lite.b.c.c(edit.putString("userName_" + str, str2), false);
        }
    }
}
