package com.baidu.swan.apps.database;

import android.text.TextUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
/* loaded from: classes2.dex */
public class a {
    public String aOA;
    public long aOB = 432000;
    public boolean aOC;
    public String aOo;
    public String aOp;
    public String aOq;
    public String aOr;
    public String aOs;
    public String aOt;
    public int aOu;
    public String aOv;
    public String aOw;
    public String aOx;
    public long aOy;
    public int aOz;
    public String appId;
    public String appKey;
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
        return (aVar == null || aVar.aOz == 0) ? false : true;
    }

    public boolean Hs() {
        return (System.currentTimeMillis() - this.createTime) / 1000 > this.aOB;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.appId);
    }

    public String Ht() {
        return "SwanAppDbInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', errorCode=" + this.errorCode + ", errorDetail='" + this.errorDetail + "', errorMsg='" + this.errorMsg + "', resumeDate='" + this.aOo + "', maxSwanVersion='" + this.aOp + "', minSwanVersion='" + this.aOq + "', name='" + this.name + "', version='" + this.version + "', type=" + this.type + ", isHaveZip=" + this.aOu + ", targetSwanVersion='" + this.aOx + "', mAppZipSize=" + this.aOy + ", mPendingApsErrcode=" + this.aOz + ", category=" + this.category + ", versionCode='" + this.aOA + "', maxAge=" + this.aOB + ", createTime=" + this.createTime + ", forceFetchMetaInfoFlag=" + this.aOC + '}';
    }

    public static PMSAppInfo f(a aVar) {
        if (aVar == null) {
            return null;
        }
        PMSAppInfo pMSAppInfo = new PMSAppInfo();
        pMSAppInfo.appId = aVar.appId;
        pMSAppInfo.appKey = aVar.appKey;
        pMSAppInfo.bKY = eL(aVar.sign);
        pMSAppInfo.versionCode = (int) eL(aVar.version);
        pMSAppInfo.versionName = aVar.aOA;
        pMSAppInfo.description = aVar.description;
        pMSAppInfo.appStatus = aVar.errorCode;
        pMSAppInfo.bKZ = aVar.errorDetail;
        pMSAppInfo.bLa = aVar.errorMsg;
        pMSAppInfo.aOo = aVar.aOo;
        pMSAppInfo.iconUrl = aVar.iconUrl;
        pMSAppInfo.appName = aVar.name;
        pMSAppInfo.aOr = aVar.aOr;
        pMSAppInfo.aOs = aVar.aOs;
        pMSAppInfo.type = aVar.type;
        pMSAppInfo.bLb = aVar.aOy;
        pMSAppInfo.bLc = aVar.aOz;
        pMSAppInfo.bLd = aVar.category;
        pMSAppInfo.orientation = aVar.orientation;
        pMSAppInfo.aOB = aVar.aOB;
        pMSAppInfo.createTime = aVar.createTime;
        return pMSAppInfo;
    }

    private static long eL(String str) {
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
