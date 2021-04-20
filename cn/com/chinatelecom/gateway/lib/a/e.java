package cn.com.chinatelecom.gateway.lib.a;

import cn.com.chinatelecom.gateway.lib.CtAuth;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1496a = "e";

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f1497b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            sb.append(f1497b[(bArr[i] >> 4) & 15]);
            sb.append(f1497b[bArr[i] & 15]);
        }
        return sb.toString();
    }

    public static byte[] a(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            int digit = Character.digit(charArray[i2 + 1], 16) | (Character.digit(charArray[i2], 16) << 4);
            if (digit > 127) {
                digit -= 256;
            }
            bArr[i] = (byte) digit;
        }
        return bArr;
    }

    public static byte[] b(String str) {
        byte[] bArr = new byte[0];
        try {
            return str.getBytes("UTF-8");
        } catch (Throwable th) {
            CtAuth.warn(f1496a, "getBytes error", th);
            return bArr;
        }
    }
}
