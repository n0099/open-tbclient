package com.baidu.swan.apps.database;
/* loaded from: classes8.dex */
public class a {
    public String appDownloadUrl;
    public String appId;
    public String appKey;
    public String bearInfo;
    public String cZZ;
    public int category;
    public long createTime;
    public String daa;
    public int dab;
    public String dac;
    public String dad;
    public long dae;
    public int daf;
    public String dag;
    public boolean dah;
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

    public String ate() {
        return "SwanAppDbInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', errorCode=" + this.errorCode + ", errorDetail='" + this.errorDetail + "', errorMsg='" + this.errorMsg + "', resumeDate='" + this.resumeDate + "', maxSwanVersion='" + this.cZZ + "', minSwanVersion='" + this.daa + "', name='" + this.name + "', version='" + this.version + "', type=" + this.type + ", isHaveZip=" + this.dab + ", targetSwanVersion='" + this.dad + "', mAppZipSize=" + this.dae + ", mPendingApsErrcode=" + this.daf + ", category=" + this.category + ", versionCode='" + this.dag + "', maxAge=" + this.maxAge + ", createTime=" + this.createTime + ", forceFetchMetaInfoFlag=" + this.dah + ", payProtected=" + this.payProtected + '}';
    }
}
