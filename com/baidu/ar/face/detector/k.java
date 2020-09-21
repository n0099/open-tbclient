package com.baidu.ar.face.detector;
/* loaded from: classes10.dex */
public class k {
    private int pa = 300;
    private int pb = 0;
    private int pc = 0;
    private int pd = 0;
    private int pe = 0;
    private int pf = 0;
    private int pg = 0;
    private double ph;
    private double pi;
    private double pj;
    private double pk;

    /* renamed from: pl  reason: collision with root package name */
    private double f960pl;
    private double pm;

    public void a(double d) {
        if (this.pb < this.pa) {
            this.pb++;
            this.pi = (((this.pb - 1) * this.pi) + d) / this.pb;
            return;
        }
        if (this.pb == this.pa) {
            this.pb++;
        }
        this.pb = 0;
        this.pi = 0.0d;
    }

    public void b(double d) {
        if (this.pc < this.pa) {
            this.pc++;
            this.ph = (((this.pc - 1) * this.ph) + d) / this.pc;
            return;
        }
        if (this.pc == this.pa) {
            this.pc++;
        }
        this.pc = 0;
        this.ph = 0.0d;
    }

    public void c(double d) {
        if (this.pd < this.pa) {
            this.pd++;
            this.pj = (((this.pd - 1) * this.pj) + d) / this.pd;
            return;
        }
        if (this.pd == this.pa) {
            this.pd++;
        }
        this.pd = 0;
        this.pj = 0.0d;
    }

    public void d(double d) {
        if (this.pe < this.pa) {
            this.pe++;
            this.pk = (((this.pe - 1) * this.pk) + d) / this.pe;
            return;
        }
        if (this.pe == this.pa) {
            this.pe++;
        }
        this.pe = 0;
        this.pk = 0.0d;
    }

    public void e(double d) {
        if (this.pf < this.pa) {
            this.pf++;
            this.f960pl = (((this.pf - 1) * this.f960pl) + d) / this.pf;
            return;
        }
        if (this.pf == this.pa) {
            this.pf++;
        }
        this.pf = 0;
        this.f960pl = 0.0d;
    }

    public void eA() {
        this.pb = 0;
        this.pc = 0;
        this.pd = 0;
        this.pe = 0;
        this.pf = 0;
        this.pg = 0;
    }

    public void f(double d) {
        if (this.pg < this.pa) {
            this.pg++;
            this.pm = (((this.pg - 1) * this.pm) + d) / this.pg;
            return;
        }
        if (this.pg == this.pa) {
            this.pg++;
        }
        this.pg = 0;
        this.pm = 0.0d;
    }
}
