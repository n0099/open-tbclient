package com.baidu.b.c.a;

import java.lang.reflect.Array;
import java.security.InvalidKeyException;
/* loaded from: classes20.dex */
public final class b implements a {
    private static int[] g;
    private static int[] h;
    private boolean b = false;
    private boolean c = false;
    private Object[] d = null;
    private int[] e = null;
    private int f = 0;
    private static final byte[] i = new byte[256];
    private static final byte[] j = new byte[256];
    private static final int[] acB = new int[256];
    private static final int[] l = new int[256];
    private static final int[] acC = new int[256];
    private static final int[] acD = new int[256];
    private static final int[] acE = new int[256];
    private static final int[] p = new int[256];
    private static final int[] q = new int[256];
    private static final int[] acF = new int[256];
    private static final int[] acG = new int[256];
    private static final int[] acH = new int[256];
    private static final int[] acI = new int[256];
    private static final int[] acJ = new int[256];
    private static final byte[] w = new byte[30];

    static {
        g = new int[256];
        h = new int[256];
        g[0] = 1;
        for (int i2 = 1; i2 < 256; i2++) {
            int i3 = (g[i2 - 1] << 1) ^ g[i2 - 1];
            if ((i3 & 256) != 0) {
                i3 ^= 283;
            }
            g[i2] = i3;
        }
        for (int i4 = 1; i4 < 255; i4++) {
            h[g[i4]] = i4;
        }
        byte[][] bArr = {new byte[]{1, 1, 1, 1, 1, 0, 0, 0}, new byte[]{0, 1, 1, 1, 1, 1, 0, 0}, new byte[]{0, 0, 1, 1, 1, 1, 1, 0}, new byte[]{0, 0, 0, 1, 1, 1, 1, 1}, new byte[]{1, 0, 0, 0, 1, 1, 1, 1}, new byte[]{1, 1, 0, 0, 0, 1, 1, 1}, new byte[]{1, 1, 1, 0, 0, 0, 1, 1}, new byte[]{1, 1, 1, 1, 0, 0, 0, 1}};
        byte[] bArr2 = {0, 1, 1, 0, 0, 0, 1, 1};
        byte[][] bArr3 = (byte[][]) Array.newInstance(Byte.TYPE, 256, 8);
        bArr3[1][7] = 1;
        for (int i5 = 2; i5 < 256; i5++) {
            int i6 = g[255 - h[i5]];
            for (int i7 = 0; i7 < 8; i7++) {
                bArr3[i5][i7] = (byte) ((i6 >>> (7 - i7)) & 1);
            }
        }
        byte[][] bArr4 = (byte[][]) Array.newInstance(Byte.TYPE, 256, 8);
        for (int i8 = 0; i8 < 256; i8++) {
            for (int i9 = 0; i9 < 8; i9++) {
                bArr4[i8][i9] = bArr2[i9];
                for (int i10 = 0; i10 < 8; i10++) {
                    byte[] bArr5 = bArr4[i8];
                    bArr5[i9] = (byte) (bArr5[i9] ^ (bArr[i9][i10] * bArr3[i8][i10]));
                }
            }
        }
        for (int i11 = 0; i11 < 256; i11++) {
            i[i11] = (byte) (bArr4[i11][0] << 7);
            for (int i12 = 1; i12 < 8; i12++) {
                byte[] bArr6 = i;
                bArr6[i11] = (byte) (bArr6[i11] ^ (bArr4[i11][i12] << (7 - i12)));
            }
            j[i[i11] & 255] = (byte) i11;
        }
        byte[][] bArr7 = {new byte[]{2, 1, 1, 3}, new byte[]{3, 2, 1, 1}, new byte[]{1, 3, 2, 1}, new byte[]{1, 1, 3, 2}};
        byte[][] bArr8 = (byte[][]) Array.newInstance(Byte.TYPE, 4, 8);
        for (int i13 = 0; i13 < 4; i13++) {
            for (int i14 = 0; i14 < 4; i14++) {
                bArr8[i13][i14] = bArr7[i13][i14];
            }
            bArr8[i13][i13 + 4] = 1;
        }
        byte[][] bArr9 = (byte[][]) Array.newInstance(Byte.TYPE, 4, 4);
        for (int i15 = 0; i15 < 4; i15++) {
            byte b = bArr8[i15][i15];
            if (b == 0) {
                int i16 = i15 + 1;
                while (bArr8[i16][i15] == 0 && i16 < 4) {
                    i16++;
                }
                if (i16 == 4) {
                    throw new RuntimeException("G matrix is not invertible");
                }
                for (int i17 = 0; i17 < 8; i17++) {
                    byte b2 = bArr8[i15][i17];
                    bArr8[i15][i17] = bArr8[i16][i17];
                    bArr8[i16][i17] = b2;
                }
                b = bArr8[i15][i15];
            }
            for (int i18 = 0; i18 < 8; i18++) {
                if (bArr8[i15][i18] != 0) {
                    bArr8[i15][i18] = (byte) g[((h[bArr8[i15][i18] & 255] + 255) - h[b & 255]) % 255];
                }
            }
            for (int i19 = 0; i19 < 4; i19++) {
                if (i15 != i19) {
                    for (int i20 = i15 + 1; i20 < 8; i20++) {
                        byte[] bArr10 = bArr8[i19];
                        bArr10[i20] = (byte) (bArr10[i20] ^ a(bArr8[i15][i20], bArr8[i19][i15]));
                    }
                    bArr8[i19][i15] = 0;
                }
            }
        }
        for (int i21 = 0; i21 < 4; i21++) {
            for (int i22 = 0; i22 < 4; i22++) {
                bArr9[i21][i22] = bArr8[i21][i22 + 4];
            }
        }
        for (int i23 = 0; i23 < 256; i23++) {
            byte b3 = i[i23];
            acB[i23] = e(b3, bArr7[0]);
            l[i23] = e(b3, bArr7[1]);
            acC[i23] = e(b3, bArr7[2]);
            acD[i23] = e(b3, bArr7[3]);
            byte b4 = j[i23];
            acE[i23] = e(b4, bArr9[0]);
            p[i23] = e(b4, bArr9[1]);
            q[i23] = e(b4, bArr9[2]);
            acF[i23] = e(b4, bArr9[3]);
            acG[i23] = e(i23, bArr9[0]);
            acH[i23] = e(i23, bArr9[1]);
            acI[i23] = e(i23, bArr9[2]);
            acJ[i23] = e(i23, bArr9[3]);
        }
        w[0] = 1;
        int i24 = 1;
        for (int i25 = 1; i25 < 30; i25++) {
            i24 = a(2, i24);
            w[i25] = (byte) i24;
        }
        h = null;
        g = null;
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
        this.b = length >= 13;
        this.c = length == 15;
        this.f = (length - 1) * 4;
    }

