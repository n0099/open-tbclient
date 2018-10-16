package com.baidu.searchbox.ng.ai.apps.scheme.actions.route;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.AiAppsActivity;
import com.baidu.searchbox.ng.ai.apps.console.ConsoleController;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragmentManager;
import com.baidu.searchbox.ng.ai.apps.core.master.AiAppsMasterManager;
import com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlaveManager;
import com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlavePool;
import com.baidu.searchbox.ng.ai.apps.core.turbo.AppReadyEvent;
import com.baidu.searchbox.ng.ai.apps.core.turbo.PageReadyEvent;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsRouteMessage;
import com.baidu.searchbox.ng.ai.apps.install.AiAppsBundleHelper;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchInfo;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.model.AiAppsPageParam;
import com.baidu.searchbox.ng.ai.apps.performance.AiAppsPerformanceUBC;
import com.baidu.searchbox.ng.ai.apps.performance.UbcFlowEvent;
import com.baidu.searchbox.ng.ai.apps.runtime.config.WindowConfig;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.LaunchAction;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUrlUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
/* loaded from: classes2.dex */
public class FirstPageAction {
    private static final boolean DEBUG = false;
    private static final String TAG = "FirstPageAction";

    public static void startFirstPage(AiAppsMasterManager aiAppsMasterManager, AiAppsSlaveManager aiAppsSlaveManager, AiAppsLaunchInfo aiAppsLaunchInfo, AiAppsBundleHelper.AiAppsLoadInfo aiAppsLoadInfo) {
        AiAppsController aiAppsController = AiAppsController.getInstance();
        String firstPageUrl = getFirstPageUrl(aiAppsController);
        AiAppsActivity activity = aiAppsController.getActivity();
        if (activity != null && !activity.isFinishing()) {
            aiAppsMasterManager.attachContextToBridge(activity);
            AppReadyEvent appReadyEvent = new AppReadyEvent();
            appReadyEvent.appConfig = aiAppsLoadInfo.mConfigData.mOriginAppData;
            aiAppsLoadInfo.mConfigData.mOriginAppData = null;
            appReadyEvent.appPath = aiAppsLoadInfo.mAppBundlePath;
            appReadyEvent.webviewId = aiAppsSlaveManager.getWebViewId();
            appReadyEvent.pageUrl = firstPageUrl;
            appReadyEvent.sConsole = String.valueOf(ConsoleController.isConsoleEnabled());
            Bundle bundle = aiAppsLaunchInfo.mExtraData;
            if (bundle != null) {
                String string = bundle.getString(LaunchAction.PARAM_EXTRA_DATA_KEY);
                if (!TextUtils.isEmpty(string)) {
                    appReadyEvent.extraData = string;
                }
            }
            AiAppsPerformanceUBC.requireSession().record(new UbcFlowEvent(AiAppsPerformanceUBC.ACTION_MASTER_DISPATCH_START));
            aiAppsController.sendJSMessage(AppReadyEvent.createAppReadyMessage(appReadyEvent));
            WindowConfig pageWindowConfig = aiAppsController.getPageWindowConfig(AiAppsUrlUtils.delAllParamsFromUrl(firstPageUrl));
            aiAppsSlaveManager.attachContextToBridge(activity);
            PageReadyEvent pageReadyEvent = new PageReadyEvent();
            pageReadyEvent.appPath = aiAppsLoadInfo.mAppBundlePath;
            pageReadyEvent.pagePath = firstPageUrl;
            pageReadyEvent.onReachBottomDistance = pageWindowConfig.mOnReachBottomDistance;
            pageReadyEvent.sConsole = String.valueOf(ConsoleController.isConsoleEnabled());
            AiAppsPerformanceUBC.requireSession().record(new UbcFlowEvent(AiAppsPerformanceUBC.ACTION_SLAVE_DISPATCH_START));
            aiAppsController.sendJSMessage(aiAppsSlaveManager.getWebViewId(), PageReadyEvent.createPageReadyMessage(pageReadyEvent));
            if (aiAppsController.getAiAppsFragmentManager() != null) {
                AiAppsPageParam createObject = AiAppsPageParam.createObject(firstPageUrl, aiAppsController.getBaseUrl());
                AiAppsSlavePool.putSlaveManager(AiAppsUtils.buildPageUrl(createObject.mBaseUrl, createObject.mPage, createObject.mParams), aiAppsSlaveManager);
                pushFirstPageFragment(activity, firstPageUrl);
                activity.getLoadingView().startLoadFinishAnimator();
                AiAppsUBCStatistic.onPagesRoute(true, aiAppsLaunchInfo.mLaunchFrom);
            }
        }
    }

    public static void pushFirstPageFragment(AiAppsActivity aiAppsActivity, String str) {
        aiAppsActivity.getAiAppsFragmentManager().createTransaction(AiAppsRouteMessage.TYPE_INIT).setCustomAnimations(AiAppsFragmentManager.ANIM_HOLD, AiAppsFragmentManager.ANIM_HOLD).popAllFragments().pushFragment("normal", AiAppsPageParam.createObject(str, AiAppsController.getInstance().getBaseUrl())).commit();
    }

    public static String getFirstPageUrl(AiAppsController aiAppsController) {
        String launchUrl = aiAppsController.getLaunchUrl();
        if (TextUtils.isEmpty(launchUrl)) {
            return aiAppsController.getFirstPageUrl();
        }
        return launchUrl;
    }
}
