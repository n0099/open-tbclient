package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes8.dex */
public final class t {
    private static SharedPreferences RW;
    private static HashMap<String, String> Sf = null;
    private static Context mContext;

    public static void a(HashMap<String, String> hashMap) {
        if (Sf == null) {
            Sf = hashMap;
        } else if (hashMap != null) {
            Sf.putAll(hashMap);
        }
    }

    public static void d(String str) {
        com.baidu.crabsdk.a.c = str;
        if (RW == null && mContext != null) {
            RW = mContext.getSharedPreferences("crab_user_info", 0);
        }
        if (RW == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.crabsdk.c.c.a(RW.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, str), false);
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            RW = context.getSharedPreferences("crab_user_info", 0);
        }
    }

    public static String getUserName() {
        return RW != null ? RW.getString(TbEnum.SystemMessage.KEY_USER_NAME, "") : "";
    }

    public static String on() {
        if (!TextUtils.isEmpty(com.baidu.crabsdk.a.c)) {
            com.baidu.crabsdk.c.a.cj("uid is which user setted " + com.baidu.crabsdk.a.c);
            return com.baidu.crabsdk.a.c;
        } else if (mContext == null) {
            com.baidu.crabsdk.c.a.w("get SharedPreferences error because context is null for unknown reasons!!!");
            return "N/A";
        } else {
            if (RW == null) {
                RW = mContext.getSharedPreferences("crab_user_info", 0);
            }
            String string = RW.getString(TbEnum.SystemMessage.KEY_USER_ID, "");
            if (TextUtils.isEmpty(string)) {
                string = UUID.randomUUID().toString();
                com.baidu.crabsdk.c.c.a(RW.edit().putString(TbEnum.SystemMessage.KEY_USER_ID, string), false);
            }
            com.baidu.crabsdk.c.a.cj("uid is UUID " + string);
            return string;
        }
    }

    public static HashMap<String, String> oo() {
        if (Sf == null) {
            Sf = new HashMap<>();
        }
        return Sf;
    }

    public static String op() {
        return Sf != null ? com.baidu.crabsdk.sender.i.c(Sf) : "";
    }

    public static void setUserName(String str) {
        if (RW != null) {
            com.baidu.crabsdk.c.c.a(RW.edit().putString(TbEnum.SystemMessage.KEY_USER_NAME, str), false);
        }
    }
}
