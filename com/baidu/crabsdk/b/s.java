package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes5.dex */
public final class s {
    private static SharedPreferences Qk;
    private static HashMap<String, String> Qs = null;
    private static Context mContext;

    public static String M() {
        if (!TextUtils.isEmpty(com.baidu.crabsdk.a.c)) {
            com.baidu.crabsdk.c.a.cb("uid is which user setted " + com.baidu.crabsdk.a.c);
            return com.baidu.crabsdk.a.c;
        } else if (mContext == null) {
            com.baidu.crabsdk.c.a.w("get SharedPreferences error because context is null for unknown reasons!!!");
            return "N/A";
        } else {
            if (Qk == null) {
                Qk = mContext.getSharedPreferences("crab_user_info", 0);
            }
            String string = Qk.getString(TbEnum.SystemMessage.KEY_USER_ID, "");
            if (TextUtils.isEmpty(string)) {
                string = UUID.randomUUID().toString();
                com.baidu.crabsdk.c.c.a(Qk.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, string), false);
            }
            com.baidu.crabsdk.c.a.cb("uid is UUID " + string);
            return string;
        }
    }

    public static String O() {
        return Qs != null ? com.baidu.crabsdk.sender.i.c(Qs) : "";
    }

    public static void a(HashMap<String, String> hashMap) {
        if (Qs == null) {
            Qs = hashMap;
        } else if (hashMap != null) {
            Qs.putAll(hashMap);
        }
    }

    public static void c(String str) {
        com.baidu.crabsdk.a.c = str;
        if (Qk == null && mContext != null) {
            Qk = mContext.getSharedPreferences("crab_user_info", 0);
        }
        if (Qk == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.crabsdk.c.c.a(Qk.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, str), false);
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            Qk = context.getSharedPreferences("crab_user_info", 0);
        }
    }

    public static String getUserName() {
        return Qk != null ? Qk.getString(TbEnum.SystemMessage.KEY_USER_NAME, "") : "";
    }

    public static HashMap<String, String> nA() {
        if (Qs == null) {
            Qs = new HashMap<>();
        }
        return Qs;
    }

    public static void setUserName(String str) {
        if (Qk != null) {
            com.baidu.crabsdk.c.c.a(Qk.edit().putString(TbEnum.SystemMessage.KEY_USER_NAME, str), false);
        }
    }
}
