package com.baidu.swan.pms.c.d;
/* loaded from: classes11.dex */
public class c extends f {
    private String cBZ;
    private int cCa;
    private long cCb;
    private String cCc;
    private String cCd;
    private int cCe;
    private String mPath;

    public c(String str, int i) {
        super(i);
        this.cCa = -1;
        this.cCb = -1L;
        this.cCe = -1;
        this.cBZ = str;
    }

    public c iJ(int i) {
        this.cCe = i;
        return this;
    }

    public int aum() {
        return this.cCe;
    }

    public c qw(String str) {
        this.cCc = str;
        return this;
    }

    public c iK(int i) {
        this.cCa = i;
        return this;
    }

    public c bl(long j) {
        this.cCb = j;
        return this;
    }

    public c qx(String str) {
        this.cCd = str;
        return this;
    }

    public c qy(String str) {
        this.mPath = str;
        return this;
    }

    public String getBundleId() {
        return this.cBZ;
    }

    public int auk() {
        return this.cCa;
    }

    public long aul() {
        return this.cCb;
    }

    public String aun() {
        return this.cCc;
    }

    public String auo() {
        return this.cCd;
    }

    public String getPath() {
        return this.mPath;
    }
}
