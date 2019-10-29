package com.baidu.swan.pms.b.d;
/* loaded from: classes2.dex */
public class b extends e {
    private String bMS;
    private int bMT;
    private String bMU;
    private long bMV;
    private String bMW;
    private String mPath;

    public b(String str, int i) {
        super(i);
        this.bMT = -1;
        this.bMV = -1L;
        this.bMS = str;
    }

    public b la(String str) {
        this.bMU = str;
        return this;
    }

    public b gH(int i) {
        this.bMT = i;
        return this;
    }

    public b aA(long j) {
        this.bMV = j;
        return this;
    }

    public b lb(String str) {
        this.bMW = str;
        return this;
    }

    public b lc(String str) {
        this.mPath = str;
        return this;
    }

    public String getBundleId() {
        return this.bMS;
    }

    public int abD() {
        return this.bMT;
    }

    public long abE() {
        return this.bMV;
    }

    public String abF() {
        return this.bMU;
    }

    public String abG() {
        return this.bMW;
    }

    public String getPath() {
        return this.mPath;
    }
}
