package com.baidu.sofire.utility;

import com.baidu.sofire.jni.Asc;
import java.io.File;
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static Asc f10412a = new Asc();

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z) {
        byte[] acn;
        if (bArr != null) {
            try {
            } catch (Throwable unused) {
                c.a();
            }
            if (bArr.length > 0 && bArr2 != null && bArr2.length > 0) {
                if (f10412a != null) {
                    if (z) {
                        acn = f10412a.ac(bArr2, bArr);
                    } else {
                        acn = f10412a.acn(bArr2, bArr);
                    }
                    if (acn != null && acn.length > 0) {
                        return acn;
                    }
                }
                return new byte[0];
            }
        }
        return new byte[0];
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        byte[] ar;
        if (bArr2 != null) {
            try {
            } catch (Throwable unused) {
                c.a();
            }
            if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                if (f10412a != null && (ar = f10412a.ar(bArr, bArr2)) != null && ar.length > 0) {
                    return ar;
                }
                return new byte[0];
            }
        }
        return new byte[0];
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        byte[] dr;
        if (bArr2 != null) {
            try {
            } catch (Throwable unused) {
                c.a();
            }
            if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                if (f10412a != null && (dr = f10412a.dr(bArr, bArr2)) != null && dr.length > 0) {
                    return dr;
                }
                return new byte[0];
            }
        }
        return new byte[0];
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] dc;
        if (bArr != null) {
            try {
            } catch (Throwable unused) {
                c.a();
            }
            if (bArr.length > 0 && bArr2 != null && bArr2.length > 0) {
                if (f10412a != null && (dc = f10412a.dc(bArr2, bArr)) != null && dc.length > 0) {
                    return dc;
                }
                return new byte[0];
            }
        }
        return new byte[0];
    }

    public static int a(File file, File file2, byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length > 0 && file != null && file2 != null && f10412a != null) {
                    return f10412a.df(file.getAbsolutePath(), file2.getAbsolutePath(), bArr);
                }
            } catch (Throwable unused) {
                c.a();
            }
        }
        return -1;
    }
}
