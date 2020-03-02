package com.baidu.swan.apps.database;
/* loaded from: classes11.dex */
public class a {
    public String appId;
    public String appKey;
    public String bearInfo;
    public String bsY;
    public String bsZ;
    public int bta;
    public String btb;
    public String btc;
    public String btd;
    public long bte;
    public int btf;
    public String btg;
    public boolean bth;
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
        return "SwanAppDbInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', errorCode=" + this.errorCode + ", errorDetail='" + this.errorDetail + "', errorMsg='" + this.errorMsg + "', resumeDate='" + this.resumeDate + "', maxSwanVersion='" + this.bsY + "', minSwanVersion='" + this.bsZ + "', name='" + this.name + "', version='" + this.version + "', type=" + this.type + ", isHaveZip=" + this.bta + ", targetSwanVersion='" + this.btd + "', mAppZipSize=" + this.bte + ", mPendingApsErrcode=" + this.btf + ", category=" + this.category + ", versionCode='" + this.btg + "', maxAge=" + this.maxAge + ", createTime=" + this.createTime + ", forceFetchMetaInfoFlag=" + this.bth + ", payProtected=" + this.payProtected + '}';
    }
}
