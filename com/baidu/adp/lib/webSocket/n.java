package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class n {
    private int AA;
    private boolean AB;
    private boolean AC;
    private int Av;
    private int Aw;
    private boolean Ax;
    private boolean Ay;
    private int Az;
    private String zH;

    public n() {
        this.zH = null;
        this.Av = 32768;
        this.Aw = 131072;
        this.Ax = false;
        this.Ay = true;
        this.Az = 30000;
        this.AA = 30000;
        this.AB = true;
        this.AC = true;
        this.zH = null;
    }

    public n(n nVar) {
        this.zH = null;
        this.Av = nVar.Av;
        this.Aw = nVar.Aw;
        this.Ax = nVar.Ax;
        this.Ay = nVar.Ay;
        this.Az = nVar.Az;
        this.AA = nVar.AA;
        this.AB = nVar.AB;
        this.AC = nVar.AC;
        this.zH = nVar.zH;
    }

    public boolean jQ() {
        return this.Ax;
    }

    public int jR() {
        return this.Av;
    }

    public int jS() {
        return this.Aw;
    }

    public boolean getTcpNoDelay() {
        return this.Ay;
    }

    public int jT() {
        return this.Az;
    }

    public int jU() {
        return this.AA;
    }

    public boolean jV() {
        return this.AB;
    }

    public boolean jW() {
        return this.AC;
    }

    public String jX() {
        return this.zH;
    }

    public void ba(String str) {
        this.zH = str;
    }
}
