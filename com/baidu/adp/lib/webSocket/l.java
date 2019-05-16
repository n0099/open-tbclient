package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private int FQ;
    private int FR;
    private boolean FT;
    private boolean FU;
    private int FV;
    private int FW;
    private boolean FX;
    private boolean FY;
    private String Fe;

    public l() {
        this.Fe = null;
        this.FQ = 32768;
        this.FR = 131072;
        this.FT = false;
        this.FU = true;
        this.FV = 30000;
        this.FW = 30000;
        this.FX = true;
        this.FY = true;
        this.Fe = null;
    }

    public l(l lVar) {
        this.Fe = null;
        this.FQ = lVar.FQ;
        this.FR = lVar.FR;
        this.FT = lVar.FT;
        this.FU = lVar.FU;
        this.FV = lVar.FV;
        this.FW = lVar.FW;
        this.FX = lVar.FX;
        this.FY = lVar.FY;
        this.Fe = lVar.Fe;
    }

    public boolean kR() {
        return this.FT;
    }

    public int kS() {
        return this.FQ;
    }

    public int kT() {
        return this.FR;
    }

    public boolean getTcpNoDelay() {
        return this.FU;
    }

    public int kU() {
        return this.FV;
    }

    public int kV() {
        return this.FW;
    }

    public boolean kW() {
        return this.FX;
    }

    public boolean kX() {
        return this.FY;
    }

    public String kY() {
        return this.Fe;
    }

    public void bp(String str) {
        this.Fe = str;
    }
}
