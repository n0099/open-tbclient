package com.baidu.clientupdate.d;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes17.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    protected static char[] f1328a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(File file) {
        return a(file, 131072);
    }

    public static String a(File file, int i) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
        }
        if (messageDigest == null) {
            return "";
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[i];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read <= 0) {
                fileInputStream.close();
                try {
                    return a(messageDigest.digest());
                } catch (Exception e2) {
                    throw new IOException(e2.toString());
                }
            }
            messageDigest.update(bArr, 0, read);
        }
    }

    private static String a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    private static String a(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer(i2 * 2);
        int i3 = i + i2;
        while (i < i3) {
            a(bArr[i], stringBuffer);
            i++;
        }
        return stringBuffer.toString();
    }

    private static void a(byte b, StringBuffer stringBuffer) {
        char c = f1328a[(b & 240) >> 4];
        char c2 = f1328a[b & 15];
        stringBuffer.append(c);
        stringBuffer.append(c2);
    }
}
