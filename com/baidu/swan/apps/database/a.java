package com.baidu.swan.apps.database;
/* loaded from: classes9.dex */
public class a {
    public String appDownloadUrl;
    public String appId;
    public String appKey;
    public String bearInfo;
    public int category;
    public long createTime;
    public String dbb;
    public String dbc;
    public int dbd;
    public String dbe;
    public String dbf;
    public long dbg;
    public int dbh;
    public String dbi;
    public boolean dbj;
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

    public String aww() {
        return "SwanAppDbInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', errorCode=" + this.errorCode + ", errorDetail='" + this.errorDetail + "', errorMsg='" + this.errorMsg + "', resumeDate='" + this.resumeDate + "', maxSwanVersion='" + this.dbb + "', minSwanVersion='" + this.dbc + "', name='" + this.name + "', version='" + this.version + "', type=" + this.type + ", isHaveZip=" + this.dbd + ", targetSwanVersion='" + this.dbf + "', mAppZipSize=" + this.dbg + ", mPendingApsErrcode=" + this.dbh + ", category=" + this.category + ", versionCode='" + this.dbi + "', maxAge=" + this.maxAge + ", createTime=" + this.createTime + ", forceFetchMetaInfoFlag=" + this.dbj + ", payProtected=" + this.payProtected + '}';
    }
}
