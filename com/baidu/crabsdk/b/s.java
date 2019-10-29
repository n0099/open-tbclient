package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes3.dex */
public final class s {
    private static SharedPreferences Kh;
    private static HashMap<String, String> Kp = null;
    private static Context mContext;

    public static String M() {
        if (!TextUtils.isEmpty(com.baidu.crabsdk.a.c)) {
            com.baidu.crabsdk.c.a.bu("uid is which user setted " + com.baidu.crabsdk.a.c);
            return com.baidu.crabsdk.a.c;
        } else if (mContext == null) {
            com.baidu.crabsdk.c.a.w("get SharedPreferences error because context is null for unknown reasons!!!");
            return "N/A";
        } else {
            if (Kh == null) {
                Kh = mContext.getSharedPreferences("crab_user_info", 0);
            }
            String string = Kh.getString(TbEnum.SystemMessage.KEY_USER_ID, "");
            if (TextUtils.isEmpty(string)) {
                string = UUID.randomUUID().toString();
                com.baidu.crabsdk.c.c.a(Kh.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, string), false);
            }
            com.baidu.crabsdk.c.a.bu("uid is UUID " + string);
            return string;
        }
    }

    public static String O() {
        return Kp != null ? com.baidu.crabsdk.sender.i.c(Kp) : "";
    }

    public static void a(HashMap<String, String> hashMap) {
        if (Kp == null) {
            Kp = hashMap;
        } else if (hashMap != null) {
            Kp.putAll(hashMap);
        }
    }

    public static void c(String str) {
        com.baidu.crabsdk.a.c = str;
        if (Kh == null && mContext != null) {
            Kh = mContext.getSharedPreferences("crab_user_info", 0);
        }
        if (Kh == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.crabsdk.c.c.a(Kh.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, str), false);
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            Kh = context.getSharedPreferences("crab_user_info", 0);
        }
    }

    public static String getUserName() {
        return Kh != null ? Kh.getString(TbEnum.SystemMessage.KEY_USER_NAME, "") : "";
    }

    public static HashMap<String, String> mr() {
        if (Kp == null) {
            Kp = new HashMap<>();
        }
        return Kp;
    }

    public static void setUserName(String str) {
        if (Kh != null) {
            com.baidu.crabsdk.c.c.a(Kh.edit().putString(TbEnum.SystemMessage.KEY_USER_NAME, str), false);
        }
    }
}
