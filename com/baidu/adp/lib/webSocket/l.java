package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private int QT;
    private int QU;
    private boolean QV;
    private boolean QW;
    private int QX;
    private int QY;
    private boolean QZ;
    private String Qj;
    private boolean Ra;

    public l() {
        this.Qj = null;
        this.QT = 32768;
        this.QU = 131072;
        this.QV = false;
        this.QW = true;
        this.QX = 30000;
        this.QY = 30000;
        this.QZ = true;
        this.Ra = true;
        this.Qj = null;
    }

    public l(l lVar) {
        this.Qj = null;
        this.QT = lVar.QT;
        this.QU = lVar.QU;
        this.QV = lVar.QV;
        this.QW = lVar.QW;
        this.QX = lVar.QX;
        this.QY = lVar.QY;
        this.QZ = lVar.QZ;
        this.Ra = lVar.Ra;
        this.Qj = lVar.Qj;
    }

    public boolean oQ() {
        return this.QV;
    }

    public int oR() {
        return this.QT;
    }

    public int oS() {
        return this.QU;
    }

    public boolean getTcpNoDelay() {
        return this.QW;
    }

    public int oT() {
        return this.QX;
    }

    public int oU() {
        return this.QY;
    }

    public boolean oV() {
        return this.QZ;
    }

    public boolean oW() {
        return this.Ra;
    }

    public String oX() {
        return this.Qj;
    }

    public void cl(String str) {
        this.Qj = str;
    }
}
