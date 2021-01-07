package com.baidu.b.c.a;

import java.lang.reflect.Array;
import java.security.InvalidKeyException;
/* loaded from: classes3.dex */
public final class b implements a {
    private static int[] g;
    private static int[] h;
    private static final byte[] i = new byte[256];
    private static final byte[] j = new byte[256];
    private static final int[] k = new int[256];
    private static final int[] l = new int[256];
    private static final int[] m = new int[256];
    private static final int[] n = new int[256];
    private static final int[] o = new int[256];
    private static final int[] p = new int[256];
    private static final int[] q = new int[256];
    private static final int[] r = new int[256];
    private static final int[] s = new int[256];
    private static final int[] t = new int[256];
    private static final int[] u = new int[256];
    private static final int[] v = new int[256];
    private static final byte[] w = new byte[30];

    /* renamed from: b  reason: collision with root package name */
    private boolean f1594b = false;
    private boolean c = false;
    private Object[] d = null;
    private int[] e = null;
    private int f = 0;

    static {
        int i2 = 1;
        g = new int[256];
        h = new int[256];
        g[0] = 1;
        for (int i3 = 1; i3 < 256; i3++) {
            int i4 = (g[i3 - 1] << 1) ^ g[i3 - 1];
            if ((i4 & 256) != 0) {
                i4 ^= 283;
            }
            g[i3] = i4;
        }
        for (int i5 = 1; i5 < 255; i5++) {
            h[g[i5]] = i5;
        }
        byte[][] bArr = {new byte[]{1, 1, 1, 1, 1, 0, 0, 0}, new byte[]{0, 1, 1, 1, 1, 1, 0, 0}, new byte[]{0, 0, 1, 1, 1, 1, 1, 0}, new byte[]{0, 0, 0, 1, 1, 1, 1, 1}, new byte[]{1, 0, 0, 0, 1, 1, 1, 1}, new byte[]{1, 1, 0, 0, 0, 1, 1, 1}, new byte[]{1, 1, 1, 0, 0, 0, 1, 1}, new byte[]{1, 1, 1, 1, 0, 0, 0, 1}};
        byte[] bArr2 = {0, 1, 1, 0, 0, 0, 1, 1};
        byte[][] bArr3 = (byte[][]) Array.newInstance(Byte.TYPE, 256, 8);
        bArr3[1][7] = 1;
        for (int i6 = 2; i6 < 256; i6++) {
            int i7 = g[255 - h[i6]];
            for (int i8 = 0; i8 < 8; i8++) {
                bArr3[i6][i8] = (byte) ((i7 >>> (7 - i8)) & 1);
            }
        }
        byte[][] bArr4 = (byte[][]) Array.newInstance(Byte.TYPE, 256, 8);
        for (int i9 = 0; i9 < 256; i9++) {
            for (int i10 = 0; i10 < 8; i10++) {
                bArr4[i9][i10] = bArr2[i10];
                for (int i11 = 0; i11 < 8; i11++) {
                    byte[] bArr5 = bArr4[i9];
                    bArr5[i10] = (byte) (bArr5[i10] ^ (bArr[i10][i11] * bArr3[i9][i11]));
                }
            }
        }
        for (int i12 = 0; i12 < 256; i12++) {
            i[i12] = (byte) (bArr4[i12][0] << 7);
            for (int i13 = 1; i13 < 8; i13++) {
                byte[] bArr6 = i;
                bArr6[i12] = (byte) (bArr6[i12] ^ (bArr4[i12][i13] << (7 - i13)));
            }
            j[i[i12] & 255] = (byte) i12;
        }
        byte[][] bArr7 = {new byte[]{2, 1, 1, 3}, new byte[]{3, 2, 1, 1}, new byte[]{1, 3, 2, 1}, new byte[]{1, 1, 3, 2}};
        byte[][] bArr8 = (byte[][]) Array.newInstance(Byte.TYPE, 4, 8);
        for (int i14 = 0; i14 < 4; i14++) {
            for (int i15 = 0; i15 < 4; i15++) {
                bArr8[i14][i15] = bArr7[i14][i15];
            }
            bArr8[i14][i14 + 4] = 1;
        }
        byte[][] bArr9 = (byte[][]) Array.newInstance(Byte.TYPE, 4, 4);
        for (int i16 = 0; i16 < 4; i16++) {
            byte b2 = bArr8[i16][i16];
            if (b2 == 0) {
                int i17 = i16 + 1;
                while (bArr8[i17][i16] == 0 && i17 < 4) {
                    i17++;
                }
                if (i17 == 4) {
                    throw new RuntimeException("G matrix is not invertible");
                }
                for (int i18 = 0; i18 < 8; i18++) {
                    byte b3 = bArr8[i16][i18];
                    bArr8[i16][i18] = bArr8[i17][i18];
                    bArr8[i17][i18] = b3;
                }
                b2 = bArr8[i16][i16];
            }
            for (int i19 = 0; i19 < 8; i19++) {
                if (bArr8[i16][i19] != 0) {
                    bArr8[i16][i19] = (byte) g[((h[bArr8[i16][i19] & 255] + 255) - h[b2 & 255]) % 255];
                }
            }
            for (int i20 = 0; i20 < 4; i20++) {
                if (i16 != i20) {
                    for (int i21 = i16 + 1; i21 < 8; i21++) {
                        byte[] bArr10 = bArr8[i20];
                        bArr10[i21] = (byte) (bArr10[i21] ^ a(bArr8[i16][i21], bArr8[i20][i16]));
                    }
                    bArr8[i20][i16] = 0;
                }
            }
        }
        for (int i22 = 0; i22 < 4; i22++) {
            for (int i23 = 0; i23 < 4; i23++) {
                bArr9[i22][i23] = bArr8[i22][i23 + 4];
            }
        }
        for (int i24 = 0; i24 < 256; i24++) {
            byte b4 = i[i24];
            k[i24] = e(b4, bArr7[0]);
            l[i24] = e(b4, bArr7[1]);
            m[i24] = e(b4, bArr7[2]);
            n[i24] = e(b4, bArr7[3]);
            byte b5 = j[i24];
            o[i24] = e(b5, bArr9[0]);
            p[i24] = e(b5, bArr9[1]);
            q[i24] = e(b5, bArr9[2]);
            r[i24] = e(b5, bArr9[3]);
            s[i24] = e(i24, bArr9[0]);
            t[i24] = e(i24, bArr9[1]);
            u[i24] = e(i24, bArr9[2]);
            v[i24] = e(i24, bArr9[3]);
        }
        w[0] = 1;
        int i25 = 1;
        while (true) {
            int i26 = i2;
            if (i26 >= 30) {
                h = null;
                g = null;
                return;
            }
            i25 = a(2, i25);
            w[i26] = (byte) i25;
            i2 = i26 + 1;
        }
    }

