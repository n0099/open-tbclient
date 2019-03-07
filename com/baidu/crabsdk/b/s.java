package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.sapi2.base.network.Apn;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class s {
    private static SharedPreferences abS;
    private static Context mContext;

    public static String N() {
        if (!TextUtils.isEmpty(com.baidu.crabsdk.a.c)) {
            com.baidu.crabsdk.c.a.cv("uid is which user setted " + com.baidu.crabsdk.a.c);
            return com.baidu.crabsdk.a.c;
        } else if (mContext == null) {
            com.baidu.crabsdk.c.a.cy("get SharedPreferences error because context is null for unknown reasons!!!");
            return Apn.APN_UNKNOWN;
        } else {
            if (abS == null) {
                abS = mContext.getSharedPreferences("crab_user_info", 0);
            }
            String string = abS.getString("userId", "");
            if (TextUtils.isEmpty(string)) {
                string = UUID.randomUUID().toString();
                com.baidu.crabsdk.c.c.a(abS.edit().putString("userId", string), false);
            }
            com.baidu.crabsdk.c.a.cv("uid is UUID " + string);
            return string;
        }
    }

    public static String P() {
        return abS != null ? abS.getString("users_custom", "") : "";
    }

    public static void a(HashMap<String, String> hashMap) {
        if (abS == null || hashMap == null) {
            if (abS == null || hashMap != null) {
                return;
            }
            com.baidu.crabsdk.c.c.a(abS.edit().putString("users_custom", ""), false);
            return;
        }
        try {
            com.baidu.crabsdk.c.c.a(abS.edit().putString("users_custom", com.baidu.crabsdk.sender.f.c(hashMap)), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void d(Context context) {
        if (mContext == null) {
            mContext = context;
            abS = context.getSharedPreferences("crab_user_info", 0);
        }
    }

    public static void d(String str) {
        com.baidu.crabsdk.a.c = str;
        if (abS == null && mContext != null) {
            abS = mContext.getSharedPreferences("crab_user_info", 0);
        }
        if (abS == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.crabsdk.c.c.a(abS.edit().putString("userId", str), false);
    }

    public static String getUserName() {
        return abS != null ? abS.getString("userName", "") : "";
    }

    public static HashMap<String, String> rU() {
        HashMap<String, String> hashMap = new HashMap<>();
        if (abS != null) {
            String string = abS.getString("users_custom", "");
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
        if (abS != null) {
            com.baidu.crabsdk.c.c.a(abS.edit().putString("userName", str), false);
        }
    }
}
