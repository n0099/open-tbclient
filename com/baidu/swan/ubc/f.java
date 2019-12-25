package com.baidu.swan.ubc;
/* loaded from: classes9.dex */
class f {
    private String cAA;
    private String cAu;
    private String cAv;
    private int cAw;
    private String cAx;
    private int cAy;
    private int cAz;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public f(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.cAu = str2;
        this.cAv = str3;
        this.cAw = i;
        this.mType = str4;
        this.cAx = str5;
    }

    public void iD(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void iE(int i) {
        this.cAy = i;
    }

    public void iF(int i) {
        this.cAz = i;
    }

    public String getId() {
        return this.mId;
    }

    public String asD() {
        return this.cAu;
    }

    public String asE() {
        return this.cAv;
    }

    public int getTimeout() {
        return this.cAw;
    }

    public String getType() {
        return this.mType;
    }

    public String asF() {
        return this.cAx;
    }

    public int asG() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int asH() {
        return this.cAy;
    }

    public int asI() {
        return this.cAz;
    }

    public void qE(String str) {
        this.cAA = str;
    }

    public String asJ() {
        return this.cAA;
    }
}
