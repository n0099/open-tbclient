package com.baidu.cyberplayer.sdk.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
/* loaded from: classes3.dex */
public class b {
    public static String a(File file) {
        if (file != null && file.isFile()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                String a = a(fileInputStream);
                fileInputStream.close();
                return a;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String a(InputStream inputStream) {
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

    public static String a(byte[] bArr) {
        if (bArr != null && bArr.length >= 1) {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                String a = a(byteArrayInputStream);
                byteArrayInputStream.close();
                return a;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
