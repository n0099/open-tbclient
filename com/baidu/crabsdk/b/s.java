package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.sapi2.base.network.Apn;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes3.dex */
public final class s {
    private static SharedPreferences ZJ;
    private static HashMap<String, String> ZR = null;
    private static Context mContext;

    public static String M() {
        if (!TextUtils.isEmpty(com.baidu.crabsdk.a.c)) {
            com.baidu.crabsdk.c.a.cf("uid is which user setted " + com.baidu.crabsdk.a.c);
            return com.baidu.crabsdk.a.c;
        } else if (mContext == null) {
            com.baidu.crabsdk.c.a.w("get SharedPreferences error because context is null for unknown reasons!!!");
            return Apn.APN_UNKNOWN;
        } else {
            if (ZJ == null) {
                ZJ = mContext.getSharedPreferences("crab_user_info", 0);
            }
            String string = ZJ.getString("userId", "");
            if (TextUtils.isEmpty(string)) {
                string = UUID.randomUUID().toString();
                com.baidu.crabsdk.c.c.a(ZJ.edit().putString("userId", string), false);
            }
            com.baidu.crabsdk.c.a.cf("uid is UUID " + string);
            return string;
        }
    }

    public static String O() {
        return ZR != null ? com.baidu.crabsdk.sender.i.c(ZR) : "";
    }

    public static void a(HashMap<String, String> hashMap) {
        if (ZR == null) {
            ZR = hashMap;
        } else if (hashMap != null) {
            ZR.putAll(hashMap);
        }
    }

    public static void c(String str) {
        com.baidu.crabsdk.a.c = str;
        if (ZJ == null && mContext != null) {
            ZJ = mContext.getSharedPreferences("crab_user_info", 0);
        }
        if (ZJ == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.crabsdk.c.c.a(ZJ.edit().putString("userId", str), false);
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            ZJ = context.getSharedPreferences("crab_user_info", 0);
        }
    }

    public static String getUserName() {
        return ZJ != null ? ZJ.getString("userName", "") : "";
    }

    public static HashMap<String, String> qP() {
        if (ZR == null) {
            ZR = new HashMap<>();
        }
        return ZR;
    }

    public static void setUserName(String str) {
        if (ZJ != null) {
            com.baidu.crabsdk.c.c.a(ZJ.edit().putString("userName", str), false);
        }
    }
}
