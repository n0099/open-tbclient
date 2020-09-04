package com.baidu.swan.ubc;
/* loaded from: classes10.dex */
class g {
    private String dJA;
    private String dJB;
    private String dJC;
    private String dJD;
    private int dJE;
    private String dJF;
    private int dJG;
    private int dJH;
    private String dJI;
    private String dJJ;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public g(String str, String str2, String str3, int i, String str4, String str5) {
        this.dJB = str;
        this.mId = str;
        this.dJC = str2;
        this.dJD = str3;
        this.dJE = i;
        this.mType = str4;
        this.dJF = str5;
    }

    public void xj(String str) {
        this.dJA = str;
    }

    public void mg(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void mh(int i) {
        this.dJG = i;
    }

    public void mi(int i) {
        this.dJH = i;
    }

    public String getId() {
        return this.mId;
    }

    public String aVH() {
        return this.dJC;
    }

    public String aVI() {
        return this.dJD;
    }

    public int getTimeout() {
        return this.dJE;
    }

    public String getType() {
        return this.mType;
    }

    public String aVJ() {
        return this.dJF;
    }

    public int aVK() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int aVL() {
        return this.dJG;
    }

    public int aVM() {
        return this.dJH;
    }

    public void xk(String str) {
        this.dJI = str;
    }

    public String aVN() {
        return this.dJI;
    }

    public void xl(String str) {
        this.dJJ = str;
    }
}
