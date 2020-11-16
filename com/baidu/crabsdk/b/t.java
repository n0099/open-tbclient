package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes7.dex */
public final class t {
    private static SharedPreferences aoM;
    private static HashMap<String, String> aoU = null;
    private static Context mContext;

    public static String R() {
        if (!TextUtils.isEmpty(com.baidu.crabsdk.a.c)) {
            com.baidu.crabsdk.c.a.dC("uid is which user setted " + com.baidu.crabsdk.a.c);
            return com.baidu.crabsdk.a.c;
        } else if (mContext == null) {
            com.baidu.crabsdk.c.a.w("get SharedPreferences error because context is null for unknown reasons!!!");
            return "N/A";
        } else {
            if (aoM == null) {
                aoM = mContext.getSharedPreferences("crab_user_info", 0);
            }
            String string = aoM.getString(TbEnum.SystemMessage.KEY_USER_ID, "");
            if (TextUtils.isEmpty(string)) {
                string = UUID.randomUUID().toString();
                com.baidu.crabsdk.c.c.a(aoM.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, string), false);
            }
            com.baidu.crabsdk.c.a.dC("uid is UUID " + string);
            return string;
        }
    }

    public static String T() {
        return aoU != null ? com.baidu.crabsdk.sender.i.c(aoU) : "";
    }

    public static void a(HashMap<String, String> hashMap) {
        if (aoU == null) {
            aoU = hashMap;
        } else if (hashMap != null) {
            aoU.putAll(hashMap);
        }
    }

    public static void d(String str) {
        com.baidu.crabsdk.a.c = str;
        if (aoM == null && mContext != null) {
            aoM = mContext.getSharedPreferences("crab_user_info", 0);
        }
        if (aoM == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.crabsdk.c.c.a(aoM.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, str), false);
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            aoM = context.getSharedPreferences("crab_user_info", 0);
        }
    }

    public static String getUserName() {
        return aoM != null ? aoM.getString(TbEnum.SystemMessage.KEY_USER_NAME, "") : "";
    }

    public static void setUserName(String str) {
        if (aoM != null) {
            com.baidu.crabsdk.c.c.a(aoM.edit().putString(TbEnum.SystemMessage.KEY_USER_NAME, str), false);
        }
    }

    public static HashMap<String, String> vp() {
        if (aoU == null) {
            aoU = new HashMap<>();
        }
        return aoU;
    }
}
