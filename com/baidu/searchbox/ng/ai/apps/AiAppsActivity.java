package com.baidu.searchbox.ng.ai.apps;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragmentManager;
import com.baidu.searchbox.ng.ai.apps.framework.AiAppsBaseFrame;
import com.baidu.searchbox.ng.ai.apps.framework.AiAppsFrameFactory;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchInfo;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.permission.AiAppsPermission;
import com.baidu.searchbox.ng.ai.apps.preload.AiAppsPreloadManager;
import com.baidu.searchbox.ng.ai.apps.process.AiAppsMessengerClient;
import com.baidu.searchbox.ng.ai.apps.process.AiAppsProcessInfo;
import com.baidu.searchbox.ng.ai.apps.process.MsgClientProvider;
import com.baidu.searchbox.ng.ai.apps.res.widget.floatlayer.FloatLayer;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.searchbox.ng.ai.apps.system.memory.TrimMemoryDispatcher;
import com.baidu.searchbox.ng.ai.apps.system.memory.TrimMemoryDispatcherHolder;
import com.baidu.searchbox.ng.ai.apps.util.AiAppExecutorUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import com.baidu.searchbox.ng.ai.apps.view.AiAppsLoadingView;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.searchbox.support.v4.app.FragmentActivity;
/* loaded from: classes2.dex */
public class AiAppsActivity extends FragmentActivity implements MsgClientProvider, FloatLayer.Holder, TrimMemoryDispatcherHolder, ActivityResultDispatcherHolder {
    private static final boolean DEBUG = false;
    private static final String TAG = "AiAppsActivity";
    private AiAppsBaseFrame mBaseFrame;
    private Object tagObject = new Object();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.support.v4.app.FragmentActivity, com.baidu.searchbox.support.v4.app.BaseFragmentActivityDonut, android.app.Activity
    @DebugTrace
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AiAppsUIUtils.applyImmersion(this);
        AiAppsLog.d(AiApp.MODEL_TAG, "AiAppsActivity onCreate");
        setContentView(R.layout.aiapps_activity);
        initAiAppsFrame();
        this.mBaseFrame.onCreate(bundle);
        AiAppExecutorUtils.postOnIO(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.AiAppsActivity.1
            @Override // java.lang.Runnable
            public void run() {
                AiAppsRuntime.getConfigRuntime().initMobstat();
            }
        }, "initMobStat");
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.mBaseFrame.onPostCreate(bundle);
    }

    private void initAiAppsFrame() {
        this.mBaseFrame = AiAppsFrameFactory.buildFramework(this, AiAppsFrameFactory.parseFrameType(getIntent()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        this.mBaseFrame.onNewIntent(intent);
    }

    public void superOnNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override // com.baidu.searchbox.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.mBaseFrame.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.mBaseFrame.getResultDispatcher();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.widget.floatlayer.FloatLayer.Holder
    @NonNull
    public FloatLayer getFloatLayer() {
        return this.mBaseFrame.getFloatLayer();
    }

    public AiAppsLoadingView getLoadingView() {
        return this.mBaseFrame.getLoadingView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        AiAppsController.getInstance().onAppForeground();
        AiAppsLog.d(AiApp.MODEL_TAG, "AiAppsActivity onStart");
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        AiAppsLog.d(AiApp.MODEL_TAG, "AiAppsActivity onResume");
        super.onResume();
        this.mBaseFrame.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        AiAppsLog.d(AiApp.MODEL_TAG, "AiAppsActivity onPause");
        this.mBaseFrame.onPause();
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        AiAppsLog.d(AiApp.MODEL_TAG, "AiAppsActivity onStop");
        super.onStop();
        AiAppsController.getInstance().onAppBackground();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.process.MsgClientProvider
    public AiAppsMessengerClient getMsgClient() {
        return this.mBaseFrame.getMsgClient();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    public AiAppsFragmentManager getAiAppsFragmentManager() {
        return this.mBaseFrame.getAiAppsFragmentManager();
    }

    @Override // android.app.Activity
    public void finish() {
        AiAppsLog.d(AiApp.MODEL_TAG, "AiAppsActivity finish");
        if (!this.mBaseFrame.finish()) {
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        AiAppsLog.d(AiApp.MODEL_TAG, "AiAppsActivity onDestroy");
        this.mBaseFrame.onDestroy();
        super.onDestroy();
    }

    @Override // com.baidu.searchbox.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        AiAppsLog.d(AiApp.MODEL_TAG, "AiAppsActivity onBackPressed");
        this.mBaseFrame.onBackPressed();
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2 = false;
        try {
            z2 = super.moveTaskToBack(z);
            overridePendingTransition(0, R.anim.aiapps_slide_out_to_right_zadjustment_top);
            return z2;
        } catch (Exception e) {
            return z2;
        }
    }

    public int getProcessId() {
        return 0;
    }

    public AiAppsLaunchInfo getLaunchInfo() {
        return this.mBaseFrame.getLaunchInfo();
    }

    public final void doUBCEventStatistic(AiAppsUBCStatistic.AiAppsUBCEvent aiAppsUBCEvent) {
        this.mBaseFrame.doUBCEventStatistic(aiAppsUBCEvent);
    }

    public void preloadNextAiAppsProcess() {
        int processId = getProcessId() + 1;
        if (AiAppsProcessInfo.checkProcessId(processId)) {
            AiAppsPreloadManager.sendPreloadBroadcast(this, processId);
        }
    }

    public void requestPermissionsExt(int i, @NonNull String[] strArr, AiAppsPermission.PermissionCallback permissionCallback) {
        this.mBaseFrame.requestPermissionsExt(i, strArr, permissionCallback);
    }

    @Override // com.baidu.searchbox.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.searchbox.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (!this.mBaseFrame.onRequestPermissionsResult(i, strArr, iArr)) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public void showLoadingView() {
        this.mBaseFrame.showLoadingView();
    }

    public void removeLoadingView() {
        this.mBaseFrame.removeLoadingView();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        this.mBaseFrame.onTrimMemory(i);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.system.memory.TrimMemoryDispatcherHolder
    @NonNull
    public TrimMemoryDispatcher getTrimMemoryDispatcher() {
        return this.mBaseFrame.getTrimMemoryDispatcher();
    }

    public void onNightModeCoverChanged(boolean z) {
        this.mBaseFrame.onNightModeCoverChanged(z);
    }
}
