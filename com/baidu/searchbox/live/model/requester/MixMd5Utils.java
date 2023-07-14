package com.baidu.searchbox.live.model.requester;

import java.security.MessageDigest;
import java.util.Locale;
/* loaded from: classes4.dex */
public class MixMd5Utils {
    public static String toHexString(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (z) {
                hexString = hexString.toUpperCase(Locale.getDefault());
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
            sb.append(str);
        }
        return sb.toString();
    }

    public static String toMd5(byte[] bArr, boolean z) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            bArr = messageDigest.digest();
        } catch (Exception unused) {
        }
        return toHexString(bArr, "", z);
    }
}
