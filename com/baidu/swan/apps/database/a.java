package com.baidu.swan.apps.database;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class a {
    public String appId;
    public String appKey;
    public String atY;
    public String atZ;
    public String aua;
    public String aub;
    public String auc;
    public String aud;
    public int aue;
    public String auf;
    public String aug;
    public String auh;
    public long aui;
    public int auj;
    public String auk;
    public long aul = 432000;
    public boolean aum;
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
        return (aVar == null || aVar.auj == 0) ? false : true;
    }

    public boolean AE() {
        return (System.currentTimeMillis() - this.createTime) / 1000 > this.aul;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.appId);
    }

    public String toShortString() {
        return "SwanAppDbInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', errorCode=" + this.errorCode + ", errorDetail='" + this.errorDetail + "', errorMsg='" + this.errorMsg + "', resumeDate='" + this.atY + "', maxSwanVersion='" + this.atZ + "', minSwanVersion='" + this.aua + "', name='" + this.name + "', version='" + this.version + "', type=" + this.type + ", isHaveZip=" + this.aue + ", targetSwanVersion='" + this.auh + "', mAppZipSize=" + this.aui + ", mPendingApsErrcode=" + this.auj + ", category=" + this.category + ", versionCode='" + this.auk + "', maxAge=" + this.aul + ", createTime=" + this.createTime + ", forceFetchMetaInfoFlag=" + this.aum + '}';
    }
}
