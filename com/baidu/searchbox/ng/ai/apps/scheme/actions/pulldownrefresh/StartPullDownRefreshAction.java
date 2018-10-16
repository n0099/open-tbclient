package com.baidu.searchbox.ng.ai.apps.scheme.actions.pulldownrefresh;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragment;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragmentManager;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes2.dex */
public class StartPullDownRefreshAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/startPullDownRefresh";
    private static final long DELAY_MILL_IS = 100;
    private static final String MODULE_TAG = "startPullDownRefresh";

    public StartPullDownRefreshAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        AiAppsFragmentManager aiAppsFragmentManager = AiAppsController.getInstance().getAiAppsFragmentManager();
        if (aiAppsFragmentManager == null) {
            AiAppsLog.e(MODULE_TAG, "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!(aiAppsFragmentManager.getTopFragment() instanceof AiAppsFragment)) {
            AiAppsLog.e(MODULE_TAG, "top fragment error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            AiAppsFragment aiAppsFragment = (AiAppsFragment) aiAppsFragmentManager.getTopFragment();
            if (aiAppsFragment.getPullToRefreshWebView() == null) {
                AiAppsLog.e(MODULE_TAG, "view is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            AiAppsLog.i(MODULE_TAG, "start pull refresh");
            aiAppsFragment.getPullToRefreshWebView().doPullRefreshing(true, DELAY_MILL_IS);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
