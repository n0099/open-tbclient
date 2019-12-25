package com.baidu.swan.pms.c.d;
/* loaded from: classes9.dex */
public class c extends f {
    private String cxP;
    private int cxQ;
    private long cxR;
    private String cxS;
    private String cxT;
    private int cxU;
    private String mPath;

    public c(String str, int i) {
        super(i);
        this.cxQ = -1;
        this.cxR = -1L;
        this.cxU = -1;
        this.cxP = str;
    }

    public c is(int i) {
        this.cxU = i;
        return this;
    }

    public int arD() {
        return this.cxU;
    }

    public c qe(String str) {
        this.cxS = str;
        return this;
    }

    public c it(int i) {
        this.cxQ = i;
        return this;
    }

    public c be(long j) {
        this.cxR = j;
        return this;
    }

    public c qf(String str) {
        this.cxT = str;
        return this;
    }

    public c qg(String str) {
        this.mPath = str;
        return this;
    }

    public String getBundleId() {
        return this.cxP;
    }

    public int arB() {
        return this.cxQ;
    }

    public long arC() {
        return this.cxR;
    }

    public String arE() {
        return this.cxS;
    }

    public String arF() {
        return this.cxT;
    }

    public String getPath() {
        return this.mPath;
    }
}
