package com.baidu.swan.pms.c.d;
/* loaded from: classes11.dex */
public class e extends f {
    private String cCa;
    private int cCb;
    private String cCd;
    private String cCe;
    private int cCf;
    private String cCh;

    public e(String str, int i, String str2, int i2) {
        super(i2);
        this.cCf = -1;
        this.cCa = str;
        this.cCh = str2;
        this.cCb = i;
    }

    public e qA(String str) {
        this.cCd = str;
        return this;
    }

    public int aum() {
        return this.cCf;
    }

    public void qB(String str) {
        this.cCe = str;
    }

    public String getBundleId() {
        return this.cCa;
    }

    public String aur() {
        return this.cCh;
    }

    public int auk() {
        return this.cCb;
    }

    public String aun() {
        return this.cCd;
    }

    public String auo() {
        return this.cCe;
    }
}