    static final boolean a(int i2) {
        for (int i3 = 0; i3 < a.length; i3++) {
            if (i2 == a[i3]) {
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
                iArr3[0] = ((w[i7] << 24) ^ ((i[i8 >>> 24] & 255) ^ (((i[(i8 >>> 16) & 255] << 24) ^ ((i[(i8 >>> 8) & 255] & 255) << 16)) ^ ((i[i8 & 255] & 255) << 8)))) ^ iArr3[0];
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
                    iArr2[b - (i19 / 4)][i19 % 4] = iArr3[i18];
                    i18++;
                    i19++;
                }
                i5 = i19;
                i7 = i9;
            }
            for (int i20 = 1; i20 < b; i20++) {
                for (int i21 = 0; i21 < 4; i21++) {
                    int i22 = iArr2[i20][i21];
                    iArr2[i20][i21] = acJ[i22 & 255] ^ ((acG[(i22 >>> 24) & 255] ^ acH[(i22 >>> 16) & 255]) ^ acI[(i22 >>> 8) & 255]);
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
        int i7 = i6 + 1;
        int i8 = (((((bArr[i4] & 255) << 16) | (bArr[i2] << 24)) | ((bArr[i5] & 255) << 8)) | (bArr[i6] & 255)) ^ this.e[0];
        int i9 = i7 + 1;
        int i10 = i9 + 1;
        int i11 = ((bArr[i9] & 255) << 16) | (bArr[i7] << 24);
        int i12 = i10 + 1;
        int i13 = i12 + 1;
        int i14 = ((i11 | ((bArr[i10] & 255) << 8)) | (bArr[i12] & 255)) ^ this.e[1];
        int i15 = i13 + 1;
        int i16 = i15 + 1;
        int i17 = i16 + 1;
        int i18 = ((bArr[i15] & 255) << 16) | (bArr[i13] << 24) | ((bArr[i16] & 255) << 8);
        int i19 = i17 + 1;
        int i20 = this.e[2] ^ (i18 | (bArr[i17] & 255));
        int i21 = i19 + 1;
        int i22 = i21 + 1;
        int i23 = ((bArr[i21] & 255) << 16) | (bArr[i19] << 24);
        int i24 = i22 + 1;
        int i25 = i23 | ((bArr[i22] & 255) << 8);
        int i26 = i24 + 1;
        int i27 = (i25 | (bArr[i24] & 255)) ^ this.e[3];
        int i28 = i8;
        int i29 = i14;
        int i30 = 4;
        while (i30 < this.f) {
            int i31 = i30 + 1;
            int i32 = (((acB[i28 >>> 24] ^ l[(i29 >>> 16) & 255]) ^ acC[(i20 >>> 8) & 255]) ^ acD[i27 & 255]) ^ this.e[i30];
            int i33 = i31 + 1;
            int i34 = this.e[i31] ^ (((acB[i29 >>> 24] ^ l[(i20 >>> 16) & 255]) ^ acC[(i27 >>> 8) & 255]) ^ acD[i28 & 255]);
            int i35 = i33 + 1;
            int i36 = (((acB[i20 >>> 24] ^ l[(i27 >>> 16) & 255]) ^ acC[(i28 >>> 8) & 255]) ^ acD[i29 & 255]) ^ this.e[i33];
            i27 = (((acB[i27 >>> 24] ^ l[(i28 >>> 16) & 255]) ^ acC[(i29 >>> 8) & 255]) ^ acD[i20 & 255]) ^ this.e[i35];
            i29 = i34;
            i28 = i32;
            i30 = i35 + 1;
            i20 = i36;
        }
        int i37 = i30 + 1;
        int i38 = this.e[i30];
        int i39 = i3 + 1;
        bArr2[i3] = (byte) (i[i28 >>> 24] ^ (i38 >>> 24));
        int i40 = i39 + 1;
        bArr2[i39] = (byte) (i[(i29 >>> 16) & 255] ^ (i38 >>> 16));
        int i41 = i40 + 1;
        bArr2[i40] = (byte) (i[(i20 >>> 8) & 255] ^ (i38 >>> 8));
        int i42 = i41 + 1;
        bArr2[i41] = (byte) (i38 ^ i[i27 & 255]);
        int i43 = i37 + 1;
        int i44 = this.e[i37];
        int i45 = i42 + 1;
        bArr2[i42] = (byte) (i[i29 >>> 24] ^ (i44 >>> 24));
        int i46 = i45 + 1;
        bArr2[i45] = (byte) (i[(i20 >>> 16) & 255] ^ (i44 >>> 16));
        int i47 = i46 + 1;
        bArr2[i46] = (byte) (i[(i27 >>> 8) & 255] ^ (i44 >>> 8));
        int i48 = i47 + 1;
        bArr2[i47] = (byte) (i44 ^ i[i28 & 255]);
        int i49 = i43 + 1;
        int i50 = this.e[i43];
        int i51 = i48 + 1;
        bArr2[i48] = (byte) (i[i20 >>> 24] ^ (i50 >>> 24));
        int i52 = i51 + 1;
        bArr2[i51] = (byte) (i[(i27 >>> 16) & 255] ^ (i50 >>> 16));
        int i53 = i52 + 1;
        bArr2[i52] = (byte) (i[(i28 >>> 8) & 255] ^ (i50 >>> 8));
        int i54 = i53 + 1;
        bArr2[i53] = (byte) (i50 ^ i[i29 & 255]);
        int i55 = i49 + 1;
        int i56 = this.e[i49];
        int i57 = i54 + 1;
        bArr2[i54] = (byte) (i[i27 >>> 24] ^ (i56 >>> 24));
        int i58 = i57 + 1;
        bArr2[i57] = (byte) (i[(i28 >>> 16) & 255] ^ (i56 >>> 16));
        bArr2[i58] = (byte) (i[(i29 >>> 8) & 255] ^ (i56 >>> 8));
        bArr2[i58 + 1] = (byte) (i[i20 & 255] ^ i56);
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
        if (this.b) {
            int i26 = this.e[8] ^ (((acE[i8 >>> 24] ^ p[(i25 >>> 16) & 255]) ^ q[(i20 >>> 8) & 255]) ^ acF[i14 & 255]);
            int i27 = (((acE[i14 >>> 24] ^ p[(i8 >>> 16) & 255]) ^ q[(i25 >>> 8) & 255]) ^ acF[i20 & 255]) ^ this.e[9];
            int i28 = (((acE[i20 >>> 24] ^ p[(i14 >>> 16) & 255]) ^ q[(i8 >>> 8) & 255]) ^ acF[i25 & 255]) ^ this.e[10];
            int i29 = (((acE[i25 >>> 24] ^ p[(i20 >>> 16) & 255]) ^ q[(i14 >>> 8) & 255]) ^ acF[i8 & 255]) ^ this.e[11];
            i8 = (((acE[i26 >>> 24] ^ p[(i29 >>> 16) & 255]) ^ q[(i28 >>> 8) & 255]) ^ acF[i27 & 255]) ^ this.e[12];
            i14 = this.e[13] ^ (((acE[i27 >>> 24] ^ p[(i26 >>> 16) & 255]) ^ q[(i29 >>> 8) & 255]) ^ acF[i28 & 255]);
            i20 = (((acE[i28 >>> 24] ^ p[(i27 >>> 16) & 255]) ^ q[(i26 >>> 8) & 255]) ^ acF[i29 & 255]) ^ this.e[14];
            int i30 = ((acE[i29 >>> 24] ^ p[(i28 >>> 16) & 255]) ^ q[(i27 >>> 8) & 255]) ^ acF[i26 & 255];
            i24 = 16;
            i25 = i30 ^ this.e[15];
            if (this.c) {
                int i31 = this.e[16] ^ (((acE[i8 >>> 24] ^ p[(i25 >>> 16) & 255]) ^ q[(i20 >>> 8) & 255]) ^ acF[i14 & 255]);
                int i32 = (((acE[i14 >>> 24] ^ p[(i8 >>> 16) & 255]) ^ q[(i25 >>> 8) & 255]) ^ acF[i20 & 255]) ^ this.e[17];
                int i33 = (((acE[i20 >>> 24] ^ p[(i14 >>> 16) & 255]) ^ q[(i8 >>> 8) & 255]) ^ acF[i25 & 255]) ^ this.e[18];
                int i34 = (((acE[i25 >>> 24] ^ p[(i20 >>> 16) & 255]) ^ q[(i14 >>> 8) & 255]) ^ acF[i8 & 255]) ^ this.e[19];
                i8 = (((acE[i31 >>> 24] ^ p[(i34 >>> 16) & 255]) ^ q[(i33 >>> 8) & 255]) ^ acF[i32 & 255]) ^ this.e[20];
                i14 = this.e[21] ^ (((acE[i32 >>> 24] ^ p[(i31 >>> 16) & 255]) ^ q[(i34 >>> 8) & 255]) ^ acF[i33 & 255]);
                i20 = (((acE[i33 >>> 24] ^ p[(i32 >>> 16) & 255]) ^ q[(i31 >>> 8) & 255]) ^ acF[i34 & 255]) ^ this.e[22];
                int i35 = ((acE[i34 >>> 24] ^ p[(i33 >>> 16) & 255]) ^ q[(i32 >>> 8) & 255]) ^ acF[i31 & 255];
                i24 = 24;
                i25 = i35 ^ this.e[23];
            }
        }
        int i36 = i24 + 1;
        int i37 = this.e[i24] ^ (((acE[i8 >>> 24] ^ p[(i25 >>> 16) & 255]) ^ q[(i20 >>> 8) & 255]) ^ acF[i14 & 255]);
        int i38 = i36 + 1;
        int i39 = (((acE[i14 >>> 24] ^ p[(i8 >>> 16) & 255]) ^ q[(i25 >>> 8) & 255]) ^ acF[i20 & 255]) ^ this.e[i36];
        int i40 = i38 + 1;
        int i41 = (((acE[i20 >>> 24] ^ p[(i14 >>> 16) & 255]) ^ q[(i8 >>> 8) & 255]) ^ acF[i25 & 255]) ^ this.e[i38];
        int i42 = i40 + 1;
        int i43 = (((acE[i25 >>> 24] ^ p[(i20 >>> 16) & 255]) ^ q[(i14 >>> 8) & 255]) ^ acF[i8 & 255]) ^ this.e[i40];
        int i44 = i42 + 1;
        int i45 = (((acE[i37 >>> 24] ^ p[(i43 >>> 16) & 255]) ^ q[(i41 >>> 8) & 255]) ^ acF[i39 & 255]) ^ this.e[i42];
        int i46 = i44 + 1;
        int i47 = (((acE[i39 >>> 24] ^ p[(i37 >>> 16) & 255]) ^ q[(i43 >>> 8) & 255]) ^ acF[i41 & 255]) ^ this.e[i44];
        int i48 = i46 + 1;
        int i49 = (((acE[i41 >>> 24] ^ p[(i39 >>> 16) & 255]) ^ q[(i37 >>> 8) & 255]) ^ acF[i43 & 255]) ^ this.e[i46];
        int i50 = i48 + 1;
        int i51 = (((acE[i43 >>> 24] ^ p[(i41 >>> 16) & 255]) ^ q[(i39 >>> 8) & 255]) ^ acF[i37 & 255]) ^ this.e[i48];
        int i52 = i50 + 1;
        int i53 = (((acE[i45 >>> 24] ^ p[(i51 >>> 16) & 255]) ^ q[(i49 >>> 8) & 255]) ^ acF[i47 & 255]) ^ this.e[i50];
        int i54 = i52 + 1;
        int i55 = (((acE[i47 >>> 24] ^ p[(i45 >>> 16) & 255]) ^ q[(i51 >>> 8) & 255]) ^ acF[i49 & 255]) ^ this.e[i52];
        int i56 = i54 + 1;
        int i57 = (((acE[i49 >>> 24] ^ p[(i47 >>> 16) & 255]) ^ q[(i45 >>> 8) & 255]) ^ acF[i51 & 255]) ^ this.e[i54];
        int i58 = i56 + 1;
        int i59 = (((acE[i51 >>> 24] ^ p[(i49 >>> 16) & 255]) ^ q[(i47 >>> 8) & 255]) ^ acF[i45 & 255]) ^ this.e[i56];
        int i60 = i58 + 1;
        int i61 = (((acE[i53 >>> 24] ^ p[(i59 >>> 16) & 255]) ^ q[(i57 >>> 8) & 255]) ^ acF[i55 & 255]) ^ this.e[i58];
        int i62 = i60 + 1;
        int i63 = (((acE[i55 >>> 24] ^ p[(i53 >>> 16) & 255]) ^ q[(i59 >>> 8) & 255]) ^ acF[i57 & 255]) ^ this.e[i60];
        int i64 = i62 + 1;
        int i65 = (((acE[i57 >>> 24] ^ p[(i55 >>> 16) & 255]) ^ q[(i53 >>> 8) & 255]) ^ acF[i59 & 255]) ^ this.e[i62];
        int i66 = i64 + 1;
        int i67 = (((acE[i59 >>> 24] ^ p[(i57 >>> 16) & 255]) ^ q[(i55 >>> 8) & 255]) ^ acF[i53 & 255]) ^ this.e[i64];
        int i68 = i66 + 1;
        int i69 = (((acE[i61 >>> 24] ^ p[(i67 >>> 16) & 255]) ^ q[(i65 >>> 8) & 255]) ^ acF[i63 & 255]) ^ this.e[i66];
        int i70 = i68 + 1;
        int i71 = (((acE[i63 >>> 24] ^ p[(i61 >>> 16) & 255]) ^ q[(i67 >>> 8) & 255]) ^ acF[i65 & 255]) ^ this.e[i68];
        int i72 = i70 + 1;
        int i73 = (((acE[i65 >>> 24] ^ p[(i63 >>> 16) & 255]) ^ q[(i61 >>> 8) & 255]) ^ acF[i67 & 255]) ^ this.e[i70];
        int i74 = i72 + 1;
        int i75 = (((acE[i67 >>> 24] ^ p[(i65 >>> 16) & 255]) ^ q[(i63 >>> 8) & 255]) ^ acF[i61 & 255]) ^ this.e[i72];
        int i76 = i74 + 1;
        int i77 = (((acE[i69 >>> 24] ^ p[(i75 >>> 16) & 255]) ^ q[(i73 >>> 8) & 255]) ^ acF[i71 & 255]) ^ this.e[i74];
        int i78 = i76 + 1;
        int i79 = (((acE[i71 >>> 24] ^ p[(i69 >>> 16) & 255]) ^ q[(i75 >>> 8) & 255]) ^ acF[i73 & 255]) ^ this.e[i76];
        int i80 = i78 + 1;
        int i81 = (((acE[i73 >>> 24] ^ p[(i71 >>> 16) & 255]) ^ q[(i69 >>> 8) & 255]) ^ acF[i75 & 255]) ^ this.e[i78];
        int i82 = i80 + 1;
        int i83 = (((acE[i75 >>> 24] ^ p[(i73 >>> 16) & 255]) ^ q[(i71 >>> 8) & 255]) ^ acF[i69 & 255]) ^ this.e[i80];
        int i84 = i82 + 1;
        int i85 = (((acE[i77 >>> 24] ^ p[(i83 >>> 16) & 255]) ^ q[(i81 >>> 8) & 255]) ^ acF[i79 & 255]) ^ this.e[i82];
        int i86 = i84 + 1;
        int i87 = (((acE[i79 >>> 24] ^ p[(i77 >>> 16) & 255]) ^ q[(i83 >>> 8) & 255]) ^ acF[i81 & 255]) ^ this.e[i84];
        int i88 = i86 + 1;
        int i89 = (((acE[i81 >>> 24] ^ p[(i79 >>> 16) & 255]) ^ q[(i77 >>> 8) & 255]) ^ acF[i83 & 255]) ^ this.e[i86];
        int i90 = i88 + 1;
        int i91 = (((acE[i83 >>> 24] ^ p[(i81 >>> 16) & 255]) ^ q[(i79 >>> 8) & 255]) ^ acF[i77 & 255]) ^ this.e[i88];
        int i92 = i90 + 1;
        int i93 = (((acE[i85 >>> 24] ^ p[(i91 >>> 16) & 255]) ^ q[(i89 >>> 8) & 255]) ^ acF[i87 & 255]) ^ this.e[i90];
        int i94 = i92 + 1;
        int i95 = (((acE[i87 >>> 24] ^ p[(i85 >>> 16) & 255]) ^ q[(i91 >>> 8) & 255]) ^ acF[i89 & 255]) ^ this.e[i92];
        int i96 = i94 + 1;
        int i97 = (((acE[i89 >>> 24] ^ p[(i87 >>> 16) & 255]) ^ q[(i85 >>> 8) & 255]) ^ acF[i91 & 255]) ^ this.e[i94];
        int i98 = i96 + 1;
        int i99 = (((acE[i91 >>> 24] ^ p[(i89 >>> 16) & 255]) ^ q[(i87 >>> 8) & 255]) ^ acF[i85 & 255]) ^ this.e[i96];
        int i100 = i98 + 1;
        int i101 = (((acE[i93 >>> 24] ^ p[(i99 >>> 16) & 255]) ^ q[(i97 >>> 8) & 255]) ^ acF[i95 & 255]) ^ this.e[i98];
        int i102 = i100 + 1;
        int i103 = (((acE[i95 >>> 24] ^ p[(i93 >>> 16) & 255]) ^ q[(i99 >>> 8) & 255]) ^ acF[i97 & 255]) ^ this.e[i100];
        int i104 = i102 + 1;
        int i105 = (((acE[i97 >>> 24] ^ p[(i95 >>> 16) & 255]) ^ q[(i93 >>> 8) & 255]) ^ acF[i99 & 255]) ^ this.e[i102];
        int i106 = i104 + 1;
        int i107 = (((acE[i99 >>> 24] ^ p[(i97 >>> 16) & 255]) ^ q[(i95 >>> 8) & 255]) ^ acF[i93 & 255]) ^ this.e[i104];
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
