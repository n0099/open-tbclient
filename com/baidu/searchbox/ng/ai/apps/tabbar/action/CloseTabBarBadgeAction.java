package com.baidu.searchbox.ng.ai.apps.tabbar.action;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragmentManager;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CloseTabBarBadgeAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/closeTabBarBadge";
    protected static final boolean DEBUG = false;
    private static final String INDEX = "index";
    private static final String MODULE_TAG = "closeTabBarBadge";
    protected static final String TAG = "CloseTabBarBadgeAction";

    public CloseTabBarBadgeAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            AiAppsLog.e(MODULE_TAG, "paramsJson is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        int optInt = optParamsAsJo.optInt("index");
        AiAppsFragmentManager aiAppsFragmentManager = AiAppsController.getInstance().getAiAppsFragmentManager();
        if (aiAppsFragmentManager == null) {
            AiAppsLog.e(MODULE_TAG, "fragmentManager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!aiAppsFragmentManager.getTopAiAppsFragment().getAiAppsBottomBarViewController().closeBottomBadge(optInt)) {
            AiAppsLog.e(MODULE_TAG, "close bottom badge fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }
}
