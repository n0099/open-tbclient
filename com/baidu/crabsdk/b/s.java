package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes8.dex */
public final class s {
    private static SharedPreferences RU;
    private static HashMap<String, String> Sc = null;
    private static Context mContext;

    public static String M() {
        if (!TextUtils.isEmpty(com.baidu.crabsdk.a.c)) {
            com.baidu.crabsdk.c.a.cj("uid is which user setted " + com.baidu.crabsdk.a.c);
            return com.baidu.crabsdk.a.c;
        } else if (mContext == null) {
            com.baidu.crabsdk.c.a.w("get SharedPreferences error because context is null for unknown reasons!!!");
            return "N/A";
        } else {
            if (RU == null) {
                RU = mContext.getSharedPreferences("crab_user_info", 0);
            }
            String string = RU.getString(TbEnum.SystemMessage.KEY_USER_ID, "");
            if (TextUtils.isEmpty(string)) {
                string = UUID.randomUUID().toString();
                com.baidu.crabsdk.c.c.a(RU.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, string), false);
            }
            com.baidu.crabsdk.c.a.cj("uid is UUID " + string);
            return string;
        }
    }

    public static String O() {
        return Sc != null ? com.baidu.crabsdk.sender.i.c(Sc) : "";
    }

    public static void a(HashMap<String, String> hashMap) {
        if (Sc == null) {
            Sc = hashMap;
        } else if (hashMap != null) {
            Sc.putAll(hashMap);
        }
    }

    public static void c(String str) {
        com.baidu.crabsdk.a.c = str;
        if (RU == null && mContext != null) {
            RU = mContext.getSharedPreferences("crab_user_info", 0);
        }
        if (RU == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.crabsdk.c.c.a(RU.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, str), false);
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            RU = context.getSharedPreferences("crab_user_info", 0);
        }
    }

    public static String getUserName() {
        return RU != null ? RU.getString(TbEnum.SystemMessage.KEY_USER_NAME, "") : "";
    }

    public static HashMap<String, String> ok() {
        if (Sc == null) {
            Sc = new HashMap<>();
        }
        return Sc;
    }

    public static void setUserName(String str) {
        if (RU != null) {
            com.baidu.crabsdk.c.c.a(RU.edit().putString(TbEnum.SystemMessage.KEY_USER_NAME, str), false);
        }
    }
}
