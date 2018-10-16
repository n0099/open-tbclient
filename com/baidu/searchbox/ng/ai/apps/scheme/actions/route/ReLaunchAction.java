package com.baidu.searchbox.ng.ai.apps.scheme.actions.route;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragmentManager;
import com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlavePool;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsRouteMessage;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.model.AiAppsPageParam;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.route.PagesRoute;
import com.baidu.searchbox.ng.ai.apps.util.AiAppJSONUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes2.dex */
public class ReLaunchAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/reLaunch";
    private static final boolean DEBUG = false;
    private static final String MODULE_TAG = "relaunch";
    private static final String TAG = "ReLaunchAction";

    public ReLaunchAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final AiApp aiApp) {
        String parseUrlParams = ActionUtils.parseUrlParams(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(parseUrlParams)) {
            AiAppsLog.e(MODULE_TAG, "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final AiAppsController aiAppsController = AiAppsController.getInstance();
        final AiAppsFragmentManager aiAppsFragmentManager = aiAppsController.getAiAppsFragmentManager();
        if (aiAppsFragmentManager == null) {
            AiAppsLog.e(MODULE_TAG, "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final AiAppsPageParam createObject = AiAppsPageParam.createObject(parseUrlParams, aiAppsController.getBaseUrl());
        if (!AiAppsUtils.checkPageParams(aiAppsController.getConfigData(), createObject, true)) {
            AiAppsLog.e(MODULE_TAG, "page params error : pageParam=" + createObject.mPage);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final AiAppsSlavePool.PreloadSlaveManager preloadSlaveManager = AiAppsSlavePool.getPreloadSlaveManager(aiAppsController.getActivity());
        final String webViewId = preloadSlaveManager.slaveManager.getWebViewId();
        final String optString = AiAppJSONUtils.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            AiAppsLog.e(MODULE_TAG, "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        aiAppsController.showLoadingView();
        PagesRoute.getInstance().checkPages(aiApp, createObject.mPage, webViewId, new PagesRoute.CheckPagesCallback() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.route.ReLaunchAction.1
            @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.route.PagesRoute.CheckPagesCallback
            public void success(String str) {
                AiAppsLog.i(ReLaunchAction.MODULE_TAG, "check pages success");
                aiAppsController.removeLoadingView();
                ActionUtils.onPagesRouteSuccess(unitedSchemeEntity, callbackHandler, aiApp, webViewId, createObject.mPage, optString);
                ReLaunchAction.this.executePageRoute(preloadSlaveManager, createObject, aiAppsFragmentManager);
            }

            @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.route.PagesRoute.CheckPagesCallback
            public void failed(int i) {
                AiAppsLog.e(ReLaunchAction.MODULE_TAG, "check pages failed");
                aiAppsController.removeLoadingView();
                ActionUtils.onPagesRouteFailed(unitedSchemeEntity, callbackHandler, optString);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executePageRoute(final AiAppsSlavePool.PreloadSlaveManager preloadSlaveManager, final AiAppsPageParam aiAppsPageParam, final AiAppsFragmentManager aiAppsFragmentManager) {
        AiAppsSlavePool.requestPreloadOnReady(preloadSlaveManager, new AiAppsSlavePool.PreloadStatusCallback() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.route.ReLaunchAction.2
            @Override // com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlavePool.PreloadStatusCallback
            public void onReady() {
                ActionUtils.createAndLoadPage(preloadSlaveManager.slaveManager, aiAppsPageParam);
                ReLaunchAction.doReLaunch(aiAppsFragmentManager, aiAppsPageParam);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doReLaunch(AiAppsFragmentManager aiAppsFragmentManager, AiAppsPageParam aiAppsPageParam) {
        aiAppsFragmentManager.createTransaction(AiAppsRouteMessage.TYPE_RE_LAUNCH).setCustomAnimations(0, 0).popAllFragments().pushFragment("normal", aiAppsPageParam).commitNow();
    }
}
