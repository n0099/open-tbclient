package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class n {
    private boolean AA;
    private int AB;
    private int AC;
    private boolean AD;
    private boolean AE;
    private int Ax;
    private int Ay;
    private boolean Az;
    private String zJ;

    public n() {
        this.zJ = null;
        this.Ax = 32768;
        this.Ay = 131072;
        this.Az = false;
        this.AA = true;
        this.AB = 30000;
        this.AC = 30000;
        this.AD = true;
        this.AE = true;
        this.zJ = null;
    }

    public n(n nVar) {
        this.zJ = null;
        this.Ax = nVar.Ax;
        this.Ay = nVar.Ay;
        this.Az = nVar.Az;
        this.AA = nVar.AA;
        this.AB = nVar.AB;
        this.AC = nVar.AC;
        this.AD = nVar.AD;
        this.AE = nVar.AE;
        this.zJ = nVar.zJ;
    }

    public boolean jR() {
        return this.Az;
    }

    public int jS() {
        return this.Ax;
    }

    public int jT() {
        return this.Ay;
    }

    public boolean getTcpNoDelay() {
        return this.AA;
    }

    public int jU() {
        return this.AB;
    }

    public int jV() {
        return this.AC;
    }

    public boolean jW() {
        return this.AD;
    }

    public boolean jX() {
        return this.AE;
    }

    public String jY() {
        return this.zJ;
    }

    public void ba(String str) {
        this.zJ = str;
    }
}
