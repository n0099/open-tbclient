package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes3.dex */
public final class s {
    private static SharedPreferences aae;
    private static HashMap<String, String> aam = null;
    private static Context mContext;

    public static String M() {
        if (!TextUtils.isEmpty(com.baidu.crabsdk.a.c)) {
            com.baidu.crabsdk.c.a.ch("uid is which user setted " + com.baidu.crabsdk.a.c);
            return com.baidu.crabsdk.a.c;
        } else if (mContext == null) {
            com.baidu.crabsdk.c.a.w("get SharedPreferences error because context is null for unknown reasons!!!");
            return "N/A";
        } else {
            if (aae == null) {
                aae = mContext.getSharedPreferences("crab_user_info", 0);
            }
            String string = aae.getString("userId", "");
            if (TextUtils.isEmpty(string)) {
                string = UUID.randomUUID().toString();
                com.baidu.crabsdk.c.c.a(aae.edit().putString("userId", string), false);
            }
            com.baidu.crabsdk.c.a.ch("uid is UUID " + string);
            return string;
        }
    }

    public static String O() {
        return aam != null ? com.baidu.crabsdk.sender.i.c(aam) : "";
    }

    public static void a(HashMap<String, String> hashMap) {
        if (aam == null) {
            aam = hashMap;
        } else if (hashMap != null) {
            aam.putAll(hashMap);
        }
    }

    public static void c(String str) {
        com.baidu.crabsdk.a.c = str;
        if (aae == null && mContext != null) {
            aae = mContext.getSharedPreferences("crab_user_info", 0);
        }
        if (aae == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.crabsdk.c.c.a(aae.edit().putString("userId", str), false);
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            aae = context.getSharedPreferences("crab_user_info", 0);
        }
    }

    public static String getUserName() {
        return aae != null ? aae.getString("userName", "") : "";
    }

    public static HashMap<String, String> rm() {
        if (aam == null) {
            aam = new HashMap<>();
        }
        return aam;
    }

    public static void setUserName(String str) {
        if (aae != null) {
            com.baidu.crabsdk.c.c.a(aae.edit().putString("userName", str), false);
        }
    }
}
