package com.baidu.ar.arplay.representation;
/* loaded from: classes.dex */
public final class Matrix {
    public static final float[] TEMP_MATRIX_ARRAY = new float[32];

    public static void frustumM(float[] fArr, int i, float f, float f2, float f3, float f4, float f5, float f6) {
        if (f == f2) {
            throw new IllegalArgumentException("left == right");
        }
        if (f4 == f3) {
            throw new IllegalArgumentException("top == bottom");
        }
        if (f5 == f6) {
            throw new IllegalArgumentException("near == far");
        }
        if (f5 <= 0.0f) {
            throw new IllegalArgumentException("near <= 0.0f");
        }
        if (f6 <= 0.0f) {
            throw new IllegalArgumentException("far <= 0.0f");
        }
        float f7 = 1.0f / (f2 - f);
        float f8 = 1.0f / (f4 - f3);
        float f9 = 1.0f / (f5 - f6);
        fArr[i + 0] = f5 * f7 * 2.0f;
        fArr[i + 5] = f5 * f8 * 2.0f;
        fArr[i + 8] = (f2 + f) * f7 * 2.0f;
        fArr[i + 9] = (f4 + f3) * f8;
        fArr[i + 10] = (f6 + f5) * f9;
        fArr[i + 14] = f6 * f5 * f9 * 2.0f;
        fArr[i + 11] = -1.0f;
        fArr[i + 1] = 0.0f;
        fArr[i + 2] = 0.0f;
        fArr[i + 3] = 0.0f;
        fArr[i + 4] = 0.0f;
        fArr[i + 6] = 0.0f;
        fArr[i + 7] = 0.0f;
        fArr[i + 12] = 0.0f;
        fArr[i + 13] = 0.0f;
        fArr[i + 15] = 0.0f;
    }

