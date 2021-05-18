package com.baidu.clientupdate.d;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static char[] f4601a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(File file) {
        return a(file, 131072);
    }

    public static String a(File file, int i2) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException unused) {
            messageDigest = null;
        }
        if (messageDigest == null) {
            return "";
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[i2];
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

    public static String a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static String a(byte[] bArr, int i2, int i3) {
        StringBuffer stringBuffer = new StringBuffer(i3 * 2);
        int i4 = i3 + i2;
        while (i2 < i4) {
            a(bArr[i2], stringBuffer);
            i2++;
        }
        return stringBuffer.toString();
    }

    public static void a(byte b2, StringBuffer stringBuffer) {
        char[] cArr = f4601a;
        char c2 = cArr[(b2 & 240) >> 4];
        char c3 = cArr[b2 & 15];
        stringBuffer.append(c2);
        stringBuffer.append(c3);
    }
}
