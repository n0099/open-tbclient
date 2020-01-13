package com.baidu.swan.apps.database;
/* loaded from: classes10.dex */
public class a {
    public String appId;
    public String appKey;
    public String bearInfo;
    public String boO;
    public String boP;
    public int boQ;
    public String boR;
    public String boS;
    public String boT;
    public long boU;
    public int boV;
    public String boW;
    public boolean boX;
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
    public String resumeDate;
    public String serviceCategory;
    public String sign;
    public String subjectInfo;
    public int type;
    public String version;

    public String OK() {
        return "SwanAppDbInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', errorCode=" + this.errorCode + ", errorDetail='" + this.errorDetail + "', errorMsg='" + this.errorMsg + "', resumeDate='" + this.resumeDate + "', maxSwanVersion='" + this.boO + "', minSwanVersion='" + this.boP + "', name='" + this.name + "', version='" + this.version + "', type=" + this.type + ", isHaveZip=" + this.boQ + ", targetSwanVersion='" + this.boT + "', mAppZipSize=" + this.boU + ", mPendingApsErrcode=" + this.boV + ", category=" + this.category + ", versionCode='" + this.boW + "', maxAge=" + this.maxAge + ", createTime=" + this.createTime + ", forceFetchMetaInfoFlag=" + this.boX + ", payProtected=" + this.payProtected + '}';
    }
}
