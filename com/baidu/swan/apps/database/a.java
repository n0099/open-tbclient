package com.baidu.swan.apps.database;
/* loaded from: classes8.dex */
public class a {
    public String appId;
    public String appKey;
    public String bearInfo;
    public int category;
    public String coq;
    public String cor;
    public int cos;
    public String cot;
    public String cou;
    public String cov;
    public long cow;
    public int cox;
    public String coy;
    public boolean coz;
    public long createTime;
    public String description;
    public int errorCode;
    public String errorDetail;
    public String errorMsg;
    public String icon;
    public String iconUrl;
    public long maxAge = 432000;
    public String name;
    public int orientation;
    public int payProtected;
    public String quickAppKey;
    public String resumeDate;
    public String serviceCategory;
    public String sign;
    public String subjectInfo;
    public int type;
    public String version;

    public String akN() {
        return "SwanAppDbInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', errorCode=" + this.errorCode + ", errorDetail='" + this.errorDetail + "', errorMsg='" + this.errorMsg + "', resumeDate='" + this.resumeDate + "', maxSwanVersion='" + this.coq + "', minSwanVersion='" + this.cor + "', name='" + this.name + "', version='" + this.version + "', type=" + this.type + ", isHaveZip=" + this.cos + ", targetSwanVersion='" + this.cov + "', mAppZipSize=" + this.cow + ", mPendingApsErrcode=" + this.cox + ", category=" + this.category + ", versionCode='" + this.coy + "', maxAge=" + this.maxAge + ", createTime=" + this.createTime + ", forceFetchMetaInfoFlag=" + this.coz + ", payProtected=" + this.payProtected + '}';
    }
}
