package com.baidu.swan.pms.c.d;
/* loaded from: classes15.dex */
public abstract class g {
    private int mCategory;
    private String mFrom = "-1";
    private String dOa = "-1";

    /* JADX INFO: Access modifiers changed from: protected */
    public g(int i) {
        this.mCategory = i;
    }

    public int getCategory() {
        return this.mCategory;
    }

    public g yA(String str) {
        this.mFrom = str;
        return this;
    }

    public g yB(String str) {
        this.dOa = str;
        return this;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String bci() {
        return this.dOa;
    }
}
