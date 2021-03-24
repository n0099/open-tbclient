package com.baidu.android.imsdk.chatuser;

import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class Utility {
    public static final String[] ZXS_LIST = {"北京市", "天津市", "上海市", "重庆市"};

    public static ChatUser contructChatUser(JSONObject jSONObject) {
        long optLong = jSONObject.optLong("to_user");
        long optLong2 = jSONObject.optLong("baidu_uid");
        String optString = jSONObject.optString("user_name");
        String optString2 = jSONObject.optString("sex");
        String optString3 = jSONObject.optString("tinyurl");
        String optString4 = jSONObject.optString("headurl");
        String optString5 = jSONObject.optString("phone");
        String optString6 = jSONObject.optString("userdetail");
        int optInt = jSONObject.optInt("account_type");
        ChatUser chatUser = new ChatUser(optLong, optLong2, optString, optString4);
        chatUser.setUserDetail(optString6);
        chatUser.setTinyUrl(optString3);
        if (!TextUtils.isEmpty(optString2) && TextUtils.isDigitsOnly(optString2)) {
            try {
                chatUser.setSex(Integer.valueOf(optString2).intValue());
            } catch (Exception e2) {
                LogUtils.e("Utility", "contructChatUser sex:", e2);
            }
        }
        if (!TextUtils.isEmpty(optString5) && TextUtils.isDigitsOnly(optString5)) {
            try {
                chatUser.setPhone(Long.valueOf(optString5).longValue());
            } catch (Exception e3) {
                LogUtils.e("Utility", "contructChatUser phone:", e3);
            }
        }
        chatUser.setAccountType(optInt);
        return chatUser;
    }

    public static ChatUser contructChatUserFormUid(JSONObject jSONObject) {
        long optLong = jSONObject.optLong("uk");
        long optLong2 = jSONObject.optLong("baidu_uid");
        String optString = jSONObject.optString("user_name");
        String optString2 = jSONObject.optString("sex");
        String optString3 = jSONObject.optString("tinyurl");
        String optString4 = jSONObject.optString("headurl");
        String optString5 = jSONObject.optString("phone");
        String optString6 = jSONObject.optString("userdetail");
        int optInt = jSONObject.optInt("account_type");
        ChatUser chatUser = new ChatUser(optLong, optLong2, optString, optString4);
        chatUser.setUserDetail(optString6);
        chatUser.setTinyUrl(optString3);
        if (!TextUtils.isEmpty(optString2) && TextUtils.isDigitsOnly(optString2)) {
            try {
                chatUser.setSex(Integer.valueOf(optString2).intValue());
            } catch (Exception e2) {
                LogUtils.e("Utility", "contructChatUserFormUid sex:", e2);
            }
        }
        if (!TextUtils.isEmpty(optString5) && TextUtils.isDigitsOnly(optString5)) {
            try {
                chatUser.setPhone(Long.valueOf(optString5).longValue());
            } catch (Exception e3) {
                LogUtils.e("Utility", "contructChatUserFormUid phone:", e3);
            }
        }
        chatUser.setAccountType(optInt);
        return chatUser;
    }

    public static String createAnonyMousUserName(IpInfo ipInfo) {
        if (ipInfo == null) {
            return "未知地区客户";
        }
        String str = new String();
        if (!TextUtils.isEmpty(ipInfo.getProv())) {
            if (isZhiXiaShi(ipInfo.getProv())) {
                return ipInfo.getProv() + "客户";
            }
            str = str + ipInfo.getProv();
        }
        if (!TextUtils.isEmpty(ipInfo.getCity())) {
            str = str + ipInfo.getCity();
        }
        if (TextUtils.isEmpty(str)) {
            str = ipInfo.getCountry();
        }
        if (TextUtils.isEmpty(str)) {
            str = "未知地区";
        }
        return str + "客户";
    }

    public static boolean isZhiXiaShi(String str) {
        for (String str2 : ZXS_LIST) {
            if (str2.startsWith(str)) {
                return true;
            }
        }
        return false;
    }
}
