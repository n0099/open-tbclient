package com.baidu.swan.ubc;
/* loaded from: classes6.dex */
class g {
    private String eAZ;
    private String eBa;
    private String eBb;
    private String eBc;
    private int eBd;
    private String eBe;
    private int eBf;
    private int eBg;
    private String eBh;
    private String eBi;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public g(String str, String str2, String str3, int i, String str4, String str5) {
        this.eBa = str;
        this.mId = str;
        this.eBb = str2;
        this.eBc = str3;
        this.eBd = i;
        this.mType = str4;
        this.eBe = str5;
    }

    public void zw(String str) {
        this.eAZ = str;
    }

    public void nM(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void nN(int i) {
        this.eBf = i;
    }

    public void nO(int i) {
        this.eBg = i;
    }

    public String getId() {
        return this.mId;
    }

    public String bip() {
        return this.eBb;
    }

    public String biq() {
        return this.eBc;
    }

    public int getTimeout() {
        return this.eBd;
    }

    public String getType() {
        return this.mType;
    }

    public String bir() {
        return this.eBe;
    }

    public int bis() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int bit() {
        return this.eBf;
    }

    public int biu() {
        return this.eBg;
    }

    public void zx(String str) {
        this.eBh = str;
    }

    public String biv() {
        return this.eBh;
    }

    public void zy(String str) {
        this.eBi = str;
    }
}
