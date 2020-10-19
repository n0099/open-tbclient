package com.baidu.browser.sailor.platform;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.baidu.browser.core.BdCore;
import com.baidu.browser.core.INoProGuard;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.BdSailorConfig;
import com.baidu.browser.sailor.feature.upload.BdUploadFeature;
import com.baidu.browser.sailor.webkit.loader.BdWebkitManager;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.webkit.internal.blink.EngineManager;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.sdk.CookieManager;
import com.baidu.webkit.sdk.CookieSyncManager;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebChromeClient;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.dumper.CrashCallback;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes11.dex */
public final class BdSailorPlatform implements INoProGuard {
    public static final int APP_STATE_BACKGROUND = 0;
    public static final int APP_STATE_FOREGROUND = 1;
    private static final String ERROR_PAGE_ASSET = "webkit/errorpage/flyflow_error_page.html";
    public static final String LITE_PACKAGE_NAME = "com.baidu.searchbox.lite";
    public static final int MSG_PAUSER_WEBKIT_TIMER = 1;
    public static final int PAUSER_WEBKIT_TIMER_DELAY_TIME = 2000;
    public static final String SAILOR_MODULE_NAME = "sailor";
    public static final String TAG = BdSailorPlatform.class.getName();
    private static SoftReference<String> sErrorPageContent = null;
    private static BdSailorPlatform sInstance;
    private Context mContext;
    private Handler mHandler;
    private a mNetworkChangedReciever;
    private HashMap<String, com.baidu.browser.sailor.feature.a> mSailorFeatureMap;
    private com.baidu.browser.sailor.platform.b.a mSailorStatic;
    private BdWebkitManager mWebkitMgr;
    private String mWorkspace;
    private boolean mNeedFix = true;
    private boolean mIsWebkitInited = false;
    private boolean mIsEnableJavaScriptOnFileScheme = false;
    private boolean mWebkitTimerPaused = false;
    private int mNetworkType = -1;
    private boolean mHasInit = false;
    private boolean mIsNeedUpdateKernel = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(BdSailorPlatform bdSailorPlatform, byte b) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action == null || !action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                return;
            }
            BdSailor.getInstance().onNetworkChanged(((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo());
        }
    }

    private BdSailorPlatform() {
        Log.d(TAG, "BdSailorPlatform");
        this.mSailorStatic = new com.baidu.browser.sailor.platform.b.a();
        this.mWebkitMgr = new BdWebkitManager();
        this.mSailorFeatureMap = new HashMap<>(4);
    }

    public static void destroy() {
        if (sInstance != null) {
            sInstance.doDestroy();
        }
        sInstance = null;
    }

    private boolean doInitWorkspace(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        new File(str).mkdirs();
        return true;
    }

    public static String getDefaultErrorPageHtml(Context context) {
        return "<html></html>";
    }

    public static synchronized BdSailorPlatform getInstance() {
        BdSailorPlatform bdSailorPlatform;
        synchronized (BdSailorPlatform.class) {
            if (sInstance == null) {
                sInstance = new BdSailorPlatform();
            }
            bdSailorPlatform = sInstance;
        }
        return bdSailorPlatform;
    }

    public static com.baidu.browser.sailor.platform.b.a getStatic() {
        return getInstance().mSailorStatic;
    }

    public static BdWebkitManager getWebkitManager() {
        return getInstance().mWebkitMgr;
    }

    public static void initCookieSyncManager(Context context) {
        CookieSyncManager.createInstance(context);
    }

    private void initFeature(Context context) {
        if (this.mHasInit) {
            return;
        }
        registerFeature(new BdUploadFeature(context));
        this.mHasInit = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0058 -> B:22:0x0004). Please submit an issue!!! */
    public boolean isAppOnForeground(Context context) {
        boolean z;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return false;
        }
        try {
            runningAppProcesses = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
        } catch (Exception e) {
            Log.e(TAG, "isAppOnForeground exception");
            e.printStackTrace();
        }
        if (runningAppProcesses == null) {
            z = false;
        } else {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                    if (runningAppProcessInfo.importance == 100) {
                        Log.d(TAG, "app is in foreground");
                        z = true;
                    } else {
                        Log.d(TAG, "app is in background");
                        z = false;
                    }
                }
            }
            Log.d(TAG, "app is in background 1");
            z = false;
        }
        return z;
    }

    public static boolean onShowFileChooser(Activity activity, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        com.baidu.browser.sailor.feature.a featureByName = getInstance().getFeatureByName(BdSailorConfig.SAILOR_BASE_UPLOAD);
        if (featureByName == null || !featureByName.isEnable()) {
            valueCallback.onReceiveValue(null);
        } else {
            BdUploadFeature bdUploadFeature = (BdUploadFeature) featureByName;
            if (bdUploadFeature != null && activity != null) {
                return bdUploadFeature.openFileChooser(activity, valueCallback, fileChooserParams);
            }
        }
        return false;
    }

    public static boolean openFileChooser(Activity activity, ValueCallback<Uri> valueCallback) {
        BdUploadFeature bdUploadFeature;
        com.baidu.browser.sailor.feature.a featureByName = getInstance().getFeatureByName(BdSailorConfig.SAILOR_BASE_UPLOAD);
        if (featureByName == null || !featureByName.isEnable() || (bdUploadFeature = (BdUploadFeature) featureByName) == null || activity == null) {
            valueCallback.onReceiveValue(null);
            return false;
        }
        return bdUploadFeature.openFileChooser(activity, valueCallback);
    }

    public static boolean openFileChooser(Activity activity, ValueCallback<Uri> valueCallback, String str) {
        com.baidu.browser.sailor.feature.a featureByName = getInstance().getFeatureByName(BdSailorConfig.SAILOR_BASE_UPLOAD);
        if (featureByName == null || !featureByName.isEnable()) {
            valueCallback.onReceiveValue(null);
        } else {
            BdUploadFeature bdUploadFeature = (BdUploadFeature) featureByName;
            if (bdUploadFeature != null && activity != null) {
                return bdUploadFeature.openFileChooser(activity, valueCallback, str);
            }
        }
        return false;
    }

    public static boolean openFileChooser(Activity activity, ValueCallback<Uri> valueCallback, String str, String str2) {
        com.baidu.browser.sailor.feature.a featureByName = getInstance().getFeatureByName(BdSailorConfig.SAILOR_BASE_UPLOAD);
        if (featureByName == null || !featureByName.isEnable()) {
            valueCallback.onReceiveValue(null);
        } else {
            BdUploadFeature bdUploadFeature = (BdUploadFeature) featureByName;
            if (bdUploadFeature != null && activity != null) {
                return bdUploadFeature.openFileChooser(activity, valueCallback, str, str2);
            }
        }
        return false;
    }

    private void registerFeature(com.baidu.browser.sailor.feature.a aVar) {
        if (aVar != null) {
            this.mSailorFeatureMap.put(aVar.getName(), aVar);
        }
    }

    private void registerReceiver() {
        if (getAppContext() != null && this.mNetworkChangedReciever == null) {
            this.mNetworkChangedReciever = new a(this, (byte) 0);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            getAppContext().registerReceiver(this.mNetworkChangedReciever, intentFilter);
        }
    }

    private void setNetworkType(int i) {
        this.mNetworkType = i;
        if (1 == i || -1 == i) {
            BdSailor.getInstance().getSailorSettings().setSaveFlow(false);
        }
    }

    private void unregisterFeature(com.baidu.browser.sailor.feature.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.getName())) {
            return;
        }
        this.mSailorFeatureMap.remove(aVar);
    }

    private void unregisterReceiver() {
        if (getAppContext() == null || this.mNetworkChangedReciever == null) {
            return;
        }
        getAppContext().unregisterReceiver(this.mNetworkChangedReciever);
        this.mNetworkChangedReciever = null;
    }

    public final void clearCache(boolean z) {
        com.baidu.browser.sailor.webkit.a tx = com.baidu.browser.sailor.webkit.a.tx();
        try {
            tx.e();
            tx.c.clearCache(z);
        } catch (Exception e) {
            Log.printStackTrace(e);
        }
    }

    public final void doDestroy() {
        Log.d(TAG, "doDestroy");
        try {
            unregisterReceiver();
            if (this.mHandler != null) {
                this.mHandler.removeMessages(1);
                this.mHandler = null;
            }
            com.baidu.browser.sailor.platform.a.a.a();
            com.baidu.browser.sailor.webkit.a.b();
            WebKitFactory.destroy();
            this.mContext = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final com.baidu.browser.sailor.feature.a findSailorFeature(String str) {
        return getFeatureByName(str);
    }

    public final Context getAppContext() {
        return this.mContext;
    }

    public final String getCookie(String str) {
        CookieSyncManager.createInstance(this.mContext);
        return CookieManager.getInstance().getCookie(str);
    }

    public final String getCuid() {
        return WebKitFactory.getCUIDString();
    }

    public final com.baidu.browser.sailor.feature.a getFeatureByName(String str) {
        com.baidu.browser.sailor.feature.a aVar = this.mSailorFeatureMap.get(str);
        if (aVar instanceof com.baidu.browser.sailor.feature.a) {
            return aVar;
        }
        return null;
    }

    public final int getNetworkType() {
        return this.mNetworkType;
    }

    public final String getWorkspace() {
        return this.mWorkspace;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean init(Context context, String str) {
        boolean z;
        File filesDir;
        Log.d(TAG, OneKeyLoginSdkCall.l);
        this.mContext = context;
        if (TextUtils.isEmpty(str)) {
            str = SAILOR_MODULE_NAME;
        }
        if (context != null) {
            this.mWorkspace = str;
            try {
                if (context.getFilesDir() == null) {
                    new File(context.getApplicationContext().getFilesDir() + "/").mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (context.getFilesDir() != null) {
                z = doInitWorkspace(filesDir.getAbsolutePath() + str);
                initFeature(context);
                BdCore.tg().init(context, false);
                if (this.mHandler == null) {
                    this.mHandler = new com.baidu.browser.sailor.platform.a(this, Looper.getMainLooper());
                }
                return z;
            }
        }
        z = false;
        initFeature(context);
        BdCore.tg().init(context, false);
        if (this.mHandler == null) {
        }
        return z;
    }

    public final void initWebkit(String str, boolean z, Class<? extends CrashCallback> cls) {
        String packageName;
        if (this.mIsWebkitInited) {
            return;
        }
        Log.d(TAG, "initWebkit");
        WebKitFactory.setKernelSessionId(String.valueOf(System.currentTimeMillis()));
        if (this.mWebkitMgr != null) {
            this.mWebkitMgr.initWebkit(str, z, cls);
        }
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.browser.sailor.webkit.a tx = com.baidu.browser.sailor.webkit.a.tx();
        Context appContext = getAppContext();
        if (tx.b == null) {
            tx.b = appContext.getApplicationContext();
            Log.d(com.baidu.browser.sailor.webkit.a.f1286a, "in BdWebViewSingleton, init");
        }
        this.mIsWebkitInited = true;
        Log.d("tangxianding", "[START] BdWebViewSingleton init time = " + (System.currentTimeMillis() - currentTimeMillis));
        registerReceiver();
        boolean z2 = z;
        if (this.mContext != null && (packageName = this.mContext.getApplicationContext().getPackageName()) != null && packageName.equalsIgnoreCase(LITE_PACKAGE_NAME)) {
            z2 = false;
        }
        if (WebSettingsGlobalBlink.isSFSwitchEnabled() || !WebViewFactory.isMainAppProcess()) {
            z2 = false;
        }
        this.mIsNeedUpdateKernel = z2;
        if (!z2 || getAppContext() == null) {
            return;
        }
        getAppContext();
        com.baidu.browser.sailor.webkit.update.a.ty().a(getAppContext());
    }

    public final boolean isFixWebViewSecurityHoles() {
        return this.mNeedFix;
    }

    public final boolean isJavaScriptEnabledOnFileScheme() {
        return this.mIsEnableJavaScriptOnFileScheme;
    }

    public final boolean isNeedUpdateKernel() {
        return this.mIsNeedUpdateKernel;
    }

    public final boolean isWebkitInit() {
        return this.mIsWebkitInited;
    }

    public final void onActivityDestory(Activity activity) {
        BdUploadFeature bdUploadFeature;
        com.baidu.browser.sailor.feature.a findSailorFeature = findSailorFeature(BdSailorConfig.SAILOR_BASE_UPLOAD);
        if (findSailorFeature == null || !findSailorFeature.isEnable() || (bdUploadFeature = (BdUploadFeature) findSailorFeature) == null) {
            return;
        }
        bdUploadFeature.onDestroy(activity);
    }

    public final void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        if (11 == i) {
            ((BdUploadFeature) findSailorFeature(BdSailorConfig.SAILOR_BASE_UPLOAD)).onResult(activity, i2, intent);
        }
    }

    public final void onReceivedNetworkType(int i) {
        setNetworkType(i);
    }

    public final void pause() {
        WebSettingsGlobalBlink.notifyBdAppStatusChange(0);
        Log.d(TAG, "pause ");
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 2000L);
        }
    }

    public final void resume() {
        Log.d(TAG, "resume ");
        WebSettingsGlobalBlink.notifyBdAppStatusChange(1);
        try {
            if (this.mHandler != null) {
                this.mHandler.removeMessages(1);
                if (this.mWebkitTimerPaused) {
                    Log.d(TAG, "do resume");
                    com.baidu.browser.sailor.webkit.a.tx().d();
                    CookieSyncManager createInstance = CookieSyncManager.createInstance(this.mContext);
                    if (createInstance != null) {
                        createInstance.startSync();
                    }
                    this.mWebkitTimerPaused = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public final void setCuid(String str) {
    }

    public final void setFixWebViewSecurityHoles(boolean z) {
        this.mNeedFix = z;
    }

    public final void setJavaScriptEnabledOnFileScheme(boolean z) {
        this.mIsEnableJavaScriptOnFileScheme = z;
    }

    public final void setNightMode(boolean z) {
    }

    public final void startCheckUpdate() {
        String packageName;
        if (getAppContext() == null || (packageName = getAppContext().getApplicationContext().getPackageName()) == null || !packageName.equalsIgnoreCase(LITE_PACKAGE_NAME)) {
            return;
        }
        Log.i(EngineManager.LOG_TAG, "start check zeus update form api");
        getAppContext();
        com.baidu.browser.sailor.webkit.update.a.ty().a(getAppContext());
    }

    public final void sync2Cookie(String str, String str2) {
        CookieSyncManager createInstance = CookieSyncManager.createInstance(this.mContext);
        CookieManager.getInstance().setCookie(str, str2);
        createInstance.sync();
    }
}
