package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private String anE;
    private int aor;
    private int aos;
    private boolean aot;
    private boolean aou;
    private int aov;
    private int aow;
    private boolean aox;
    private boolean aoy;

    public l() {
        this.anE = null;
        this.aor = 32768;
        this.aos = 131072;
        this.aot = false;
        this.aou = true;
        this.aov = 30000;
        this.aow = 30000;
        this.aox = true;
        this.aoy = true;
        this.anE = null;
    }

    public l(l lVar) {
        this.anE = null;
        this.aor = lVar.aor;
        this.aos = lVar.aos;
        this.aot = lVar.aot;
        this.aou = lVar.aou;
        this.aov = lVar.aov;
        this.aow = lVar.aow;
        this.aox = lVar.aox;
        this.aoy = lVar.aoy;
        this.anE = lVar.anE;
    }

    public boolean pK() {
        return this.aot;
    }

    public int pL() {
        return this.aor;
    }

    public int pM() {
        return this.aos;
    }

    public boolean getTcpNoDelay() {
        return this.aou;
    }

    public int pN() {
        return this.aov;
    }

    public int pO() {
        return this.aow;
    }

    public boolean pP() {
        return this.aox;
    }

    public boolean pQ() {
        return this.aoy;
    }

    public String pR() {
        return this.anE;
    }

    public void bd(String str) {
        this.anE = str;
    }
}
