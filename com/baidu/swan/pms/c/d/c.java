package com.baidu.swan.pms.c.d;
/* loaded from: classes15.dex */
public class c extends g {
    private String ecP;
    private long ecQ;
    private long ecR;
    private String ecS;
    private String ecT;
    private int ecU;
    private String mPath;

    public c(String str, int i) {
        super(i);
        this.ecQ = -1L;
        this.ecR = -1L;
        this.ecU = -1;
        this.ecP = str;
    }

    public c mM(int i) {
        this.ecU = i;
        return this;
    }

    public int aZA() {
        return this.ecU;
    }

    public c yg(String str) {
        this.ecS = str;
        return this;
    }

    public c cw(long j) {
        this.ecQ = j;
        return this;
    }

    public c cx(long j) {
        this.ecR = j;
        return this;
    }

    public c yh(String str) {
        this.ecT = str;
        return this;
    }

    public c yi(String str) {
        this.mPath = str;
        return this;
    }

    public String getBundleId() {
        return this.ecP;
    }

    public long aZy() {
        return this.ecQ;
    }

    public long aZz() {
        return this.ecR;
    }

    public String aZB() {
        return this.ecS;
    }

    public String aZC() {
        return this.ecT;
    }

    public String getPath() {
        return this.mPath;
    }
}
