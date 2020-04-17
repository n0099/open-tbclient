package com.baidu.swan.apps.database;
/* loaded from: classes11.dex */
public class a {
    public String appId;
    public String appKey;
    public String bRA;
    public boolean bRB;
    public String bRs;
    public String bRt;
    public int bRu;
    public String bRv;
    public String bRw;
    public String bRx;
    public long bRy;
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

    public String YS() {
        return "SwanAppDbInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', errorCode=" + this.errorCode + ", errorDetail='" + this.errorDetail + "', errorMsg='" + this.errorMsg + "', resumeDate='" + this.resumeDate + "', maxSwanVersion='" + this.bRs + "', minSwanVersion='" + this.bRt + "', name='" + this.name + "', version='" + this.version + "', type=" + this.type + ", isHaveZip=" + this.bRu + ", targetSwanVersion='" + this.bRx + "', mAppZipSize=" + this.bRy + ", mPendingApsErrcode=" + this.bRz + ", category=" + this.category + ", versionCode='" + this.bRA + "', maxAge=" + this.maxAge + ", createTime=" + this.createTime + ", forceFetchMetaInfoFlag=" + this.bRB + ", payProtected=" + this.payProtected + '}';
    }
}
