package com.baidu.mobstat;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.webkit.internal.Base64;
import com.baidu.webkit.internal.utils.UtilsBlink;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPOutputStream;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes2.dex */
public class db {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ boolean f8776a = !db.class.desiredAssertionStatus();

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f8777b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f8778c = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, StandardMessageCodec.LIST, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, Base64.INTERNAL_PADDING, 36, 37, 38, 39, 40, 41, ExifInterface.START_CODE, 43, 44, UtilsBlink.VER_TYPE_SEPARATOR, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: d  reason: collision with root package name */
    public static final byte[] f8779d = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, UtilsBlink.VER_TYPE_SEPARATOR, 95};

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f8780e = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, StandardMessageCodec.LIST, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, Base64.INTERNAL_PADDING, 36, 37, 38, 39, 40, 41, ExifInterface.START_CODE, 43, 44, UtilsBlink.VER_TYPE_SEPARATOR, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: f  reason: collision with root package name */
    public static final byte[] f8781f = {UtilsBlink.VER_TYPE_SEPARATOR, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122};

    /* renamed from: g  reason: collision with root package name */
    public static final byte[] f8782g = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, StandardMessageCodec.LIST, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, Base64.INTERNAL_PADDING, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, ExifInterface.START_CODE, 43, 44, UtilsBlink.VER_TYPE_SEPARATOR, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    public static final byte[] b(int i) {
        if ((i & 16) == 16) {
            return f8779d;
        }
        if ((i & 32) == 32) {
            return f8781f;
        }
        return f8777b;
    }

    public static final byte[] c(int i) {
        if ((i & 16) == 16) {
            return f8780e;
        }
        if ((i & 32) == 32) {
            return f8782g;
        }
        return f8778c;
    }

    public static byte[] a(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        byte[] b2 = b(i4);
        int i5 = (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0) | (i2 > 2 ? (bArr[i + 2] << 24) >>> 24 : 0);
        if (i2 == 1) {
            bArr2[i3] = b2[i5 >>> 18];
            bArr2[i3 + 1] = b2[(i5 >>> 12) & 63];
            bArr2[i3 + 2] = 61;
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 == 2) {
            bArr2[i3] = b2[i5 >>> 18];
            bArr2[i3 + 1] = b2[(i5 >>> 12) & 63];
            bArr2[i3 + 2] = b2[(i5 >>> 6) & 63];
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 != 3) {
            return bArr2;
        } else {
            bArr2[i3] = b2[i5 >>> 18];
            bArr2[i3 + 1] = b2[(i5 >>> 12) & 63];
            bArr2[i3 + 2] = b2[(i5 >>> 6) & 63];
            bArr2[i3 + 3] = b2[i5 & 63];
            return bArr2;
        }
    }

    public static byte[] b(byte[] bArr, byte[] bArr2, int i, int i2) {
        a(bArr2, 0, i, bArr, 0, i2);
        return bArr;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x003c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0040 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v16, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v17, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v19, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v20, resolved type: java.io.ByteArrayOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] b(byte[] bArr, int i, int i2, int i3) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        a aVar;
        GZIPOutputStream gZIPOutputStream;
        if (bArr != null) {
            if (i < 0) {
                throw new IllegalArgumentException("Cannot have negative offset: " + i);
            } else if (i2 >= 0) {
                if (i + i2 <= bArr.length) {
                    if ((i3 & 2) != 0) {
                        GZIPOutputStream gZIPOutputStream2 = null;
                        try {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                aVar = new a(byteArrayOutputStream, i3 | 1);
                                try {
                                    gZIPOutputStream = new GZIPOutputStream(aVar);
                                } catch (IOException e2) {
                                    e = e2;
                                    gZIPOutputStream = null;
                                } catch (Throwable th) {
                                    th = th;
                                    try {
                                        gZIPOutputStream2.close();
                                    } catch (Exception unused) {
                                    }
                                    try {
                                        aVar.close();
                                    } catch (Exception unused2) {
                                    }
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception unused3) {
                                    }
                                    throw th;
                                }
                            } catch (IOException e3) {
                                e = e3;
                                aVar = null;
                                gZIPOutputStream = null;
                            } catch (Throwable th2) {
                                th = th2;
                                aVar = null;
                            }
                        } catch (IOException e4) {
                            e = e4;
                            aVar = null;
                            gZIPOutputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            byteArrayOutputStream = 0;
                            aVar = null;
                        }
                        try {
                            gZIPOutputStream.write(bArr, i, i2);
                            gZIPOutputStream.close();
                            try {
                                gZIPOutputStream.close();
                            } catch (Exception unused4) {
                            }
                            try {
                                aVar.close();
                            } catch (Exception unused5) {
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused6) {
                            }
                            return byteArrayOutputStream.toByteArray();
                        } catch (IOException e5) {
                            e = e5;
                            gZIPOutputStream2 = byteArrayOutputStream;
                            try {
                                throw e;
                            } catch (Throwable th4) {
                                th = th4;
                                byteArrayOutputStream = gZIPOutputStream2;
                                gZIPOutputStream2 = gZIPOutputStream;
                                gZIPOutputStream2.close();
                                aVar.close();
                                byteArrayOutputStream.close();
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            gZIPOutputStream2 = gZIPOutputStream;
                            gZIPOutputStream2.close();
                            aVar.close();
                            byteArrayOutputStream.close();
                            throw th;
                        }
                    }
                    boolean z = (i3 & 8) != 0;
                    int i4 = ((i2 / 3) * 4) + (i2 % 3 > 0 ? 4 : 0);
                    if (z) {
                        i4 += i4 / 76;
                    }
                    int i5 = i4;
                    byte[] bArr2 = new byte[i5];
                    int i6 = i2 - 2;
                    int i7 = 0;
                    int i8 = 0;
                    int i9 = 0;
                    while (i7 < i6) {
                        int i10 = i7;
                        a(bArr, i7 + i, 3, bArr2, i8, i3);
                        int i11 = i9 + 4;
                        if (!z || i11 < 76) {
                            i9 = i11;
                        } else {
                            bArr2[i8 + 4] = 10;
                            i8++;
                            i9 = 0;
                        }
                        i7 = i10 + 3;
                        i8 += 4;
                    }
                    int i12 = i7;
                    if (i12 < i2) {
                        a(bArr, i12 + i, i2 - i12, bArr2, i8, i3);
                        i8 += 4;
                    }
                    int i13 = i8;
                    if (i13 <= i5 - 1) {
                        byte[] bArr3 = new byte[i13];
                        System.arraycopy(bArr2, 0, bArr3, 0, i13);
                        return bArr3;
                    }
                    return bArr2;
                }
                throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length)));
            } else {
                throw new IllegalArgumentException("Cannot have length offset: " + i2);
            }
        }
        throw new NullPointerException("Cannot serialize a null array.");
    }

    public static String a(byte[] bArr) {
        String str;
        try {
            str = a(bArr, 0, bArr.length, 0);
        } catch (IOException e2) {
            if (!f8776a) {
                throw new AssertionError(e2.getMessage());
            }
            str = null;
        }
        if (f8776a || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    /* loaded from: classes2.dex */
    public static class a extends FilterOutputStream {

        /* renamed from: a  reason: collision with root package name */
        public boolean f8783a;

        /* renamed from: b  reason: collision with root package name */
        public int f8784b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f8785c;

        /* renamed from: d  reason: collision with root package name */
        public int f8786d;

        /* renamed from: e  reason: collision with root package name */
        public int f8787e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f8788f;

        /* renamed from: g  reason: collision with root package name */
        public byte[] f8789g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f8790h;
        public int i;
        public byte[] j;

        public a(OutputStream outputStream, int i) {
            super(outputStream);
            this.f8788f = (i & 8) != 0;
            boolean z = (i & 1) != 0;
            this.f8783a = z;
            int i2 = z ? 3 : 4;
            this.f8786d = i2;
            this.f8785c = new byte[i2];
            this.f8784b = 0;
            this.f8787e = 0;
            this.f8790h = false;
            this.f8789g = new byte[4];
            this.i = i;
            this.j = db.c(i);
        }

        public void a() throws IOException {
            int i = this.f8784b;
            if (i > 0) {
                if (this.f8783a) {
                    ((FilterOutputStream) this).out.write(db.b(this.f8789g, this.f8785c, i, this.i));
                    this.f8784b = 0;
                    return;
                }
                throw new IOException("Base64 input not properly padded.");
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            a();
            super.close();
            this.f8785c = null;
            ((FilterOutputStream) this).out = null;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            if (this.f8790h) {
                ((FilterOutputStream) this).out.write(i);
            } else if (this.f8783a) {
                byte[] bArr = this.f8785c;
                int i2 = this.f8784b;
                int i3 = i2 + 1;
                this.f8784b = i3;
                bArr[i2] = (byte) i;
                int i4 = this.f8786d;
                if (i3 >= i4) {
                    ((FilterOutputStream) this).out.write(db.b(this.f8789g, bArr, i4, this.i));
                    int i5 = this.f8787e + 4;
                    this.f8787e = i5;
                    if (this.f8788f && i5 >= 76) {
                        ((FilterOutputStream) this).out.write(10);
                        this.f8787e = 0;
                    }
                    this.f8784b = 0;
                }
            } else {
                byte[] bArr2 = this.j;
                int i6 = i & 127;
                if (bArr2[i6] > -5) {
                    byte[] bArr3 = this.f8785c;
                    int i7 = this.f8784b;
                    int i8 = i7 + 1;
                    this.f8784b = i8;
                    bArr3[i7] = (byte) i;
                    if (i8 >= this.f8786d) {
                        ((FilterOutputStream) this).out.write(this.f8789g, 0, db.b(bArr3, 0, this.f8789g, 0, this.i));
                        this.f8784b = 0;
                    }
                } else if (bArr2[i6] != -5) {
                    throw new IOException("Invalid character in Base64 data.");
                }
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (this.f8790h) {
                ((FilterOutputStream) this).out.write(bArr, i, i2);
                return;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                write(bArr[i + i3]);
            }
        }
    }

    public static String a(byte[] bArr, int i, int i2, int i3) throws IOException {
        byte[] b2 = b(bArr, i, i2, i3);
        try {
            return new String(b2, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(b2);
        }
    }

    public static int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4;
        int i5;
        if (bArr != null) {
            if (bArr2 != null) {
                if (i >= 0 && (i4 = i + 3) < bArr.length) {
                    if (i2 >= 0 && (i5 = i2 + 2) < bArr2.length) {
                        byte[] c2 = c(i3);
                        int i6 = i + 2;
                        if (bArr[i6] == 61) {
                            bArr2[i2] = (byte) ((((c2[bArr[i + 1]] & 255) << 12) | ((c2[bArr[i]] & 255) << 18)) >>> 16);
                            return 1;
                        } else if (bArr[i4] == 61) {
                            int i7 = ((c2[bArr[i6]] & 255) << 6) | ((c2[bArr[i + 1]] & 255) << 12) | ((c2[bArr[i]] & 255) << 18);
                            bArr2[i2] = (byte) (i7 >>> 16);
                            bArr2[i2 + 1] = (byte) (i7 >>> 8);
                            return 2;
                        } else {
                            int i8 = (c2[bArr[i4]] & 255) | ((c2[bArr[i + 1]] & 255) << 12) | ((c2[bArr[i]] & 255) << 18) | ((c2[bArr[i6]] & 255) << 6);
                            bArr2[i2] = (byte) (i8 >> 16);
                            bArr2[i2 + 1] = (byte) (i8 >> 8);
                            bArr2[i5] = (byte) i8;
                            return 3;
                        }
                    }
                    throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i2)));
                }
                throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i)));
            }
            throw new NullPointerException("Destination array was null.");
        }
        throw new NullPointerException("Source array was null.");
    }
}
