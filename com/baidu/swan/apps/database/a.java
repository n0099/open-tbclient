package com.baidu.swan.apps.database;

import android.text.TextUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
/* loaded from: classes2.dex */
public class a {
    public String appId;
    public String appKey;
    public int auA;
    public String auB;
    public long auC = 432000;
    public boolean auD;
    public String aup;
    public String auq;
    public String aur;
    public String aus;
    public String aut;
    public String auu;
    public int auv;
    public String auw;
    public String aux;
    public String auy;
    public long auz;
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
        return (aVar == null || aVar.auA == 0) ? false : true;
    }

    public boolean BL() {
        return (System.currentTimeMillis() - this.createTime) / 1000 > this.auC;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.appId);
    }

    public String toShortString() {
        return "SwanAppDbInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', errorCode=" + this.errorCode + ", errorDetail='" + this.errorDetail + "', errorMsg='" + this.errorMsg + "', resumeDate='" + this.aup + "', maxSwanVersion='" + this.auq + "', minSwanVersion='" + this.aur + "', name='" + this.name + "', version='" + this.version + "', type=" + this.type + ", isHaveZip=" + this.auv + ", targetSwanVersion='" + this.auy + "', mAppZipSize=" + this.auz + ", mPendingApsErrcode=" + this.auA + ", category=" + this.category + ", versionCode='" + this.auB + "', maxAge=" + this.auC + ", createTime=" + this.createTime + ", forceFetchMetaInfoFlag=" + this.auD + '}';
    }

    public static PMSAppInfo f(a aVar) {
        if (aVar == null) {
            return null;
        }
        PMSAppInfo pMSAppInfo = new PMSAppInfo();
        pMSAppInfo.appId = aVar.appId;
        pMSAppInfo.appKey = aVar.appKey;
        pMSAppInfo.brS = dX(aVar.sign);
        pMSAppInfo.versionCode = (int) dX(aVar.version);
        pMSAppInfo.versionName = aVar.auB;
        pMSAppInfo.description = aVar.description;
        pMSAppInfo.appStatus = aVar.errorCode;
        pMSAppInfo.brT = aVar.errorDetail;
        pMSAppInfo.brU = aVar.errorMsg;
        pMSAppInfo.aup = aVar.aup;
        pMSAppInfo.iconUrl = aVar.iconUrl;
        pMSAppInfo.appName = aVar.name;
        pMSAppInfo.aus = aVar.aus;
        pMSAppInfo.aut = aVar.aut;
        pMSAppInfo.type = aVar.type;
        pMSAppInfo.brV = aVar.auz;
        pMSAppInfo.brW = aVar.auA;
        pMSAppInfo.appCategory = aVar.category;
        pMSAppInfo.orientation = aVar.orientation;
        pMSAppInfo.auC = aVar.auC;
        pMSAppInfo.createTime = aVar.createTime;
        return pMSAppInfo;
    }

    private static long dX(String str) {
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
