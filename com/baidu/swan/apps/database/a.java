package com.baidu.swan.apps.database;
/* loaded from: classes11.dex */
public class a {
    public String appId;
    public String appKey;
    public String bearInfo;
    public String bsZ;
    public String bta;
    public int btb;
    public String btc;
    public String btd;
    public String bte;
    public long btf;
    public int btg;
    public String bth;
    public boolean bti;
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

    public String Ra() {
        return "SwanAppDbInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', errorCode=" + this.errorCode + ", errorDetail='" + this.errorDetail + "', errorMsg='" + this.errorMsg + "', resumeDate='" + this.resumeDate + "', maxSwanVersion='" + this.bsZ + "', minSwanVersion='" + this.bta + "', name='" + this.name + "', version='" + this.version + "', type=" + this.type + ", isHaveZip=" + this.btb + ", targetSwanVersion='" + this.bte + "', mAppZipSize=" + this.btf + ", mPendingApsErrcode=" + this.btg + ", category=" + this.category + ", versionCode='" + this.bth + "', maxAge=" + this.maxAge + ", createTime=" + this.createTime + ", forceFetchMetaInfoFlag=" + this.bti + ", payProtected=" + this.payProtected + '}';
    }
}
