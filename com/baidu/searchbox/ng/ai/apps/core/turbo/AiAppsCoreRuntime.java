package com.baidu.searchbox.ng.ai.apps.core.turbo;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.g;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.core.AiAppsCoreUtils;
import com.baidu.searchbox.ng.ai.apps.core.AiAppsWebPageCallback;
import com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager;
import com.baidu.searchbox.ng.ai.apps.core.container.NgWebView;
import com.baidu.searchbox.ng.ai.apps.core.container.init.NgWebViewInitHelper;
import com.baidu.searchbox.ng.ai.apps.core.container.init.NgWebViewInitListener;
import com.baidu.searchbox.ng.ai.apps.core.master.AiAppsMasterManager;
import com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlaveManager;
import com.baidu.searchbox.ng.ai.apps.event.JSEventDispatcher;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsBaseMessage;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsLifecycleMessage;
import com.baidu.searchbox.ng.ai.apps.install.AiAppsBundleHelper;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppLocationIoc;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchInfo;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsWebViewCallback;
import com.baidu.searchbox.ng.ai.apps.performance.AiAppsPerformanceUBC;
import com.baidu.searchbox.ng.ai.apps.performance.UbcFlowEvent;
import com.baidu.searchbox.ng.ai.apps.preload.AiAppsPreloadManager;
import com.baidu.searchbox.ng.ai.apps.res.widget.loadingview.LoadingViewHelper;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.route.FirstPageAction;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppBusinessUbc;
import com.baidu.searchbox.ng.ai.apps.swancore.AiAppsSwanCoreManager;
import com.baidu.searchbox.ng.ai.apps.swancore.model.SwanCoreVersion;
import com.baidu.searchbox.ng.ai.apps.swancore.remote.RemoteSwanCoreControl;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUrlUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class AiAppsCoreRuntime implements AiAppsWebViewCallback {
    private static final boolean DEBUG = false;
    private static final String MASTER_HTML_PATH = "master/master.html";
    private static final String SLAVE_HTML_PATH = "slaves/slaves.html";
    private static final String TAG = "AiAppsCoreRuntime";
    private static volatile AiAppsCoreRuntime sInstance;
    private NgWebViewInitListener mInitListener;
    private boolean mIsMasterReady;
    private boolean mIsReleased;
    private boolean mIsSlaveReady;
    private AiAppsMasterManager mMasterManager;
    private AiAppsSlaveManager mSlaveManager;
    private SwanCoreVersion mSwanCoreVersion;
    private String mWebViewUa;
    private ArrayList<PrepareStatusCallback> mStatusCallbacks = new ArrayList<>();
    private LinkedList<AiAppsBaseMessage> mPendingEvents = new LinkedList<>();
    private HashMap<String, AiAppsWebViewManager> mManagerMap = new HashMap<>();

    /* loaded from: classes2.dex */
    public interface PrepareStatusCallback {
        void onReady();
    }

    private AiAppsCoreRuntime() {
        AiAppsWebViewManager.setWebViewCallback(this);
    }

    public static AiAppsCoreRuntime getInstance() {
        if (sInstance == null) {
            synchronized (AiAppsCoreRuntime.class) {
                if (sInstance == null) {
                    sInstance = new AiAppsCoreRuntime();
                }
            }
        }
        return sInstance;
    }

    private static Context getContext() {
        return AppRuntime.getAppContext();
    }

    public static void release() {
        if (sInstance != null) {
            sInstance.mIsReleased = true;
            if (sInstance.mInitListener != null) {
                NgWebViewInitHelper.getInstance().removeInitListener(sInstance.mInitListener);
            }
            releaseWebViewManager();
            sInstance = null;
            getInstance().preloadCoreRuntime();
        }
    }

    private static void releaseWebViewManager() {
        if (sInstance.mManagerMap != null) {
            for (AiAppsWebViewManager aiAppsWebViewManager : ((HashMap) sInstance.mManagerMap.clone()).values()) {
                if (aiAppsWebViewManager != null) {
                    aiAppsWebViewManager.destroy();
                }
            }
        }
        if (sInstance.mMasterManager != null) {
            sInstance.mMasterManager = null;
        }
        if (sInstance.mSlaveManager != null) {
            sInstance.mSlaveManager = null;
        }
    }

    private void preloadCoreRuntime() {
        preloadCoreRuntime(null);
    }

    public void preloadCoreRuntime(Intent intent) {
        SwanCoreVersion swanCoreVersion;
        if (!isRuntimeReady()) {
            if (intent == null) {
                swanCoreVersion = AiAppsSwanCoreManager.getSwanCoreVersionIPC();
            } else {
                intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
                swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra(AiAppsPreloadManager.EXTRA_KEY_SWAN_CORE);
            }
            if (swanCoreVersion != null) {
                setSwanCoreVersion(swanCoreVersion);
                prepareRuntime(new PrepareStatusCallback() { // from class: com.baidu.searchbox.ng.ai.apps.core.turbo.AiAppsCoreRuntime.1
                    @Override // com.baidu.searchbox.ng.ai.apps.core.turbo.AiAppsCoreRuntime.PrepareStatusCallback
                    public void onReady() {
                    }
                });
                IAiAppLocationIoc locationRuntime = AiAppsRuntime.getLocationRuntime();
                if (locationRuntime != null) {
                    locationRuntime.preInitLocation();
                }
            }
        }
    }

    public void syncSwanCore(AiAppsLaunchInfo aiAppsLaunchInfo) {
        if (this.mSwanCoreVersion != null) {
            aiAppsLaunchInfo.mSwanCoreVersion = this.mSwanCoreVersion;
        } else {
            this.mSwanCoreVersion = aiAppsLaunchInfo.mSwanCoreVersion;
        }
    }

    public void startFirstPage(final AiAppsLaunchInfo aiAppsLaunchInfo, final AiAppsBundleHelper.AiAppsLoadInfo aiAppsLoadInfo) {
        syncSwanCore(aiAppsLaunchInfo);
        AiAppsPerformanceUBC.requireSession().record(new UbcFlowEvent(AiAppsPerformanceUBC.ACTION_PRE_LOAD_CHECK));
        prepareRuntime(new PrepareStatusCallback() { // from class: com.baidu.searchbox.ng.ai.apps.core.turbo.AiAppsCoreRuntime.2
            @Override // com.baidu.searchbox.ng.ai.apps.core.turbo.AiAppsCoreRuntime.PrepareStatusCallback
            public void onReady() {
                AiAppsPerformanceUBC.requireSession().record(new UbcFlowEvent(AiAppsPerformanceUBC.ACTION_PRE_LOAD_OK));
                AiAppsPerformanceUBC.mergeSession();
                if (AiAppsCoreRuntime.this.mMasterManager != null && AiAppsCoreRuntime.this.mSlaveManager != null) {
                    FirstPageAction.startFirstPage(AiAppsCoreRuntime.this.mMasterManager, AiAppsCoreRuntime.this.mSlaveManager, aiAppsLaunchInfo, aiAppsLoadInfo);
                    AiAppsCoreRuntime.this.mSlaveManager = null;
                }
            }
        });
    }

    public void prepareRuntime(PrepareStatusCallback prepareStatusCallback) {
        if (prepareStatusCallback != null && !this.mStatusCallbacks.contains(prepareStatusCallback)) {
            this.mStatusCallbacks.add(prepareStatusCallback);
        }
        boolean isRuntimeReady = isRuntimeReady();
        AiAppsPerformanceUBC.requireSession().putExt(AiAppsPerformanceUBC.EXT_SWAN_PRELOAD, isRuntimeReady ? "1" : "0");
        if (isRuntimeReady) {
            notifyPrepareStatusIfNeeded();
            return;
        }
        AiAppsPerformanceUBC.requireSessionPreload().record(new UbcFlowEvent(AiAppsPerformanceUBC.ACTION_PRE_LOAD_START));
        if (this.mInitListener == null) {
            this.mInitListener = new NgWebViewInitListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.turbo.AiAppsCoreRuntime.3
                @Override // com.baidu.searchbox.ng.ai.apps.core.container.init.NgWebViewInitListener
                public void onInitFinished() {
                    AiAppsPerformanceUBC.requireSessionPreload().record(new UbcFlowEvent(AiAppsPerformanceUBC.ACTION_PRE_LOAD_BLINK_INIT_OK));
                    AiAppsUtils.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.core.turbo.AiAppsCoreRuntime.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!AiAppsCoreRuntime.this.mIsReleased) {
                                AiAppsCoreRuntime.this.updateSwanCoreIfNeeded();
                                if (AiAppsCoreRuntime.this.mSwanCoreVersion != null) {
                                    AiAppsCoreRuntime.this.prepareMaster();
                                    AiAppsCoreRuntime.this.prepareSlave();
                                    return;
                                }
                                AiAppsCoreRuntime.this.handleFallbackCase();
                            }
                        }
                    });
                }
            };
            NgWebViewInitHelper.getInstance().addInitListener(this.mInitListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFallbackCase() {
        this.mIsMasterReady = false;
        this.mIsSlaveReady = false;
        this.mMasterManager = null;
        this.mSlaveManager = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swanjs version", RemoteSwanCoreControl.getCurRemoteVersion());
            jSONObject.put("system model", Build.MODEL);
            jSONObject.put("webview ua", this.mWebViewUa);
        } catch (JSONException e) {
        }
        new AiAppBusinessUbc.Builder(10001).buildAppId(AiApp.get() == null ? "" : AiApp.get().getAppKey()).buildInfo(jSONObject.toString()).report();
    }

    public boolean isRuntimeReady() {
        return this.mIsMasterReady && this.mIsSlaveReady;
    }

    public void notifyPrepareStatusIfNeeded() {
        if (!this.mStatusCallbacks.isEmpty() && isRuntimeReady()) {
            AiAppsPerformanceUBC.requireSessionPreload().record(new UbcFlowEvent(AiAppsPerformanceUBC.ACTION_PRE_LOAD_END));
            Iterator<PrepareStatusCallback> it = this.mStatusCallbacks.iterator();
            while (it.hasNext()) {
                PrepareStatusCallback next = it.next();
                if (next != null) {
                    next.onReady();
                }
            }
            this.mStatusCallbacks.clear();
        }
    }

    private String addPreLoadString(String str, boolean z) {
        String str2 = z ? "slave" : "master";
        if (!TextUtils.isEmpty(str)) {
            AiAppsCoreUtils.insertBeforeFile(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
        }
        return str;
    }

    public String getMasterFileUri() {
        updateSwanCoreIfNeeded();
        String str = this.mSwanCoreVersion.swanCorePath + File.separator + MASTER_HTML_PATH;
        if (AiAppsCoreUtils.isEnableRemoteDebug()) {
            addPreLoadString(str, false);
        } else {
            AiAppsCoreUtils.restFile(str);
        }
        return AiAppsUrlUtils.toFileUriString(str);
    }

    public String getSlaveFileUri() {
        updateSwanCoreIfNeeded();
        String str = this.mSwanCoreVersion.swanCorePath + File.separator + SLAVE_HTML_PATH;
        if (AiAppsCoreUtils.isEnableRemoteDebug()) {
            addPreLoadString(str, true);
        } else {
            AiAppsCoreUtils.restFile(str);
        }
        return AiAppsUrlUtils.toFileUriString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchPendingEvents() {
        if (!this.mPendingEvents.isEmpty()) {
            Iterator<AiAppsBaseMessage> it = this.mPendingEvents.iterator();
            while (it.hasNext()) {
                sendJSMessage(it.next());
            }
            this.mPendingEvents.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepareMaster() {
        if (!this.mIsMasterReady && this.mMasterManager == null) {
            AiAppsPerformanceUBC.requireSessionPreload().record(new UbcFlowEvent(AiAppsPerformanceUBC.ACTION_PRE_LOAD_MASTER_START));
            this.mMasterManager = new AiAppsMasterManager(getContext());
            AiAppsPerformanceUBC.requireSessionPreload().record(new UbcFlowEvent(AiAppsPerformanceUBC.ACTION_PRE_LOAD_MASTER_CREATED));
            this.mMasterManager.loadUrl(getMasterFileUri());
            this.mMasterManager.setWebPageCallback(new AiAppsWebPageCallback() { // from class: com.baidu.searchbox.ng.ai.apps.core.turbo.AiAppsCoreRuntime.4
                @Override // com.baidu.searchbox.ng.ai.apps.core.AiAppsWebPageCallback
                public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
                    AiAppsPerformanceUBC.requireSessionPreload().record(new UbcFlowEvent(AiAppsPerformanceUBC.ACTION_PRE_LOAD_MASTER_OK));
                    AiAppsCoreRuntime.this.mIsMasterReady = true;
                    AiAppsCoreRuntime.this.dispatchPendingEvents();
                    AiAppsCoreRuntime.this.notifyPrepareStatusIfNeeded();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepareSlave() {
        if (!this.mIsSlaveReady && this.mSlaveManager == null) {
            AiAppsPerformanceUBC.requireSessionPreload().record(new UbcFlowEvent(AiAppsPerformanceUBC.ACTION_PRE_LOAD_SLAVE_START));
            this.mSlaveManager = prepareSlave(getContext(), new AiAppsWebPageCallback() { // from class: com.baidu.searchbox.ng.ai.apps.core.turbo.AiAppsCoreRuntime.5
                @Override // com.baidu.searchbox.ng.ai.apps.core.AiAppsWebPageCallback
                public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
                    AiAppsPerformanceUBC.requireSessionPreload().record(new UbcFlowEvent(AiAppsPerformanceUBC.ACTION_PRE_LOAD_SLAVE_OK));
                    AiAppsCoreRuntime.this.mIsSlaveReady = true;
                    AiAppsCoreRuntime.this.notifyPrepareStatusIfNeeded();
                }
            });
        }
    }

    public AiAppsSlaveManager prepareSlave(Context context, AiAppsWebPageCallback aiAppsWebPageCallback) {
        AiAppsSlaveManager aiAppsSlaveManager = new AiAppsSlaveManager(context);
        AiAppsPerformanceUBC.requireSessionPreload().record(new UbcFlowEvent(AiAppsPerformanceUBC.ACTION_PRE_LOAD_SLAVE_CREATED));
        aiAppsSlaveManager.loadUrl(getSlaveFileUri());
        aiAppsSlaveManager.setWebPageCallback(aiAppsWebPageCallback);
        return aiAppsSlaveManager;
    }

    public void setSwanCoreVersion(SwanCoreVersion swanCoreVersion) {
        if (swanCoreVersion != null && swanCoreVersion.isAvailable()) {
            this.mSwanCoreVersion = swanCoreVersion;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSwanCoreIfNeeded() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            setSwanCoreVersion(AiAppsSwanCoreManager.getSwanCoreVersionIPC());
        }
    }

    public SwanCoreVersion getSwanCoreVersion() {
        return this.mSwanCoreVersion;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsWebViewCallback
    public void onCreate(AiAppsWebViewManager aiAppsWebViewManager) {
        this.mManagerMap.put(aiAppsWebViewManager.getWebViewId(), aiAppsWebViewManager);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsWebViewCallback
    public void onResume(AiAppsWebViewManager aiAppsWebViewManager) {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsWebViewCallback
    public void onPause(AiAppsWebViewManager aiAppsWebViewManager) {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsWebViewCallback
    public void onDestroy(AiAppsWebViewManager aiAppsWebViewManager) {
        String webViewId = aiAppsWebViewManager.getWebViewId();
        this.mManagerMap.remove(webViewId);
        if (aiAppsWebViewManager instanceof AiAppsSlaveManager) {
            HashMap hashMap = new HashMap();
            hashMap.put(AiAppsLifecycleMessage.EVENT_TYPE_KEY, AiAppsLifecycleMessage.TYPE_ON_UNLOAD);
            hashMap.put("wvID", webViewId);
            sendJSMessage(new AiAppsLifecycleMessage(hashMap));
            AiAppsLog.d(AiApp.MODEL_TAG, AiAppsLifecycleMessage.TYPE_ON_UNLOAD);
        }
        LoadingViewHelper.clearCachedLoadingViews();
    }

    public AiAppsWebViewManager getWebViewManager(String str) {
        if (this.mManagerMap.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mManagerMap.get(str);
    }

    public void sendJSMessage(AiAppsBaseMessage aiAppsBaseMessage) {
        if (aiAppsBaseMessage == null) {
            throw new IllegalArgumentException("message must be non-null.");
        }
        if (!this.mIsMasterReady) {
            this.mPendingEvents.add(aiAppsBaseMessage);
        } else if (this.mMasterManager != null) {
            JSEventDispatcher.dispatchJSEvent(this.mMasterManager.getWebView(), aiAppsBaseMessage, 1);
        }
    }

    public void sendJSMessage(String str, AiAppsBaseMessage aiAppsBaseMessage) {
        AiAppsWebViewManager aiAppsWebViewManager = this.mManagerMap.get(str);
        if (aiAppsWebViewManager != null) {
            JSEventDispatcher.dispatchJSEvent(aiAppsWebViewManager.getWebView(), aiAppsBaseMessage, 1);
        }
    }

    @Nullable
    public String getWebViewUa() {
        NgWebView webView;
        g settings;
        if (!TextUtils.isEmpty(this.mWebViewUa)) {
            return this.mWebViewUa;
        }
        if (this.mMasterManager != null && (webView = this.mMasterManager.getWebView()) != null && (settings = webView.getSettings()) != null) {
            this.mWebViewUa = settings.getUserAgentString();
        }
        return this.mWebViewUa;
    }
}
