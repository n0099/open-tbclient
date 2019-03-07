package cn.jiguang.api.a;

import cn.jiguang.api.h;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public class c {
    public static byte[] G(String str) {
        byte[] bArr;
        if (str == null || "".equals(str)) {
            return new byte[]{0, 0};
        }
        try {
            bArr = str.getBytes(HTTP.UTF_8);
        } catch (UnsupportedEncodingException e) {
            bArr = null;
        }
        if (bArr == null) {
            return new byte[]{0, 0};
        }
        short length = (short) bArr.length;
        byte[] bArr2 = new byte[length + 2];
        System.arraycopy(c(length), 0, bArr2, 0, 2);
        System.arraycopy(bArr, 0, bArr2, 2, length);
        return bArr2;
    }

    public static byte[] c(short s) {
        return new byte[]{(byte) (s >>> 8), (byte) s};
    }

    public static String e(ByteBuffer byteBuffer, h hVar) {
        int b = a.b(byteBuffer, hVar);
        if (b < 0) {
            return null;
        }
        byte[] bArr = new byte[b];
        a.a(byteBuffer, bArr, hVar);
        try {
            return new String(bArr, HTTP.UTF_8);
        } catch (Throwable th) {
            return null;
        }
    }

    public static byte[] g(ByteBuffer byteBuffer) {
        try {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return bArr;
        } catch (NegativeArraySizeException e) {
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    public static byte[] h(ByteBuffer byteBuffer) {
        try {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.asReadOnlyBuffer().flip();
            byteBuffer.get(bArr);
            return bArr;
        } catch (NegativeArraySizeException e) {
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    public static String i(ByteBuffer byteBuffer) {
        try {
            byte[] bArr = new byte[byteBuffer.getShort()];
            byteBuffer.get(bArr);
            return new String(bArr, HTTP.UTF_8);
        } catch (UnsupportedEncodingException | Exception e) {
            return null;
        }
    }
}
