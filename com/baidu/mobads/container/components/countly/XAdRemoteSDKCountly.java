package com.baidu.mobads.container.components.countly;

import android.content.Context;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.mobads.container.util.CommonUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.container.util.SendLogUtil;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class XAdRemoteSDKCountly {
    public static final String COUNTLY_BASE_URL_POST = "https://mobads-logs.baidu.com/brwhis.log";
    public static final String COUNTLY_TYPE_4_CRASH = "404";
    public static final String TEMP_FOR_FEED_RESPONSE_HTML = "temp_for_feed_response_html";
    public final RemoteXAdLogger mAdLogger = RemoteXAdLogger.getInstance();
    public static XAdRemoteSDKCountly theInstance = new XAdRemoteSDKCountly();
    public static volatile String TEMP_REQUEST_AD_STRING = "";
    public static volatile String TEMP_RESPONSE_AD_STRING = "";
    public static boolean HAS_SEND_ERROR_FOR_FEED_RESPONSE_HTML = false;

    private XAdRemoteAPKDownloadExtraInfo cloneApkDownloadExtraInfo(XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo) {
        XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo2 = new XAdRemoteAPKDownloadExtraInfo(xAdRemoteAPKDownloadExtraInfo.packageName, xAdRemoteAPKDownloadExtraInfo.mTitle);
        xAdRemoteAPKDownloadExtraInfo2.setSingleAdsRelated(xAdRemoteAPKDownloadExtraInfo.getQueryKey(), xAdRemoteAPKDownloadExtraInfo.getAdid(), xAdRemoteAPKDownloadExtraInfo.mUrl, xAdRemoteAPKDownloadExtraInfo.autoOpen, xAdRemoteAPKDownloadExtraInfo.getBuyer());
        xAdRemoteAPKDownloadExtraInfo2.popNotify = xAdRemoteAPKDownloadExtraInfo.popNotify;
        xAdRemoteAPKDownloadExtraInfo2.setLocalRelated(xAdRemoteAPKDownloadExtraInfo.outputFileName, xAdRemoteAPKDownloadExtraInfo.outputFolder);
        xAdRemoteAPKDownloadExtraInfo2.setPlaceRelated(xAdRemoteAPKDownloadExtraInfo.placeId, xAdRemoteAPKDownloadExtraInfo.mProd, xAdRemoteAPKDownloadExtraInfo.mAppsid);
        xAdRemoteAPKDownloadExtraInfo2.notifID = xAdRemoteAPKDownloadExtraInfo.notifID;
        xAdRemoteAPKDownloadExtraInfo2.mobileConfirmed = xAdRemoteAPKDownloadExtraInfo.mobileConfirmed;
        xAdRemoteAPKDownloadExtraInfo2.setClickTime(xAdRemoteAPKDownloadExtraInfo.getClickTime());
        xAdRemoteAPKDownloadExtraInfo2.setAppSize(xAdRemoteAPKDownloadExtraInfo.getAppSize());
        xAdRemoteAPKDownloadExtraInfo2.setTooLarge(xAdRemoteAPKDownloadExtraInfo.isTooLarge());
        xAdRemoteAPKDownloadExtraInfo2.asl = xAdRemoteAPKDownloadExtraInfo.asl;
        xAdRemoteAPKDownloadExtraInfo2.apoPage = xAdRemoteAPKDownloadExtraInfo.apoPage;
        xAdRemoteAPKDownloadExtraInfo2.mAPOOpen = xAdRemoteAPKDownloadExtraInfo.mAPOOpen;
        xAdRemoteAPKDownloadExtraInfo2.copyExtraFrom(xAdRemoteAPKDownloadExtraInfo.mExtras);
        return xAdRemoteAPKDownloadExtraInfo2;
    }

    public static XAdRemoteSDKCountly getInstance() {
        return theInstance;
    }

    private void onAPKAction(Context context, int i2, XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo) {
        if (xAdRemoteAPKDownloadExtraInfo != null) {
            XAdRemoteDownloadMonitorTrackingInfo xAdRemoteDownloadMonitorTrackingInfo = new XAdRemoteDownloadMonitorTrackingInfo(context, cloneApkDownloadExtraInfo(xAdRemoteAPKDownloadExtraInfo));
            xAdRemoteDownloadMonitorTrackingInfo.adid = xAdRemoteAPKDownloadExtraInfo.getAdid();
            SendLogUtil.Builder.create(context).appendType(i2).append("net", CommonUtils.getNetworkType(context)).append(xAdRemoteDownloadMonitorTrackingInfo.toHashMap()).sendWithVd();
        }
    }

    private void onTracking(String str, String str2, HashMap<String, String> hashMap) {
    }

    public void onAPKDownloadComplete(Context context, XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo) {
        onAPKAction(context, 9, xAdRemoteAPKDownloadExtraInfo);
    }

    public void onAPKDownloadError(XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo) {
    }

    public void onAPKInstallComplete(Context context, XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo) {
        onAPKAction(context, 11, xAdRemoteAPKDownloadExtraInfo);
    }

    public void onCrash(String str, String str2, String str3) {
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("ad", str3);
            hashMap.put("stacktrace", str2);
            onTracking(str, COUNTLY_TYPE_4_CRASH, hashMap);
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().e(e2);
        }
    }
}
