package com.baidu.ar.face.detector;
/* loaded from: classes3.dex */
public class k {
    private double pA;
    private double pB;
    private double pC;
    private int pq = 300;
    private int pr = 0;
    private int ps = 0;
    private int pt = 0;
    private int pu = 0;
    private int pv = 0;
    private int pw = 0;
    private double px;
    private double py;
    private double pz;

    public void a(double d) {
        if (this.pr < this.pq) {
            this.pr++;
            this.py = (((this.pr - 1) * this.py) + d) / this.pr;
            return;
        }
        if (this.pr == this.pq) {
            this.pr++;
        }
        this.pr = 0;
        this.py = 0.0d;
    }

    public void b(double d) {
        if (this.ps < this.pq) {
            this.ps++;
            this.px = (((this.ps - 1) * this.px) + d) / this.ps;
            return;
        }
        if (this.ps == this.pq) {
            this.ps++;
        }
        this.ps = 0;
        this.px = 0.0d;
    }

    public void c(double d) {
        if (this.pt < this.pq) {
            this.pt++;
            this.pz = (((this.pt - 1) * this.pz) + d) / this.pt;
            return;
        }
        if (this.pt == this.pq) {
            this.pt++;
        }
        this.pt = 0;
        this.pz = 0.0d;
    }

    public void d(double d) {
        if (this.pu < this.pq) {
            this.pu++;
            this.pA = (((this.pu - 1) * this.pA) + d) / this.pu;
            return;
        }
        if (this.pu == this.pq) {
            this.pu++;
        }
        this.pu = 0;
        this.pA = 0.0d;
    }

    public void e(double d) {
        if (this.pv < this.pq) {
            this.pv++;
            this.pB = (((this.pv - 1) * this.pB) + d) / this.pv;
            return;
        }
        if (this.pv == this.pq) {
            this.pv++;
        }
        this.pv = 0;
        this.pB = 0.0d;
    }

    public void ez() {
        this.pr = 0;
        this.ps = 0;
        this.pt = 0;
        this.pu = 0;
        this.pv = 0;
        this.pw = 0;
    }

    public void f(double d) {
        if (this.pw < this.pq) {
            this.pw++;
            this.pC = (((this.pw - 1) * this.pC) + d) / this.pw;
            return;
        }
        if (this.pw == this.pq) {
            this.pw++;
        }
        this.pw = 0;
        this.pC = 0.0d;
    }
}
