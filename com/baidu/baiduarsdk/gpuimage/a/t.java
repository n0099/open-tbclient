package com.baidu.baiduarsdk.gpuimage.a;

import android.opengl.GLES20;
/* loaded from: classes3.dex */
public class t extends s {
    public t(String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
    }

    @Override // com.baidu.baiduarsdk.gpuimage.a.h, com.baidu.baiduarsdk.gpuimage.a.g
    public void a() {
        super.a();
        o();
    }

    @Override // com.baidu.baiduarsdk.gpuimage.a.h, com.baidu.baiduarsdk.gpuimage.a.g
    public void a(int i, int i2) {
        super.a(i, i2);
        o();
    }

    public float m() {
        return 1.0f;
    }

    public float n() {
        return 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o() {
        if (this.i <= 0 || this.j <= 0) {
            return;
        }
        float n = n();
        g gVar = this.a.get(0);
        int glGetUniformLocation = GLES20.glGetUniformLocation(gVar.h(), "texelWidthOffset");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(gVar.h(), "texelHeightOffset");
        gVar.a(glGetUniformLocation, n / this.i);
        gVar.a(glGetUniformLocation2, 0.0f);
        float m = m();
        g gVar2 = this.a.get(1);
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(gVar2.h(), "texelWidthOffset");
        int glGetUniformLocation4 = GLES20.glGetUniformLocation(gVar2.h(), "texelHeightOffset");
        gVar2.a(glGetUniformLocation3, 0.0f);
        gVar2.a(glGetUniformLocation4, m / this.j);
    }
}
