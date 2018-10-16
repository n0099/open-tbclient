package com.baidu.searchbox.ng.ai.apps.framework;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.ng.ai.apps.AiAppsActivity;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.console.debugger.RemoteDebugger;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragmentManager;
import com.baidu.searchbox.ng.ai.apps.core.turbo.AiAppsCoreRuntime;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchInfo;
import com.baidu.searchbox.ng.ai.apps.network.update.AiAppsUpdateManager;
import com.baidu.searchbox.ng.ai.apps.performance.AiAppsPerformanceUBC;
import com.baidu.searchbox.ng.ai.apps.performance.panel.PanelDataProvider;
import com.baidu.searchbox.ng.ai.apps.permission.AiAppsPermission;
import com.baidu.searchbox.ng.ai.apps.process.AiAppsMessengerClient;
import com.baidu.searchbox.ng.ai.apps.res.widget.floatlayer.FloatLayer;
import com.baidu.searchbox.ng.ai.apps.res.widget.loadingview.LoadingViewHelper;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.searchbox.ng.ai.apps.system.memory.TrimMemoryDispatcher;
import com.baidu.searchbox.ng.ai.apps.trace.ErrCode;
import com.baidu.searchbox.ng.ai.apps.trace.Tracer;
import com.baidu.searchbox.ng.ai.apps.view.AiAppsLoadingView;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
/* loaded from: classes2.dex */
public abstract class AiAppsBaseFrame {
    private static final boolean DEBUG = false;
    private static final int REQUEST_CODE_RESULT_DISPATCHER = 1;
    private static final String TAG = "AiAppsBaseFrame";
    protected AiAppsActivity mActivity;
    private FloatLayer mFloatLayer;
    protected AiAppsFragmentManager mFragmentManager;
    protected AiAppsLaunchInfo mLaunchInfo;
    private FrameLayout mLoadingContainer;
    private AiAppsLoadingView mLoadingView;
    protected AiAppsPermission mPermissionHandler;
    private final ActivityResultDispatcher mResultDispatcher;
    protected AiAppsMessengerClient mClient = new AiAppsMessengerClient();
    protected AiAppsMessengerClient.OnHandleMessageCallback mMessageCallback = null;
    protected AiAppsUBCStatistic mAiAppsStatistic = new AiAppsUBCStatistic();
    private final TrimMemoryDispatcher mTrimMemoryDispatcher = new TrimMemoryDispatcher();

    @NonNull
    protected abstract AiAppsMessengerClient.OnHandleMessageCallback getMessageCallback();

    public abstract void onNewIntent(Intent intent);

    public AiAppsBaseFrame(AiAppsActivity aiAppsActivity) {
        this.mActivity = aiAppsActivity;
        this.mResultDispatcher = new ActivityResultDispatcher(this.mActivity, 1);
    }

    @CallSuper
    @DebugTrace
    public void onCreate(Bundle bundle) {
        AiAppsLog.d(AiApp.MODEL_TAG, "onCreate: " + this);
        parseIntent(getIntent());
        if (RemoteDebugger.isRemoteDebug()) {
            AiAppsCoreRuntime.release();
        }
        createFragmentManager();
        showAiAppStartView();
        AiApp.updateAiApp(this.mLaunchInfo);
        if (!AiApp.isDataValid()) {
            ErrCode detail = new ErrCode().feature(5L).error(11L).detail("aiapp data is invalid");
            Tracer.get().record(detail);
            AiAppsPerformanceUBC.onEvent(new AiAppsPerformanceUBC.Event(AiAppsPerformanceUBC.ID_STABILITY).from("swan").type(String.valueOf(detail.code())).launchInfo(this.mLaunchInfo).infoAdd("detail", detail.details().toString()));
            tryFinishAndRemoveTask();
            return;
        }
        bindAppService();
    }

    public void onPostCreate(Bundle bundle) {
        AiAppsLog.d(AiApp.MODEL_TAG, "onPostCreate: " + this);
    }

    public Intent getIntent() {
        if (this.mActivity != null) {
            return this.mActivity.getIntent();
        }
        return null;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.mResultDispatcher;
    }

