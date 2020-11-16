package com.baidu.swan.pms.c.d;
/* loaded from: classes6.dex */
public class f extends g {
    private String eha;
    private String ehd;
    private String ehe;
    private int ehf;
    private String ehh;
    private int ehj;

    public f(String str, int i, String str2, int i2) {
        super(i2);
        this.ehf = -1;
        this.eha = str;
        this.ehh = str2;
        this.ehj = i;
    }

    public f(String str, String str2, String str3, int i) {
        super(i);
        this.ehf = -1;
        this.eha = str;
        this.ehh = str3;
        try {
            this.ehj = Integer.valueOf(str2).intValue();
        } catch (NumberFormatException e) {
            this.ehj = 0;
        }
    }

    public f yt(String str) {
        this.ehd = str;
        return this;
    }

    public int bbt() {
        return this.ehf;
    }

    public void yu(String str) {
        this.ehe = str;
    }

    public String getBundleId() {
        return this.eha;
    }

    public String bby() {
        return this.ehh;
    }

    public int bbA() {
        return this.ehj;
    }

    public String bbu() {
        return this.ehd;
    }

    public String bbv() {
        return this.ehe;
    }
}
