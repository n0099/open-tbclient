package com.baidu.swan.ubc;
/* loaded from: classes11.dex */
class f {
    private String cED;
    private String cEE;
    private int cEF;
    private String cEG;
    private int cEH;
    private int cEI;
    private String cEJ;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public f(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.cED = str2;
        this.cEE = str3;
        this.cEF = i;
        this.mType = str4;
        this.cEG = str5;
    }

    public void iU(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void iV(int i) {
        this.cEH = i;
    }

    public void iW(int i) {
        this.cEI = i;
    }

    public String getId() {
        return this.mId;
    }

    public String avk() {
        return this.cED;
    }

    public String avl() {
        return this.cEE;
    }

    public int getTimeout() {
        return this.cEF;
    }

    public String getType() {
        return this.mType;
    }

    public String avm() {
        return this.cEG;
    }

    public int avn() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int avo() {
        return this.cEH;
    }

    public int avp() {
        return this.cEI;
    }

    public void qW(String str) {
        this.cEJ = str;
    }

    public String avq() {
        return this.cEJ;
    }
}
