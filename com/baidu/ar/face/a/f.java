package com.baidu.ar.face.a;
/* loaded from: classes11.dex */
public class f {
    private double oA;
    private double oB;
    private double oC;
    private double oD;
    private double oE;
    private int os = 300;
    private int ot = 0;
    private int ou = 0;
    private int ov = 0;
    private int ow = 0;
    private int ox = 0;
    private int oy = 0;
    private double oz;

    public void a(double d) {
        if (this.ot < this.os) {
            this.ot++;
            this.oA = (((this.ot - 1) * this.oA) + d) / this.ot;
            return;
        }
        if (this.ot == this.os) {
            this.ot++;
        }
        this.ot = 0;
        this.oA = 0.0d;
    }

    public void b(double d) {
        if (this.ou < this.os) {
            this.ou++;
            this.oz = (((this.ou - 1) * this.oz) + d) / this.ou;
            return;
        }
        if (this.ou == this.os) {
            this.ou++;
        }
        this.ou = 0;
        this.oz = 0.0d;
    }

    public void c(double d) {
        if (this.ov < this.os) {
            this.ov++;
            this.oB = (((this.ov - 1) * this.oB) + d) / this.ov;
            return;
        }
        if (this.ov == this.os) {
            this.ov++;
        }
        this.ov = 0;
        this.oB = 0.0d;
    }

    public void d(double d) {
        if (this.ow < this.os) {
            this.ow++;
            this.oC = (((this.ow - 1) * this.oC) + d) / this.ow;
            return;
        }
        if (this.ow == this.os) {
            this.ow++;
        }
        this.ow = 0;
        this.oC = 0.0d;
    }

    public void dt() {
        this.ot = 0;
        this.ou = 0;
        this.ov = 0;
        this.ow = 0;
        this.ox = 0;
        this.oy = 0;
    }

    public void e(double d) {
        if (this.ox < this.os) {
            this.ox++;
            this.oD = (((this.ox - 1) * this.oD) + d) / this.ox;
            return;
        }
        if (this.ox == this.os) {
            this.ox++;
        }
        this.ox = 0;
        this.oD = 0.0d;
    }

    public void f(double d) {
        if (this.oy < this.os) {
            this.oy++;
            this.oE = (((this.oy - 1) * this.oE) + d) / this.oy;
            return;
        }
        if (this.oy == this.os) {
            this.oy++;
        }
        this.oy = 0;
        this.oE = 0.0d;
    }
}
