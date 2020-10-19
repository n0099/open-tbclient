package com.baidu.swan.pms.c.d;
/* loaded from: classes15.dex */
public class f extends g {
    private String dUA;
    private int dUC;
    private String dUt;
    private String dUw;
    private String dUx;
    private int dUy;

    public f(String str, int i, String str2, int i2) {
        super(i2);
        this.dUy = -1;
        this.dUt = str;
        this.dUA = str2;
        this.dUC = i;
    }

    public f(String str, String str2, String str3, int i) {
        super(i);
        this.dUy = -1;
        this.dUt = str;
        this.dUA = str3;
        try {
            this.dUC = Integer.valueOf(str2).intValue();
        } catch (NumberFormatException e) {
            this.dUC = 0;
        }
    }

    public f xR(String str) {
        this.dUw = str;
        return this;
    }

    public int aXH() {
        return this.dUy;
    }

    public void xS(String str) {
        this.dUx = str;
    }

    public String getBundleId() {
        return this.dUt;
    }

    public String aXM() {
        return this.dUA;
    }

    public int aXO() {
        return this.dUC;
    }

    public String aXI() {
        return this.dUw;
    }

    public String aXJ() {
        return this.dUx;
    }
}
