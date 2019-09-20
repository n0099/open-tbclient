package com.baidu.swan.pms.b.d;
/* loaded from: classes2.dex */
public class d extends e {
    private String bui;
    private int buj;
    private String buk;
    private String bum;
    private String bup;

    public d(String str, int i, String str2, int i2) {
        super(i2);
        this.bui = str;
        this.bup = str2;
        this.buj = i;
    }

    public d kC(String str) {
        this.buk = str;
        return this;
    }

    public void kD(String str) {
        this.bum = str;
    }

    public String getBundleId() {
        return this.bui;
    }

    public String WU() {
        return this.bup;
    }

    public int WO() {
        return this.buj;
    }

    public String WQ() {
        return this.buk;
    }

    public String WR() {
        return this.bum;
    }
}
