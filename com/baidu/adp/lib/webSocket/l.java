package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private String rR;
    private int sI;
    private int sJ;
    private boolean sK;
    private boolean sL;
    private int sM;
    private int sN;
    private boolean sO;
    private boolean sP;

    public l() {
        this.rR = null;
        this.sI = 32768;
        this.sJ = 131072;
        this.sK = false;
        this.sL = true;
        this.sM = 30000;
        this.sN = 30000;
        this.sO = true;
        this.sP = true;
        this.rR = null;
    }

    public l(l lVar) {
        this.rR = null;
        this.sI = lVar.sI;
        this.sJ = lVar.sJ;
        this.sK = lVar.sK;
        this.sL = lVar.sL;
        this.sM = lVar.sM;
        this.sN = lVar.sN;
        this.sO = lVar.sO;
        this.sP = lVar.sP;
        this.rR = lVar.rR;
    }

    public boolean hF() {
        return this.sK;
    }

    public int hG() {
        return this.sI;
    }

    public int hH() {
        return this.sJ;
    }

    public boolean hI() {
        return this.sL;
    }

    public int hJ() {
        return this.sM;
    }

    public int hK() {
        return this.sN;
    }

    public boolean hL() {
        return this.sO;
    }

    public boolean hM() {
        return this.sP;
    }

    public String hN() {
        return this.rR;
    }

    public void ay(String str) {
        this.rR = str;
    }
}
