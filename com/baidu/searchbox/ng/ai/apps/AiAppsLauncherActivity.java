package com.baidu.searchbox.ng.ai.apps;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.ng.ai.apps.core.aps.LoadAiAppsBundle;
import com.baidu.searchbox.ng.ai.apps.env.AiAppEnv;
import com.baidu.searchbox.ng.ai.apps.env.Purger;
import com.baidu.searchbox.ng.ai.apps.launch.AiAppsLaunchStatusTransfer;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchInfo;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchParams;
import com.baidu.searchbox.ng.ai.apps.performance.AiAppsPerformanceUBC;
import com.baidu.searchbox.ng.ai.apps.prepose.util.AiAppsDebugUtil;
import com.baidu.searchbox.ng.ai.apps.process.AiAppsMainProcessHelper;
import com.baidu.searchbox.ng.ai.apps.res.widget.loadingview.LoadingViewHelper;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.searchbox.ng.ai.apps.statistic.search.AiAppsSearchFlowUBC;
import com.baidu.searchbox.ng.ai.apps.statistic.search.SearchFlowEvent;
import com.baidu.searchbox.ng.ai.apps.swancore.AiAppsSwanCoreManager;
import com.baidu.searchbox.ng.ai.apps.swancore.callback.OnSwanCoreUpdateCallback;
import com.baidu.searchbox.ng.ai.apps.swancore.preset.PresetSwanCoreUpdater;
import com.baidu.searchbox.ng.ai.apps.util.AiAppIntentUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class AiAppsLauncherActivity extends Activity implements AiAppsLaunchStatusTransfer.AiAppsApsStatusListener {
    public static final String AIAPPS_LAUNCH_ACTION = "com.baidu.searchbox.action.aiapps.LAUNCH";
    private static final boolean DEBUG = false;
    private static final String TAG = "AiAppsLauncherActivity";
    private AiAppsLaunchParams mLaunchParams;
    private FrameLayout mLoadingContainer;

    @Override // android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AiAppsUIUtils.applyImmersion(this);
        if (!AiAppIntentUtils.checkActivityRefuseServiceAndFinish(this)) {
            if (!parseIntent(getIntent())) {
                finish();
            } else {
                PresetSwanCoreUpdater.getInstance().updateSwanCoreAsync(new OnSwanCoreUpdateCallback() { // from class: com.baidu.searchbox.ng.ai.apps.AiAppsLauncherActivity.1
                    @Override // com.baidu.searchbox.ng.ai.apps.swancore.callback.OnSwanCoreUpdateCallback
                    public void onUpdateFinished() {
                        AiAppsLauncherActivity.this.mLaunchParams.mSwanCoreVersion = AiAppsSwanCoreManager.getSwanCoreVersion();
                        AiAppsLaunchStatusTransfer.getInstance().registerStatusListener(AiAppsLauncherActivity.this);
                        if (!AiAppsDebugUtil.launchAiAppIfDebug(AiAppsLauncherActivity.this, AiAppsLauncherActivity.this.mLaunchParams)) {
                            AiAppsLauncherActivity.this.setContentView(R.layout.aiapps_launcher_activity);
                            AiAppsLauncherActivity.this.mLoadingContainer = (FrameLayout) AiAppsLauncherActivity.this.findViewById(R.id.launch_loading_container);
                            AiAppsLauncherActivity.this.showLoadingView();
                            LoadAiAppsBundle.loadAiAppsBundle(AiAppsLauncherActivity.this, AiAppsLauncherActivity.this.mLaunchParams);
                        }
                    }
                });
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.mLaunchParams != null) {
            Bundle bundle = this.mLaunchParams.mExtraData;
            if (bundle != null && bundle.getLong(AiAppsUBCStatistic.EXT_KEY_LAUNCH_FLAG) > 0) {
                AiAppsUBCStatistic.AiAppsUBCEvent aiAppsUBCEvent = new AiAppsUBCStatistic.AiAppsUBCEvent();
                aiAppsUBCEvent.mAppId = this.mLaunchParams.mAppId;
                aiAppsUBCEvent.mSource = this.mLaunchParams.mFrom;
                aiAppsUBCEvent.mType = AiAppsUBCStatistic.TYPE_LAUNCH;
                aiAppsUBCEvent.mValue = AiAppsUBCStatistic.VALUE_CANCEL;
                AiAppsUBCStatistic.onEvent(aiAppsUBCEvent);
                bundle.remove(AiAppsUBCStatistic.EXT_KEY_LAUNCH_FLAG);
            }
            AiAppsSearchFlowUBC.addEvent(new SearchFlowEvent(SearchFlowEvent.ID_NOT_REACH, System.currentTimeMillis(), SearchFlowEvent.ERR_TYPE_BACK, "", SearchFlowEvent.EventType.END));
        }
        super.onBackPressed();
    }

    public static void startAiApps(Context context, final AiAppsLaunchInfo aiAppsLaunchInfo) {
        if (!isLauncherActivityClosed(context)) {
            if (AiAppsSwanCoreManager.getVersion(aiAppsLaunchInfo.mTargetSwanVersion) > (aiAppsLaunchInfo.mSwanCoreVersion != null ? aiAppsLaunchInfo.mSwanCoreVersion.swanCoreVersion : 0L)) {
                AiAppsSwanCoreManager.requestUpdateSwanCore();
            }
            final WeakReference weakReference = new WeakReference(context);
            aiAppsLaunchInfo.requireExtraData().putLong(AiAppsPerformanceUBC.EXTRA_AIAPP_PRE_CREATE_CHECK_TIMESTAMP, System.currentTimeMillis());
            AiAppsMainProcessHelper.getInstance().checkStatusAsync(new AiAppsMainProcessHelper.OnStatusCallback() { // from class: com.baidu.searchbox.ng.ai.apps.AiAppsLauncherActivity.2
                @Override // com.baidu.searchbox.ng.ai.apps.process.AiAppsMainProcessHelper.OnStatusCallback
                public void onReady() {
                    AiAppsLaunchInfo.this.requireExtraData().putLong(AiAppsPerformanceUBC.EXTRA_AIAPP_PRE_CREATE_OK_TIMESTAMP, System.currentTimeMillis());
                    Context context2 = (Context) weakReference.get();
                    if (context2 != null && !AiAppsLauncherActivity.isLauncherActivityClosed(context2)) {
                        AiAppsLauncherActivity.doStartAiApps(context2, AiAppsLaunchInfo.createLaunchIntent(context2, AiAppsLaunchInfo.this), AiAppsLaunchInfo.this);
                    }
                }
            });
        }
    }

    private boolean parseIntent(Intent intent) {
        if (intent == null) {
            return false;
        }
        this.mLaunchParams = AiAppsLaunchParams.createFromIntent(intent);
        return this.mLaunchParams != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isLauncherActivityClosed(Context context) {
        if (context == null || !(context instanceof AiAppsLauncherActivity)) {
            return false;
        }
        AiAppsLauncherActivity aiAppsLauncherActivity = (AiAppsLauncherActivity) context;
        return aiAppsLauncherActivity.isFinishing() || aiAppsLauncherActivity.isDestroyed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doStartAiApps(Context context, Intent intent, AiAppsLaunchInfo aiAppsLaunchInfo) {
        startTargetAiApps(context, intent, AiAppsMainProcessHelper.getInstance().getProcessInfoAndResort(aiAppsLaunchInfo.mAppId).mProcessId);
        Purger purger = AiAppEnv.get().getPurger();
        if (purger != null && purger.isDeleting()) {
            purger.addDelIgnoreAppId(aiAppsLaunchInfo.mAppId);
        }
        AiAppsLaunchStatusTransfer.getInstance().onLaunchReady();
    }

    private static void startTargetAiApps(Context context, Intent intent, int i) {
        Intent intent2 = new Intent(context, AiAppsUtils.getAiAppsComponentClazz(AiAppsActivity.class, i));
        if (intent != null && intent.getExtras() != null) {
            intent2.putExtras(intent.getExtras());
        }
        Bundle bundleExtra = intent2.getBundleExtra(AiAppsLaunchInfo.EXTRA_APP_INIT_PARAMS_KEY);
        if (bundleExtra != null) {
            bundleExtra.putLong(AiAppsPerformanceUBC.EXTRA_AIAPP_LAUNCH_ACTIVITY_TIMESTAMP, System.currentTimeMillis());
        }
        context.startActivity(intent2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        LoadingViewHelper.showLoadingView(this, this.mLoadingContainer);
    }

    private void removeLoadingView() {
        LoadingViewHelper.removeLoadingView(this.mLoadingContainer);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        removeLoadingView();
        AiAppsLaunchStatusTransfer.getInstance().removeStatusListener(this);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.launch.AiAppsLaunchStatusTransfer.AiAppsApsStatusListener
    public boolean onLaunchReady() {
        finish();
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.launch.AiAppsLaunchStatusTransfer.AiAppsApsStatusListener
    public boolean onLaunchFailed() {
        finish();
        return false;
    }
}
