package com.baidu.batsdk.f;

import java.io.UnsupportedEncodingException;
/* loaded from: classes.dex */
public class b {
    private static /* synthetic */ boolean a;

    static {
        a = !b.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public abstract class a {
        public byte[] a;
        public int b;

        a() {
        }
    }

    public static byte[] a(String str, int i) {
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        C0004b c0004b = new C0004b(0, new byte[(length * 3) / 4]);
        if (c0004b.a(bytes, 0, length, true)) {
            if (c0004b.b == c0004b.a.length) {
                return c0004b.a;
            }
            byte[] bArr = new byte[c0004b.b];
            System.arraycopy(c0004b.a, 0, bArr, 0, c0004b.b);
            return bArr;
        }
        throw new IllegalArgumentException("bad base-64");
    }

    /* renamed from: com.baidu.batsdk.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    final class C0004b extends a {
        private static final int[] c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private int e;
        private int f;
        private final int[] g;

        public C0004b(int i, byte[] bArr) {
            this.a = bArr;
            this.g = (i & 8) == 0 ? c : d;
            this.e = 0;
            this.f = 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [297=4] */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0112  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0118  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0122  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0132  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean a(byte[] bArr, int i, int i2, boolean z) {
            if (this.e == 6) {
                return false;
            }
            int i3 = i2 + i;
            int i4 = this.e;
            int i5 = this.f;
            int i6 = 0;
            byte[] bArr2 = this.a;
            int[] iArr = this.g;
            int i7 = i4;
            int i8 = i;
            while (i8 < i3) {
                if (i7 == 0) {
                    while (i8 + 4 <= i3 && (i5 = (iArr[bArr[i8] & 255] << 18) | (iArr[bArr[i8 + 1] & 255] << 12) | (iArr[bArr[i8 + 2] & 255] << 6) | iArr[bArr[i8 + 3] & 255]) >= 0) {
                        bArr2[i6 + 2] = (byte) i5;
                        bArr2[i6 + 1] = (byte) (i5 >> 8);
                        bArr2[i6] = (byte) (i5 >> 16);
                        i6 += 3;
                        i8 += 4;
                    }
                    if (i8 >= i3) {
                        int i9 = i5;
                        switch (i7) {
                            case 1:
                                this.e = 6;
                                return false;
                            case 2:
                                bArr2[i6] = (byte) (i9 >> 4);
                                i6++;
                                break;
                            case 3:
                                int i10 = i6 + 1;
                                bArr2[i6] = (byte) (i9 >> 10);
                                i6 = i10 + 1;
                                bArr2[i10] = (byte) (i9 >> 2);
                                break;
                            case 4:
                                this.e = 6;
                                return false;
                        }
                        this.e = i7;
                        this.b = i6;
                        return true;
                    }
                }
                int i11 = i8 + 1;
                int i12 = iArr[bArr[i8] & 255];
                switch (i7) {
                    case 0:
                        if (i12 >= 0) {
                            i7++;
                            i5 = i12;
                            i8 = i11;
                            continue;
                        } else if (i12 != -1) {
                            this.e = 6;
                            return false;
                        }
                        break;
                    case 1:
                        if (i12 >= 0) {
                            i5 = (i5 << 6) | i12;
                            i7++;
                            i8 = i11;
                            continue;
                        } else if (i12 != -1) {
                            this.e = 6;
                            return false;
                        }
                        break;
                    case 2:
                        if (i12 >= 0) {
                            i5 = (i5 << 6) | i12;
                            i7++;
                            i8 = i11;
                            continue;
                        } else if (i12 == -2) {
                            bArr2[i6] = (byte) (i5 >> 4);
                            i7 = 4;
                            i6++;
                            i8 = i11;
                        } else if (i12 != -1) {
                            this.e = 6;
                            return false;
                        }
                        break;
                    case 3:
                        if (i12 >= 0) {
                            i5 = (i5 << 6) | i12;
                            bArr2[i6 + 2] = (byte) i5;
                            bArr2[i6 + 1] = (byte) (i5 >> 8);
                            bArr2[i6] = (byte) (i5 >> 16);
                            i6 += 3;
                            i7 = 0;
                            i8 = i11;
                            continue;
                        } else if (i12 == -2) {
                            bArr2[i6 + 1] = (byte) (i5 >> 2);
                            bArr2[i6] = (byte) (i5 >> 10);
                            i6 += 2;
                            i7 = 5;
                            i8 = i11;
                        } else if (i12 != -1) {
                            this.e = 6;
                            return false;
                        }
                        break;
                    case 4:
                        if (i12 == -2) {
                            i7++;
                            i8 = i11;
                            continue;
                        } else if (i12 != -1) {
                            this.e = 6;
                            return false;
                        }
                        break;
                    case 5:
                        if (i12 != -1) {
                            this.e = 6;
                            return false;
                        }
                        break;
                }
                i8 = i11;
            }
            int i92 = i5;
            switch (i7) {
            }
            this.e = i7;
            this.b = i6;
            return true;
        }
    }

