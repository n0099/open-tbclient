package com.baidu.searchbox.ng.ai.apps.framework.apps;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.searchbox.ng.ai.apps.AiAppsActivity;
import com.baidu.searchbox.ng.ai.apps.channel.im.AiAppImClientManager;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.console.debugger.RemoteDebugger;
import com.baidu.searchbox.ng.ai.apps.core.AiAppsCoreUtils;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragmentManager;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsLifecycleMessage;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsRouteMessage;
import com.baidu.searchbox.ng.ai.apps.framework.AiAppsBaseFrame;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchInfo;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.monitor.AiAppsMonitor;
import com.baidu.searchbox.ng.ai.apps.performance.AiAppsPerformanceUBC;
import com.baidu.searchbox.ng.ai.apps.performance.UbcFlowEvent;
import com.baidu.searchbox.ng.ai.apps.process.AiAppsMessengerClient;
import com.baidu.searchbox.ng.ai.apps.process.AiAppsMessengerService;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.route.ActionUtils;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.route.PagesRoute;
import com.baidu.searchbox.ng.ai.apps.screenshot.AiAppsScreenshot;
import com.baidu.searchbox.ng.ai.apps.skin.AiAppNightModeHelper;
import com.baidu.searchbox.ng.ai.apps.skin.AiAppsSkinDecorator;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.searchbox.ng.ai.apps.statistic.search.AiAppsSearchFlowUBC;
import com.baidu.searchbox.ng.ai.apps.statistic.search.SearchFlowEvent;
import com.baidu.searchbox.ng.ai.apps.swancore.AiAppsSwanCoreManager;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class AiAppsFrame extends AiAppsBaseFrame implements AiAppsFragmentManager.FragmentOpListener {
    private static final boolean DEBUG = false;
    private static final String TAG = "AiAppsFrame";
    private AiAppsSkinDecorator mSkinDecorator;

    public AiAppsFrame(AiAppsActivity aiAppsActivity) {
        super(aiAppsActivity);
        this.mSkinDecorator = null;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.framework.AiAppsBaseFrame
    public void onCreate(Bundle bundle) {
        if (AiAppsCoreUtils.isEnableRemoteDebug()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        AiAppsPerformanceUBC.resetSession();
        AiAppsPerformanceUBC.requireSession().record(new UbcFlowEvent(AiAppsPerformanceUBC.ACTION_FRAME_START_CREATE));
        AiAppsMonitor.getInstance().startMonitor(this.mActivity);
        super.onCreate(bundle);
        if (bundle == null) {
            onLaunchSuccessUBC();
            onLaunchSuccessForSearchUBC(false);
        }
        updateInvalidSwanCore();
        asyncLoadApps(this.mLaunchInfo);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.framework.AiAppsBaseFrame
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        onNightModeCoverChanged(AiAppNightModeHelper.getNightModeSwitcherState());
        AiAppsScreenshot.registerScreenshotEvent();
        AiAppsController.getInstance().registReceiver(this.mActivity);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.framework.AiAppsBaseFrame
    public void onResume() {
        super.onResume();
        AiAppsPerformanceUBC.requireSession().record(new UbcFlowEvent(AiAppsPerformanceUBC.ACTION_FRAME_START_END));
    }

    private void asyncLoadApps(AiAppsLaunchInfo aiAppsLaunchInfo) {
        if (aiAppsLaunchInfo != null) {
            AiAppsController.getInstance().setActivityRef(this.mActivity);
            AiAppsController.getInstance().setCloudConfigData(aiAppsLaunchInfo);
            AiAppsController.getInstance().asyncLoadAiApps(aiAppsLaunchInfo);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.framework.AiAppsBaseFrame
    public void onNewIntent(Intent intent) {
        AiAppsLog.d(AiApp.MODEL_TAG, "AiAppsActivity onNewIntent");
        this.mActivity.setIntent(intent);
        AiAppsLaunchInfo createFromIntent = AiAppsLaunchInfo.createFromIntent(intent);
        if (!TextUtils.equals(createFromIntent.mAppId, this.mLaunchInfo.mAppId) || RemoteDebugger.isRemoteDebug()) {
            this.mActivity.superOnNewIntent(intent);
            unbindAppService();
            parseIntent(getIntent());
            showAiAppStartView();
            AiAppsController.release();
            asyncLoadApps(this.mLaunchInfo);
            bindAppService();
        } else {
            this.mLaunchInfo = createFromIntent;
            String launchPageUrl = getLaunchPageUrl();
            if (!TextUtils.isEmpty(launchPageUrl)) {
                ActionUtils.dispatchRouteRequest(ActionUtils.BACK_TO_HOME_REQUEST, null, launchPageUrl);
            }
        }
        AiApp.updateAiApp(this.mLaunchInfo);
        onLaunchSuccessUBC();
        onLaunchSuccessForSearchUBC(true);
        AiApp aiApp = AiApp.get();
        if (aiApp != null) {
            aiApp.getSetting().clearAuthorizeAndCallback();
            aiApp.getAccount().clear();
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.framework.AiAppsBaseFrame
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && AiAppsRuntime.getVideoRuntime().onKeyBack()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.framework.AiAppsBaseFrame
    public void onBackPressed() {
        AiAppsLog.d(AiApp.MODEL_TAG, "onBackPressed back stack count:" + this.mFragmentManager.getFragmentCount());
        AiAppsUBCStatistic.AiAppsUBCEvent aiAppsUBCEvent = new AiAppsUBCStatistic.AiAppsUBCEvent();
        aiAppsUBCEvent.mValue = AiAppsUBCStatistic.VALUE_BACK;
        doUBCEventStatistic(aiAppsUBCEvent);
        AiAppsBaseFragment topFragment = this.mFragmentManager.getTopFragment();
        if (topFragment == null || !topFragment.handleBackPressed()) {
            if (handleTaskToBack()) {
                AiApp aiApp = AiApp.get();
                if (aiApp != null) {
                    aiApp.getBackgroundPlayer().release();
                }
                HashMap hashMap = new HashMap();
                hashMap.put(AiAppsLifecycleMessage.EVENT_TYPE_KEY, AiAppsLifecycleMessage.TYPE_APP_BACK);
                hashMap.put(AiAppsLifecycleMessage.APP_ID_KEY, AiApp.getAiAppId());
                AiAppsController.getInstance().sendJSMessage(new AiAppsLifecycleMessage(hashMap));
                AiAppsLog.d(TAG, AiAppsLifecycleMessage.TYPE_APP_BACK);
                return;
            }
            this.mFragmentManager.createTransaction(AiAppsRouteMessage.TYPE_NAVIGATE_BACK).setCustomAnimations(AiAppsFragmentManager.ANIM_HOLD, AiAppsFragmentManager.ANIM_EXIT).popFragment().commit();
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.framework.AiAppsBaseFrame
    @NonNull
    protected AiAppsMessengerClient.OnHandleMessageCallback getMessageCallback() {
        return new AiAppsMessengerClient.OnHandleMessageCallback() { // from class: com.baidu.searchbox.ng.ai.apps.framework.apps.AiAppsFrame.1
            @Override // com.baidu.searchbox.ng.ai.apps.process.AiAppsMessengerClient.OnHandleMessageCallback
            public boolean onHandleMessage(Message message) {
                switch (message.what) {
                    case 100:
                        AiAppsFrame.this.mClient.sendMessage(4);
                        AiAppsFrame.this.syncBdussCookie();
                        AiAppsFrame.this.reset();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = AiAppNightModeHelper.getNightModeSwitcherState();
                        AiAppNightModeHelper.forceSyncNightModeState(nightModeSwitcherState);
                        AiAppsFrame.this.onNightModeCoverChanged(nightModeSwitcherState, false);
                        return true;
                    case 103:
                        AiApp aiApp = AiApp.get();
                        if (aiApp != null) {
                            aiApp.getSetting().clear();
                        }
                        AiAppsFrame.this.syncBdussCookie();
                        return true;
                    case 104:
                        PagesRoute.getInstance().onSubPackageDownLoadFailed((Bundle) message.obj);
                        return true;
                    case 105:
                        PagesRoute.getInstance().onSubPackageDownloadSuccess((Bundle) message.obj);
                        return true;
                    case 106:
                        AiAppsFrame.this.reset();
                        return true;
                    case AiAppsMessengerService.MSG_TYPE_SC_IM_REGISTER_CALLBACK /* 211 */:
                        AiAppImClientManager.getIns().registerImCallback(message.obj);
                        return true;
                    case AiAppsMessengerService.MSG_TYPE_SC_IM_SEND_MSG_CALLBACK /* 212 */:
                        AiAppImClientManager.getIns().sendOrFetchImMsgCallback(true, message.obj);
                        return true;
                    case AiAppsMessengerService.MSG_TYPE_SC_IM_PULL_MSG_CALLBACK /* 213 */:
                        AiAppImClientManager.getIns().sendOrFetchImMsgCallback(false, message.obj);
                        return true;
                    default:
                        return false;
                }
            }
        };
    }

    @Override // com.baidu.searchbox.ng.ai.apps.framework.AiAppsBaseFrame
    public boolean finish() {
        return hookNavigationFragment();
    }

    private boolean hookNavigationFragment() {
        if (AiAppsRuntime.getMapRuntime().isTopWalkNavFragment()) {
            this.mFragmentManager.createTransaction(AiAppsRouteMessage.TYPE_NAVIGATE_BACK).setCustomAnimations(AiAppsFragmentManager.ANIM_HOLD, AiAppsFragmentManager.ANIM_EXIT).popFragment().commit();
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.framework.AiAppsBaseFrame
    public void onDestroy() {
        AiAppsScreenshot.unRegisterScreenshotEvent();
        AiAppsMonitor.getInstance().stopMonitor();
        AiAppsController.getInstance().unregistReceiver(this.mActivity);
        AiAppsController.getInstance().setActivityRef(null);
        AiAppsController.release();
        super.onDestroy();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.framework.AiAppsBaseFrame
    public void onNightModeCoverChanged(boolean z) {
        onNightModeCoverChanged(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNightModeCoverChanged(boolean z, boolean z2) {
        if (this.mActivity != null && this.mActivity.getWindow() != null) {
            if (this.mSkinDecorator == null) {
                this.mSkinDecorator = new AiAppsSkinDecorator();
            }
            ViewGroup viewGroup = (ViewGroup) this.mActivity.getWindow().getDecorView();
            if (z) {
                this.mSkinDecorator.decorateNightModeCover(viewGroup);
            } else {
                this.mSkinDecorator.removeNightModeCover(viewGroup);
            }
            if (z2) {
                this.mClient.sendMessage(5);
            }
        }
    }

    private String getLaunchPageUrl() {
        if (this.mLaunchInfo != null) {
            String str = this.mLaunchInfo.mPage;
            String pageInfo = AiAppsLaunchInfo.getPageInfo(this.mLaunchInfo, AiAppsController.getInstance().getConfigData());
            this.mLaunchInfo.mPage = str;
            return pageInfo;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void syncBdussCookie() {
        AiAppsCoreUtils.syncBdussCookie(this.mActivity);
    }

    private void onLaunchSuccessUBC() {
        Bundle bundle = this.mLaunchInfo.mExtraData;
        if (bundle != null && bundle.getLong(AiAppsUBCStatistic.EXT_KEY_LAUNCH_FLAG) > 0) {
            AiAppsUBCStatistic.AiAppsUBCEvent aiAppsUBCEvent = new AiAppsUBCStatistic.AiAppsUBCEvent();
            aiAppsUBCEvent.mAppId = this.mLaunchInfo.mAppId;
            aiAppsUBCEvent.mSource = this.mLaunchInfo.mLaunchFrom;
            aiAppsUBCEvent.mType = AiAppsUBCStatistic.TYPE_LAUNCH;
            aiAppsUBCEvent.mValue = "success";
            AiAppsUBCStatistic.onEvent(aiAppsUBCEvent);
            bundle.remove(AiAppsUBCStatistic.EXT_KEY_LAUNCH_FLAG);
        }
    }

    private void onLaunchSuccessForSearchUBC(boolean z) {
        AiAppsSearchFlowUBC.recordFromLaunch(this.mLaunchInfo);
        if (z) {
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent(SearchFlowEvent.ID_DOM_FIRST_PAINT);
            searchFlowEvent.eventType = SearchFlowEvent.EventType.END;
            AiAppsSearchFlowUBC.addEvent(searchFlowEvent);
        }
    }

    private void updateInvalidSwanCore() {
        if (this.mLaunchInfo.mSwanCoreVersion == null || !this.mLaunchInfo.mSwanCoreVersion.isAvailable()) {
            this.mLaunchInfo.mSwanCoreVersion = AiAppsSwanCoreManager.getSwanCoreVersionIPC();
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.framework.AiAppsBaseFrame
    protected void onFragmentManagerCreated() {
        this.mFragmentManager.setFragmentOpListener(this);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragmentManager.FragmentOpListener
    public void onFragmentAdd() {
        AiAppsMonitor.getInstance().startMonitor(this.mActivity);
    }
}
