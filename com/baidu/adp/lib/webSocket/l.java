package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private int RK;
    private int RL;
    private boolean RO;
    private boolean RP;
    private int RQ;
    private int RR;
    private boolean RT;
    private boolean RU;
    private String Rd;

    public l() {
        this.Rd = null;
        this.RK = 32768;
        this.RL = 131072;
        this.RO = false;
        this.RP = true;
        this.RQ = 30000;
        this.RR = 30000;
        this.RT = true;
        this.RU = true;
        this.Rd = null;
    }

    public l(l lVar) {
        this.Rd = null;
        this.RK = lVar.RK;
        this.RL = lVar.RL;
        this.RO = lVar.RO;
        this.RP = lVar.RP;
        this.RQ = lVar.RQ;
        this.RR = lVar.RR;
        this.RT = lVar.RT;
        this.RU = lVar.RU;
        this.Rd = lVar.Rd;
    }

    public boolean oQ() {
        return this.RO;
    }

    public int oR() {
        return this.RK;
    }

    public int oS() {
        return this.RL;
    }

    public boolean oT() {
        return this.RP;
    }

    public int oU() {
        return this.RQ;
    }

    public int oV() {
        return this.RR;
    }

    public boolean oW() {
        return this.RT;
    }

    public boolean oX() {
        return this.RU;
    }

    public String oY() {
        return this.Rd;
    }

    public void co(String str) {
        this.Rd = str;
    }
}
