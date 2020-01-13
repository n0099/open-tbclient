package com.baidu.swan.pms.c.d;
/* loaded from: classes10.dex */
public abstract class f {
    private int mCategory;
    private String mFrom = "-1";
    private String cyi = "-1";

    /* JADX INFO: Access modifiers changed from: protected */
    public f(int i) {
        this.mCategory = i;
    }

    public int getCategory() {
        return this.mCategory;
    }

    public f qn(String str) {
        this.mFrom = str;
        return this;
    }

    public f qo(String str) {
        this.cyi = str;
        return this;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String asc() {
        return this.cyi;
    }
}
