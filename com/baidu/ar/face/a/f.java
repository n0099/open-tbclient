package com.baidu.ar.face.a;
/* loaded from: classes3.dex */
public class f {
    private int nT = 300;
    private int nU = 0;
    private int nV = 0;
    private int nW = 0;
    private int nX = 0;
    private int nY = 0;
    private int nZ = 0;
    private double oa;
    private double ob;
    private double oc;
    private double od;
    private double oe;
    private double of;

    public void a(double d) {
        if (this.nU < this.nT) {
            this.nU++;
            this.ob = (((this.nU - 1) * this.ob) + d) / this.nU;
            return;
        }
        if (this.nU == this.nT) {
            this.nU++;
        }
        this.nU = 0;
        this.ob = 0.0d;
    }

    public void b(double d) {
        if (this.nV < this.nT) {
            this.nV++;
            this.oa = (((this.nV - 1) * this.oa) + d) / this.nV;
            return;
        }
        if (this.nV == this.nT) {
            this.nV++;
        }
        this.nV = 0;
        this.oa = 0.0d;
    }

    public void c(double d) {
        if (this.nW < this.nT) {
            this.nW++;
            this.oc = (((this.nW - 1) * this.oc) + d) / this.nW;
            return;
        }
        if (this.nW == this.nT) {
            this.nW++;
        }
        this.nW = 0;
        this.oc = 0.0d;
    }

    public void d(double d) {
        if (this.nX < this.nT) {
            this.nX++;
            this.od = (((this.nX - 1) * this.od) + d) / this.nX;
            return;
        }
        if (this.nX == this.nT) {
            this.nX++;
        }
        this.nX = 0;
        this.od = 0.0d;
    }

    public void dd() {
        this.nU = 0;
        this.nV = 0;
        this.nW = 0;
        this.nX = 0;
        this.nY = 0;
        this.nZ = 0;
    }

    public void e(double d) {
        if (this.nY < this.nT) {
            this.nY++;
            this.oe = (((this.nY - 1) * this.oe) + d) / this.nY;
            return;
        }
        if (this.nY == this.nT) {
            this.nY++;
        }
        this.nY = 0;
        this.oe = 0.0d;
    }

    public void f(double d) {
        if (this.nZ < this.nT) {
            this.nZ++;
            this.of = (((this.nZ - 1) * this.of) + d) / this.nZ;
            return;
        }
        if (this.nZ == this.nT) {
            this.nZ++;
        }
        this.nZ = 0;
        this.of = 0.0d;
    }
}
