package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private String sv;
    private int ti;
    private int tj;
    private boolean tk;
    private boolean tl;
    private int tm;
    private int tp;
    private boolean tq;
    private boolean tr;

    public l() {
        this.sv = null;
        this.ti = 32768;
        this.tj = 131072;
        this.tk = false;
        this.tl = true;
        this.tm = 30000;
        this.tp = 30000;
        this.tq = true;
        this.tr = true;
        this.sv = null;
    }

    public l(l lVar) {
        this.sv = null;
        this.ti = lVar.ti;
        this.tj = lVar.tj;
        this.tk = lVar.tk;
        this.tl = lVar.tl;
        this.tm = lVar.tm;
        this.tp = lVar.tp;
        this.tq = lVar.tq;
        this.tr = lVar.tr;
        this.sv = lVar.sv;
    }

    public boolean hF() {
        return this.tk;
    }

    public int hG() {
        return this.ti;
    }

    public int hH() {
        return this.tj;
    }

    public boolean hI() {
        return this.tl;
    }

    public int hJ() {
        return this.tm;
    }

    public int hK() {
        return this.tp;
    }

    public boolean hL() {
        return this.tq;
    }

    public boolean hM() {
        return this.tr;
    }

    public String hN() {
        return this.sv;
    }

    public void ay(String str) {
        this.sv = str;
    }
}
