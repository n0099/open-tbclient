package com.baidu.ar.recorder.b;

import android.opengl.Matrix;
/* loaded from: classes3.dex */
public class b {
    private static final String a = b.class.getSimpleName();
    private final float[] b = new float[16];
    private com.baidu.ar.recorder.e.a c;
    private d d;
    private com.baidu.ar.recorder.filter.c e;

    public b(com.baidu.ar.recorder.e.a aVar, d dVar, com.baidu.ar.recorder.filter.c cVar) {
        this.c = aVar;
        this.d = dVar;
        this.e = cVar;
        Matrix.setIdentityM(this.b, 0);
    }

    public void a() {
        Matrix.setIdentityM(this.b, 0);
        if (this.d.f() == 1) {
            Matrix.rotateM(this.b, 0, 180.0f, 0.0f, 1.0f, 0.0f);
        } else if (this.d.f() == 2) {
            Matrix.rotateM(this.b, 0, 180.0f, 1.0f, 0.0f, 0.0f);
        }
        Matrix.rotateM(this.b, 0, this.d.c(), 0.0f, 0.0f, 1.0f);
        Matrix.scaleM(this.b, 0, this.d.d(), this.d.e(), 1.0f);
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
}
