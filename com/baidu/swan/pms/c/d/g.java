package com.baidu.swan.pms.c.d;
/* loaded from: classes19.dex */
public abstract class g {
    private int mCategory;
    private String mFrom = "-1";
    private String dbo = "-1";

    /* JADX INFO: Access modifiers changed from: protected */
    public g(int i) {
        this.mCategory = i;
    }

    public int getCategory() {
        return this.mCategory;
    }

    public g uE(String str) {
        this.mFrom = str;
        return this;
    }

    public g uF(String str) {
        this.dbo = str;
        return this;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String aLU() {
        return this.dbo;
    }
}
