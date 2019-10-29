package com.baidu.swan.pms.b.d;
/* loaded from: classes2.dex */
public class c extends e {
    private String bMX;
    private String bMY;

    public c(String str, String str2, int i) {
        super(i);
        this.bMX = str;
        this.bMY = str2;
    }

    public c ld(String str) {
        this.bMY = str;
        return this;
    }

    public String abH() {
        return this.bMX;
    }

    public String abI() {
        return this.bMY;
    }
}
