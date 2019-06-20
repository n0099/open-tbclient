package com.baidu.mario.gldraw2d.params;

import android.opengl.Matrix;
/* loaded from: classes2.dex */
public class b implements Cloneable {
    private float[] adl;
    private boolean adm;
    private boolean adn;
    private float[] mMVPMatrix = new float[16];
    private long mTimestamp;

    public b() {
        Matrix.setIdentityM(this.mMVPMatrix, 0);
        this.adl = new float[16];
        Matrix.setIdentityM(this.adl, 0);
        this.adm = false;
        this.adn = false;
    }

    public float[] ss() {
        return this.mMVPMatrix;
    }

    public void e(float[] fArr) {
        this.mMVPMatrix = fArr;
    }

    public float[] st() {
        return this.adl;
    }

    public void f(float[] fArr) {
        this.adl = fArr;
    }

    public boolean su() {
        return this.adm;
    }

    public boolean sv() {
        return this.adn;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: sw */
    public b clone() {
        b bVar = null;
        try {
            bVar = (b) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if (bVar != null) {
            bVar.e((float[]) this.mMVPMatrix.clone());
            bVar.f((float[]) this.adl.clone());
        }
        return bVar;
    }
}
