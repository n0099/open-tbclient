package com.baidu.swan.pms.c.d;
/* loaded from: classes6.dex */
public class c extends g {
    private String eha;
    private long ehb;
    private long ehc;
    private String ehd;
    private String ehe;
    private int ehf;
    private String mPath;

    public c(String str, int i) {
        super(i);
        this.ehb = -1L;
        this.ehc = -1L;
        this.ehf = -1;
        this.eha = str;
    }

    public c mS(int i) {
        this.ehf = i;
        return this;
    }

    public int bbt() {
        return this.ehf;
    }

    public c yp(String str) {
        this.ehd = str;
        return this;
    }

    public c cS(long j) {
        this.ehb = j;
        return this;
    }

    public c cT(long j) {
        this.ehc = j;
        return this;
    }

    public c yq(String str) {
        this.ehe = str;
        return this;
    }

    public c yr(String str) {
        this.mPath = str;
        return this;
    }

    public String getBundleId() {
        return this.eha;
    }

    public long bbr() {
        return this.ehb;
    }

    public long bbs() {
        return this.ehc;
    }

    public String bbu() {
        return this.ehd;
    }

    public String bbv() {
        return this.ehe;
    }

    public String getPath() {
        return this.mPath;
    }
}
