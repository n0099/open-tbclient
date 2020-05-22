package com.baidu.cesium.c.a;

import java.lang.reflect.Array;
import java.security.InvalidKeyException;
/* loaded from: classes13.dex */
public final class b implements a {
    private static int[] h;
    private static int[] i;
    private static final byte[] j = new byte[256];
    private static final byte[] k = new byte[256];
    private static final int[] l = new int[256];
    private static final int[] aiV = new int[256];
    private static final int[] aiW = new int[256];
    private static final int[] aiX = new int[256];
    private static final int[] aiY = new int[256];
    private static final int[] aiZ = new int[256];
    private static final int[] aja = new int[256];
    private static final int[] ajb = new int[256];
    private static final int[] ajc = new int[256];
    private static final int[] ajd = new int[256];
    private static final int[] aje = new int[256];
    private static final int[] ajf = new int[256];
    private static final byte[] ajg = new byte[30];
    private boolean c = false;
    private boolean d = false;
    private Object[] e = null;
    private int[] aiU = null;
    private int g = 0;

    static {
        h = new int[256];
        i = new int[256];
        h[0] = 1;
        for (int i2 = 1; i2 < 256; i2++) {
            int i3 = (h[i2 - 1] << 1) ^ h[i2 - 1];
            if ((i3 & 256) != 0) {
                i3 ^= 283;
            }
            h[i2] = i3;
        }
        for (int i4 = 1; i4 < 255; i4++) {
            i[h[i4]] = i4;
        }
        byte[][] bArr = {new byte[]{1, 1, 1, 1, 1, 0, 0, 0}, new byte[]{0, 1, 1, 1, 1, 1, 0, 0}, new byte[]{0, 0, 1, 1, 1, 1, 1, 0}, new byte[]{0, 0, 0, 1, 1, 1, 1, 1}, new byte[]{1, 0, 0, 0, 1, 1, 1, 1}, new byte[]{1, 1, 0, 0, 0, 1, 1, 1}, new byte[]{1, 1, 1, 0, 0, 0, 1, 1}, new byte[]{1, 1, 1, 1, 0, 0, 0, 1}};
        byte[] bArr2 = {0, 1, 1, 0, 0, 0, 1, 1};
        byte[][] bArr3 = (byte[][]) Array.newInstance(Byte.TYPE, 256, 8);
        bArr3[1][7] = 1;
        for (int i5 = 2; i5 < 256; i5++) {
            int i6 = h[255 - i[i5]];
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
            j[i11] = (byte) (bArr4[i11][0] << 7);
            for (int i12 = 1; i12 < 8; i12++) {
                byte[] bArr6 = j;
                bArr6[i11] = (byte) (bArr6[i11] ^ (bArr4[i11][i12] << (7 - i12)));
            }
            k[j[i11] & 255] = (byte) i11;
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
                    bArr8[i15][i18] = (byte) h[((i[bArr8[i15][i18] & 255] + 255) - i[b & 255]) % 255];
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
            byte b3 = j[i23];
            l[i23] = e(b3, bArr7[0]);
            aiV[i23] = e(b3, bArr7[1]);
            aiW[i23] = e(b3, bArr7[2]);
            aiX[i23] = e(b3, bArr7[3]);
            byte b4 = k[i23];
            aiY[i23] = e(b4, bArr9[0]);
            aiZ[i23] = e(b4, bArr9[1]);
            aja[i23] = e(b4, bArr9[2]);
            ajb[i23] = e(b4, bArr9[3]);
            ajc[i23] = e(i23, bArr9[0]);
            ajd[i23] = e(i23, bArr9[1]);
            aje[i23] = e(i23, bArr9[2]);
            ajf[i23] = e(i23, bArr9[3]);
        }
        ajg[0] = 1;
        int i24 = 1;
        for (int i25 = 1; i25 < 30; i25++) {
            i24 = a(2, i24);
            ajg[i25] = (byte) i24;
        }
        i = null;
        h = null;
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
        this.aiU = new int[length * 4];
        for (int i2 = 0; i2 < length; i2++) {
            for (int i3 = 0; i3 < 4; i3++) {
                this.aiU[(i2 * 4) + i3] = iArr[i2][i3];
            }
        }
        if (z) {
            int i4 = this.aiU[this.aiU.length - 4];
            int i5 = this.aiU[this.aiU.length - 3];
            int i6 = this.aiU[this.aiU.length - 2];
            int i7 = this.aiU[this.aiU.length - 1];
            for (int length2 = this.aiU.length - 1; length2 > 3; length2--) {
                this.aiU[length2] = this.aiU[length2 - 4];
            }
            this.aiU[0] = i4;
            this.aiU[1] = i5;
            this.aiU[2] = i6;
            this.aiU[3] = i7;
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

    private static Object[] p(byte[] bArr) {
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
                iArr3[0] = ((ajg[i7] << 24) ^ ((j[i8 >>> 24] & 255) ^ (((j[(i8 >>> 16) & 255] << 24) ^ ((j[(i8 >>> 8) & 255] & 255) << 16)) ^ ((j[i8 & 255] & 255) << 8)))) ^ iArr3[0];
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
                i5 = i19;
                i7 = i9;
            }
            for (int i20 = 1; i20 < b; i20++) {
                for (int i21 = 0; i21 < 4; i21++) {
                    int i22 = iArr2[i20][i21];
                    iArr2[i20][i21] = ajf[i22 & 255] ^ ((ajc[(i22 >>> 24) & 255] ^ ajd[(i22 >>> 16) & 255]) ^ aje[(i22 >>> 8) & 255]);
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
        this.e = p(bArr);
        a(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(byte[] bArr, int i2, byte[] bArr2, int i3) {
        int i4 = i2 + 1;
        int i5 = i4 + 1;
        int i6 = i5 + 1;
        int i7 = i6 + 1;
        int i8 = (((((bArr[i4] & 255) << 16) | (bArr[i2] << 24)) | ((bArr[i5] & 255) << 8)) | (bArr[i6] & 255)) ^ this.aiU[0];
        int i9 = i7 + 1;
        int i10 = i9 + 1;
        int i11 = ((bArr[i9] & 255) << 16) | (bArr[i7] << 24);
        int i12 = i10 + 1;
        int i13 = i12 + 1;
        int i14 = ((i11 | ((bArr[i10] & 255) << 8)) | (bArr[i12] & 255)) ^ this.aiU[1];
        int i15 = i13 + 1;
        int i16 = i15 + 1;
        int i17 = i16 + 1;
        int i18 = ((bArr[i15] & 255) << 16) | (bArr[i13] << 24) | ((bArr[i16] & 255) << 8);
        int i19 = i17 + 1;
        int i20 = this.aiU[2] ^ (i18 | (bArr[i17] & 255));
        int i21 = i19 + 1;
        int i22 = i21 + 1;
        int i23 = ((bArr[i21] & 255) << 16) | (bArr[i19] << 24);
        int i24 = i22 + 1;
        int i25 = i23 | ((bArr[i22] & 255) << 8);
        int i26 = i24 + 1;
        int i27 = (i25 | (bArr[i24] & 255)) ^ this.aiU[3];
        int i28 = i8;
        int i29 = i14;
        int i30 = 4;
        while (i30 < this.g) {
            int i31 = i30 + 1;
            int i32 = (((l[i28 >>> 24] ^ aiV[(i29 >>> 16) & 255]) ^ aiW[(i20 >>> 8) & 255]) ^ aiX[i27 & 255]) ^ this.aiU[i30];
            int i33 = i31 + 1;
            int i34 = this.aiU[i31] ^ (((l[i29 >>> 24] ^ aiV[(i20 >>> 16) & 255]) ^ aiW[(i27 >>> 8) & 255]) ^ aiX[i28 & 255]);
            int i35 = i33 + 1;
            int i36 = (((l[i20 >>> 24] ^ aiV[(i27 >>> 16) & 255]) ^ aiW[(i28 >>> 8) & 255]) ^ aiX[i29 & 255]) ^ this.aiU[i33];
            i27 = (((l[i27 >>> 24] ^ aiV[(i28 >>> 16) & 255]) ^ aiW[(i29 >>> 8) & 255]) ^ aiX[i20 & 255]) ^ this.aiU[i35];
            i29 = i34;
            i28 = i32;
            i30 = i35 + 1;
            i20 = i36;
        }
        int i37 = i30 + 1;
        int i38 = this.aiU[i30];
        int i39 = i3 + 1;
        bArr2[i3] = (byte) (j[i28 >>> 24] ^ (i38 >>> 24));
        int i40 = i39 + 1;
        bArr2[i39] = (byte) (j[(i29 >>> 16) & 255] ^ (i38 >>> 16));
        int i41 = i40 + 1;
        bArr2[i40] = (byte) (j[(i20 >>> 8) & 255] ^ (i38 >>> 8));
        int i42 = i41 + 1;
        bArr2[i41] = (byte) (i38 ^ j[i27 & 255]);
        int i43 = i37 + 1;
        int i44 = this.aiU[i37];
        int i45 = i42 + 1;
        bArr2[i42] = (byte) (j[i29 >>> 24] ^ (i44 >>> 24));
        int i46 = i45 + 1;
        bArr2[i45] = (byte) (j[(i20 >>> 16) & 255] ^ (i44 >>> 16));
        int i47 = i46 + 1;
        bArr2[i46] = (byte) (j[(i27 >>> 8) & 255] ^ (i44 >>> 8));
        int i48 = i47 + 1;
        bArr2[i47] = (byte) (i44 ^ j[i28 & 255]);
        int i49 = i43 + 1;
        int i50 = this.aiU[i43];
        int i51 = i48 + 1;
        bArr2[i48] = (byte) (j[i20 >>> 24] ^ (i50 >>> 24));
        int i52 = i51 + 1;
        bArr2[i51] = (byte) (j[(i27 >>> 16) & 255] ^ (i50 >>> 16));
        int i53 = i52 + 1;
        bArr2[i52] = (byte) (j[(i28 >>> 8) & 255] ^ (i50 >>> 8));
        int i54 = i53 + 1;
        bArr2[i53] = (byte) (i50 ^ j[i29 & 255]);
        int i55 = i49 + 1;
        int i56 = this.aiU[i49];
        int i57 = i54 + 1;
        bArr2[i54] = (byte) (j[i27 >>> 24] ^ (i56 >>> 24));
        int i58 = i57 + 1;
        bArr2[i57] = (byte) (j[(i28 >>> 16) & 255] ^ (i56 >>> 16));
        bArr2[i58] = (byte) (j[(i29 >>> 8) & 255] ^ (i56 >>> 8));
        bArr2[i58 + 1] = (byte) (j[i20 & 255] ^ i56);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(byte[] bArr, int i2, byte[] bArr2, int i3) {
        int i4 = i2 + 1;
        int i5 = i4 + 1;
        int i6 = i5 + 1;
        int i7 = i6 + 1;
        int i8 = (((((bArr[i4] & 255) << 16) | (bArr[i2] << 24)) | ((bArr[i5] & 255) << 8)) | (bArr[i6] & 255)) ^ this.aiU[4];
        int i9 = i7 + 1;
        int i10 = i9 + 1;
        int i11 = ((bArr[i9] & 255) << 16) | (bArr[i7] << 24);
        int i12 = i10 + 1;
        int i13 = i12 + 1;
        int i14 = ((i11 | ((bArr[i10] & 255) << 8)) | (bArr[i12] & 255)) ^ this.aiU[5];
        int i15 = i13 + 1;
        int i16 = i15 + 1;
        int i17 = i16 + 1;
        int i18 = ((bArr[i15] & 255) << 16) | (bArr[i13] << 24) | ((bArr[i16] & 255) << 8);
        int i19 = i17 + 1;
        int i20 = this.aiU[6] ^ (i18 | (bArr[i17] & 255));
        int i21 = i19 + 1;
        int i22 = i21 + 1;
        int i23 = ((bArr[i21] & 255) << 16) | (bArr[i19] << 24) | ((bArr[i22] & 255) << 8) | (bArr[i22 + 1] & 255);
        int i24 = 8;
        int i25 = i23 ^ this.aiU[7];
        if (this.c) {
            int i26 = this.aiU[8] ^ (((aiY[i8 >>> 24] ^ aiZ[(i25 >>> 16) & 255]) ^ aja[(i20 >>> 8) & 255]) ^ ajb[i14 & 255]);
            int i27 = (((aiY[i14 >>> 24] ^ aiZ[(i8 >>> 16) & 255]) ^ aja[(i25 >>> 8) & 255]) ^ ajb[i20 & 255]) ^ this.aiU[9];
            int i28 = (((aiY[i20 >>> 24] ^ aiZ[(i14 >>> 16) & 255]) ^ aja[(i8 >>> 8) & 255]) ^ ajb[i25 & 255]) ^ this.aiU[10];
            int i29 = (((aiY[i25 >>> 24] ^ aiZ[(i20 >>> 16) & 255]) ^ aja[(i14 >>> 8) & 255]) ^ ajb[i8 & 255]) ^ this.aiU[11];
            i8 = (((aiY[i26 >>> 24] ^ aiZ[(i29 >>> 16) & 255]) ^ aja[(i28 >>> 8) & 255]) ^ ajb[i27 & 255]) ^ this.aiU[12];
            i14 = this.aiU[13] ^ (((aiY[i27 >>> 24] ^ aiZ[(i26 >>> 16) & 255]) ^ aja[(i29 >>> 8) & 255]) ^ ajb[i28 & 255]);
            i20 = (((aiY[i28 >>> 24] ^ aiZ[(i27 >>> 16) & 255]) ^ aja[(i26 >>> 8) & 255]) ^ ajb[i29 & 255]) ^ this.aiU[14];
            int i30 = ((aiY[i29 >>> 24] ^ aiZ[(i28 >>> 16) & 255]) ^ aja[(i27 >>> 8) & 255]) ^ ajb[i26 & 255];
            i24 = 16;
            i25 = i30 ^ this.aiU[15];
            if (this.d) {
                int i31 = this.aiU[16] ^ (((aiY[i8 >>> 24] ^ aiZ[(i25 >>> 16) & 255]) ^ aja[(i20 >>> 8) & 255]) ^ ajb[i14 & 255]);
                int i32 = (((aiY[i14 >>> 24] ^ aiZ[(i8 >>> 16) & 255]) ^ aja[(i25 >>> 8) & 255]) ^ ajb[i20 & 255]) ^ this.aiU[17];
                int i33 = (((aiY[i20 >>> 24] ^ aiZ[(i14 >>> 16) & 255]) ^ aja[(i8 >>> 8) & 255]) ^ ajb[i25 & 255]) ^ this.aiU[18];
                int i34 = (((aiY[i25 >>> 24] ^ aiZ[(i20 >>> 16) & 255]) ^ aja[(i14 >>> 8) & 255]) ^ ajb[i8 & 255]) ^ this.aiU[19];
                i8 = (((aiY[i31 >>> 24] ^ aiZ[(i34 >>> 16) & 255]) ^ aja[(i33 >>> 8) & 255]) ^ ajb[i32 & 255]) ^ this.aiU[20];
                i14 = this.aiU[21] ^ (((aiY[i32 >>> 24] ^ aiZ[(i31 >>> 16) & 255]) ^ aja[(i34 >>> 8) & 255]) ^ ajb[i33 & 255]);
                i20 = (((aiY[i33 >>> 24] ^ aiZ[(i32 >>> 16) & 255]) ^ aja[(i31 >>> 8) & 255]) ^ ajb[i34 & 255]) ^ this.aiU[22];
                int i35 = ((aiY[i34 >>> 24] ^ aiZ[(i33 >>> 16) & 255]) ^ aja[(i32 >>> 8) & 255]) ^ ajb[i31 & 255];
                i24 = 24;
                i25 = i35 ^ this.aiU[23];
            }
        }
        int i36 = i24 + 1;
        int i37 = this.aiU[i24] ^ (((aiY[i8 >>> 24] ^ aiZ[(i25 >>> 16) & 255]) ^ aja[(i20 >>> 8) & 255]) ^ ajb[i14 & 255]);
        int i38 = i36 + 1;
        int i39 = (((aiY[i14 >>> 24] ^ aiZ[(i8 >>> 16) & 255]) ^ aja[(i25 >>> 8) & 255]) ^ ajb[i20 & 255]) ^ this.aiU[i36];
        int i40 = i38 + 1;
        int i41 = (((aiY[i20 >>> 24] ^ aiZ[(i14 >>> 16) & 255]) ^ aja[(i8 >>> 8) & 255]) ^ ajb[i25 & 255]) ^ this.aiU[i38];
        int i42 = i40 + 1;
        int i43 = (((aiY[i25 >>> 24] ^ aiZ[(i20 >>> 16) & 255]) ^ aja[(i14 >>> 8) & 255]) ^ ajb[i8 & 255]) ^ this.aiU[i40];
        int i44 = i42 + 1;
        int i45 = (((aiY[i37 >>> 24] ^ aiZ[(i43 >>> 16) & 255]) ^ aja[(i41 >>> 8) & 255]) ^ ajb[i39 & 255]) ^ this.aiU[i42];
        int i46 = i44 + 1;
        int i47 = (((aiY[i39 >>> 24] ^ aiZ[(i37 >>> 16) & 255]) ^ aja[(i43 >>> 8) & 255]) ^ ajb[i41 & 255]) ^ this.aiU[i44];
        int i48 = i46 + 1;
        int i49 = (((aiY[i41 >>> 24] ^ aiZ[(i39 >>> 16) & 255]) ^ aja[(i37 >>> 8) & 255]) ^ ajb[i43 & 255]) ^ this.aiU[i46];
        int i50 = i48 + 1;
        int i51 = (((aiY[i43 >>> 24] ^ aiZ[(i41 >>> 16) & 255]) ^ aja[(i39 >>> 8) & 255]) ^ ajb[i37 & 255]) ^ this.aiU[i48];
        int i52 = i50 + 1;
        int i53 = (((aiY[i45 >>> 24] ^ aiZ[(i51 >>> 16) & 255]) ^ aja[(i49 >>> 8) & 255]) ^ ajb[i47 & 255]) ^ this.aiU[i50];
        int i54 = i52 + 1;
        int i55 = (((aiY[i47 >>> 24] ^ aiZ[(i45 >>> 16) & 255]) ^ aja[(i51 >>> 8) & 255]) ^ ajb[i49 & 255]) ^ this.aiU[i52];
        int i56 = i54 + 1;
        int i57 = (((aiY[i49 >>> 24] ^ aiZ[(i47 >>> 16) & 255]) ^ aja[(i45 >>> 8) & 255]) ^ ajb[i51 & 255]) ^ this.aiU[i54];
        int i58 = i56 + 1;
        int i59 = (((aiY[i51 >>> 24] ^ aiZ[(i49 >>> 16) & 255]) ^ aja[(i47 >>> 8) & 255]) ^ ajb[i45 & 255]) ^ this.aiU[i56];
        int i60 = i58 + 1;
        int i61 = (((aiY[i53 >>> 24] ^ aiZ[(i59 >>> 16) & 255]) ^ aja[(i57 >>> 8) & 255]) ^ ajb[i55 & 255]) ^ this.aiU[i58];
        int i62 = i60 + 1;
        int i63 = (((aiY[i55 >>> 24] ^ aiZ[(i53 >>> 16) & 255]) ^ aja[(i59 >>> 8) & 255]) ^ ajb[i57 & 255]) ^ this.aiU[i60];
        int i64 = i62 + 1;
        int i65 = (((aiY[i57 >>> 24] ^ aiZ[(i55 >>> 16) & 255]) ^ aja[(i53 >>> 8) & 255]) ^ ajb[i59 & 255]) ^ this.aiU[i62];
        int i66 = i64 + 1;
        int i67 = (((aiY[i59 >>> 24] ^ aiZ[(i57 >>> 16) & 255]) ^ aja[(i55 >>> 8) & 255]) ^ ajb[i53 & 255]) ^ this.aiU[i64];
        int i68 = i66 + 1;
        int i69 = (((aiY[i61 >>> 24] ^ aiZ[(i67 >>> 16) & 255]) ^ aja[(i65 >>> 8) & 255]) ^ ajb[i63 & 255]) ^ this.aiU[i66];
        int i70 = i68 + 1;
        int i71 = (((aiY[i63 >>> 24] ^ aiZ[(i61 >>> 16) & 255]) ^ aja[(i67 >>> 8) & 255]) ^ ajb[i65 & 255]) ^ this.aiU[i68];
        int i72 = i70 + 1;
        int i73 = (((aiY[i65 >>> 24] ^ aiZ[(i63 >>> 16) & 255]) ^ aja[(i61 >>> 8) & 255]) ^ ajb[i67 & 255]) ^ this.aiU[i70];
        int i74 = i72 + 1;
        int i75 = (((aiY[i67 >>> 24] ^ aiZ[(i65 >>> 16) & 255]) ^ aja[(i63 >>> 8) & 255]) ^ ajb[i61 & 255]) ^ this.aiU[i72];
        int i76 = i74 + 1;
        int i77 = (((aiY[i69 >>> 24] ^ aiZ[(i75 >>> 16) & 255]) ^ aja[(i73 >>> 8) & 255]) ^ ajb[i71 & 255]) ^ this.aiU[i74];
        int i78 = i76 + 1;
        int i79 = (((aiY[i71 >>> 24] ^ aiZ[(i69 >>> 16) & 255]) ^ aja[(i75 >>> 8) & 255]) ^ ajb[i73 & 255]) ^ this.aiU[i76];
        int i80 = i78 + 1;
        int i81 = (((aiY[i73 >>> 24] ^ aiZ[(i71 >>> 16) & 255]) ^ aja[(i69 >>> 8) & 255]) ^ ajb[i75 & 255]) ^ this.aiU[i78];
        int i82 = i80 + 1;
        int i83 = (((aiY[i75 >>> 24] ^ aiZ[(i73 >>> 16) & 255]) ^ aja[(i71 >>> 8) & 255]) ^ ajb[i69 & 255]) ^ this.aiU[i80];
        int i84 = i82 + 1;
        int i85 = (((aiY[i77 >>> 24] ^ aiZ[(i83 >>> 16) & 255]) ^ aja[(i81 >>> 8) & 255]) ^ ajb[i79 & 255]) ^ this.aiU[i82];
        int i86 = i84 + 1;
        int i87 = (((aiY[i79 >>> 24] ^ aiZ[(i77 >>> 16) & 255]) ^ aja[(i83 >>> 8) & 255]) ^ ajb[i81 & 255]) ^ this.aiU[i84];
        int i88 = i86 + 1;
        int i89 = (((aiY[i81 >>> 24] ^ aiZ[(i79 >>> 16) & 255]) ^ aja[(i77 >>> 8) & 255]) ^ ajb[i83 & 255]) ^ this.aiU[i86];
        int i90 = i88 + 1;
        int i91 = (((aiY[i83 >>> 24] ^ aiZ[(i81 >>> 16) & 255]) ^ aja[(i79 >>> 8) & 255]) ^ ajb[i77 & 255]) ^ this.aiU[i88];
        int i92 = i90 + 1;
        int i93 = (((aiY[i85 >>> 24] ^ aiZ[(i91 >>> 16) & 255]) ^ aja[(i89 >>> 8) & 255]) ^ ajb[i87 & 255]) ^ this.aiU[i90];
        int i94 = i92 + 1;
        int i95 = (((aiY[i87 >>> 24] ^ aiZ[(i85 >>> 16) & 255]) ^ aja[(i91 >>> 8) & 255]) ^ ajb[i89 & 255]) ^ this.aiU[i92];
        int i96 = i94 + 1;
        int i97 = (((aiY[i89 >>> 24] ^ aiZ[(i87 >>> 16) & 255]) ^ aja[(i85 >>> 8) & 255]) ^ ajb[i91 & 255]) ^ this.aiU[i94];
        int i98 = i96 + 1;
        int i99 = (((aiY[i91 >>> 24] ^ aiZ[(i89 >>> 16) & 255]) ^ aja[(i87 >>> 8) & 255]) ^ ajb[i85 & 255]) ^ this.aiU[i96];
        int i100 = i98 + 1;
        int i101 = (((aiY[i93 >>> 24] ^ aiZ[(i99 >>> 16) & 255]) ^ aja[(i97 >>> 8) & 255]) ^ ajb[i95 & 255]) ^ this.aiU[i98];
        int i102 = i100 + 1;
        int i103 = (((aiY[i95 >>> 24] ^ aiZ[(i93 >>> 16) & 255]) ^ aja[(i99 >>> 8) & 255]) ^ ajb[i97 & 255]) ^ this.aiU[i100];
        int i104 = i102 + 1;
        int i105 = (((aiY[i97 >>> 24] ^ aiZ[(i95 >>> 16) & 255]) ^ aja[(i93 >>> 8) & 255]) ^ ajb[i99 & 255]) ^ this.aiU[i102];
        int i106 = i104 + 1;
        int i107 = (((aiY[i99 >>> 24] ^ aiZ[(i97 >>> 16) & 255]) ^ aja[(i95 >>> 8) & 255]) ^ ajb[i93 & 255]) ^ this.aiU[i104];
        int i108 = this.aiU[0];
        int i109 = i3 + 1;
        bArr2[i3] = (byte) (k[i101 >>> 24] ^ (i108 >>> 24));
        int i110 = i109 + 1;
        bArr2[i109] = (byte) (k[(i107 >>> 16) & 255] ^ (i108 >>> 16));
        int i111 = i110 + 1;
        bArr2[i110] = (byte) (k[(i105 >>> 8) & 255] ^ (i108 >>> 8));
        int i112 = i111 + 1;
        bArr2[i111] = (byte) (i108 ^ k[i103 & 255]);
        int i113 = this.aiU[1];
        int i114 = i112 + 1;
        bArr2[i112] = (byte) (k[i103 >>> 24] ^ (i113 >>> 24));
        int i115 = i114 + 1;
        bArr2[i114] = (byte) (k[(i101 >>> 16) & 255] ^ (i113 >>> 16));
        int i116 = i115 + 1;
        bArr2[i115] = (byte) (k[(i107 >>> 8) & 255] ^ (i113 >>> 8));
        int i117 = i116 + 1;
        bArr2[i116] = (byte) (i113 ^ k[i105 & 255]);
        int i118 = this.aiU[2];
        int i119 = i117 + 1;
        bArr2[i117] = (byte) (k[i105 >>> 24] ^ (i118 >>> 24));
        int i120 = i119 + 1;
        bArr2[i119] = (byte) (k[(i103 >>> 16) & 255] ^ (i118 >>> 16));
        int i121 = i120 + 1;
        bArr2[i120] = (byte) (k[(i101 >>> 8) & 255] ^ (i118 >>> 8));
        int i122 = i121 + 1;
        bArr2[i121] = (byte) (i118 ^ k[i107 & 255]);
        int i123 = this.aiU[3];
        int i124 = i122 + 1;
        bArr2[i122] = (byte) (k[i107 >>> 24] ^ (i123 >>> 24));
        int i125 = i124 + 1;
        bArr2[i124] = (byte) (k[(i105 >>> 16) & 255] ^ (i123 >>> 16));
        bArr2[i125] = (byte) (k[(i103 >>> 8) & 255] ^ (i123 >>> 8));
        bArr2[i125 + 1] = (byte) (k[i101 & 255] ^ i123);
    }
}
