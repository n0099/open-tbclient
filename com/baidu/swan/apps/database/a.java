package com.baidu.swan.apps.database;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class a {
    public String appId;
    public String appKey;
    public String atU;
    public String atV;
    public String atW;
    public String atX;
    public String atY;
    public String atZ;
    public int aua;
    public String aub;
    public String auc;
    public String aud;
    public long aue;
    public int auf;
    public String aug;
    public long auh = 432000;
    public boolean aui;
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
        return (aVar == null || aVar.auf == 0) ? false : true;
    }

    public boolean AF() {
        return (System.currentTimeMillis() - this.createTime) / 1000 > this.auh;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.appId);
    }

    public String toShortString() {
        return "SwanAppDbInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', errorCode=" + this.errorCode + ", errorDetail='" + this.errorDetail + "', errorMsg='" + this.errorMsg + "', resumeDate='" + this.atU + "', maxSwanVersion='" + this.atV + "', minSwanVersion='" + this.atW + "', name='" + this.name + "', version='" + this.version + "', type=" + this.type + ", isHaveZip=" + this.aua + ", targetSwanVersion='" + this.aud + "', mAppZipSize=" + this.aue + ", mPendingApsErrcode=" + this.auf + ", category=" + this.category + ", versionCode='" + this.aug + "', maxAge=" + this.auh + ", createTime=" + this.createTime + ", forceFetchMetaInfoFlag=" + this.aui + '}';
    }
}
