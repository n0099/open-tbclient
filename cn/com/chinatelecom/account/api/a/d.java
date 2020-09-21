package cn.com.chinatelecom.account.api.a;

import java.nio.charset.Charset;
/* loaded from: classes14.dex */
public class d {
    private static final String a = d.class.getSimpleName();
    private static final Charset b = Charset.forName("UTF-8");
    private static byte[] c = "D@^12S".getBytes(b);

    public static String a(byte[] bArr) {
        try {
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            for (int i = 0; i < length; i++) {
                bArr2[i] = bArr[i];
                for (byte b2 : c) {
                    bArr2[i] = (byte) (b2 ^ bArr2[i]);
                }
            }
            return new String(bArr2);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
