package com.alipay.sdk.packet;

import com.alipay.sdk.util.n;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Locale;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1888a;

    /* renamed from: b  reason: collision with root package name */
    public String f1889b = n.a(24);

    public c(boolean z) {
        this.f1888a = z;
    }

    public static byte[] b(String str, byte[] bArr) {
        return com.alipay.sdk.encrypt.e.b(str, bArr);
    }

    public d a(b bVar, boolean z) {
        byte[] a2;
        if (bVar == null) {
            return null;
        }
        byte[] bytes = bVar.a().getBytes();
        byte[] bytes2 = bVar.b().getBytes();
        if (z) {
            try {
                bytes2 = com.alipay.sdk.encrypt.c.a(bytes2);
            } catch (Exception unused) {
                z = false;
            }
        }
        if (this.f1888a) {
            a2 = a(bytes, a(this.f1889b, com.alipay.sdk.cons.a.f1817c), a(this.f1889b, bytes2));
        } else {
            a2 = a(bytes, bytes2);
        }
        return new d(z, a2);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b a(d dVar) {
        ByteArrayInputStream byteArrayInputStream;
        String str;
        String str2;
        ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(dVar.b());
            try {
                try {
                    byte[] bArr = new byte[5];
                    byteArrayInputStream.read(bArr);
                    byte[] bArr2 = new byte[a(new String(bArr))];
                    byteArrayInputStream.read(bArr2);
                    str = new String(bArr2);
                } catch (Exception e2) {
                    e = e2;
                    str = null;
                }
                try {
                    byte[] bArr3 = new byte[5];
                    byteArrayInputStream.read(bArr3);
                    int a2 = a(new String(bArr3));
                    if (a2 > 0) {
                        byte[] bArr4 = new byte[a2];
                        byteArrayInputStream.read(bArr4);
                        if (this.f1888a) {
                            bArr4 = b(this.f1889b, bArr4);
                        }
                        if (dVar.a()) {
                            bArr4 = com.alipay.sdk.encrypt.c.b(bArr4);
                        }
                        str2 = new String(bArr4);
                    } else {
                        str2 = null;
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception unused) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    com.alipay.sdk.util.c.a(e);
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    str2 = null;
                    if (str == null) {
                    }
                    return new b(str, str2);
                }
            } catch (Throwable th) {
                th = th;
                byteArrayInputStream2 = byteArrayInputStream;
                if (byteArrayInputStream2 != null) {
                    try {
                        byteArrayInputStream2.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            byteArrayInputStream = null;
            str = null;
        } catch (Throwable th2) {
            th = th2;
            if (byteArrayInputStream2 != null) {
            }
            throw th;
        }
        if (str == null || str2 != null) {
            return new b(str, str2);
        }
        return null;
    }

    public static byte[] a(String str, String str2) {
        return com.alipay.sdk.encrypt.d.a(str, str2);
    }

    public static byte[] a(String str, byte[] bArr) {
        return com.alipay.sdk.encrypt.e.a(str, bArr);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x0038 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x0054 */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0050, code lost:
        if (r2 == null) goto L25;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(byte[]... bArr) {
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2;
        ByteArrayOutputStream byteArrayOutputStream = null;
        r0 = null;
        byte[] bArr2 = null;
        if (bArr != null) {
            ?? length = bArr.length;
            try {
                if (length != 0) {
                    try {
                        length = new ByteArrayOutputStream();
                    } catch (Exception e2) {
                        e = e2;
                        length = 0;
                        dataOutputStream2 = null;
                    } catch (Throwable th) {
                        th = th;
                        dataOutputStream = null;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused) {
                            }
                        }
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                    try {
                        dataOutputStream2 = new DataOutputStream(length);
                        try {
                            for (byte[] bArr3 : bArr) {
                                dataOutputStream2.write(a(bArr3.length).getBytes());
                                dataOutputStream2.write(bArr3);
                            }
                            dataOutputStream2.flush();
                            bArr2 = length.toByteArray();
                            try {
                                length.close();
                            } catch (Exception unused3) {
                            }
                        } catch (Exception e3) {
                            e = e3;
                            com.alipay.sdk.util.c.a(e);
                            if (length != 0) {
                                try {
                                    length.close();
                                } catch (Exception unused4) {
                                }
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        dataOutputStream2 = null;
                    } catch (Throwable th2) {
                        th = th2;
                        dataOutputStream = null;
                        byteArrayOutputStream = length;
                        if (byteArrayOutputStream != null) {
                        }
                        if (dataOutputStream != null) {
                        }
                        throw th;
                    }
                    try {
                        dataOutputStream2.close();
                    } catch (Exception unused5) {
                        return bArr2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return null;
    }

    public static String a(int i2) {
        return String.format(Locale.getDefault(), "%05d", Integer.valueOf(i2));
    }

    public static int a(String str) {
        return Integer.parseInt(str);
    }
}
