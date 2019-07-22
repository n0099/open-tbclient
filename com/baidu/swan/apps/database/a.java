package com.baidu.swan.apps.database;

import android.text.TextUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
/* loaded from: classes2.dex */
public class a {
    public String appId;
    public String appKey;
    public String auS;
    public String auT;
    public String auU;
    public String auV;
    public String auW;
    public String auX;
    public int auY;
    public String auZ;
    public String ava;
    public String avb;
    public long avc;
    public int avd;
    public int ave;
    public String avf;
    public long avg = 432000;
    public boolean avh;
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
        return (aVar == null || aVar.avd == 0) ? false : true;
    }

    public boolean Ct() {
        return (System.currentTimeMillis() - this.createTime) / 1000 > this.avg;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.appId);
    }

    public String Cu() {
        return "SwanAppDbInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', errorCode=" + this.errorCode + ", errorDetail='" + this.errorDetail + "', errorMsg='" + this.errorMsg + "', resumeDate='" + this.auS + "', maxSwanVersion='" + this.auT + "', minSwanVersion='" + this.auU + "', name='" + this.name + "', version='" + this.version + "', type=" + this.type + ", isHaveZip=" + this.auY + ", targetSwanVersion='" + this.avb + "', mAppZipSize=" + this.avc + ", mPendingApsErrcode=" + this.avd + ", category=" + this.ave + ", versionCode='" + this.avf + "', maxAge=" + this.avg + ", createTime=" + this.createTime + ", forceFetchMetaInfoFlag=" + this.avh + '}';
    }

    public static PMSAppInfo f(a aVar) {
        if (aVar == null) {
            return null;
        }
        PMSAppInfo pMSAppInfo = new PMSAppInfo();
        pMSAppInfo.appId = aVar.appId;
        pMSAppInfo.appKey = aVar.appKey;
        pMSAppInfo.bsG = ec(aVar.sign);
        pMSAppInfo.versionCode = (int) ec(aVar.version);
        pMSAppInfo.versionName = aVar.avf;
        pMSAppInfo.description = aVar.description;
        pMSAppInfo.appStatus = aVar.errorCode;
        pMSAppInfo.bsH = aVar.errorDetail;
        pMSAppInfo.bsI = aVar.errorMsg;
        pMSAppInfo.auS = aVar.auS;
        pMSAppInfo.iconUrl = aVar.iconUrl;
        pMSAppInfo.appName = aVar.name;
        pMSAppInfo.auV = aVar.auV;
        pMSAppInfo.auW = aVar.auW;
        pMSAppInfo.type = aVar.type;
        pMSAppInfo.bsJ = aVar.avc;
        pMSAppInfo.bsK = aVar.avd;
        pMSAppInfo.bsL = aVar.ave;
        pMSAppInfo.orientation = aVar.orientation;
        pMSAppInfo.avg = aVar.avg;
        pMSAppInfo.createTime = aVar.createTime;
        return pMSAppInfo;
    }

    private static long ec(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            if (!com.baidu.swan.apps.b.DEBUG) {
                return 0L;
            }
            e.printStackTrace();
            return 0L;
        }
    }
}
