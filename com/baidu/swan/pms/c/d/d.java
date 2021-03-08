package com.baidu.swan.pms.c.d;
/* loaded from: classes3.dex */
public class d extends g {
    private String dtJ;
    private String ewJ;

    public d(String str, String str2, int i) {
        super(i);
        this.dtJ = str;
        this.ewJ = str2;
    }

    public d yn(String str) {
        this.ewJ = str;
        return this;
    }

    public String bds() {
        return this.dtJ;
    }

    public String bdt() {
        return this.ewJ;
    }
}
