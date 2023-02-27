package com.baidu.pass.face.platform.utils;

import com.baidu.android.imsdk.internal.Constants;
import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.net.QCodec;
/* loaded from: classes2.dex */
public class Base64Utils {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;

    /* loaded from: classes2.dex */
    public static abstract class a {
        public byte[] a;
        public int b;
    }

    /* loaded from: classes2.dex */
    public static class b extends a {
        public static final int[] c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        public static final int[] d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        public int e;
        public int f;
        public final int[] g;

        public b(int i, byte[] bArr) {
            this.a = bArr;
            this.g = (i & 8) == 0 ? c : d;
            this.e = 0;
            this.f = 0;
        }

        /* JADX WARN: Code restructure failed: missing block: B:67:0x00fe, code lost:
            if (r5 != 4) goto L27;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(byte[] bArr, int i, int i2, boolean z) {
            int i3 = this.e;
            if (i3 == 6) {
                return false;
            }
            int i4 = i2 + i;
            int i5 = this.f;
            byte[] bArr2 = this.a;
            int[] iArr = this.g;
            int i6 = i5;
            int i7 = 0;
            int i8 = i3;
            int i9 = i;
            while (i9 < i4) {
                if (i8 == 0) {
                    while (true) {
                        int i10 = i9 + 4;
                        if (i10 > i4 || (i6 = (iArr[bArr[i9] & 255] << 18) | (iArr[bArr[i9 + 1] & 255] << 12) | (iArr[bArr[i9 + 2] & 255] << 6) | iArr[bArr[i9 + 3] & 255]) < 0) {
                            break;
                        }
                        bArr2[i7 + 2] = (byte) i6;
                        bArr2[i7 + 1] = (byte) (i6 >> 8);
                        bArr2[i7] = (byte) (i6 >> 16);
                        i7 += 3;
                        i9 = i10;
                    }
                    if (i9 >= i4) {
                        break;
                    }
                }
                int i11 = i9 + 1;
                int i12 = iArr[bArr[i9] & 255];
                if (i8 != 0) {
                    if (i8 == 1) {
                        if (i12 < 0) {
                            if (i12 != -1) {
                                this.e = 6;
                                return false;
                            }
                        }
                        i12 |= i6 << 6;
                    } else if (i8 == 2) {
                        if (i12 < 0) {
                            if (i12 == -2) {
                                bArr2[i7] = (byte) (i6 >> 4);
                                i7++;
                                i8 = 4;
                            } else if (i12 != -1) {
                                this.e = 6;
                                return false;
                            }
                        }
                        i12 |= i6 << 6;
                    } else if (i8 != 3) {
                        if (i8 != 4) {
                            if (i8 == 5 && i12 != -1) {
                                this.e = 6;
                                return false;
                            }
                        } else if (i12 == -2) {
                            i8++;
                        } else if (i12 != -1) {
                            this.e = 6;
                            return false;
                        }
                    } else if (i12 >= 0) {
                        int i13 = i12 | (i6 << 6);
                        bArr2[i7 + 2] = (byte) i13;
                        bArr2[i7 + 1] = (byte) (i13 >> 8);
                        bArr2[i7] = (byte) (i13 >> 16);
                        i7 += 3;
                        i6 = i13;
                        i8 = 0;
                    } else if (i12 == -2) {
                        bArr2[i7 + 1] = (byte) (i6 >> 2);
                        bArr2[i7] = (byte) (i6 >> 10);
                        i7 += 2;
                        i8 = 5;
                    } else if (i12 != -1) {
                        break;
                    }
                    i8++;
                    i6 = i12;
                } else {
                    if (i12 < 0) {
                        if (i12 != -1) {
                            this.e = 6;
                            return false;
                        }
                    }
                    i8++;
                    i6 = i12;
                }
                i9 = i11;
            }
            if (z) {
                if (i8 != 1) {
                    if (i8 == 2) {
                        bArr2[i7] = (byte) (i6 >> 4);
                        i7++;
                    } else if (i8 == 3) {
                        int i14 = i7 + 1;
                        bArr2[i7] = (byte) (i6 >> 10);
                        i7 = i14 + 1;
                        bArr2[i14] = (byte) (i6 >> 2);
                    }
                    this.e = i8;
                }
                this.e = 6;
                return false;
            }
            this.e = i8;
            this.f = i6;
            this.b = i7;
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends a {
        public static final /* synthetic */ boolean g = !Base64Utils.class.desiredAssertionStatus();
        public static final byte[] h = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        public static final byte[] i = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, QCodec.UNDERSCORE};
        public int c;
        public final boolean d;
        public final boolean e;
        public final boolean f;
        public final byte[] j;
        public int k;
        public final byte[] l;

