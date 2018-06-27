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
    private static SharedPreferences SV;
    private static Context mContext;

    public static String M() {
        if (!TextUtils.isEmpty(com.baidu.crabsdk.a.c)) {
            com.baidu.crabsdk.c.a.cd("uid is which user setted " + com.baidu.crabsdk.a.c);
            return com.baidu.crabsdk.a.c;
        } else if (mContext == null) {
            com.baidu.crabsdk.c.a.cg("get SharedPreferences error because context is null for unknown reasons!!!");
            return "N/A";
        } else {
            if (SV == null) {
                SV = mContext.getSharedPreferences("crab_user_info", 0);
            }
            String string = SV.getString("userId", "");
            if (TextUtils.isEmpty(string)) {
                string = UUID.randomUUID().toString();
                com.baidu.crabsdk.c.c.a(SV.edit().putString("userId", string), false);
            }
            com.baidu.crabsdk.c.a.cd("uid is UUID " + string);
            return string;
        }
    }

    public static String O() {
        return SV != null ? SV.getString("users_custom", "") : "";
    }

    public static void a(HashMap<String, String> hashMap) {
        if (SV == null || hashMap == null) {
            if (SV == null || hashMap != null) {
                return;
            }
            com.baidu.crabsdk.c.c.a(SV.edit().putString("users_custom", ""), false);
            return;
        }
        try {
            com.baidu.crabsdk.c.c.a(SV.edit().putString("users_custom", com.baidu.crabsdk.sender.f.c(hashMap)), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void d(Context context) {
        if (mContext == null) {
            mContext = context;
            SV = context.getSharedPreferences("crab_user_info", 0);
        }
    }

    public static String getUserName() {
        return SV != null ? SV.getString("userName", "") : "";
    }

    public static HashMap<String, String> pd() {
        HashMap<String, String> hashMap = new HashMap<>();
        if (SV != null) {
            String string = SV.getString("users_custom", "");
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
        if (SV != null) {
            com.baidu.crabsdk.c.c.a(SV.edit().putString("userName", str), false);
        }
    }
}
