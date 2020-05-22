package com.baidu.swan.ubc;
/* loaded from: classes11.dex */
class g {
    private String dpM;
    private String dpN;
    private String dpO;
    private String dpP;
    private int dpQ;
    private String dpR;
    private int dpS;
    private int dpT;
    private String dpU;
    private String dpV;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public g(String str, String str2, String str3, int i, String str4, String str5) {
        this.dpN = str;
        this.mId = str;
        this.dpO = str2;
        this.dpP = str3;
        this.dpQ = i;
        this.mType = str4;
        this.dpR = str5;
    }

    public void tM(String str) {
        this.dpM = str;
    }

    public void ju(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void jv(int i) {
        this.dpS = i;
    }

    public void jw(int i) {
        this.dpT = i;
    }

    public String getId() {
        return this.mId;
    }

    public String aIj() {
        return this.dpO;
    }

    public String aIk() {
        return this.dpP;
    }

    public int getTimeout() {
        return this.dpQ;
    }

    public String getType() {
        return this.mType;
    }

    public String aIl() {
        return this.dpR;
    }

    public int aIm() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int aIn() {
        return this.dpS;
    }

    public int aIo() {
        return this.dpT;
    }

    public void tN(String str) {
        this.dpU = str;
    }

    public String aIp() {
        return this.dpU;
    }

    public void tO(String str) {
        this.dpV = str;
    }
}
