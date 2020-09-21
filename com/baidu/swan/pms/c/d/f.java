package com.baidu.swan.pms.c.d;
/* loaded from: classes24.dex */
public class f extends g {
    private int dIB;
    private String dIs;
    private String dIv;
    private String dIw;
    private int dIx;
    private String dIz;

    public f(String str, int i, String str2, int i2) {
        super(i2);
        this.dIx = -1;
        this.dIs = str;
        this.dIz = str2;
        this.dIB = i;
    }

    public f(String str, String str2, String str3, int i) {
        super(i);
        this.dIx = -1;
        this.dIs = str;
        this.dIz = str3;
        try {
            this.dIB = Integer.valueOf(str2).intValue();
        } catch (NumberFormatException e) {
            this.dIB = 0;
        }
    }

    public f xf(String str) {
        this.dIv = str;
        return this;
    }

    public int aUY() {
        return this.dIx;
    }

    public void xg(String str) {
        this.dIw = str;
    }

    public String getBundleId() {
        return this.dIs;
    }

    public String aVd() {
        return this.dIz;
    }

    public int aVf() {
        return this.dIB;
    }

    public String aUZ() {
        return this.dIv;
    }

    public String aVa() {
        return this.dIw;
    }
}
