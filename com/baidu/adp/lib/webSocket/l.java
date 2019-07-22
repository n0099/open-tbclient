package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private int FX;
    private int FY;
    private boolean FZ;
    private String Fk;
    private boolean Ga;
    private int Gb;
    private int Gc;
    private boolean Gd;
    private boolean Ge;

    public l() {
        this.Fk = null;
        this.FX = 32768;
        this.FY = 131072;
        this.FZ = false;
        this.Ga = true;
        this.Gb = 30000;
        this.Gc = 30000;
        this.Gd = true;
        this.Ge = true;
        this.Fk = null;
    }

    public l(l lVar) {
        this.Fk = null;
        this.FX = lVar.FX;
        this.FY = lVar.FY;
        this.FZ = lVar.FZ;
        this.Ga = lVar.Ga;
        this.Gb = lVar.Gb;
        this.Gc = lVar.Gc;
        this.Gd = lVar.Gd;
        this.Ge = lVar.Ge;
        this.Fk = lVar.Fk;
    }

    public boolean lg() {
        return this.FZ;
    }

    public int lh() {
        return this.FX;
    }

    public int li() {
        return this.FY;
    }

    public boolean lj() {
        return this.Ga;
    }

    public int lk() {
        return this.Gb;
    }

    public int ll() {
        return this.Gc;
    }

    public boolean lm() {
        return this.Gd;
    }

    public boolean ln() {
        return this.Ge;
    }

    public String lo() {
        return this.Fk;
    }

    public void br(String str) {
        this.Fk = str;
    }
}
