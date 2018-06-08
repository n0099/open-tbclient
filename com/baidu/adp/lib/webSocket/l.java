package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private String Eo;
    private int Fb;
    private int Fc;
    private boolean Fd;
    private boolean Fe;
    private int Ff;
    private int Fg;
    private boolean Fh;
    private boolean Fi;

    public l() {
        this.Eo = null;
        this.Fb = 32768;
        this.Fc = 131072;
        this.Fd = false;
        this.Fe = true;
        this.Ff = 30000;
        this.Fg = 30000;
        this.Fh = true;
        this.Fi = true;
        this.Eo = null;
    }

    public l(l lVar) {
        this.Eo = null;
        this.Fb = lVar.Fb;
        this.Fc = lVar.Fc;
        this.Fd = lVar.Fd;
        this.Fe = lVar.Fe;
        this.Ff = lVar.Ff;
        this.Fg = lVar.Fg;
        this.Fh = lVar.Fh;
        this.Fi = lVar.Fi;
        this.Eo = lVar.Eo;
    }

    public boolean kD() {
        return this.Fd;
    }

    public int kE() {
        return this.Fb;
    }

    public int kF() {
        return this.Fc;
    }

    public boolean getTcpNoDelay() {
        return this.Fe;
    }

    public int kG() {
        return this.Ff;
    }

    public int kH() {
        return this.Fg;
    }

    public boolean kI() {
        return this.Fh;
    }

    public boolean kJ() {
        return this.Fi;
    }

    public String kK() {
        return this.Eo;
    }

    public void bm(String str) {
        this.Eo = str;
    }
}