    private static final int a(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        return g[(h[i2 & 255] + h[i3 & 255]) % 255];
    }

    private void a(boolean z) {
        int[][] iArr = (int[][]) this.d[z ? (char) 1 : (char) 0];
        int length = iArr.length;
        this.e = new int[length * 4];
        for (int i2 = 0; i2 < length; i2++) {
            for (int i3 = 0; i3 < 4; i3++) {
                this.e[(i2 * 4) + i3] = iArr[i2][i3];
            }
        }
        if (z) {
            int i4 = this.e[this.e.length - 4];
            int i5 = this.e[this.e.length - 3];
            int i6 = this.e[this.e.length - 2];
            int i7 = this.e[this.e.length - 1];
            for (int length2 = this.e.length - 1; length2 > 3; length2--) {
                this.e[length2] = this.e[length2 - 4];
            }
            this.e[0] = i4;
            this.e[1] = i5;
            this.e[2] = i6;
            this.e[3] = i7;
        }
        this.f1594b = length >= 13;
        this.c = length == 15;
        this.f = (length - 1) * 4;
    }

    static final boolean a(int i2) {
        for (int i3 = 0; i3 < f1593a.length; i3++) {
            if (i2 == f1593a[i3]) {
                return true;
            }
        }
        return false;
    }

    private static int b(int i2) {
        return (i2 >> 2) + 6;
    }

