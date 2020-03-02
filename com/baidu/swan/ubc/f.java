package com.baidu.swan.ubc;
/* loaded from: classes11.dex */
class f {
    private String cEE;
    private String cEF;
    private int cEG;
    private String cEH;
    private int cEI;
    private int cEJ;
    private String cEK;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public f(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.cEE = str2;
        this.cEF = str3;
        this.cEG = i;
        this.mType = str4;
        this.cEH = str5;
    }

    public void iU(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void iV(int i) {
        this.cEI = i;
    }

    public void iW(int i) {
        this.cEJ = i;
    }

    public String getId() {
        return this.mId;
    }

    public String avm() {
        return this.cEE;
    }

    public String avn() {
        return this.cEF;
    }

    public int getTimeout() {
        return this.cEG;
    }

    public String getType() {
        return this.mType;
    }

    public String avo() {
        return this.cEH;
    }

    public int avp() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int avq() {
        return this.cEI;
    }

    public int avr() {
        return this.cEJ;
    }

    public void qW(String str) {
        this.cEK = str;
    }

    public String avs() {
        return this.cEK;
    }
}
