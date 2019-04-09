package com.baidu.swan.apps.database;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class a {
    public String appId;
    public String appKey;
    public String atZ;
    public String aua;
    public String aub;
    public String auc;
    public String aud;
    public String aue;
    public int auf;
    public String aug;
    public String auh;
    public String aui;
    public long auj;
    public int auk;
    public String aul;
    public long aum = 432000;
    public boolean aun;
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
        return (aVar == null || aVar.auk == 0) ? false : true;
    }

    public boolean AE() {
        return (System.currentTimeMillis() - this.createTime) / 1000 > this.aum;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.appId);
    }

    public String toShortString() {
        return "SwanAppDbInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', errorCode=" + this.errorCode + ", errorDetail='" + this.errorDetail + "', errorMsg='" + this.errorMsg + "', resumeDate='" + this.atZ + "', maxSwanVersion='" + this.aua + "', minSwanVersion='" + this.aub + "', name='" + this.name + "', version='" + this.version + "', type=" + this.type + ", isHaveZip=" + this.auf + ", targetSwanVersion='" + this.aui + "', mAppZipSize=" + this.auj + ", mPendingApsErrcode=" + this.auk + ", category=" + this.category + ", versionCode='" + this.aul + "', maxAge=" + this.aum + ", createTime=" + this.createTime + ", forceFetchMetaInfoFlag=" + this.aun + '}';
    }
}
