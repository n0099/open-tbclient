package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes12.dex */
public final class t {
    private static SharedPreferences amq;
    private static HashMap<String, String> amy = null;
    private static Context mContext;

    public static String R() {
        if (!TextUtils.isEmpty(com.baidu.crabsdk.a.c)) {
            com.baidu.crabsdk.c.a.dh("uid is which user setted " + com.baidu.crabsdk.a.c);
            return com.baidu.crabsdk.a.c;
        } else if (mContext == null) {
            com.baidu.crabsdk.c.a.w("get SharedPreferences error because context is null for unknown reasons!!!");
            return "N/A";
        } else {
            if (amq == null) {
                amq = mContext.getSharedPreferences("crab_user_info", 0);
            }
            String string = amq.getString(TbEnum.SystemMessage.KEY_USER_ID, "");
            if (TextUtils.isEmpty(string)) {
                string = UUID.randomUUID().toString();
                com.baidu.crabsdk.c.c.a(amq.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, string), false);
            }
            com.baidu.crabsdk.c.a.dh("uid is UUID " + string);
            return string;
        }
    }

    public static String T() {
        return amy != null ? com.baidu.crabsdk.sender.i.c(amy) : "";
    }

    public static void a(HashMap<String, String> hashMap) {
        if (amy == null) {
            amy = hashMap;
        } else if (hashMap != null) {
            amy.putAll(hashMap);
        }
    }

    public static void d(String str) {
        com.baidu.crabsdk.a.c = str;
        if (amq == null && mContext != null) {
            amq = mContext.getSharedPreferences("crab_user_info", 0);
        }
        if (amq == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.crabsdk.c.c.a(amq.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, str), false);
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            amq = context.getSharedPreferences("crab_user_info", 0);
        }
    }

    public static String getUserName() {
        return amq != null ? amq.getString(TbEnum.SystemMessage.KEY_USER_NAME, "") : "";
    }

    public static void setUserName(String str) {
        if (amq != null) {
            com.baidu.crabsdk.c.c.a(amq.edit().putString(TbEnum.SystemMessage.KEY_USER_NAME, str), false);
        }
    }

    public static HashMap<String, String> tl() {
        if (amy == null) {
            amy = new HashMap<>();
        }
        return amy;
    }
}
