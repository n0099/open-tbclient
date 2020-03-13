package com.baidu.swan.pms.c.d;
/* loaded from: classes11.dex */
public class c extends f {
    private String cCa;
    private int cCb;
    private long cCc;
    private String cCd;
    private String cCe;
    private int cCf;
    private String mPath;

    public c(String str, int i) {
        super(i);
        this.cCb = -1;
        this.cCc = -1L;
        this.cCf = -1;
        this.cCa = str;
    }

    public c iJ(int i) {
        this.cCf = i;
        return this;
    }

    public int aum() {
        return this.cCf;
    }

    public c qw(String str) {
        this.cCd = str;
        return this;
    }

    public c iK(int i) {
        this.cCb = i;
        return this;
    }

    public c bl(long j) {
        this.cCc = j;
        return this;
    }

    public c qx(String str) {
        this.cCe = str;
        return this;
    }

    public c qy(String str) {
        this.mPath = str;
        return this;
    }

    public String getBundleId() {
        return this.cCa;
    }

    public int auk() {
        return this.cCb;
    }

    public long aul() {
        return this.cCc;
    }

    public String aun() {
        return this.cCd;
    }

    public String auo() {
        return this.cCe;
    }

    public String getPath() {
        return this.mPath;
    }
}