    public static String a(byte[] bArr, int i) {
        int i2;
        try {
            int length = bArr.length;
            c cVar = new c(0, null);
            int i3 = (length / 3) << 2;
            if (!cVar.c) {
                switch (length % 3) {
                    case 1:
                        i3 += 2;
                        break;
                    case 2:
                        i3 += 3;
                        break;
                }
            } else if (length % 3 > 0) {
                i3 += 4;
            }
            if (!cVar.d || length <= 0) {
                i2 = i3;
            } else {
                i2 = ((cVar.e ? 2 : 1) * (((length - 1) / 57) + 1)) + i3;
            }
            cVar.a = new byte[i2];
            cVar.a(bArr, 0, length, true);
            if (a || cVar.b == i2) {
                return new String(cVar.a, "US-ASCII");
            }
            throw new AssertionError();
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    /* loaded from: classes.dex */
    final class c extends a {
        private static final byte[] f;
        private static final byte[] g;
        private static /* synthetic */ boolean l;
        public final boolean c;
        public final boolean d;
        public final boolean e;
        private final byte[] h;
        private int i;
        private int j;
        private final byte[] k;

        static {
            l = !b.class.desiredAssertionStatus();
            f = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
            g = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        }

        public c(int i, byte[] bArr) {
            this.a = null;
            this.c = (i & 1) == 0;
            this.d = (i & 2) == 0;
            this.e = (i & 4) != 0;
            this.k = (i & 8) == 0 ? f : g;
            this.h = new byte[2];
            this.i = 0;
            this.j = this.d ? 19 : -1;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public final boolean a(byte[] bArr, int i, int i2, boolean z) {
            int i3;
            int i4;
            int i5;
            int i6;
            byte b;
            int i7;
            byte b2;
            int i8;
            byte b3;
            int i9;
            int i10;
            byte[] bArr2 = this.k;
            byte[] bArr3 = this.a;
            int i11 = 0;
            int i12 = this.j;
            int i13 = i2 + i;
            switch (this.i) {
                case 0:
                    i4 = -1;
                    i3 = i;
                    break;
                case 1:
                    if (i + 2 <= i13) {
                        int i14 = i + 1;
                        this.i = 0;
                        i4 = ((this.h[0] & 255) << 16) | ((bArr[i] & 255) << 8) | (bArr[i14] & 255);
                        i3 = i14 + 1;
                        break;
                    }
                    i4 = -1;
                    i3 = i;
                    break;
                case 2:
                    if (i + 1 <= i13) {
                        int i15 = ((this.h[0] & 255) << 16) | ((this.h[1] & 255) << 8);
                        i3 = i + 1;
                        this.i = 0;
                        i4 = i15 | (bArr[i] & 255);
                        break;
                    }
                    i4 = -1;
                    i3 = i;
                    break;
                default:
                    i4 = -1;
                    i3 = i;
                    break;
            }
            if (i4 != -1) {
                bArr3[0] = bArr2[(i4 >> 18) & 63];
                bArr3[1] = bArr2[(i4 >> 12) & 63];
                bArr3[2] = bArr2[(i4 >> 6) & 63];
                int i16 = 4;
                bArr3[3] = bArr2[i4 & 63];
                int i17 = i12 - 1;
                if (i17 == 0) {
                    if (this.e) {
                        i16 = 5;
                        bArr3[4] = 13;
                    }
                    i11 = i16 + 1;
                    bArr3[i16] = 10;
                    i5 = 19;
                } else {
                    i5 = i17;
                    i11 = 4;
                }
            } else {
                i5 = i12;
            }
            while (i3 + 3 <= i13) {
                int i18 = ((bArr[i3] & 255) << 16) | ((bArr[i3 + 1] & 255) << 8) | (bArr[i3 + 2] & 255);
                bArr3[i11] = bArr2[(i18 >> 18) & 63];
                bArr3[i11 + 1] = bArr2[(i18 >> 12) & 63];
                bArr3[i11 + 2] = bArr2[(i18 >> 6) & 63];
                bArr3[i11 + 3] = bArr2[i18 & 63];
                int i19 = i3 + 3;
                int i20 = i11 + 4;
                int i21 = i5 - 1;
                if (i21 == 0) {
                    if (this.e) {
                        i10 = i20 + 1;
                        bArr3[i20] = 13;
                    } else {
                        i10 = i20;
                    }
                    i11 = i10 + 1;
                    bArr3[i10] = 10;
                    i3 = i19;
                    i5 = 19;
                } else {
                    i5 = i21;
                    i11 = i20;
                    i3 = i19;
                }
            }
            if (i3 - this.i == i13 - 1) {
                if (this.i > 0) {
                    i9 = 1;
                    b3 = this.h[0];
                } else {
                    b3 = bArr[i3];
                    i3++;
                    i9 = 0;
                }
                int i22 = (b3 & 255) << 4;
                this.i -= i9;
                int i23 = i11 + 1;
                bArr3[i11] = bArr2[(i22 >> 6) & 63];
                i8 = i23 + 1;
                bArr3[i23] = bArr2[i22 & 63];
                if (this.c) {
                    int i24 = i8 + 1;
                    bArr3[i8] = 61;
                    i8 = i24 + 1;
                    bArr3[i24] = 61;
                }
                if (this.d) {
                    if (this.e) {
                        bArr3[i8] = 13;
                        i8++;
                    }
                    i11 = i8 + 1;
                    bArr3[i8] = 10;
                }
                i11 = i8;
            } else if (i3 - this.i == i13 - 2) {
                if (this.i > 1) {
                    i7 = 1;
                    b = this.h[0];
                } else {
                    b = bArr[i3];
                    i3++;
                    i7 = 0;
                }
                int i25 = (b & 255) << 10;
                if (this.i > 0) {
                    b2 = this.h[i7];
                    i7++;
                } else {
                    b2 = bArr[i3];
                    i3++;
                }
                int i26 = ((b2 & 255) << 2) | i25;
                this.i -= i7;
                int i27 = i11 + 1;
                bArr3[i11] = bArr2[(i26 >> 12) & 63];
                int i28 = i27 + 1;
                bArr3[i27] = bArr2[(i26 >> 6) & 63];
                int i29 = i28 + 1;
                bArr3[i28] = bArr2[i26 & 63];
                if (this.c) {
                    i8 = i29 + 1;
                    bArr3[i29] = 61;
                } else {
                    i8 = i29;
                }
                if (this.d) {
                    if (this.e) {
                        bArr3[i8] = 13;
                        i8++;
                    }
                    i11 = i8 + 1;
                    bArr3[i8] = 10;
                }
                i11 = i8;
            } else if (this.d && i11 > 0 && i5 != 19) {
                if (this.e) {
                    i6 = i11 + 1;
                    bArr3[i11] = 13;
                } else {
                    i6 = i11;
                }
                i11 = i6 + 1;
                bArr3[i6] = 10;
            }
            if (l || this.i == 0) {
                if (l || i3 == i13) {
                    this.b = i11;
                    this.j = i5;
                    return true;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
    }

    private b() {
    }
}
