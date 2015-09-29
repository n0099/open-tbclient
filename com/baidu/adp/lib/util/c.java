package com.baidu.adp.lib.util;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes.dex */
public class c {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final byte[] xC;
    private static final byte[] xD;
    private static final byte[] xE;
    private static final byte[] xF;
    private static final byte[] xG;
    private static final byte[] xH;

    static {
        $assertionsDisabled = !c.class.desiredAssertionStatus();
        xC = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        xD = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
        xE = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        xF = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
        xG = new byte[]{45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
        xH = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    }

    private static final byte[] ab(int i) {
        if ((i & 16) == 16) {
            return xE;
        }
        if ((i & 32) == 32) {
            return xG;
        }
        return xC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] ac(int i) {
        if ((i & 16) == 16) {
            return xF;
        }
        if ((i & 32) == 32) {
            return xH;
        }
        return xD;
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] c(byte[] bArr, byte[] bArr2, int i, int i2) {
        c(bArr2, 0, i, bArr, 0, i2);
        return bArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [571=4] */
    private static byte[] c(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        byte[] ab = ab(i4);
        int i5 = (i2 > 2 ? (bArr[i + 2] << 24) >>> 24 : 0) | (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0) | (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0);
        switch (i2) {
            case 1:
                bArr2[i3] = ab[i5 >>> 18];
                bArr2[i3 + 1] = ab[(i5 >>> 12) & 63];
                bArr2[i3 + 2] = 61;
                bArr2[i3 + 3] = 61;
                break;
            case 2:
                bArr2[i3] = ab[i5 >>> 18];
                bArr2[i3 + 1] = ab[(i5 >>> 12) & 63];
                bArr2[i3 + 2] = ab[(i5 >>> 6) & 63];
                bArr2[i3 + 3] = 61;
                break;
            case 3:
                bArr2[i3] = ab[i5 >>> 18];
                bArr2[i3 + 1] = ab[(i5 >>> 12) & 63];
                bArr2[i3 + 2] = ab[(i5 >>> 6) & 63];
                bArr2[i3 + 3] = ab[i5 & 63];
                break;
        }
        return bArr2;
    }

    public static String encodeBytes(byte[] bArr) {
        String str = null;
        try {
            str = encodeBytes(bArr, 0, bArr.length, 0);
        } catch (IOException e) {
            if (!$assertionsDisabled) {
                throw new AssertionError(e.getMessage());
            }
        }
        if ($assertionsDisabled || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    public static String encodeBytes(byte[] bArr, int i) {
        return encodeBytes(bArr, 0, bArr.length, i);
    }

    public static String encodeBytes(byte[] bArr, int i, int i2, int i3) {
        byte[] encodeBytesToBytes = encodeBytesToBytes(bArr, i, i2, i3);
        try {
            return new String(encodeBytesToBytes, "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            return new String(encodeBytesToBytes);
        }
    }

    public static byte[] encodeBytesToBytes(byte[] bArr, int i, int i2, int i3) {
        a aVar;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        GZIPOutputStream gZIPOutputStream = null;
        if (bArr == null) {
            throw new NullPointerException("Cannot serialize a null array.");
        }
        if (i < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + i);
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Cannot have length offset: " + i2);
        }
        if (i + i2 > bArr.length) {
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length)));
        }
        if ((i3 & 2) != 0) {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    aVar = new a(byteArrayOutputStream, i3 | 1);
                    try {
                        GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(aVar);
                        try {
                            gZIPOutputStream2.write(bArr, i, i2);
                            gZIPOutputStream2.close();
                            try {
                                gZIPOutputStream2.close();
                            } catch (Exception e) {
                            }
                            try {
                                aVar.close();
                            } catch (Exception e2) {
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e3) {
                            }
                            return byteArrayOutputStream.toByteArray();
                        } catch (IOException e4) {
                            e = e4;
                            gZIPOutputStream = gZIPOutputStream2;
                            byteArrayOutputStream2 = byteArrayOutputStream;
                            try {
                                throw e;
                            } catch (Throwable th) {
                                th = th;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                try {
                                    gZIPOutputStream.close();
                                } catch (Exception e5) {
                                }
                                try {
                                    aVar.close();
                                } catch (Exception e6) {
                                }
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Exception e7) {
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            gZIPOutputStream = gZIPOutputStream2;
                            gZIPOutputStream.close();
                            aVar.close();
                            byteArrayOutputStream.close();
                            throw th;
                        }
                    } catch (IOException e8) {
                        e = e8;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (IOException e9) {
                    e = e9;
                    aVar = null;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                } catch (Throwable th4) {
                    th = th4;
                    aVar = null;
                }
            } catch (IOException e10) {
                e = e10;
                aVar = null;
                byteArrayOutputStream2 = null;
            } catch (Throwable th5) {
                th = th5;
                aVar = null;
                byteArrayOutputStream = null;
            }
        } else {
            boolean z = (i3 & 8) != 0;
            int i4 = (i2 % 3 > 0 ? 4 : 0) + ((i2 / 3) * 4);
            if (z) {
                i4 += i4 / 76;
            }
            byte[] bArr2 = new byte[i4];
            int i5 = i2 - 2;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (i8 < i5) {
                c(bArr, i8 + i, 3, bArr2, i7, i3);
                int i9 = i6 + 4;
                if (z && i9 >= 76) {
                    bArr2[i7 + 4] = 10;
                    i7++;
                    i9 = 0;
                }
                i7 += 4;
                i6 = i9;
                i8 += 3;
            }
            if (i8 < i2) {
                c(bArr, i8 + i, i2 - i8, bArr2, i7, i3);
                i7 += 4;
            }
            if (i7 <= bArr2.length - 1) {
                byte[] bArr3 = new byte[i7];
                System.arraycopy(bArr2, 0, bArr3, 0, i7);
                return bArr3;
            }
            return bArr2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1201=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public static int c(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (bArr == null) {
            throw new NullPointerException("Source array was null.");
        }
        if (bArr2 == null) {
            throw new NullPointerException("Destination array was null.");
        }
        if (i < 0 || i + 3 >= bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i)));
        }
        if (i2 < 0 || i2 + 2 >= bArr2.length) {
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i2)));
        }
        byte[] ac = ac(i3);
        if (bArr[i + 2] == 61) {
            bArr2[i2] = (byte) ((((ac[bArr[i]] & 255) << 18) | ((ac[bArr[i + 1]] & 255) << 12)) >>> 16);
            return 1;
        } else if (bArr[i + 3] == 61) {
            int i4 = ((ac[bArr[i]] & 255) << 18) | ((ac[bArr[i + 1]] & 255) << 12) | ((ac[bArr[i + 2]] & 255) << 6);
            bArr2[i2] = (byte) (i4 >>> 16);
            bArr2[i2 + 1] = (byte) (i4 >>> 8);
            return 2;
        } else {
            int i5 = ((ac[bArr[i]] & 255) << 18) | ((ac[bArr[i + 1]] & 255) << 12) | ((ac[bArr[i + 2]] & 255) << 6) | (ac[bArr[i + 3]] & 255);
            bArr2[i2] = (byte) (i5 >> 16);
            bArr2[i2 + 1] = (byte) (i5 >> 8);
            bArr2[i2 + 2] = (byte) i5;
            return 3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0067, code lost:
        r2 = new byte[r0];
        java.lang.System.arraycopy(r6, 0, r2, 0, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:?, code lost:
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] decode(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        if (bArr == null) {
            throw new NullPointerException("Cannot decode null source array.");
        }
        if (i < 0 || i + i2 > bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        if (i2 == 0) {
            return new byte[0];
        }
        if (i2 < 4) {
            throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + i2);
        }
        byte[] ac = ac(i3);
        byte[] bArr2 = new byte[(i2 * 3) / 4];
        byte[] bArr3 = new byte[4];
        int i7 = i;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            if (i7 >= i + i2) {
                i4 = i9;
                break;
            }
            byte b = ac[bArr[i7] & 255];
            if (b >= -5) {
                if (b >= -1) {
                    i5 = i8 + 1;
                    bArr3[i8] = bArr[i7];
                    if (i5 > 3) {
                        i4 = c(bArr3, 0, bArr2, i9, i3) + i9;
                        if (bArr[i7] == 61) {
                            break;
                        }
                        i6 = i4;
                        i5 = 0;
                    } else {
                        i6 = i9;
                    }
                } else {
                    i5 = i8;
                    i6 = i9;
                }
                i7++;
                i9 = i6;
                i8 = i5;
            } else {
                throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", Integer.valueOf(bArr[i7] & 255), Integer.valueOf(i7)));
            }
        }
    }

    public static byte[] decode(String str) {
        return decode(str, 0);
    }

    public static byte[] decode(String str, int i) {
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
        } catch (UnsupportedEncodingException e) {
            bytes = str.getBytes();
        }
        byte[] decode = decode(bytes, 0, bytes.length, i);
        boolean z = (i & 4) != 0;
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
                            } catch (IOException e2) {
                                e = e2;
                                gZIPInputStream = gZIPInputStream2;
                                byteArrayInputStream2 = byteArrayInputStream;
                                try {
                                    e.printStackTrace();
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception e3) {
                                    }
                                    try {
                                        gZIPInputStream.close();
                                    } catch (Exception e4) {
                                    }
                                    try {
                                        byteArrayInputStream2.close();
                                    } catch (Exception e5) {
                                    }
                                    return decode;
                                } catch (Throwable th) {
                                    th = th;
                                    byteArrayInputStream = byteArrayInputStream2;
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception e6) {
                                    }
                                    try {
                                        gZIPInputStream.close();
                                    } catch (Exception e7) {
                                    }
                                    try {
                                        byteArrayInputStream.close();
                                    } catch (Exception e8) {
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
                        } catch (Exception e9) {
                        }
                        try {
                            gZIPInputStream2.close();
                        } catch (Exception e10) {
                        }
                        try {
                            byteArrayInputStream.close();
                        } catch (Exception e11) {
                        }
                    } catch (IOException e12) {
                        e = e12;
                        byteArrayInputStream2 = byteArrayInputStream;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (IOException e13) {
                    e = e13;
                    byteArrayInputStream2 = null;
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayInputStream = null;
                }
            } catch (IOException e14) {
                e = e14;
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

    /* loaded from: classes.dex */
    public static class a extends FilterOutputStream {
        private byte[] buffer;
        private int position;
        private boolean xI;
        private int xJ;
        private int xK;
        private boolean xL;
        private byte[] xM;
        private boolean xN;
        private int xO;
        private byte[] xP;

        public a(OutputStream outputStream, int i) {
            super(outputStream);
            this.xL = (i & 8) != 0;
            this.xI = (i & 1) != 0;
            this.xJ = this.xI ? 3 : 4;
            this.buffer = new byte[this.xJ];
            this.position = 0;
            this.xK = 0;
            this.xN = false;
            this.xM = new byte[4];
            this.xO = i;
            this.xP = c.ac(i);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) {
            if (this.xN) {
                this.out.write(i);
            } else if (this.xI) {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) i;
                if (this.position >= this.xJ) {
                    this.out.write(c.c(this.xM, this.buffer, this.xJ, this.xO));
                    this.xK += 4;
                    if (this.xL && this.xK >= 76) {
                        this.out.write(10);
                        this.xK = 0;
                    }
                    this.position = 0;
                }
            } else if (this.xP[i & TransportMediator.KEYCODE_MEDIA_PAUSE] > -5) {
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr2[i3] = (byte) i;
                if (this.position >= this.xJ) {
                    this.out.write(this.xM, 0, c.c(this.buffer, 0, this.xM, 0, this.xO));
                    this.position = 0;
                }
            } else if (this.xP[i & TransportMediator.KEYCODE_MEDIA_PAUSE] != -5) {
                throw new IOException("Invalid character in Base64 data.");
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            if (this.xN) {
                this.out.write(bArr, i, i2);
                return;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                write(bArr[i + i3]);
            }
        }

        public void flushBase64() {
            if (this.position > 0) {
                if (this.xI) {
                    this.out.write(c.c(this.xM, this.buffer, this.position, this.xO));
                    this.position = 0;
                    return;
                }
                throw new IOException("Base64 input not properly padded.");
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            flushBase64();
            super.close();
            this.buffer = null;
            this.out = null;
        }
    }
}
