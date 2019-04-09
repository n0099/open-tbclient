package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.sapi2.base.network.Apn;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes3.dex */
public final class s {
    private static SharedPreferences abU;
    private static HashMap<String, String> acd = null;
    private static Context mContext;

    public static String M() {
        if (!TextUtils.isEmpty(com.baidu.crabsdk.a.c)) {
            com.baidu.crabsdk.c.a.cv("uid is which user setted " + com.baidu.crabsdk.a.c);
            return com.baidu.crabsdk.a.c;
        } else if (mContext == null) {
            com.baidu.crabsdk.c.a.w("get SharedPreferences error because context is null for unknown reasons!!!");
            return Apn.APN_UNKNOWN;
        } else {
            if (abU == null) {
                abU = mContext.getSharedPreferences("crab_user_info", 0);
            }
            String string = abU.getString("userId", "");
            if (TextUtils.isEmpty(string)) {
                string = UUID.randomUUID().toString();
                com.baidu.crabsdk.c.c.a(abU.edit().putString("userId", string), false);
            }
            com.baidu.crabsdk.c.a.cv("uid is UUID " + string);
            return string;
        }
    }

    public static String O() {
        return acd != null ? com.baidu.crabsdk.sender.i.c(acd) : "";
    }

    public static void a(HashMap<String, String> hashMap) {
        if (acd == null) {
            acd = hashMap;
        } else if (hashMap != null) {
            acd.putAll(hashMap);
        }
    }

    public static void c(String str) {
        com.baidu.crabsdk.a.c = str;
        if (abU == null && mContext != null) {
            abU = mContext.getSharedPreferences("crab_user_info", 0);
        }
        if (abU == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.crabsdk.c.c.a(abU.edit().putString("userId", str), false);
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            abU = context.getSharedPreferences("crab_user_info", 0);
        }
    }

    public static String getUserName() {
        return abU != null ? abU.getString("userName", "") : "";
    }

    public static HashMap<String, String> rU() {
        if (acd == null) {
            acd = new HashMap<>();
        }
        return acd;
    }

    public static void setUserName(String str) {
        if (abU != null) {
            com.baidu.crabsdk.c.c.a(abU.edit().putString("userName", str), false);
        }
    }
}
