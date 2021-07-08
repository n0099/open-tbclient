package com.baidu.mobads.container.components.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;
    public XAdRemoteEventDispatcher mDispatcher;
    public IOAdEventListener mDlStatusListener;
    public int numOfCheckAPOAppIsAtFront;

    /* loaded from: classes2.dex */
    public class MarketDownloadBackupTask extends BaseTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int countDown;
        public int currentCount;
        public boolean isBackground;
        public String mAdPlaceId;
        public String mAppPkg;
        public String mAppsid;
        public Context mContext;
        public IXAdInstanceInfo mInstanceInfo;
        public String mPk;
        public String mProd;
        public final /* synthetic */ XAdRemoteClickHandler this$0;

        public MarketDownloadBackupTask(XAdRemoteClickHandler xAdRemoteClickHandler, XAdContainerContext xAdContainerContext, IXAdInstanceInfo iXAdInstanceInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xAdRemoteClickHandler, xAdContainerContext, iXAdInstanceInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = xAdRemoteClickHandler;
            this.countDown = 5000;
            this.currentCount = 0;
            this.isBackground = false;
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                cancel();
                this.isBackground = false;
                this.currentCount = 0;
            }
        }

        @Override // com.baidu.mobads.container.executor.BaseTask
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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
                    this.this$0.dealDownloadApk(this.mContext, this.mInstanceInfo, this.mProd, this.mAppsid);
                    return null;
                } else {
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public XAdRemoteClickHandler() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((IOAdEventListener) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealDownloadApk(Context context, IXAdInstanceInfo iXAdInstanceInfo, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, this, context, iXAdInstanceInfo, str, str2) == null) || context == null || iXAdInstanceInfo == null) {
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

    private void handleClick4DownloadApk(XBaseAdContainer xBaseAdContainer, IXAdInstanceInfo iXAdInstanceInfo, HashMap<String, Object> hashMap) {
        String appStoreLink;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, this, xBaseAdContainer, iXAdInstanceInfo, hashMap) == null) {
            XAdContainerContext adContainerContext = xBaseAdContainer.getAdContainerContext();
            Context appContext = xBaseAdContainer.getAdContainerContext().getAppContext();
            String adProd = adContainerContext.getAdProd();
            String appsid = adContainerContext.getAppsid();
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
                        ConfirmDialog.loadWith(xBaseAdContainer.getAdContainerContext().getActivity(), iXAdInstanceInfo).setHideNavigation(true).setConfirmListener(new ConfirmDialog.OnConfirmListener(this, xBaseAdContainer, iXAdInstanceInfo, appContext, adProd, appsid, hashMap) { // from class: com.baidu.mobads.container.components.utils.XAdRemoteClickHandler.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ XAdRemoteClickHandler this$0;
                            public final /* synthetic */ String val$appsid;
                            public final /* synthetic */ XBaseAdContainer val$c;
                            public final /* synthetic */ Context val$context;
                            public final /* synthetic */ IXAdInstanceInfo val$instanceInfo;
                            public final /* synthetic */ HashMap val$p;
                            public final /* synthetic */ String val$prod;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, xBaseAdContainer, iXAdInstanceInfo, appContext, adProd, appsid, hashMap};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$c = xBaseAdContainer;
                                this.val$instanceInfo = iXAdInstanceInfo;
                                this.val$context = appContext;
                                this.val$prod = adProd;
                                this.val$appsid = appsid;
                                this.val$p = hashMap;
                            }

                            @Override // com.baidu.mobads.container.widget.ConfirmDialog.OnConfirmListener
                            public void onAdClick() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.this$0.prevHandleDownloadApk(this.val$c, this.val$instanceInfo);
                                    this.this$0.dealDownloadApk(this.val$context, this.val$instanceInfo, this.val$prod, this.val$appsid);
                                    this.val$c.onAdClick(this.val$instanceInfo, (View) this.val$p.get("adView"));
                                }
                            }

                            @Override // com.baidu.mobads.container.widget.ConfirmDialog.OnConfirmListener
                            public void onDialogClose() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                    this.val$c.handleResume(this.val$instanceInfo);
                                }
                            }

                            @Override // com.baidu.mobads.container.widget.ConfirmDialog.OnConfirmListener
                            public void onDialogShow() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                                    this.val$c.handlePause(this.val$instanceInfo);
                                }
                            }

                            @Override // com.baidu.mobads.container.widget.ConfirmDialog.OnConfirmListener
                            public void onPermissionClose() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                                    this.val$c.onPermissionClose(this.val$instanceInfo);
                                }
                            }

                            @Override // com.baidu.mobads.container.widget.ConfirmDialog.OnConfirmListener
                            public void onPermissionShow() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                                    this.val$c.onPermissionShow(this.val$instanceInfo);
                                }
                            }

                            @Override // com.baidu.mobads.container.widget.ConfirmDialog.OnConfirmListener
                            public void onPrivacyClick() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                                    this.val$c.onPrivacyClick(this.val$instanceInfo);
                                }
                            }

                            @Override // com.baidu.mobads.container.widget.ConfirmDialog.OnConfirmListener
                            public void onPrivacyClose() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                                    this.val$c.onPrivacyLpClose(this.val$instanceInfo);
                                }
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
    }

    private boolean handleFeedVideo(XAdContainerContext xAdContainerContext, HashMap<String, Object> hashMap, String str, IXAdInstanceInfo iXAdInstanceInfo) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65543, this, xAdContainerContext, hashMap, str, iXAdInstanceInfo)) == null) {
            if (xAdContainerContext == null || hashMap == null || !hashMap.containsKey("lpShoubaiStyle") || !hashMap.get("lpShoubaiStyle").equals("video_and_web")) {
                return false;
            }
            AdLandingpageOpen adLandingpageOpen = new AdLandingpageOpen(xAdContainerContext, str, (XAdInstanceInfoExt) iXAdInstanceInfo, iXAdInstanceInfo.getWebUrl());
            adLandingpageOpen.lpStyle = (String) hashMap.get("lpShoubaiStyle");
            adLandingpageOpen.lpMurl = (String) hashMap.get(XAdRemoteCommonUtils.LP_MURL_KEY);
            adLandingpageOpen.execute();
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    private boolean isFeedVideo(HashMap<String, Object> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, this, hashMap)) == null) ? hashMap != null && hashMap.containsKey("lpShoubaiStyle") && hashMap.get("lpShoubaiStyle").equals("video_and_web") : invokeL.booleanValue;
    }

    private boolean isProdType4Remote(XBaseAdContainer xBaseAdContainer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, xBaseAdContainer)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean isRemoteApkDownloader(int i2, XBaseAdContainer xBaseAdContainer, HashMap<String, Object> hashMap) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(65546, this, i2, xBaseAdContainer, hashMap)) == null) ? i2 == 2 && isProdType4Remote(xBaseAdContainer) && !isFeedVideo(hashMap) : invokeILL.booleanValue;
    }

    private void monitorAppInstall(XAdContainerContext xAdContainerContext, IXAdInstanceInfo iXAdInstanceInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, this, xAdContainerContext, iXAdInstanceInfo) == null) {
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
    }

    private boolean openExternalApp(XBaseAdContainer xBaseAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap<String, Object> hashMap) {
        InterceptResult invokeLLLL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, this, xBaseAdContainer, iXAdInstanceInfo, bool, hashMap)) == null) {
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
                        TaskScheduler.getInstance().submitAtFixedRate(new MarketDownloadBackupTask(this, xBaseAdContainer.getAdContainerContext(), xAdInstanceInfoExt), 0L, 500L, TimeUnit.MILLISECONDS);
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
        return invokeLLLL.booleanValue;
    }

    private void pingThirdClickUrls(IXAdInstanceInfo iXAdInstanceInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, iXAdInstanceInfo) == null) {
            ArrayList arrayList = new ArrayList();
            List<String> thirdClickTrackingUrls = iXAdInstanceInfo.getThirdClickTrackingUrls();
            for (int i2 = 0; i2 < thirdClickTrackingUrls.size(); i2++) {
                arrayList.add(thirdClickTrackingUrls.get(i2).replaceAll(XAdSDKRemoteConfig.REGULAR_MATCH_PROGRESS, String.valueOf(0)));
            }
            Set<String> hashSet = new HashSet<>();
            hashSet.addAll(arrayList);
            pingURLs(hashSet);
        }
    }

    private void pingURLs(Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, set) == null) {
            for (String str : set) {
                new OAdURLConnection(1, str).asynLoad();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prevHandleDownloadApk(XBaseAdContainer xBaseAdContainer, IXAdInstanceInfo iXAdInstanceInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, this, xBaseAdContainer, iXAdInstanceInfo) == null) {
            StateMachine.event(iXAdInstanceInfo.getUniqueId(), AdStateCode.EVENT_CLICK_DL);
            pingThirdClickUrls(iXAdInstanceInfo);
            this.mDispatcher.dispatchEvent(new XAdRemoteEvent("AdUserClick", iXAdInstanceInfo.getUniqueId()));
        }
    }

    private void registerLpCloseReceiver(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, this, context) == null) || this.mDispatcher == null) {
            return;
        }
        LpCloseController.getInstance(context).startListener();
        LpCloseController.getInstance(context).addEventListener("AdLpClosed", this.mDispatcher.getEventType("AdLpClosed"));
    }

    private void registerReceiver(Context context, XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65553, this, context, xAdRemoteAPKDownloadExtraInfo, str) == null) {
            XAdInstallController xAdInstallController = XAdInstallController.getInstance();
            xAdInstallController.registerInstallReceiver(context, xAdRemoteAPKDownloadExtraInfo);
            xAdInstallController.setInstallListener(str, new InstallReceiver.InstallListener(this, str) { // from class: com.baidu.mobads.container.components.utils.XAdRemoteClickHandler.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ XAdRemoteClickHandler this$0;
                public final /* synthetic */ String val$pk;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$pk = str;
                }

                @Override // com.baidu.mobads.container.components.controller.InstallReceiver.InstallListener
                public void onPackageInstalled(Context context2, Intent intent) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLL(1048576, this, context2, intent) == null) || this.this$0.mDlStatusListener == null) {
                        return;
                    }
                    this.this$0.mDlStatusListener.run(new XAdRemoteEvent("AdStatusChange", this.val$pk));
                }
            });
        }
    }

    public void onAdClicked(XBaseAdContainer xBaseAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, xBaseAdContainer, iXAdInstanceInfo, bool, hashMap) == null) || xBaseAdContainer == null || xBaseAdContainer.getAdContainerContext() == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iOAdEventListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.numOfCheckAPOAppIsAtFront = 0;
        this.mDlStatusListener = iOAdEventListener;
    }
}
