package com.baidu.cesium.c.a;

import java.lang.reflect.Array;
import java.security.InvalidKeyException;
/* loaded from: classes6.dex */
public final class b implements a {
    private static int[] h;
    private static int[] i;
    private boolean c = false;
    private boolean d = false;
    private Object[] e = null;
    private int[] f = null;
    private int g = 0;
    private static final byte[] j = new byte[256];
    private static final byte[] k = new byte[256];
    private static final int[] l = new int[256];
    private static final int[] aov = new int[256];
    private static final int[] n = new int[256];
    private static final int[] o = new int[256];
    private static final int[] p = new int[256];
    private static final int[] q = new int[256];
    private static final int[] aow = new int[256];
    private static final int[] aox = new int[256];
    private static final int[] aoy = new int[256];
    private static final int[] aoz = new int[256];
    private static final int[] aoA = new int[256];
    private static final int[] aoB = new int[256];
    private static final byte[] aoC = new byte[30];

    static {
        int i2 = 1;
        h = new int[256];
        i = new int[256];
        h[0] = 1;
        for (int i3 = 1; i3 < 256; i3++) {
            int i4 = (h[i3 - 1] << 1) ^ h[i3 - 1];
            if ((i4 & 256) != 0) {
                i4 ^= 283;
            }
            h[i3] = i4;
        }
        for (int i5 = 1; i5 < 255; i5++) {
            i[h[i5]] = i5;
        }
        byte[][] bArr = {new byte[]{1, 1, 1, 1, 1, 0, 0, 0}, new byte[]{0, 1, 1, 1, 1, 1, 0, 0}, new byte[]{0, 0, 1, 1, 1, 1, 1, 0}, new byte[]{0, 0, 0, 1, 1, 1, 1, 1}, new byte[]{1, 0, 0, 0, 1, 1, 1, 1}, new byte[]{1, 1, 0, 0, 0, 1, 1, 1}, new byte[]{1, 1, 1, 0, 0, 0, 1, 1}, new byte[]{1, 1, 1, 1, 0, 0, 0, 1}};
        byte[] bArr2 = {0, 1, 1, 0, 0, 0, 1, 1};
        byte[][] bArr3 = (byte[][]) Array.newInstance(Byte.TYPE, 256, 8);
        bArr3[1][7] = 1;
        for (int i6 = 2; i6 < 256; i6++) {
            int i7 = h[255 - i[i6]];
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
            j[i12] = (byte) (bArr4[i12][0] << 7);
            for (int i13 = 1; i13 < 8; i13++) {
                byte[] bArr6 = j;
                bArr6[i12] = (byte) (bArr6[i12] ^ (bArr4[i12][i13] << (7 - i13)));
            }
            k[j[i12] & 255] = (byte) i12;
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
            byte b = bArr8[i16][i16];
            if (b == 0) {
                int i17 = i16 + 1;
                while (bArr8[i17][i16] == 0 && i17 < 4) {
                    i17++;
                }
                if (i17 == 4) {
                    throw new RuntimeException("G matrix is not invertible");
                }
                for (int i18 = 0; i18 < 8; i18++) {
                    byte b2 = bArr8[i16][i18];
                    bArr8[i16][i18] = bArr8[i17][i18];
                    bArr8[i17][i18] = b2;
                }
                b = bArr8[i16][i16];
            }
            for (int i19 = 0; i19 < 8; i19++) {
                if (bArr8[i16][i19] != 0) {
                    bArr8[i16][i19] = (byte) h[((i[bArr8[i16][i19] & 255] + 255) - i[b & 255]) % 255];
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
            byte b3 = j[i24];
            l[i24] = e(b3, bArr7[0]);
            aov[i24] = e(b3, bArr7[1]);
            n[i24] = e(b3, bArr7[2]);
            o[i24] = e(b3, bArr7[3]);
            byte b4 = k[i24];
            p[i24] = e(b4, bArr9[0]);
            q[i24] = e(b4, bArr9[1]);
            aow[i24] = e(b4, bArr9[2]);
            aox[i24] = e(b4, bArr9[3]);
            aoy[i24] = e(i24, bArr9[0]);
            aoz[i24] = e(i24, bArr9[1]);
            aoA[i24] = e(i24, bArr9[2]);
            aoB[i24] = e(i24, bArr9[3]);
        }
        aoC[0] = 1;
        int i25 = 1;
        while (true) {
            int i26 = i2;
            if (i26 >= 30) {
                i = null;
                h = null;
                return;
            }
            i25 = a(2, i25);
            aoC[i26] = (byte) i25;
            i2 = i26 + 1;
        }
    }

    private static final int a(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        return h[(i[i2 & 255] + i[i3 & 255]) % 255];
    }

    private void a(boolean z) {
        int[][] iArr = (int[][]) this.e[z ? (char) 1 : (char) 0];
        int length = iArr.length;
        this.f = new int[length * 4];
        for (int i2 = 0; i2 < length; i2++) {
            for (int i3 = 0; i3 < 4; i3++) {
                this.f[(i2 * 4) + i3] = iArr[i2][i3];
            }
        }
        if (z) {
            int i4 = this.f[this.f.length - 4];
            int i5 = this.f[this.f.length - 3];
            int i6 = this.f[this.f.length - 2];
            int i7 = this.f[this.f.length - 1];
            for (int length2 = this.f.length - 1; length2 > 3; length2--) {
                this.f[length2] = this.f[length2 - 4];
            }
            this.f[0] = i4;
            this.f[1] = i5;
            this.f[2] = i6;
            this.f[3] = i7;
        }
        this.c = length >= 13;
        this.d = length == 15;
        this.g = (length - 1) * 4;
    }

    static final boolean a(int i2) {
        for (int i3 = 0; i3 < b.length; i3++) {
            if (i2 == b[i3]) {
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
        int i3 = i[i2 & 255];
        return (bArr[3] != 0 ? h[(i3 + i[bArr[3] & 255]) % 255] & 255 : 0) | ((bArr[0] != 0 ? h[(i[bArr[0] & 255] + i3) % 255] & 255 : 0) << 24) | ((bArr[1] != 0 ? h[(i[bArr[1] & 255] + i3) % 255] & 255 : 0) << 16) | ((bArr[2] != 0 ? h[(i[bArr[2] & 255] + i3) % 255] & 255 : 0) << 8);
    }

    private static Object[] r(byte[] bArr) {
        if (bArr == null) {
            throw new InvalidKeyException("Empty key");
        }
        if (a(bArr.length)) {
            int b = b(bArr.length);
            int i2 = (b + 1) * 4;
            int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, b + 1, 4);
            int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, b + 1, 4);
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
                iArr2[b - (i5 / 4)][i5 % 4] = iArr3[i6];
                i6++;
                i5++;
            }
            int i7 = 0;
            while (i5 < i2) {
                int i8 = iArr3[length - 1];
                int i9 = i7 + 1;
                iArr3[0] = (((j[i8 >>> 24] & 255) ^ (((j[(i8 >>> 16) & 255] << 24) ^ ((j[(i8 >>> 8) & 255] & 255) << 16)) ^ ((j[i8 & 255] & 255) << 8))) ^ (aoC[i7] << 24)) ^ iArr3[0];
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
                    iArr3[i15] = ((j[i14 >>> 24] << 24) ^ (((j[i14 & 255] & 255) ^ ((j[(i14 >>> 8) & 255] & 255) << 8)) ^ ((j[(i14 >>> 16) & 255] & 255) << 16))) ^ iArr3[i15];
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
                    iArr2[b - (i19 / 4)][i19 % 4] = iArr3[i18];
                    i18++;
                    i19++;
                }
                i7 = i9;
                i5 = i19;
            }
            for (int i20 = 1; i20 < b; i20++) {
                for (int i21 = 0; i21 < 4; i21++) {
                    int i22 = iArr2[i20][i21];
                    iArr2[i20][i21] = aoB[i22 & 255] ^ ((aoy[(i22 >>> 24) & 255] ^ aoz[(i22 >>> 16) & 255]) ^ aoA[(i22 >>> 8) & 255]);
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
        this.e = r(bArr);
        a(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(byte[] bArr, int i2, byte[] bArr2, int i3) {
        int i4 = i2 + 1;
        int i5 = i4 + 1;
        int i6 = i5 + 1;
        int i7 = ((bArr[i4] & 255) << 16) | (bArr[i2] << 24) | ((bArr[i5] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = (i7 | (bArr[i6] & 255)) ^ this.f[0];
        int i10 = i8 + 1;
        int i11 = i10 + 1;
        int i12 = ((bArr[i10] & 255) << 16) | (bArr[i8] << 24);
        int i13 = i11 + 1;
        int i14 = i13 + 1;
        int i15 = ((i12 | ((bArr[i11] & 255) << 8)) | (bArr[i13] & 255)) ^ this.f[1];
        int i16 = i14 + 1;
        int i17 = i16 + 1;
        int i18 = i17 + 1;
        int i19 = ((bArr[i16] & 255) << 16) | (bArr[i14] << 24) | ((bArr[i17] & 255) << 8);
        int i20 = i18 + 1;
        int i21 = this.f[2] ^ (i19 | (bArr[i18] & 255));
        int i22 = i20 + 1;
        int i23 = i22 + 1;
        int i24 = ((bArr[i22] & 255) << 16) | (bArr[i20] << 24);
        int i25 = i23 + 1;
        int i26 = i24 | ((bArr[i23] & 255) << 8);
        int i27 = i25 + 1;
        int i28 = (i26 | (bArr[i25] & 255)) ^ this.f[3];
        int i29 = i15;
        int i30 = i9;
        int i31 = 4;
        while (i31 < this.g) {
            int i32 = i31 + 1;
            int i33 = (((l[i30 >>> 24] ^ aov[(i29 >>> 16) & 255]) ^ n[(i21 >>> 8) & 255]) ^ o[i28 & 255]) ^ this.f[i31];
            int i34 = i32 + 1;
            int i35 = this.f[i32] ^ (((l[i29 >>> 24] ^ aov[(i21 >>> 16) & 255]) ^ n[(i28 >>> 8) & 255]) ^ o[i30 & 255]);
            int i36 = i34 + 1;
            int i37 = (((l[i21 >>> 24] ^ aov[(i28 >>> 16) & 255]) ^ n[(i30 >>> 8) & 255]) ^ o[i29 & 255]) ^ this.f[i34];
            i31 = i36 + 1;
            i28 = (((l[i28 >>> 24] ^ aov[(i30 >>> 16) & 255]) ^ n[(i29 >>> 8) & 255]) ^ o[i21 & 255]) ^ this.f[i36];
            i21 = i37;
            i29 = i35;
            i30 = i33;
        }
        int i38 = i31 + 1;
        int i39 = this.f[i31];
        int i40 = i3 + 1;
        bArr2[i3] = (byte) (j[i30 >>> 24] ^ (i39 >>> 24));
        int i41 = i40 + 1;
        bArr2[i40] = (byte) (j[(i29 >>> 16) & 255] ^ (i39 >>> 16));
        int i42 = i41 + 1;
        bArr2[i41] = (byte) (j[(i21 >>> 8) & 255] ^ (i39 >>> 8));
        int i43 = i42 + 1;
        bArr2[i42] = (byte) (i39 ^ j[i28 & 255]);
        int i44 = i38 + 1;
        int i45 = this.f[i38];
        int i46 = i43 + 1;
        bArr2[i43] = (byte) (j[i29 >>> 24] ^ (i45 >>> 24));
        int i47 = i46 + 1;
        bArr2[i46] = (byte) (j[(i21 >>> 16) & 255] ^ (i45 >>> 16));
        int i48 = i47 + 1;
        bArr2[i47] = (byte) (j[(i28 >>> 8) & 255] ^ (i45 >>> 8));
        int i49 = i48 + 1;
        bArr2[i48] = (byte) (i45 ^ j[i30 & 255]);
        int i50 = i44 + 1;
        int i51 = this.f[i44];
        int i52 = i49 + 1;
        bArr2[i49] = (byte) (j[i21 >>> 24] ^ (i51 >>> 24));
        int i53 = i52 + 1;
        bArr2[i52] = (byte) (j[(i28 >>> 16) & 255] ^ (i51 >>> 16));
        int i54 = i53 + 1;
        bArr2[i53] = (byte) (j[(i30 >>> 8) & 255] ^ (i51 >>> 8));
        int i55 = i54 + 1;
        bArr2[i54] = (byte) (i51 ^ j[i29 & 255]);
        int i56 = i50 + 1;
        int i57 = this.f[i50];
        int i58 = i55 + 1;
        bArr2[i55] = (byte) (j[i28 >>> 24] ^ (i57 >>> 24));
        int i59 = i58 + 1;
        bArr2[i58] = (byte) (j[(i30 >>> 16) & 255] ^ (i57 >>> 16));
        bArr2[i59] = (byte) (j[(i29 >>> 8) & 255] ^ (i57 >>> 8));
        bArr2[i59 + 1] = (byte) (j[i21 & 255] ^ i57);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(byte[] bArr, int i2, byte[] bArr2, int i3) {
        int i4 = i2 + 1;
        int i5 = i4 + 1;
        int i6 = i5 + 1;
        int i7 = i6 + 1;
        int i8 = (((((bArr[i4] & 255) << 16) | (bArr[i2] << 24)) | ((bArr[i5] & 255) << 8)) | (bArr[i6] & 255)) ^ this.f[4];
        int i9 = i7 + 1;
        int i10 = i9 + 1;
        int i11 = ((bArr[i9] & 255) << 16) | (bArr[i7] << 24);
        int i12 = i10 + 1;
        int i13 = i12 + 1;
        int i14 = ((i11 | ((bArr[i10] & 255) << 8)) | (bArr[i12] & 255)) ^ this.f[5];
        int i15 = i13 + 1;
        int i16 = i15 + 1;
        int i17 = i16 + 1;
        int i18 = ((bArr[i15] & 255) << 16) | (bArr[i13] << 24) | ((bArr[i16] & 255) << 8);
        int i19 = i17 + 1;
        int i20 = this.f[6] ^ (i18 | (bArr[i17] & 255));
        int i21 = i19 + 1;
        int i22 = i21 + 1;
        int i23 = ((bArr[i21] & 255) << 16) | (bArr[i19] << 24) | ((bArr[i22] & 255) << 8) | (bArr[i22 + 1] & 255);
        int i24 = 8;
        int i25 = i23 ^ this.f[7];
        if (this.c) {
            int i26 = this.f[8] ^ (((p[i8 >>> 24] ^ q[(i25 >>> 16) & 255]) ^ aow[(i20 >>> 8) & 255]) ^ aox[i14 & 255]);
            int i27 = (((p[i14 >>> 24] ^ q[(i8 >>> 16) & 255]) ^ aow[(i25 >>> 8) & 255]) ^ aox[i20 & 255]) ^ this.f[9];
            int i28 = (((p[i20 >>> 24] ^ q[(i14 >>> 16) & 255]) ^ aow[(i8 >>> 8) & 255]) ^ aox[i25 & 255]) ^ this.f[10];
            int i29 = (((p[i25 >>> 24] ^ q[(i20 >>> 16) & 255]) ^ aow[(i14 >>> 8) & 255]) ^ aox[i8 & 255]) ^ this.f[11];
            i8 = (((p[i26 >>> 24] ^ q[(i29 >>> 16) & 255]) ^ aow[(i28 >>> 8) & 255]) ^ aox[i27 & 255]) ^ this.f[12];
            i14 = this.f[13] ^ (((p[i27 >>> 24] ^ q[(i26 >>> 16) & 255]) ^ aow[(i29 >>> 8) & 255]) ^ aox[i28 & 255]);
            i20 = (((p[i28 >>> 24] ^ q[(i27 >>> 16) & 255]) ^ aow[(i26 >>> 8) & 255]) ^ aox[i29 & 255]) ^ this.f[14];
            int i30 = ((p[i29 >>> 24] ^ q[(i28 >>> 16) & 255]) ^ aow[(i27 >>> 8) & 255]) ^ aox[i26 & 255];
            i24 = 16;
            i25 = i30 ^ this.f[15];
            if (this.d) {
                int i31 = this.f[16] ^ (((p[i8 >>> 24] ^ q[(i25 >>> 16) & 255]) ^ aow[(i20 >>> 8) & 255]) ^ aox[i14 & 255]);
                int i32 = (((p[i14 >>> 24] ^ q[(i8 >>> 16) & 255]) ^ aow[(i25 >>> 8) & 255]) ^ aox[i20 & 255]) ^ this.f[17];
                int i33 = (((p[i20 >>> 24] ^ q[(i14 >>> 16) & 255]) ^ aow[(i8 >>> 8) & 255]) ^ aox[i25 & 255]) ^ this.f[18];
                int i34 = (((p[i25 >>> 24] ^ q[(i20 >>> 16) & 255]) ^ aow[(i14 >>> 8) & 255]) ^ aox[i8 & 255]) ^ this.f[19];
                i8 = (((p[i31 >>> 24] ^ q[(i34 >>> 16) & 255]) ^ aow[(i33 >>> 8) & 255]) ^ aox[i32 & 255]) ^ this.f[20];
                i14 = this.f[21] ^ (((p[i32 >>> 24] ^ q[(i31 >>> 16) & 255]) ^ aow[(i34 >>> 8) & 255]) ^ aox[i33 & 255]);
                i20 = (((p[i33 >>> 24] ^ q[(i32 >>> 16) & 255]) ^ aow[(i31 >>> 8) & 255]) ^ aox[i34 & 255]) ^ this.f[22];
                int i35 = ((p[i34 >>> 24] ^ q[(i33 >>> 16) & 255]) ^ aow[(i32 >>> 8) & 255]) ^ aox[i31 & 255];
                i24 = 24;
                i25 = i35 ^ this.f[23];
            }
        }
        int i36 = i24 + 1;
        int i37 = this.f[i24] ^ (((p[i8 >>> 24] ^ q[(i25 >>> 16) & 255]) ^ aow[(i20 >>> 8) & 255]) ^ aox[i14 & 255]);
        int i38 = i36 + 1;
        int i39 = (((p[i14 >>> 24] ^ q[(i8 >>> 16) & 255]) ^ aow[(i25 >>> 8) & 255]) ^ aox[i20 & 255]) ^ this.f[i36];
        int i40 = i38 + 1;
        int i41 = (((p[i20 >>> 24] ^ q[(i14 >>> 16) & 255]) ^ aow[(i8 >>> 8) & 255]) ^ aox[i25 & 255]) ^ this.f[i38];
        int i42 = i40 + 1;
        int i43 = (((p[i25 >>> 24] ^ q[(i20 >>> 16) & 255]) ^ aow[(i14 >>> 8) & 255]) ^ aox[i8 & 255]) ^ this.f[i40];
        int i44 = i42 + 1;
        int i45 = (((p[i37 >>> 24] ^ q[(i43 >>> 16) & 255]) ^ aow[(i41 >>> 8) & 255]) ^ aox[i39 & 255]) ^ this.f[i42];
        int i46 = i44 + 1;
        int i47 = (((p[i39 >>> 24] ^ q[(i37 >>> 16) & 255]) ^ aow[(i43 >>> 8) & 255]) ^ aox[i41 & 255]) ^ this.f[i44];
        int i48 = i46 + 1;
        int i49 = (((p[i41 >>> 24] ^ q[(i39 >>> 16) & 255]) ^ aow[(i37 >>> 8) & 255]) ^ aox[i43 & 255]) ^ this.f[i46];
        int i50 = i48 + 1;
        int i51 = (((p[i43 >>> 24] ^ q[(i41 >>> 16) & 255]) ^ aow[(i39 >>> 8) & 255]) ^ aox[i37 & 255]) ^ this.f[i48];
        int i52 = i50 + 1;
        int i53 = (((p[i45 >>> 24] ^ q[(i51 >>> 16) & 255]) ^ aow[(i49 >>> 8) & 255]) ^ aox[i47 & 255]) ^ this.f[i50];
        int i54 = i52 + 1;
        int i55 = (((p[i47 >>> 24] ^ q[(i45 >>> 16) & 255]) ^ aow[(i51 >>> 8) & 255]) ^ aox[i49 & 255]) ^ this.f[i52];
        int i56 = i54 + 1;
        int i57 = (((p[i49 >>> 24] ^ q[(i47 >>> 16) & 255]) ^ aow[(i45 >>> 8) & 255]) ^ aox[i51 & 255]) ^ this.f[i54];
        int i58 = i56 + 1;
        int i59 = (((p[i51 >>> 24] ^ q[(i49 >>> 16) & 255]) ^ aow[(i47 >>> 8) & 255]) ^ aox[i45 & 255]) ^ this.f[i56];
        int i60 = i58 + 1;
        int i61 = (((p[i53 >>> 24] ^ q[(i59 >>> 16) & 255]) ^ aow[(i57 >>> 8) & 255]) ^ aox[i55 & 255]) ^ this.f[i58];
        int i62 = i60 + 1;
        int i63 = (((p[i55 >>> 24] ^ q[(i53 >>> 16) & 255]) ^ aow[(i59 >>> 8) & 255]) ^ aox[i57 & 255]) ^ this.f[i60];
        int i64 = i62 + 1;
        int i65 = (((p[i57 >>> 24] ^ q[(i55 >>> 16) & 255]) ^ aow[(i53 >>> 8) & 255]) ^ aox[i59 & 255]) ^ this.f[i62];
        int i66 = i64 + 1;
        int i67 = (((p[i59 >>> 24] ^ q[(i57 >>> 16) & 255]) ^ aow[(i55 >>> 8) & 255]) ^ aox[i53 & 255]) ^ this.f[i64];
        int i68 = i66 + 1;
        int i69 = (((p[i61 >>> 24] ^ q[(i67 >>> 16) & 255]) ^ aow[(i65 >>> 8) & 255]) ^ aox[i63 & 255]) ^ this.f[i66];
        int i70 = i68 + 1;
        int i71 = (((p[i63 >>> 24] ^ q[(i61 >>> 16) & 255]) ^ aow[(i67 >>> 8) & 255]) ^ aox[i65 & 255]) ^ this.f[i68];
        int i72 = i70 + 1;
        int i73 = (((p[i65 >>> 24] ^ q[(i63 >>> 16) & 255]) ^ aow[(i61 >>> 8) & 255]) ^ aox[i67 & 255]) ^ this.f[i70];
        int i74 = i72 + 1;
        int i75 = (((p[i67 >>> 24] ^ q[(i65 >>> 16) & 255]) ^ aow[(i63 >>> 8) & 255]) ^ aox[i61 & 255]) ^ this.f[i72];
        int i76 = i74 + 1;
        int i77 = (((p[i69 >>> 24] ^ q[(i75 >>> 16) & 255]) ^ aow[(i73 >>> 8) & 255]) ^ aox[i71 & 255]) ^ this.f[i74];
        int i78 = i76 + 1;
        int i79 = (((p[i71 >>> 24] ^ q[(i69 >>> 16) & 255]) ^ aow[(i75 >>> 8) & 255]) ^ aox[i73 & 255]) ^ this.f[i76];
        int i80 = i78 + 1;
        int i81 = (((p[i73 >>> 24] ^ q[(i71 >>> 16) & 255]) ^ aow[(i69 >>> 8) & 255]) ^ aox[i75 & 255]) ^ this.f[i78];
        int i82 = i80 + 1;
        int i83 = (((p[i75 >>> 24] ^ q[(i73 >>> 16) & 255]) ^ aow[(i71 >>> 8) & 255]) ^ aox[i69 & 255]) ^ this.f[i80];
        int i84 = i82 + 1;
        int i85 = (((p[i77 >>> 24] ^ q[(i83 >>> 16) & 255]) ^ aow[(i81 >>> 8) & 255]) ^ aox[i79 & 255]) ^ this.f[i82];
        int i86 = i84 + 1;
        int i87 = (((p[i79 >>> 24] ^ q[(i77 >>> 16) & 255]) ^ aow[(i83 >>> 8) & 255]) ^ aox[i81 & 255]) ^ this.f[i84];
        int i88 = i86 + 1;
        int i89 = (((p[i81 >>> 24] ^ q[(i79 >>> 16) & 255]) ^ aow[(i77 >>> 8) & 255]) ^ aox[i83 & 255]) ^ this.f[i86];
        int i90 = i88 + 1;
        int i91 = (((p[i83 >>> 24] ^ q[(i81 >>> 16) & 255]) ^ aow[(i79 >>> 8) & 255]) ^ aox[i77 & 255]) ^ this.f[i88];
        int i92 = i90 + 1;
        int i93 = (((p[i85 >>> 24] ^ q[(i91 >>> 16) & 255]) ^ aow[(i89 >>> 8) & 255]) ^ aox[i87 & 255]) ^ this.f[i90];
        int i94 = i92 + 1;
        int i95 = (((p[i87 >>> 24] ^ q[(i85 >>> 16) & 255]) ^ aow[(i91 >>> 8) & 255]) ^ aox[i89 & 255]) ^ this.f[i92];
        int i96 = i94 + 1;
        int i97 = (((p[i89 >>> 24] ^ q[(i87 >>> 16) & 255]) ^ aow[(i85 >>> 8) & 255]) ^ aox[i91 & 255]) ^ this.f[i94];
        int i98 = i96 + 1;
        int i99 = (((p[i91 >>> 24] ^ q[(i89 >>> 16) & 255]) ^ aow[(i87 >>> 8) & 255]) ^ aox[i85 & 255]) ^ this.f[i96];
        int i100 = i98 + 1;
        int i101 = (((p[i93 >>> 24] ^ q[(i99 >>> 16) & 255]) ^ aow[(i97 >>> 8) & 255]) ^ aox[i95 & 255]) ^ this.f[i98];
        int i102 = i100 + 1;
        int i103 = (((p[i95 >>> 24] ^ q[(i93 >>> 16) & 255]) ^ aow[(i99 >>> 8) & 255]) ^ aox[i97 & 255]) ^ this.f[i100];
        int i104 = i102 + 1;
        int i105 = (((p[i97 >>> 24] ^ q[(i95 >>> 16) & 255]) ^ aow[(i93 >>> 8) & 255]) ^ aox[i99 & 255]) ^ this.f[i102];
        int i106 = i104 + 1;
        int i107 = (((p[i99 >>> 24] ^ q[(i97 >>> 16) & 255]) ^ aow[(i95 >>> 8) & 255]) ^ aox[i93 & 255]) ^ this.f[i104];
        int i108 = this.f[0];
        int i109 = i3 + 1;
        bArr2[i3] = (byte) (k[i101 >>> 24] ^ (i108 >>> 24));
        int i110 = i109 + 1;
        bArr2[i109] = (byte) (k[(i107 >>> 16) & 255] ^ (i108 >>> 16));
        int i111 = i110 + 1;
        bArr2[i110] = (byte) (k[(i105 >>> 8) & 255] ^ (i108 >>> 8));
        int i112 = i111 + 1;
        bArr2[i111] = (byte) (i108 ^ k[i103 & 255]);
        int i113 = this.f[1];
        int i114 = i112 + 1;
        bArr2[i112] = (byte) (k[i103 >>> 24] ^ (i113 >>> 24));
        int i115 = i114 + 1;
        bArr2[i114] = (byte) (k[(i101 >>> 16) & 255] ^ (i113 >>> 16));
        int i116 = i115 + 1;
        bArr2[i115] = (byte) (k[(i107 >>> 8) & 255] ^ (i113 >>> 8));
        int i117 = i116 + 1;
        bArr2[i116] = (byte) (i113 ^ k[i105 & 255]);
        int i118 = this.f[2];
        int i119 = i117 + 1;
        bArr2[i117] = (byte) (k[i105 >>> 24] ^ (i118 >>> 24));
        int i120 = i119 + 1;
        bArr2[i119] = (byte) (k[(i103 >>> 16) & 255] ^ (i118 >>> 16));
        int i121 = i120 + 1;
        bArr2[i120] = (byte) (k[(i101 >>> 8) & 255] ^ (i118 >>> 8));
        int i122 = i121 + 1;
        bArr2[i121] = (byte) (i118 ^ k[i107 & 255]);
        int i123 = this.f[3];
        int i124 = i122 + 1;
        bArr2[i122] = (byte) (k[i107 >>> 24] ^ (i123 >>> 24));
        int i125 = i124 + 1;
        bArr2[i124] = (byte) (k[(i105 >>> 16) & 255] ^ (i123 >>> 16));
        bArr2[i125] = (byte) (k[(i103 >>> 8) & 255] ^ (i123 >>> 8));
        bArr2[i125 + 1] = (byte) (k[i101 & 255] ^ i123);
    }
}
