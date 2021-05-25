package com.baidu.browser.sailor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.annotation.Nullable;
import com.baidu.android.common.util.CommonParam;
import com.baidu.browser.core.INoProGuard;
import com.baidu.browser.sailor.feature.a;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.browser.sailor.platform.nativeability.BdGeoLocationInfo;
import com.baidu.browser.sailor.webkit.loader.BdWebkitManager;
import com.baidu.browser.sailor.webkit.loader.IWebkitLoaderListener;
import com.baidu.browser.sailor.webkit.update.BdZeusUpdate;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.internal.blink.EngineManager;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.baidu.webkit.internal.utils.NetWorkUtils;
import com.baidu.webkit.sdk.IABTestInterface;
import com.baidu.webkit.sdk.ICronetListenerInterface;
import com.baidu.webkit.sdk.INetProbeInterface;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebViewDatabase;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.dumper.CrashCallback;
import com.baidu.webkit.sdk.dumper.ZwDebug;
import com.baidu.webkit.sdk.location.ZeusGeoLocationInfo;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdSailor implements INoProGuard {
    public static final String LOG_TAG = "BdSailor";
    public static BdSailor sInstance;
    public BdSailorClient mClient;
    public BdSailorWebView mCurSailorWebView;
    public boolean mIsInit = false;
    public BdSailorSettings mSettings;
    public HashMap<String, Object> mStaticWebSettings;

    public BdSailor() {
        Log.d(LOG_TAG, "BdSailor::BdSailor");
        this.mClient = new BdSailorClient();
    }

    public static void addForceInitListener(WebKitFactory.IForceInitZeusListener iForceInitZeusListener) {
        WebKitFactory.addListener(iForceInitZeusListener);
    }

    public static void crashIntentionally(int i2) {
        Log.d("CRASHPAD", "bdsailor.crashIntentionally type:".concat(String.valueOf(i2)));
        if (i2 == 4) {
            ZwDebug.crashIntentionally(2);
        } else if (i2 != 5) {
            Log.d("CRASHPAD", "bdsailor.crashIntentionally default type:".concat(String.valueOf(i2)));
        } else {
            ZwDebug.crashIntentionally(3);
        }
    }

    private void enableFeatureInternal(String str) {
        a featureByName;
        if (TextUtils.isEmpty(str) || (featureByName = BdSailorPlatform.getInstance().getFeatureByName(str)) == null) {
            return;
        }
        featureByName.enable();
    }

    public static synchronized BdSailor getInstance() {
        BdSailor bdSailor;
        synchronized (BdSailor.class) {
            if (sInstance == null) {
                sInstance = new BdSailor();
            }
            bdSailor = sInstance;
        }
        return bdSailor;
    }

    public static void initCookieSyncManager(Context context) {
        BdSailorPlatform.initCookieSyncManager(context);
    }

    private void notifyUserPrivacyConfirmedInner() {
        if (!BdSailorPlatform.getInstance().isNeedUpdateKernel() || getAppContext() == null) {
            return;
        }
        Log.i(EngineManager.LOG_TAG, "start check zeus update after notifyUserPrivacyConfirmInner");
        getAppContext();
        BdZeusUpdate.a().c(getAppContext());
    }

    private void setSailorFeatureListener() {
    }

    public void OnAppEnterBackground() {
        Log.i("huqin-ps2-app", "OnAppEnterBackground");
        SessionMonitorEngine.getInstance().OnAppEnterBackground();
    }

    public void OnAppEnterForeground() {
        Log.i("huqin-ps2-app", "OnAppEnterForeground");
        SessionMonitorEngine.getInstance().OnAppEnterForeground();
    }

    public void addListener(IWebkitLoaderListener iWebkitLoaderListener) {
        BdSailorPlatform.getWebkitManager().addListener(iWebkitLoaderListener);
    }

    public boolean checkZeusForceInit() {
        return isWebkitInit() && WebKitFactory.isForceInitT7();
    }

    public void clearCache(boolean z) {
        if (isWebkitInit()) {
            BdSailorPlatform.getInstance().clearCache(z);
        }
    }

    public void clearPasswords(Context context) {
        if (isWebkitInit()) {
            WebViewDatabase webViewDatabase = WebViewDatabase.getInstance(context);
            webViewDatabase.clearUsernamePassword();
            webViewDatabase.clearHttpAuthUsernamePassword();
        }
    }

    public void destroy() {
        Log.d(LOG_TAG, "BdSailor::destroy");
        BdSailorPlatform.destroy();
        sInstance = null;
    }

    public void disableFeature(String str) {
        a featureByName;
        WebViewFactory.getProvider().disableFeature(str);
        if (TextUtils.isEmpty(str) || (featureByName = BdSailorPlatform.getInstance().getFeatureByName(str)) == null) {
            return;
        }
        featureByName.disable();
    }

    public void enableFeature(String str) {
        a featureByName;
        WebViewFactory.getProvider().enableFeature(str);
        if (TextUtils.isEmpty(str) || (featureByName = BdSailorPlatform.getInstance().getFeatureByName(str)) == null) {
            return;
        }
        featureByName.enable();
    }

    public void exitFeature(String str) {
    }

    public Context getAppContext() {
        return BdSailorPlatform.getInstance().getAppContext();
    }

    public String getCookie(String str) {
        return BdSailorPlatform.getInstance().getCookie(str);
    }

    public BdSailorWebView getCurSailorWebView() {
        return this.mCurSailorWebView;
    }

    public List<String> getCurrentPagePictureList() {
        if (getCurSailorWebView() == null || getCurSailorWebView().getWebViewExt() == null) {
            return null;
        }
        return getCurSailorWebView().getWebViewExt().getPictureUrlListExt();
    }

    public String getSDKVersionName() {
        return WebKitFactory.getSdkVersionName();
    }

    @Nullable
    public ISailorAbTestInterface getSailorAbTestInterface() {
        IABTestInterface abTestInterface = WebViewFactory.getAbTestInterface();
        if (abTestInterface == null || !(abTestInterface instanceof ISailorAbTestInterface)) {
            return null;
        }
        return (ISailorAbTestInterface) abTestInterface;
    }

    public BdSailorClient getSailorClient() {
        BdSailorClient bdSailorClient = this.mClient;
        if (bdSailorClient == null) {
            Log.e(LOG_TAG, "SailorClient can not be NULL!");
            return new BdSailorClient();
        }
        return bdSailorClient;
    }

    @Nullable
    public ISailorCronetListenerInterface getSailorCronetListenerInterface() {
        ICronetListenerInterface cronetListenerInterface = WebViewFactory.getCronetListenerInterface();
        if (cronetListenerInterface == null || !(cronetListenerInterface instanceof ISailorCronetListenerInterface)) {
            return null;
        }
        return (ISailorCronetListenerInterface) cronetListenerInterface;
    }

    @Nullable
    public ISailorNetProbeInterface getSailorNetProbeInterface() {
        INetProbeInterface netProbeInterface = WebViewFactory.getNetProbeInterface();
        if (netProbeInterface == null || !(netProbeInterface instanceof ISailorNetProbeInterface)) {
            return null;
        }
        return (ISailorNetProbeInterface) netProbeInterface;
    }

    public synchronized BdSailorSettings getSailorSettings() {
        if (this.mSettings == null) {
            this.mSettings = new BdSailorSettings();
        }
        return this.mSettings;
    }

    public d.a.h.b.b.b.a getStatic() {
        BdSailorPlatform.getInstance();
        return BdSailorPlatform.getStatic();
    }

    public String getZeusVersionName() {
        return WebKitFactory.getZeusVersionName();
    }

    public boolean hasPictureInCurrentPage(String str) {
        List<String> currentPagePictureList = getCurrentPagePictureList();
        if (currentPagePictureList != null) {
            return currentPagePictureList.contains(str);
        }
        return false;
    }

    public boolean init(Context context, String str) {
        if (!this.mIsInit) {
            Log.d(LOG_TAG, "BdSailor::init");
            if (context == null) {
                throw new RuntimeException("BdSailor::init aContext must not be null.");
            }
            boolean init = BdSailorPlatform.getInstance().init(context.getApplicationContext(), str);
            enableFeatureInternal(BdSailorConfig.SAILOR_BASE_SSL);
            enableFeatureInternal(BdSailorConfig.SAILOR_BASE_UPLOAD);
            enableFeatureInternal(BdSailorConfig.SAILOR_EXT_LIGHT_APP);
            setSailorFeatureListener();
            this.mIsInit = init;
        }
        return this.mIsInit;
    }

    public boolean init(Context context, String str, String str2) {
        boolean init = init(context, str);
        if (TextUtils.isEmpty(str2)) {
            str2 = CommonParam.getCUID(BdSailorPlatform.getInstance().getAppContext());
        }
        WebKitFactory.setCUIDString(str2);
        return init;
    }

    @Deprecated
    public int initAdBlock() {
        return -1;
    }

    public void initWebkit(String str, boolean z) {
        initWebkit(str, z, (Class<? extends CrashCallback>) null);
    }

    public void initWebkit(String str, boolean z, int i2) {
        if ((1 == i2 || 2 == i2) && z) {
            WebKitFactory.forceInitT7(i2);
        }
        initWebkit(str, z);
    }

    public void initWebkit(String str, boolean z, int i2, int i3) {
        WebKitFactory.setHttpCacheMbSize(i3);
        initWebkit(str, z, i2);
    }

    public void initWebkit(String str, boolean z, Class<? extends CrashCallback> cls) {
        StringBuilder sb;
        String zeusInitTiming;
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = BdWebkitManager.a.SYSTEM == BdSailorPlatform.getWebkitManager().getWebkitType();
        ZeusPerformanceTiming.Stage stage = ZeusPerformanceTiming.Stage.Start;
        if (z2) {
            ZeusPerformanceTiming.record(stage, ZeusPerformanceTiming.KEY_INIT_SYS_WEBKIT);
        } else {
            ZeusPerformanceTiming.record(stage, ZeusPerformanceTiming.KEY_INIT_WEBKIT);
        }
        BdSailorPlatform.getInstance().initWebkit(str, z, cls);
        if (z2) {
            ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_INIT_SYS_WEBKIT);
            sb = new StringBuilder("initWebkit = ");
            sb.append(System.currentTimeMillis() - currentTimeMillis);
            sb.append(" ");
            zeusInitTiming = ZeusPerformanceTiming.getSysInitTiming();
        } else {
            ZeusPerformanceTiming.record(ZeusPerformanceTiming.Stage.End, ZeusPerformanceTiming.KEY_INIT_WEBKIT);
            sb = new StringBuilder("initWebkit = ");
            sb.append(System.currentTimeMillis() - currentTimeMillis);
            sb.append(" ");
            zeusInitTiming = ZeusPerformanceTiming.getZeusInitTiming();
        }
        sb.append(zeusInitTiming);
        android.util.Log.i(GlobalConstants.LOG_PER_TAG, sb.toString());
    }

    public void installZeusFromDownload(String str) {
        BdSailorPlatform.getWebkitManager().installZeusFromDownload(str);
    }

    public boolean isFeatureEnable(String str) {
        a featureByName;
        if (TextUtils.isEmpty(str) || (featureByName = BdSailorPlatform.getInstance().getFeatureByName(str)) == null) {
            return false;
        }
        return featureByName.isEnable();
    }

    public boolean isInit() {
        return this.mIsInit;
    }

    public boolean isWebkitInit() {
        return this.mIsInit && BdSailorPlatform.getInstance().isWebkitInit();
    }

    public boolean isZeusForceInited() {
        return isWebkitInit() && WebKitFactory.isForceInitT7() && WebViewFactory.isForceZeusProviderInited();
    }

    public void notifyUserPrivacyConfirmIfNeeded(boolean z) {
        if (WebKitFactory.isUserPrivacyEnabled() != z) {
            if (z) {
                notifyUserPrivacyConfirmedInner();
            }
            WebKitFactory.notifyUserPrivacyConfirmIfNeeded(z);
        }
    }

    public void onAccountLoginSuccess(String str) {
    }

    public void onActivityDestory(Activity activity) {
        Log.d(LOG_TAG, "BdSailor::onActivityDestory");
        BdSailorPlatform.getInstance().onActivityDestory(activity);
    }

    public void onActivityResult(Activity activity, int i2, int i3, Intent intent) {
        BdSailorPlatform.getInstance().onActivityResult(activity, i2, i3, intent);
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (getCurSailorWebView() != null) {
            getCurSailorWebView().onKeyDown(i2, keyEvent);
            return false;
        }
        return false;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (getCurSailorWebView() != null) {
            getCurSailorWebView().onKeyUp(i2, keyEvent);
            return false;
        }
        return false;
    }

    public void onLowMemory() {
    }

    public void onNetworkChanged(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
            BdSailorPlatform.getInstance().onReceivedNetworkType(networkInfo.getType());
        }
        NetWorkUtils.onNetWorkChanged(getAppContext(), networkInfo);
    }

    public void onVideoGetUrl(String str, String str2) {
    }

    public void onWindowSwitched(BdSailorWebView bdSailorWebView) {
    }

    public void openUrlInBrowser(Activity activity, String str) {
    }

    public void pause() {
        if (WebKitFactory.isUserPrivacyEnabled() && isInit()) {
            WebSettingsGlobalBlink.notifyPause();
            Log.d(LOG_TAG, "BdSailor::pause");
            BdSailorPlatform.getInstance().pause();
        }
    }

    public void removeForceInitListener(WebKitFactory.IForceInitZeusListener iForceInitZeusListener) {
        WebKitFactory.removeListener(iForceInitZeusListener);
    }

    public void removeListener(IWebkitLoaderListener iWebkitLoaderListener) {
        BdSailorPlatform.getWebkitManager().removeListener(iWebkitLoaderListener);
    }

    public void requestFocusNodeHref(int i2) {
    }

    public void resume() {
        if (WebKitFactory.isUserPrivacyEnabled() && isInit()) {
            WebSettingsGlobalBlink.notifyResume();
            Log.d(LOG_TAG, "BdSailor::resume");
            BdSailorPlatform.getInstance().resume();
        }
    }

    public void setCuid(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, WebKitFactory.getCUIDString())) {
            return;
        }
        WebKitFactory.setCUIDString(str);
    }

    public void setCurrentSailorWebView(BdSailorWebView bdSailorWebView) {
        this.mCurSailorWebView = bdSailorWebView;
    }

    public void setLocation(BdGeoLocationInfo bdGeoLocationInfo, boolean z) {
        ZeusGeoLocationInfo zeusGeoLocationInfo = new ZeusGeoLocationInfo();
        zeusGeoLocationInfo.setLatitude(bdGeoLocationInfo.getLatitude());
        zeusGeoLocationInfo.setLongitude(bdGeoLocationInfo.getLongitude());
        zeusGeoLocationInfo.setRadius(bdGeoLocationInfo.getRadius());
        zeusGeoLocationInfo.setTime(bdGeoLocationInfo.getTime());
        zeusGeoLocationInfo.setProvince(bdGeoLocationInfo.getProvince());
        zeusGeoLocationInfo.setDistrict(bdGeoLocationInfo.getDistrict());
        zeusGeoLocationInfo.setStreet(bdGeoLocationInfo.getStreet());
        zeusGeoLocationInfo.setStreetNumber(bdGeoLocationInfo.getStreetNumber());
        zeusGeoLocationInfo.setCityCode(bdGeoLocationInfo.getCityCode());
        WebKitFactory.setLocation(zeusGeoLocationInfo, z);
    }

    public void setSailorAbTestInterface(ISailorAbTestInterface iSailorAbTestInterface) {
        WebViewFactory.setAbTestInterface(iSailorAbTestInterface);
    }

    public void setSailorClient(BdSailorClient bdSailorClient) {
        this.mClient = bdSailorClient;
        WebKitFactory.setWebKitClient(bdSailorClient);
        setSailorFeatureListener();
        BdSailorPlatform.getStatic().f39975a = this.mClient;
    }

    public void setSailorCronetListenerInterface(ICronetListenerInterface iCronetListenerInterface) {
        Log.i(LOG_TAG, "setSailorCronetListenerInterface");
        WebViewFactory.setCronetListenerInterface(iCronetListenerInterface);
    }

    public void setSailorNetProbeInterface(ISailorNetProbeInterface iSailorNetProbeInterface) {
        Log.i(LOG_TAG, "setSailorNetProbeInterface");
        WebViewFactory.setNetProbeInterface(iSailorNetProbeInterface);
    }

    public void setWebkitEnable(boolean z) {
        if (z) {
            BdSailorPlatform.getWebkitManager().enableBdWebkit();
        } else {
            BdSailorPlatform.getWebkitManager().disableBdWebkit();
        }
    }

    public void startCaptureCurrentPageContent() {
        getCurSailorWebView().getWebViewExt().startCaptureContentExt();
    }

    public void startCheckUpdate() {
        BdSailorPlatform.getInstance().startCheckUpdate();
    }

    public void syncCookie(String str, String str2) {
        BdSailorPlatform.getInstance().sync2Cookie(str, str2);
    }

    @Deprecated
    public void updateAdBlock() {
    }
}
