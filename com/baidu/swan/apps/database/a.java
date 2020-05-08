package com.baidu.swan.apps.database;
/* loaded from: classes11.dex */
public class a {
    public String appId;
    public String appKey;
    public String bRA;
    public String bRB;
    public String bRC;
    public long bRD;
    public int bRE;
    public String bRF;
    public boolean bRG;
    public String bRx;
    public String bRy;
    public int bRz;
    public String bearInfo;
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

    public String YR() {
        return "SwanAppDbInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', errorCode=" + this.errorCode + ", errorDetail='" + this.errorDetail + "', errorMsg='" + this.errorMsg + "', resumeDate='" + this.resumeDate + "', maxSwanVersion='" + this.bRx + "', minSwanVersion='" + this.bRy + "', name='" + this.name + "', version='" + this.version + "', type=" + this.type + ", isHaveZip=" + this.bRz + ", targetSwanVersion='" + this.bRC + "', mAppZipSize=" + this.bRD + ", mPendingApsErrcode=" + this.bRE + ", category=" + this.category + ", versionCode='" + this.bRF + "', maxAge=" + this.maxAge + ", createTime=" + this.createTime + ", forceFetchMetaInfoFlag=" + this.bRG + ", payProtected=" + this.payProtected + '}';
    }
}
