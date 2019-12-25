package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private String uM;
    private boolean vA;
    private boolean vB;
    private int vu;
    private int vv;
    private boolean vw;
    private boolean vx;
    private int vy;
    private int vz;

    public l() {
        this.uM = null;
        this.vu = 32768;
        this.vv = 131072;
        this.vw = false;
        this.vx = true;
        this.vy = 30000;
        this.vz = 30000;
        this.vA = true;
        this.vB = true;
        this.uM = null;
    }

    public l(l lVar) {
        this.uM = null;
        this.vu = lVar.vu;
        this.vv = lVar.vv;
        this.vw = lVar.vw;
        this.vx = lVar.vx;
        this.vy = lVar.vy;
        this.vz = lVar.vz;
        this.vA = lVar.vA;
        this.vB = lVar.vB;
        this.uM = lVar.uM;
    }

    public boolean ia() {
        return this.vw;
    }

    public int ib() {
        return this.vu;
    }

    public int ic() {
        return this.vv;
    }

    public boolean getTcpNoDelay() {
        return this.vx;
    }

    public int id() {
        return this.vy;
    }

    public int ie() {
        return this.vz;
    }

    /* renamed from: if  reason: not valid java name */
    public boolean m9if() {
        return this.vA;
    }

    public boolean ig() {
        return this.vB;
    }

    public String ih() {
        return this.uM;
    }

    public void aK(String str) {
        this.uM = str;
    }
}
