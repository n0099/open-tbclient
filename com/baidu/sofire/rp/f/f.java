package com.baidu.sofire.rp.f;

import com.baidu.sofire.ac.FI;
/* loaded from: classes.dex */
public final class f {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        try {
            Class<?> cls = Class.forName("com.baidu.sofire.ac.F");
            FI fi = (FI) cls.getDeclaredMethod("getInstance", new Class[0]).invoke(cls, new Object[0]);
            if (fi == null) {
                return null;
            }
            return fi.ae(bArr, bArr2);
        } catch (Throwable th) {
            b.a();
            return bArr;
        }
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        try {
            Class<?> cls = Class.forName("com.baidu.sofire.ac.F");
            FI fi = (FI) cls.getDeclaredMethod("getInstance", new Class[0]).invoke(cls, new Object[0]);
            if (fi == null) {
                return null;
            }
            return fi.ad(bArr, bArr2);
        } catch (Throwable th) {
            b.a();
            return bArr;
        }
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        try {
            Class<?> cls = Class.forName("com.baidu.sofire.ac.F");
            FI fi = (FI) cls.getDeclaredMethod("getInstance", new Class[0]).invoke(cls, new Object[0]);
            if (fi == null) {
                return null;
            }
            return fi.re(bArr, bArr2);
        } catch (Throwable th) {
            b.a();
            return bArr;
        }
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        try {
            Class<?> cls = Class.forName("com.baidu.sofire.ac.F");
            FI fi = (FI) cls.getDeclaredMethod("getInstance", new Class[0]).invoke(cls, new Object[0]);
            if (fi == null) {
                return null;
            }
            return fi.rd(bArr, bArr2);
        } catch (Throwable th) {
            b.a();
            return bArr;
        }
    }
}
