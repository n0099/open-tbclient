package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes6.dex */
public final class t {
    private static HashMap<String, String> anC = null;
    private static SharedPreferences anu;
    private static Context mContext;

    public static String R() {
        if (!TextUtils.isEmpty(com.baidu.crabsdk.a.c)) {
            com.baidu.crabsdk.c.a.dt("uid is which user setted " + com.baidu.crabsdk.a.c);
            return com.baidu.crabsdk.a.c;
        } else if (mContext == null) {
            com.baidu.crabsdk.c.a.w("get SharedPreferences error because context is null for unknown reasons!!!");
            return "N/A";
        } else {
            if (anu == null) {
                anu = mContext.getSharedPreferences("crab_user_info", 0);
            }
            String string = anu.getString(TbEnum.SystemMessage.KEY_USER_ID, "");
            if (TextUtils.isEmpty(string)) {
                string = UUID.randomUUID().toString();
                com.baidu.crabsdk.c.c.a(anu.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, string), false);
            }
            com.baidu.crabsdk.c.a.dt("uid is UUID " + string);
            return string;
        }
    }

    public static String T() {
        return anC != null ? com.baidu.crabsdk.sender.i.c(anC) : "";
    }

    public static void a(HashMap<String, String> hashMap) {
        if (anC == null) {
            anC = hashMap;
        } else if (hashMap != null) {
            anC.putAll(hashMap);
        }
    }

    public static void d(String str) {
        com.baidu.crabsdk.a.c = str;
        if (anu == null && mContext != null) {
            anu = mContext.getSharedPreferences("crab_user_info", 0);
        }
        if (anu == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.crabsdk.c.c.a(anu.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, str), false);
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            anu = context.getSharedPreferences("crab_user_info", 0);
        }
    }

    public static String getUserName() {
        return anu != null ? anu.getString(TbEnum.SystemMessage.KEY_USER_NAME, "") : "";
    }

    public static void setUserName(String str) {
        if (anu != null) {
            com.baidu.crabsdk.c.c.a(anu.edit().putString(TbEnum.SystemMessage.KEY_USER_NAME, str), false);
        }
    }

    public static HashMap<String, String> uT() {
        if (anC == null) {
            anC = new HashMap<>();
        }
        return anC;
    }
}