    private static final int e(int i2, byte[] bArr) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = h[i2 & 255];
        return (bArr[3] != 0 ? g[(i3 + h[bArr[3] & 255]) % 255] & 255 : 0) | ((bArr[0] != 0 ? g[(h[bArr[0] & 255] + i3) % 255] & 255 : 0) << 24) | ((bArr[1] != 0 ? g[(h[bArr[1] & 255] + i3) % 255] & 255 : 0) << 16) | ((bArr[2] != 0 ? g[(h[bArr[2] & 255] + i3) % 255] & 255 : 0) << 8);
    }

    private static Object[] r(byte[] bArr) {
        if (bArr == null) {
            throw new InvalidKeyException("Empty key");
        }
        if (a(bArr.length)) {
            int b2 = b(bArr.length);
            int i2 = (b2 + 1) * 4;
            int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, b2 + 1, 4);
            int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, b2 + 1, 4);
            int length = bArr.length / 4;
            int[] iArr3 = new int[length];
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                iArr3[i3] = (bArr[i4] << 24) | ((bArr[i4 + 1] & 255) << 16) | ((bArr[i4 + 2] & 255) << 8) | (bArr[i4 + 3] & 255);
                i3++;
                i4 += 4;
            }
            int i5 = 0;
            int i6 = 0;
            while (i6 < length && i5 < i2) {
                iArr[i5 / 4][i5 % 4] = iArr3[i6];
                iArr2[b2 - (i5 / 4)][i5 % 4] = iArr3[i6];
                i6++;
                i5++;
            }
            int i7 = 0;
            while (i5 < i2) {
                int i8 = iArr3[length - 1];
                int i9 = i7 + 1;
                iArr3[0] = (((i[i8 >>> 24] & 255) ^ (((i[(i8 >>> 16) & 255] << 24) ^ ((i[(i8 >>> 8) & 255] & 255) << 16)) ^ ((i[i8 & 255] & 255) << 8))) ^ (w[i7] << 24)) ^ iArr3[0];
                if (length != 8) {
                    int i10 = 1;
                    int i11 = 0;
                    while (i10 < length) {
                        iArr3[i10] = iArr3[i10] ^ iArr3[i11];
                        i10++;
                        i11++;
                    }
                } else {
                    int i12 = 1;
                    int i13 = 0;
                    while (i12 < length / 2) {
                        iArr3[i12] = iArr3[i12] ^ iArr3[i13];
                        i12++;
                        i13++;
                    }
                    int i14 = iArr3[(length / 2) - 1];
                    int i15 = length / 2;
                    iArr3[i15] = ((i[i14 >>> 24] << 24) ^ (((i[i14 & 255] & 255) ^ ((i[(i14 >>> 8) & 255] & 255) << 8)) ^ ((i[(i14 >>> 16) & 255] & 255) << 16))) ^ iArr3[i15];
                    int i16 = length / 2;
                    int i17 = i16 + 1;
                    while (i17 < length) {
                        iArr3[i17] = iArr3[i17] ^ iArr3[i16];
                        i17++;
                        i16++;
                    }
                }
                int i18 = 0;
                int i19 = i5;
                while (i18 < length && i19 < i2) {
                    iArr[i19 / 4][i19 % 4] = iArr3[i18];
                    iArr2[b2 - (i19 / 4)][i19 % 4] = iArr3[i18];
                    i18++;
                    i19++;
                }
                i7 = i9;
                i5 = i19;
            }
            for (int i20 = 1; i20 < b2; i20++) {
                for (int i21 = 0; i21 < 4; i21++) {
                    int i22 = iArr2[i20][i21];
                    iArr2[i20][i21] = v[i22 & 255] ^ ((s[(i22 >>> 24) & 255] ^ t[(i22 >>> 16) & 255]) ^ u[(i22 >>> 8) & 255]);
                }
            }
            return new Object[]{iArr, iArr2};
        }
        throw new InvalidKeyException("Invalid AES key length: " + bArr.length + " bytes");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return 16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z, String str, byte[] bArr) {
        if (!a(bArr.length)) {
            throw new InvalidKeyException("Invalid AES key length: " + bArr.length + " bytes");
        }
        this.d = r(bArr);
        a(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(byte[] bArr, int i2, byte[] bArr2, int i3) {
        int i4 = i2 + 1;
        int i5 = i4 + 1;
        int i6 = i5 + 1;
        int i7 = ((bArr[i4] & 255) << 16) | (bArr[i2] << 24) | ((bArr[i5] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = (i7 | (bArr[i6] & 255)) ^ this.e[0];
        int i10 = i8 + 1;
        int i11 = i10 + 1;
        int i12 = ((bArr[i10] & 255) << 16) | (bArr[i8] << 24);
        int i13 = i11 + 1;
        int i14 = i13 + 1;
        int i15 = ((i12 | ((bArr[i11] & 255) << 8)) | (bArr[i13] & 255)) ^ this.e[1];
        int i16 = i14 + 1;
        int i17 = i16 + 1;
        int i18 = i17 + 1;
        int i19 = ((bArr[i16] & 255) << 16) | (bArr[i14] << 24) | ((bArr[i17] & 255) << 8);
        int i20 = i18 + 1;
        int i21 = this.e[2] ^ (i19 | (bArr[i18] & 255));
        int i22 = i20 + 1;
        int i23 = i22 + 1;
        int i24 = ((bArr[i22] & 255) << 16) | (bArr[i20] << 24);
        int i25 = i23 + 1;
        int i26 = i24 | ((bArr[i23] & 255) << 8);
        int i27 = i25 + 1;
        int i28 = (i26 | (bArr[i25] & 255)) ^ this.e[3];
        int i29 = i15;
        int i30 = i9;
        int i31 = 4;
        while (i31 < this.f) {
            int i32 = i31 + 1;
            int i33 = (((k[i30 >>> 24] ^ l[(i29 >>> 16) & 255]) ^ m[(i21 >>> 8) & 255]) ^ n[i28 & 255]) ^ this.e[i31];
            int i34 = i32 + 1;
            int i35 = this.e[i32] ^ (((k[i29 >>> 24] ^ l[(i21 >>> 16) & 255]) ^ m[(i28 >>> 8) & 255]) ^ n[i30 & 255]);
            int i36 = i34 + 1;
            int i37 = (((k[i21 >>> 24] ^ l[(i28 >>> 16) & 255]) ^ m[(i30 >>> 8) & 255]) ^ n[i29 & 255]) ^ this.e[i34];
            i31 = i36 + 1;
            i28 = (((k[i28 >>> 24] ^ l[(i30 >>> 16) & 255]) ^ m[(i29 >>> 8) & 255]) ^ n[i21 & 255]) ^ this.e[i36];
            i21 = i37;
            i29 = i35;
            i30 = i33;
        }
        int i38 = i31 + 1;
        int i39 = this.e[i31];
        int i40 = i3 + 1;
        bArr2[i3] = (byte) (i[i30 >>> 24] ^ (i39 >>> 24));
        int i41 = i40 + 1;
        bArr2[i40] = (byte) (i[(i29 >>> 16) & 255] ^ (i39 >>> 16));
        int i42 = i41 + 1;
        bArr2[i41] = (byte) (i[(i21 >>> 8) & 255] ^ (i39 >>> 8));
        int i43 = i42 + 1;
        bArr2[i42] = (byte) (i39 ^ i[i28 & 255]);
        int i44 = i38 + 1;
        int i45 = this.e[i38];
        int i46 = i43 + 1;
        bArr2[i43] = (byte) (i[i29 >>> 24] ^ (i45 >>> 24));
        int i47 = i46 + 1;
        bArr2[i46] = (byte) (i[(i21 >>> 16) & 255] ^ (i45 >>> 16));
        int i48 = i47 + 1;
        bArr2[i47] = (byte) (i[(i28 >>> 8) & 255] ^ (i45 >>> 8));
        int i49 = i48 + 1;
        bArr2[i48] = (byte) (i45 ^ i[i30 & 255]);
        int i50 = i44 + 1;
        int i51 = this.e[i44];
        int i52 = i49 + 1;
        bArr2[i49] = (byte) (i[i21 >>> 24] ^ (i51 >>> 24));
        int i53 = i52 + 1;
        bArr2[i52] = (byte) (i[(i28 >>> 16) & 255] ^ (i51 >>> 16));
        int i54 = i53 + 1;
        bArr2[i53] = (byte) (i[(i30 >>> 8) & 255] ^ (i51 >>> 8));
        int i55 = i54 + 1;
        bArr2[i54] = (byte) (i51 ^ i[i29 & 255]);
        int i56 = i50 + 1;
        int i57 = this.e[i50];
        int i58 = i55 + 1;
        bArr2[i55] = (byte) (i[i28 >>> 24] ^ (i57 >>> 24));
        int i59 = i58 + 1;
        bArr2[i58] = (byte) (i[(i30 >>> 16) & 255] ^ (i57 >>> 16));
        bArr2[i59] = (byte) (i[(i29 >>> 8) & 255] ^ (i57 >>> 8));
        bArr2[i59 + 1] = (byte) (i[i21 & 255] ^ i57);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(byte[] bArr, int i2, byte[] bArr2, int i3) {
        int i4 = i2 + 1;
        int i5 = i4 + 1;
        int i6 = i5 + 1;
        int i7 = i6 + 1;
        int i8 = (((((bArr[i4] & 255) << 16) | (bArr[i2] << 24)) | ((bArr[i5] & 255) << 8)) | (bArr[i6] & 255)) ^ this.e[4];
        int i9 = i7 + 1;
        int i10 = i9 + 1;
        int i11 = ((bArr[i9] & 255) << 16) | (bArr[i7] << 24);
        int i12 = i10 + 1;
        int i13 = i12 + 1;
        int i14 = ((i11 | ((bArr[i10] & 255) << 8)) | (bArr[i12] & 255)) ^ this.e[5];
        int i15 = i13 + 1;
        int i16 = i15 + 1;
        int i17 = i16 + 1;
        int i18 = ((bArr[i15] & 255) << 16) | (bArr[i13] << 24) | ((bArr[i16] & 255) << 8);
        int i19 = i17 + 1;
        int i20 = this.e[6] ^ (i18 | (bArr[i17] & 255));
        int i21 = i19 + 1;
        int i22 = i21 + 1;
        int i23 = ((bArr[i21] & 255) << 16) | (bArr[i19] << 24) | ((bArr[i22] & 255) << 8) | (bArr[i22 + 1] & 255);
        int i24 = 8;
        int i25 = i23 ^ this.e[7];
        if (this.f1594b) {
            int i26 = this.e[8] ^ (((o[i8 >>> 24] ^ p[(i25 >>> 16) & 255]) ^ q[(i20 >>> 8) & 255]) ^ r[i14 & 255]);
            int i27 = (((o[i14 >>> 24] ^ p[(i8 >>> 16) & 255]) ^ q[(i25 >>> 8) & 255]) ^ r[i20 & 255]) ^ this.e[9];
            int i28 = (((o[i20 >>> 24] ^ p[(i14 >>> 16) & 255]) ^ q[(i8 >>> 8) & 255]) ^ r[i25 & 255]) ^ this.e[10];
            int i29 = (((o[i25 >>> 24] ^ p[(i20 >>> 16) & 255]) ^ q[(i14 >>> 8) & 255]) ^ r[i8 & 255]) ^ this.e[11];
            i8 = (((o[i26 >>> 24] ^ p[(i29 >>> 16) & 255]) ^ q[(i28 >>> 8) & 255]) ^ r[i27 & 255]) ^ this.e[12];
            i14 = this.e[13] ^ (((o[i27 >>> 24] ^ p[(i26 >>> 16) & 255]) ^ q[(i29 >>> 8) & 255]) ^ r[i28 & 255]);
            i20 = (((o[i28 >>> 24] ^ p[(i27 >>> 16) & 255]) ^ q[(i26 >>> 8) & 255]) ^ r[i29 & 255]) ^ this.e[14];
            int i30 = ((o[i29 >>> 24] ^ p[(i28 >>> 16) & 255]) ^ q[(i27 >>> 8) & 255]) ^ r[i26 & 255];
            i24 = 16;
            i25 = i30 ^ this.e[15];
            if (this.c) {
                int i31 = this.e[16] ^ (((o[i8 >>> 24] ^ p[(i25 >>> 16) & 255]) ^ q[(i20 >>> 8) & 255]) ^ r[i14 & 255]);
                int i32 = (((o[i14 >>> 24] ^ p[(i8 >>> 16) & 255]) ^ q[(i25 >>> 8) & 255]) ^ r[i20 & 255]) ^ this.e[17];
                int i33 = (((o[i20 >>> 24] ^ p[(i14 >>> 16) & 255]) ^ q[(i8 >>> 8) & 255]) ^ r[i25 & 255]) ^ this.e[18];
                int i34 = (((o[i25 >>> 24] ^ p[(i20 >>> 16) & 255]) ^ q[(i14 >>> 8) & 255]) ^ r[i8 & 255]) ^ this.e[19];
                i8 = (((o[i31 >>> 24] ^ p[(i34 >>> 16) & 255]) ^ q[(i33 >>> 8) & 255]) ^ r[i32 & 255]) ^ this.e[20];
                i14 = this.e[21] ^ (((o[i32 >>> 24] ^ p[(i31 >>> 16) & 255]) ^ q[(i34 >>> 8) & 255]) ^ r[i33 & 255]);
                i20 = (((o[i33 >>> 24] ^ p[(i32 >>> 16) & 255]) ^ q[(i31 >>> 8) & 255]) ^ r[i34 & 255]) ^ this.e[22];
                int i35 = ((o[i34 >>> 24] ^ p[(i33 >>> 16) & 255]) ^ q[(i32 >>> 8) & 255]) ^ r[i31 & 255];
                i24 = 24;
                i25 = i35 ^ this.e[23];
            }
        }
        int i36 = i24 + 1;
        int i37 = this.e[i24] ^ (((o[i8 >>> 24] ^ p[(i25 >>> 16) & 255]) ^ q[(i20 >>> 8) & 255]) ^ r[i14 & 255]);
        int i38 = i36 + 1;
        int i39 = (((o[i14 >>> 24] ^ p[(i8 >>> 16) & 255]) ^ q[(i25 >>> 8) & 255]) ^ r[i20 & 255]) ^ this.e[i36];
        int i40 = i38 + 1;
        int i41 = (((o[i20 >>> 24] ^ p[(i14 >>> 16) & 255]) ^ q[(i8 >>> 8) & 255]) ^ r[i25 & 255]) ^ this.e[i38];
        int i42 = i40 + 1;
        int i43 = (((o[i25 >>> 24] ^ p[(i20 >>> 16) & 255]) ^ q[(i14 >>> 8) & 255]) ^ r[i8 & 255]) ^ this.e[i40];
        int i44 = i42 + 1;
        int i45 = (((o[i37 >>> 24] ^ p[(i43 >>> 16) & 255]) ^ q[(i41 >>> 8) & 255]) ^ r[i39 & 255]) ^ this.e[i42];
        int i46 = i44 + 1;
        int i47 = (((o[i39 >>> 24] ^ p[(i37 >>> 16) & 255]) ^ q[(i43 >>> 8) & 255]) ^ r[i41 & 255]) ^ this.e[i44];
        int i48 = i46 + 1;
        int i49 = (((o[i41 >>> 24] ^ p[(i39 >>> 16) & 255]) ^ q[(i37 >>> 8) & 255]) ^ r[i43 & 255]) ^ this.e[i46];
        int i50 = i48 + 1;
        int i51 = (((o[i43 >>> 24] ^ p[(i41 >>> 16) & 255]) ^ q[(i39 >>> 8) & 255]) ^ r[i37 & 255]) ^ this.e[i48];
        int i52 = i50 + 1;
        int i53 = (((o[i45 >>> 24] ^ p[(i51 >>> 16) & 255]) ^ q[(i49 >>> 8) & 255]) ^ r[i47 & 255]) ^ this.e[i50];
        int i54 = i52 + 1;
        int i55 = (((o[i47 >>> 24] ^ p[(i45 >>> 16) & 255]) ^ q[(i51 >>> 8) & 255]) ^ r[i49 & 255]) ^ this.e[i52];
        int i56 = i54 + 1;
        int i57 = (((o[i49 >>> 24] ^ p[(i47 >>> 16) & 255]) ^ q[(i45 >>> 8) & 255]) ^ r[i51 & 255]) ^ this.e[i54];
        int i58 = i56 + 1;
        int i59 = (((o[i51 >>> 24] ^ p[(i49 >>> 16) & 255]) ^ q[(i47 >>> 8) & 255]) ^ r[i45 & 255]) ^ this.e[i56];
        int i60 = i58 + 1;
        int i61 = (((o[i53 >>> 24] ^ p[(i59 >>> 16) & 255]) ^ q[(i57 >>> 8) & 255]) ^ r[i55 & 255]) ^ this.e[i58];
        int i62 = i60 + 1;
        int i63 = (((o[i55 >>> 24] ^ p[(i53 >>> 16) & 255]) ^ q[(i59 >>> 8) & 255]) ^ r[i57 & 255]) ^ this.e[i60];
        int i64 = i62 + 1;
        int i65 = (((o[i57 >>> 24] ^ p[(i55 >>> 16) & 255]) ^ q[(i53 >>> 8) & 255]) ^ r[i59 & 255]) ^ this.e[i62];
        int i66 = i64 + 1;
        int i67 = (((o[i59 >>> 24] ^ p[(i57 >>> 16) & 255]) ^ q[(i55 >>> 8) & 255]) ^ r[i53 & 255]) ^ this.e[i64];
        int i68 = i66 + 1;
        int i69 = (((o[i61 >>> 24] ^ p[(i67 >>> 16) & 255]) ^ q[(i65 >>> 8) & 255]) ^ r[i63 & 255]) ^ this.e[i66];
        int i70 = i68 + 1;
        int i71 = (((o[i63 >>> 24] ^ p[(i61 >>> 16) & 255]) ^ q[(i67 >>> 8) & 255]) ^ r[i65 & 255]) ^ this.e[i68];
        int i72 = i70 + 1;
        int i73 = (((o[i65 >>> 24] ^ p[(i63 >>> 16) & 255]) ^ q[(i61 >>> 8) & 255]) ^ r[i67 & 255]) ^ this.e[i70];
        int i74 = i72 + 1;
        int i75 = (((o[i67 >>> 24] ^ p[(i65 >>> 16) & 255]) ^ q[(i63 >>> 8) & 255]) ^ r[i61 & 255]) ^ this.e[i72];
        int i76 = i74 + 1;
        int i77 = (((o[i69 >>> 24] ^ p[(i75 >>> 16) & 255]) ^ q[(i73 >>> 8) & 255]) ^ r[i71 & 255]) ^ this.e[i74];
        int i78 = i76 + 1;
        int i79 = (((o[i71 >>> 24] ^ p[(i69 >>> 16) & 255]) ^ q[(i75 >>> 8) & 255]) ^ r[i73 & 255]) ^ this.e[i76];
        int i80 = i78 + 1;
        int i81 = (((o[i73 >>> 24] ^ p[(i71 >>> 16) & 255]) ^ q[(i69 >>> 8) & 255]) ^ r[i75 & 255]) ^ this.e[i78];
        int i82 = i80 + 1;
        int i83 = (((o[i75 >>> 24] ^ p[(i73 >>> 16) & 255]) ^ q[(i71 >>> 8) & 255]) ^ r[i69 & 255]) ^ this.e[i80];
        int i84 = i82 + 1;
        int i85 = (((o[i77 >>> 24] ^ p[(i83 >>> 16) & 255]) ^ q[(i81 >>> 8) & 255]) ^ r[i79 & 255]) ^ this.e[i82];
        int i86 = i84 + 1;
        int i87 = (((o[i79 >>> 24] ^ p[(i77 >>> 16) & 255]) ^ q[(i83 >>> 8) & 255]) ^ r[i81 & 255]) ^ this.e[i84];
        int i88 = i86 + 1;
        int i89 = (((o[i81 >>> 24] ^ p[(i79 >>> 16) & 255]) ^ q[(i77 >>> 8) & 255]) ^ r[i83 & 255]) ^ this.e[i86];
        int i90 = i88 + 1;
        int i91 = (((o[i83 >>> 24] ^ p[(i81 >>> 16) & 255]) ^ q[(i79 >>> 8) & 255]) ^ r[i77 & 255]) ^ this.e[i88];
        int i92 = i90 + 1;
        int i93 = (((o[i85 >>> 24] ^ p[(i91 >>> 16) & 255]) ^ q[(i89 >>> 8) & 255]) ^ r[i87 & 255]) ^ this.e[i90];
        int i94 = i92 + 1;
        int i95 = (((o[i87 >>> 24] ^ p[(i85 >>> 16) & 255]) ^ q[(i91 >>> 8) & 255]) ^ r[i89 & 255]) ^ this.e[i92];
        int i96 = i94 + 1;
        int i97 = (((o[i89 >>> 24] ^ p[(i87 >>> 16) & 255]) ^ q[(i85 >>> 8) & 255]) ^ r[i91 & 255]) ^ this.e[i94];
        int i98 = i96 + 1;
        int i99 = (((o[i91 >>> 24] ^ p[(i89 >>> 16) & 255]) ^ q[(i87 >>> 8) & 255]) ^ r[i85 & 255]) ^ this.e[i96];
        int i100 = i98 + 1;
        int i101 = (((o[i93 >>> 24] ^ p[(i99 >>> 16) & 255]) ^ q[(i97 >>> 8) & 255]) ^ r[i95 & 255]) ^ this.e[i98];
        int i102 = i100 + 1;
        int i103 = (((o[i95 >>> 24] ^ p[(i93 >>> 16) & 255]) ^ q[(i99 >>> 8) & 255]) ^ r[i97 & 255]) ^ this.e[i100];
        int i104 = i102 + 1;
        int i105 = (((o[i97 >>> 24] ^ p[(i95 >>> 16) & 255]) ^ q[(i93 >>> 8) & 255]) ^ r[i99 & 255]) ^ this.e[i102];
        int i106 = i104 + 1;
        int i107 = (((o[i99 >>> 24] ^ p[(i97 >>> 16) & 255]) ^ q[(i95 >>> 8) & 255]) ^ r[i93 & 255]) ^ this.e[i104];
        int i108 = this.e[0];
        int i109 = i3 + 1;
        bArr2[i3] = (byte) (j[i101 >>> 24] ^ (i108 >>> 24));
        int i110 = i109 + 1;
        bArr2[i109] = (byte) (j[(i107 >>> 16) & 255] ^ (i108 >>> 16));
        int i111 = i110 + 1;
        bArr2[i110] = (byte) (j[(i105 >>> 8) & 255] ^ (i108 >>> 8));
        int i112 = i111 + 1;
        bArr2[i111] = (byte) (i108 ^ j[i103 & 255]);
        int i113 = this.e[1];
        int i114 = i112 + 1;
        bArr2[i112] = (byte) (j[i103 >>> 24] ^ (i113 >>> 24));
        int i115 = i114 + 1;
        bArr2[i114] = (byte) (j[(i101 >>> 16) & 255] ^ (i113 >>> 16));
        int i116 = i115 + 1;
        bArr2[i115] = (byte) (j[(i107 >>> 8) & 255] ^ (i113 >>> 8));
        int i117 = i116 + 1;
        bArr2[i116] = (byte) (i113 ^ j[i105 & 255]);
        int i118 = this.e[2];
        int i119 = i117 + 1;
        bArr2[i117] = (byte) (j[i105 >>> 24] ^ (i118 >>> 24));
        int i120 = i119 + 1;
        bArr2[i119] = (byte) (j[(i103 >>> 16) & 255] ^ (i118 >>> 16));
        int i121 = i120 + 1;
        bArr2[i120] = (byte) (j[(i101 >>> 8) & 255] ^ (i118 >>> 8));
        int i122 = i121 + 1;
        bArr2[i121] = (byte) (i118 ^ j[i107 & 255]);
        int i123 = this.e[3];
        int i124 = i122 + 1;
        bArr2[i122] = (byte) (j[i107 >>> 24] ^ (i123 >>> 24));
        int i125 = i124 + 1;
        bArr2[i124] = (byte) (j[(i105 >>> 16) & 255] ^ (i123 >>> 16));
        bArr2[i125] = (byte) (j[(i103 >>> 8) & 255] ^ (i123 >>> 8));
        bArr2[i125 + 1] = (byte) (j[i101 & 255] ^ i123);
    }
}
