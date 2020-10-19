package com.baidu.swan.ubc;
/* loaded from: classes9.dex */
class g {
    private String dXF;
    private String dXG;
    private String dXH;
    private String dXI;
    private int dXJ;
    private String dXK;
    private int dXL;
    private int dXM;
    private String dXN;
    private String dXO;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public g(String str, String str2, String str3, int i, String str4, String str5) {
        this.dXG = str;
        this.mId = str;
        this.dXH = str2;
        this.dXI = str3;
        this.dXJ = i;
        this.mType = str4;
        this.dXK = str5;
    }

    public void yo(String str) {
        this.dXF = str;
    }

    public void mO(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void mP(int i) {
        this.dXL = i;
    }

    public void mQ(int i) {
        this.dXM = i;
    }

    public String getId() {
        return this.mId;
    }

    public String aZb() {
        return this.dXH;
    }

    public String aZc() {
        return this.dXI;
    }

    public int getTimeout() {
        return this.dXJ;
    }

    public String getType() {
        return this.mType;
    }

    public String aZd() {
        return this.dXK;
    }

    public int aZe() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int aZf() {
        return this.dXL;
    }

    public int aZg() {
        return this.dXM;
    }

    public void yp(String str) {
        this.dXN = str;
    }

    public String aZh() {
        return this.dXN;
    }

    public void yq(String str) {
        this.dXO = str;
    }
}
