package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes11.dex */
public final class t {
    private static SharedPreferences aoG;
    private static HashMap<String, String> aoO = null;
    private static Context mContext;

    public static String R() {
        if (!TextUtils.isEmpty(com.baidu.crabsdk.a.c)) {
            com.baidu.crabsdk.c.a.dA("uid is which user setted " + com.baidu.crabsdk.a.c);
            return com.baidu.crabsdk.a.c;
        } else if (mContext == null) {
            com.baidu.crabsdk.c.a.w("get SharedPreferences error because context is null for unknown reasons!!!");
            return "N/A";
        } else {
            if (aoG == null) {
                aoG = mContext.getSharedPreferences("crab_user_info", 0);
            }
            String string = aoG.getString(TbEnum.SystemMessage.KEY_USER_ID, "");
            if (TextUtils.isEmpty(string)) {
                string = UUID.randomUUID().toString();
                com.baidu.crabsdk.c.c.a(aoG.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, string), false);
            }
            com.baidu.crabsdk.c.a.dA("uid is UUID " + string);
            return string;
        }
    }

    public static String T() {
        return aoO != null ? com.baidu.crabsdk.sender.i.c(aoO) : "";
    }

    public static void a(HashMap<String, String> hashMap) {
        if (aoO == null) {
            aoO = hashMap;
        } else if (hashMap != null) {
            aoO.putAll(hashMap);
        }
    }

    public static void d(String str) {
        com.baidu.crabsdk.a.c = str;
        if (aoG == null && mContext != null) {
            aoG = mContext.getSharedPreferences("crab_user_info", 0);
        }
        if (aoG == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.crabsdk.c.c.a(aoG.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, str), false);
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            aoG = context.getSharedPreferences("crab_user_info", 0);
        }
    }

    public static String getUserName() {
        return aoG != null ? aoG.getString(TbEnum.SystemMessage.KEY_USER_NAME, "") : "";
    }

    public static void setUserName(String str) {
        if (aoG != null) {
            com.baidu.crabsdk.c.c.a(aoG.edit().putString(TbEnum.SystemMessage.KEY_USER_NAME, str), false);
        }
    }

    public static HashMap<String, String> vq() {
        if (aoO == null) {
            aoO = new HashMap<>();
        }
        return aoO;
    }
}