    public static boolean invertM(float[] fArr, int i, float[] fArr2, int i2) {
        float f = fArr2[i2 + 0];
        float f2 = fArr2[i2 + 1];
        float f3 = fArr2[i2 + 2];
        float f4 = fArr2[i2 + 3];
        float f5 = fArr2[i2 + 4];
        float f6 = fArr2[i2 + 5];
        float f7 = fArr2[i2 + 6];
        float f8 = fArr2[i2 + 7];
        float f9 = fArr2[i2 + 8];
        float f10 = fArr2[i2 + 9];
        float f11 = fArr2[i2 + 10];
        float f12 = fArr2[i2 + 11];
        float f13 = fArr2[i2 + 12];
        float f14 = fArr2[i2 + 13];
        float f15 = fArr2[i2 + 14];
        float f16 = fArr2[i2 + 15];
        float f17 = f11 * f16;
        float f18 = f15 * f12;
        float f19 = f7 * f16;
        float f20 = f15 * f8;
        float f21 = f7 * f12;
        float f22 = f11 * f8;
        float f23 = f3 * f16;
        float f24 = f15 * f4;
        float f25 = f3 * f12;
        float f26 = f11 * f4;
        float f27 = f3 * f8;
        float f28 = f7 * f4;
        float f29 = (((f17 * f6) + (f20 * f10)) + (f21 * f14)) - (((f18 * f6) + (f19 * f10)) + (f22 * f14));
        float f30 = (((f18 * f2) + (f23 * f10)) + (f26 * f14)) - (((f17 * f2) + (f24 * f10)) + (f25 * f14));
        float f31 = (((f19 * f2) + (f24 * f6)) + (f27 * f14)) - (((f20 * f2) + (f23 * f6)) + (f28 * f14));
        float f32 = (((f22 * f2) + (f25 * f6)) + (f28 * f10)) - (((f21 * f2) + (f26 * f6)) + (f27 * f10));
        float f33 = (((f18 * f5) + (f19 * f9)) + (f22 * f13)) - (((f17 * f5) + (f20 * f9)) + (f21 * f13));
        float f34 = (((f17 * f) + (f24 * f9)) + (f25 * f13)) - (((f18 * f) + (f23 * f9)) + (f26 * f13));
        float f35 = (((f20 * f) + (f23 * f5)) + (f28 * f13)) - (((f19 * f) + (f24 * f5)) + (f27 * f13));
        float f36 = (((f21 * f) + (f26 * f5)) + (f27 * f9)) - (((f22 * f) + (f25 * f5)) + (f28 * f9));
        float f37 = f9 * f14;
        float f38 = f13 * f10;
        float f39 = f5 * f14;
        float f40 = f13 * f6;
        float f41 = f5 * f10;
        float f42 = f9 * f6;
        float f43 = f14 * f;
        float f44 = f13 * f2;
        float f45 = f10 * f;
        float f46 = f9 * f2;
        float f47 = f6 * f;
        float f48 = f2 * f5;
        float f49 = (((f37 * f8) + (f40 * f12)) + (f41 * f16)) - (((f38 * f8) + (f39 * f12)) + (f42 * f16));
        float f50 = (((f38 * f4) + (f43 * f12)) + (f46 * f16)) - (((f37 * f4) + (f44 * f12)) + (f45 * f16));
        float f51 = (((f39 * f4) + (f44 * f8)) + (f47 * f16)) - (((f40 * f4) + (f43 * f8)) + (f16 * f48));
        float f52 = (((f42 * f4) + (f45 * f8)) + (f48 * f12)) - (((f4 * f41) + (f8 * f46)) + (f12 * f47));
        float f53 = (((f39 * f11) + (f42 * f15)) + (f38 * f7)) - (((f41 * f15) + (f37 * f7)) + (f40 * f11));
        float f54 = (((f45 * f15) + (f37 * f3)) + (f44 * f11)) - (((f43 * f11) + (f46 * f15)) + (f38 * f3));
        float f55 = (((f43 * f7) + (f48 * f15)) + (f40 * f3)) - (((f15 * f47) + (f39 * f3)) + (f44 * f7));
        float f56 = (((f47 * f11) + (f41 * f3)) + (f46 * f7)) - (((f45 * f7) + (f48 * f11)) + (f42 * f3));
        float f57 = (f * f29) + (f5 * f30) + (f9 * f31) + (f13 * f32);
        if (f57 == 0.0f) {
            return false;
        }
        float f58 = 1.0f / f57;
        fArr[i] = f29 * f58;
        fArr[i + 1] = f30 * f58;
        fArr[i + 2] = f31 * f58;
        fArr[i + 3] = f32 * f58;
        fArr[i + 4] = f33 * f58;
        fArr[i + 5] = f34 * f58;
        fArr[i + 6] = f35 * f58;
        fArr[i + 7] = f36 * f58;
        fArr[i + 8] = f49 * f58;
        fArr[i + 9] = f50 * f58;
        fArr[i + 10] = f51 * f58;
        fArr[i + 11] = f52 * f58;
        fArr[i + 12] = f53 * f58;
        fArr[i + 13] = f54 * f58;
        fArr[i + 14] = f55 * f58;
        fArr[i + 15] = f56 * f58;
        return true;
    }

