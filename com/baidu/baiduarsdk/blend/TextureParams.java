package com.baidu.baiduarsdk.blend;

import android.opengl.Matrix;
/* loaded from: classes3.dex */
public class TextureParams {
    private boolean a = true;
    private boolean b = true;
    private boolean c = true;
    private float d = 0.0f;
    private int e = 0;
    private float f = 0.0f;
    private float g = 1.0f;
    private float h = 1.0f;
    private SourceType i = SourceType.SURFACE_TEXTURE;
    private final float[] j = new float[16];

    /* loaded from: classes3.dex */
    public enum SourceType {
        NONE("none"),
        SURFACE_TEXTURE("surfacetexture"),
        YUV_DATA("yuv");
        
        private final String mValue;

        SourceType(String str) {
            this.mValue = str;
        }
    }

    private void f() {
        Matrix.setIdentityM(this.j, 0);
        if (this.i == SourceType.YUV_DATA) {
            if (this.e == 1) {
                Matrix.rotateM(this.j, 0, 180.0f, 0.0f, 1.0f, 0.0f);
            } else if (this.e == 2) {
                Matrix.rotateM(this.j, 0, 180.0f, 1.0f, 0.0f, 0.0f);
            }
            Matrix.rotateM(this.j, 0, this.f, 0.0f, 0.0f, 1.0f);
            Matrix.scaleM(this.j, 0, this.g, this.h, 1.0f);
        }
    }

    public void a(int i, float f, float f2, float f3, SourceType sourceType) {
        this.e = i;
        this.f = f;
        this.g = f2;
        this.h = f3;
        this.i = sourceType;
        f();
    }

    public void a(boolean z) {
        this.a = z;
    }

    public void a(boolean z, float f) {
        this.c = z;
        this.d = f;
    }

    public float[] a() {
        return this.j;
    }

    public boolean b() {
        return this.a;
    }

    public boolean c() {
        return this.c;
    }

    public float d() {
        return this.d;
    }

    public SourceType e() {
        return this.i;
    }
}
