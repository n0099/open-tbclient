package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private int FP;
    private int FQ;
    private boolean FR;
    private boolean FT;
    private int FU;
    private int FV;
    private boolean FW;
    private boolean FX;
    private String Fd;

    public l() {
        this.Fd = null;
        this.FP = 32768;
        this.FQ = 131072;
        this.FR = false;
        this.FT = true;
        this.FU = 30000;
        this.FV = 30000;
        this.FW = true;
        this.FX = true;
        this.Fd = null;
    }

    public l(l lVar) {
        this.Fd = null;
        this.FP = lVar.FP;
        this.FQ = lVar.FQ;
        this.FR = lVar.FR;
        this.FT = lVar.FT;
        this.FU = lVar.FU;
        this.FV = lVar.FV;
        this.FW = lVar.FW;
        this.FX = lVar.FX;
        this.Fd = lVar.Fd;
    }

    public boolean kR() {
        return this.FR;
    }

    public int kS() {
        return this.FP;
    }

    public int kT() {
        return this.FQ;
    }

    public boolean getTcpNoDelay() {
        return this.FT;
    }

    public int kU() {
        return this.FU;
    }

    public int kV() {
        return this.FV;
    }

    public boolean kW() {
        return this.FW;
    }

    public boolean kX() {
        return this.FX;
    }

    public String kY() {
        return this.Fd;
    }

    public void bp(String str) {
        this.Fd = str;
    }
}
