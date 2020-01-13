package com.baidu.swan.ubc;
/* loaded from: classes10.dex */
class f {
    private String cAF;
    private String cAG;
    private int cAH;
    private String cAI;
    private int cAJ;
    private int cAK;
    private String cAL;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public f(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.cAF = str2;
        this.cAG = str3;
        this.cAH = i;
        this.mType = str4;
        this.cAI = str5;
    }

    public void iD(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void iE(int i) {
        this.cAJ = i;
    }

    public void iF(int i) {
        this.cAK = i;
    }

    public String getId() {
        return this.mId;
    }

    public String asW() {
        return this.cAF;
    }

    public String asX() {
        return this.cAG;
    }

    public int getTimeout() {
        return this.cAH;
    }

    public String getType() {
        return this.mType;
    }

    public String asY() {
        return this.cAI;
    }

    public int asZ() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int ata() {
        return this.cAJ;
    }

    public int atb() {
        return this.cAK;
    }

    public void qH(String str) {
        this.cAL = str;
    }

    public String atc() {
        return this.cAL;
    }
}
