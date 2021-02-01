package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private int RJ;
    private int RK;
    private boolean RL;
    private boolean RO;
    private int RP;
    private int RQ;
    private boolean RR;
    private boolean RT;
    private String Rc;

    public l() {
        this.Rc = null;
        this.RJ = 32768;
        this.RK = 131072;
        this.RL = false;
        this.RO = true;
        this.RP = 30000;
        this.RQ = 30000;
        this.RR = true;
        this.RT = true;
        this.Rc = null;
    }

    public l(l lVar) {
        this.Rc = null;
        this.RJ = lVar.RJ;
        this.RK = lVar.RK;
        this.RL = lVar.RL;
        this.RO = lVar.RO;
        this.RP = lVar.RP;
        this.RQ = lVar.RQ;
        this.RR = lVar.RR;
        this.RT = lVar.RT;
        this.Rc = lVar.Rc;
    }

    public boolean op() {
        return this.RL;
    }

    public int oq() {
        return this.RJ;
    }

    public int or() {
        return this.RK;
    }

    public boolean os() {
        return this.RO;
    }

    public int ot() {
        return this.RP;
    }

    public int ou() {
        return this.RQ;
    }

    public boolean ov() {
        return this.RR;
    }

    public boolean ow() {
        return this.RT;
    }

    public String ox() {
        return this.Rc;
    }

    public void ch(String str) {
        this.Rc = str;
    }
}
