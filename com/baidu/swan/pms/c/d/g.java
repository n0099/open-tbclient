package com.baidu.swan.pms.c.d;
/* loaded from: classes3.dex */
public abstract class g {
    private int mCategory;
    private String mFrom = "-1";
    private String dZH = "-1";

    /* JADX INFO: Access modifiers changed from: protected */
    public g(int i) {
        this.mCategory = i;
    }

    public int getCategory() {
        return this.mCategory;
    }

    public g yj(String str) {
        this.mFrom = str;
        return this;
    }

    public g yk(String str) {
        this.dZH = str;
        return this;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String bdv() {
        return this.dZH;
    }
}
