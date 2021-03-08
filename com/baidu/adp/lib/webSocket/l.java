package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private String Sx;
    private int Ti;
    private int Tj;
    private boolean Tk;
    private boolean Tl;
    private int Tm;
    private int Tn;
    private boolean To;
    private boolean Tp;

    public l() {
        this.Sx = null;
        this.Ti = 32768;
        this.Tj = 131072;
        this.Tk = false;
        this.Tl = true;
        this.Tm = 30000;
        this.Tn = 30000;
        this.To = true;
        this.Tp = true;
        this.Sx = null;
    }

    public l(l lVar) {
        this.Sx = null;
        this.Ti = lVar.Ti;
        this.Tj = lVar.Tj;
        this.Tk = lVar.Tk;
        this.Tl = lVar.Tl;
        this.Tm = lVar.Tm;
        this.Tn = lVar.Tn;
        this.To = lVar.To;
        this.Tp = lVar.Tp;
        this.Sx = lVar.Sx;
    }

    public boolean op() {
        return this.Tk;
    }

    public int oq() {
        return this.Ti;
    }

    public int or() {
        return this.Tj;
    }

    public boolean os() {
        return this.Tl;
    }

    public int ot() {
        return this.Tm;
    }

    public int ou() {
        return this.Tn;
    }

    public boolean ov() {
        return this.To;
    }

    public boolean ow() {
        return this.Tp;
    }

    public String ox() {
        return this.Sx;
    }

    public void cl(String str) {
        this.Sx = str;
    }
}
