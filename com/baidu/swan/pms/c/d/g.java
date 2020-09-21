package com.baidu.swan.pms.c.d;
/* loaded from: classes24.dex */
public abstract class g {
    private int mCategory;
    private String mFrom = "-1";
    private String dnG = "-1";

    /* JADX INFO: Access modifiers changed from: protected */
    public g(int i) {
        this.mCategory = i;
    }

    public int getCategory() {
        return this.mCategory;
    }

    public g xh(String str) {
        this.mFrom = str;
        return this;
    }

    public g xi(String str) {
        this.dnG = str;
        return this;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String aVg() {
        return this.dnG;
    }
}
