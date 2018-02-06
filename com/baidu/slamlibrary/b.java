package com.baidu.slamlibrary;

import android.opengl.Matrix;
import android.util.Log;
/* loaded from: classes3.dex */
public class b {
    a a;
    float[] b = new float[3];
    boolean c = false;
    float d = 0.0f;
    float[] e = {-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    float f = 0.0f;
    private boolean g;
    private boolean h;
    private float i;
    private com.baidu.ar.a.d.a j;

    public b(int i, int i2, boolean z) {
        this.h = true;
        com.baidu.ar.util.b.a(false);
        this.a = a.a(i, i2, z);
        this.a.b = i2;
        this.a.a = i;
        this.h = this.a.b() ? false : true;
        this.j = new com.baidu.ar.a.d.a();
    }

    public static int a(byte[] bArr, int i, int i2) {
        return ARAlgoJniClient.slamPlaneQuality(bArr, i, i2);
    }

    private void a(float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[16];
        float[] fArr4 = new float[16];
        Matrix.invertM(fArr3, 0, fArr2, 0);
        Matrix.multiplyMM(fArr4, 0, this.e, 0, fArr3, 0);
        Matrix.invertM(fArr3, 0, fArr4, 0);
        fArr[0] = fArr3[0];
        fArr[1] = fArr3[1];
        fArr[2] = fArr3[2];
        fArr[4] = fArr3[4];
        fArr[5] = fArr3[5];
        fArr[6] = fArr3[6];
        fArr[8] = fArr3[8];
        fArr[9] = fArr3[9];
        fArr[10] = fArr3[10];
        float a = this.a.a();
        float f = fArr[12] * this.i * a;
        float f2 = fArr[13] * this.i * a;
        fArr[12] = f;
        fArr[13] = f2;
        fArr[14] = a * fArr[14] * this.i;
        Log.e("hanyong", "angle = " + this.f);
        Matrix.rotateM(fArr, 0, this.f, 0.0f, 0.0f, 1.0f);
    }

    private float[] a(float[] fArr) {
        if (this.f == 0.0f) {
            this.f = com.baidu.ar.d.b.l;
        }
        float[] fArr2 = new float[16];
        float[] fArr3 = new float[16];
        Matrix.invertM(fArr2, 0, fArr, 0);
        Matrix.multiplyMM(fArr3, 0, this.e, 0, fArr2, 0);
        return new float[]{-fArr3[4], -fArr3[5], -fArr3[6], -fArr3[0], -fArr3[1], -fArr3[2], -fArr3[8], -fArr3[9], -fArr3[10], 0.0f, 0.0f, 0.0f};
    }

    public int a(int i) {
        return this.j.a(i);
    }

    public TrackParams a(byte[] bArr, float[] fArr) {
        if (!this.g) {
            com.baidu.ar.util.b.d("addFrame before start");
            return new TrackParams();
        }
        TrackParams slamTrack = ARAlgoJniClient.slamTrack(bArr, a(fArr));
        if (slamTrack.trackQuality != 0) {
            a(slamTrack.trans, fArr);
            return slamTrack;
        }
        return slamTrack;
    }

    public void a(float f) {
        this.i = f;
    }

    public boolean a() {
        if (this.h) {
            return false;
        }
        if (this.g) {
            return this.g;
        }
        this.g = ARAlgoJniClient.slamStart(this.a.a, this.a.b, this.a.c(), this.a.d());
        return this.g;
    }

    public void b() {
        this.f = 0.0f;
        this.c = false;
        if (this.g) {
            ARAlgoJniClient.slamReset();
        }
    }

    public void c() {
        if (this.g) {
            ARAlgoJniClient.slamStop();
            this.j.a();
        }
    }
}
