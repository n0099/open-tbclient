package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes8.dex */
public final class t {
    private static HashMap<String, String> amD = null;
    private static SharedPreferences amv;
    private static Context mContext;

    public static String T() {
        return amD != null ? com.baidu.crabsdk.sender.i.c(amD) : "";
    }

    public static void a(HashMap<String, String> hashMap) {
        if (amD == null) {
            amD = hashMap;
        } else if (hashMap != null) {
            amD.putAll(hashMap);
        }
    }

    public static void d(String str) {
        com.baidu.crabsdk.a.c = str;
        if (amv == null && mContext != null) {
            amv = mContext.getSharedPreferences("crab_user_info", 0);
        }
        if (amv == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.crabsdk.c.c.a(amv.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, str), false);
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            amv = context.getSharedPreferences("crab_user_info", 0);
        }
    }

    public static String getUserName() {
        return amv != null ? amv.getString(TbEnum.SystemMessage.KEY_USER_NAME, "") : "";
    }

    public static void setUserName(String str) {
        if (amv != null) {
            com.baidu.crabsdk.c.c.a(amv.edit().putString(TbEnum.SystemMessage.KEY_USER_NAME, str), false);
        }
    }

    public static String tk() {
        if (!TextUtils.isEmpty(com.baidu.crabsdk.a.c)) {
            com.baidu.crabsdk.c.a.di("uid is which user setted " + com.baidu.crabsdk.a.c);
            return com.baidu.crabsdk.a.c;
        } else if (mContext == null) {
            com.baidu.crabsdk.c.a.w("get SharedPreferences error because context is null for unknown reasons!!!");
            return "N/A";
        } else {
            if (amv == null) {
                amv = mContext.getSharedPreferences("crab_user_info", 0);
            }
            String string = amv.getString(TbEnum.SystemMessage.KEY_USER_ID, "");
            if (TextUtils.isEmpty(string)) {
                string = UUID.randomUUID().toString();
                com.baidu.crabsdk.c.c.a(amv.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, string), false);
            }
            com.baidu.crabsdk.c.a.di("uid is UUID " + string);
            return string;
        }
    }

    public static HashMap<String, String> tl() {
        if (amD == null) {
            amD = new HashMap<>();
        }
        return amD;
    }
}
