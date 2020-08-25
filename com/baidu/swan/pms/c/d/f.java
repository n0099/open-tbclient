package com.baidu.swan.pms.c.d;
/* loaded from: classes14.dex */
public class f extends g {
    private String dGk;
    private String dGn;
    private String dGo;
    private int dGp;
    private String dGr;
    private int dGt;

    public f(String str, int i, String str2, int i2) {
        super(i2);
        this.dGp = -1;
        this.dGk = str;
        this.dGr = str2;
        this.dGt = i;
    }

    public f(String str, String str2, String str3, int i) {
        super(i);
        this.dGp = -1;
        this.dGk = str;
        this.dGr = str3;
        try {
            this.dGt = Integer.valueOf(str2).intValue();
        } catch (NumberFormatException e) {
            this.dGt = 0;
        }
    }

    public f wL(String str) {
        this.dGn = str;
        return this;
    }

    public int aUm() {
        return this.dGp;
    }

    public void wM(String str) {
        this.dGo = str;
    }

    public String getBundleId() {
        return this.dGk;
    }

    public String aUr() {
        return this.dGr;
    }

    public int aUt() {
        return this.dGt;
    }

    public String aUn() {
        return this.dGn;
    }

    public String aUo() {
        return this.dGo;
    }
}
