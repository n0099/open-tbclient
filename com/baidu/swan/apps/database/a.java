package com.baidu.swan.apps.database;
/* loaded from: classes7.dex */
public class a {
    public String appId;
    public String appKey;
    public String bearInfo;
    public String cPm;
    public String cPn;
    public int cPo;
    public String cPp;
    public String cPq;
    public String cPr;
    public long cPs;
    public int cPt;
    public String cPu;
    public boolean cPv;
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

    public String arV() {
        return "SwanAppDbInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', errorCode=" + this.errorCode + ", errorDetail='" + this.errorDetail + "', errorMsg='" + this.errorMsg + "', resumeDate='" + this.resumeDate + "', maxSwanVersion='" + this.cPm + "', minSwanVersion='" + this.cPn + "', name='" + this.name + "', version='" + this.version + "', type=" + this.type + ", isHaveZip=" + this.cPo + ", targetSwanVersion='" + this.cPr + "', mAppZipSize=" + this.cPs + ", mPendingApsErrcode=" + this.cPt + ", category=" + this.category + ", versionCode='" + this.cPu + "', maxAge=" + this.maxAge + ", createTime=" + this.createTime + ", forceFetchMetaInfoFlag=" + this.cPv + ", payProtected=" + this.payProtected + '}';
    }
}
