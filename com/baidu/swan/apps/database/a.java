package com.baidu.swan.apps.database;
/* loaded from: classes9.dex */
public class a {
    public String appDownloadUrl;
    public String appId;
    public String appKey;
    public String bearInfo;
    public String cYA;
    public int cYB;
    public String cYC;
    public String cYD;
    public long cYE;
    public int cYF;
    public String cYG;
    public boolean cYH;
    public String cYz;
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

    public String atb() {
        return "SwanAppDbInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', errorCode=" + this.errorCode + ", errorDetail='" + this.errorDetail + "', errorMsg='" + this.errorMsg + "', resumeDate='" + this.resumeDate + "', maxSwanVersion='" + this.cYz + "', minSwanVersion='" + this.cYA + "', name='" + this.name + "', version='" + this.version + "', type=" + this.type + ", isHaveZip=" + this.cYB + ", targetSwanVersion='" + this.cYD + "', mAppZipSize=" + this.cYE + ", mPendingApsErrcode=" + this.cYF + ", category=" + this.category + ", versionCode='" + this.cYG + "', maxAge=" + this.maxAge + ", createTime=" + this.createTime + ", forceFetchMetaInfoFlag=" + this.cYH + ", payProtected=" + this.payProtected + '}';
    }
}
