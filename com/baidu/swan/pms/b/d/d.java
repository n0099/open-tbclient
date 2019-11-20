package com.baidu.swan.pms.b.d;
/* loaded from: classes2.dex */
public class d extends e {
    private String bMb;
    private int bMc;
    private String bMd;
    private String bMf;
    private String bMi;

    public d(String str, int i, String str2, int i2) {
        super(i2);
        this.bMb = str;
        this.bMi = str2;
        this.bMc = i;
    }

    public d le(String str) {
        this.bMd = str;
        return this;
    }

    public void lf(String str) {
        this.bMf = str;
    }

    public String getBundleId() {
        return this.bMb;
    }

    public String abH() {
        return this.bMi;
    }

    public int abB() {
        return this.bMc;
    }

    public String abD() {
        return this.bMd;
    }

    public String abE() {
        return this.bMf;
    }
}
