package com.baidu.sapi2.utils.b;

import android.text.TextUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.sapi2.utils.L;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes.dex */
public class b {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder("");
            int length = digest.length;
            for (int i = 0; i < length; i++) {
                int i2 = digest[i];
                if (i2 < 0) {
                    i2 += 256;
                }
                if (i2 < 16) {
                    sb.append(SocialConstants.FALSE);
                }
                sb.append(Integer.toHexString(i2));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            L.e(e);
            return "";
        }
    }

    public static String a(byte[] bArr, boolean z) {
        if (bArr == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return a(messageDigest.digest(), "", z);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String a(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null) {
            return sb.toString();
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (z) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append(SocialConstants.FALSE);
            }
            sb.append(hexString).append(str);
        }
        return sb.toString();
    }
}
