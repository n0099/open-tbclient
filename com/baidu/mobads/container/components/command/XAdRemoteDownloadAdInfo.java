package com.baidu.mobads.container.components.command;

import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class XAdRemoteDownloadAdInfo {
    public String appOpenStrs;
    public boolean isTooLarge;
    public int mAct;
    public String mAdId;
    public String mApId;
    public String mAppName;
    public String mAppPackageName;
    public long mAppSize;
    public String mAppsid;
    public String mAsl;
    public String mBuyer;
    public String mClickThroughUrl;
    public String mDlType;
    public String mOriginalUrl;
    public String mPage;
    public String mProd;
    public String mQueryKey;
    public String mTitle;
    public JSONObject originJsonObject;
    public int mDownType = 1;
    public boolean mAutoOpen = true;
    public boolean mIsPopNotif = true;
    public boolean mActionOnlyWifi = true;
    public boolean mAPOOpen = false;
    public HashMap<String, String> mExtras = new HashMap<>();

    public static XAdRemoteDownloadAdInfo createAdInfoFromJson(JSONObject jSONObject) {
        XAdRemoteDownloadAdInfo xAdRemoteDownloadAdInfo = new XAdRemoteDownloadAdInfo();
        xAdRemoteDownloadAdInfo.mApId = "";
        xAdRemoteDownloadAdInfo.mProd = "";
        if (jSONObject != null) {
            xAdRemoteDownloadAdInfo.mClickThroughUrl = jSONObject.optString("curl", "");
            xAdRemoteDownloadAdInfo.mOriginalUrl = jSONObject.optString("ori_curl", "");
            xAdRemoteDownloadAdInfo.mAdId = jSONObject.optString("id", "-1");
            xAdRemoteDownloadAdInfo.mAct = jSONObject.optInt("act");
            xAdRemoteDownloadAdInfo.mTitle = jSONObject.optString("tit", "");
            xAdRemoteDownloadAdInfo.mAppPackageName = jSONObject.optString("pk", "");
            xAdRemoteDownloadAdInfo.mAppName = jSONObject.optString("appname", "");
            xAdRemoteDownloadAdInfo.mQueryKey = jSONObject.optString(XAdRemoteAPKDownloadExtraInfo.QK, "");
            xAdRemoteDownloadAdInfo.mActionOnlyWifi = true;
            xAdRemoteDownloadAdInfo.mAppSize = jSONObject.optLong("sz", 0L);
            xAdRemoteDownloadAdInfo.isTooLarge = false;
            xAdRemoteDownloadAdInfo.originJsonObject = jSONObject;
            xAdRemoteDownloadAdInfo.mAsl = jSONObject.optString("app_store_link", "");
            xAdRemoteDownloadAdInfo.appOpenStrs = jSONObject.optString("apo", "");
            try {
                xAdRemoteDownloadAdInfo.mPage = new JSONObject(xAdRemoteDownloadAdInfo.appOpenStrs).optString("page", "");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return xAdRemoteDownloadAdInfo;
    }

    public static XAdRemoteDownloadAdInfo createFromInstanceInfo(IXAdInstanceInfo iXAdInstanceInfo) {
        XAdRemoteDownloadAdInfo xAdRemoteDownloadAdInfo = new XAdRemoteDownloadAdInfo();
        xAdRemoteDownloadAdInfo.mApId = "";
        xAdRemoteDownloadAdInfo.mProd = "";
        if (iXAdInstanceInfo != null) {
            xAdRemoteDownloadAdInfo.mClickThroughUrl = iXAdInstanceInfo.getClickThroughUrl();
            xAdRemoteDownloadAdInfo.mOriginalUrl = iXAdInstanceInfo.getOriginClickUrl();
            xAdRemoteDownloadAdInfo.mAdId = iXAdInstanceInfo.getAdId();
            xAdRemoteDownloadAdInfo.mAct = iXAdInstanceInfo.getActionType();
            xAdRemoteDownloadAdInfo.mBuyer = iXAdInstanceInfo.getBuyer();
            xAdRemoteDownloadAdInfo.mTitle = iXAdInstanceInfo.getTitle();
            xAdRemoteDownloadAdInfo.mAppPackageName = iXAdInstanceInfo.getAppPackageName();
            xAdRemoteDownloadAdInfo.mAppName = iXAdInstanceInfo.getAppName();
            xAdRemoteDownloadAdInfo.mQueryKey = iXAdInstanceInfo.getQueryKey();
            xAdRemoteDownloadAdInfo.mAutoOpen = iXAdInstanceInfo.isAutoOpen();
            xAdRemoteDownloadAdInfo.mIsPopNotif = iXAdInstanceInfo.isPopNotif();
            xAdRemoteDownloadAdInfo.mActionOnlyWifi = iXAdInstanceInfo.isActionOnlyWifi();
            xAdRemoteDownloadAdInfo.mAppSize = iXAdInstanceInfo.getAppSize();
            xAdRemoteDownloadAdInfo.isTooLarge = iXAdInstanceInfo.isTooLarge();
            xAdRemoteDownloadAdInfo.mAPOOpen = iXAdInstanceInfo.getAPOOpen();
            xAdRemoteDownloadAdInfo.mPage = iXAdInstanceInfo.getPage();
            xAdRemoteDownloadAdInfo.mAsl = iXAdInstanceInfo.getAppStoreLink();
            xAdRemoteDownloadAdInfo.originJsonObject = iXAdInstanceInfo.getOriginJsonObject();
            xAdRemoteDownloadAdInfo.appOpenStrs = iXAdInstanceInfo.getAppOpenStrs();
        }
        return xAdRemoteDownloadAdInfo;
    }

    public void addExtraParam(String str, String str2) {
        this.mExtras.put(str, str2);
    }

    public boolean getAPOOpen() {
        return this.mAPOOpen;
    }

    public int getActType() {
        return this.mAct;
    }

    public String getAdId() {
        return this.mAdId;
    }

    public String getApId() {
        return this.mApId;
    }

    public String getAppName() {
        return this.mAppName;
    }

    public String getAppOpenStrs() {
        return this.appOpenStrs;
    }

    public String getAppPackageName() {
        return this.mAppPackageName;
    }

    public long getAppSize() {
        return this.mAppSize;
    }

    public String getAppStoreLink() {
        return this.mAsl;
    }

    public String getAppsid() {
        return this.mAppsid;
    }

    public String getClickThroughUrl() {
        return this.mClickThroughUrl;
    }

    public HashMap<String, String> getExtras() {
        return this.mExtras;
    }

    public String getOriginClickUrl() {
        return this.mOriginalUrl;
    }

    public JSONObject getOriginJsonObject() {
        return this.originJsonObject;
    }

    public String getPage() {
        return this.mPage;
    }

    public String getProd() {
        return this.mProd;
    }

    public String getQueryKey() {
        return this.mQueryKey;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public boolean isActionOnlyWifi() {
        return this.mActionOnlyWifi;
    }

    public boolean isAutoOpen() {
        return this.mAutoOpen;
    }

    public boolean isPopNotif() {
        return this.mIsPopNotif;
    }

    public boolean isTooLarge() {
        return this.isTooLarge;
    }
}
