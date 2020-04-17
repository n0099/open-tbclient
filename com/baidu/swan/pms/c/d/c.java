package com.baidu.swan.pms.c.d;
/* loaded from: classes11.dex */
public class c extends f {
    private String dbl;
    private int dbm;
    private long dbn;
    private String dbo;
    private String dbp;
    private int dbq;
    private String mPath;

    public c(String str, int i) {
        super(i);
        this.dbm = -1;
        this.dbn = -1L;
        this.dbq = -1;
        this.dbl = str;
    }

    public c iQ(int i) {
        this.dbq = i;
        return this;
    }

    public int aCA() {
        return this.dbq;
    }

    public c rI(String str) {
        this.dbo = str;
        return this;
    }

    public c iR(int i) {
        this.dbm = i;
        return this;
    }

    public c bQ(long j) {
        this.dbn = j;
        return this;
    }

    public c rJ(String str) {
        this.dbp = str;
        return this;
    }

    public c rK(String str) {
        this.mPath = str;
        return this;
    }

    public String getBundleId() {
        return this.dbl;
    }

    public int aCy() {
        return this.dbm;
    }

    public long aCz() {
        return this.dbn;
    }

    public String aCB() {
        return this.dbo;
    }

    public String aCC() {
        return this.dbp;
    }

    public String getPath() {
        return this.mPath;
    }
}
