package cn.jiguang.d.h;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes3.dex */
public final class x {
    public static byte[] a(byte[] bArr) {
        GZIPOutputStream gZIPOutputStream;
        if (bArr != null && bArr.length != 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream = null;
            }
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.close();
                bArr = byteArrayOutputStream.toByteArray();
                cn.jiguang.g.f.a(byteArrayOutputStream);
                cn.jiguang.g.f.a(gZIPOutputStream);
            } catch (Throwable th2) {
                th = th2;
                cn.jiguang.g.f.a(byteArrayOutputStream);
                cn.jiguang.g.f.a(gZIPOutputStream);
                throw th;
            }
        }
        return bArr;
    }

    public static byte[] b(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        if (bArr != null && bArr.length != 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                try {
                    byte[] bArr2 = new byte[256];
                    while (true) {
                        int read = gZIPInputStream.read(bArr2);
                        if (read < 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                    cn.jiguang.g.f.a(byteArrayOutputStream);
                    cn.jiguang.g.f.a((Closeable) byteArrayInputStream);
                    cn.jiguang.g.f.a((Closeable) gZIPInputStream);
                } catch (Throwable th) {
                    th = th;
                    cn.jiguang.g.f.a(byteArrayOutputStream);
                    cn.jiguang.g.f.a((Closeable) byteArrayInputStream);
                    cn.jiguang.g.f.a((Closeable) gZIPInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                gZIPInputStream = null;
            }
        }
        return bArr;
    }
}
