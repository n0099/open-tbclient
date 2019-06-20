package com.baidu.swan.pms.b.d;
/* loaded from: classes2.dex */
public class d extends e {
    private String bsT;
    private int bsU;
    private String bsV;
    private String bsX;
    private String bta;

    public d(String str, int i, String str2, int i2) {
        super(i2);
        this.bsT = str;
        this.bta = str2;
        this.bsU = i;
    }

    public d ks(String str) {
        this.bsV = str;
        return this;
    }

    public void kt(String str) {
        this.bsX = str;
    }

    public String getBundleId() {
        return this.bsT;
    }

    public String VX() {
        return this.bta;
    }

    public int VR() {
        return this.bsU;
    }

    public String VT() {
        return this.bsV;
    }

    public String VU() {
        return this.bsX;
    }
}
