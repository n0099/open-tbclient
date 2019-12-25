package com.baidu.swan.pms.c.d;
/* loaded from: classes9.dex */
public abstract class f {
    private int mCategory;
    private String mFrom = "-1";
    private String cxX = "-1";

    /* JADX INFO: Access modifiers changed from: protected */
    public f(int i) {
        this.mCategory = i;
    }

    public int getCategory() {
        return this.mCategory;
    }

    public f qk(String str) {
        this.mFrom = str;
        return this;
    }

    public f ql(String str) {
        this.cxX = str;
        return this;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String arJ() {
        return this.cxX;
    }
}
