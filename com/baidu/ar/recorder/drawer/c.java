package com.baidu.ar.recorder.drawer;

import android.opengl.Matrix;
/* loaded from: classes3.dex */
public class c {
    private static final String a = c.class.getSimpleName();
    private final float[] b = new float[16];
    private com.baidu.ar.recorder.c.a c;
    private RectDrawableParams d;
    private com.baidu.ar.recorder.filter.c e;

    public c(com.baidu.ar.recorder.c.a aVar, RectDrawableParams rectDrawableParams, com.baidu.ar.recorder.filter.c cVar) {
        this.c = aVar;
        this.d = rectDrawableParams;
        this.e = cVar;
        Matrix.setIdentityM(this.b, 0);
    }

    public com.baidu.ar.recorder.filter.c a() {
        return this.e;
    }

    public void a(int i, float[] fArr) {
        a(i, fArr, false, false);
    }

    public void a(int i, float[] fArr, boolean z, boolean z2) {
        this.e.a(this.b, this.c.a(), 0, this.c.c(), this.c.f(), this.c.d(), fArr, this.c.b(), i, this.c.e(), z, z2);
    }

    public void a(com.baidu.ar.recorder.filter.c cVar) {
        this.e.g();
        this.e = cVar;
    }

    public void a(boolean z) {
        if (this.e != null) {
            if (z) {
                this.e.g();
            }
            this.e = null;
        }
    }

    public int b() {
        return com.baidu.ar.recorder.c.d.a(this.e.f());
    }

    public void c() {
        Matrix.setIdentityM(this.b, 0);
        if (this.d.i() == 1) {
            Matrix.rotateM(this.b, 0, 180.0f, 0.0f, 1.0f, 0.0f);
        } else if (this.d.i() == 2) {
            Matrix.rotateM(this.b, 0, 180.0f, 1.0f, 0.0f, 0.0f);
        }
        Matrix.rotateM(this.b, 0, this.d.f(), 0.0f, 0.0f, 1.0f);
        Matrix.scaleM(this.b, 0, this.d.g(), this.d.h(), 1.0f);
    }
}
