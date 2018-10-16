package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private int HX;
    private int HY;
    private boolean HZ;
    private String Hp;
    private boolean Ia;
    private int Ib;
    private int Ic;
    private boolean Id;
    private boolean Ie;

    public l() {
        this.Hp = null;
        this.HX = 32768;
        this.HY = 131072;
        this.HZ = false;
        this.Ia = true;
        this.Ib = 30000;
        this.Ic = 30000;
        this.Id = true;
        this.Ie = true;
        this.Hp = null;
    }

    public l(l lVar) {
        this.Hp = null;
        this.HX = lVar.HX;
        this.HY = lVar.HY;
        this.HZ = lVar.HZ;
        this.Ia = lVar.Ia;
        this.Ib = lVar.Ib;
        this.Ic = lVar.Ic;
        this.Id = lVar.Id;
        this.Ie = lVar.Ie;
        this.Hp = lVar.Hp;
    }

    public boolean lV() {
        return this.HZ;
    }

    public int lW() {
        return this.HX;
    }

    public int lX() {
        return this.HY;
    }

    public boolean getTcpNoDelay() {
        return this.Ia;
    }

    public int lY() {
        return this.Ib;
    }

    public int lZ() {
        return this.Ic;
    }

    public boolean ma() {
        return this.Id;
    }

    public boolean mb() {
        return this.Ie;
    }

    public String mc() {
        return this.Hp;
    }

    public void bF(String str) {
        this.Hp = str;
    }
}
