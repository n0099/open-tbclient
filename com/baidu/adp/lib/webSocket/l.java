package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private String BC;
    private int Cp;
    private int Cq;
    private boolean Cr;
    private boolean Cs;
    private int Ct;
    private int Cu;
    private boolean Cv;
    private boolean Cw;

    public l() {
        this.BC = null;
        this.Cp = 32768;
        this.Cq = 131072;
        this.Cr = false;
        this.Cs = true;
        this.Ct = 30000;
        this.Cu = 30000;
        this.Cv = true;
        this.Cw = true;
        this.BC = null;
    }

    public l(l lVar) {
        this.BC = null;
        this.Cp = lVar.Cp;
        this.Cq = lVar.Cq;
        this.Cr = lVar.Cr;
        this.Cs = lVar.Cs;
        this.Ct = lVar.Ct;
        this.Cu = lVar.Cu;
        this.Cv = lVar.Cv;
        this.Cw = lVar.Cw;
        this.BC = lVar.BC;
    }

    public boolean it() {
        return this.Cr;
    }

    public int iu() {
        return this.Cp;
    }

    public int iv() {
        return this.Cq;
    }

    public boolean getTcpNoDelay() {
        return this.Cs;
    }

    public int iw() {
        return this.Ct;
    }

    public int ix() {
        return this.Cu;
    }

    public boolean iy() {
        return this.Cv;
    }

    public boolean iz() {
        return this.Cw;
    }

    public String iA() {
        return this.BC;
    }

    public void aY(String str) {
        this.BC = str;
    }
}
