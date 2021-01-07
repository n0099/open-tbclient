package com.baidu.swan.pms.c.d;
/* loaded from: classes6.dex */
public class f extends g {
    private String exJ;
    private String exM;
    private String exN;
    private int exO;
    private String exQ;
    private int exT;

    public f(String str, int i, String str2, int i2) {
        super(i2);
        this.exO = -1;
        this.exJ = str;
        this.exQ = str2;
        this.exT = i;
    }

    public f(String str, String str2, String str3, int i) {
        super(i);
        this.exO = -1;
        this.exJ = str;
        this.exQ = str3;
        try {
            this.exT = Integer.valueOf(str2).intValue();
        } catch (NumberFormatException e) {
            this.exT = 0;
        }
    }

    public f yZ(String str) {
        this.exM = str;
        return this;
    }

    public int bgU() {
        return this.exO;
    }

    public void za(String str) {
        this.exN = str;
    }

    public String getBundleId() {
        return this.exJ;
    }

    public String bgZ() {
        return this.exQ;
    }

    public int bhb() {
        return this.exT;
    }

    public String bgV() {
        return this.exM;
    }

    public String bgW() {
        return this.exN;
    }
}
