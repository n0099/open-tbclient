package cn.com.chinatelecom.gateway.lib.a;

import cn.com.chinatelecom.gateway.lib.CtAuth;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1516a = "e";

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f1517b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append(f1517b[(bArr[i2] >> 4) & 15]);
            sb.append(f1517b[bArr[i2] & 15]);
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
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            int digit = Character.digit(charArray[i3 + 1], 16) | (Character.digit(charArray[i3], 16) << 4);
            if (digit > 127) {
                digit -= 256;
            }
            bArr[i2] = (byte) digit;
        }
        return bArr;
    }

    public static byte[] b(String str) {
        byte[] bArr = new byte[0];
        try {
            return str.getBytes("UTF-8");
        } catch (Throwable th) {
            CtAuth.warn(f1516a, "getBytes error", th);
            return bArr;
        }
    }
}
