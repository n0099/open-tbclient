package com.baidu.swan.ubc;
/* loaded from: classes11.dex */
class f {
    private String cEQ;
    private String cER;
    private int cES;
    private String cET;
    private int cEU;
    private int cEV;
    private String cEW;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public f(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.cEQ = str2;
        this.cER = str3;
        this.cES = i;
        this.mType = str4;
        this.cET = str5;
    }

    public void iU(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void iV(int i) {
        this.cEU = i;
    }

    public void iW(int i) {
        this.cEV = i;
    }

    public String getId() {
        return this.mId;
    }

    public String avp() {
        return this.cEQ;
    }

    public String avq() {
        return this.cER;
    }

    public int getTimeout() {
        return this.cES;
    }

    public String getType() {
        return this.mType;
    }

    public String avr() {
        return this.cET;
    }

    public int avs() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int avt() {
        return this.cEU;
    }

    public int avu() {
        return this.cEV;
    }

    public void qV(String str) {
        this.cEW = str;
    }

    public String avv() {
        return this.cEW;
    }
}