    public static float length(float f, float f2, float f3) {
        return (float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
    }

    public static void multiplyMM(float[] fArr, int i, float[] fArr2, int i2, float[] fArr3, int i3) {
        int i4 = i2 + 0;
        int i5 = i3 + 0;
        int i6 = i2 + 4;
        int i7 = i3 + 1;
        int i8 = i2 + 8;
        int i9 = i3 + 2;
        int i10 = i2 + 12;
        int i11 = i3 + 3;
        fArr[i + 0] = (fArr2[i4] * fArr3[i5]) + (fArr2[i6] * fArr3[i7]) + (fArr2[i8] * fArr3[i9]) + (fArr2[i10] * fArr3[i11]);
        int i12 = i2 + 1;
        int i13 = i2 + 5;
        int i14 = i2 + 9;
        int i15 = i2 + 13;
        fArr[i + 1] = (fArr2[i12] * fArr3[i5]) + (fArr2[i13] * fArr3[i7]) + (fArr2[i14] * fArr3[i9]) + (fArr2[i15] * fArr3[i11]);
        int i16 = i2 + 2;
        int i17 = i2 + 6;
        int i18 = i2 + 10;
        int i19 = i2 + 14;
        fArr[i + 2] = (fArr2[i16] * fArr3[i5]) + (fArr2[i17] * fArr3[i7]) + (fArr2[i18] * fArr3[i9]) + (fArr2[i19] * fArr3[i11]);
        int i20 = i2 + 3;
        float f = fArr2[i20] * fArr3[i5];
        int i21 = i2 + 7;
        int i22 = i2 + 11;
        int i23 = i2 + 15;
        fArr[i + 3] = f + (fArr2[i21] * fArr3[i7]) + (fArr2[i22] * fArr3[i9]) + (fArr2[i23] * fArr3[i11]);
        int i24 = i3 + 4;
        int i25 = i3 + 5;
        int i26 = i3 + 6;
        int i27 = i3 + 7;
        fArr[i + 4] = (fArr2[i4] * fArr3[i24]) + (fArr2[i6] * fArr3[i25]) + (fArr2[i8] * fArr3[i26]) + (fArr2[i10] * fArr3[i27]);
        fArr[i + 5] = (fArr2[i12] * fArr3[i24]) + (fArr2[i13] * fArr3[i25]) + (fArr2[i14] * fArr3[i26]) + (fArr2[i15] * fArr3[i27]);
        fArr[i + 6] = (fArr2[i16] * fArr3[i24]) + (fArr2[i17] * fArr3[i25]) + (fArr2[i18] * fArr3[i26]) + (fArr2[i19] * fArr3[i27]);
        fArr[i + 7] = (fArr2[i20] * fArr3[i24]) + (fArr2[i21] * fArr3[i25]) + (fArr2[i22] * fArr3[i26]) + (fArr2[i23] * fArr3[i27]);
        int i28 = i3 + 8;
        int i29 = i3 + 9;
        int i30 = i3 + 10;
        int i31 = i3 + 11;
        fArr[i + 8] = (fArr2[i4] * fArr3[i28]) + (fArr2[i6] * fArr3[i29]) + (fArr2[i8] * fArr3[i30]) + (fArr2[i10] * fArr3[i31]);
        fArr[i + 9] = (fArr2[i12] * fArr3[i28]) + (fArr2[i13] * fArr3[i29]) + (fArr2[i14] * fArr3[i30]) + (fArr2[i15] * fArr3[i31]);
        fArr[i + 10] = (fArr2[i16] * fArr3[i28]) + (fArr2[i17] * fArr3[i29]) + (fArr2[i18] * fArr3[i30]) + (fArr2[i19] * fArr3[i31]);
        fArr[i + 11] = (fArr2[i20] * fArr3[i28]) + (fArr2[i21] * fArr3[i29]) + (fArr2[i22] * fArr3[i30]) + (fArr2[i23] * fArr3[i31]);
        int i32 = i3 + 12;
        int i33 = i3 + 13;
        float f2 = (fArr2[i4] * fArr3[i32]) + (fArr2[i6] * fArr3[i33]);
        float f3 = fArr2[i8];
        int i34 = i3 + 14;
        float f4 = f2 + (f3 * fArr3[i34]);
        float f5 = fArr2[i10];
        int i35 = i3 + 15;
        fArr[i + 12] = f4 + (f5 * fArr3[i35]);
        fArr[i + 13] = (fArr2[i12] * fArr3[i32]) + (fArr2[i13] * fArr3[i33]) + (fArr2[i14] * fArr3[i34]) + (fArr2[i15] * fArr3[i35]);
        fArr[i + 14] = (fArr2[i16] * fArr3[i32]) + (fArr2[i17] * fArr3[i33]) + (fArr2[i18] * fArr3[i34]) + (fArr2[i19] * fArr3[i35]);
        fArr[i + 15] = (fArr2[i20] * fArr3[i32]) + (fArr2[i21] * fArr3[i33]) + (fArr2[i22] * fArr3[i34]) + (fArr2[i23] * fArr3[i35]);
    }

    public static void multiplyMM(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = (fArr2[0] * fArr3[0]) + (fArr2[4] * fArr3[1]) + (fArr2[8] * fArr3[2]) + (fArr2[12] * fArr3[3]);
        fArr[1] = (fArr2[1] * fArr3[0]) + (fArr2[5] * fArr3[1]) + (fArr2[9] * fArr3[2]) + (fArr2[13] * fArr3[3]);
        fArr[2] = (fArr2[2] * fArr3[0]) + (fArr2[6] * fArr3[1]) + (fArr2[10] * fArr3[2]) + (fArr2[14] * fArr3[3]);
        fArr[3] = (fArr2[3] * fArr3[0]) + (fArr2[7] * fArr3[1]) + (fArr2[11] * fArr3[2]) + (fArr2[15] * fArr3[3]);
        fArr[4] = (fArr2[0] * fArr3[4]) + (fArr2[4] * fArr3[5]) + (fArr2[8] * fArr3[6]) + (fArr2[12] * fArr3[7]);
        fArr[5] = (fArr2[1] * fArr3[4]) + (fArr2[5] * fArr3[5]) + (fArr2[9] * fArr3[6]) + (fArr2[13] * fArr3[7]);
        fArr[6] = (fArr2[2] * fArr3[4]) + (fArr2[6] * fArr3[5]) + (fArr2[10] * fArr3[6]) + (fArr2[14] * fArr3[7]);
        fArr[7] = (fArr2[3] * fArr3[4]) + (fArr2[7] * fArr3[5]) + (fArr2[11] * fArr3[6]) + (fArr2[15] * fArr3[7]);
        fArr[8] = (fArr2[0] * fArr3[8]) + (fArr2[4] * fArr3[9]) + (fArr2[8] * fArr3[10]) + (fArr2[12] * fArr3[11]);
        fArr[9] = (fArr2[1] * fArr3[8]) + (fArr2[5] * fArr3[9]) + (fArr2[9] * fArr3[10]) + (fArr2[13] * fArr3[11]);
        fArr[10] = (fArr2[2] * fArr3[8]) + (fArr2[6] * fArr3[9]) + (fArr2[10] * fArr3[10]) + (fArr2[14] * fArr3[11]);
        fArr[11] = (fArr2[3] * fArr3[8]) + (fArr2[7] * fArr3[9]) + (fArr2[11] * fArr3[10]) + (fArr2[15] * fArr3[11]);
        fArr[12] = (fArr2[0] * fArr3[12]) + (fArr2[4] * fArr3[13]) + (fArr2[8] * fArr3[14]) + (fArr2[12] * fArr3[15]);
        fArr[13] = (fArr2[1] * fArr3[12]) + (fArr2[5] * fArr3[13]) + (fArr2[9] * fArr3[14]) + (fArr2[13] * fArr3[15]);
        fArr[14] = (fArr2[2] * fArr3[12]) + (fArr2[6] * fArr3[13]) + (fArr2[10] * fArr3[14]) + (fArr2[14] * fArr3[15]);
        fArr[15] = (fArr2[3] * fArr3[12]) + (fArr2[7] * fArr3[13]) + (fArr2[11] * fArr3[14]) + (fArr2[15] * fArr3[15]);
    }

    public static void multiplyMV(float[] fArr, int i, float[] fArr2, int i2, float[] fArr3, int i3) {
        int i4 = i3 + 0;
        int i5 = i3 + 1;
        int i6 = i3 + 2;
        int i7 = i3 + 3;
        fArr[i + 0] = (fArr2[i2 + 0] * fArr3[i4]) + (fArr2[i2 + 4] * fArr3[i5]) + (fArr2[i2 + 8] * fArr3[i6]) + (fArr2[i2 + 12] * fArr3[i7]);
        fArr[i + 1] = (fArr2[i2 + 1] * fArr3[i4]) + (fArr2[i2 + 5] * fArr3[i5]) + (fArr2[i2 + 9] * fArr3[i6]) + (fArr2[i2 + 13] * fArr3[i7]);
        fArr[i + 2] = (fArr2[i2 + 2] * fArr3[i4]) + (fArr2[i2 + 6] * fArr3[i5]) + (fArr2[i2 + 10] * fArr3[i6]) + (fArr2[i2 + 14] * fArr3[i7]);
        fArr[i + 3] = (fArr2[i2 + 3] * fArr3[i4]) + (fArr2[i2 + 7] * fArr3[i5]) + (fArr2[i2 + 11] * fArr3[i6]) + (fArr2[i2 + 15] * fArr3[i7]);
    }

    public static void multiplyMV(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = (fArr2[0] * fArr3[0]) + (fArr2[4] * fArr3[1]) + (fArr2[8] * fArr3[2]) + (fArr2[12] * fArr3[3]);
        fArr[1] = (fArr2[1] * fArr3[0]) + (fArr2[5] * fArr3[1]) + (fArr2[9] * fArr3[2]) + (fArr2[13] * fArr3[3]);
        fArr[2] = (fArr2[2] * fArr3[0]) + (fArr2[6] * fArr3[1]) + (fArr2[10] * fArr3[2]) + (fArr2[14] * fArr3[3]);
        fArr[3] = (fArr2[3] * fArr3[0]) + (fArr2[7] * fArr3[1]) + (fArr2[11] * fArr3[2]) + (fArr2[15] * fArr3[3]);
    }

    public static void multiplyMV3(float[] fArr, float[] fArr2, float[] fArr3, float f) {
        fArr[0] = (fArr2[0] * fArr3[0]) + (fArr2[4] * fArr3[1]) + (fArr2[8] * fArr3[2]) + (fArr2[12] * f);
        fArr[1] = (fArr2[1] * fArr3[0]) + (fArr2[5] * fArr3[1]) + (fArr2[9] * fArr3[2]) + (fArr2[13] * f);
        fArr[2] = (fArr2[2] * fArr3[0]) + (fArr2[6] * fArr3[1]) + (fArr2[10] * fArr3[2]) + (fArr2[14] * f);
    }

    public static void orthoM(float[] fArr, int i, float f, float f2, float f3, float f4, float f5, float f6) {
        if (f == f2) {
            throw new IllegalArgumentException("left == right");
        }
        if (f3 == f4) {
            throw new IllegalArgumentException("bottom == top");
        }
        if (f5 == f6) {
            throw new IllegalArgumentException("near == far");
        }
        float f7 = 1.0f / (f2 - f);
        float f8 = 1.0f / (f4 - f3);
        float f9 = 1.0f / (f6 - f5);
        fArr[i + 0] = f7 * 2.0f;
        fArr[i + 5] = 2.0f * f8;
        fArr[i + 10] = (-2.0f) * f9;
        fArr[i + 12] = (-(f2 + f)) * f7;
        fArr[i + 13] = (-(f4 + f3)) * f8;
        fArr[i + 14] = (-(f6 + f5)) * f9;
        fArr[i + 15] = 1.0f;
        fArr[i + 1] = 0.0f;
        fArr[i + 2] = 0.0f;
        fArr[i + 3] = 0.0f;
        fArr[i + 4] = 0.0f;
        fArr[i + 6] = 0.0f;
        fArr[i + 7] = 0.0f;
        fArr[i + 8] = 0.0f;
        fArr[i + 9] = 0.0f;
        fArr[i + 11] = 0.0f;
    }

    public static void perspectiveM(float[] fArr, int i, float f, float f2, float f3, float f4) {
        float tan = 1.0f / ((float) Math.tan(f * 0.008726646259971648d));
        float f5 = 1.0f / (f3 - f4);
        fArr[i + 0] = tan / f2;
        fArr[i + 1] = 0.0f;
        fArr[i + 2] = 0.0f;
        fArr[i + 3] = 0.0f;
        fArr[i + 4] = 0.0f;
        fArr[i + 5] = tan;
        fArr[i + 6] = 0.0f;
        fArr[i + 7] = 0.0f;
        fArr[i + 8] = 0.0f;
        fArr[i + 9] = 0.0f;
        fArr[i + 10] = (f4 + f3) * f5;
        fArr[i + 11] = -1.0f;
        fArr[i + 12] = 0.0f;
        fArr[i + 13] = 0.0f;
        fArr[i + 14] = f4 * 2.0f * f3 * f5;
        fArr[i + 15] = 0.0f;
    }

    public static void rotateM(float[] fArr, int i, float f, float f2, float f3, float f4) {
        synchronized (TEMP_MATRIX_ARRAY) {
            setRotateM(TEMP_MATRIX_ARRAY, 0, f, f2, f3, f4);
            multiplyMM(TEMP_MATRIX_ARRAY, 16, fArr, i, TEMP_MATRIX_ARRAY, 0);
            System.arraycopy(TEMP_MATRIX_ARRAY, 16, fArr, i, 16);
        }
    }

    public static void rotateM(float[] fArr, int i, float[] fArr2, int i2, float f, float f2, float f3, float f4) {
        synchronized (TEMP_MATRIX_ARRAY) {
            setRotateM(TEMP_MATRIX_ARRAY, 0, f, f2, f3, f4);
            multiplyMM(fArr, i, fArr2, i2, TEMP_MATRIX_ARRAY, 0);
        }
    }

    public static void scaleM(float[] fArr, int i, float f, float f2, float f3) {
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i + i2;
            fArr[i3] = fArr[i3] * f;
            int i4 = i3 + 4;
            fArr[i4] = fArr[i4] * f2;
            int i5 = i3 + 8;
            fArr[i5] = fArr[i5] * f3;
        }
    }