        public c(int i2, byte[] bArr) {
            this.a = bArr;
            this.d = (i2 & 1) == 0;
            this.e = (i2 & 2) == 0;
            this.f = (i2 & 4) != 0;
            this.l = (i2 & 8) == 0 ? h : i;
            this.j = new byte[2];
            this.c = 0;
            this.k = this.e ? 19 : -1;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:100:0x00e6 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00dd -> B:22:0x008a). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(byte[] r18, int r19, int r20, boolean r21) {
            /*
                r17 = this;
                r0 = r17
                byte[] r1 = r0.l
                byte[] r2 = r0.a
                int r3 = r0.k
                int r4 = r20 + r19
                int r5 = r0.c
                r6 = -1
                r7 = 0
                r8 = 2
                r9 = 1
                if (r5 == r9) goto L31
                if (r5 == r8) goto L15
                goto L50
            L15:
                int r5 = r19 + 1
                if (r5 > r4) goto L50
                byte[] r10 = r0.j
                r11 = r10[r7]
                r11 = r11 & 255(0xff, float:3.57E-43)
                int r11 = r11 << 16
                r10 = r10[r9]
                r10 = r10 & 255(0xff, float:3.57E-43)
                int r10 = r10 << 8
                r10 = r10 | r11
                r11 = r18[r19]
                r11 = r11 & 255(0xff, float:3.57E-43)
                r10 = r10 | r11
                r0.c = r7
                r11 = r5
                goto L53
            L31:
                int r5 = r19 + 2
                if (r5 > r4) goto L50
                byte[] r5 = r0.j
                r5 = r5[r7]
                r5 = r5 & 255(0xff, float:3.57E-43)
                int r5 = r5 << 16
                int r10 = r19 + 1
                r11 = r18[r19]
                r11 = r11 & 255(0xff, float:3.57E-43)
                int r11 = r11 << 8
                r5 = r5 | r11
                int r11 = r10 + 1
                r10 = r18[r10]
                r10 = r10 & 255(0xff, float:3.57E-43)
                r10 = r10 | r5
                r0.c = r7
                goto L53
            L50:
                r11 = r19
                r10 = -1
            L53:
                r12 = 4
                r13 = 13
                r14 = 10
                if (r10 == r6) goto L8f
                int r6 = r10 >> 18
                r6 = r6 & 63
                r6 = r1[r6]
                r2[r7] = r6
                int r6 = r10 >> 12
                r6 = r6 & 63
                r6 = r1[r6]
                r2[r9] = r6
                int r6 = r10 >> 6
                r6 = r6 & 63
                r6 = r1[r6]
                r2[r8] = r6
                r6 = r10 & 63
                r6 = r1[r6]
                r10 = 3
                r2[r10] = r6
                int r3 = r3 + (-1)
                if (r3 != 0) goto L8d
                boolean r3 = r0.f
                if (r3 == 0) goto L85
                r3 = 5
                r2[r12] = r13
                goto L86
            L85:
                r3 = 4
            L86:
                int r6 = r3 + 1
                r2[r3] = r14
            L8a:
                r3 = 19
                goto L90
            L8d:
                r6 = 4
                goto L90
            L8f:
                r6 = 0
            L90:
                int r10 = r11 + 3
                if (r10 > r4) goto Le6
                r15 = r18[r11]
                r15 = r15 & 255(0xff, float:3.57E-43)
                int r15 = r15 << 16
                int r16 = r11 + 1
                r5 = r18[r16]
                r5 = r5 & 255(0xff, float:3.57E-43)
                int r5 = r5 << 8
                r5 = r5 | r15
                int r11 = r11 + 2
                r11 = r18[r11]
                r11 = r11 & 255(0xff, float:3.57E-43)
                r5 = r5 | r11
                int r11 = r5 >> 18
                r11 = r11 & 63
                r11 = r1[r11]
                r2[r6] = r11
                int r11 = r6 + 1
                int r15 = r5 >> 12
                r15 = r15 & 63
                r15 = r1[r15]
                r2[r11] = r15
                int r11 = r6 + 2
                int r15 = r5 >> 6
                r15 = r15 & 63
                r15 = r1[r15]
                r2[r11] = r15
                int r11 = r6 + 3
                r5 = r5 & 63
                r5 = r1[r5]
                r2[r11] = r5
                int r6 = r6 + 4
                int r3 = r3 + (-1)
                if (r3 != 0) goto Le4
                boolean r3 = r0.f
                if (r3 == 0) goto Ldd
                int r3 = r6 + 1
                r2[r6] = r13
                r6 = r3
            Ldd:
                int r3 = r6 + 1
                r2[r6] = r14
                r6 = r3
                r11 = r10
                goto L8a
            Le4:
                r11 = r10
                goto L90
            Le6:
                if (r21 == 0) goto L1d8
                int r5 = r0.c
                int r10 = r11 - r5
                int r15 = r4 + (-1)
                r16 = 61
                if (r10 != r15) goto L139
                if (r5 <= 0) goto Lfa
                byte[] r5 = r0.j
                r5 = r5[r7]
                r7 = 1
                goto L100
            Lfa:
                int r5 = r11 + 1
                r8 = r18[r11]
                r11 = r5
                r5 = r8
            L100:
                r5 = r5 & 255(0xff, float:3.57E-43)
                int r5 = r5 << r12
                int r8 = r0.c
                int r8 = r8 - r7
                r0.c = r8
                int r7 = r6 + 1
                int r8 = r5 >> 6
                r8 = r8 & 63
                r8 = r1[r8]
                r2[r6] = r8
                int r6 = r7 + 1
                r5 = r5 & 63
                r1 = r1[r5]
                r2[r7] = r1
                boolean r1 = r0.d
                if (r1 == 0) goto L126
                int r1 = r6 + 1
                r2[r6] = r16
                int r6 = r1 + 1
                r2[r1] = r16
            L126:
                boolean r1 = r0.e
                if (r1 == 0) goto L1bc
                boolean r1 = r0.f
                if (r1 == 0) goto L133
                int r1 = r6 + 1
                r2[r6] = r13
                r6 = r1
            L133:
                int r1 = r6 + 1
                r2[r6] = r14
                goto L1bb
            L139:
                int r10 = r11 - r5
                int r12 = r4 + (-2)
                if (r10 != r12) goto L1a4
                if (r5 <= r9) goto L147
                byte[] r5 = r0.j
                r5 = r5[r7]
                r7 = 1
                goto L14d
            L147:
                int r5 = r11 + 1
                r10 = r18[r11]
                r11 = r5
                r5 = r10
            L14d:
                r5 = r5 & 255(0xff, float:3.57E-43)
                int r5 = r5 << r14
                int r10 = r0.c
                if (r10 <= 0) goto L15b
                byte[] r10 = r0.j
                int r12 = r7 + 1
                r7 = r10[r7]
                goto L162
            L15b:
                int r10 = r11 + 1
                r11 = r18[r11]
                r12 = r7
                r7 = r11
                r11 = r10
            L162:
                r7 = r7 & 255(0xff, float:3.57E-43)
                int r7 = r7 << r8
                r5 = r5 | r7
                int r7 = r0.c
                int r7 = r7 - r12
                r0.c = r7
                int r7 = r6 + 1
                int r8 = r5 >> 12
                r8 = r8 & 63
                r8 = r1[r8]
                r2[r6] = r8
                int r6 = r7 + 1
                int r8 = r5 >> 6
                r8 = r8 & 63
                r8 = r1[r8]
                r2[r7] = r8
                int r7 = r6 + 1
                r5 = r5 & 63
                r1 = r1[r5]
                r2[r6] = r1
                boolean r1 = r0.d
                if (r1 == 0) goto L190
                int r1 = r7 + 1
                r2[r7] = r16
                r7 = r1
            L190:
                boolean r1 = r0.e
                if (r1 == 0) goto L1a2
                boolean r1 = r0.f
                if (r1 == 0) goto L19d
                int r1 = r7 + 1
                r2[r7] = r13
                r7 = r1
            L19d:
                int r1 = r7 + 1
                r2[r7] = r14
                r7 = r1
            L1a2:
                r6 = r7
                goto L1bc
            L1a4:
                boolean r1 = r0.e
                if (r1 == 0) goto L1bc
                if (r6 <= 0) goto L1bc
                r1 = 19
                if (r3 == r1) goto L1bc
                boolean r1 = r0.f
                if (r1 == 0) goto L1b7
                int r1 = r6 + 1
                r2[r6] = r13
                r6 = r1
            L1b7:
                int r1 = r6 + 1
                r2[r6] = r14
            L1bb:
                r6 = r1
            L1bc:
                boolean r1 = com.baidu.pass.face.platform.utils.Base64Utils.c.g
                if (r1 != 0) goto L1cb
                int r1 = r0.c
                if (r1 != 0) goto L1c5
                goto L1cb
            L1c5:
                java.lang.AssertionError r1 = new java.lang.AssertionError
                r1.<init>()
                throw r1
            L1cb:
                boolean r1 = com.baidu.pass.face.platform.utils.Base64Utils.c.g
                if (r1 != 0) goto L201
                if (r11 != r4) goto L1d2
                goto L201
            L1d2:
                java.lang.AssertionError r1 = new java.lang.AssertionError
                r1.<init>()
                throw r1
            L1d8:
                int r1 = r4 + (-1)
                if (r11 != r1) goto L1e9
                byte[] r1 = r0.j
                int r2 = r0.c
                int r4 = r2 + 1
                r0.c = r4
                r4 = r18[r11]
                r1[r2] = r4
                goto L201
            L1e9:
                int r4 = r4 - r8
                if (r11 != r4) goto L201
                byte[] r1 = r0.j
                int r2 = r0.c
                int r4 = r2 + 1
                r0.c = r4
                r5 = r18[r11]
                r1[r2] = r5
                int r2 = r4 + 1
                r0.c = r2
                int r11 = r11 + r9
                r2 = r18[r11]
                r1[r4] = r2
            L201:
                r0.b = r6
                r0.k = r3
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.pass.face.platform.utils.Base64Utils.c.a(byte[], int, int, boolean):boolean");
        }
    }

    public static byte[] decode(String str, int i) {
        return decode(str.getBytes(), i);
    }

    public static byte[] decode(byte[] bArr, int i) {
        return decode(bArr, 0, bArr.length, i);
    }

    public static byte[] decode(byte[] bArr, int i, int i2, int i3) {
        b bVar = new b(i3, new byte[(i2 * 3) / 4]);
        if (bVar.a(bArr, i, i2, true)) {
            int i4 = bVar.b;
            byte[] bArr2 = bVar.a;
            if (i4 == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i4];
            System.arraycopy(bArr2, 0, bArr3, 0, i4);
            return bArr3;
        }
        throw new IllegalArgumentException("bad base-64");
    }

    public static byte[] encode(byte[] bArr, int i) {
        return encode(bArr, 0, bArr.length, i);
    }

    public static byte[] encode(byte[] bArr, int i, int i2, int i3) {
        c cVar = new c(i3, null);
        int i4 = (i2 / 3) * 4;
        if (!cVar.d) {
            int i5 = i2 % 3;
            if (i5 == 1) {
                i4 += 2;
            } else if (i5 == 2) {
                i4 += 3;
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (cVar.e && i2 > 0) {
            i4 += (((i2 - 1) / 57) + 1) * (cVar.f ? 2 : 1);
        }
        cVar.a = new byte[i4];
        cVar.a(bArr, i, i2, true);
        return cVar.a;
    }

    public static String encodeToString(byte[] bArr, int i) {
        try {
            return new String(encode(bArr, i), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static String encodeToString(byte[] bArr, int i, int i2, int i3) {
        try {
            return new String(encode(bArr, i, i2, i3), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
