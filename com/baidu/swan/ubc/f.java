package com.baidu.swan.ubc;
/* loaded from: classes2.dex */
class f {
    private String bvA;
    private String bvu;
    private String bvv;
    private int bvw;
    private String bvx;
    private int bvy;
    private int bvz;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public f(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.bvu = str2;
        this.bvv = str3;
        this.bvw = i;
        this.mType = str4;
        this.bvx = str5;
    }

    public void fU(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void fV(int i) {
        this.bvy = i;
    }

    public void fW(int i) {
        this.bvz = i;
    }

    public String getId() {
        return this.mId;
    }

    public String WM() {
        return this.bvu;
    }

    public String WN() {
        return this.bvv;
    }

    public int getTimeout() {
        return this.bvw;
    }

    public String getType() {
        return this.mType;
    }

    public String WO() {
        return this.bvx;
    }

    public int WP() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int WQ() {
        return this.bvy;
    }

    public int WR() {
        return this.bvz;
    }

    public void kM(String str) {
        this.bvA = str;
    }

    public String getIdType() {
        return this.bvA;
    }
}
