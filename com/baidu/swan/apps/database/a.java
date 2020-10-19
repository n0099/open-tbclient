package com.baidu.swan.apps.database;
/* loaded from: classes10.dex */
public class a {
    public String appId;
    public String appKey;
    public String bearInfo;
    public String cCH;
    public String cCI;
    public int cCJ;
    public String cCK;
    public String cCL;
    public String cCM;
    public long cCN;
    public int cCO;
    public String cCP;
    public boolean cCQ;
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

    public String aoi() {
        return "SwanAppDbInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', errorCode=" + this.errorCode + ", errorDetail='" + this.errorDetail + "', errorMsg='" + this.errorMsg + "', resumeDate='" + this.resumeDate + "', maxSwanVersion='" + this.cCH + "', minSwanVersion='" + this.cCI + "', name='" + this.name + "', version='" + this.version + "', type=" + this.type + ", isHaveZip=" + this.cCJ + ", targetSwanVersion='" + this.cCM + "', mAppZipSize=" + this.cCN + ", mPendingApsErrcode=" + this.cCO + ", category=" + this.category + ", versionCode='" + this.cCP + "', maxAge=" + this.maxAge + ", createTime=" + this.createTime + ", forceFetchMetaInfoFlag=" + this.cCQ + ", payProtected=" + this.payProtected + '}';
    }
}
