package com.baidu.searchbox.ng.ai.apps.database;
/* loaded from: classes2.dex */
public class AiAppsDbInfo {
    public static final int PENDING_APS_ERRCODE_INVALID_VALUE = 0;
    public String appDownloadUrl;
    public String appId;
    public String appKey;
    public String appOpenUrl;
    public String description;
    public int errorCode;
    public String errorDetail;
    public String errorMsg;
    public String icon;
    public String iconUrl;
    public int isHaveZip;
    public long mAppZipSize;
    public int mPendingApsErrcode;
    public String maxSwanVersion;
    public String minSwanVersion;
    public String name;
    public String resumeDate;
    public String serviceCategory;
    public String sign;
    public String subjectInfo;
    public String targetSwanVersion;
    public int type;
    public String version;
    public String versionCode;

    public static boolean hashApsPendingErrcode(AiAppsDbInfo aiAppsDbInfo) {
        return (aiAppsDbInfo == null || aiAppsDbInfo.mPendingApsErrcode == 0) ? false : true;
    }
}
