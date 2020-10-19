package com.baidu.swan.pms.c.d;
/* loaded from: classes15.dex */
public abstract class g {
    private int mCategory;
    private String mFrom = "-1";
    private String dzL = "-1";

    /* JADX INFO: Access modifiers changed from: protected */
    public g(int i) {
        this.mCategory = i;
    }

    public int getCategory() {
        return this.mCategory;
    }

    public g xT(String str) {
        this.mFrom = str;
        return this;
    }

    public g xU(String str) {
        this.dzL = str;
        return this;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String aXP() {
        return this.dzL;
    }
}
