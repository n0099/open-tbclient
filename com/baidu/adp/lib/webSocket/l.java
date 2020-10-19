package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private int QR;
    private int QS;
    private boolean QT;
    private boolean QU;
    private int QV;
    private int QW;
    private boolean QX;
    private boolean QY;
    private String Qh;

    public l() {
        this.Qh = null;
        this.QR = 32768;
        this.QS = 131072;
        this.QT = false;
        this.QU = true;
        this.QV = 30000;
        this.QW = 30000;
        this.QX = true;
        this.QY = true;
        this.Qh = null;
    }

    public l(l lVar) {
        this.Qh = null;
        this.QR = lVar.QR;
        this.QS = lVar.QS;
        this.QT = lVar.QT;
        this.QU = lVar.QU;
        this.QV = lVar.QV;
        this.QW = lVar.QW;
        this.QX = lVar.QX;
        this.QY = lVar.QY;
        this.Qh = lVar.Qh;
    }

    public boolean oQ() {
        return this.QT;
    }

    public int oR() {
        return this.QR;
    }

    public int oS() {
        return this.QS;
    }

    public boolean getTcpNoDelay() {
        return this.QU;
    }

    public int oT() {
        return this.QV;
    }

    public int oU() {
        return this.QW;
    }

    public boolean oV() {
        return this.QX;
    }

    public boolean oW() {
        return this.QY;
    }

    public String oX() {
        return this.Qh;
    }

    public void ck(String str) {
        this.Qh = str;
    }
}
