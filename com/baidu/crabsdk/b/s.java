package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes3.dex */
public final class s {
    private static SharedPreferences JH;
    private static HashMap<String, String> JP = null;
    private static Context mContext;

    public static String M() {
        if (!TextUtils.isEmpty(com.baidu.crabsdk.a.c)) {
            com.baidu.crabsdk.c.a.bu("uid is which user setted " + com.baidu.crabsdk.a.c);
            return com.baidu.crabsdk.a.c;
        } else if (mContext == null) {
            com.baidu.crabsdk.c.a.w("get SharedPreferences error because context is null for unknown reasons!!!");
            return "N/A";
        } else {
            if (JH == null) {
                JH = mContext.getSharedPreferences("crab_user_info", 0);
            }
            String string = JH.getString(TbEnum.SystemMessage.KEY_USER_ID, "");
            if (TextUtils.isEmpty(string)) {
                string = UUID.randomUUID().toString();
                com.baidu.crabsdk.c.c.a(JH.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, string), false);
            }
            com.baidu.crabsdk.c.a.bu("uid is UUID " + string);
            return string;
        }
    }

    public static String O() {
        return JP != null ? com.baidu.crabsdk.sender.i.c(JP) : "";
    }

    public static void a(HashMap<String, String> hashMap) {
        if (JP == null) {
            JP = hashMap;
        } else if (hashMap != null) {
            JP.putAll(hashMap);
        }
    }

    public static void c(String str) {
        com.baidu.crabsdk.a.c = str;
        if (JH == null && mContext != null) {
            JH = mContext.getSharedPreferences("crab_user_info", 0);
        }
        if (JH == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.crabsdk.c.c.a(JH.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, str), false);
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            JH = context.getSharedPreferences("crab_user_info", 0);
        }
    }

    public static String getUserName() {
        return JH != null ? JH.getString(TbEnum.SystemMessage.KEY_USER_NAME, "") : "";
    }

    public static HashMap<String, String> mr() {
        if (JP == null) {
            JP = new HashMap<>();
        }
        return JP;
    }

    public static void setUserName(String str) {
        if (JH != null) {
            com.baidu.crabsdk.c.c.a(JH.edit().putString(TbEnum.SystemMessage.KEY_USER_NAME, str), false);
        }
    }
}
