package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class s {
    private static SharedPreferences Yh;
    private static Context mContext;

    public static String N() {
        if (!TextUtils.isEmpty(com.baidu.crabsdk.a.c)) {
            com.baidu.crabsdk.c.a.cG("uid is which user setted " + com.baidu.crabsdk.a.c);
            return com.baidu.crabsdk.a.c;
        } else if (mContext == null) {
            com.baidu.crabsdk.c.a.cJ("get SharedPreferences error because context is null for unknown reasons!!!");
            return "N/A";
        } else {
            if (Yh == null) {
                Yh = mContext.getSharedPreferences("crab_user_info", 0);
            }
            String string = Yh.getString("userId", "");
            if (TextUtils.isEmpty(string)) {
                string = UUID.randomUUID().toString();
                com.baidu.crabsdk.c.c.a(Yh.edit().putString("userId", string), false);
            }
            com.baidu.crabsdk.c.a.cG("uid is UUID " + string);
            return string;
        }
    }

    public static String P() {
        return Yh != null ? Yh.getString("users_custom", "") : "";
    }

    public static void a(HashMap<String, String> hashMap) {
        if (Yh == null || hashMap == null) {
            if (Yh == null || hashMap != null) {
                return;
            }
            com.baidu.crabsdk.c.c.a(Yh.edit().putString("users_custom", ""), false);
            return;
        }
        try {
            com.baidu.crabsdk.c.c.a(Yh.edit().putString("users_custom", com.baidu.crabsdk.sender.f.c(hashMap)), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void d(Context context) {
        if (mContext == null) {
            mContext = context;
            Yh = context.getSharedPreferences("crab_user_info", 0);
        }
    }

    public static void d(String str) {
        com.baidu.crabsdk.a.c = str;
        if (Yh == null && mContext != null) {
            Yh = mContext.getSharedPreferences("crab_user_info", 0);
        }
        if (Yh == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.crabsdk.c.c.a(Yh.edit().putString("userId", str), false);
    }

    public static String getUserName() {
        return Yh != null ? Yh.getString("userName", "") : "";
    }

    public static HashMap<String, String> rp() {
        HashMap<String, String> hashMap = new HashMap<>();
        if (Yh != null) {
            String string = Yh.getString("users_custom", "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject.getString(next));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return hashMap;
    }

    public static void setUserName(String str) {
        if (Yh != null) {
            com.baidu.crabsdk.c.c.a(Yh.edit().putString("userName", str), false);
        }
    }
}
