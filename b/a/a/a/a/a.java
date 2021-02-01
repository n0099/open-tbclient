package b.a.a.a.a;

import com.baidu.android.imsdk.internal.Constants;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes15.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f1046a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f1047b = {84, Constants.SHORT_PING_CMD_TYPE, 110, 99, Constants.SHORT_PING_CMD_TYPE, 110, 116, 76, 111, 99, 97, 116, 105, 111, 110, 49};

    public static byte[] a(byte[] bArr, String str) {
        return b(bArr, str);
    }

    private static byte[] b(byte[] bArr, String str) {
        if (bArr == null || bArr.length == 0) {
            return f1046a;
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes("UTF-8"), com.baidu.sapi2.utils.e.q);
            Cipher cipher = Cipher.getInstance(com.baidu.sapi2.utils.e.p);
            cipher.init(1, secretKeySpec, new IvParameterSpec(f1047b));
            return cipher == null ? f1046a : cipher.doFinal(bArr);
        } catch (Throwable th) {
            return f1046a;
        }
    }
}
