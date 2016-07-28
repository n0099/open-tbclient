package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class n {
    private String qY;
    private int rM;
    private int rN;
    private boolean rO;
    private boolean rP;
    private int rQ;
    private int rR;
    private boolean rS;
    private boolean rT;

    public n() {
        this.qY = null;
        this.rM = 32768;
        this.rN = 131072;
        this.rO = false;
        this.rP = true;
        this.rQ = 30000;
        this.rR = 30000;
        this.rS = true;
        this.rT = true;
        this.qY = null;
    }

    public n(n nVar) {
        this.qY = null;
        this.rM = nVar.rM;
        this.rN = nVar.rN;
        this.rO = nVar.rO;
        this.rP = nVar.rP;
        this.rQ = nVar.rQ;
        this.rR = nVar.rR;
        this.rS = nVar.rS;
        this.rT = nVar.rT;
        this.qY = nVar.qY;
    }

    public boolean gv() {
        return this.rO;
    }

    public int gw() {
        return this.rM;
    }

    public int gx() {
        return this.rN;
    }

    public boolean getTcpNoDelay() {
        return this.rP;
    }

    public int gy() {
        return this.rQ;
    }

    public int gz() {
        return this.rR;
    }

    public boolean gA() {
        return this.rS;
    }

    public boolean gB() {
        return this.rT;
    }

    public String gC() {
        return this.qY;
    }

    public void aW(String str) {
        this.qY = str;
    }
}
