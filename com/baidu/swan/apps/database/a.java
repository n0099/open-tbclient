package com.baidu.swan.apps.database;
/* loaded from: classes10.dex */
public class a {
    public String appId;
    public String appKey;
    public String bearInfo;
    public String cLd;
    public String cLe;
    public int cLf;
    public String cLg;
    public String cLh;
    public String cLi;
    public long cLj;
    public int cLk;
    public String cLl;
    public boolean cLm;
    public int category;
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

    public String aqd() {
        return "SwanAppDbInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', errorCode=" + this.errorCode + ", errorDetail='" + this.errorDetail + "', errorMsg='" + this.errorMsg + "', resumeDate='" + this.resumeDate + "', maxSwanVersion='" + this.cLd + "', minSwanVersion='" + this.cLe + "', name='" + this.name + "', version='" + this.version + "', type=" + this.type + ", isHaveZip=" + this.cLf + ", targetSwanVersion='" + this.cLi + "', mAppZipSize=" + this.cLj + ", mPendingApsErrcode=" + this.cLk + ", category=" + this.category + ", versionCode='" + this.cLl + "', maxAge=" + this.maxAge + ", createTime=" + this.createTime + ", forceFetchMetaInfoFlag=" + this.cLm + ", payProtected=" + this.payProtected + '}';
    }
}
