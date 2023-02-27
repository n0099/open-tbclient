package com.baidu.ar.face.detector;
/* loaded from: classes.dex */
public class k {
    public double pA;
    public double pB;
    public double pC;
    public int pq = 300;
    public int pr = 0;
    public int ps = 0;
    public int pt = 0;
    public int pu = 0;
    public int pv = 0;
    public int pw = 0;
    public double px;
    public double py;
    public double pz;

    public void a(double d) {
        int i = this.pr;
        int i2 = this.pq;
        if (i < i2) {
            int i3 = i + 1;
            this.pr = i3;
            this.py = (((i3 - 1) * this.py) + d) / i3;
            return;
        }
        if (i == i2) {
            this.pr = i + 1;
        }
        this.pr = 0;
        this.py = 0.0d;
    }

    public void b(double d) {
        int i = this.ps;
        int i2 = this.pq;
        if (i < i2) {
            int i3 = i + 1;
            this.ps = i3;
            this.px = (((i3 - 1) * this.px) + d) / i3;
            return;
        }
        if (i == i2) {
            this.ps = i + 1;
        }
        this.ps = 0;
        this.px = 0.0d;
    }

    public void c(double d) {
        int i = this.pt;
        int i2 = this.pq;
        if (i < i2) {
            int i3 = i + 1;
            this.pt = i3;
            this.pz = (((i3 - 1) * this.pz) + d) / i3;
            return;
        }
        if (i == i2) {
            this.pt = i + 1;
        }
        this.pt = 0;
        this.pz = 0.0d;
    }

    public void d(double d) {
        int i = this.pu;
        int i2 = this.pq;
        if (i < i2) {
            int i3 = i + 1;
            this.pu = i3;
            this.pA = (((i3 - 1) * this.pA) + d) / i3;
            return;
        }
        if (i == i2) {
            this.pu = i + 1;
        }
        this.pu = 0;
        this.pA = 0.0d;
    }

    public void e(double d) {
        int i = this.pv;
        int i2 = this.pq;
        if (i < i2) {
            int i3 = i + 1;
            this.pv = i3;
            this.pB = (((i3 - 1) * this.pB) + d) / i3;
            return;
        }
        if (i == i2) {
            this.pv = i + 1;
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
        int i = this.pw;
        int i2 = this.pq;
        if (i < i2) {
            int i3 = i + 1;
            this.pw = i3;
            this.pC = (((i3 - 1) * this.pC) + d) / i3;
            return;
        }
        if (i == i2) {
            this.pw = i + 1;
        }
        this.pw = 0;
        this.pC = 0.0d;
    }
}
