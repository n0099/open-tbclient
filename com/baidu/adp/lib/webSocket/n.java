package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class n {
    private int AF;
    private int AG;
    private boolean AH;
    private boolean AI;
    private int AJ;
    private int AK;
    private boolean AL;
    private boolean AM;
    private String zR;

    public n() {
        this.zR = null;
        this.AF = 32768;
        this.AG = 131072;
        this.AH = false;
        this.AI = true;
        this.AJ = 30000;
        this.AK = 30000;
        this.AL = true;
        this.AM = true;
        this.zR = null;
    }

    public n(n nVar) {
        this.zR = null;
        this.AF = nVar.AF;
        this.AG = nVar.AG;
        this.AH = nVar.AH;
        this.AI = nVar.AI;
        this.AJ = nVar.AJ;
        this.AK = nVar.AK;
        this.AL = nVar.AL;
        this.AM = nVar.AM;
        this.zR = nVar.zR;
    }

    public boolean ka() {
        return this.AH;
    }

    public int kb() {
        return this.AF;
    }

    public int kd() {
        return this.AG;
    }

    public boolean getTcpNoDelay() {
        return this.AI;
    }

    public int ke() {
        return this.AJ;
    }

    public int kf() {
        return this.AK;
    }

    public boolean kg() {
        return this.AL;
    }

    public boolean kh() {
        return this.AM;
    }

    public String ki() {
        return this.zR;
    }

    public void aZ(String str) {
        this.zR = str;
    }
}
