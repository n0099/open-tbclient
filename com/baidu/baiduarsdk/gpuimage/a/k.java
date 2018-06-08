package com.baidu.baiduarsdk.gpuimage.a;

import android.opengl.Matrix;
/* loaded from: classes3.dex */
public class k extends b {
    public k() {
        this.a = (float[]) com.baidu.baiduarsdk.gpuimage.graphics.a.a.clone();
    }

    private void a(float[] fArr, float f) {
        a(new float[]{((1.0f - f) * 0.3f) + f, (1.0f - f) * 0.3f, 0.3f * (1.0f - f), 0.0f, (1.0f - f) * 0.59f, ((1.0f - f) * 0.59f) + f, 0.59f * (1.0f - f), 0.0f, (1.0f - f) * 0.11f, (1.0f - f) * 0.11f, (0.11f * (1.0f - f)) + f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f}, (float[]) fArr.clone(), fArr);
    }

    private void a(float[] fArr, float[] fArr2) {
        fArr[0] = fArr2[0];
        fArr[5] = fArr2[1];
        fArr[10] = fArr2[2];
    }

    private void a(float[] fArr, float[] fArr2, float[] fArr3) {
        Matrix.multiplyMM(fArr3, 0, fArr, 0, fArr2, 0);
    }

    private void b(float[] fArr, float f) {
        Matrix.rotateM(fArr, 0, f, 0.3f, 0.59f, 0.11f);
    }

    private void k() {
        a(this.a);
    }

    public void b(float f) {
        b(this.a, f);
        k();
    }

    public void c(float f) {
        a(this.a, f);
        k();
    }

    public void d(float f) {
        a(this.a, new float[]{f, f, f});
        k();
    }
}
