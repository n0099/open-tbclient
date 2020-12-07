package com.baidu.swan.ubc;
/* loaded from: classes17.dex */
class g {
    private String ero;
    private String erp;
    private String erq;
    private String ers;
    private int ert;
    private String eru;
    private int erv;
    private int erw;
    private String erx;
    private String ery;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public g(String str, String str2, String str3, int i, String str4, String str5) {
        this.erp = str;
        this.mId = str;
        this.erq = str2;
        this.ers = str3;
        this.ert = i;
        this.mType = str4;
        this.eru = str5;
    }

    public void zx(String str) {
        this.ero = str;
    }

    public void nD(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void nE(int i) {
        this.erv = i;
    }

    public void nF(int i) {
        this.erw = i;
    }

    public String getId() {
        return this.mId;
    }

    public String bfS() {
        return this.erq;
    }

    public String bfT() {
        return this.ers;
    }

    public int getTimeout() {
        return this.ert;
    }

    public String getType() {
        return this.mType;
    }

    public String bfU() {
        return this.eru;
    }

    public int bfV() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int bfW() {
        return this.erv;
    }

    public int bfX() {
        return this.erw;
    }

    public void zy(String str) {
        this.erx = str;
    }

    public String bfY() {
        return this.erx;
    }

    public void zz(String str) {
        this.ery = str;
    }
}
