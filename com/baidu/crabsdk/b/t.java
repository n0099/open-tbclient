package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes3.dex */
public final class t {
    private static SharedPreferences aqa;
    private static HashMap<String, String> aqi = null;
    private static Context mContext;

    public static String R() {
        if (!TextUtils.isEmpty(com.baidu.crabsdk.a.c)) {
            com.baidu.crabsdk.c.a.dx("uid is which user setted " + com.baidu.crabsdk.a.c);
            return com.baidu.crabsdk.a.c;
        } else if (mContext == null) {
            com.baidu.crabsdk.c.a.w("get SharedPreferences error because context is null for unknown reasons!!!");
            return "N/A";
        } else {
            if (aqa == null) {
                aqa = mContext.getSharedPreferences("crab_user_info", 0);
            }
            String string = aqa.getString(TbEnum.SystemMessage.KEY_USER_ID, "");
            if (TextUtils.isEmpty(string)) {
                string = UUID.randomUUID().toString();
                com.baidu.crabsdk.c.c.a(aqa.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, string), false);
            }
            com.baidu.crabsdk.c.a.dx("uid is UUID " + string);
            return string;
        }
    }

    public static String T() {
        return aqi != null ? com.baidu.crabsdk.sender.i.c(aqi) : "";
    }

    public static void a(HashMap<String, String> hashMap) {
        if (aqi == null) {
            aqi = hashMap;
        } else if (hashMap != null) {
            aqi.putAll(hashMap);
        }
    }

    public static void d(String str) {
        com.baidu.crabsdk.a.c = str;
        if (aqa == null && mContext != null) {
            aqa = mContext.getSharedPreferences("crab_user_info", 0);
        }
        if (aqa == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.crabsdk.c.c.a(aqa.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, str), false);
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            aqa = context.getSharedPreferences("crab_user_info", 0);
        }
    }

    public static String getUserName() {
        return aqa != null ? aqa.getString(TbEnum.SystemMessage.KEY_USER_NAME, "") : "";
    }

    public static void setUserName(String str) {
        if (aqa != null) {
            com.baidu.crabsdk.c.c.a(aqa.edit().putString(TbEnum.SystemMessage.KEY_USER_NAME, str), false);
        }
    }

    public static HashMap<String, String> uz() {
        if (aqi == null) {
            aqi = new HashMap<>();
        }
        return aqi;
    }
}