    public static void scaleM(float[] fArr, int i, float[] fArr2, int i2, float f, float f2, float f3) {
        for (int i3 = 0; i3 < 4; i3++) {
            int i4 = i + i3;
            int i5 = i2 + i3;
            fArr[i4] = fArr2[i5] * f;
            fArr[i4 + 4] = fArr2[i5 + 4] * f2;
            fArr[i4 + 8] = fArr2[i5 + 8] * f3;
            fArr[i4 + 12] = fArr2[i5 + 12];
        }
    }

    public static void setIdentityM(float[] fArr, int i) {
        for (int i2 = 0; i2 < 16; i2++) {
            fArr[i + i2] = 0.0f;
        }
        for (int i3 = 0; i3 < 16; i3 += 5) {
            fArr[i + i3] = 1.0f;
        }
    }

    public static void setLookAtM(float[] fArr, int i, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = f4 - f;
        float f11 = f5 - f2;
        float f12 = f6 - f3;
        float length = length(f10, f11, f12) != 0.0f ? 1.0f / length(f10, f11, f12) : 1.0f;
        float f13 = f10 * length;
        float f14 = f11 * length;
        float f15 = f12 * length;
        float f16 = (f14 * f9) - (f15 * f8);
        float f17 = (f15 * f7) - (f13 * f9);
        float f18 = (f13 * f8) - (f14 * f7);
        float length2 = length(f16, f17, f18) != 0.0f ? 1.0f / length(f16, f17, f18) : 1.0f;
        float f19 = f16 * length2;
        float f20 = f17 * length2;
        float f21 = f18 * length2;
        fArr[i + 0] = f19;
        fArr[i + 1] = (f20 * f15) - (f21 * f14);
        fArr[i + 2] = -f13;
        fArr[i + 3] = 0.0f;
        fArr[i + 4] = f20;
        fArr[i + 5] = (f21 * f13) - (f19 * f15);
        fArr[i + 6] = -f14;
        fArr[i + 7] = 0.0f;
        fArr[i + 8] = f21;
        fArr[i + 9] = (f19 * f14) - (f20 * f13);
        fArr[i + 10] = -f15;
        fArr[i + 11] = 0.0f;
        fArr[i + 12] = 0.0f;
        fArr[i + 13] = 0.0f;
        fArr[i + 14] = 0.0f;
        fArr[i + 15] = 1.0f;
        translateM(fArr, i, -f, -f2, -f3);
    }

