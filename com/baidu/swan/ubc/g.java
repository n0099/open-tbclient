package com.baidu.swan.ubc;
/* loaded from: classes6.dex */
class g {
    private String ewk;
    private String ewl;
    private String ewm;
    private String ewn;
    private int ewo;
    private String ewp;
    private int ewq;
    private int ewr;
    private String ews;
    private String ewt;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public g(String str, String str2, String str3, int i, String str4, String str5) {
        this.ewl = str;
        this.mId = str;
        this.ewm = str2;
        this.ewn = str3;
        this.ewo = i;
        this.mType = str4;
        this.ewp = str5;
    }

    public void yl(String str) {
        this.ewk = str;
    }

    public void mg(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void mh(int i) {
        this.ewq = i;
    }

    public void mi(int i) {
        this.ewr = i;
    }

    public String getId() {
        return this.mId;
    }

    public String bew() {
        return this.ewm;
    }

    public String bex() {
        return this.ewn;
    }

    public int getTimeout() {
        return this.ewo;
    }

    public String getType() {
        return this.mType;
    }

    public String bey() {
        return this.ewp;
    }

    public int bez() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int beA() {
        return this.ewq;
    }

    public int beB() {
        return this.ewr;
    }

    public void ym(String str) {
        this.ews = str;
    }

    public String beC() {
        return this.ews;
    }

    public void yn(String str) {
        this.ewt = str;
    }
}
