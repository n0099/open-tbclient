package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private String anI;
    private int aoA;
    private boolean aoB;
    private boolean aoC;
    private int aov;
    private int aow;
    private boolean aox;
    private boolean aoy;
    private int aoz;

    public l() {
        this.anI = null;
        this.aov = 32768;
        this.aow = 131072;
        this.aox = false;
        this.aoy = true;
        this.aoz = 30000;
        this.aoA = 30000;
        this.aoB = true;
        this.aoC = true;
        this.anI = null;
    }

    public l(l lVar) {
        this.anI = null;
        this.aov = lVar.aov;
        this.aow = lVar.aow;
        this.aox = lVar.aox;
        this.aoy = lVar.aoy;
        this.aoz = lVar.aoz;
        this.aoA = lVar.aoA;
        this.aoB = lVar.aoB;
        this.aoC = lVar.aoC;
        this.anI = lVar.anI;
    }

    public boolean pJ() {
        return this.aox;
    }

    public int pK() {
        return this.aov;
    }

    public int pL() {
        return this.aow;
    }

    public boolean getTcpNoDelay() {
        return this.aoy;
    }

    public int pM() {
        return this.aoz;
    }

    public int pN() {
        return this.aoA;
    }

    public boolean pO() {
        return this.aoB;
    }

    public boolean pP() {
        return this.aoC;
    }

    public String pQ() {
        return this.anI;
    }

    public void bd(String str) {
        this.anI = str;
    }
}
