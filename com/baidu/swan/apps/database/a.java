package com.baidu.swan.apps.database;
/* loaded from: classes8.dex */
public class a {
    public String appDownloadUrl;
    public String appId;
    public String appKey;
    public String bearInfo;
    public String cWn;
    public String cWo;
    public int cWp;
    public String cWq;
    public String cWr;
    public long cWs;
    public int cWt;
    public String cWu;
    public boolean cWv;
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

    public String asD() {
        return "SwanAppDbInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', errorCode=" + this.errorCode + ", errorDetail='" + this.errorDetail + "', errorMsg='" + this.errorMsg + "', resumeDate='" + this.resumeDate + "', maxSwanVersion='" + this.cWn + "', minSwanVersion='" + this.cWo + "', name='" + this.name + "', version='" + this.version + "', type=" + this.type + ", isHaveZip=" + this.cWp + ", targetSwanVersion='" + this.cWr + "', mAppZipSize=" + this.cWs + ", mPendingApsErrcode=" + this.cWt + ", category=" + this.category + ", versionCode='" + this.cWu + "', maxAge=" + this.maxAge + ", createTime=" + this.createTime + ", forceFetchMetaInfoFlag=" + this.cWv + ", payProtected=" + this.payProtected + '}';
    }
}
