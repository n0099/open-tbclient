package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes8.dex */
public final class t {
    private static SharedPreferences akp;
    private static HashMap<String, String> bt = null;
    private static Context mContext;

    public static void a(HashMap<String, String> hashMap) {
        if (bt == null) {
            bt = hashMap;
        } else if (hashMap != null) {
            bt.putAll(hashMap);
        }
    }

    public static void d(String str) {
        com.baidu.crabsdk.a.c = str;
        if (akp == null && mContext != null) {
            akp = mContext.getSharedPreferences("crab_user_info", 0);
        }
        if (akp == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.crabsdk.c.c.a(akp.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, str), false);
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            akp = context.getSharedPreferences("crab_user_info", 0);
        }
    }

    public static String getUserName() {
        return akp != null ? akp.getString(TbEnum.SystemMessage.KEY_USER_NAME, "") : "";
    }

    public static String sH() {
        if (!TextUtils.isEmpty(com.baidu.crabsdk.a.c)) {
            com.baidu.crabsdk.c.a.de("uid is which user setted " + com.baidu.crabsdk.a.c);
            return com.baidu.crabsdk.a.c;
        } else if (mContext == null) {
            com.baidu.crabsdk.c.a.w("get SharedPreferences error because context is null for unknown reasons!!!");
            return "N/A";
        } else {
            if (akp == null) {
                akp = mContext.getSharedPreferences("crab_user_info", 0);
            }
            String string = akp.getString(TbEnum.SystemMessage.KEY_USER_ID, "");
            if (TextUtils.isEmpty(string)) {
                string = UUID.randomUUID().toString();
                com.baidu.crabsdk.c.c.a(akp.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, string), false);
            }
            com.baidu.crabsdk.c.a.de("uid is UUID " + string);
            return string;
        }
    }

    public static HashMap<String, String> sI() {
        if (bt == null) {
            bt = new HashMap<>();
        }
        return bt;
    }

    public static String sJ() {
        return bt != null ? com.baidu.crabsdk.sender.i.c(bt) : "";
    }

    public static void setUserName(String str) {
        if (akp != null) {
            com.baidu.crabsdk.c.c.a(akp.edit().putString(TbEnum.SystemMessage.KEY_USER_NAME, str), false);
        }
    }
}
