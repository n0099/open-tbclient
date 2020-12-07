package com.baidu.swan.pms.c.d;
/* loaded from: classes6.dex */
public abstract class g {
    private int mCategory;
    private String mFrom = "-1";
    private String dTq = "-1";

    /* JADX INFO: Access modifiers changed from: protected */
    public g(int i) {
        this.mCategory = i;
    }

    public int getCategory() {
        return this.mCategory;
    }

    public g zc(String str) {
        this.mFrom = str;
        return this;
    }

    public g zd(String str) {
        this.dTq = str;
        return this;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String beG() {
        return this.dTq;
    }
}