    public static void setRotateEulerM(float[] fArr, int i, float f, float f2, float f3) {
        double d = f * 0.017453292f;
        float cos = (float) Math.cos(d);
        float sin = (float) Math.sin(d);
        double d2 = f2 * 0.017453292f;
        float cos2 = (float) Math.cos(d2);
        float sin2 = (float) Math.sin(d2);
        double d3 = f3 * 0.017453292f;
        float cos3 = (float) Math.cos(d3);
        float sin3 = (float) Math.sin(d3);
        float f4 = cos * sin2;
        float f5 = sin * sin2;
        fArr[i + 0] = cos2 * cos3;
        fArr[i + 1] = (-cos2) * sin3;
        fArr[i + 2] = sin2;
        fArr[i + 3] = 0.0f;
        fArr[i + 4] = (f4 * cos3) + (cos * sin3);
        fArr[i + 5] = ((-f4) * sin3) + (cos * cos3);
        fArr[i + 6] = (-sin) * cos2;
        fArr[i + 7] = 0.0f;
        fArr[i + 8] = ((-f5) * cos3) + (sin * sin3);
        fArr[i + 9] = (f5 * sin3) + (sin * cos3);
        fArr[i + 10] = cos * cos2;
        fArr[i + 11] = 0.0f;
        fArr[i + 12] = 0.0f;
        fArr[i + 13] = 0.0f;
        fArr[i + 14] = 0.0f;
        fArr[i + 15] = 1.0f;
    }

