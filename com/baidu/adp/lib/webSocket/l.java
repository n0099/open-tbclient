package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private String Ht;
    private int Ib;
    private int Ic;
    private boolean Id;
    private boolean Ie;
    private int If;
    private int Ig;
    private boolean Ih;
    private boolean Ii;

    public l() {
        this.Ht = null;
        this.Ib = 32768;
        this.Ic = 131072;
        this.Id = false;
        this.Ie = true;
        this.If = 30000;
        this.Ig = 30000;
        this.Ih = true;
        this.Ii = true;
        this.Ht = null;
    }

    public l(l lVar) {
        this.Ht = null;
        this.Ib = lVar.Ib;
        this.Ic = lVar.Ic;
        this.Id = lVar.Id;
        this.Ie = lVar.Ie;
        this.If = lVar.If;
        this.Ig = lVar.Ig;
        this.Ih = lVar.Ih;
        this.Ii = lVar.Ii;
        this.Ht = lVar.Ht;
    }

    public boolean lT() {
        return this.Id;
    }

    public int lU() {
        return this.Ib;
    }

    public int lV() {
        return this.Ic;
    }

    public boolean getTcpNoDelay() {
        return this.Ie;
    }

    public int lW() {
        return this.If;
    }

    public int lX() {
        return this.Ig;
    }

    public boolean lY() {
        return this.Ih;
    }

    public boolean lZ() {
        return this.Ii;
    }

    public String ma() {
        return this.Ht;
    }

    public void bF(String str) {
        this.Ht = str;
    }
}
