package com.baidu.swan.ubc;
/* loaded from: classes14.dex */
class g {
    private int eAa;
    private int eAb;
    private String eAc;
    private String eAd;
    private String ezU;
    private String ezV;
    private String ezW;
    private String ezX;
    private int ezY;
    private String ezZ;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public g(String str, String str2, String str3, int i, String str4, String str5) {
        this.ezV = str;
        this.mId = str;
        this.ezW = str2;
        this.ezX = str3;
        this.ezY = i;
        this.mType = str4;
        this.ezZ = str5;
    }

    public void yL(String str) {
        this.ezU = str;
    }

    public void mk(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void ml(int i) {
        this.eAa = i;
    }

    public void mm(int i) {
        this.eAb = i;
    }

    public String getId() {
        return this.mId;
    }

    public String beL() {
        return this.ezW;
    }

    public String beM() {
        return this.ezX;
    }

    public int getTimeout() {
        return this.ezY;
    }

    public String getType() {
        return this.mType;
    }

    public String beN() {
        return this.ezZ;
    }

    public int beO() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int beP() {
        return this.eAa;
    }

    public int beQ() {
        return this.eAb;
    }

    public void yM(String str) {
        this.eAc = str;
    }

    public String beR() {
        return this.eAc;
    }

    public void yN(String str) {
        this.eAd = str;
    }
}
