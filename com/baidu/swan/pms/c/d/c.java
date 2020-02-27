package com.baidu.swan.pms.c.d;
/* loaded from: classes11.dex */
public class c extends f {
    private String cBY;
    private int cBZ;
    private long cCa;
    private String cCb;
    private String cCc;
    private int cCd;
    private String mPath;

    public c(String str, int i) {
        super(i);
        this.cBZ = -1;
        this.cCa = -1L;
        this.cCd = -1;
        this.cBY = str;
    }

    public c iJ(int i) {
        this.cCd = i;
        return this;
    }

    public int auk() {
        return this.cCd;
    }

    public c qw(String str) {
        this.cCb = str;
        return this;
    }

    public c iK(int i) {
        this.cBZ = i;
        return this;
    }

    public c bl(long j) {
        this.cCa = j;
        return this;
    }

    public c qx(String str) {
        this.cCc = str;
        return this;
    }

    public c qy(String str) {
        this.mPath = str;
        return this;
    }

    public String getBundleId() {
        return this.cBY;
    }

    public int aui() {
        return this.cBZ;
    }

    public long auj() {
        return this.cCa;
    }

    public String aul() {
        return this.cCb;
    }

    public String aum() {
        return this.cCc;
    }

    public String getPath() {
        return this.mPath;
    }
}
