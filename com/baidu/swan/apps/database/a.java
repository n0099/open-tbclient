package com.baidu.swan.apps.database;
/* loaded from: classes7.dex */
public class a {
    public String appId;
    public String appKey;
    public String bearInfo;
    public int category;
    public String chO;
    public String chP;
    public int chQ;
    public String chR;
    public String chS;
    public String chT;
    public long chU;
    public int chV;
    public String chW;
    public boolean chX;
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
    public String resumeDate;
    public String serviceCategory;
    public String sign;
    public String subjectInfo;
    public int type;
    public String version;

    public String aed() {
        return "SwanAppDbInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', errorCode=" + this.errorCode + ", errorDetail='" + this.errorDetail + "', errorMsg='" + this.errorMsg + "', resumeDate='" + this.resumeDate + "', maxSwanVersion='" + this.chO + "', minSwanVersion='" + this.chP + "', name='" + this.name + "', version='" + this.version + "', type=" + this.type + ", isHaveZip=" + this.chQ + ", targetSwanVersion='" + this.chT + "', mAppZipSize=" + this.chU + ", mPendingApsErrcode=" + this.chV + ", category=" + this.category + ", versionCode='" + this.chW + "', maxAge=" + this.maxAge + ", createTime=" + this.createTime + ", forceFetchMetaInfoFlag=" + this.chX + ", payProtected=" + this.payProtected + '}';
    }
}
