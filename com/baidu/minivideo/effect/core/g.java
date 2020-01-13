package com.baidu.minivideo.effect.core;
/* loaded from: classes12.dex */
class g {
    public static final float[] a = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final float[] b = {1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};
    public static final float[] c = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    public static final float[] d = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    private static float a(float f) {
        return f == 0.0f ? 1.0f : 0.0f;
    }

    public static float[] b(Rotation rotation, boolean z, boolean z2) {
        float[] fArr;
        switch (rotation) {
            case ROTATION_90:
                fArr = b;
                break;
            case ROTATION_180:
                fArr = c;
                break;
            case ROTATION_270:
                fArr = d;
                break;
            default:
                fArr = a;
                break;
        }
        float[] fArr2 = z ? new float[]{a(fArr[0]), fArr[1], a(fArr[2]), fArr[3], a(fArr[4]), fArr[5], a(fArr[6]), fArr[7]} : fArr;
        return z2 ? new float[]{fArr2[0], a(fArr2[1]), fArr2[2], a(fArr2[3]), fArr2[4], a(fArr2[5]), fArr2[6], a(fArr2[7])} : fArr2;
    }
}
