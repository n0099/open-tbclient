package com.baidu.baiduarsdk.gpuimage.a;
/* loaded from: classes3.dex */
public class o extends b {
    private float k;

    public void b(float f) {
        this.k = f;
        float f2 = this.k;
        float f3 = 0.213f * (1.0f - f2);
        float f4 = 0.715f * (1.0f - f2);
        float f5 = 0.072f * (1.0f - f2);
        System.arraycopy(new float[]{f3 + f2, f4, f5, 0.0f, f3, f4 + f2, f5, 0.0f, f3, f4, f2 + f5, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f}, 0, this.a, 0, 16);
        a(this.a);
    }
}
