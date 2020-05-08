package com.baidu.swan.ubc;
/* loaded from: classes11.dex */
class f {
    private String ddV;
    private String ddW;
    private int ddX;
    private String ddY;
    private int ddZ;
    private int dea;
    private String deb;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public f(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.ddV = str2;
        this.ddW = str3;
        this.ddX = i;
        this.mType = str4;
        this.ddY = str5;
    }

    public void jb(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void jc(int i) {
        this.ddZ = i;
    }

    public void jd(int i) {
        this.dea = i;
    }

    public String getId() {
        return this.mId;
    }

    public String aDA() {
        return this.ddV;
    }

    public String aDB() {
        return this.ddW;
    }

    public int getTimeout() {
        return this.ddX;
    }

    public String getType() {
        return this.mType;
    }

    public String aDC() {
        return this.ddY;
    }

    public int aDD() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int aDE() {
        return this.ddZ;
    }

    public int aDF() {
        return this.dea;
    }

    public void si(String str) {
        this.deb = str;
    }

    public String aDG() {
        return this.deb;
    }
}
