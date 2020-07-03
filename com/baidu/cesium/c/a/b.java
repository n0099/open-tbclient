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
    private static final int[] akr = new int[256];
    private static final int[] aks = new int[256];
    private static final int[] akt = new int[256];
    private static final int[] aku = new int[256];
    private static final int[] akv = new int[256];
    private static final int[] akw = new int[256];
    private static final int[] akx = new int[256];
    private static final int[] aky = new int[256];
    private static final int[] akz = new int[256];
    private static final int[] akA = new int[256];
    private static final int[] akB = new int[256];
    private static final byte[] akC = new byte[30];
    private boolean c = false;
    private boolean d = false;
    private Object[] e = null;
    private int[] akq = null;
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
            akr[i23] = e(b3, bArr7[1]);
            aks[i23] = e(b3, bArr7[2]);
            akt[i23] = e(b3, bArr7[3]);
            byte b4 = k[i23];
            aku[i23] = e(b4, bArr9[0]);
            akv[i23] = e(b4, bArr9[1]);
            akw[i23] = e(b4, bArr9[2]);
            akx[i23] = e(b4, bArr9[3]);
            aky[i23] = e(i23, bArr9[0]);
            akz[i23] = e(i23, bArr9[1]);
            akA[i23] = e(i23, bArr9[2]);
            akB[i23] = e(i23, bArr9[3]);
        }
        akC[0] = 1;
        int i24 = 1;
        for (int i25 = 1; i25 < 30; i25++) {
            i24 = a(2, i24);
            akC[i25] = (byte) i24;
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
        this.akq = new int[length * 4];
        for (int i2 = 0; i2 < length; i2++) {
            for (int i3 = 0; i3 < 4; i3++) {
                this.akq[(i2 * 4) + i3] = iArr[i2][i3];
            }
        }
        if (z) {
            int i4 = this.akq[this.akq.length - 4];
            int i5 = this.akq[this.akq.length - 3];
            int i6 = this.akq[this.akq.length - 2];
            int i7 = this.akq[this.akq.length - 1];
            for (int length2 = this.akq.length - 1; length2 > 3; length2--) {
                this.akq[length2] = this.akq[length2 - 4];
            }
            this.akq[0] = i4;
            this.akq[1] = i5;
            this.akq[2] = i6;
            this.akq[3] = i7;
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
                iArr3[0] = ((akC[i7] << 24) ^ ((j[i8 >>> 24] & 255) ^ (((j[(i8 >>> 16) & 255] << 24) ^ ((j[(i8 >>> 8) & 255] & 255) << 16)) ^ ((j[i8 & 255] & 255) << 8)))) ^ iArr3[0];
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
                    iArr2[i20][i21] = akB[i22 & 255] ^ ((aky[(i22 >>> 24) & 255] ^ akz[(i22 >>> 16) & 255]) ^ akA[(i22 >>> 8) & 255]);
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
        int i7 = i6 + 1;
        int i8 = (((((bArr[i4] & 255) << 16) | (bArr[i2] << 24)) | ((bArr[i5] & 255) << 8)) | (bArr[i6] & 255)) ^ this.akq[0];
        int i9 = i7 + 1;
        int i10 = i9 + 1;
        int i11 = ((bArr[i9] & 255) << 16) | (bArr[i7] << 24);
        int i12 = i10 + 1;
        int i13 = i12 + 1;
        int i14 = ((i11 | ((bArr[i10] & 255) << 8)) | (bArr[i12] & 255)) ^ this.akq[1];
        int i15 = i13 + 1;
        int i16 = i15 + 1;
        int i17 = i16 + 1;
        int i18 = ((bArr[i15] & 255) << 16) | (bArr[i13] << 24) | ((bArr[i16] & 255) << 8);
        int i19 = i17 + 1;
        int i20 = this.akq[2] ^ (i18 | (bArr[i17] & 255));
        int i21 = i19 + 1;
        int i22 = i21 + 1;
        int i23 = ((bArr[i21] & 255) << 16) | (bArr[i19] << 24);
        int i24 = i22 + 1;
        int i25 = i23 | ((bArr[i22] & 255) << 8);
        int i26 = i24 + 1;
        int i27 = (i25 | (bArr[i24] & 255)) ^ this.akq[3];
        int i28 = i8;
        int i29 = i14;
        int i30 = 4;
        while (i30 < this.g) {
            int i31 = i30 + 1;
            int i32 = (((l[i28 >>> 24] ^ akr[(i29 >>> 16) & 255]) ^ aks[(i20 >>> 8) & 255]) ^ akt[i27 & 255]) ^ this.akq[i30];
            int i33 = i31 + 1;
            int i34 = this.akq[i31] ^ (((l[i29 >>> 24] ^ akr[(i20 >>> 16) & 255]) ^ aks[(i27 >>> 8) & 255]) ^ akt[i28 & 255]);
            int i35 = i33 + 1;
            int i36 = (((l[i20 >>> 24] ^ akr[(i27 >>> 16) & 255]) ^ aks[(i28 >>> 8) & 255]) ^ akt[i29 & 255]) ^ this.akq[i33];
            i27 = (((l[i27 >>> 24] ^ akr[(i28 >>> 16) & 255]) ^ aks[(i29 >>> 8) & 255]) ^ akt[i20 & 255]) ^ this.akq[i35];
            i29 = i34;
            i28 = i32;
            i30 = i35 + 1;
            i20 = i36;
        }
        int i37 = i30 + 1;
        int i38 = this.akq[i30];
        int i39 = i3 + 1;
        bArr2[i3] = (byte) (j[i28 >>> 24] ^ (i38 >>> 24));
        int i40 = i39 + 1;
        bArr2[i39] = (byte) (j[(i29 >>> 16) & 255] ^ (i38 >>> 16));
        int i41 = i40 + 1;
        bArr2[i40] = (byte) (j[(i20 >>> 8) & 255] ^ (i38 >>> 8));
        int i42 = i41 + 1;
        bArr2[i41] = (byte) (i38 ^ j[i27 & 255]);
        int i43 = i37 + 1;
        int i44 = this.akq[i37];
        int i45 = i42 + 1;
        bArr2[i42] = (byte) (j[i29 >>> 24] ^ (i44 >>> 24));
        int i46 = i45 + 1;
        bArr2[i45] = (byte) (j[(i20 >>> 16) & 255] ^ (i44 >>> 16));
        int i47 = i46 + 1;
        bArr2[i46] = (byte) (j[(i27 >>> 8) & 255] ^ (i44 >>> 8));
        int i48 = i47 + 1;
        bArr2[i47] = (byte) (i44 ^ j[i28 & 255]);
        int i49 = i43 + 1;
        int i50 = this.akq[i43];
        int i51 = i48 + 1;
        bArr2[i48] = (byte) (j[i20 >>> 24] ^ (i50 >>> 24));
        int i52 = i51 + 1;
        bArr2[i51] = (byte) (j[(i27 >>> 16) & 255] ^ (i50 >>> 16));
        int i53 = i52 + 1;
        bArr2[i52] = (byte) (j[(i28 >>> 8) & 255] ^ (i50 >>> 8));
        int i54 = i53 + 1;
        bArr2[i53] = (byte) (i50 ^ j[i29 & 255]);
        int i55 = i49 + 1;
        int i56 = this.akq[i49];
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
        int i8 = (((((bArr[i4] & 255) << 16) | (bArr[i2] << 24)) | ((bArr[i5] & 255) << 8)) | (bArr[i6] & 255)) ^ this.akq[4];
        int i9 = i7 + 1;
        int i10 = i9 + 1;
        int i11 = ((bArr[i9] & 255) << 16) | (bArr[i7] << 24);
        int i12 = i10 + 1;
        int i13 = i12 + 1;
        int i14 = ((i11 | ((bArr[i10] & 255) << 8)) | (bArr[i12] & 255)) ^ this.akq[5];
        int i15 = i13 + 1;
        int i16 = i15 + 1;
        int i17 = i16 + 1;
        int i18 = ((bArr[i15] & 255) << 16) | (bArr[i13] << 24) | ((bArr[i16] & 255) << 8);
        int i19 = i17 + 1;
        int i20 = this.akq[6] ^ (i18 | (bArr[i17] & 255));
        int i21 = i19 + 1;
        int i22 = i21 + 1;
        int i23 = ((bArr[i21] & 255) << 16) | (bArr[i19] << 24) | ((bArr[i22] & 255) << 8) | (bArr[i22 + 1] & 255);
        int i24 = 8;
        int i25 = i23 ^ this.akq[7];
        if (this.c) {
            int i26 = this.akq[8] ^ (((aku[i8 >>> 24] ^ akv[(i25 >>> 16) & 255]) ^ akw[(i20 >>> 8) & 255]) ^ akx[i14 & 255]);
            int i27 = (((aku[i14 >>> 24] ^ akv[(i8 >>> 16) & 255]) ^ akw[(i25 >>> 8) & 255]) ^ akx[i20 & 255]) ^ this.akq[9];
            int i28 = (((aku[i20 >>> 24] ^ akv[(i14 >>> 16) & 255]) ^ akw[(i8 >>> 8) & 255]) ^ akx[i25 & 255]) ^ this.akq[10];
            int i29 = (((aku[i25 >>> 24] ^ akv[(i20 >>> 16) & 255]) ^ akw[(i14 >>> 8) & 255]) ^ akx[i8 & 255]) ^ this.akq[11];
            i8 = (((aku[i26 >>> 24] ^ akv[(i29 >>> 16) & 255]) ^ akw[(i28 >>> 8) & 255]) ^ akx[i27 & 255]) ^ this.akq[12];
            i14 = this.akq[13] ^ (((aku[i27 >>> 24] ^ akv[(i26 >>> 16) & 255]) ^ akw[(i29 >>> 8) & 255]) ^ akx[i28 & 255]);
            i20 = (((aku[i28 >>> 24] ^ akv[(i27 >>> 16) & 255]) ^ akw[(i26 >>> 8) & 255]) ^ akx[i29 & 255]) ^ this.akq[14];
            int i30 = ((aku[i29 >>> 24] ^ akv[(i28 >>> 16) & 255]) ^ akw[(i27 >>> 8) & 255]) ^ akx[i26 & 255];
            i24 = 16;
            i25 = i30 ^ this.akq[15];
            if (this.d) {
                int i31 = this.akq[16] ^ (((aku[i8 >>> 24] ^ akv[(i25 >>> 16) & 255]) ^ akw[(i20 >>> 8) & 255]) ^ akx[i14 & 255]);
                int i32 = (((aku[i14 >>> 24] ^ akv[(i8 >>> 16) & 255]) ^ akw[(i25 >>> 8) & 255]) ^ akx[i20 & 255]) ^ this.akq[17];
                int i33 = (((aku[i20 >>> 24] ^ akv[(i14 >>> 16) & 255]) ^ akw[(i8 >>> 8) & 255]) ^ akx[i25 & 255]) ^ this.akq[18];
                int i34 = (((aku[i25 >>> 24] ^ akv[(i20 >>> 16) & 255]) ^ akw[(i14 >>> 8) & 255]) ^ akx[i8 & 255]) ^ this.akq[19];
                i8 = (((aku[i31 >>> 24] ^ akv[(i34 >>> 16) & 255]) ^ akw[(i33 >>> 8) & 255]) ^ akx[i32 & 255]) ^ this.akq[20];
                i14 = this.akq[21] ^ (((aku[i32 >>> 24] ^ akv[(i31 >>> 16) & 255]) ^ akw[(i34 >>> 8) & 255]) ^ akx[i33 & 255]);
                i20 = (((aku[i33 >>> 24] ^ akv[(i32 >>> 16) & 255]) ^ akw[(i31 >>> 8) & 255]) ^ akx[i34 & 255]) ^ this.akq[22];
                int i35 = ((aku[i34 >>> 24] ^ akv[(i33 >>> 16) & 255]) ^ akw[(i32 >>> 8) & 255]) ^ akx[i31 & 255];
                i24 = 24;
                i25 = i35 ^ this.akq[23];
            }
        }
        int i36 = i24 + 1;
        int i37 = this.akq[i24] ^ (((aku[i8 >>> 24] ^ akv[(i25 >>> 16) & 255]) ^ akw[(i20 >>> 8) & 255]) ^ akx[i14 & 255]);
        int i38 = i36 + 1;
        int i39 = (((aku[i14 >>> 24] ^ akv[(i8 >>> 16) & 255]) ^ akw[(i25 >>> 8) & 255]) ^ akx[i20 & 255]) ^ this.akq[i36];
        int i40 = i38 + 1;
        int i41 = (((aku[i20 >>> 24] ^ akv[(i14 >>> 16) & 255]) ^ akw[(i8 >>> 8) & 255]) ^ akx[i25 & 255]) ^ this.akq[i38];
        int i42 = i40 + 1;
        int i43 = (((aku[i25 >>> 24] ^ akv[(i20 >>> 16) & 255]) ^ akw[(i14 >>> 8) & 255]) ^ akx[i8 & 255]) ^ this.akq[i40];
        int i44 = i42 + 1;
        int i45 = (((aku[i37 >>> 24] ^ akv[(i43 >>> 16) & 255]) ^ akw[(i41 >>> 8) & 255]) ^ akx[i39 & 255]) ^ this.akq[i42];
        int i46 = i44 + 1;
        int i47 = (((aku[i39 >>> 24] ^ akv[(i37 >>> 16) & 255]) ^ akw[(i43 >>> 8) & 255]) ^ akx[i41 & 255]) ^ this.akq[i44];
        int i48 = i46 + 1;
        int i49 = (((aku[i41 >>> 24] ^ akv[(i39 >>> 16) & 255]) ^ akw[(i37 >>> 8) & 255]) ^ akx[i43 & 255]) ^ this.akq[i46];
        int i50 = i48 + 1;
        int i51 = (((aku[i43 >>> 24] ^ akv[(i41 >>> 16) & 255]) ^ akw[(i39 >>> 8) & 255]) ^ akx[i37 & 255]) ^ this.akq[i48];
        int i52 = i50 + 1;
        int i53 = (((aku[i45 >>> 24] ^ akv[(i51 >>> 16) & 255]) ^ akw[(i49 >>> 8) & 255]) ^ akx[i47 & 255]) ^ this.akq[i50];
        int i54 = i52 + 1;
        int i55 = (((aku[i47 >>> 24] ^ akv[(i45 >>> 16) & 255]) ^ akw[(i51 >>> 8) & 255]) ^ akx[i49 & 255]) ^ this.akq[i52];
        int i56 = i54 + 1;
        int i57 = (((aku[i49 >>> 24] ^ akv[(i47 >>> 16) & 255]) ^ akw[(i45 >>> 8) & 255]) ^ akx[i51 & 255]) ^ this.akq[i54];
        int i58 = i56 + 1;
        int i59 = (((aku[i51 >>> 24] ^ akv[(i49 >>> 16) & 255]) ^ akw[(i47 >>> 8) & 255]) ^ akx[i45 & 255]) ^ this.akq[i56];
        int i60 = i58 + 1;
        int i61 = (((aku[i53 >>> 24] ^ akv[(i59 >>> 16) & 255]) ^ akw[(i57 >>> 8) & 255]) ^ akx[i55 & 255]) ^ this.akq[i58];
        int i62 = i60 + 1;
        int i63 = (((aku[i55 >>> 24] ^ akv[(i53 >>> 16) & 255]) ^ akw[(i59 >>> 8) & 255]) ^ akx[i57 & 255]) ^ this.akq[i60];
        int i64 = i62 + 1;
        int i65 = (((aku[i57 >>> 24] ^ akv[(i55 >>> 16) & 255]) ^ akw[(i53 >>> 8) & 255]) ^ akx[i59 & 255]) ^ this.akq[i62];
        int i66 = i64 + 1;
        int i67 = (((aku[i59 >>> 24] ^ akv[(i57 >>> 16) & 255]) ^ akw[(i55 >>> 8) & 255]) ^ akx[i53 & 255]) ^ this.akq[i64];
        int i68 = i66 + 1;
        int i69 = (((aku[i61 >>> 24] ^ akv[(i67 >>> 16) & 255]) ^ akw[(i65 >>> 8) & 255]) ^ akx[i63 & 255]) ^ this.akq[i66];
        int i70 = i68 + 1;
        int i71 = (((aku[i63 >>> 24] ^ akv[(i61 >>> 16) & 255]) ^ akw[(i67 >>> 8) & 255]) ^ akx[i65 & 255]) ^ this.akq[i68];
        int i72 = i70 + 1;
        int i73 = (((aku[i65 >>> 24] ^ akv[(i63 >>> 16) & 255]) ^ akw[(i61 >>> 8) & 255]) ^ akx[i67 & 255]) ^ this.akq[i70];
        int i74 = i72 + 1;
        int i75 = (((aku[i67 >>> 24] ^ akv[(i65 >>> 16) & 255]) ^ akw[(i63 >>> 8) & 255]) ^ akx[i61 & 255]) ^ this.akq[i72];
        int i76 = i74 + 1;
        int i77 = (((aku[i69 >>> 24] ^ akv[(i75 >>> 16) & 255]) ^ akw[(i73 >>> 8) & 255]) ^ akx[i71 & 255]) ^ this.akq[i74];
        int i78 = i76 + 1;
        int i79 = (((aku[i71 >>> 24] ^ akv[(i69 >>> 16) & 255]) ^ akw[(i75 >>> 8) & 255]) ^ akx[i73 & 255]) ^ this.akq[i76];
        int i80 = i78 + 1;
        int i81 = (((aku[i73 >>> 24] ^ akv[(i71 >>> 16) & 255]) ^ akw[(i69 >>> 8) & 255]) ^ akx[i75 & 255]) ^ this.akq[i78];
        int i82 = i80 + 1;
        int i83 = (((aku[i75 >>> 24] ^ akv[(i73 >>> 16) & 255]) ^ akw[(i71 >>> 8) & 255]) ^ akx[i69 & 255]) ^ this.akq[i80];
        int i84 = i82 + 1;
        int i85 = (((aku[i77 >>> 24] ^ akv[(i83 >>> 16) & 255]) ^ akw[(i81 >>> 8) & 255]) ^ akx[i79 & 255]) ^ this.akq[i82];
        int i86 = i84 + 1;
        int i87 = (((aku[i79 >>> 24] ^ akv[(i77 >>> 16) & 255]) ^ akw[(i83 >>> 8) & 255]) ^ akx[i81 & 255]) ^ this.akq[i84];
        int i88 = i86 + 1;
        int i89 = (((aku[i81 >>> 24] ^ akv[(i79 >>> 16) & 255]) ^ akw[(i77 >>> 8) & 255]) ^ akx[i83 & 255]) ^ this.akq[i86];
        int i90 = i88 + 1;
        int i91 = (((aku[i83 >>> 24] ^ akv[(i81 >>> 16) & 255]) ^ akw[(i79 >>> 8) & 255]) ^ akx[i77 & 255]) ^ this.akq[i88];
        int i92 = i90 + 1;
        int i93 = (((aku[i85 >>> 24] ^ akv[(i91 >>> 16) & 255]) ^ akw[(i89 >>> 8) & 255]) ^ akx[i87 & 255]) ^ this.akq[i90];
        int i94 = i92 + 1;
        int i95 = (((aku[i87 >>> 24] ^ akv[(i85 >>> 16) & 255]) ^ akw[(i91 >>> 8) & 255]) ^ akx[i89 & 255]) ^ this.akq[i92];
        int i96 = i94 + 1;
        int i97 = (((aku[i89 >>> 24] ^ akv[(i87 >>> 16) & 255]) ^ akw[(i85 >>> 8) & 255]) ^ akx[i91 & 255]) ^ this.akq[i94];
        int i98 = i96 + 1;
        int i99 = (((aku[i91 >>> 24] ^ akv[(i89 >>> 16) & 255]) ^ akw[(i87 >>> 8) & 255]) ^ akx[i85 & 255]) ^ this.akq[i96];
        int i100 = i98 + 1;
        int i101 = (((aku[i93 >>> 24] ^ akv[(i99 >>> 16) & 255]) ^ akw[(i97 >>> 8) & 255]) ^ akx[i95 & 255]) ^ this.akq[i98];
        int i102 = i100 + 1;
        int i103 = (((aku[i95 >>> 24] ^ akv[(i93 >>> 16) & 255]) ^ akw[(i99 >>> 8) & 255]) ^ akx[i97 & 255]) ^ this.akq[i100];
        int i104 = i102 + 1;
        int i105 = (((aku[i97 >>> 24] ^ akv[(i95 >>> 16) & 255]) ^ akw[(i93 >>> 8) & 255]) ^ akx[i99 & 255]) ^ this.akq[i102];
        int i106 = i104 + 1;
        int i107 = (((aku[i99 >>> 24] ^ akv[(i97 >>> 16) & 255]) ^ akw[(i95 >>> 8) & 255]) ^ akx[i93 & 255]) ^ this.akq[i104];
        int i108 = this.akq[0];
        int i109 = i3 + 1;
        bArr2[i3] = (byte) (k[i101 >>> 24] ^ (i108 >>> 24));
        int i110 = i109 + 1;
        bArr2[i109] = (byte) (k[(i107 >>> 16) & 255] ^ (i108 >>> 16));
        int i111 = i110 + 1;
        bArr2[i110] = (byte) (k[(i105 >>> 8) & 255] ^ (i108 >>> 8));
        int i112 = i111 + 1;
        bArr2[i111] = (byte) (i108 ^ k[i103 & 255]);
        int i113 = this.akq[1];
        int i114 = i112 + 1;
        bArr2[i112] = (byte) (k[i103 >>> 24] ^ (i113 >>> 24));
        int i115 = i114 + 1;
        bArr2[i114] = (byte) (k[(i101 >>> 16) & 255] ^ (i113 >>> 16));
        int i116 = i115 + 1;
        bArr2[i115] = (byte) (k[(i107 >>> 8) & 255] ^ (i113 >>> 8));
        int i117 = i116 + 1;
        bArr2[i116] = (byte) (i113 ^ k[i105 & 255]);
        int i118 = this.akq[2];
        int i119 = i117 + 1;
        bArr2[i117] = (byte) (k[i105 >>> 24] ^ (i118 >>> 24));
        int i120 = i119 + 1;
        bArr2[i119] = (byte) (k[(i103 >>> 16) & 255] ^ (i118 >>> 16));
        int i121 = i120 + 1;
        bArr2[i120] = (byte) (k[(i101 >>> 8) & 255] ^ (i118 >>> 8));
        int i122 = i121 + 1;
        bArr2[i121] = (byte) (i118 ^ k[i107 & 255]);
        int i123 = this.akq[3];
        int i124 = i122 + 1;
        bArr2[i122] = (byte) (k[i107 >>> 24] ^ (i123 >>> 24));
        int i125 = i124 + 1;
        bArr2[i124] = (byte) (k[(i105 >>> 16) & 255] ^ (i123 >>> 16));
        bArr2[i125] = (byte) (k[(i103 >>> 8) & 255] ^ (i123 >>> 8));
        bArr2[i125 + 1] = (byte) (k[i101 & 255] ^ i123);
    }
}
