package com.baidu.android.imsdk.utils;

import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes9.dex */
public abstract class BaseUtils {
    public static final String METHOD_RECEIVEESSAGE = "93";
    public static final String METHOD_SENDMESSAGE = "55";

    public static String getMd5(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                return Utility.byte2Hex(messageDigest.digest());
            } catch (NoSuchAlgorithmException e) {
                LogUtils.e("BaseUtils", "MD5 error " + e.getMessage());
                return str;
            }
        }
        return str;
    }

    public static boolean containsEmoji(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (isEmojiCharacter(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean isEmojiCharacter(char c) {
        return c == 0 || c == '\t' || c == '\n' || c == '\r' || (c >= ' ' && c <= 55295) || ((c >= 57344 && c <= 65533) || (c >= 0 && c <= 65535));
    }
}
