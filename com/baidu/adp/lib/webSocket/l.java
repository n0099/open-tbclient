package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private String BE;
    private int Cr;
    private int Cs;
    private boolean Ct;
    private boolean Cu;
    private int Cv;
    private int Cw;
    private boolean Cx;
    private boolean Cy;

    public l() {
        this.BE = null;
        this.Cr = 32768;
        this.Cs = 131072;
        this.Ct = false;
        this.Cu = true;
        this.Cv = 30000;
        this.Cw = 30000;
        this.Cx = true;
        this.Cy = true;
        this.BE = null;
    }

    public l(l lVar) {
        this.BE = null;
        this.Cr = lVar.Cr;
        this.Cs = lVar.Cs;
        this.Ct = lVar.Ct;
        this.Cu = lVar.Cu;
        this.Cv = lVar.Cv;
        this.Cw = lVar.Cw;
        this.Cx = lVar.Cx;
        this.Cy = lVar.Cy;
        this.BE = lVar.BE;
    }

    public boolean it() {
        return this.Ct;
    }

    public int iu() {
        return this.Cr;
    }

    public int iv() {
        return this.Cs;
    }

    public boolean getTcpNoDelay() {
        return this.Cu;
    }

    public int iw() {
        return this.Cv;
    }

    public int ix() {
        return this.Cw;
    }

    public boolean iy() {
        return this.Cx;
    }

    public boolean iz() {
        return this.Cy;
    }

    public String iA() {
        return this.BE;
    }

    public void aZ(String str) {
        this.BE = str;
    }
}
