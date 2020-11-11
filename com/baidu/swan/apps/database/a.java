package com.baidu.swan.apps.database;
/* loaded from: classes10.dex */
public class a {
    public String appId;
    public String appKey;
    public String bearInfo;
    public String cQW;
    public String cQX;
    public int cQY;
    public String cQZ;
    public String cRa;
    public String cRb;
    public long cRc;
    public int cRd;
    public String cRe;
    public boolean cRf;
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

    public String asE() {
        return "SwanAppDbInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', errorCode=" + this.errorCode + ", errorDetail='" + this.errorDetail + "', errorMsg='" + this.errorMsg + "', resumeDate='" + this.resumeDate + "', maxSwanVersion='" + this.cQW + "', minSwanVersion='" + this.cQX + "', name='" + this.name + "', version='" + this.version + "', type=" + this.type + ", isHaveZip=" + this.cQY + ", targetSwanVersion='" + this.cRb + "', mAppZipSize=" + this.cRc + ", mPendingApsErrcode=" + this.cRd + ", category=" + this.category + ", versionCode='" + this.cRe + "', maxAge=" + this.maxAge + ", createTime=" + this.createTime + ", forceFetchMetaInfoFlag=" + this.cRf + ", payProtected=" + this.payProtected + '}';
    }
}
