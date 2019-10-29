package com.baidu.swan.pms.b.d;
/* loaded from: classes2.dex */
public class d extends e {
    private String bMS;
    private int bMT;
    private String bMU;
    private String bMW;
    private String bMZ;

    public d(String str, int i, String str2, int i2) {
        super(i2);
        this.bMS = str;
        this.bMZ = str2;
        this.bMT = i;
    }

    public d le(String str) {
        this.bMU = str;
        return this;
    }

    public void lf(String str) {
        this.bMW = str;
    }

    public String getBundleId() {
        return this.bMS;
    }

    public String abJ() {
        return this.bMZ;
    }

    public int abD() {
        return this.bMT;
    }

    public String abF() {
        return this.bMU;
    }

    public String abG() {
        return this.bMW;
    }
}
