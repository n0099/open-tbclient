package b.a.a.a.a;

import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes4.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f1068a = new byte[0];

    private static byte[] a(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            bArr2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return bArr2;
        } catch (Throwable th) {
            th.printStackTrace();
            return bArr2;
        }
    }

    public static byte[] a(byte[] bArr, String str) {
        if (bArr == null || bArr.length == 0) {
            return f1068a;
        }
        byte[] a2 = a.a(a(bArr), str);
        if (a2 == null || a2.length == 0) {
            return f1068a;
        }
        byte[] bArr2 = new byte[a2.length + 2];
        int length = a2.length;
        byte[] bArr3 = new byte[2];
        for (int i = 0; i < 2; i++) {
            bArr3[i] = Integer.valueOf(length & 255).byteValue();
            length >>= 8;
        }
        System.arraycopy(bArr3, 0, bArr2, 0, 2);
        System.arraycopy(a2, 0, bArr2, 2, a2.length);
        return bArr2;
    }
}
