package com.baidu.swan.pms.c.d;
/* loaded from: classes15.dex */
public class f extends g {
    private String eiH;
    private String eiK;
    private String eiL;
    private int eiM;
    private String eiO;
    private int eiQ;

    public f(String str, int i, String str2, int i2) {
        super(i2);
        this.eiM = -1;
        this.eiH = str;
        this.eiO = str2;
        this.eiQ = i;
    }

    public f(String str, String str2, String str3, int i) {
        super(i);
        this.eiM = -1;
        this.eiH = str;
        this.eiO = str3;
        try {
            this.eiQ = Integer.valueOf(str2).intValue();
        } catch (NumberFormatException e) {
            this.eiQ = 0;
        }
    }

    public f yy(String str) {
        this.eiK = str;
        return this;
    }

    public int bca() {
        return this.eiM;
    }

    public void yz(String str) {
        this.eiL = str;
    }

    public String getBundleId() {
        return this.eiH;
    }

    public String bcf() {
        return this.eiO;
    }

    public int bch() {
        return this.eiQ;
    }

    public String bcb() {
        return this.eiK;
    }

    public String bcc() {
        return this.eiL;
    }
}
