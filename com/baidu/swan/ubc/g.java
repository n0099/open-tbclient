package com.baidu.swan.ubc;
/* loaded from: classes9.dex */
class g {
    private String dAn;
    private String dAo;
    private String dAp;
    private String dAq;
    private int dAr;
    private String dAs;
    private int dAt;
    private int dAu;
    private String dAv;
    private String dAw;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public g(String str, String str2, String str3, int i, String str4, String str5) {
        this.dAo = str;
        this.mId = str;
        this.dAp = str2;
        this.dAq = str3;
        this.dAr = i;
        this.mType = str4;
        this.dAs = str5;
    }

    public void uX(String str) {
        this.dAn = str;
    }

    public void ka(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void kb(int i) {
        this.dAt = i;
    }

    public void kc(int i) {
        this.dAu = i;
    }

    public String getId() {
        return this.mId;
    }

    public String aNh() {
        return this.dAp;
    }

    public String aNi() {
        return this.dAq;
    }

    public int getTimeout() {
        return this.dAr;
    }

    public String getType() {
        return this.mType;
    }

    public String aNj() {
        return this.dAs;
    }

    public int aNk() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int aNl() {
        return this.dAt;
    }

    public int aNm() {
        return this.dAu;
    }

    public void uY(String str) {
        this.dAv = str;
    }

    public String aNn() {
        return this.dAv;
    }

    public void uZ(String str) {
        this.dAw = str;
    }
}
