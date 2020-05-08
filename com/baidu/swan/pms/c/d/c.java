package com.baidu.swan.pms.c.d;
/* loaded from: classes11.dex */
public class c extends f {
    private String dbq;
    private int dbr;
    private long dbs;
    private String dbt;
    private String dbu;
    private int dbv;
    private String mPath;

    public c(String str, int i) {
        super(i);
        this.dbr = -1;
        this.dbs = -1L;
        this.dbv = -1;
        this.dbq = str;
    }

    public c iQ(int i) {
        this.dbv = i;
        return this;
    }

    public int aCA() {
        return this.dbv;
    }

    public c rI(String str) {
        this.dbt = str;
        return this;
    }

    public c iR(int i) {
        this.dbr = i;
        return this;
    }

    public c bQ(long j) {
        this.dbs = j;
        return this;
    }

    public c rJ(String str) {
        this.dbu = str;
        return this;
    }

    public c rK(String str) {
        this.mPath = str;
        return this;
    }

    public String getBundleId() {
        return this.dbq;
    }

    public int aCy() {
        return this.dbr;
    }

    public long aCz() {
        return this.dbs;
    }

    public String aCB() {
        return this.dbt;
    }

    public String aCC() {
        return this.dbu;
    }

    public String getPath() {
        return this.mPath;
    }
}
