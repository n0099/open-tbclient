package com.baidu.swan.apps.database;

import android.text.TextUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
/* loaded from: classes2.dex */
public class a {
    public String aOG;
    public String aOH;
    public String aOI;
    public String aOJ;
    public String aOK;
    public String aOL;
    public int aOM;
    public String aON;
    public String aOO;
    public String aOP;
    public long aOQ;
    public int aOR;
    public String aOS;
    public long aOT = 432000;
    public boolean aOU;
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
        return (aVar == null || aVar.aOR == 0) ? false : true;
    }

    public boolean Hr() {
        return (System.currentTimeMillis() - this.createTime) / 1000 > this.aOT;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.appId);
    }

    public String Hs() {
        return "SwanAppDbInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', errorCode=" + this.errorCode + ", errorDetail='" + this.errorDetail + "', errorMsg='" + this.errorMsg + "', resumeDate='" + this.aOG + "', maxSwanVersion='" + this.aOH + "', minSwanVersion='" + this.aOI + "', name='" + this.name + "', version='" + this.version + "', type=" + this.type + ", isHaveZip=" + this.aOM + ", targetSwanVersion='" + this.aOP + "', mAppZipSize=" + this.aOQ + ", mPendingApsErrcode=" + this.aOR + ", category=" + this.category + ", versionCode='" + this.aOS + "', maxAge=" + this.aOT + ", createTime=" + this.createTime + ", forceFetchMetaInfoFlag=" + this.aOU + '}';
    }

    public static PMSAppInfo f(a aVar) {
        if (aVar == null) {
            return null;
        }
        PMSAppInfo pMSAppInfo = new PMSAppInfo();
        pMSAppInfo.appId = aVar.appId;
        pMSAppInfo.appKey = aVar.appKey;
        pMSAppInfo.bLP = eL(aVar.sign);
        pMSAppInfo.versionCode = (int) eL(aVar.version);
        pMSAppInfo.versionName = aVar.aOS;
        pMSAppInfo.description = aVar.description;
        pMSAppInfo.appStatus = aVar.errorCode;
        pMSAppInfo.bLQ = aVar.errorDetail;
        pMSAppInfo.bLR = aVar.errorMsg;
        pMSAppInfo.aOG = aVar.aOG;
        pMSAppInfo.iconUrl = aVar.iconUrl;
        pMSAppInfo.appName = aVar.name;
        pMSAppInfo.aOJ = aVar.aOJ;
        pMSAppInfo.aOK = aVar.aOK;
        pMSAppInfo.type = aVar.type;
        pMSAppInfo.bLS = aVar.aOQ;
        pMSAppInfo.bLT = aVar.aOR;
        pMSAppInfo.bLU = aVar.category;
        pMSAppInfo.orientation = aVar.orientation;
        pMSAppInfo.aOT = aVar.aOT;
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
