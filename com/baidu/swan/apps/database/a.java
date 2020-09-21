package com.baidu.swan.apps.database;
/* loaded from: classes3.dex */
public class a {
    public String appId;
    public String appKey;
    public String bearInfo;
    public int category;
    public int cqA;
    public String cqB;
    public boolean cqC;
    public String cqt;
    public String cqu;
    public int cqv;
    public String cqw;
    public String cqx;
    public String cqy;
    public long cqz;
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

    public String alx() {
        return "SwanAppDbInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', errorCode=" + this.errorCode + ", errorDetail='" + this.errorDetail + "', errorMsg='" + this.errorMsg + "', resumeDate='" + this.resumeDate + "', maxSwanVersion='" + this.cqt + "', minSwanVersion='" + this.cqu + "', name='" + this.name + "', version='" + this.version + "', type=" + this.type + ", isHaveZip=" + this.cqv + ", targetSwanVersion='" + this.cqy + "', mAppZipSize=" + this.cqz + ", mPendingApsErrcode=" + this.cqA + ", category=" + this.category + ", versionCode='" + this.cqB + "', maxAge=" + this.maxAge + ", createTime=" + this.createTime + ", forceFetchMetaInfoFlag=" + this.cqC + ", payProtected=" + this.payProtected + '}';
    }
}
