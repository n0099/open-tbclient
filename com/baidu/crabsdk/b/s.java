package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.sapi2.base.network.Apn;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes3.dex */
public final class s {
    private static SharedPreferences ZK;
    private static HashMap<String, String> ZS = null;
    private static Context mContext;

    public static String M() {
        if (!TextUtils.isEmpty(com.baidu.crabsdk.a.c)) {
            com.baidu.crabsdk.c.a.cf("uid is which user setted " + com.baidu.crabsdk.a.c);
            return com.baidu.crabsdk.a.c;
        } else if (mContext == null) {
            com.baidu.crabsdk.c.a.w("get SharedPreferences error because context is null for unknown reasons!!!");
            return Apn.APN_UNKNOWN;
        } else {
            if (ZK == null) {
                ZK = mContext.getSharedPreferences("crab_user_info", 0);
            }
            String string = ZK.getString("userId", "");
            if (TextUtils.isEmpty(string)) {
                string = UUID.randomUUID().toString();
                com.baidu.crabsdk.c.c.a(ZK.edit().putString("userId", string), false);
            }
            com.baidu.crabsdk.c.a.cf("uid is UUID " + string);
            return string;
        }
    }

    public static String O() {
        return ZS != null ? com.baidu.crabsdk.sender.i.c(ZS) : "";
    }

    public static void a(HashMap<String, String> hashMap) {
        if (ZS == null) {
            ZS = hashMap;
        } else if (hashMap != null) {
            ZS.putAll(hashMap);
        }
    }

    public static void c(String str) {
        com.baidu.crabsdk.a.c = str;
        if (ZK == null && mContext != null) {
            ZK = mContext.getSharedPreferences("crab_user_info", 0);
        }
        if (ZK == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.crabsdk.c.c.a(ZK.edit().putString("userId", str), false);
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            ZK = context.getSharedPreferences("crab_user_info", 0);
        }
    }

    public static String getUserName() {
        return ZK != null ? ZK.getString("userName", "") : "";
    }

    public static HashMap<String, String> qP() {
        if (ZS == null) {
            ZS = new HashMap<>();
        }
        return ZS;
    }

    public static void setUserName(String str) {
        if (ZK != null) {
            com.baidu.crabsdk.c.c.a(ZK.edit().putString("userName", str), false);
        }
    }
}
