package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private int yT;
    private int yU;
    private boolean yV;
    private boolean yW;
    private int yX;
    private int yY;
    private boolean yZ;
    private String yg;
    private boolean za;

    public l() {
        this.yg = null;
        this.yT = 32768;
        this.yU = 131072;
        this.yV = false;
        this.yW = true;
        this.yX = 30000;
        this.yY = 30000;
        this.yZ = true;
        this.za = true;
        this.yg = null;
    }

    public l(l lVar) {
        this.yg = null;
        this.yT = lVar.yT;
        this.yU = lVar.yU;
        this.yV = lVar.yV;
        this.yW = lVar.yW;
        this.yX = lVar.yX;
        this.yY = lVar.yY;
        this.yZ = lVar.yZ;
        this.za = lVar.za;
        this.yg = lVar.yg;
    }

    public boolean hP() {
        return this.yV;
    }

    public int hQ() {
        return this.yT;
    }

    public int hR() {
        return this.yU;
    }

    public boolean getTcpNoDelay() {
        return this.yW;
    }

    public int hS() {
        return this.yX;
    }

    public int hT() {
        return this.yY;
    }

    public boolean hU() {
        return this.yZ;
    }

    public boolean hV() {
        return this.za;
    }

    public String hW() {
        return this.yg;
    }

    public void ba(String str) {
        this.yg = str;
    }
}
