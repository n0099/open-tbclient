package b.a.a.a.a;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes15.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f1064a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f1065b = {93629, 99879, 79843, 75029, 59699, 55667, 46867, 38039};

    public static byte[] a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ (f1065b[i & 7] & 255));
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr, String str) {
        return b(bArr, str);
    }

    private static byte[] b(byte[] bArr, String str) {
        if (bArr == null || bArr.length == 0) {
            return f1064a;
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes("UTF-8"), com.baidu.sapi2.utils.e.q);
            Cipher cipher = Cipher.getInstance(new String(Base64.decode("QUVTL0VDQi9Ob1BhZGRpbmc=", 2)));
            cipher.init(1, secretKeySpec);
            if (cipher == null) {
                return f1064a;
            }
            int length = bArr.length;
            int i = 0;
            while (i < length) {
                if (i + 16 > length) {
                    while (i < length) {
                        bArr[i] = (byte) (bArr[i] ^ 91);
                        i++;
                    }
                    return bArr;
                }
                cipher.doFinal(bArr, i, 16, bArr, i);
                i += 16;
            }
            return bArr;
        } catch (Throwable th) {
            return f1064a;
        }
    }
}
