package com.baidu.fsg.base.utils.support;

import android.support.v4.view.MotionEventCompat;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes3.dex */
public class Base64 {
    public static final int DECODE = 0;
    public static final int DONT_GUNZIP = 4;
    public static final int DO_BREAK_LINES = 8;
    public static final int ENCODE = 1;
    public static final int GZIP = 2;
    public static final int NO_OPTIONS = 0;
    public static final int ORDERED = 32;
    public static final int URL_SAFE = 16;
    static final /* synthetic */ boolean a;
    private static final int b = 76;
    private static final byte c = 61;
    private static final byte d = 10;
    private static final String e = "US-ASCII";
    private static final byte f = -5;
    private static final byte g = -1;
    private static final byte[] h;
    private static final byte[] i;
    private static final byte[] j;
    private static final byte[] k;
    private static final byte[] l;
    private static final byte[] m;

    static {
        a = !Base64.class.desiredAssertionStatus();
        h = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        i = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, f, f, -9, -9, f, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, f, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, c, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, d, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
        j = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        k = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, f, f, -9, -9, f, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, f, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, c, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, d, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
        l = new byte[]{45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
        m = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, f, f, -9, -9, f, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, f, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, d, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, c, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    }

    private Base64() {
    }

    private static final byte[] b(int i2) {
        if ((i2 & 16) == 16) {
            return j;
        }
        if ((i2 & 32) == 32) {
            return l;
        }
        return h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] c(int i2) {
        if ((i2 & 16) == 16) {
            return k;
        }
        if ((i2 & 32) == 32) {
            return m;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] b(byte[] bArr, byte[] bArr2, int i2, int i3) {
        b(bArr2, 0, i2, bArr, 0, i3);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] b(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        byte[] b2 = b(i5);
        int i6 = (i3 > 2 ? (bArr[i2 + 2] << 24) >>> 24 : 0) | (i3 > 1 ? (bArr[i2 + 1] << 24) >>> 16 : 0) | (i3 > 0 ? (bArr[i2] << 24) >>> 8 : 0);
        switch (i3) {
            case 1:
                bArr2[i4] = b2[i6 >>> 18];
                bArr2[i4 + 1] = b2[(i6 >>> 12) & 63];
                bArr2[i4 + 2] = c;
                bArr2[i4 + 3] = c;
                break;
            case 2:
                bArr2[i4] = b2[i6 >>> 18];
                bArr2[i4 + 1] = b2[(i6 >>> 12) & 63];
                bArr2[i4 + 2] = b2[(i6 >>> 6) & 63];
                bArr2[i4 + 3] = c;
                break;
            case 3:
                bArr2[i4] = b2[i6 >>> 18];
                bArr2[i4 + 1] = b2[(i6 >>> 12) & 63];
                bArr2[i4 + 2] = b2[(i6 >>> 6) & 63];
                bArr2[i4 + 3] = b2[i6 & 63];
                break;
        }
        return bArr2;
    }

    public static void encode(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int min = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, min);
            b(bArr2, bArr, min, 0);
            byteBuffer2.put(bArr2);
        }
    }

