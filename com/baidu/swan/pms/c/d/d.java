package com.baidu.swan.pms.c.d;
/* loaded from: classes15.dex */
public class d extends g {
    private String dkt;
    private String eiN;

    public d(String str, String str2, int i) {
        super(i);
        this.dkt = str;
        this.eiN = str2;
    }

    public d yx(String str) {
        this.eiN = str;
        return this;
    }

    public String bcd() {
        return this.dkt;
    }

    public String bce() {
        return this.eiN;
    }
}
