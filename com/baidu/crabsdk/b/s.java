package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class s {
    private static SharedPreferences SS;
    private static Context mContext;

    public static String M() {
        if (!TextUtils.isEmpty(com.baidu.crabsdk.a.c)) {
            com.baidu.crabsdk.c.a.ce("uid is which user setted " + com.baidu.crabsdk.a.c);
            return com.baidu.crabsdk.a.c;
        } else if (mContext == null) {
            com.baidu.crabsdk.c.a.ch("get SharedPreferences error because context is null for unknown reasons!!!");
            return "N/A";
        } else {
            if (SS == null) {
                SS = mContext.getSharedPreferences("crab_user_info", 0);
            }
            String string = SS.getString("userId", "");
            if (TextUtils.isEmpty(string)) {
                string = UUID.randomUUID().toString();
                com.baidu.crabsdk.c.c.a(SS.edit().putString("userId", string), false);
            }
            com.baidu.crabsdk.c.a.ce("uid is UUID " + string);
            return string;
        }
    }

    public static String O() {
        return SS != null ? SS.getString("users_custom", "") : "";
    }

    public static void a(HashMap<String, String> hashMap) {
        if (SS == null || hashMap == null) {
            if (SS == null || hashMap != null) {
                return;
            }
            com.baidu.crabsdk.c.c.a(SS.edit().putString("users_custom", ""), false);
            return;
        }
        try {
            com.baidu.crabsdk.c.c.a(SS.edit().putString("users_custom", com.baidu.crabsdk.sender.f.c(hashMap)), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void d(Context context) {
        if (mContext == null) {
            mContext = context;
            SS = context.getSharedPreferences("crab_user_info", 0);
        }
    }

    public static String getUserName() {
        return SS != null ? SS.getString("userName", "") : "";
    }

    public static HashMap<String, String> pe() {
        HashMap<String, String> hashMap = new HashMap<>();
        if (SS != null) {
            String string = SS.getString("users_custom", "");
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
        if (SS != null) {
            com.baidu.crabsdk.c.c.a(SS.edit().putString("userName", str), false);
        }
    }
}
