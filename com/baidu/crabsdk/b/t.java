package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes5.dex */
public final class t {
    private static SharedPreferences aqC;
    private static HashMap<String, String> aqK = null;
    private static Context mContext;

    public static String R() {
        if (!TextUtils.isEmpty(com.baidu.crabsdk.a.c)) {
            com.baidu.crabsdk.c.a.dw("uid is which user setted " + com.baidu.crabsdk.a.c);
            return com.baidu.crabsdk.a.c;
        } else if (mContext == null) {
            com.baidu.crabsdk.c.a.w("get SharedPreferences error because context is null for unknown reasons!!!");
            return "N/A";
        } else {
            if (aqC == null) {
                aqC = mContext.getSharedPreferences("crab_user_info", 0);
            }
            String string = aqC.getString(TbEnum.SystemMessage.KEY_USER_ID, "");
            if (TextUtils.isEmpty(string)) {
                string = UUID.randomUUID().toString();
                com.baidu.crabsdk.c.c.a(aqC.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, string), false);
            }
            com.baidu.crabsdk.c.a.dw("uid is UUID " + string);
            return string;
        }
    }

    public static String T() {
        return aqK != null ? com.baidu.crabsdk.sender.i.c(aqK) : "";
    }

    public static void a(HashMap<String, String> hashMap) {
        if (aqK == null) {
            aqK = hashMap;
        } else if (hashMap != null) {
            aqK.putAll(hashMap);
        }
    }

    public static void d(String str) {
        com.baidu.crabsdk.a.c = str;
        if (aqC == null && mContext != null) {
            aqC = mContext.getSharedPreferences("crab_user_info", 0);
        }
        if (aqC == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.crabsdk.c.c.a(aqC.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, str), false);
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            aqC = context.getSharedPreferences("crab_user_info", 0);
        }
    }

    public static String getUserName() {
        return aqC != null ? aqC.getString(TbEnum.SystemMessage.KEY_USER_NAME, "") : "";
    }

    public static void setUserName(String str) {
        if (aqC != null) {
            com.baidu.crabsdk.c.c.a(aqC.edit().putString(TbEnum.SystemMessage.KEY_USER_NAME, str), false);
        }
    }

    public static HashMap<String, String> us() {
        if (aqK == null) {
            aqK = new HashMap<>();
        }
        return aqK;
    }
}
