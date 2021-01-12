package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private int RL;
    private int RO;
    private boolean RP;
    private boolean RQ;
    private int RR;
    private int RT;
    private boolean RU;
    private boolean RV;
    private String Re;

    public l() {
        this.Re = null;
        this.RL = 32768;
        this.RO = 131072;
        this.RP = false;
        this.RQ = true;
        this.RR = 30000;
        this.RT = 30000;
        this.RU = true;
        this.RV = true;
        this.Re = null;
    }

    public l(l lVar) {
        this.Re = null;
        this.RL = lVar.RL;
        this.RO = lVar.RO;
        this.RP = lVar.RP;
        this.RQ = lVar.RQ;
        this.RR = lVar.RR;
        this.RT = lVar.RT;
        this.RU = lVar.RU;
        this.RV = lVar.RV;
        this.Re = lVar.Re;
    }

    public boolean or() {
        return this.RP;
    }

    public int os() {
        return this.RL;
    }

    public int ot() {
        return this.RO;
    }

    public boolean ou() {
        return this.RQ;
    }

    public int ov() {
        return this.RR;
    }

    public int ow() {
        return this.RT;
    }

    public boolean ox() {
        return this.RU;
    }

    public boolean oy() {
        return this.RV;
    }

    public String oz() {
        return this.Re;
    }

    public void ch(String str) {
        this.Re = str;
    }
}
