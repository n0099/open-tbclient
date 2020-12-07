package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes8.dex */
public final class t {
    private static SharedPreferences apE;
    private static HashMap<String, String> apM = null;
    private static Context mContext;

    public static String R() {
        if (!TextUtils.isEmpty(com.baidu.crabsdk.a.c)) {
            com.baidu.crabsdk.c.a.dE("uid is which user setted " + com.baidu.crabsdk.a.c);
            return com.baidu.crabsdk.a.c;
        } else if (mContext == null) {
            com.baidu.crabsdk.c.a.w("get SharedPreferences error because context is null for unknown reasons!!!");
            return "N/A";
        } else {
            if (apE == null) {
                apE = mContext.getSharedPreferences("crab_user_info", 0);
            }
            String string = apE.getString(TbEnum.SystemMessage.KEY_USER_ID, "");
            if (TextUtils.isEmpty(string)) {
                string = UUID.randomUUID().toString();
                com.baidu.crabsdk.c.c.a(apE.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, string), false);
            }
            com.baidu.crabsdk.c.a.dE("uid is UUID " + string);
            return string;
        }
    }

    public static String T() {
        return apM != null ? com.baidu.crabsdk.sender.i.c(apM) : "";
    }

    public static void a(HashMap<String, String> hashMap) {
        if (apM == null) {
            apM = hashMap;
        } else if (hashMap != null) {
            apM.putAll(hashMap);
        }
    }

    public static void d(String str) {
        com.baidu.crabsdk.a.c = str;
        if (apE == null && mContext != null) {
            apE = mContext.getSharedPreferences("crab_user_info", 0);
        }
        if (apE == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.crabsdk.c.c.a(apE.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, str), false);
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            apE = context.getSharedPreferences("crab_user_info", 0);
        }
    }

    public static String getUserName() {
        return apE != null ? apE.getString(TbEnum.SystemMessage.KEY_USER_NAME, "") : "";
    }

    public static void setUserName(String str) {
        if (apE != null) {
            com.baidu.crabsdk.c.c.a(apE.edit().putString(TbEnum.SystemMessage.KEY_USER_NAME, str), false);
        }
    }

    public static HashMap<String, String> ve() {
        if (apM == null) {
            apM = new HashMap<>();
        }
        return apM;
    }
}
