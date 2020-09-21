package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private String PP;
    private int QB;
    private boolean QC;
    private boolean QD;
    private int QE;
    private int QF;
    private boolean QG;
    private boolean QH;
    private int Qz;

    public l() {
        this.PP = null;
        this.Qz = 32768;
        this.QB = 131072;
        this.QC = false;
        this.QD = true;
        this.QE = 30000;
        this.QF = 30000;
        this.QG = true;
        this.QH = true;
        this.PP = null;
    }

    public l(l lVar) {
        this.PP = null;
        this.Qz = lVar.Qz;
        this.QB = lVar.QB;
        this.QC = lVar.QC;
        this.QD = lVar.QD;
        this.QE = lVar.QE;
        this.QF = lVar.QF;
        this.QG = lVar.QG;
        this.QH = lVar.QH;
        this.PP = lVar.PP;
    }

    public boolean oQ() {
        return this.QC;
    }

    public int oR() {
        return this.Qz;
    }

    public int oS() {
        return this.QB;
    }

    public boolean getTcpNoDelay() {
        return this.QD;
    }

    public int oT() {
        return this.QE;
    }

    public int oU() {
        return this.QF;
    }

    public boolean oV() {
        return this.QG;
    }

    public boolean oW() {
        return this.QH;
    }

    public String oX() {
        return this.PP;
    }

    public void ck(String str) {
        this.PP = str;
    }
}
