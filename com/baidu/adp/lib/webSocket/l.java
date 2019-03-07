package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private String Ht;
    private int Ig;
    private int Ih;
    private boolean Ii;
    private boolean Ij;
    private int Ik;
    private int Il;
    private boolean Im;
    private boolean In;

    public l() {
        this.Ht = null;
        this.Ig = 32768;
        this.Ih = 131072;
        this.Ii = false;
        this.Ij = true;
        this.Ik = 30000;
        this.Il = 30000;
        this.Im = true;
        this.In = true;
        this.Ht = null;
    }

    public l(l lVar) {
        this.Ht = null;
        this.Ig = lVar.Ig;
        this.Ih = lVar.Ih;
        this.Ii = lVar.Ii;
        this.Ij = lVar.Ij;
        this.Ik = lVar.Ik;
        this.Il = lVar.Il;
        this.Im = lVar.Im;
        this.In = lVar.In;
        this.Ht = lVar.Ht;
    }

    public boolean lX() {
        return this.Ii;
    }

    public int lY() {
        return this.Ig;
    }

    public int lZ() {
        return this.Ih;
    }

    public boolean getTcpNoDelay() {
        return this.Ij;
    }

    public int ma() {
        return this.Ik;
    }

    public int mb() {
        return this.Il;
    }

    public boolean mc() {
        return this.Im;
    }

    public boolean md() {
        return this.In;
    }

    public String me() {
        return this.Ht;
    }

    public void bF(String str) {
        this.Ht = str;
    }
}
