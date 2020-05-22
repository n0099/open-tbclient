package com.baidu.swan.pms.c.d;
/* loaded from: classes11.dex */
public class c extends f {
    private String dmC;
    private int dmD;
    private long dmE;
    private String dmF;
    private String dmG;
    private int dmH;
    private String mPath;

    public c(String str, int i) {
        super(i);
        this.dmD = -1;
        this.dmE = -1L;
        this.dmH = -1;
        this.dmC = str;
    }

    public c jg(int i) {
        this.dmH = i;
        return this;
    }

    public int aGQ() {
        return this.dmH;
    }

    public c tn(String str) {
        this.dmF = str;
        return this;
    }

    public c jh(int i) {
        this.dmD = i;
        return this;
    }

    public c bO(long j) {
        this.dmE = j;
        return this;
    }

    public c to(String str) {
        this.dmG = str;
        return this;
    }

    public c tp(String str) {
        this.mPath = str;
        return this;
    }

    public String getBundleId() {
        return this.dmC;
    }

    public int aGO() {
        return this.dmD;
    }

    public long aGP() {
        return this.dmE;
    }

    public String aGR() {
        return this.dmF;
    }

    public String aGS() {
        return this.dmG;
    }

    public String getPath() {
        return this.mPath;
    }
}
