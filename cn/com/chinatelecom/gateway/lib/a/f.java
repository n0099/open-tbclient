package cn.com.chinatelecom.gateway.lib.a;

import com.baidu.webkit.internal.Base64;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1531a = "f";

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f1532b = {68, 64, 94, 49, 69, Base64.INTERNAL_PADDING, 50, 83};

    /* renamed from: c  reason: collision with root package name */
    public static final Charset f1533c = Charset.forName("UTF-8");

    public static String a(byte[] bArr) {
        try {
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                bArr2[i2] = bArr[i2];
                for (byte b2 : f1532b) {
                    bArr2[i2] = (byte) (b2 ^ bArr2[i2]);
                }
            }
            return new String(bArr2);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
