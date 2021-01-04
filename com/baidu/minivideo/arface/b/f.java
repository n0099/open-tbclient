package com.baidu.minivideo.arface.b;

import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import java.io.FileInputStream;
import java.security.MessageDigest;
/* loaded from: classes6.dex */
public class f {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String getFileMD5(String str) {
        byte[] bArr = new byte[1024];
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return toHexString(messageDigest.digest());
                }
            }
        } catch (Exception e) {
            return "";
        }
    }

    private static String toHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(HEX_DIGITS[(bArr[i] & 240) >>> 4]);
            sb.append(HEX_DIGITS[bArr[i] & 15]);
        }
        return sb.toString();
    }
}
