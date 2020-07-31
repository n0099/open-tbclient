package com.baidu.swan.pms.c.d;
/* loaded from: classes19.dex */
public class c extends g {
    private String dxf;
    private int dxg;
    private long dxh;
    private String dxi;
    private String dxj;
    private int dxk;
    private String mPath;

    public c(String str, int i) {
        super(i);
        this.dxg = -1;
        this.dxh = -1L;
        this.dxk = -1;
        this.dxf = str;
    }

    public c jM(int i) {
        this.dxk = i;
        return this;
    }

    public int aLN() {
        return this.dxk;
    }

    public c uy(String str) {
        this.dxi = str;
        return this;
    }

    public c jN(int i) {
        this.dxg = i;
        return this;
    }

    public c ce(long j) {
        this.dxh = j;
        return this;
    }

    public c uz(String str) {
        this.dxj = str;
        return this;
    }

    public c uA(String str) {
        this.mPath = str;
        return this;
    }

    public String getBundleId() {
        return this.dxf;
    }

    public int aLL() {
        return this.dxg;
    }

    public long aLM() {
        return this.dxh;
    }

    public String aLO() {
        return this.dxi;
    }

    public String aLP() {
        return this.dxj;
    }

    public String getPath() {
        return this.mPath;
    }
}
