package com.baidu.swan.pms.c.d;
/* loaded from: classes15.dex */
public class c extends g {
    private String eiH;
    private long eiI;
    private long eiJ;
    private String eiK;
    private String eiL;
    private int eiM;
    private String mPath;

    public c(String str, int i) {
        super(i);
        this.eiI = -1L;
        this.eiJ = -1L;
        this.eiM = -1;
        this.eiH = str;
    }

    public c mW(int i) {
        this.eiM = i;
        return this;
    }

    public int bca() {
        return this.eiM;
    }

    public c yu(String str) {
        this.eiK = str;
        return this;
    }

    public c cS(long j) {
        this.eiI = j;
        return this;
    }

    public c cT(long j) {
        this.eiJ = j;
        return this;
    }

    public c yv(String str) {
        this.eiL = str;
        return this;
    }

    public c yw(String str) {
        this.mPath = str;
        return this;
    }

    public String getBundleId() {
        return this.eiH;
    }

    public long bbY() {
        return this.eiI;
    }

    public long bbZ() {
        return this.eiJ;
    }

    public String bcb() {
        return this.eiK;
    }

    public String bcc() {
        return this.eiL;
    }

    public String getPath() {
        return this.mPath;
    }
}
