package com.baidu.searchbox.ng.ai.apps.scheme.actions.route;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragment;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragmentManager;
import com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlavePool;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.model.AiAppsPageParam;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes2.dex */
public class SwitchTabAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/switchTab";
    private static final boolean DEBUG = false;
    private static final String MODULE_TAG = "switchTab";
    private static final String TAG = "SwitchTabAction";

    public SwitchTabAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        String parseUrlParams = ActionUtils.parseUrlParams(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(parseUrlParams)) {
            AiAppsLog.e("switchTab", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        AiAppsController aiAppsController = AiAppsController.getInstance();
        final AiAppsFragmentManager aiAppsFragmentManager = aiAppsController.getAiAppsFragmentManager();
        if (aiAppsFragmentManager == null) {
            AiAppsLog.e("switchTab", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final AiAppsPageParam createObject = AiAppsPageParam.createObject(parseUrlParams, aiAppsController.getBaseUrl());
        if (!AiAppsUtils.checkTabParams(aiAppsController.getConfigData(), createObject)) {
            AiAppsLog.e("switchTab", "tab params error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        AiAppsFragment tabFragment = aiAppsFragmentManager.getTabFragment();
        if (tabFragment == null || TextUtils.isEmpty(tabFragment.getTabWebViewId(createObject.mPage))) {
            final AiAppsSlavePool.PreloadSlaveManager preloadSlaveManager = AiAppsSlavePool.getPreloadSlaveManager(aiAppsController.getActivity());
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(ActionUtils.buildRouteJSONData(preloadSlaveManager.slaveManager.getWebViewId()), 0));
            AiAppsSlavePool.requestPreloadOnReady(preloadSlaveManager, new AiAppsSlavePool.PreloadStatusCallback() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.route.SwitchTabAction.1
                @Override // com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlavePool.PreloadStatusCallback
                public void onReady() {
                    ActionUtils.createAndLoadPage(preloadSlaveManager.slaveManager, createObject);
                    SwitchTabAction.this.doSwitchTab(aiAppsFragmentManager, createObject);
                }
            });
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(ActionUtils.buildRouteJSONData(tabFragment.getTabWebViewId(createObject.mPage)), 0));
            doSwitchTab(aiAppsFragmentManager, createObject);
        }
        AiAppsLog.i("switchTab", "create and load page");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSwitchTab(AiAppsFragmentManager aiAppsFragmentManager, AiAppsPageParam aiAppsPageParam) {
        aiAppsFragmentManager.createTransaction("switchTab").setCustomAnimations(0, 0).popNonTabFragments().switchFragmentTab(aiAppsPageParam).commitNow();
    }
}
