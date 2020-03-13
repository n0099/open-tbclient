package com.baidu.swan.ubc;
/* loaded from: classes11.dex */
class f {
    private String cEF;
    private String cEG;
    private int cEH;
    private String cEI;
    private int cEJ;
    private int cEK;
    private String cEL;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public f(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.cEF = str2;
        this.cEG = str3;
        this.cEH = i;
        this.mType = str4;
        this.cEI = str5;
    }

    public void iU(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void iV(int i) {
        this.cEJ = i;
    }

    public void iW(int i) {
        this.cEK = i;
    }

    public String getId() {
        return this.mId;
    }

    public String avm() {
        return this.cEF;
    }

    public String avn() {
        return this.cEG;
    }

    public int getTimeout() {
        return this.cEH;
    }

    public String getType() {
        return this.mType;
    }

    public String avo() {
        return this.cEI;
    }

    public int avp() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int avq() {
        return this.cEJ;
    }

    public int avr() {
        return this.cEK;
    }

    public void qW(String str) {
        this.cEL = str;
    }

    public String avs() {
        return this.cEL;
    }
}
