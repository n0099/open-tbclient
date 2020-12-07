package com.baidu.swan.pms.c.d;
/* loaded from: classes6.dex */
public class d extends g {
    private String dpL;
    private String eoi;

    public d(String str, String str2, int i) {
        super(i);
        this.dpL = str;
        this.eoi = str2;
    }

    public d yZ(String str) {
        this.eoi = str;
        return this;
    }

    public String beB() {
        return this.dpL;
    }

    public String beC() {
        return this.eoi;
    }
}
