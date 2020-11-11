package com.baidu.swan.ubc;
/* loaded from: classes9.dex */
class g {
    private String elT;
    private String elU;
    private String elV;
    private String elW;
    private int elX;
    private String elY;
    private int elZ;
    private int ema;
    private String emb;
    private String emc;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public g(String str, String str2, String str3, int i, String str4, String str5) {
        this.elU = str;
        this.mId = str;
        this.elV = str2;
        this.elW = str3;
        this.elX = i;
        this.mType = str4;
        this.elY = str5;
    }

    public void yV(String str) {
        this.elT = str;
    }

    public void nj(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void nk(int i) {
        this.elZ = i;
    }

    public void nl(int i) {
        this.ema = i;
    }

    public String getId() {
        return this.mId;
    }

    public String bdu() {
        return this.elV;
    }

    public String bdv() {
        return this.elW;
    }

    public int getTimeout() {
        return this.elX;
    }

    public String getType() {
        return this.mType;
    }

    public String bdw() {
        return this.elY;
    }

    public int bdx() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int bdy() {
        return this.elZ;
    }

    public int bdz() {
        return this.ema;
    }

    public void yW(String str) {
        this.emb = str;
    }

    public String bdA() {
        return this.emb;
    }

    public void yX(String str) {
        this.emc = str;
    }
}
