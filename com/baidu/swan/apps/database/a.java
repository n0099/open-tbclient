package com.baidu.swan.apps.database;
/* loaded from: classes11.dex */
public class a {
    public String appId;
    public String appKey;
    public String bearInfo;
    public int category;
    public String cbn;
    public String cbo;
    public int cbp;
    public String cbq;
    public String cbr;
    public String cbs;
    public long cbt;
    public int cbu;
    public String cbv;
    public boolean cbw;
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

    public String abS() {
        return "SwanAppDbInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', errorCode=" + this.errorCode + ", errorDetail='" + this.errorDetail + "', errorMsg='" + this.errorMsg + "', resumeDate='" + this.resumeDate + "', maxSwanVersion='" + this.cbn + "', minSwanVersion='" + this.cbo + "', name='" + this.name + "', version='" + this.version + "', type=" + this.type + ", isHaveZip=" + this.cbp + ", targetSwanVersion='" + this.cbs + "', mAppZipSize=" + this.cbt + ", mPendingApsErrcode=" + this.cbu + ", category=" + this.category + ", versionCode='" + this.cbv + "', maxAge=" + this.maxAge + ", createTime=" + this.createTime + ", forceFetchMetaInfoFlag=" + this.cbw + ", payProtected=" + this.payProtected + '}';
    }
}
