package com.baidu.swan.pms.c.d;
/* loaded from: classes6.dex */
public abstract class g {
    private int mCategory;
    private String mFrom = "-1";
    private String dXB = "-1";

    /* JADX INFO: Access modifiers changed from: protected */
    public g(int i) {
        this.mCategory = i;
    }

    public int getCategory() {
        return this.mCategory;
    }

    public g xQ(String str) {
        this.mFrom = str;
        return this;
    }

    public g xR(String str) {
        this.dXB = str;
        return this;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String bdi() {
        return this.dXB;
    }
}
