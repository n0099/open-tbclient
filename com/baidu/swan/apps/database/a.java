package com.baidu.swan.apps.database;
/* loaded from: classes11.dex */
public class a {
    public String appId;
    public String appKey;
    public String bearInfo;
    public int category;
    public String cgc;
    public String cgd;
    public int cge;
    public String cgf;
    public String cgg;
    public String cgh;
    public long cgi;
    public int cgj;
    public String cgk;
    public boolean cgl;
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

    public String acY() {
        return "SwanAppDbInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', errorCode=" + this.errorCode + ", errorDetail='" + this.errorDetail + "', errorMsg='" + this.errorMsg + "', resumeDate='" + this.resumeDate + "', maxSwanVersion='" + this.cgc + "', minSwanVersion='" + this.cgd + "', name='" + this.name + "', version='" + this.version + "', type=" + this.type + ", isHaveZip=" + this.cge + ", targetSwanVersion='" + this.cgh + "', mAppZipSize=" + this.cgi + ", mPendingApsErrcode=" + this.cgj + ", category=" + this.category + ", versionCode='" + this.cgk + "', maxAge=" + this.maxAge + ", createTime=" + this.createTime + ", forceFetchMetaInfoFlag=" + this.cgl + ", payProtected=" + this.payProtected + '}';
    }
}
