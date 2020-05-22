package com.baidu.swan.pms.c.d;
/* loaded from: classes11.dex */
public abstract class f {
    private int mCategory;
    private String mFrom = "-1";
    private String dmK = "-1";

    /* JADX INFO: Access modifiers changed from: protected */
    public f(int i) {
        this.mCategory = i;
    }

    public int getCategory() {
        return this.mCategory;
    }

    public f tt(String str) {
        this.mFrom = str;
        return this;
    }

    public f tu(String str) {
        this.dmK = str;
        return this;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String aGW() {
        return this.dmK;
    }
}
