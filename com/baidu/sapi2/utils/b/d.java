package com.baidu.sapi2.utils.b;

import com.baidu.sapi2.utils.L;
import java.security.MessageDigest;
/* loaded from: classes.dex */
public class d {
    private static char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static MessageDigest b;

    static {
        b = null;
        try {
            b = MessageDigest.getInstance("MD5");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String a(String str) {
        try {
            return a(str.getBytes());
        } catch (Throwable th) {
            L.e(th);
            return "";
        }
    }

    public static String a(byte[] bArr) {
        b.update(bArr);
        return b(b.digest());
    }

    private static String b(byte[] bArr) {
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

    private static void a(byte b2, StringBuffer stringBuffer) {
        char c = a[(b2 & 240) >> 4];
        char c2 = a[b2 & 15];
        stringBuffer.append(c);
        stringBuffer.append(c2);
    }
}
