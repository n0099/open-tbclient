package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private String GH;
    private int HA;
    private boolean HB;
    private boolean HC;
    private int Hv;
    private int Hw;
    private boolean Hx;
    private boolean Hy;
    private int Hz;

    public l() {
        this.GH = null;
        this.Hv = 32768;
        this.Hw = 131072;
        this.Hx = false;
        this.Hy = true;
        this.Hz = 30000;
        this.HA = 30000;
        this.HB = true;
        this.HC = true;
        this.GH = null;
    }

    public l(l lVar) {
        this.GH = null;
        this.Hv = lVar.Hv;
        this.Hw = lVar.Hw;
        this.Hx = lVar.Hx;
        this.Hy = lVar.Hy;
        this.Hz = lVar.Hz;
        this.HA = lVar.HA;
        this.HB = lVar.HB;
        this.HC = lVar.HC;
        this.GH = lVar.GH;
    }

    public boolean lL() {
        return this.Hx;
    }

    public int lM() {
        return this.Hv;
    }

    public int lN() {
        return this.Hw;
    }

    public boolean getTcpNoDelay() {
        return this.Hy;
    }

    public int lO() {
        return this.Hz;
    }

    public int lP() {
        return this.HA;
    }

    public boolean lQ() {
        return this.HB;
    }

    public boolean lR() {
        return this.HC;
    }

    public String lS() {
        return this.GH;
    }

    public void bG(String str) {
        this.GH = str;
    }
}
