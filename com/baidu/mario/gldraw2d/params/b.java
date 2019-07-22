package com.baidu.mario.gldraw2d.params;

import android.opengl.Matrix;
/* loaded from: classes2.dex */
public class b implements Cloneable {
    private float[] adI;
    private boolean adJ;
    private boolean adK;
    private long mTimestamp;
    private float[] qA = new float[16];

    public b() {
        Matrix.setIdentityM(this.qA, 0);
        this.adI = new float[16];
        Matrix.setIdentityM(this.adI, 0);
        this.adJ = false;
        this.adK = false;
    }

    public float[] sQ() {
        return this.qA;
    }

    public void e(float[] fArr) {
        this.qA = fArr;
    }

    public float[] sR() {
        return this.adI;
    }

    public void f(float[] fArr) {
        this.adI = fArr;
    }

    public boolean sS() {
        return this.adJ;
    }

    public boolean sT() {
        return this.adK;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: sU */
    public b clone() {
        b bVar = null;
        try {
            bVar = (b) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if (bVar != null) {
            bVar.e((float[]) this.qA.clone());
            bVar.f((float[]) this.adI.clone());
        }
        return bVar;
    }
}
