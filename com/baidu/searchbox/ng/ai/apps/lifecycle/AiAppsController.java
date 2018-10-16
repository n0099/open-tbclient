package com.baidu.searchbox.ng.ai.apps.lifecycle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ViewGroup;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.AiAppsActivity;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.aps.AiAppsApsUtils;
import com.baidu.searchbox.ng.ai.apps.camera.AiAppsCameraManager;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsPropertyWindow;
import com.baidu.searchbox.ng.ai.apps.console.ConsoleController;
import com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager;
import com.baidu.searchbox.ng.ai.apps.core.console.AiAppsConsoleManager;
import com.baidu.searchbox.ng.ai.apps.core.container.NgWebView;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragment;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragmentManager;
import com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlavePool;
import com.baidu.searchbox.ng.ai.apps.core.turbo.AiAppsCoreRuntime;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsBaseMessage;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsLifecycleMessage;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsNativeMessage;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsWebMessage;
import com.baidu.searchbox.ng.ai.apps.install.AiAppsBundleHelper;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchInfo;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsCollectionPolicy;
import com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerManager;
import com.baidu.searchbox.ng.ai.apps.media.recorder.manager.AiAppsAudioRecorderManager;
import com.baidu.searchbox.ng.ai.apps.monitor.AiAppsMonitor;
import com.baidu.searchbox.ng.ai.apps.performance.AiAppsPerformanceTrace;
import com.baidu.searchbox.ng.ai.apps.performance.AiAppsPerformanceUBC;
import com.baidu.searchbox.ng.ai.apps.performance.UbcFlowEvent;
import com.baidu.searchbox.ng.ai.apps.permission.AiAppsPermission;
import com.baidu.searchbox.ng.ai.apps.process.AiAppsMessengerClient;
import com.baidu.searchbox.ng.ai.apps.res.ui.FullScreenFloatView;
import com.baidu.searchbox.ng.ai.apps.res.ui.FullScreenFloatViewManager;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.runtime.config.AiAppsConfigData;
import com.baidu.searchbox.ng.ai.apps.runtime.config.PageConfigData;
import com.baidu.searchbox.ng.ai.apps.runtime.config.WindowConfig;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.route.PagesRoute;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.searchbox.ng.ai.apps.system.accelerometer.AiAppsAccelerometerManager;
import com.baidu.searchbox.ng.ai.apps.system.bluetooth.manager.AiAppsBluetoothManager;
import com.baidu.searchbox.ng.ai.apps.system.compass.AiAppsCompassManager;
import com.baidu.searchbox.ng.ai.apps.update.data.AiAppsCloudConfigData;
import com.baidu.searchbox.ng.ai.apps.util.AiAppExecutorUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUrlUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import com.baidu.searchbox.ng.ai.apps.view.AiAppsNARootViewManager;
import com.baidu.webkit.sdk.WebView;
import java.util.HashMap;
/* loaded from: classes2.dex */
public final class AiAppsController implements AiAppsCollectionPolicy.RequestCollectListener {
    private static final boolean DEBUG = false;
    private static final String TAG = "AiAppsController";
    private static volatile AiAppsController sInstance;
    private AiAppsActivity mActivityRef;
    private String mAppBundlePath;
    private AiAppsCloudConfigData mCloudConfigData;
    private AiAppsCollectionPolicy mCollectionPolicy;
    private AiAppsConfigData mConfigData;
    private FullScreenFloatView mConsoleButton;
    private AiAppsConsoleManager mConsoleManager;
    private boolean mIsReleased;
    private boolean mNeedCountTimer;
    private PageConfigData mPagesConfig = new PageConfigData();
    private AiAppsPropertyWindow mPropertyWindow;

    private AiAppsController() {
        AiAppsCoreRuntime.getInstance();
        this.mCollectionPolicy = new AiAppsCollectionPolicy();
        this.mCollectionPolicy.setCollectionListener(this);
        AiAppsLifecycle.get().registerSelf();
    }

