package com.baidu.swan.pms.c.d;
/* loaded from: classes11.dex */
public class e extends f {
    private String drn;
    private int dro;
    private String drq;
    private String drr;
    private int drt;
    private String drv;

    public e(String str, int i, String str2, int i2) {
        super(i2);
        this.drt = -1;
        this.drn = str;
        this.drv = str2;
        this.dro = i;
    }

    public e tz(String str) {
        this.drq = str;
        return this;
    }

    public int aHW() {
        return this.drt;
    }

    public void tA(String str) {
        this.drr = str;
    }

    public String getBundleId() {
        return this.drn;
    }

    public String aIb() {
        return this.drv;
    }

    public int aHU() {
        return this.dro;
    }

    public String aHX() {
        return this.drq;
    }

    public String aHY() {
        return this.drr;
    }
}
