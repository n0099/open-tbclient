package com.baidu.mario.gldraw2d.params;

import android.opengl.Matrix;
/* loaded from: classes11.dex */
public class b implements Cloneable {
    private float[] aJG;
    private boolean aJH;
    private boolean aJI;
    private float[] mMVPMatrix = new float[16];
    private long mTimestamp;

    public b() {
        Matrix.setIdentityM(this.mMVPMatrix, 0);
        this.aJG = new float[16];
        Matrix.setIdentityM(this.aJG, 0);
        this.aJH = false;
        this.aJI = false;
    }

    public float[] Cw() {
        return this.mMVPMatrix;
    }

    public void e(float[] fArr) {
        this.mMVPMatrix = fArr;
    }

    public float[] Cx() {
        return this.aJG;
    }

    public void f(float[] fArr) {
        this.aJG = fArr;
    }

    public boolean Cy() {
        return this.aJH;
    }

    public boolean Cz() {
        return this.aJI;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: CA */
    public b clone() {
        b bVar = null;
        try {
            bVar = (b) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if (bVar != null) {
            bVar.e((float[]) this.mMVPMatrix.clone());
            bVar.f((float[]) this.aJG.clone());
        }
        return bVar;
    }
}
