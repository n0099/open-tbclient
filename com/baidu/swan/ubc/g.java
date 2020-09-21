package com.baidu.swan.ubc;
/* loaded from: classes14.dex */
class g {
    private String dLE;
    private String dLF;
    private String dLG;
    private String dLH;
    private int dLI;
    private String dLJ;
    private int dLK;
    private int dLL;
    private String dLM;
    private String dLN;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public g(String str, String str2, String str3, int i, String str4, String str5) {
        this.dLF = str;
        this.mId = str;
        this.dLG = str2;
        this.dLH = str3;
        this.dLI = i;
        this.mType = str4;
        this.dLJ = str5;
    }

    public void xC(String str) {
        this.dLE = str;
    }

    public void mr(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void ms(int i) {
        this.dLK = i;
    }

    public void mt(int i) {
        this.dLL = i;
    }

    public String getId() {
        return this.mId;
    }

    public String aWt() {
        return this.dLG;
    }

    public String aWu() {
        return this.dLH;
    }

    public int getTimeout() {
        return this.dLI;
    }

    public String getType() {
        return this.mType;
    }

    public String aWv() {
        return this.dLJ;
    }

    public int aWw() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int aWx() {
        return this.dLK;
    }

    public int aWy() {
        return this.dLL;
    }

    public void xD(String str) {
        this.dLM = str;
    }

    public String aWz() {
        return this.dLM;
    }

    public void xE(String str) {
        this.dLN = str;
    }
}
