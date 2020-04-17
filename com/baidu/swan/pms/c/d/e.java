package com.baidu.swan.pms.c.d;
/* loaded from: classes11.dex */
public class e extends f {
    private String dbl;
    private int dbm;
    private String dbo;
    private String dbp;
    private int dbq;
    private String dbs;

    public e(String str, int i, String str2, int i2) {
        super(i2);
        this.dbq = -1;
        this.dbl = str;
        this.dbs = str2;
        this.dbm = i;
    }

    public e rM(String str) {
        this.dbo = str;
        return this;
    }

    public int aCA() {
        return this.dbq;
    }

    public void rN(String str) {
        this.dbp = str;
    }

    public String getBundleId() {
        return this.dbl;
    }

    public String aCF() {
        return this.dbs;
    }

    public int aCy() {
        return this.dbm;
    }

    public String aCB() {
        return this.dbo;
    }

    public String aCC() {
        return this.dbp;
    }
}
