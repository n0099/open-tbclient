package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private String anL;
    private boolean aoA;
    private boolean aoB;
    private int aoC;
    private int aoD;
    private boolean aoE;
    private boolean aoF;
    private int aoy;
    private int aoz;

    public l() {
        this.anL = null;
        this.aoy = 32768;
        this.aoz = 131072;
        this.aoA = false;
        this.aoB = true;
        this.aoC = 30000;
        this.aoD = 30000;
        this.aoE = true;
        this.aoF = true;
        this.anL = null;
    }

    public l(l lVar) {
        this.anL = null;
        this.aoy = lVar.aoy;
        this.aoz = lVar.aoz;
        this.aoA = lVar.aoA;
        this.aoB = lVar.aoB;
        this.aoC = lVar.aoC;
        this.aoD = lVar.aoD;
        this.aoE = lVar.aoE;
        this.aoF = lVar.aoF;
        this.anL = lVar.anL;
    }

    public boolean pK() {
        return this.aoA;
    }

    public int pL() {
        return this.aoy;
    }

    public int pM() {
        return this.aoz;
    }

    public boolean getTcpNoDelay() {
        return this.aoB;
    }

    public int pN() {
        return this.aoC;
    }

    public int pO() {
        return this.aoD;
    }

    public boolean pP() {
        return this.aoE;
    }

    public boolean pQ() {
        return this.aoF;
    }

    public String pR() {
        return this.anL;
    }

    public void bd(String str) {
        this.anL = str;
    }
}
