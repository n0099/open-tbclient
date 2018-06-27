package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private String Eq;
    private int Fd;
    private int Fe;
    private boolean Ff;
    private boolean Fg;
    private int Fh;
    private int Fi;
    private boolean Fj;
    private boolean Fk;

    public l() {
        this.Eq = null;
        this.Fd = 32768;
        this.Fe = 131072;
        this.Ff = false;
        this.Fg = true;
        this.Fh = 30000;
        this.Fi = 30000;
        this.Fj = true;
        this.Fk = true;
        this.Eq = null;
    }

    public l(l lVar) {
        this.Eq = null;
        this.Fd = lVar.Fd;
        this.Fe = lVar.Fe;
        this.Ff = lVar.Ff;
        this.Fg = lVar.Fg;
        this.Fh = lVar.Fh;
        this.Fi = lVar.Fi;
        this.Fj = lVar.Fj;
        this.Fk = lVar.Fk;
        this.Eq = lVar.Eq;
    }

    public boolean kD() {
        return this.Ff;
    }

    public int kE() {
        return this.Fd;
    }

    public int kF() {
        return this.Fe;
    }

    public boolean getTcpNoDelay() {
        return this.Fg;
    }

    public int kG() {
        return this.Fh;
    }

    public int kH() {
        return this.Fi;
    }

    public boolean kI() {
        return this.Fj;
    }

    public boolean kJ() {
        return this.Fk;
    }

    public String kK() {
        return this.Eq;
    }

    public void bo(String str) {
        this.Eq = str;
    }
}
