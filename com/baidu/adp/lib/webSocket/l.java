package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private String anK;
    private boolean aoA;
    private int aoB;
    private int aoC;
    private boolean aoD;
    private boolean aoE;
    private int aox;
    private int aoy;
    private boolean aoz;

    public l() {
        this.anK = null;
        this.aox = 32768;
        this.aoy = 131072;
        this.aoz = false;
        this.aoA = true;
        this.aoB = 30000;
        this.aoC = 30000;
        this.aoD = true;
        this.aoE = true;
        this.anK = null;
    }

    public l(l lVar) {
        this.anK = null;
        this.aox = lVar.aox;
        this.aoy = lVar.aoy;
        this.aoz = lVar.aoz;
        this.aoA = lVar.aoA;
        this.aoB = lVar.aoB;
        this.aoC = lVar.aoC;
        this.aoD = lVar.aoD;
        this.aoE = lVar.aoE;
        this.anK = lVar.anK;
    }

    public boolean pK() {
        return this.aoz;
    }

    public int pL() {
        return this.aox;
    }

    public int pM() {
        return this.aoy;
    }

    public boolean getTcpNoDelay() {
        return this.aoA;
    }

    public int pN() {
        return this.aoB;
    }

    public int pO() {
        return this.aoC;
    }

    public boolean pP() {
        return this.aoD;
    }

    public boolean pQ() {
        return this.aoE;
    }

    public String pR() {
        return this.anK;
    }

    public void bd(String str) {
        this.anK = str;
    }
}
