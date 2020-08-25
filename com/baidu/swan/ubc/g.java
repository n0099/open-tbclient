package com.baidu.swan.ubc;
/* loaded from: classes10.dex */
class g {
    private int dJA;
    private String dJB;
    private int dJC;
    private int dJD;
    private String dJE;
    private String dJF;
    private String dJw;
    private String dJx;
    private String dJy;
    private String dJz;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public g(String str, String str2, String str3, int i, String str4, String str5) {
        this.dJx = str;
        this.mId = str;
        this.dJy = str2;
        this.dJz = str3;
        this.dJA = i;
        this.mType = str4;
        this.dJB = str5;
    }

    public void xi(String str) {
        this.dJw = str;
    }

    public void mg(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void mh(int i) {
        this.dJC = i;
    }

    public void mi(int i) {
        this.dJD = i;
    }

    public String getId() {
        return this.mId;
    }

    public String aVH() {
        return this.dJy;
    }

    public String aVI() {
        return this.dJz;
    }

    public int getTimeout() {
        return this.dJA;
    }

    public String getType() {
        return this.mType;
    }

    public String aVJ() {
        return this.dJB;
    }

    public int aVK() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int aVL() {
        return this.dJC;
    }

    public int aVM() {
        return this.dJD;
    }

    public void xj(String str) {
        this.dJE = str;
    }

    public String aVN() {
        return this.dJE;
    }

    public void xk(String str) {
        this.dJF = str;
    }
}
