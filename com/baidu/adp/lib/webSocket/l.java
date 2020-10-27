package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private int QS;
    private int QT;
    private boolean QU;
    private boolean QV;
    private int QW;
    private int QX;
    private boolean QY;
    private boolean QZ;
    private String Qi;

    public l() {
        this.Qi = null;
        this.QS = 32768;
        this.QT = 131072;
        this.QU = false;
        this.QV = true;
        this.QW = 30000;
        this.QX = 30000;
        this.QY = true;
        this.QZ = true;
        this.Qi = null;
    }

    public l(l lVar) {
        this.Qi = null;
        this.QS = lVar.QS;
        this.QT = lVar.QT;
        this.QU = lVar.QU;
        this.QV = lVar.QV;
        this.QW = lVar.QW;
        this.QX = lVar.QX;
        this.QY = lVar.QY;
        this.QZ = lVar.QZ;
        this.Qi = lVar.Qi;
    }

    public boolean oQ() {
        return this.QU;
    }

    public int oR() {
        return this.QS;
    }

    public int oS() {
        return this.QT;
    }

    public boolean getTcpNoDelay() {
        return this.QV;
    }

    public int oT() {
        return this.QW;
    }

    public int oU() {
        return this.QX;
    }

    public boolean oV() {
        return this.QY;
    }

    public boolean oW() {
        return this.QZ;
    }

    public String oX() {
        return this.Qi;
    }

    public void ck(String str) {
        this.Qi = str;
    }
}
