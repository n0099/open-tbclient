package com.baidu.swan.pms.c.d;
/* loaded from: classes3.dex */
public abstract class g {
    private int mCategory;
    private String mFrom = "-1";
    private String ebj = "-1";

    /* JADX INFO: Access modifiers changed from: protected */
    public g(int i) {
        this.mCategory = i;
    }

    public int getCategory() {
        return this.mCategory;
    }

    public g yq(String str) {
        this.mFrom = str;
        return this;
    }

    public g yr(String str) {
        this.ebj = str;
        return this;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String bdx() {
        return this.ebj;
    }
}
