package com.baidu.mario.gldraw2d.params;

import android.opengl.Matrix;
/* loaded from: classes10.dex */
public class b implements Cloneable {
    private float[] aFk;
    private boolean aFl;
    private boolean aFm;
    private float[] kE = new float[16];
    private long mTimestamp;

    public b() {
        Matrix.setIdentityM(this.kE, 0);
        this.aFk = new float[16];
        Matrix.setIdentityM(this.aFk, 0);
        this.aFl = false;
        this.aFm = false;
    }

    public float[] zX() {
        return this.kE;
    }

    public void e(float[] fArr) {
        this.kE = fArr;
    }

    public float[] zY() {
        return this.aFk;
    }

    public void f(float[] fArr) {
        this.aFk = fArr;
    }

    public boolean zZ() {
        return this.aFl;
    }

    public boolean Aa() {
        return this.aFm;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Ab */
    public b clone() {
        b bVar = null;
        try {
            bVar = (b) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if (bVar != null) {
            bVar.e((float[]) this.kE.clone());
            bVar.f((float[]) this.aFk.clone());
        }
        return bVar;
    }
}
