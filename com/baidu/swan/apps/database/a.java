package com.baidu.swan.apps.database;
/* loaded from: classes25.dex */
public class a {
    public String appId;
    public String appKey;
    public String bearInfo;
    public String cWf;
    public String cWg;
    public int cWh;
    public String cWi;
    public String cWj;
    public String cWk;
    public long cWl;
    public int cWm;
    public String cWn;
    public boolean cWo;
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

    public String ave() {
        return "SwanAppDbInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', errorCode=" + this.errorCode + ", errorDetail='" + this.errorDetail + "', errorMsg='" + this.errorMsg + "', resumeDate='" + this.resumeDate + "', maxSwanVersion='" + this.cWf + "', minSwanVersion='" + this.cWg + "', name='" + this.name + "', version='" + this.version + "', type=" + this.type + ", isHaveZip=" + this.cWh + ", targetSwanVersion='" + this.cWk + "', mAppZipSize=" + this.cWl + ", mPendingApsErrcode=" + this.cWm + ", category=" + this.category + ", versionCode='" + this.cWn + "', maxAge=" + this.maxAge + ", createTime=" + this.createTime + ", forceFetchMetaInfoFlag=" + this.cWo + ", payProtected=" + this.payProtected + '}';
    }
}
