package com.baidu.android.imsdk.utils;

import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes.dex */
public abstract class BaseUtils {
    public static final String METHOD_RECEIVEESSAGE = "93";
    public static final String METHOD_SENDMESSAGE = "55";

    public static boolean containsEmoji(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (isEmojiCharacter(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static String getMd5(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return Utility.byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e2) {
            LogUtils.e("BaseUtils", "MD5 error " + e2.getMessage());
            return str;
        }
    }

    public static boolean isEmojiCharacter(char c2) {
        return c2 == 0 || c2 == '\t' || c2 == '\n' || c2 == '\r' || (c2 >= ' ' && c2 <= 55295) || ((c2 >= 57344 && c2 <= 65533) || (c2 >= 0 && c2 <= 65535));
    }
}
