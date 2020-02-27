package com.baidu.swan.apps.database;
/* loaded from: classes11.dex */
public class a {
    public String appId;
    public String appKey;
    public String bearInfo;
    public String bsX;
    public String bsY;
    public int bsZ;
    public String bta;
    public String btb;
    public String btc;
    public long btd;
    public int bte;
    public String btf;
    public boolean btg;
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

    public String QY() {
        return "SwanAppDbInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', errorCode=" + this.errorCode + ", errorDetail='" + this.errorDetail + "', errorMsg='" + this.errorMsg + "', resumeDate='" + this.resumeDate + "', maxSwanVersion='" + this.bsX + "', minSwanVersion='" + this.bsY + "', name='" + this.name + "', version='" + this.version + "', type=" + this.type + ", isHaveZip=" + this.bsZ + ", targetSwanVersion='" + this.btc + "', mAppZipSize=" + this.btd + ", mPendingApsErrcode=" + this.bte + ", category=" + this.category + ", versionCode='" + this.btf + "', maxAge=" + this.maxAge + ", createTime=" + this.createTime + ", forceFetchMetaInfoFlag=" + this.btg + ", payProtected=" + this.payProtected + '}';
    }
}
