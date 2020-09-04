package com.baidu.swan.pms.c.d;
/* loaded from: classes14.dex */
public class f extends g {
    private String dGo;
    private String dGr;
    private String dGs;
    private int dGt;
    private String dGv;
    private int dGx;

    public f(String str, int i, String str2, int i2) {
        super(i2);
        this.dGt = -1;
        this.dGo = str;
        this.dGv = str2;
        this.dGx = i;
    }

    public f(String str, String str2, String str3, int i) {
        super(i);
        this.dGt = -1;
        this.dGo = str;
        this.dGv = str3;
        try {
            this.dGx = Integer.valueOf(str2).intValue();
        } catch (NumberFormatException e) {
            this.dGx = 0;
        }
    }

    public f wM(String str) {
        this.dGr = str;
        return this;
    }

    public int aUm() {
        return this.dGt;
    }

    public void wN(String str) {
        this.dGs = str;
    }

    public String getBundleId() {
        return this.dGo;
    }

    public String aUr() {
        return this.dGv;
    }

    public int aUt() {
        return this.dGx;
    }

    public String aUn() {
        return this.dGr;
    }

    public String aUo() {
        return this.dGs;
    }
}
