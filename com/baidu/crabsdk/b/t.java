package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes5.dex */
public final class t {
    private static SharedPreferences apb;
    private static HashMap<String, String> apj = null;
    private static Context mContext;

    public static String R() {
        if (!TextUtils.isEmpty(com.baidu.crabsdk.a.c)) {
            com.baidu.crabsdk.c.a.ds("uid is which user setted " + com.baidu.crabsdk.a.c);
            return com.baidu.crabsdk.a.c;
        } else if (mContext == null) {
            com.baidu.crabsdk.c.a.w("get SharedPreferences error because context is null for unknown reasons!!!");
            return "N/A";
        } else {
            if (apb == null) {
                apb = mContext.getSharedPreferences("crab_user_info", 0);
            }
            String string = apb.getString(TbEnum.SystemMessage.KEY_USER_ID, "");
            if (TextUtils.isEmpty(string)) {
                string = UUID.randomUUID().toString();
                com.baidu.crabsdk.c.c.a(apb.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, string), false);
            }
            com.baidu.crabsdk.c.a.ds("uid is UUID " + string);
            return string;
        }
    }

    public static String T() {
        return apj != null ? com.baidu.crabsdk.sender.i.c(apj) : "";
    }

    public static void a(HashMap<String, String> hashMap) {
        if (apj == null) {
            apj = hashMap;
        } else if (hashMap != null) {
            apj.putAll(hashMap);
        }
    }

    public static void d(String str) {
        com.baidu.crabsdk.a.c = str;
        if (apb == null && mContext != null) {
            apb = mContext.getSharedPreferences("crab_user_info", 0);
        }
        if (apb == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.crabsdk.c.c.a(apb.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, str), false);
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            apb = context.getSharedPreferences("crab_user_info", 0);
        }
    }

    public static String getUserName() {
        return apb != null ? apb.getString(TbEnum.SystemMessage.KEY_USER_NAME, "") : "";
    }

    public static void setUserName(String str) {
        if (apb != null) {
            com.baidu.crabsdk.c.c.a(apb.edit().putString(TbEnum.SystemMessage.KEY_USER_NAME, str), false);
        }
    }

    public static HashMap<String, String> uq() {
        if (apj == null) {
            apj = new HashMap<>();
        }
        return apj;
    }
}
