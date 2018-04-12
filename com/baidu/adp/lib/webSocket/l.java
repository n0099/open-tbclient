package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private int yU;
    private int yV;
    private boolean yW;
    private boolean yX;
    private int yY;
    private int yZ;
    private String yh;
    private boolean za;
    private boolean zb;

    public l() {
        this.yh = null;
        this.yU = 32768;
        this.yV = 131072;
        this.yW = false;
        this.yX = true;
        this.yY = 30000;
        this.yZ = 30000;
        this.za = true;
        this.zb = true;
        this.yh = null;
    }

    public l(l lVar) {
        this.yh = null;
        this.yU = lVar.yU;
        this.yV = lVar.yV;
        this.yW = lVar.yW;
        this.yX = lVar.yX;
        this.yY = lVar.yY;
        this.yZ = lVar.yZ;
        this.za = lVar.za;
        this.zb = lVar.zb;
        this.yh = lVar.yh;
    }

    public boolean hP() {
        return this.yW;
    }

    public int hQ() {
        return this.yU;
    }

    public int hR() {
        return this.yV;
    }

    public boolean getTcpNoDelay() {
        return this.yX;
    }

    public int hS() {
        return this.yY;
    }

    public int hT() {
        return this.yZ;
    }

    public boolean hU() {
        return this.za;
    }

    public boolean hV() {
        return this.zb;
    }

    public String hW() {
        return this.yh;
    }

    public void ba(String str) {
        this.yh = str;
    }
}
