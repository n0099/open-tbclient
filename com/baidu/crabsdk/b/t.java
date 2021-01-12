package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes14.dex */
public final class t {
    private static SharedPreferences apm;
    private static HashMap<String, String> apv = null;
    private static Context mContext;

    public static String R() {
        if (!TextUtils.isEmpty(com.baidu.crabsdk.a.c)) {
            com.baidu.crabsdk.c.a.ds("uid is which user setted " + com.baidu.crabsdk.a.c);
            return com.baidu.crabsdk.a.c;
        } else if (mContext == null) {
            com.baidu.crabsdk.c.a.w("get SharedPreferences error because context is null for unknown reasons!!!");
            return "N/A";
        } else {
            if (apm == null) {
                apm = mContext.getSharedPreferences("crab_user_info", 0);
            }
            String string = apm.getString(TbEnum.SystemMessage.KEY_USER_ID, "");
            if (TextUtils.isEmpty(string)) {
                string = UUID.randomUUID().toString();
                com.baidu.crabsdk.c.c.a(apm.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, string), false);
            }
            com.baidu.crabsdk.c.a.ds("uid is UUID " + string);
            return string;
        }
    }

    public static String T() {
        return apv != null ? com.baidu.crabsdk.sender.i.c(apv) : "";
    }

    public static void a(HashMap<String, String> hashMap) {
        if (apv == null) {
            apv = hashMap;
        } else if (hashMap != null) {
            apv.putAll(hashMap);
        }
    }

    public static void d(String str) {
        com.baidu.crabsdk.a.c = str;
        if (apm == null && mContext != null) {
            apm = mContext.getSharedPreferences("crab_user_info", 0);
        }
        if (apm == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.crabsdk.c.c.a(apm.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, str), false);
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            apm = context.getSharedPreferences("crab_user_info", 0);
        }
    }

    public static String getUserName() {
        return apm != null ? apm.getString(TbEnum.SystemMessage.KEY_USER_NAME, "") : "";
    }

    public static void setUserName(String str) {
        if (apm != null) {
            com.baidu.crabsdk.c.c.a(apm.edit().putString(TbEnum.SystemMessage.KEY_USER_NAME, str), false);
        }
    }

    public static HashMap<String, String> ut() {
        if (apv == null) {
            apv = new HashMap<>();
        }
        return apv;
    }
}
