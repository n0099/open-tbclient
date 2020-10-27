package com.baidu.swan.ubc;
/* loaded from: classes9.dex */
class g {
    private String egb;
    private String egc;
    private String egd;
    private String ege;
    private int egf;
    private String egg;
    private int egh;
    private int egi;
    private String egj;
    private String egk;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public g(String str, String str2, String str3, int i, String str4, String str5) {
        this.egc = str;
        this.mId = str;
        this.egd = str2;
        this.ege = str3;
        this.egf = i;
        this.mType = str4;
        this.egg = str5;
    }

    public void yH(String str) {
        this.egb = str;
    }

    public void mZ(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void na(int i) {
        this.egh = i;
    }

    public void nb(int i) {
        this.egi = i;
    }

    public String getId() {
        return this.mId;
    }

    public String baU() {
        return this.egd;
    }

    public String baV() {
        return this.ege;
    }

    public int getTimeout() {
        return this.egf;
    }

    public String getType() {
        return this.mType;
    }

    public String baW() {
        return this.egg;
    }

    public int baX() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int baY() {
        return this.egh;
    }

    public int baZ() {
        return this.egi;
    }

    public void yI(String str) {
        this.egj = str;
    }

    public String bba() {
        return this.egj;
    }

    public void yJ(String str) {
        this.egk = str;
    }
}
