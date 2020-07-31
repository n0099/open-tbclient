package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private String OO;
    private boolean PD;
    private int PE;
    private int PF;
    private boolean PG;
    private boolean PH;
    private int Px;
    private int Py;
    private boolean Pz;

    public l() {
        this.OO = null;
        this.Px = 32768;
        this.Py = 131072;
        this.Pz = false;
        this.PD = true;
        this.PE = 30000;
        this.PF = 30000;
        this.PG = true;
        this.PH = true;
        this.OO = null;
    }

    public l(l lVar) {
        this.OO = null;
        this.Px = lVar.Px;
        this.Py = lVar.Py;
        this.Pz = lVar.Pz;
        this.PD = lVar.PD;
        this.PE = lVar.PE;
        this.PF = lVar.PF;
        this.PG = lVar.PG;
        this.PH = lVar.PH;
        this.OO = lVar.OO;
    }

    public boolean nl() {
        return this.Pz;
    }

    public int nm() {
        return this.Px;
    }

    public int nn() {
        return this.Py;
    }

    public boolean getTcpNoDelay() {
        return this.PD;
    }

    public int no() {
        return this.PE;
    }

    public int np() {
        return this.PF;
    }

    public boolean nq() {
        return this.PG;
    }

    public boolean nr() {
        return this.PH;
    }

    public String ns() {
        return this.OO;
    }

    public void cc(String str) {
        this.OO = str;
    }
}
