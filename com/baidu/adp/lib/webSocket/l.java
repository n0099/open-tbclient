package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private int RP;
    private int RQ;
    private boolean RR;
    private boolean RT;
    private int RU;
    private int RV;
    private boolean RW;
    private boolean RX;
    private String Rg;

    public l() {
        this.Rg = null;
        this.RP = 32768;
        this.RQ = 131072;
        this.RR = false;
        this.RT = true;
        this.RU = 30000;
        this.RV = 30000;
        this.RW = true;
        this.RX = true;
        this.Rg = null;
    }

    public l(l lVar) {
        this.Rg = null;
        this.RP = lVar.RP;
        this.RQ = lVar.RQ;
        this.RR = lVar.RR;
        this.RT = lVar.RT;
        this.RU = lVar.RU;
        this.RV = lVar.RV;
        this.RW = lVar.RW;
        this.RX = lVar.RX;
        this.Rg = lVar.Rg;
    }

    public boolean or() {
        return this.RR;
    }

    public int os() {
        return this.RP;
    }

    public int ot() {
        return this.RQ;
    }

    public boolean ou() {
        return this.RT;
    }

    public int ov() {
        return this.RU;
    }

    public int ow() {
        return this.RV;
    }

    public boolean ox() {
        return this.RW;
    }

    public boolean oy() {
        return this.RX;
    }

    public String oz() {
        return this.Rg;
    }

    public void ch(String str) {
        this.Rg = str;
    }
}
