package com.baidu.swan.ubc;
/* loaded from: classes16.dex */
class g {
    private String ekm;
    private String ekn;
    private String eko;
    private String ekp;
    private int ekq;
    private String ekr;
    private int eks;
    private int ekt;
    private String eku;
    private String ekv;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public g(String str, String str2, String str3, int i, String str4, String str5) {
        this.ekn = str;
        this.mId = str;
        this.eko = str2;
        this.ekp = str3;
        this.ekq = i;
        this.mType = str4;
        this.ekr = str5;
    }

    public void yQ(String str) {
        this.ekm = str;
    }

    public void nf(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void ng(int i) {
        this.eks = i;
    }

    public void nh(int i) {
        this.ekt = i;
    }

    public String getId() {
        return this.mId;
    }

    public String bcN() {
        return this.eko;
    }

    public String bcO() {
        return this.ekp;
    }

    public int getTimeout() {
        return this.ekq;
    }

    public String getType() {
        return this.mType;
    }

    public String bcP() {
        return this.ekr;
    }

    public int bcQ() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int bcR() {
        return this.eks;
    }

    public int bcS() {
        return this.ekt;
    }

    public void yR(String str) {
        this.eku = str;
    }

    public String bcT() {
        return this.eku;
    }

    public void yS(String str) {
        this.ekv = str;
    }
}
