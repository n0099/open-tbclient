package com.baidu.swan.pms.c.d;
/* loaded from: classes15.dex */
public class c extends g {
    private String dUt;
    private long dUu;
    private long dUv;
    private String dUw;
    private String dUx;
    private int dUy;
    private String mPath;

    public c(String str, int i) {
        super(i);
        this.dUu = -1L;
        this.dUv = -1L;
        this.dUy = -1;
        this.dUt = str;
    }

    public c mB(int i) {
        this.dUy = i;
        return this;
    }

    public int aXH() {
        return this.dUy;
    }

    public c xN(String str) {
        this.dUw = str;
        return this;
    }

    public c cu(long j) {
        this.dUu = j;
        return this;
    }

    public c cv(long j) {
        this.dUv = j;
        return this;
    }

    public c xO(String str) {
        this.dUx = str;
        return this;
    }

    public c xP(String str) {
        this.mPath = str;
        return this;
    }

    public String getBundleId() {
        return this.dUt;
    }

    public long aXF() {
        return this.dUu;
    }

    public long aXG() {
        return this.dUv;
    }

    public String aXI() {
        return this.dUw;
    }

    public String aXJ() {
        return this.dUx;
    }

    public String getPath() {
        return this.mPath;
    }
}
