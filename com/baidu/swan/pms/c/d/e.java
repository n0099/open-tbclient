package com.baidu.swan.pms.c.d;
/* loaded from: classes9.dex */
public class e extends f {
    private String cxP;
    private int cxQ;
    private String cxS;
    private String cxT;
    private int cxU;
    private String cxW;

    public e(String str, int i, String str2, int i2) {
        super(i2);
        this.cxU = -1;
        this.cxP = str;
        this.cxW = str2;
        this.cxQ = i;
    }

    public e qi(String str) {
        this.cxS = str;
        return this;
    }

    public int arD() {
        return this.cxU;
    }

    public void qj(String str) {
        this.cxT = str;
    }

    public String getBundleId() {
        return this.cxP;
    }

    public String arI() {
        return this.cxW;
    }

    public int arB() {
        return this.cxQ;
    }

    public String arE() {
        return this.cxS;
    }

    public String arF() {
        return this.cxT;
    }
}
