package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class n {
    private int tW;
    private int tX;
    private boolean tY;
    private boolean tZ;
    private String th;
    private int ua;
    private int ub;
    private boolean uc;
    private boolean ud;

    public n() {
        this.th = null;
        this.tW = 32768;
        this.tX = 131072;
        this.tY = false;
        this.tZ = true;
        this.ua = 30000;
        this.ub = 30000;
        this.uc = true;
        this.ud = true;
        this.th = null;
    }

    public n(n nVar) {
        this.th = null;
        this.tW = nVar.tW;
        this.tX = nVar.tX;
        this.tY = nVar.tY;
        this.tZ = nVar.tZ;
        this.ua = nVar.ua;
        this.ub = nVar.ub;
        this.uc = nVar.uc;
        this.ud = nVar.ud;
        this.th = nVar.th;
    }

    public boolean ho() {
        return this.tY;
    }

    public int hp() {
        return this.tW;
    }

    public int hq() {
        return this.tX;
    }

    public boolean getTcpNoDelay() {
        return this.tZ;
    }

    public int hr() {
        return this.ua;
    }

    public int hs() {
        return this.ub;
    }

    public boolean ht() {
        return this.uc;
    }

    public boolean hu() {
        return this.ud;
    }

    public String hv() {
        return this.th;
    }

    public void aW(String str) {
        this.th = str;
    }
}
