package com.baidu.searchbox.ng.ai.apps.scheme.actions.route;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragmentManager;
import com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlaveManager;
import com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlavePool;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.model.AiAppsPageParam;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.route.PagesRoute;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.searchbox.ng.ai.apps.util.AiAppJSONUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes2.dex */
public class NavigateToAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/navigateTo";
    private static final boolean DEBUG = false;
    private static final String MODULE_TAG = "navigateTo";
    private static final int NAVIGATE_MAX_COUNT = AiAppsRuntime.getAiAppAbTestRuntime().getAiAppsNavigateMaxValue();
    private static final String TAG = "NavigateToAction";

    public NavigateToAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final AiApp aiApp) {
        String parseUrlParams = ActionUtils.parseUrlParams(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(parseUrlParams)) {
            AiAppsLog.e("navigateTo", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        final AiAppsController aiAppsController = AiAppsController.getInstance();
        final AiAppsFragmentManager aiAppsFragmentManager = aiAppsController.getAiAppsFragmentManager();
        if (aiAppsFragmentManager == null) {
            AiAppsLog.e("navigateTo", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final AiAppsPageParam createObject = AiAppsPageParam.createObject(parseUrlParams, aiAppsController.getBaseUrl());
        if (!AiAppsUtils.checkPageParams(aiAppsController.getConfigData(), createObject, false)) {
            AiAppsLog.e("navigateTo", "page params error : pageParam=" + createObject.mPage);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        final AiAppsSlavePool.PreloadSlaveManager preloadSlaveManager = AiAppsSlavePool.getPreloadSlaveManager(aiAppsController.getActivity());
        final String webViewId = preloadSlaveManager.slaveManager.getWebViewId();
        final String optString = AiAppJSONUtils.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            AiAppsLog.e("navigateTo", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        aiAppsController.showLoadingView();
        PagesRoute.getInstance().checkPages(aiApp, createObject.mPage, webViewId, new PagesRoute.CheckPagesCallback() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.route.NavigateToAction.1
            @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.route.PagesRoute.CheckPagesCallback
            public void success(String str) {
                AiAppsLog.i("navigateTo", "check pages success");
                AiAppsUBCStatistic.onPagesRoute(true, aiApp.getLaunchInfo().mLaunchFrom);
                aiAppsController.removeLoadingView();
                ActionUtils.onPagesRouteSuccess(unitedSchemeEntity, callbackHandler, aiApp, webViewId, createObject.mPage, optString);
                NavigateToAction.this.tryToExecutePageRoute(preloadSlaveManager, createObject, aiAppsFragmentManager);
            }

            @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.route.PagesRoute.CheckPagesCallback
            public void failed(int i) {
                AiAppsLog.e("navigateTo", "check pages failed");
                AiAppsUBCStatistic.onPagesRoute(false, aiApp.getLaunchInfo().mLaunchFrom);
                aiAppsController.removeLoadingView();
                ActionUtils.onPagesRouteFailed(unitedSchemeEntity, callbackHandler, optString);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryToExecutePageRoute(final AiAppsSlavePool.PreloadSlaveManager preloadSlaveManager, final AiAppsPageParam aiAppsPageParam, final AiAppsFragmentManager aiAppsFragmentManager) {
        AiAppsSlavePool.requestPreloadOnReady(preloadSlaveManager, new AiAppsSlavePool.PreloadStatusCallback() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.route.NavigateToAction.2
            @Override // com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlavePool.PreloadStatusCallback
            public void onReady() {
                NavigateToAction.this.executePageRoute(preloadSlaveManager.slaveManager, aiAppsPageParam, aiAppsFragmentManager);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executePageRoute(AiAppsSlaveManager aiAppsSlaveManager, AiAppsPageParam aiAppsPageParam, AiAppsFragmentManager aiAppsFragmentManager) {
        ActionUtils.createAndLoadPage(aiAppsSlaveManager, aiAppsPageParam);
        if (aiAppsFragmentManager.getFragmentCount() < NAVIGATE_MAX_COUNT) {
            aiAppsFragmentManager.createTransaction("navigateTo").setCustomAnimations(AiAppsFragmentManager.ANIM_ENTER, AiAppsFragmentManager.ANIM_HOLD).pushFragment("normal", aiAppsPageParam).commitNow();
        } else {
            RedirectToAction.doRedirectTo(aiAppsFragmentManager, aiAppsPageParam);
        }
    }
}
