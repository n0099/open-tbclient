package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes11.dex */
public final class t {
    private static SharedPreferences aoF;
    private static HashMap<String, String> aoN = null;
    private static Context mContext;

    public static String R() {
        if (!TextUtils.isEmpty(com.baidu.crabsdk.a.c)) {
            com.baidu.crabsdk.c.a.dA("uid is which user setted " + com.baidu.crabsdk.a.c);
            return com.baidu.crabsdk.a.c;
        } else if (mContext == null) {
            com.baidu.crabsdk.c.a.w("get SharedPreferences error because context is null for unknown reasons!!!");
            return "N/A";
        } else {
            if (aoF == null) {
                aoF = mContext.getSharedPreferences("crab_user_info", 0);
            }
            String string = aoF.getString(TbEnum.SystemMessage.KEY_USER_ID, "");
            if (TextUtils.isEmpty(string)) {
                string = UUID.randomUUID().toString();
                com.baidu.crabsdk.c.c.a(aoF.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, string), false);
            }
            com.baidu.crabsdk.c.a.dA("uid is UUID " + string);
            return string;
        }
    }

    public static String T() {
        return aoN != null ? com.baidu.crabsdk.sender.i.c(aoN) : "";
    }

    public static void a(HashMap<String, String> hashMap) {
        if (aoN == null) {
            aoN = hashMap;
        } else if (hashMap != null) {
            aoN.putAll(hashMap);
        }
    }

    public static void d(String str) {
        com.baidu.crabsdk.a.c = str;
        if (aoF == null && mContext != null) {
            aoF = mContext.getSharedPreferences("crab_user_info", 0);
        }
        if (aoF == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.crabsdk.c.c.a(aoF.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, str), false);
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            aoF = context.getSharedPreferences("crab_user_info", 0);
        }
    }

    public static String getUserName() {
        return aoF != null ? aoF.getString(TbEnum.SystemMessage.KEY_USER_NAME, "") : "";
    }

    public static void setUserName(String str) {
        if (aoF != null) {
            com.baidu.crabsdk.c.c.a(aoF.edit().putString(TbEnum.SystemMessage.KEY_USER_NAME, str), false);
        }
    }

    public static HashMap<String, String> vq() {
        if (aoN == null) {
            aoN = new HashMap<>();
        }
        return aoN;
    }
}
