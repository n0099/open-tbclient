package com.baidu.swan.pms.c.d;
/* loaded from: classes6.dex */
public class f extends g {
    private String esV;
    private String esY;
    private String esZ;
    private int eta;
    private String etd;
    private int etg;

    public f(String str, int i, String str2, int i2) {
        super(i2);
        this.eta = -1;
        this.esV = str;
        this.etd = str2;
        this.etg = i;
    }

    public f(String str, String str2, String str3, int i) {
        super(i);
        this.eta = -1;
        this.esV = str;
        this.etd = str3;
        try {
            this.etg = Integer.valueOf(str2).intValue();
        } catch (NumberFormatException e) {
            this.etg = 0;
        }
    }

    public f xO(String str) {
        this.esY = str;
        return this;
    }

    public int bda() {
        return this.eta;
    }

    public void xP(String str) {
        this.esZ = str;
    }

    public String getBundleId() {
        return this.esV;
    }

    public String bdf() {
        return this.etd;
    }

    public int bdh() {
        return this.etg;
    }

    public String bdb() {
        return this.esY;
    }

    public String bdc() {
        return this.esZ;
    }
}
