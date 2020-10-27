package com.baidu.swan.pms.c.d;
/* loaded from: classes15.dex */
public class f extends g {
    private String ecP;
    private String ecS;
    private String ecT;
    private int ecU;
    private String ecW;
    private int ecY;

    public f(String str, int i, String str2, int i2) {
        super(i2);
        this.ecU = -1;
        this.ecP = str;
        this.ecW = str2;
        this.ecY = i;
    }

    public f(String str, String str2, String str3, int i) {
        super(i);
        this.ecU = -1;
        this.ecP = str;
        this.ecW = str3;
        try {
            this.ecY = Integer.valueOf(str2).intValue();
        } catch (NumberFormatException e) {
            this.ecY = 0;
        }
    }

    public f yk(String str) {
        this.ecS = str;
        return this;
    }

    public int aZA() {
        return this.ecU;
    }

    public void yl(String str) {
        this.ecT = str;
    }

    public String getBundleId() {
        return this.ecP;
    }

    public String aZF() {
        return this.ecW;
    }

    public int aZH() {
        return this.ecY;
    }

    public String aZB() {
        return this.ecS;
    }

    public String aZC() {
        return this.ecT;
    }
}
