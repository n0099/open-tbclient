package com.baidu.swan.apps.database;
/* loaded from: classes11.dex */
public class a {
    public String appId;
    public String appKey;
    public String bearInfo;
    public String btl;
    public String btm;
    public int btn;
    public String bto;
    public String btp;
    public String btq;
    public long btr;
    public int bts;
    public String btt;
    public boolean btu;
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

    public String Rd() {
        return "SwanAppDbInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', errorCode=" + this.errorCode + ", errorDetail='" + this.errorDetail + "', errorMsg='" + this.errorMsg + "', resumeDate='" + this.resumeDate + "', maxSwanVersion='" + this.btl + "', minSwanVersion='" + this.btm + "', name='" + this.name + "', version='" + this.version + "', type=" + this.type + ", isHaveZip=" + this.btn + ", targetSwanVersion='" + this.btq + "', mAppZipSize=" + this.btr + ", mPendingApsErrcode=" + this.bts + ", category=" + this.category + ", versionCode='" + this.btt + "', maxAge=" + this.maxAge + ", createTime=" + this.createTime + ", forceFetchMetaInfoFlag=" + this.btu + ", payProtected=" + this.payProtected + '}';
    }
}
