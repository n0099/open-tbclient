package com.baidu.swan.pms.c.d;
/* loaded from: classes11.dex */
public class e extends f {
    private String dbq;
    private int dbr;
    private String dbt;
    private String dbu;
    private int dbv;
    private String dbx;

    public e(String str, int i, String str2, int i2) {
        super(i2);
        this.dbv = -1;
        this.dbq = str;
        this.dbx = str2;
        this.dbr = i;
    }

    public e rM(String str) {
        this.dbt = str;
        return this;
    }

    public int aCA() {
        return this.dbv;
    }

    public void rN(String str) {
        this.dbu = str;
    }

    public String getBundleId() {
        return this.dbq;
    }

    public String aCF() {
        return this.dbx;
    }

    public int aCy() {
        return this.dbr;
    }

    public String aCB() {
        return this.dbt;
    }

    public String aCC() {
        return this.dbu;
    }
}