    @NonNull
    public FloatLayer getFloatLayer() {
        if (this.mFloatLayer == null) {
            this.mFloatLayer = new FloatLayer(this.mActivity, (FrameLayout) this.mActivity.findViewById(16908290), 0);
        }
        return this.mFloatLayer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showAiAppStartView() {
        if (this.mLoadingView == null) {
            this.mLoadingView = new AiAppsLoadingView(this.mActivity);
        }
        this.mLoadingView.showAiAppStartView();
    }

    public AiAppsLoadingView getLoadingView() {
        return this.mLoadingView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bindAppService() {
        if (this.mMessageCallback == null) {
            this.mMessageCallback = getMessageCallback();
        }
        this.mClient.bindService(this.mActivity, getServiceBindInfo(), null, this.mMessageCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unbindAppService() {
        this.mClient.unbindService(this.mActivity);
        this.mMessageCallback = null;
    }

    @NonNull
    protected AiAppsMessengerClient.AiAppsServiceBindInfo getServiceBindInfo() {
        AiAppsMessengerClient.AiAppsServiceBindInfo aiAppsServiceBindInfo = new AiAppsMessengerClient.AiAppsServiceBindInfo();
        aiAppsServiceBindInfo.processId = this.mActivity.getProcessId();
        aiAppsServiceBindInfo.appId = this.mLaunchInfo.mAppId;
        aiAppsServiceBindInfo.swanCoreVersion = this.mLaunchInfo.mSwanCoreVersion;
        return aiAppsServiceBindInfo;
    }

    public void reset() {
        AiApp aiApp = AiApp.get();
        if (aiApp != null) {
            aiApp.purge();
        }
        AiApp.terminate();
        tryFinishAndRemoveTask();
        Process.killProcess(Process.myPid());
    }

    private void tryFinishAndRemoveTask() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.mActivity.finishAndRemoveTask();
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void parseIntent(Intent intent) {
        if (intent != null) {
            this.mLaunchInfo = AiAppsLaunchInfo.createFromIntent(intent);
            String stringExtra = intent.getStringExtra(RemoteDebugger.EXTRA_REMOTE_DEBUG_URL);
            if (!TextUtils.isEmpty(stringExtra)) {
                RemoteDebugger.setWebUrl(stringExtra);
            }
            AiAppsPerformanceUBC.recordFromLaunchInfo(this.mLaunchInfo);
        }
    }

    public void onResume() {
        AiAppsLog.d(AiApp.MODEL_TAG, "onResume: " + this);
        this.mAiAppsStatistic.startFlow();
        updateTaskDescription();
        AiApp aiApp = AiApp.get();
        if (aiApp != null) {
            aiApp.onActivityResume(this.mActivity);
        }
        AiAppsUpdateManager.getInstance().tryUpdate();
    }

    public void onPause() {
        AiAppsLog.d(AiApp.MODEL_TAG, "onPause: " + this);
        AiAppsUBCStatistic.AiAppsUBCEvent aiAppsUBCEvent = new AiAppsUBCStatistic.AiAppsUBCEvent();
        aiAppsUBCEvent.mAppId = this.mLaunchInfo.mAppId;
        aiAppsUBCEvent.mSource = this.mLaunchInfo.mLaunchFrom;
        this.mAiAppsStatistic.endFlow(aiAppsUBCEvent);
    }

    public AiAppsMessengerClient getMsgClient() {
        return this.mClient;
    }

    private void updateTaskDescription() {
        if (this.mLaunchInfo != null && this.mLaunchInfo.isValid()) {
            setTaskDescription(this.mActivity, this.mLaunchInfo.mAppTitle, this.mLaunchInfo.mAppIcon, (int) this.mLaunchInfo.mNavigateBarColor);
        }
    }

    public static void setTaskDescription(Activity activity, String str, Bitmap bitmap, int i) {
        if (Color.alpha(i) != 255) {
            i = Color.argb(255, Color.red(i), Color.green(i), Color.blue(i));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setTaskDescription(new ActivityManager.TaskDescription(str, bitmap, i));
        }
    }

    private void createFragmentManager() {
        this.mFragmentManager = new AiAppsFragmentManager(this.mActivity);
        onFragmentManagerCreated();
    }

    protected void onFragmentManagerCreated() {
    }

    public AiAppsFragmentManager getAiAppsFragmentManager() {
        return this.mFragmentManager;
    }

    public boolean finish() {
        return false;
    }

    public void onDestroy() {
        AiAppsLog.d(AiApp.MODEL_TAG, "onDestroy: " + this);
        if (this.mLoadingView != null) {
            this.mLoadingView.stopAnimations();
            this.mLoadingView = null;
        }
        AiAppsUpdateManager.getInstance().release();
        PanelDataProvider.releaseInstance();
        unbindAppService();
    }

    public void onTrimMemory(int i) {
        AiAppsLog.w(TAG, "onTrimMemory level:" + i);
        getTrimMemoryDispatcher().notifyTrimMemory(i);
    }

    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean handleTaskToBack() {
        if (this.mFragmentManager.getFragmentCount() != 1) {
            return false;
        }
        this.mActivity.moveTaskToBack(true);
        return true;
    }

    public AiAppsLaunchInfo getLaunchInfo() {
        return this.mLaunchInfo;
    }

    public final void doUBCEventStatistic(AiAppsUBCStatistic.AiAppsUBCEvent aiAppsUBCEvent) {
        if (this.mLaunchInfo != null && aiAppsUBCEvent != null) {
            aiAppsUBCEvent.mType = AiAppsUBCStatistic.TYPE_CLICK;
            aiAppsUBCEvent.mAppId = this.mLaunchInfo.mAppId;
            AiAppsUBCStatistic.onEvent(aiAppsUBCEvent);
        }
    }

    public void onNightModeCoverChanged(boolean z) {
    }

    public void requestPermissionsExt(int i, @NonNull String[] strArr, AiAppsPermission.PermissionCallback permissionCallback) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.mPermissionHandler == null) {
                this.mPermissionHandler = new AiAppsPermission();
            }
            this.mPermissionHandler.requestPermissions(this.mActivity, i, strArr, permissionCallback);
        }
    }

    public boolean onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.mPermissionHandler != null) {
            this.mPermissionHandler.onRequestPermissionsResult(i, strArr, iArr);
            return true;
        }
        return false;
    }

    public void showLoadingView() {
        this.mLoadingContainer = (FrameLayout) this.mActivity.findViewById(R.id.ai_apps_activity_root);
        LoadingViewHelper.showLoadingView(this.mActivity, this.mLoadingContainer);
    }

    public void removeLoadingView() {
        LoadingViewHelper.removeLoadingView(this.mLoadingContainer);
    }

    @NonNull
    public TrimMemoryDispatcher getTrimMemoryDispatcher() {
        return this.mTrimMemoryDispatcher;
    }
}
