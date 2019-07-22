package com.baidu.swan.ubc;
/* loaded from: classes2.dex */
class f {
    private String bwk;
    private String bwl;
    private int bwm;
    private String bwn;
    private int bwo;
    private int bwp;
    private String bwq;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public f(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.bwk = str2;
        this.bwl = str3;
        this.bwm = i;
        this.mType = str4;
        this.bwn = str5;
    }

    public void fY(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void fZ(int i) {
        this.bwo = i;
    }

    public void ga(int i) {
        this.bwp = i;
    }

    public String getId() {
        return this.mId;
    }

    public String XG() {
        return this.bwk;
    }

    public String XH() {
        return this.bwl;
    }

    public int getTimeout() {
        return this.bwm;
    }

    public String getType() {
        return this.mType;
    }

    public String XI() {
        return this.bwn;
    }

    public int XJ() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int XK() {
        return this.bwo;
    }

    public int XL() {
        return this.bwp;
    }

    public void kU(String str) {
        this.bwq = str;
    }

    public String XM() {
        return this.bwq;
    }
}
