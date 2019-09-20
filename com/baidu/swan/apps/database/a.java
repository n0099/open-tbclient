package com.baidu.swan.apps.database;

import android.text.TextUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
/* loaded from: classes2.dex */
public class a {
    public String appId;
    public String appKey;
    public long avA;
    public int avB;
    public int avC;
    public String avD;
    public long avE = 432000;
    public boolean avF;
    public String avq;
    public String avr;
    public String avs;
    public String avt;
    public String avu;
    public String avv;
    public int avw;
    public String avx;
    public String avy;
    public String avz;
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
        return (aVar == null || aVar.avB == 0) ? false : true;
    }

    public boolean Cx() {
        return (System.currentTimeMillis() - this.createTime) / 1000 > this.avE;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.appId);
    }

    public String Cy() {
        return "SwanAppDbInfo{appId='" + this.appId + "', appKey='" + this.appKey + "', errorCode=" + this.errorCode + ", errorDetail='" + this.errorDetail + "', errorMsg='" + this.errorMsg + "', resumeDate='" + this.avq + "', maxSwanVersion='" + this.avr + "', minSwanVersion='" + this.avs + "', name='" + this.name + "', version='" + this.version + "', type=" + this.type + ", isHaveZip=" + this.avw + ", targetSwanVersion='" + this.avz + "', mAppZipSize=" + this.avA + ", mPendingApsErrcode=" + this.avB + ", category=" + this.avC + ", versionCode='" + this.avD + "', maxAge=" + this.avE + ", createTime=" + this.createTime + ", forceFetchMetaInfoFlag=" + this.avF + '}';
    }

    public static PMSAppInfo f(a aVar) {
        if (aVar == null) {
            return null;
        }
        PMSAppInfo pMSAppInfo = new PMSAppInfo();
        pMSAppInfo.appId = aVar.appId;
        pMSAppInfo.appKey = aVar.appKey;
        pMSAppInfo.bte = ee(aVar.sign);
        pMSAppInfo.versionCode = (int) ee(aVar.version);
        pMSAppInfo.versionName = aVar.avD;
        pMSAppInfo.description = aVar.description;
        pMSAppInfo.appStatus = aVar.errorCode;
        pMSAppInfo.btf = aVar.errorDetail;
        pMSAppInfo.btg = aVar.errorMsg;
        pMSAppInfo.avq = aVar.avq;
        pMSAppInfo.iconUrl = aVar.iconUrl;
        pMSAppInfo.appName = aVar.name;
        pMSAppInfo.avt = aVar.avt;
        pMSAppInfo.avu = aVar.avu;
        pMSAppInfo.type = aVar.type;
        pMSAppInfo.bth = aVar.avA;
        pMSAppInfo.bti = aVar.avB;
        pMSAppInfo.btj = aVar.avC;
        pMSAppInfo.orientation = aVar.orientation;
        pMSAppInfo.avE = aVar.avE;
        pMSAppInfo.createTime = aVar.createTime;
        return pMSAppInfo;
    }

    private static long ee(String str) {
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
