package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private String anJ;
    private int aoA;
    private int aoB;
    private boolean aoC;
    private boolean aoD;
    private int aow;
    private int aox;
    private boolean aoy;
    private boolean aoz;

    public l() {
        this.anJ = null;
        this.aow = 32768;
        this.aox = 131072;
        this.aoy = false;
        this.aoz = true;
        this.aoA = 30000;
        this.aoB = 30000;
        this.aoC = true;
        this.aoD = true;
        this.anJ = null;
    }

    public l(l lVar) {
        this.anJ = null;
        this.aow = lVar.aow;
        this.aox = lVar.aox;
        this.aoy = lVar.aoy;
        this.aoz = lVar.aoz;
        this.aoA = lVar.aoA;
        this.aoB = lVar.aoB;
        this.aoC = lVar.aoC;
        this.aoD = lVar.aoD;
        this.anJ = lVar.anJ;
    }

    public boolean pJ() {
        return this.aoy;
    }

    public int pK() {
        return this.aow;
    }

    public int pL() {
        return this.aox;
    }

    public boolean getTcpNoDelay() {
        return this.aoz;
    }

    public int pM() {
        return this.aoA;
    }

    public int pN() {
        return this.aoB;
    }

    public boolean pO() {
        return this.aoC;
    }

    public boolean pP() {
        return this.aoD;
    }

    public String pQ() {
        return this.anJ;
    }

    public void bd(String str) {
        this.anJ = str;
    }
}
