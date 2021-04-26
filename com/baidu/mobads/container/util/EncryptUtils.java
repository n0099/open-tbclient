package com.baidu.mobads.container.util;

import java.security.MessageDigest;
/* loaded from: classes2.dex */
public class EncryptUtils {
    public static final String TAG = "EncryptUtils";

    public static String getMD5(String str) {
        byte[] bytes = str.getBytes();
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[32];
            int i2 = 0;
            for (int i3 = 0; i3 < 16; i3++) {
                byte b2 = digest[i3];
                int i4 = i2 + 1;
                cArr2[i2] = cArr[(b2 >>> 4) & 15];
                i2 = i4 + 1;
                cArr2[i4] = cArr[b2 & 15];
            }
            return new String(cArr2);
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().e(TAG, "", e2);
            return null;
        }
    }
}
