package com.baidu.cyberplayer.sdk.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
/* loaded from: classes3.dex */
public class MD5Utils {
    public static final String ENCODING_ALGORITHM = "MD5";
    public static final int READ_SIZE = 1024;

    public static String computeMD5Hash(File file) {
        if (file != null && file.isFile()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                String computeMD5Hash = computeMD5Hash(fileInputStream);
                fileInputStream.close();
                return computeMD5Hash;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String computeMD5Hash(InputStream inputStream) {
        int i;
        if (inputStream == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr, 0, 1024);
                if (read == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
            }
            byte[] digest = messageDigest.digest();
            char[] charArray = "0123456789abcdef".toCharArray();
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (i = 0; i < digest.length; i++) {
                sb.append(charArray[(digest[i] >> 4) & 15]);
                sb.append(charArray[digest[i] & 15]);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String computeMD5Hash(byte[] bArr) {
        if (bArr != null && bArr.length >= 1) {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                String computeMD5Hash = computeMD5Hash(byteArrayInputStream);
                byteArrayInputStream.close();
                return computeMD5Hash;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