    public static void encode(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int min = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, min);
            b(bArr2, bArr, min, 0);
            for (int i2 = 0; i2 < 4; i2++) {
                charBuffer.put((char) (bArr2[i2] & 255));
            }
        }
    }

    public static String encodeObject(Serializable serializable) throws IOException {
        return encodeObject(serializable, 0);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0050 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:78:? */
    /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: java.util.zip.GZIPOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    public static String encodeObject(Serializable serializable, int i2) throws IOException {
        GZIPOutputStream gZIPOutputStream;
        OutputStream outputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream2;
        ObjectOutputStream objectOutputStream = null;
        if (serializable == null) {
            throw new NullPointerException("Cannot serialize a null object.");
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                outputStream = new OutputStream(byteArrayOutputStream, i2 | 1);
                try {
                    if ((i2 & 2) != 0) {
                        gZIPOutputStream = new GZIPOutputStream(outputStream);
                        try {
                            try {
                                objectOutputStream = new ObjectOutputStream(gZIPOutputStream);
                                gZIPOutputStream2 = gZIPOutputStream;
                            } catch (IOException e2) {
                                throw e2;
                            }
                        } catch (Throwable th) {
                            th = th;
                            try {
                                objectOutputStream.close();
                            } catch (Exception e3) {
                            }
                            try {
                                gZIPOutputStream.close();
                            } catch (Exception e4) {
                            }
                            try {
                                outputStream.close();
                            } catch (Exception e5) {
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e6) {
                            }
                            throw th;
                        }
                    } else {
                        gZIPOutputStream2 = null;
                        objectOutputStream = new ObjectOutputStream(outputStream);
                    }
                    objectOutputStream.writeObject(serializable);
                    try {
                        objectOutputStream.close();
                    } catch (Exception e7) {
                    }
                    try {
                        gZIPOutputStream2.close();
                    } catch (Exception e8) {
                    }
                    try {
                        outputStream.close();
                    } catch (Exception e9) {
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e10) {
                    }
                    try {
                        return new String(byteArrayOutputStream.toByteArray(), "US-ASCII");
                    } catch (UnsupportedEncodingException e11) {
                        return new String(byteArrayOutputStream.toByteArray());
                    }
                } catch (IOException e12) {
                    throw e12;
                } catch (Throwable th2) {
                    th = th2;
                    gZIPOutputStream = objectOutputStream;
                    objectOutputStream.close();
                    gZIPOutputStream.close();
                    outputStream.close();
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (IOException e13) {
                throw e13;
            } catch (Throwable th3) {
                th = th3;
                gZIPOutputStream = null;
                outputStream = null;
            }
        } catch (IOException e14) {
            gZIPOutputStream = null;
            outputStream = null;
            byteArrayOutputStream = null;
            throw e14;
        } catch (Throwable th4) {
            th = th4;
            gZIPOutputStream = null;
            outputStream = null;
            byteArrayOutputStream = null;
        }
    }

    public static String encodeBytes(byte[] bArr) {
        String str = null;
        try {
            str = encodeBytes(bArr, 0, bArr.length, 0);
        } catch (IOException e2) {
            if (!a) {
                throw new AssertionError(e2.getMessage());
            }
        }
        if (a || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    public static String encodeBytes(byte[] bArr, int i2) throws IOException {
        return encodeBytes(bArr, 0, bArr.length, i2);
    }

    public static String encodeBytes(byte[] bArr, int i2, int i3) {
        String str = null;
        try {
            str = encodeBytes(bArr, i2, i3, 0);
        } catch (IOException e2) {
            if (!a) {
                throw new AssertionError(e2.getMessage());
            }
        }
        if (a || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    public static String encodeBytes(byte[] bArr, int i2, int i3, int i4) throws IOException {
        byte[] encodeBytesToBytes = encodeBytesToBytes(bArr, i2, i3, i4);
        try {
            return new String(encodeBytesToBytes, "US-ASCII");
        } catch (UnsupportedEncodingException e2) {
            return new String(encodeBytesToBytes);
        }
    }

    public static byte[] encodeBytesToBytes(byte[] bArr) {
        try {
            return encodeBytesToBytes(bArr, 0, bArr.length, 0);
        } catch (IOException e2) {
            if (a) {
                return null;
            }
            throw new AssertionError("IOExceptions only come from GZipping, which is turned off: " + e2.getMessage());
        }
    }

    public static byte[] encodeBytesToBytes(byte[] bArr, int i2, int i3, int i4) throws IOException {
        OutputStream outputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2 = null;
        if (bArr == null) {
            throw new NullPointerException("Cannot serialize a null array.");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + i2);
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("Cannot have length offset: " + i3);
        }
        if (i2 + i3 > bArr.length) {
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bArr.length)));
        }
        if ((i4 & 2) != 0) {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    outputStream = new OutputStream(byteArrayOutputStream, i4 | 1);
                    try {
                        gZIPOutputStream = new GZIPOutputStream(outputStream);
                    } catch (IOException e2) {
                        e = e2;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    outputStream = null;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = null;
                }
            } catch (IOException e4) {
                e = e4;
                outputStream = null;
                byteArrayOutputStream2 = null;
            } catch (Throwable th3) {
                th = th3;
                outputStream = null;
                byteArrayOutputStream = null;
            }
            try {
                gZIPOutputStream.write(bArr, i2, i3);
                gZIPOutputStream.close();
                try {
                    gZIPOutputStream.close();
                } catch (Exception e5) {
                }
                try {
                    outputStream.close();
                } catch (Exception e6) {
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e7) {
                }
                return byteArrayOutputStream.toByteArray();
            } catch (IOException e8) {
                e = e8;
                gZIPOutputStream2 = gZIPOutputStream;
                byteArrayOutputStream2 = byteArrayOutputStream;
                try {
                    throw e;
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    try {
                        gZIPOutputStream2.close();
                    } catch (Exception e9) {
                    }
                    try {
                        outputStream.close();
                    } catch (Exception e10) {
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e11) {
                    }
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                gZIPOutputStream2 = gZIPOutputStream;
                gZIPOutputStream2.close();
                outputStream.close();
                byteArrayOutputStream.close();
                throw th;
            }
        }
        boolean z = (i4 & 8) != 0;
        int i5 = (i3 % 3 > 0 ? 4 : 0) + ((i3 / 3) * 4);
        if (z) {
            i5 += i5 / 76;
        }
        byte[] bArr2 = new byte[i5];
        int i6 = i3 - 2;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i9 < i6) {
            b(bArr, i9 + i2, 3, bArr2, i8, i4);
            int i10 = i7 + 4;
            if (z && i10 >= 76) {
                bArr2[i8 + 4] = d;
                i8++;
                i10 = 0;
            }
            i8 += 4;
            i7 = i10;
            i9 += 3;
        }
        if (i9 < i3) {
            b(bArr, i9 + i2, i3 - i9, bArr2, i8, i4);
            i8 += 4;
        }
        if (i8 <= bArr2.length - 1) {
            byte[] bArr3 = new byte[i8];
            System.arraycopy(bArr2, 0, bArr3, 0, i8);
            return bArr3;
        }
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        if (bArr == null) {
            throw new NullPointerException("Source array was null.");
        }
        if (bArr2 == null) {
            throw new NullPointerException("Destination array was null.");
        }
        if (i2 < 0 || i2 + 3 >= bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i2)));
        }
        if (i3 < 0 || i3 + 2 >= bArr2.length) {
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i3)));
        }
        byte[] c2 = c(i4);
        if (bArr[i2 + 2] == 61) {
            bArr2[i3] = (byte) ((((c2[bArr[i2]] & 255) << 18) | ((c2[bArr[i2 + 1]] & 255) << 12)) >>> 16);
            return 1;
        } else if (bArr[i2 + 3] == 61) {
            int i5 = ((c2[bArr[i2]] & 255) << 18) | ((c2[bArr[i2 + 1]] & 255) << 12) | ((c2[bArr[i2 + 2]] & 255) << 6);
            bArr2[i3] = (byte) (i5 >>> 16);
            bArr2[i3 + 1] = (byte) (i5 >>> 8);
            return 2;
        } else {
            int i6 = ((c2[bArr[i2]] & 255) << 18) | ((c2[bArr[i2 + 1]] & 255) << 12) | ((c2[bArr[i2 + 2]] & 255) << 6) | (c2[bArr[i2 + 3]] & 255);
            bArr2[i3] = (byte) (i6 >> 16);
            bArr2[i3 + 1] = (byte) (i6 >> 8);
            bArr2[i3 + 2] = (byte) i6;
            return 3;
        }
    }

    public static byte[] decode(byte[] bArr) throws IOException {
        return decode(bArr, 0, bArr.length, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x008c, code lost:
        r2 = new byte[r0];
        java.lang.System.arraycopy(r6, 0, r2, 0, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:?, code lost:
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] decode(byte[] bArr, int i2, int i3, int i4) throws IOException {
        int i5;
        int i6;
        int i7;
        if (bArr == null) {
            throw new NullPointerException("Cannot decode null source array.");
        }
        if (i2 < 0 || i2 + i3 > bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        if (i3 == 0) {
            return new byte[0];
        }
        if (i3 < 4) {
            throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + i3);
        }
        byte[] c2 = c(i4);
        byte[] bArr2 = new byte[(i3 * 3) / 4];
        byte[] bArr3 = new byte[4];
        int i8 = i2;
        int i9 = 0;
        int i10 = 0;
        while (true) {
            if (i8 >= i2 + i3) {
                i5 = i10;
                break;
            }
            byte b2 = c2[bArr[i8] & 255];
            if (b2 >= -5) {
                if (b2 >= -1) {
                    i6 = i9 + 1;
                    bArr3[i9] = bArr[i8];
                    if (i6 > 3) {
                        i5 = b(bArr3, 0, bArr2, i10, i4) + i10;
                        if (bArr[i8] == 61) {
                            break;
                        }
                        i7 = i5;
                        i6 = 0;
                    } else {
                        i7 = i10;
                    }
                } else {
                    i6 = i9;
                    i7 = i10;
                }
                i8++;
                i10 = i7;
                i9 = i6;
            } else {
                throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", Integer.valueOf(bArr[i8] & 255), Integer.valueOf(i8)));
            }
        }
    }

    public static byte[] decode(String str) throws IOException {
        return decode(str, 0);
    }

    public static byte[] decode(String str, int i2) throws IOException {
        byte[] bytes;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream2;
        GZIPInputStream gZIPInputStream = null;
        if (str == null) {
            throw new NullPointerException("Input string was null.");
        }
        try {
            bytes = str.getBytes("US-ASCII");
        } catch (UnsupportedEncodingException e2) {
            bytes = str.getBytes();
        }
        byte[] decode = decode(bytes, 0, bytes.length, i2);
        boolean z = (i2 & 4) != 0;
        if (decode != null && decode.length >= 4 && !z && 35615 == ((decode[0] & 255) | ((decode[1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK))) {
            byte[] bArr = new byte[2048];
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byteArrayInputStream = new ByteArrayInputStream(decode);
                    try {
                        GZIPInputStream gZIPInputStream2 = new GZIPInputStream(byteArrayInputStream);
                        while (true) {
                            try {
                                int read = gZIPInputStream2.read(bArr);
                                if (read < 0) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            } catch (IOException e3) {
                                e = e3;
                                gZIPInputStream = gZIPInputStream2;
                                byteArrayInputStream2 = byteArrayInputStream;
                                try {
                                    e.printStackTrace();
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception e4) {
                                    }
                                    try {
                                        gZIPInputStream.close();
                                    } catch (Exception e5) {
                                    }
                                    try {
                                        byteArrayInputStream2.close();
                                    } catch (Exception e6) {
                                    }
                                    return decode;
                                } catch (Throwable th) {
                                    th = th;
                                    byteArrayInputStream = byteArrayInputStream2;
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception e7) {
                                    }
                                    try {
                                        gZIPInputStream.close();
                                    } catch (Exception e8) {
                                    }
                                    try {
                                        byteArrayInputStream.close();
                                    } catch (Exception e9) {
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                gZIPInputStream = gZIPInputStream2;
                                byteArrayOutputStream.close();
                                gZIPInputStream.close();
                                byteArrayInputStream.close();
                                throw th;
                            }
                        }
                        decode = byteArrayOutputStream.toByteArray();
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e10) {
                        }
                        try {
                            gZIPInputStream2.close();
                        } catch (Exception e11) {
                        }
                        try {
                            byteArrayInputStream.close();
                        } catch (Exception e12) {
                        }
                    } catch (IOException e13) {
                        e = e13;
                        byteArrayInputStream2 = byteArrayInputStream;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (IOException e14) {
                    e = e14;
                    byteArrayInputStream2 = null;
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayInputStream = null;
                }
            } catch (IOException e15) {
                e = e15;
                byteArrayOutputStream = null;
                byteArrayInputStream2 = null;
            } catch (Throwable th5) {
                th = th5;
                byteArrayOutputStream = null;
                byteArrayInputStream = null;
            }
        }
        return decode;
    }

    public static Object decodeToObject(String str) throws IOException, ClassNotFoundException {
        return decodeToObject(str, 0, null);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.ByteArrayInputStream, java.io.ObjectInputStream] */
    public static Object decodeToObject(String str, int i2, final ClassLoader classLoader) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream;
        ?? r1 = 0;
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decode(str, i2));
                try {
                    if (classLoader == null) {
                        objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    } else {
                        objectInputStream = new ObjectInputStream(byteArrayInputStream) { // from class: com.baidu.fsg.base.utils.support.Base64.1
                            @Override // java.io.ObjectInputStream
                            public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
                                Class<?> cls = Class.forName(objectStreamClass.getName(), false, classLoader);
                                if (cls == null) {
                                    return super.resolveClass(objectStreamClass);
                                }
                                return cls;
                            }
                        };
                    }
                    Object readObject = objectInputStream.readObject();
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception e2) {
                    }
                    try {
                        objectInputStream.close();
                    } catch (Exception e3) {
                    }
                    return readObject;
                } catch (IOException e4) {
                    throw e4;
                } catch (ClassNotFoundException e5) {
                    throw e5;
                }
            } catch (Throwable th) {
                th = th;
                try {
                    r1.close();
                } catch (Exception e6) {
                }
                try {
                    r1.close();
                } catch (Exception e7) {
                }
                throw th;
            }
        } catch (IOException e8) {
            throw e8;
        } catch (ClassNotFoundException e9) {
            throw e9;
        } catch (Throwable th2) {
            th = th2;
            r1.close();
            r1.close();
            throw th;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0022: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:14:0x0022 */
    public static void encodeToFile(byte[] bArr, String str) throws IOException {
        AutoCloseable autoCloseable;
        if (bArr == null) {
            throw new NullPointerException("Data to encode was null.");
        }
        AutoCloseable autoCloseable2 = null;
        try {
            try {
                OutputStream outputStream = new OutputStream(new FileOutputStream(str), 1);
                try {
                    outputStream.write(bArr);
                    try {
                        outputStream.close();
                    } catch (Exception e2) {
                    }
                } catch (IOException e3) {
                }
            } catch (Throwable th) {
                th = th;
                autoCloseable2 = autoCloseable;
                try {
                    autoCloseable2.close();
                } catch (Exception e4) {
                }
                throw th;
            }
        } catch (IOException e5) {
            throw e5;
        } catch (Throwable th2) {
            th = th2;
            autoCloseable2.close();
            throw th;
        }
    }

    public static void decodeToFile(String str, String str2) throws IOException {
        OutputStream outputStream;
        try {
            outputStream = new OutputStream(new FileOutputStream(str2), 0);
            try {
                try {
                    outputStream.write(str.getBytes("US-ASCII"));
                    try {
                        outputStream.close();
                    } catch (Exception e2) {
                    }
                } catch (IOException e3) {
                }
            } catch (Throwable th) {
                th = th;
                try {
                    outputStream.close();
                } catch (Exception e4) {
                }
                throw th;
            }
        } catch (IOException e5) {
            outputStream = null;
            throw e5;
        } catch (Throwable th2) {
            th = th2;
            outputStream = null;
            outputStream.close();
            throw th;
        }
    }

    public static byte[] decodeFromFile(String str) throws IOException {
        int i2 = 0;
        InputStream inputStream = null;
        try {
            try {
                File file = new File(str);
                if (file.length() > 2147483647L) {
                    throw new IOException("File is too big for this convenience method (" + file.length() + " bytes).");
                }
                byte[] bArr = new byte[(int) file.length()];
                InputStream inputStream2 = new InputStream(new BufferedInputStream(new FileInputStream(file)), 0);
                while (true) {
                    try {
                        int read = inputStream2.read(bArr, i2, 4096);
                        if (read < 0) {
                            break;
                        }
                        i2 += read;
                    } catch (IOException e2) {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        try {
                            inputStream.close();
                        } catch (Exception e3) {
                        }
                        throw th;
                    }
                }
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, 0, bArr2, 0, i2);
                try {
                    inputStream2.close();
                } catch (Exception e4) {
                }
                return bArr2;
            } catch (IOException e5) {
                throw e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String encodeFromFile(String str) throws IOException {
        InputStream inputStream;
        int i2 = 0;
        InputStream inputStream2 = null;
        try {
            File file = new File(str);
            byte[] bArr = new byte[Math.max((int) ((file.length() * 1.4d) + 1.0d), 40)];
            inputStream = new InputStream(new BufferedInputStream(new FileInputStream(file)), 1);
            while (true) {
                try {
                    try {
                        int read = inputStream.read(bArr, i2, 4096);
                        if (read < 0) {
                            break;
                        }
                        i2 += read;
                    } catch (IOException e2) {
                        throw e2;
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = inputStream;
                    try {
                        inputStream2.close();
                    } catch (Exception e3) {
                    }
                    throw th;
                }
            }
            String str2 = new String(bArr, 0, i2, "US-ASCII");
            try {
                inputStream.close();
            } catch (Exception e4) {
            }
            return str2;
        } catch (IOException e5) {
            inputStream = null;
            throw e5;
        } catch (Throwable th2) {
            th = th2;
            inputStream2.close();
            throw th;
        }
    }

    public static void encodeFileToFile(String str, String str2) throws IOException {
        String encodeFromFile = encodeFromFile(str);
        java.io.OutputStream outputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
                try {
                    bufferedOutputStream.write(encodeFromFile.getBytes("US-ASCII"));
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception e2) {
                    }
                } catch (IOException e3) {
                }
            } catch (Throwable th) {
                th = th;
                try {
                    outputStream.close();
                } catch (Exception e4) {
                }
                throw th;
            }
        } catch (IOException e5) {
            throw e5;
        } catch (Throwable th2) {
            th = th2;
            outputStream.close();
            throw th;
        }
    }

    public static void decodeFileToFile(String str, String str2) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        byte[] decodeFromFile = decodeFromFile(str);
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
            try {
                try {
                    bufferedOutputStream.write(decodeFromFile);
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception e2) {
                    }
                } catch (IOException e3) {
                }
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream2 = bufferedOutputStream;
                try {
                    bufferedOutputStream2.close();
                } catch (Exception e4) {
                }
                throw th;
            }
        } catch (IOException e5) {
            bufferedOutputStream = null;
            throw e5;
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream2.close();
            throw th;
        }
    }

    /* loaded from: classes3.dex */
    public static class InputStream extends FilterInputStream {
        private final boolean a;
        private final byte[] b;
        private final int c;
        private final boolean d;
        private final int e;
        private final byte[] f;
        private int g;
        private int h;
        private int i;

        public InputStream(java.io.InputStream inputStream) {
            this(inputStream, 0);
        }

        public InputStream(java.io.InputStream inputStream, int i) {
            super(inputStream);
            this.e = i;
            this.d = (i & 8) > 0;
            this.a = (i & 1) > 0;
            this.c = this.a ? 4 : 3;
            this.b = new byte[this.c];
            this.g = -1;
            this.i = 0;
            this.f = Base64.c(i);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read;
            if (this.g < 0) {
                if (this.a) {
                    byte[] bArr = new byte[3];
                    int i = 0;
                    int i2 = 0;
                    while (i < 3) {
                        int read2 = this.in.read();
                        if (read2 < 0) {
                            break;
                        }
                        bArr[i] = (byte) read2;
                        i++;
                        i2++;
                    }
                    if (i2 <= 0) {
                        return -1;
                    }
                    Base64.b(bArr, 0, i2, this.b, 0, this.e);
                    this.g = 0;
                    this.h = 4;
                } else {
                    byte[] bArr2 = new byte[4];
                    int i3 = 0;
                    while (i3 < 4) {
                        do {
                            read = this.in.read();
                            if (read < 0) {
                                break;
                            }
                        } while (this.f[read & 127] <= -5);
                        if (read < 0) {
                            break;
                        }
                        bArr2[i3] = (byte) read;
                        i3++;
                    }
                    if (i3 == 4) {
                        this.h = Base64.b(bArr2, 0, this.b, 0, this.e);
                        this.g = 0;
                    } else if (i3 == 0) {
                        return -1;
                    } else {
                        throw new IOException("Improperly padded Base64 input.");
                    }
                }
            }
            if (this.g >= 0) {
                if (this.g >= this.h) {
                    return -1;
                }
                if (this.a && this.d && this.i >= 76) {
                    this.i = 0;
                    return 10;
                }
                this.i++;
                byte[] bArr3 = this.b;
                int i4 = this.g;
                this.g = i4 + 1;
                byte b = bArr3[i4];
                if (this.g >= this.c) {
                    this.g = -1;
                }
                return b & 255;
            }
            throw new IOException("Error in Base64 code reading stream.");
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = 0;
            while (i3 < i2) {
                int read = read();
                if (read >= 0) {
                    bArr[i + i3] = (byte) read;
                    i3++;
                } else if (i3 == 0) {
                    return -1;
                } else {
                    return i3;
                }
            }
            return i3;
        }
    }

    /* loaded from: classes3.dex */
    public static class OutputStream extends FilterOutputStream {
        private final boolean a;
        private final int b;
        private final boolean c;
        private final byte[] d;
        private final int e;
        private final byte[] f;
        private int g;
        private byte[] h;
        private int i;
        private boolean j;

        public OutputStream(java.io.OutputStream outputStream) {
            this(outputStream, 1);
        }

        public OutputStream(java.io.OutputStream outputStream, int i) {
            super(outputStream);
            this.c = (i & 8) != 0;
            this.a = (i & 1) != 0;
            this.b = this.a ? 3 : 4;
            this.h = new byte[this.b];
            this.g = 0;
            this.i = 0;
            this.j = false;
            this.d = new byte[4];
            this.e = i;
            this.f = Base64.c(i);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            if (this.j) {
                this.out.write(i);
            } else if (this.a) {
                byte[] bArr = this.h;
                int i2 = this.g;
                this.g = i2 + 1;
                bArr[i2] = (byte) i;
                if (this.g >= this.b) {
                    this.out.write(Base64.b(this.d, this.h, this.b, this.e));
                    this.i += 4;
                    if (this.c && this.i >= 76) {
                        this.out.write(10);
                        this.i = 0;
                    }
                    this.g = 0;
                }
            } else if (this.f[i & 127] > -5) {
                byte[] bArr2 = this.h;
                int i3 = this.g;
                this.g = i3 + 1;
                bArr2[i3] = (byte) i;
                if (this.g >= this.b) {
                    this.out.write(this.d, 0, Base64.b(this.h, 0, this.d, 0, this.e));
                    this.g = 0;
                }
            } else if (this.f[i & 127] != -5) {
                throw new IOException("Invalid character in Base64 data.");
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (this.j) {
                this.out.write(bArr, i, i2);
                return;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                write(bArr[i + i3]);
            }
        }

        public void flushBase64() throws IOException {
            if (this.g > 0) {
                if (this.a) {
                    this.out.write(Base64.b(this.d, this.h, this.g, this.e));
                    this.g = 0;
                    return;
                }
                throw new IOException("Base64 input not properly padded.");
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            flushBase64();
            super.close();
            this.h = null;
            this.out = null;
        }

        public void suspendEncoding() throws IOException {
            flushBase64();
            this.j = true;
        }

        public void resumeEncoding() {
            this.j = false;
        }
    }
}
