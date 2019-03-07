package com.baidu.swan.apps.database;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class a {
    public String appId;
    public String appKey;
    public String atT;
    public String atU;
    public String atV;
    public String atW;
    public String atX;
    public String atY;
    public int atZ;
    public String aua;
    public String aub;
    public String auc;
    public long aud;
    public int aue;
    public String auf;
    public long aug = 432000;
    public boolean auh;
    public int category;
    public long createTime;
    public String description;
    public int errorCode;
    public String errorDetail;
    public String errorMsg;
    public String icon;
    public String iconUrl;
    public String name;
    public int orientation;
    public String sign;
    public int type;
    public String version;

    public static boolean e(a aVar) {
        return (aVar == null || aVar.aue == 0) ? false : true;
    }

    public boolean AF() {
        return (System.currentTimeMillis() - this.createTime) / 1000 > this.aug;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.appId);
    }

    public String toShortString() {
        return "SwanAppDbInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', errorCode=" + this.errorCode + ", errorDetail='" + this.errorDetail + "', errorMsg='" + this.errorMsg + "', resumeDate='" + this.atT + "', maxSwanVersion='" + this.atU + "', minSwanVersion='" + this.atV + "', name='" + this.name + "', version='" + this.version + "', type=" + this.type + ", isHaveZip=" + this.atZ + ", targetSwanVersion='" + this.auc + "', mAppZipSize=" + this.aud + ", mPendingApsErrcode=" + this.aue + ", category=" + this.category + ", versionCode='" + this.auf + "', maxAge=" + this.aug + ", createTime=" + this.createTime + ", forceFetchMetaInfoFlag=" + this.auh + '}';
    }
}
