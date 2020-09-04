package com.baidu.swan.pms.c.d;
/* loaded from: classes14.dex */
public abstract class g {
    private int mCategory;
    private String mFrom = "-1";
    private String dlE = "-1";

    /* JADX INFO: Access modifiers changed from: protected */
    public g(int i) {
        this.mCategory = i;
    }

    public int getCategory() {
        return this.mCategory;
    }

    public g wO(String str) {
        this.mFrom = str;
        return this;
    }

    public g wP(String str) {
        this.dlE = str;
        return this;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String aUu() {
        return this.dlE;
    }
}
