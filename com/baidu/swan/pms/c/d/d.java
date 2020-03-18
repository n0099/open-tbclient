package com.baidu.swan.pms.c.d;
/* loaded from: classes11.dex */
public class d extends f {
    private String bIp;
    private String cCr;

    public d(String str, String str2, int i) {
        super(i);
        this.bIp = str;
        this.cCr = str2;
    }

    public d qy(String str) {
        this.cCr = str;
        return this;
    }

    public String aus() {
        return this.bIp;
    }

    public String aut() {
        return this.cCr;
    }
}
