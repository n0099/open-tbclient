package com.baidu.swan.ubc;
/* loaded from: classes11.dex */
class g {
    private String duA;
    private String duB;
    private int duC;
    private String duD;
    private int duE;
    private int duF;
    private String duG;
    private String duH;
    private String duy;
    private String duz;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public g(String str, String str2, String str3, int i, String str4, String str5) {
        this.duz = str;
        this.mId = str;
        this.duA = str2;
        this.duB = str3;
        this.duC = i;
        this.mType = str4;
        this.duD = str5;
    }

    public void tU(String str) {
        this.duy = str;
    }

    public void jH(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void jI(int i) {
        this.duE = i;
    }

    public void jJ(int i) {
        this.duF = i;
    }

    public String getId() {
        return this.mId;
    }

    public String aJp() {
        return this.duA;
    }

    public String aJq() {
        return this.duB;
    }

    public int getTimeout() {
        return this.duC;
    }

    public String getType() {
        return this.mType;
    }

    public String aJr() {
        return this.duD;
    }

    public int aJs() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int aJt() {
        return this.duE;
    }

    public int aJu() {
        return this.duF;
    }

    public void tV(String str) {
        this.duG = str;
    }

    public String aJv() {
        return this.duG;
    }

    public void tW(String str) {
        this.duH = str;
    }
}