    public static void setRotateM(float[] fArr, int i, float f, float f2, float f3, float f4) {
        fArr[i + 3] = 0.0f;
        fArr[i + 7] = 0.0f;
        fArr[i + 11] = 0.0f;
        fArr[i + 12] = 0.0f;
        fArr[i + 13] = 0.0f;
        fArr[i + 14] = 0.0f;
        fArr[i + 15] = 1.0f;
        double d = f * 0.017453292f;
        float sin = (float) Math.sin(d);
        float cos = (float) Math.cos(d);
        if (1.0f == f2 && 0.0f == f3 && 0.0f == f4) {
            fArr[i + 5] = cos;
            fArr[i + 10] = cos;
            fArr[i + 6] = sin;
            fArr[i + 9] = -sin;
            fArr[i + 1] = 0.0f;
            fArr[i + 2] = 0.0f;
            fArr[i + 4] = 0.0f;
            fArr[i + 8] = 0.0f;
            fArr[i + 0] = 1.0f;
            return;
        }
        int i2 = (0.0f > f2 ? 1 : (0.0f == f2 ? 0 : -1));
        if (i2 == 0 && 1.0f == f3 && 0.0f == f4) {
            fArr[i + 0] = cos;
            fArr[i + 10] = cos;
            fArr[i + 8] = sin;
            fArr[i + 2] = -sin;
            fArr[i + 1] = 0.0f;
            fArr[i + 4] = 0.0f;
            fArr[i + 6] = 0.0f;
            fArr[i + 9] = 0.0f;
            fArr[i + 5] = 1.0f;
        } else if (i2 == 0 && 0.0f == f3 && 1.0f == f4) {
            fArr[i + 0] = cos;
            fArr[i + 5] = cos;
            fArr[i + 1] = sin;
            fArr[i + 4] = -sin;
            fArr[i + 2] = 0.0f;
            fArr[i + 6] = 0.0f;
            fArr[i + 8] = 0.0f;
            fArr[i + 9] = 0.0f;
            fArr[i + 10] = 1.0f;
        } else {
            float length = length(f2, f3, f4);
            if (1.0f != length) {
                float f5 = 1.0f / length;
                f2 *= f5;
                f3 *= f5;
                f4 *= f5;
            }
            float f6 = 1.0f - cos;
            float f7 = f2 * sin;
            float f8 = f3 * sin;
            float f9 = sin * f4;
            fArr[i + 0] = (f2 * f2 * f6) + cos;
            float f10 = f2 * f3 * f6;
            fArr[i + 4] = f10 - f9;
            float f11 = f4 * f2 * f6;
            fArr[i + 8] = f11 + f8;
            fArr[i + 1] = f10 + f9;
            fArr[i + 5] = (f3 * f3 * f6) + cos;
            float f12 = f3 * f4 * f6;
            fArr[i + 9] = f12 - f7;
            fArr[i + 2] = f11 - f8;
            fArr[i + 6] = f12 + f7;
            fArr[i + 10] = (f4 * f4 * f6) + cos;
        }
    }

    public static void translateM(float[] fArr, int i, float f, float f2, float f3) {
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i + i2;
            int i4 = i3 + 12;
            fArr[i4] = fArr[i4] + (fArr[i3] * f) + (fArr[i3 + 4] * f2) + (fArr[i3 + 8] * f3);
        }
    }

    public static void translateM(float[] fArr, int i, float[] fArr2, int i2, float f, float f2, float f3) {
        for (int i3 = 0; i3 < 12; i3++) {
            fArr[i + i3] = fArr2[i2 + i3];
        }
        for (int i4 = 0; i4 < 4; i4++) {
            int i5 = i2 + i4;
            fArr[i + i4 + 12] = (fArr2[i5] * f) + (fArr2[i5 + 4] * f2) + (fArr2[i5 + 8] * f3) + fArr2[i5 + 12];
        }
    }

    public static void transposeM(float[] fArr, int i, float[] fArr2, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            int i4 = (i3 * 4) + i2;
            fArr[i3 + i] = fArr2[i4];
            fArr[i3 + 4 + i] = fArr2[i4 + 1];
            fArr[i3 + 8 + i] = fArr2[i4 + 2];
            fArr[i3 + 12 + i] = fArr2[i4 + 3];
        }
    }
}
