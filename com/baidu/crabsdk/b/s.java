package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.sapi2.base.network.Apn;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes3.dex */
public final class s {
    private static SharedPreferences abT;
    private static HashMap<String, String> acb = null;
    private static Context mContext;

    public static String M() {
        if (!TextUtils.isEmpty(com.baidu.crabsdk.a.c)) {
            com.baidu.crabsdk.c.a.cv("uid is which user setted " + com.baidu.crabsdk.a.c);
            return com.baidu.crabsdk.a.c;
        } else if (mContext == null) {
            com.baidu.crabsdk.c.a.w("get SharedPreferences error because context is null for unknown reasons!!!");
            return Apn.APN_UNKNOWN;
        } else {
            if (abT == null) {
                abT = mContext.getSharedPreferences("crab_user_info", 0);
            }
            String string = abT.getString("userId", "");
            if (TextUtils.isEmpty(string)) {
                string = UUID.randomUUID().toString();
                com.baidu.crabsdk.c.c.a(abT.edit().putString("userId", string), false);
            }
            com.baidu.crabsdk.c.a.cv("uid is UUID " + string);
            return string;
        }
    }

    public static String O() {
        return acb != null ? com.baidu.crabsdk.sender.i.c(acb) : "";
    }

    public static void a(HashMap<String, String> hashMap) {
        if (acb == null) {
            acb = hashMap;
        } else if (hashMap != null) {
            acb.putAll(hashMap);
        }
    }

    public static void c(String str) {
        com.baidu.crabsdk.a.c = str;
        if (abT == null && mContext != null) {
            abT = mContext.getSharedPreferences("crab_user_info", 0);
        }
        if (abT == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.crabsdk.c.c.a(abT.edit().putString("userId", str), false);
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            abT = context.getSharedPreferences("crab_user_info", 0);
        }
    }

    public static String getUserName() {
        return abT != null ? abT.getString("userName", "") : "";
    }

    public static HashMap<String, String> rU() {
        if (acb == null) {
            acb = new HashMap<>();
        }
        return acb;
    }

    public static void setUserName(String str) {
        if (abT != null) {
            com.baidu.crabsdk.c.c.a(abT.edit().putString("userName", str), false);
        }
    }
}
