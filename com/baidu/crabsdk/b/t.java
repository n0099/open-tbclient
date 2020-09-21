package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes8.dex */
public final class t {
    private static SharedPreferences anW;
    private static HashMap<String, String> aoe = null;
    private static Context mContext;

    public static String R() {
        if (!TextUtils.isEmpty(com.baidu.crabsdk.a.c)) {
            com.baidu.crabsdk.c.a.dv("uid is which user setted " + com.baidu.crabsdk.a.c);
            return com.baidu.crabsdk.a.c;
        } else if (mContext == null) {
            com.baidu.crabsdk.c.a.w("get SharedPreferences error because context is null for unknown reasons!!!");
            return "N/A";
        } else {
            if (anW == null) {
                anW = mContext.getSharedPreferences("crab_user_info", 0);
            }
            String string = anW.getString(TbEnum.SystemMessage.KEY_USER_ID, "");
            if (TextUtils.isEmpty(string)) {
                string = UUID.randomUUID().toString();
                com.baidu.crabsdk.c.c.a(anW.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, string), false);
            }
            com.baidu.crabsdk.c.a.dv("uid is UUID " + string);
            return string;
        }
    }

    public static String T() {
        return aoe != null ? com.baidu.crabsdk.sender.i.c(aoe) : "";
    }

    public static void a(HashMap<String, String> hashMap) {
        if (aoe == null) {
            aoe = hashMap;
        } else if (hashMap != null) {
            aoe.putAll(hashMap);
        }
    }

    public static void d(String str) {
        com.baidu.crabsdk.a.c = str;
        if (anW == null && mContext != null) {
            anW = mContext.getSharedPreferences("crab_user_info", 0);
        }
        if (anW == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.crabsdk.c.c.a(anW.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, str), false);
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            anW = context.getSharedPreferences("crab_user_info", 0);
        }
    }

    public static String getUserName() {
        return anW != null ? anW.getString(TbEnum.SystemMessage.KEY_USER_NAME, "") : "";
    }

    public static void setUserName(String str) {
        if (anW != null) {
            com.baidu.crabsdk.c.c.a(anW.edit().putString(TbEnum.SystemMessage.KEY_USER_NAME, str), false);
        }
    }

    public static HashMap<String, String> vh() {
        if (aoe == null) {
            aoe = new HashMap<>();
        }
        return aoe;
    }
}
