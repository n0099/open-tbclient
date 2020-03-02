package com.baidu.swan.pms.c.d;
/* loaded from: classes11.dex */
public class e extends f {
    private String cBZ;
    private int cCa;
    private String cCc;
    private String cCd;
    private int cCe;
    private String cCg;

    public e(String str, int i, String str2, int i2) {
        super(i2);
        this.cCe = -1;
        this.cBZ = str;
        this.cCg = str2;
        this.cCa = i;
    }

    public e qA(String str) {
        this.cCc = str;
        return this;
    }

    public int aum() {
        return this.cCe;
    }

    public void qB(String str) {
        this.cCd = str;
    }

    public String getBundleId() {
        return this.cBZ;
    }

    public String aur() {
        return this.cCg;
    }

    public int auk() {
        return this.cCa;
    }

    public String aun() {
        return this.cCc;
    }

    public String auo() {
        return this.cCd;
    }
}
