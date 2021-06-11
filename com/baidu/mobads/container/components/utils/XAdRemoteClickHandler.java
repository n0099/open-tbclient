package com.baidu.mobads.container.components.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobads.container.XAdInstanceInfoExt;
import com.baidu.mobads.container.XAdRemoteCommonUtils;
import com.baidu.mobads.container.XAdSDKRemoteConfig;
import com.baidu.mobads.container.XBaseAdContainer;
import com.baidu.mobads.container.adrequest.AdLandingpageOpen;
import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
import com.baidu.mobads.container.adrequest.XAdContainerContext;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.mobads.container.components.command.XAdRemoteDownloadAPKCommand;
import com.baidu.mobads.container.components.command.XAdRemoteDownloadAdInfo;
import com.baidu.mobads.container.components.controller.InstallReceiver;
import com.baidu.mobads.container.components.controller.XAdInstallController;
import com.baidu.mobads.container.components.net.OAdURLConnection;
import com.baidu.mobads.container.components.statemachine.AdStateCode;
import com.baidu.mobads.container.components.statemachine.StateMachine;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.landingpage.LpCloseController;
import com.baidu.mobads.container.util.AdDownloadApkUtils;
import com.baidu.mobads.container.util.AppUtils;
import com.baidu.mobads.container.util.EncryptUtils;
import com.baidu.mobads.container.util.OpenAppUtils;
import com.baidu.mobads.container.util.PackageUtils;
import com.baidu.mobads.container.util.RemoteCommonUtils;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.mobads.container.util.SendLogUtil;
import com.baidu.mobads.container.util.XAdRemoteEvent;
import com.baidu.mobads.container.util.XAdRemoteEventDispatcher;
import com.baidu.mobads.container.widget.ConfirmDialog;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class XAdRemoteClickHandler {
    public static final int ACT_TYPE_APO = 512;
    public static final int ACT_TYPE_DOWNLOAD = 2;
    public static final int ACT_TYPE_LANDING_PAGE = 1;
    public static final String BUYER_4_NATIVE = "10";
    public static final int CHECK_APO_APP_COUNT = 15;
    public static final String LP_STYLE_FLAG_KEY = "lpShoubaiStyle";
    public static final String LP_STYLE_VIDEO = "video_and_web";
    public static final String PRODUCT_TYPE_CPU = "cpu";
    public static final String PRODUCT_TYPE_FEED = "feed";
    public static final String PRODUCT_TYPE_RVIDEO = "rvideo";
    public static final String PRODUCT_TYPE_SPLASH = "rsplash";
    public static final String TAG = "XAdRemoteClickHandler";
    public static final int WAIT_APO_APP_START_TIME = 2;
    public XAdRemoteEventDispatcher mDispatcher;
    public IOAdEventListener mDlStatusListener;
    public int numOfCheckAPOAppIsAtFront;

    /* loaded from: classes2.dex */
    public class MarketDownloadBackupTask extends BaseTask {
        public final int countDown = 5000;
        public int currentCount = 0;
        public boolean isBackground = false;
        public String mAdPlaceId;
        public String mAppPkg;
        public String mAppsid;
        public Context mContext;
        public IXAdInstanceInfo mInstanceInfo;
        public String mPk;
        public String mProd;

        public MarketDownloadBackupTask(XAdContainerContext xAdContainerContext, IXAdInstanceInfo iXAdInstanceInfo) {
            Context appContext = xAdContainerContext.getAppContext();
            this.mContext = appContext;
            this.mAppPkg = appContext.getPackageName();
            this.mInstanceInfo = iXAdInstanceInfo;
            this.mPk = iXAdInstanceInfo.getAppPackageName();
            this.mProd = xAdContainerContext.getAdProd();
            this.mAdPlaceId = xAdContainerContext.getAdPlacementId();
            this.mAppsid = xAdContainerContext.getAppsid();
        }

        private void stop() {
            cancel();
            this.isBackground = false;
            this.currentCount = 0;
        }

        @Override // com.baidu.mobads.container.executor.BaseTask
        public Object doInBackground() {
            this.currentCount += 500;
            if (!AppUtils.isForeground(this.mContext, this.mAppPkg)) {
                this.isBackground = true;
            }
            if (this.currentCount >= 5000) {
                stop();
                return null;
            } else if (AppUtils.isForeground(this.mContext, this.mAppPkg) && this.isBackground) {
                stop();
                try {
                    SendLogUtil.Builder append = SendLogUtil.Builder.create(this.mContext).appendType(SDKLogTypeConstants.TYPE_ASL_DELAY_DOWNLOAD).append("pk", this.mPk).appendAdInfo(this.mInstanceInfo).appendProdType(this.mProd).appendAppSid(this.mAppsid).append("msg", "asl_delay_download").append("canopen", true);
                    if (!TextUtils.isEmpty(this.mProd)) {
                        append.appendProdType(this.mProd);
                    }
                    if (!TextUtils.isEmpty(this.mAdPlaceId)) {
                        append.appendApId(this.mAdPlaceId);
                    }
                    append.send();
                } catch (Exception unused) {
                }
                if (AdDownloadApkUtils.isInstalled(this.mContext, this.mPk)) {
                    return null;
                }
                XAdRemoteClickHandler.this.dealDownloadApk(this.mContext, this.mInstanceInfo, this.mProd, this.mAppsid);
                return null;
            } else {
                return null;
            }
        }
    }

    public XAdRemoteClickHandler() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealDownloadApk(Context context, IXAdInstanceInfo iXAdInstanceInfo, String str, String str2) {
        if (context == null || iXAdInstanceInfo == null) {
            return;
        }
        XAdRemoteDownloadAdInfo createFromInstanceInfo = XAdRemoteDownloadAdInfo.createFromInstanceInfo(iXAdInstanceInfo);
        createFromInstanceInfo.mProd = str;
        createFromInstanceInfo.mAppsid = str2;
        createFromInstanceInfo.mDlType = "ac_" + str;
        createFromInstanceInfo.addExtraParam("pkgmd5", EncryptUtils.getMD5(createFromInstanceInfo.getOriginClickUrl()));
        createFromInstanceInfo.addExtraParam("uniqueId", iXAdInstanceInfo.getUniqueId());
        RemoteCommonUtils.getInstance().sendDownloadApkLog(context, PayBeanFactory.BEAN_ID_GET_WALLET_INTERFACE, PrefetchEvent.STATE_CLICK, createFromInstanceInfo);
        new XAdRemoteDownloadAPKCommand(context.getApplicationContext(), createFromInstanceInfo, this.mDlStatusListener).execute();
    }

    private void handleClick4DownloadApk(final XBaseAdContainer xBaseAdContainer, final IXAdInstanceInfo iXAdInstanceInfo, final HashMap<String, Object> hashMap) {
        String appStoreLink;
        XAdContainerContext adContainerContext = xBaseAdContainer.getAdContainerContext();
        final Context appContext = xBaseAdContainer.getAdContainerContext().getAppContext();
        final String adProd = adContainerContext.getAdProd();
        final String appsid = adContainerContext.getAppsid();
        try {
            String appPackageName = iXAdInstanceInfo.getAppPackageName();
            boolean isInstalled = AdDownloadApkUtils.isInstalled(appContext, appPackageName);
            Boolean bool = Boolean.FALSE;
            if (isInstalled) {
                String appOpenStrs = iXAdInstanceInfo.getAppOpenStrs();
                JSONObject jSONObject = !TextUtils.isEmpty(appOpenStrs) ? new JSONObject(appOpenStrs) : null;
                appStoreLink = jSONObject != null ? jSONObject.optString("page") : null;
            } else {
                appStoreLink = iXAdInstanceInfo.getAppStoreLink();
                bool = Boolean.TRUE;
            }
            if (!TextUtils.isEmpty(appStoreLink)) {
                Boolean valueOf = Boolean.valueOf(PackageUtils.isAPOOpenAvailable(appContext, appStoreLink));
                if (bool.booleanValue()) {
                    try {
                        SendLogUtil.Builder append = SendLogUtil.Builder.create(appContext).appendType(SDKLogTypeConstants.TYPE_ASL_APO).appendAdInfo(iXAdInstanceInfo).append(XAdRemoteAPKDownloadExtraInfo.APP_STORE_LINK, appStoreLink).append("pk", iXAdInstanceInfo.getAppPackageName()).append("msg", "open_appstore_link").append("canopen", valueOf.booleanValue());
                        append.appendApId(adContainerContext.getAdPlacementId());
                        append.appendProdType(adContainerContext.getAdProd());
                        append.appendAppSid(adContainerContext.getAppsid());
                        append.send();
                    } catch (Exception unused) {
                    }
                }
                if (valueOf.booleanValue()) {
                    OpenAppUtils.browserOutside(appContext, appStoreLink);
                    if (bool.booleanValue()) {
                        String title = iXAdInstanceInfo.getTitle();
                        if (TextUtils.isEmpty(title)) {
                            title = iXAdInstanceInfo.getAppName();
                        }
                        XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo = new XAdRemoteAPKDownloadExtraInfo(appPackageName, title);
                        xAdRemoteAPKDownloadExtraInfo.mAppName = iXAdInstanceInfo.getAppName();
                        xAdRemoteAPKDownloadExtraInfo.popNotify = iXAdInstanceInfo.isPopNotif();
                        xAdRemoteAPKDownloadExtraInfo.asl = iXAdInstanceInfo.getAppStoreLink();
                        try {
                            String appOpenStrs2 = iXAdInstanceInfo.getAppOpenStrs();
                            JSONObject jSONObject2 = !TextUtils.isEmpty(appOpenStrs2) ? new JSONObject(appOpenStrs2) : null;
                            if (jSONObject2 != null) {
                                xAdRemoteAPKDownloadExtraInfo.apoPage = jSONObject2.optString("page");
                            }
                        } catch (Exception unused2) {
                        }
                        try {
                            xAdRemoteAPKDownloadExtraInfo.addExtra("act", String.valueOf(iXAdInstanceInfo.getActionType()));
                        } catch (Exception unused3) {
                        }
                        registerReceiver(appContext, xAdRemoteAPKDownloadExtraInfo, appPackageName);
                    } else {
                        try {
                            new OAdURLConnection(1, iXAdInstanceInfo.getClickThroughUrl()).asynLoad();
                        } catch (Throwable unused4) {
                        }
                    }
                    prevHandleDownloadApk(xBaseAdContainer, iXAdInstanceInfo);
                    return;
                }
            }
            if (hashMap != null && hashMap.containsKey(XBaseAdContainer.USE_DIALOG_FRAME)) {
                Boolean bool2 = (Boolean) hashMap.get(XBaseAdContainer.USE_DIALOG_FRAME);
                if (bool2 != null && bool2.booleanValue() && !AdDownloadApkUtils.isInstalled(xBaseAdContainer.getAdContainerContext().getAppContext(), iXAdInstanceInfo.getAppPackageName())) {
                    ConfirmDialog.loadWith(xBaseAdContainer.getAdContainerContext().getActivity(), iXAdInstanceInfo).setHideNavigation(true).setConfirmListener(new ConfirmDialog.OnConfirmListener() { // from class: com.baidu.mobads.container.components.utils.XAdRemoteClickHandler.1
                        @Override // com.baidu.mobads.container.widget.ConfirmDialog.OnConfirmListener
                        public void onAdClick() {
                            XAdRemoteClickHandler.this.prevHandleDownloadApk(xBaseAdContainer, iXAdInstanceInfo);
                            XAdRemoteClickHandler.this.dealDownloadApk(appContext, iXAdInstanceInfo, adProd, appsid);
                            xBaseAdContainer.onAdClick(iXAdInstanceInfo, (View) hashMap.get("adView"));
                        }

                        @Override // com.baidu.mobads.container.widget.ConfirmDialog.OnConfirmListener
                        public void onDialogClose() {
                            xBaseAdContainer.handleResume(iXAdInstanceInfo);
                        }

                        @Override // com.baidu.mobads.container.widget.ConfirmDialog.OnConfirmListener
                        public void onDialogShow() {
                            xBaseAdContainer.handlePause(iXAdInstanceInfo);
                        }

                        @Override // com.baidu.mobads.container.widget.ConfirmDialog.OnConfirmListener
                        public void onPermissionClose() {
                            xBaseAdContainer.onPermissionClose(iXAdInstanceInfo);
                        }

                        @Override // com.baidu.mobads.container.widget.ConfirmDialog.OnConfirmListener
                        public void onPermissionShow() {
                            xBaseAdContainer.onPermissionShow(iXAdInstanceInfo);
                        }

                        @Override // com.baidu.mobads.container.widget.ConfirmDialog.OnConfirmListener
                        public void onPrivacyClick() {
                            xBaseAdContainer.onPrivacyClick(iXAdInstanceInfo);
                        }

                        @Override // com.baidu.mobads.container.widget.ConfirmDialog.OnConfirmListener
                        public void onPrivacyClose() {
                            xBaseAdContainer.onPrivacyLpClose(iXAdInstanceInfo);
                        }
                    }).show();
                    return;
                }
                prevHandleDownloadApk(xBaseAdContainer, iXAdInstanceInfo);
                dealDownloadApk(appContext, iXAdInstanceInfo, adProd, appsid);
                xBaseAdContainer.onAdClick(iXAdInstanceInfo, (View) hashMap.get("adView"));
                return;
            }
            prevHandleDownloadApk(xBaseAdContainer, iXAdInstanceInfo);
            dealDownloadApk(appContext, iXAdInstanceInfo, adProd, appsid);
        } catch (Throwable unused5) {
        }
    }

    private boolean handleFeedVideo(XAdContainerContext xAdContainerContext, HashMap<String, Object> hashMap, String str, IXAdInstanceInfo iXAdInstanceInfo) {
        if (xAdContainerContext == null || hashMap == null || !hashMap.containsKey("lpShoubaiStyle") || !hashMap.get("lpShoubaiStyle").equals("video_and_web")) {
            return false;
        }
        AdLandingpageOpen adLandingpageOpen = new AdLandingpageOpen(xAdContainerContext, str, (XAdInstanceInfoExt) iXAdInstanceInfo, iXAdInstanceInfo.getWebUrl());
        adLandingpageOpen.lpStyle = (String) hashMap.get("lpShoubaiStyle");
        adLandingpageOpen.lpMurl = (String) hashMap.get(XAdRemoteCommonUtils.LP_MURL_KEY);
        adLandingpageOpen.execute();
        return true;
    }

    private boolean isFeedVideo(HashMap<String, Object> hashMap) {
        return hashMap != null && hashMap.containsKey("lpShoubaiStyle") && hashMap.get("lpShoubaiStyle").equals("video_and_web");
    }

    private boolean isProdType4Remote(XBaseAdContainer xBaseAdContainer) {
        return true;
    }

    private boolean isRemoteApkDownloader(int i2, XBaseAdContainer xBaseAdContainer, HashMap<String, Object> hashMap) {
        return i2 == 2 && isProdType4Remote(xBaseAdContainer) && !isFeedVideo(hashMap);
    }

    private void monitorAppInstall(XAdContainerContext xAdContainerContext, IXAdInstanceInfo iXAdInstanceInfo) {
        try {
            XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo = new XAdRemoteAPKDownloadExtraInfo(iXAdInstanceInfo.getAppPackageName(), iXAdInstanceInfo.getTitle());
            xAdRemoteAPKDownloadExtraInfo.mAdid = iXAdInstanceInfo.getAdId();
            xAdRemoteAPKDownloadExtraInfo.queryKey = iXAdInstanceInfo.getQueryKey();
            xAdRemoteAPKDownloadExtraInfo.setTooLarge(iXAdInstanceInfo.isTooLarge());
            xAdRemoteAPKDownloadExtraInfo.setAppSize(iXAdInstanceInfo.getAppSize());
            xAdRemoteAPKDownloadExtraInfo.setClickTime(System.currentTimeMillis());
            xAdRemoteAPKDownloadExtraInfo.mProd = xAdContainerContext.getAdProd();
            xAdRemoteAPKDownloadExtraInfo.mAppsid = xAdContainerContext.getAppsid();
            if (iXAdInstanceInfo.getOriginJsonObject() != null) {
                xAdRemoteAPKDownloadExtraInfo.mBuyer = iXAdInstanceInfo.getOriginJsonObject().optString(XAdRemoteAPKDownloadExtraInfo.BUYER);
            }
            XAdInstallController.getInstance().registerInstallReceiver(xAdContainerContext.getAppContext(), xAdRemoteAPKDownloadExtraInfo);
        } catch (Throwable unused) {
        }
    }

    private boolean openExternalApp(XBaseAdContainer xBaseAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap<String, Object> hashMap) {
        JSONObject jSONObject;
        String clickThroughUrl = iXAdInstanceInfo.getClickThroughUrl();
        String appPackageName = iXAdInstanceInfo.getAppPackageName();
        try {
            try {
                jSONObject = new JSONObject(clickThroughUrl);
            } catch (Exception unused) {
                jSONObject = new JSONObject(iXAdInstanceInfo.getAppOpenStrs());
                new OAdURLConnection(1, clickThroughUrl).asynLoad();
            }
            JSONObject jSONObject2 = jSONObject;
            String optString = jSONObject2.optString("page", "");
            Context appContext = xBaseAdContainer.getAdContainerContext().getAppContext();
            if (PackageUtils.isAPOOpenAvailable(xBaseAdContainer.getAdContainerContext(), optString, iXAdInstanceInfo, SDKLogTypeConstants.TYPE_APO_CLICK, jSONObject2.optInt("fb_act", 0), jSONObject2.optInt("version", 0))) {
                StateMachine.event(iXAdInstanceInfo.getUniqueId(), AdStateCode.EVENT_APO_OPEN);
                OpenAppUtils.browserOutside(appContext, optString);
                if (optString.contains("market") && !TextUtils.isEmpty(appPackageName)) {
                    monitorAppInstall(xBaseAdContainer.getAdContainerContext(), iXAdInstanceInfo);
                }
                StateMachine.finish(iXAdInstanceInfo.getUniqueId());
                return true;
            }
            int optInt = jSONObject2.optInt("fb_act", 0);
            StateMachine.event(iXAdInstanceInfo.getUniqueId(), AdStateCode.EVENT_APO_FB);
            XAdInstanceInfoExt xAdInstanceInfoExt = new XAdInstanceInfoExt(iXAdInstanceInfo);
            StateMachine.addIdMapper(xAdInstanceInfoExt.getUniqueId(), iXAdInstanceInfo.getUniqueId());
            if (optInt == 1) {
                xAdInstanceInfoExt.setActionType(1);
                xAdInstanceInfoExt.setClickThroughUrl(jSONObject2.optString("fallback", ""));
                xAdInstanceInfoExt.setTitle(iXAdInstanceInfo.getTitle());
                xAdInstanceInfoExt.setInapp(true);
                onAdClicked(xBaseAdContainer, xAdInstanceInfoExt, bool, hashMap);
            } else if (optInt == 2) {
                String appStoreLink = iXAdInstanceInfo.getAppStoreLink();
                Boolean bool2 = Boolean.FALSE;
                if (!TextUtils.isEmpty(appStoreLink)) {
                    bool2 = Boolean.valueOf(PackageUtils.isAPOOpenAvailable(appContext, appStoreLink));
                    try {
                        SendLogUtil.Builder append = SendLogUtil.Builder.create(appContext).appendType(SDKLogTypeConstants.TYPE_ASL_APO).appendAdInfo(iXAdInstanceInfo).append(XAdRemoteAPKDownloadExtraInfo.APP_STORE_LINK, appStoreLink).append("pk", appPackageName).append("msg", "open_appstore_link").append("canopen", bool2.booleanValue());
                        append.appendApId(xBaseAdContainer.getAdContainerContext().getAdPlacementId());
                        append.appendProdType(xBaseAdContainer.getAdContainerContext().getAdProd());
                        append.appendAppSid(xBaseAdContainer.getAdContainerContext().getAppsid());
                        append.send();
                    } catch (Exception unused2) {
                    }
                }
                if (bool2.booleanValue()) {
                    OpenAppUtils.browserOutside(appContext, appStoreLink);
                    String title = xAdInstanceInfoExt.getTitle();
                    if (TextUtils.isEmpty(title)) {
                        title = xAdInstanceInfoExt.getAppName();
                    }
                    XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo = new XAdRemoteAPKDownloadExtraInfo(appPackageName, title);
                    xAdRemoteAPKDownloadExtraInfo.mAppName = xAdInstanceInfoExt.getAppName();
                    xAdRemoteAPKDownloadExtraInfo.popNotify = xAdInstanceInfoExt.isPopNotif();
                    xAdRemoteAPKDownloadExtraInfo.asl = xAdInstanceInfoExt.getAppStoreLink();
                    try {
                        String appOpenStrs = xAdInstanceInfoExt.getAppOpenStrs();
                        JSONObject jSONObject3 = TextUtils.isEmpty(appOpenStrs) ? null : new JSONObject(appOpenStrs);
                        if (jSONObject3 != null) {
                            xAdRemoteAPKDownloadExtraInfo.apoPage = jSONObject3.optString("page");
                        }
                    } catch (Exception unused3) {
                    }
                    try {
                        xAdRemoteAPKDownloadExtraInfo.addExtra("act", String.valueOf(xAdInstanceInfoExt.getActionType()));
                    } catch (Exception unused4) {
                    }
                    registerReceiver(appContext, xAdRemoteAPKDownloadExtraInfo, appPackageName);
                    TaskScheduler.getInstance().submitAtFixedRate(new MarketDownloadBackupTask(xBaseAdContainer.getAdContainerContext(), xAdInstanceInfoExt), 0L, 500L, TimeUnit.MILLISECONDS);
                } else {
                    xAdInstanceInfoExt.setActionType(2);
                    xAdInstanceInfoExt.setClickThroughUrl(jSONObject2.optString("fallback", ""));
                    xAdInstanceInfoExt.setTitle(iXAdInstanceInfo.getTitle());
                    xAdInstanceInfoExt.setQueryKey(iXAdInstanceInfo.getQueryKey());
                    xAdInstanceInfoExt.setInapp(true);
                    xAdInstanceInfoExt.setAPOOpen(true);
                    xAdInstanceInfoExt.setPage(optString);
                    xAdInstanceInfoExt.setAppPackageName(iXAdInstanceInfo.getAppPackageName());
                    onAdClicked(xBaseAdContainer, xAdInstanceInfoExt, bool, hashMap);
                }
            }
            return false;
        } catch (Exception unused5) {
            return false;
        }
    }

    private void pingThirdClickUrls(IXAdInstanceInfo iXAdInstanceInfo) {
        ArrayList arrayList = new ArrayList();
        List<String> thirdClickTrackingUrls = iXAdInstanceInfo.getThirdClickTrackingUrls();
        for (int i2 = 0; i2 < thirdClickTrackingUrls.size(); i2++) {
            arrayList.add(thirdClickTrackingUrls.get(i2).replaceAll(XAdSDKRemoteConfig.REGULAR_MATCH_PROGRESS, String.valueOf(0)));
        }
        Set<String> hashSet = new HashSet<>();
        hashSet.addAll(arrayList);
        pingURLs(hashSet);
    }

    private void pingURLs(Set<String> set) {
        for (String str : set) {
            new OAdURLConnection(1, str).asynLoad();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prevHandleDownloadApk(XBaseAdContainer xBaseAdContainer, IXAdInstanceInfo iXAdInstanceInfo) {
        StateMachine.event(iXAdInstanceInfo.getUniqueId(), AdStateCode.EVENT_CLICK_DL);
        pingThirdClickUrls(iXAdInstanceInfo);
        this.mDispatcher.dispatchEvent(new XAdRemoteEvent("AdUserClick", iXAdInstanceInfo.getUniqueId()));
    }

    private void registerLpCloseReceiver(Context context) {
        if (this.mDispatcher == null) {
            return;
        }
        LpCloseController.getInstance(context).startListener();
        LpCloseController.getInstance(context).addEventListener("AdLpClosed", this.mDispatcher.getEventType("AdLpClosed"));
    }

    private void registerReceiver(Context context, XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo, final String str) {
        XAdInstallController xAdInstallController = XAdInstallController.getInstance();
        xAdInstallController.registerInstallReceiver(context, xAdRemoteAPKDownloadExtraInfo);
        xAdInstallController.setInstallListener(str, new InstallReceiver.InstallListener() { // from class: com.baidu.mobads.container.components.utils.XAdRemoteClickHandler.2
            @Override // com.baidu.mobads.container.components.controller.InstallReceiver.InstallListener
            public void onPackageInstalled(Context context2, Intent intent) {
                if (XAdRemoteClickHandler.this.mDlStatusListener != null) {
                    XAdRemoteClickHandler.this.mDlStatusListener.run(new XAdRemoteEvent("AdStatusChange", str));
                }
            }
        });
    }

    public void onAdClicked(XBaseAdContainer xBaseAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap<String, Object> hashMap) {
        if (xBaseAdContainer == null || xBaseAdContainer.getAdContainerContext() == null) {
            return;
        }
        XAdRemoteEventDispatcher eventDispatcher = xBaseAdContainer.getAdContainerContext().getEventDispatcher();
        this.mDispatcher = eventDispatcher;
        if (eventDispatcher == null) {
            return;
        }
        if (512 == iXAdInstanceInfo.getActionType()) {
            StateMachine.event(iXAdInstanceInfo.getUniqueId(), AdStateCode.EVENT_CLICK_APO);
            if (openExternalApp(xBaseAdContainer, iXAdInstanceInfo, bool, hashMap)) {
                pingThirdClickUrls(iXAdInstanceInfo);
                this.mDispatcher.dispatchEvent(new XAdRemoteEvent("AdUserClick", iXAdInstanceInfo.getUniqueId()));
            }
        } else if (isRemoteApkDownloader(iXAdInstanceInfo.getActionType(), xBaseAdContainer, hashMap)) {
            handleClick4DownloadApk(xBaseAdContainer, iXAdInstanceInfo, hashMap);
        } else {
            if (1 == iXAdInstanceInfo.getActionType()) {
                registerLpCloseReceiver(xBaseAdContainer.getAdContainerContext().getAppContext());
                StateMachine.event(iXAdInstanceInfo.getUniqueId(), AdStateCode.EVENT_CLICK_LP);
                try {
                    SendLogUtil.Builder appendAdInfo = SendLogUtil.Builder.create(xBaseAdContainer.getAdContainerContext().getAppContext()).appendType(1047).appendAdInfo(iXAdInstanceInfo);
                    appendAdInfo.appendApId(xBaseAdContainer.getAdContainerContext().getAdPlacementId());
                    appendAdInfo.appendProdType(xBaseAdContainer.getAdContainerContext().getAdProd());
                    appendAdInfo.appendAppSid(xBaseAdContainer.getAdContainerContext().getAppsid());
                    appendAdInfo.send();
                } catch (Throwable unused) {
                }
            }
            String adProd = xBaseAdContainer.getAdContainerContext().getAdProd();
            if (iXAdInstanceInfo.isInapp()) {
                if (!handleFeedVideo(xBaseAdContainer.getAdContainerContext(), hashMap, adProd, iXAdInstanceInfo)) {
                    AdLandingpageOpen adLandingpageOpen = new AdLandingpageOpen(xBaseAdContainer.getAdContainerContext(), adProd, (XAdInstanceInfoExt) iXAdInstanceInfo, iXAdInstanceInfo.getClickThroughUrl());
                    if (hashMap != null && hashMap.containsKey("lpShoubaiStyle")) {
                        adLandingpageOpen.lpStyle = (String) hashMap.get("lpShoubaiStyle");
                    }
                    adLandingpageOpen.execute();
                }
            } else {
                OpenAppUtils.browserOutside(xBaseAdContainer.getAdContainerContext().getAppContext(), iXAdInstanceInfo.getClickThroughUrl());
            }
            pingThirdClickUrls(iXAdInstanceInfo);
            XAdRemoteEvent xAdRemoteEvent = new XAdRemoteEvent("AdUserClick", iXAdInstanceInfo.getUniqueId());
            xAdRemoteEvent.setData(iXAdInstanceInfo);
            xAdRemoteEvent.getData().put("isClickAd", iXAdInstanceInfo.isValid());
            this.mDispatcher.dispatchEvent(xAdRemoteEvent);
        }
    }

    public XAdRemoteClickHandler(IOAdEventListener iOAdEventListener) {
        this.numOfCheckAPOAppIsAtFront = 0;
        this.mDlStatusListener = iOAdEventListener;
    }
}
