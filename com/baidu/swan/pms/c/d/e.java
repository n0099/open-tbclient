package com.baidu.swan.pms.c.d;
/* loaded from: classes11.dex */
public class e extends f {
    private String cBY;
    private int cBZ;
    private String cCb;
    private String cCc;
    private int cCd;
    private String cCf;

    public e(String str, int i, String str2, int i2) {
        super(i2);
        this.cCd = -1;
        this.cBY = str;
        this.cCf = str2;
        this.cBZ = i;
    }

    public e qA(String str) {
        this.cCb = str;
        return this;
    }

    public int auk() {
        return this.cCd;
    }

    public void qB(String str) {
        this.cCc = str;
    }

    public String getBundleId() {
        return this.cBY;
    }

    public String aup() {
        return this.cCf;
    }

    public int aui() {
        return this.cBZ;
    }

    public String aul() {
        return this.cCb;
    }

    public String aum() {
        return this.cCc;
    }
}
