package com.baidu.searchbox.ng.ai.apps.tabbar.action;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.R;
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
public class SetTabBarBadgeAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/setTabBarBadge";
    protected static final boolean DEBUG = false;
    private static final String INDEX = "index";
    private static final int MAX_BADGE_LENGTH = 3;
    private static final String MODULE_TAG = "setTabBarBadge";
    protected static final String TAG = "SetTabBarBadgeAction";
    private static final String TEXT = "text";

    public SetTabBarBadgeAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
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
        String optString = optParamsAsJo.optString("text");
        AiAppsFragmentManager aiAppsFragmentManager = AiAppsController.getInstance().getAiAppsFragmentManager();
        if (aiAppsFragmentManager == null) {
            AiAppsLog.e(MODULE_TAG, "fragmentManager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        if (optString.length() > 3) {
            optString = context.getString(R.string.aiapps_tabbar_badge_over_length);
        }
        if (!aiAppsFragmentManager.getTopAiAppsFragment().getAiAppsBottomBarViewController().setBottomBadge(optInt, optString)) {
            AiAppsLog.e(MODULE_TAG, "set bottom badge fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }
}
