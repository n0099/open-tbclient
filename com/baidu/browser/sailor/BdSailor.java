package com.baidu.browser.sailor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.baidu.android.common.util.CommonParam;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.browser.core.INoProGuard;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.browser.sailor.platform.nativeability.BdGeoLocationInfo;
import com.baidu.browser.sailor.webkit.loader.BdWebkitManager;
import com.baidu.browser.sailor.webkit.loader.IWebkitLoaderListener;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.internal.utils.NetWorkUtils;
import com.baidu.webkit.sdk.IABTestInterface;
import com.baidu.webkit.sdk.INetProbeInterface;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebViewDatabase;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.dumper.CrashCallback;
import com.baidu.webkit.sdk.location.ZeusGeoLocationInfo;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes11.dex */
public class BdSailor implements INoProGuard {
    public static final String LOG_TAG = BdSailor.class.getSimpleName();
    protected static BdSailor sInstance;
    private BdSailorClient mClient;
    private BdSailorWebView mCurSailorWebView;
    private boolean mIsInit = false;
    private BdSailorSettings mSettings;
    private HashMap<String, Object> mStaticWebSettings;

    protected BdSailor() {
        Log.d(LOG_TAG, "BdSailor::BdSailor");
        this.mClient = new BdSailorClient();
    }

    public static void addForceInitListener(WebKitFactory.IForceInitZeusListener iForceInitZeusListener) {
        WebKitFactory.addListener(iForceInitZeusListener);
    }

    private void enableFeatureInternal(String str) {
        com.baidu.browser.sailor.feature.a featureByName;
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

    private void setSailorFeatureListener() {
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
        com.baidu.browser.sailor.feature.a featureByName;
        WebViewFactory.getProvider().disableFeature(str);
        if (TextUtils.isEmpty(str) || (featureByName = BdSailorPlatform.getInstance().getFeatureByName(str)) == null) {
            return;
        }
        featureByName.disable();
    }

    public void enableFeature(String str) {
        com.baidu.browser.sailor.feature.a featureByName;
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
        if (this.mClient == null) {
            Log.e(LOG_TAG, "SailorClient can not be NULL!");
            return new BdSailorClient();
        }
        return this.mClient;
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

    public com.baidu.browser.sailor.platform.b.a getStatic() {
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
        BdSailorPlatform.getInstance().setCuid(str2);
        return init;
    }

    @Deprecated
    public int initAdBlock() {
        return -1;
    }

    public void initWebkit(String str, boolean z) {
        initWebkit(str, z, (Class<? extends CrashCallback>) null);
    }

    public void initWebkit(String str, boolean z, int i) {
        if (1 == i && z) {
            WebKitFactory.forceInitT7(i);
        }
        initWebkit(str, z);
    }

    public void initWebkit(String str, boolean z, Class<? extends CrashCallback> cls) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = BdWebkitManager.a.a == BdSailorPlatform.getWebkitManager().getWebkitType$630ca8f2();
        if (z2) {
            ZeusPerformanceTiming.initSysWebkitStart();
        } else {
            ZeusPerformanceTiming.initWebkitStart();
        }
        BdSailorPlatform.getInstance().initWebkit(str, z, cls);
        if (z2) {
            ZeusPerformanceTiming.initSysWebkitEnd();
            android.util.Log.i(GlobalConstants.LOG_PER_TAG, "initWebkit = " + (System.currentTimeMillis() - currentTimeMillis) + HanziToPinyin.Token.SEPARATOR + ZeusPerformanceTiming.getSysInitTiming());
            return;
        }
        ZeusPerformanceTiming.initWebkitEnd();
        android.util.Log.i(GlobalConstants.LOG_PER_TAG, "initWebkit = " + (System.currentTimeMillis() - currentTimeMillis) + HanziToPinyin.Token.SEPARATOR + ZeusPerformanceTiming.getZeusInitTiming());
    }

    public void installZeusFromDownload(String str) {
        BdSailorPlatform.getWebkitManager().installZeusFromDownload(str);
    }

    public boolean isFeatureEnable(String str) {
        com.baidu.browser.sailor.feature.a featureByName;
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

    public void onAccountLoginSuccess(String str) {
    }

    public void onActivityDestory(Activity activity) {
        Log.d(LOG_TAG, "BdSailor::onActivityDestory");
        BdSailorPlatform.getInstance().onActivityDestory(activity);
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        BdSailorPlatform.getInstance().onActivityResult(activity, i, i2, intent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (getCurSailorWebView() != null) {
            getCurSailorWebView().onKeyDown(i, keyEvent);
            return false;
        }
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (getCurSailorWebView() != null) {
            getCurSailorWebView().onKeyUp(i, keyEvent);
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
        if (isInit()) {
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

    public void requestFocusNodeHref(int i) {
    }

    public void resume() {
        if (isInit()) {
            WebSettingsGlobalBlink.notifyResume();
            Log.d(LOG_TAG, "BdSailor::resume");
            BdSailorPlatform.getInstance().resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
        Log.i(LOG_TAG, "setSailorAbTestInterface");
        WebViewFactory.setAbTestInterface(iSailorAbTestInterface);
    }

    public void setSailorClient(BdSailorClient bdSailorClient) {
        this.mClient = bdSailorClient;
        WebKitFactory.setWebKitClient(bdSailorClient);
        setSailorFeatureListener();
        BdSailorPlatform.getStatic().Jx = this.mClient;
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

    public void syncCookie(String str, String str2) {
        BdSailorPlatform.getInstance().sync2Cookie(str, str2);
    }

    @Deprecated
    public void updateAdBlock() {
    }
}
