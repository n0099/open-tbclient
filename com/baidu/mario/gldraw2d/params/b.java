package com.baidu.mario.gldraw2d.params;

import android.opengl.Matrix;
/* loaded from: classes2.dex */
public class b implements Cloneable {
    private float[] axg;
    private boolean axh;
    private boolean axi;
    private float[] iQ = new float[16];
    private long mTimestamp;

    public b() {
        Matrix.setIdentityM(this.iQ, 0);
        this.axg = new float[16];
        Matrix.setIdentityM(this.axg, 0);
        this.axh = false;
        this.axi = false;
    }

    public float[] xL() {
        return this.iQ;
    }

    public void e(float[] fArr) {
        this.iQ = fArr;
    }

    public float[] xM() {
        return this.axg;
    }

    public void f(float[] fArr) {
        this.axg = fArr;
    }

    public boolean xN() {
        return this.axh;
    }

    public boolean xO() {
        return this.axi;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: xP */
    public b clone() {
        b bVar = null;
        try {
            bVar = (b) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if (bVar != null) {
            bVar.e((float[]) this.iQ.clone());
            bVar.f((float[]) this.axg.clone());
        }
        return bVar;
    }
}
