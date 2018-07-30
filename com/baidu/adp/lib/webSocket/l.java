package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private String En;
    private int Fa;
    private int Fb;
    private boolean Fc;
    private boolean Fd;
    private int Fe;
    private int Ff;
    private boolean Fg;
    private boolean Fh;

    public l() {
        this.En = null;
        this.Fa = 32768;
        this.Fb = 131072;
        this.Fc = false;
        this.Fd = true;
        this.Fe = 30000;
        this.Ff = 30000;
        this.Fg = true;
        this.Fh = true;
        this.En = null;
    }

    public l(l lVar) {
        this.En = null;
        this.Fa = lVar.Fa;
        this.Fb = lVar.Fb;
        this.Fc = lVar.Fc;
        this.Fd = lVar.Fd;
        this.Fe = lVar.Fe;
        this.Ff = lVar.Ff;
        this.Fg = lVar.Fg;
        this.Fh = lVar.Fh;
        this.En = lVar.En;
    }

    public boolean kF() {
        return this.Fc;
    }

    public int kG() {
        return this.Fa;
    }

    public int kH() {
        return this.Fb;
    }

    public boolean getTcpNoDelay() {
        return this.Fd;
    }

    public int kI() {
        return this.Fe;
    }

    public int kJ() {
        return this.Ff;
    }

    public boolean kK() {
        return this.Fg;
    }

    public boolean kL() {
        return this.Fh;
    }

    public String kM() {
        return this.En;
    }

    public void bp(String str) {
        this.En = str;
    }
}
