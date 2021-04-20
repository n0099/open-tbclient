package cn.com.chinatelecom.gateway.lib.a;

import com.baidu.webkit.internal.Base64;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1498a = "f";

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f1499b = {68, 64, 94, 49, 69, Base64.INTERNAL_PADDING, 50, 83};

    /* renamed from: c  reason: collision with root package name */
    public static final Charset f1500c = Charset.forName("UTF-8");

    public static String a(byte[] bArr) {
        try {
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            for (int i = 0; i < length; i++) {
                bArr2[i] = bArr[i];
                for (byte b2 : f1499b) {
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
