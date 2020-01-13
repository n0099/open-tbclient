package com.baidu.swan.pms.c.d;
/* loaded from: classes10.dex */
public class e extends f {
    private String cya;
    private int cyb;
    private String cyd;
    private String cye;
    private int cyf;
    private String cyh;

    public e(String str, int i, String str2, int i2) {
        super(i2);
        this.cyf = -1;
        this.cya = str;
        this.cyh = str2;
        this.cyb = i;
    }

    public e ql(String str) {
        this.cyd = str;
        return this;
    }

    public int arW() {
        return this.cyf;
    }

    public void qm(String str) {
        this.cye = str;
    }

    public String getBundleId() {
        return this.cya;
    }

    public String asb() {
        return this.cyh;
    }

    public int arU() {
        return this.cyb;
    }

    public String arX() {
        return this.cyd;
    }

    public String arY() {
        return this.cye;
    }
}