    public static AiAppsController getInstance() {
        if (sInstance == null) {
            synchronized (AiAppsController.class) {
                if (sInstance == null) {
                    sInstance = new AiAppsController();
                }
            }
        }
        return sInstance;
    }

    public void registReceiver(Context context) {
        this.mCollectionPolicy.addScreenListener(context);
    }

    public void unregistReceiver(Context context) {
        this.mCollectionPolicy.removeScreenListener(context);
    }

    public void onAppForeground() {
        AiAppsMessengerClient msgClient;
        AiAppsLog.d(AiApp.MODEL_TAG, "onAppForeground");
        String aiAppId = AiApp.getAiAppId();
        if (!TextUtils.isEmpty(aiAppId)) {
            HashMap hashMap = new HashMap();
            hashMap.put(AiAppsLifecycleMessage.EVENT_TYPE_KEY, AiAppsLifecycleMessage.TYPE_APP_SHOW);
            hashMap.put(AiAppsLifecycleMessage.APP_ID_KEY, aiAppId);
            if (this.mActivityRef != null && this.mActivityRef.getLaunchInfo() != null) {
                hashMap.put(AiAppsLifecycleMessage.CLICK_ID_KEY, this.mActivityRef.getLaunchInfo().mClickId);
                hashMap.put("scene", this.mActivityRef.getLaunchInfo().mLaunchFrom);
                AiAppsUBCStatistic.AiAppsUBCEvent aiAppsUBCEvent = new AiAppsUBCStatistic.AiAppsUBCEvent();
                aiAppsUBCEvent.mAppId = this.mActivityRef.getLaunchInfo().mAppId;
                aiAppsUBCEvent.mSource = this.mActivityRef.getLaunchInfo().mLaunchFrom;
                aiAppsUBCEvent.mType = "show";
                AiAppsUBCStatistic.onEvent(aiAppsUBCEvent);
            }
            sendJSMessage(new AiAppsLifecycleMessage(hashMap));
            AiAppsLog.d(AiApp.MODEL_TAG, AiAppsLifecycleMessage.TYPE_APP_SHOW);
            this.mNeedCountTimer = true;
            this.mCollectionPolicy.stopCollectionTimeOut();
            AiAppsCameraManager.getIns().onAiAppForegroundChange(false);
            AiAppsPlayerManager.onAppForegroundChanged(true);
            AiAppsAudioRecorderManager.getInstance().onAiAppForegroundChange(false);
            AiAppsMonitor.getInstance().onForegroundChange(false);
            AiAppExecutorUtils.postOnComputation(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController.1
                @Override // java.lang.Runnable
                public void run() {
                    if (AiAppsController.this.getActivity() != null && AiApp.get() != null) {
                        AiAppsRuntime.getHistoryRuntime().saveAiAppInHistory(AiAppsController.this.getActivity(), AiApp.get());
                    }
                }
            }, "saveAiAppsHistory");
            AiApp aiApp = AiApp.get();
            if (aiApp != null && (msgClient = aiApp.getMsgClient()) != null) {
                msgClient.sendMessage(9, "");
            }
        }
    }

    public void onAppBackground() {
        AiAppsLog.d(AiApp.MODEL_TAG, "onAppBackground");
        String aiAppId = AiApp.getAiAppId();
        if (!TextUtils.isEmpty(aiAppId)) {
            HashMap hashMap = new HashMap();
            hashMap.put(AiAppsLifecycleMessage.EVENT_TYPE_KEY, AiAppsLifecycleMessage.TYPE_APP_HIDE);
            hashMap.put(AiAppsLifecycleMessage.APP_ID_KEY, aiAppId);
            sendJSMessage(new AiAppsLifecycleMessage(hashMap));
            AiAppsLog.d(AiApp.MODEL_TAG, AiAppsLifecycleMessage.TYPE_APP_HIDE);
            if (this.mNeedCountTimer) {
                this.mCollectionPolicy.startCollectionTimeOut();
            }
            AiAppsCameraManager.getIns().onAiAppForegroundChange(true);
            AiAppsPlayerManager.onAppForegroundChanged(false);
            AiAppsAudioRecorderManager.getInstance().onAiAppForegroundChange(true);
            AiAppsMonitor.getInstance().onForegroundChange(true);
        }
    }

    public void requestPermissionsExt(int i, @NonNull String[] strArr, AiAppsPermission.PermissionCallback permissionCallback) {
        AiAppsActivity activity = getActivity();
        if (activity != null) {
            activity.requestPermissionsExt(i, strArr, permissionCallback);
        }
    }

    public void requestCollectionPolicyStopFlag() {
        this.mNeedCountTimer = false;
    }

    public void requestCollectionPolicyContinueFlag() {
        this.mNeedCountTimer = true;
    }

    public static void release() {
        if (sInstance != null) {
            sInstance.mIsReleased = true;
            AiAppsLifecycle.get().unRegisterSelf();
            if (sInstance.mCollectionPolicy != null) {
                sInstance.mCollectionPolicy.stopCollectionTimeOut();
                sInstance.mCollectionPolicy = null;
            }
            AiAppsSlavePool.clearAll();
            AiAppsCoreRuntime.release();
            if (sInstance.mConsoleManager != null) {
                sInstance.mConsoleManager = null;
            }
            AiApp.terminate();
            AiAppsPlayerManager.clearAllPlayerContext();
            AiAppsAudioRecorderManager.release();
            AiAppsBluetoothManager.release();
            AiAppsCompassManager.release();
            AiAppsAccelerometerManager.release();
            sInstance = null;
        }
    }

    @Nullable
    public AiApp getAiApp() {
        return AiApp.get();
    }

    public void asyncLoadAiApps(final AiAppsLaunchInfo aiAppsLaunchInfo) {
        AiAppsBundleHelper.asyncLoadAiApps(aiAppsLaunchInfo, new AiAppsBundleHelper.AiAppsLoadCallback() { // from class: com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController.2
            @Override // com.baidu.searchbox.ng.ai.apps.install.AiAppsBundleHelper.AiAppsLoadCallback
            public void onLoaded(final int i, final AiAppsBundleHelper.AiAppsLoadInfo aiAppsLoadInfo) {
                if (PagesRoute.needPreLoadSubPackage(aiAppsLaunchInfo, aiAppsLoadInfo)) {
                    AiApp aiApp = AiApp.get();
                    if (aiApp != null && !TextUtils.isEmpty(aiAppsLoadInfo.mAppBundlePath)) {
                        String str = aiAppsLoadInfo.mConfigData.mSubPackageList.mSubPackagesPagesMap.get(AiAppsUrlUtils.delAllParamsFromUrl(aiAppsLaunchInfo.mPage));
                        String str2 = aiAppsLoadInfo.mAppBundlePath;
                        PagesRoute.getInstance().downloadSubPackage(aiApp.getMsgClient(), aiAppsLaunchInfo.mAppId, aiAppsLaunchInfo.mVersion, str, aiAppsLoadInfo.mConfigData.mSubPackagesPath.mSubPackagesPathMap.get(str), str2, AiAppsController.this.getSlaveWebViewId(), new PagesRoute.CheckPagesCallback() { // from class: com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController.2.1
                            @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.route.PagesRoute.CheckPagesCallback
                            public void success(String str3) {
                                AiAppsLog.d(AiApp.MODEL_TAG, "download subpackage success");
                                AiAppsController.this.checkInfoAndLoad(i, aiAppsLaunchInfo, aiAppsLoadInfo);
                            }

                            @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.route.PagesRoute.CheckPagesCallback
                            public void failed(int i2) {
                                AiAppsLog.d(AiApp.MODEL_TAG, "download subpackage fail");
                                AiAppsController.this.checkInfoAndLoad(i, aiAppsLaunchInfo, aiAppsLoadInfo);
                            }
                        });
                        return;
                    }
                    AiAppsLog.d(AiApp.MODEL_TAG, "subpackage is invalid");
                }
                AiAppsController.this.checkInfoAndLoad(i, aiAppsLaunchInfo, aiAppsLoadInfo);
            }
        });
        AiAppsCoreRuntime.getInstance().syncSwanCore(aiAppsLaunchInfo);
        AiAppsCoreRuntime.getInstance().prepareRuntime(null);
    }

    @DebugTrace
    public AiAppsConsoleManager getConsoleManager() {
        if (this.mConsoleManager == null) {
            this.mConsoleManager = new AiAppsConsoleManager(AppRuntime.getAppContext());
            AiAppsLog.setConsoleSwitch(true);
        }
        this.mConsoleManager.addToParent((ViewGroup) this.mActivityRef.findViewById(R.id.ai_apps_activity_root));
        return this.mConsoleManager;
    }

    public FullScreenFloatView initConsoleButton(Activity activity) {
        if (activity == null) {
            return null;
        }
        if (this.mConsoleButton == null) {
            this.mConsoleButton = FullScreenFloatViewManager.addFloatView(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.mConsoleButton.setFloatButtonText(activity.getString(R.string.aiapps_sconsole));
            this.mConsoleButton.setFloatImageBackground(R.drawable.aiapps_float_view_button_shape);
            this.mConsoleButton.setVisibility(8);
            this.mConsoleButton.setDragImageListener(new FullScreenFloatView.DragImageClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController.3
                AiAppsConsoleManager mConsoleManager;

                @Override // com.baidu.searchbox.ng.ai.apps.res.ui.FullScreenFloatView.DragImageClickListener
                public void onClick() {
                    if (this.mConsoleManager == null) {
                        this.mConsoleManager = AiAppsController.getInstance().getConsoleManager();
                    }
                    this.mConsoleManager.toggleConsoleVisibility();
                }

                @Override // com.baidu.searchbox.ng.ai.apps.res.ui.FullScreenFloatView.DragImageClickListener
                public void onDrag() {
                }
            });
        }
        return this.mConsoleButton;
    }

    public AiAppsPropertyWindow initPropertyWindow(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.mPropertyWindow == null && (viewGroup = (ViewGroup) activity.findViewById(R.id.ai_apps_activity_root)) != null) {
            this.mPropertyWindow = new AiAppsPropertyWindow(activity);
            this.mPropertyWindow.setVisibility(8);
            viewGroup.addView(this.mPropertyWindow);
        }
        return this.mPropertyWindow;
    }

    public boolean isSupportDebug() {
        AiApp aiApp = AiApp.get();
        AiAppsLaunchInfo aiAppsLaunchInfo = null;
        if (aiApp != null) {
            aiAppsLaunchInfo = aiApp.getLaunchInfo();
        }
        return aiAppsLaunchInfo != null && (AiAppsApsUtils.isTrialPackage(aiAppsLaunchInfo) || AiAppsApsUtils.isDevPackage(aiAppsLaunchInfo));
    }

    public void preloadAiAppsRuntime(Intent intent) {
        AiAppsCoreRuntime.getInstance().preloadCoreRuntime(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkInfoAndLoad(int i, final AiAppsLaunchInfo aiAppsLaunchInfo, final AiAppsBundleHelper.AiAppsLoadInfo aiAppsLoadInfo) {
        if (i == 0 && aiAppsLaunchInfo != null && aiAppsLoadInfo != null) {
            AiAppsPerformanceUBC.requireSession().record(new UbcFlowEvent(AiAppsPerformanceUBC.ACTION_POST_TO_MAIN_STRAT));
            AiAppsUtils.runOnUiThreadAtOnce(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController.4
                @Override // java.lang.Runnable
                public void run() {
                    AiAppsPerformanceUBC.requireSession().record(new UbcFlowEvent(AiAppsPerformanceUBC.ACTION_POST_TO_MAIN_END));
                    if (!AiAppsController.this.mIsReleased) {
                        AiAppsController.this.mAppBundlePath = aiAppsLoadInfo.mAppBundlePath;
                        AiAppsController.this.setConfigData(aiAppsLoadInfo.mConfigData);
                        AiAppsCoreRuntime.getInstance().startFirstPage(aiAppsLaunchInfo, aiAppsLoadInfo);
                        if (aiAppsLaunchInfo.mConsoleSwitch) {
                            AiAppsController.this.initConsoleButton(AiAppsController.this.mActivityRef).setVisibility(0);
                            ConsoleController.setConsoleEnabled(true);
                            AiAppsLog.d(AiAppsController.TAG, "init sConsole for devHook");
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConfigData(AiAppsConfigData aiAppsConfigData) {
        this.mConfigData = aiAppsConfigData;
        AiApp aiApp = getAiApp();
        if (aiApp != null) {
            aiApp.setConfig(aiAppsConfigData);
        }
    }

    public void setActivityRef(AiAppsActivity aiAppsActivity) {
        this.mActivityRef = aiAppsActivity;
        AiApp aiApp = getAiApp();
        if (aiApp != null) {
            aiApp.bindActivity(aiAppsActivity);
        }
    }

    public AiAppsConfigData getConfigData() {
        return this.mConfigData;
    }

    @NonNull
    public WindowConfig getPageWindowConfig(String str) {
        return this.mConfigData == null ? WindowConfig.createNullObject() : this.mPagesConfig.obtainWindowConfig(getBaseUrl(), str, this.mConfigData.mWindowConfig);
    }

    public String getBaseUrl() {
        return TextUtils.isEmpty(this.mAppBundlePath) ? "" : this.mAppBundlePath;
    }

    public String getLaunchUrl() {
        if (this.mActivityRef == null || this.mActivityRef.getLaunchInfo() == null) {
            return null;
        }
        return AiAppsLaunchInfo.getPageInfo(this.mActivityRef.getLaunchInfo(), getInstance().getConfigData());
    }

    public String getFirstPageUrl() {
        return this.mConfigData == null ? "" : this.mConfigData.getFirstPageUrl();
    }

    public AiAppsFragmentManager getAiAppsFragmentManager() {
        if (this.mActivityRef == null) {
            return null;
        }
        return this.mActivityRef.getAiAppsFragmentManager();
    }

    public AiAppsActivity getActivity() {
        return this.mActivityRef;
    }

    public AiAppsNARootViewManager getAiAppsNARootViewManager() {
        AiAppsFragment topAiAppsFragment;
        AiAppsFragmentManager aiAppsFragmentManager = getAiAppsFragmentManager();
        if (aiAppsFragmentManager == null || (topAiAppsFragment = aiAppsFragmentManager.getTopAiAppsFragment()) == null) {
            return null;
        }
        return topAiAppsFragment.getAiAppsNARootViewManager();
    }

    public AiAppsWebViewManager getWebViewManager(String str) {
        return AiAppsCoreRuntime.getInstance().getWebViewManager(str);
    }

    public WebView getBdWebViewBySlaveId(String str) {
        NgWebView webView;
        AiAppsWebViewManager webViewManager = getWebViewManager(str);
        if (webViewManager == null || (webView = webViewManager.getWebView()) == null) {
            return null;
        }
        return webView.getCurrentWebView();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    public void handleNativeMessage(AiAppsNativeMessage aiAppsNativeMessage, boolean z) {
        AiAppsPerformanceTrace.log(AiAppsPerformanceTrace.POST_MSG_TAG, "handleNativeMessage start.");
        if (aiAppsNativeMessage != null) {
            AiAppsWebMessage aiAppsWebMessage = new AiAppsWebMessage();
            aiAppsWebMessage.mData = aiAppsNativeMessage.mData;
            aiAppsWebMessage.mNeedEncode = z;
            sendJSMessage(aiAppsNativeMessage.mWebViewId, aiAppsWebMessage);
            AiAppsPerformanceTrace.log(AiAppsPerformanceTrace.POST_MSG_TAG, "handleNativeMessage end.");
        }
    }

    public void sendJSMessage(AiAppsBaseMessage aiAppsBaseMessage) {
        AiAppsCoreRuntime.getInstance().sendJSMessage(aiAppsBaseMessage);
    }

    public void sendJSMessage(String str, AiAppsBaseMessage aiAppsBaseMessage) {
        AiAppsCoreRuntime.getInstance().sendJSMessage(str, aiAppsBaseMessage);
    }

    public AiAppsFragment getTopAiAppsFragment() {
        AiAppsFragmentManager aiAppsFragmentManager = getAiAppsFragmentManager();
        if (aiAppsFragmentManager == null) {
            return null;
        }
        return aiAppsFragmentManager.getTopAiAppsFragment();
    }

    public String getSlaveWebViewId() {
        AiAppsFragment topAiAppsFragment = getTopAiAppsFragment();
        return topAiAppsFragment != null ? topAiAppsFragment.getSlaveWebViewId() : "";
    }

    public NgWebView getNgWebView() {
        AiAppsWebViewManager webViewManager = getWebViewManager(getSlaveWebViewId());
        if (webViewManager == null) {
            return null;
        }
        return webViewManager.getWebView();
    }

    @NonNull
    public Pair<Integer, Integer> getCurWindowSafeSize() {
        Pair<Integer, Integer> curWindowSize = getCurWindowSize();
        int intValue = ((Integer) curWindowSize.first).intValue();
        int intValue2 = ((Integer) curWindowSize.second).intValue();
        if (intValue == 0) {
            intValue = AiAppsUIUtils.getDisplayWidth(AppRuntime.getAppContext());
        }
        if (intValue2 == 0) {
            intValue2 = AiAppsUIUtils.getAiAppWindowHeight(AppRuntime.getAppContext());
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    @NonNull
    public Pair<Integer, Integer> getCurWindowSize() {
        AiAppsFragment topAiAppsFragment = getTopAiAppsFragment();
        return topAiAppsFragment == null ? new Pair<>(0, 0) : topAiAppsFragment.getCurWindowSize();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsCollectionPolicy.RequestCollectListener
    public void onRequestedCollect(int i) {
        if (this.mActivityRef != null) {
            AiAppsUtils.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController.5
                @Override // java.lang.Runnable
                public void run() {
                    if (AiAppsController.this.mActivityRef != null) {
                        AiAppsController.this.mActivityRef.finish();
                    }
                }
            });
        }
    }

    public void showLoadingView() {
        if (this.mActivityRef != null) {
            this.mActivityRef.showLoadingView();
        }
    }

    public void removeLoadingView() {
        if (this.mActivityRef != null) {
            this.mActivityRef.removeLoadingView();
        }
    }

    public void setCloudConfigData(Intent intent) {
        if (intent != null) {
            getCloudConfigData().setCloudConfigData(intent);
        }
    }

    public void setCloudConfigData(AiAppsLaunchInfo aiAppsLaunchInfo) {
        if (aiAppsLaunchInfo != null) {
            getCloudConfigData().setCloudConfigData(aiAppsLaunchInfo);
        }
    }

    public AiAppsCloudConfigData getCloudConfigData() {
        if (this.mCloudConfigData == null) {
            this.mCloudConfigData = new AiAppsCloudConfigData();
        }
        return this.mCloudConfigData;
    }
}
