package com.baidu.adp.lib.webSocket;
/* loaded from: classes.dex */
public class l {
    private String uP;
    private boolean vA;
    private int vB;
    private int vC;
    private boolean vD;
    private boolean vE;
    private int vx;
    private int vy;
    private boolean vz;

    public l() {
        this.uP = null;
        this.vx = 32768;
        this.vy = 131072;
        this.vz = false;
        this.vA = true;
        this.vB = 30000;
        this.vC = 30000;
        this.vD = true;
        this.vE = true;
        this.uP = null;
    }

    public l(l lVar) {
        this.uP = null;
        this.vx = lVar.vx;
        this.vy = lVar.vy;
        this.vz = lVar.vz;
        this.vA = lVar.vA;
        this.vB = lVar.vB;
        this.vC = lVar.vC;
        this.vD = lVar.vD;
        this.vE = lVar.vE;
        this.uP = lVar.uP;
    }

    public boolean hZ() {
        return this.vz;
    }

    public int ia() {
        return this.vx;
    }

    public int ib() {
        return this.vy;
    }

    public boolean getTcpNoDelay() {
        return this.vA;
    }

    public int ic() {
        return this.vB;
    }

    public int id() {
        return this.vC;
    }

    public boolean ie() {
        return this.vD;
    }

    /* renamed from: if  reason: not valid java name */
    public boolean m10if() {
        return this.vE;
    }

    public String ig() {
        return this.uP;
    }

    public void aK(String str) {
        this.uP = str;
    }
}
