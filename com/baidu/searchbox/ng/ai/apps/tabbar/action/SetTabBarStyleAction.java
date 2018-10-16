package com.baidu.searchbox.ng.ai.apps.tabbar.action;

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
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SetTabBarStyleAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/setTabBarStyle";
    private static final String BACKGROUND_COLOR = "backgroundColor";
    private static final String BORDER_STYLE = "borderStyle";
    private static final String COLOR = "color";
    protected static final boolean DEBUG = false;
    private static final String MODULE_TAG = "setTabBarStyle";
    private static final String SELECTED_COLOR = "selectedColor";
    protected static final String TAG = "SetTabBarStyleAction";

    public SetTabBarStyleAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        AiAppsController aiAppsController = AiAppsController.getInstance();
        if (optParamsAsJo == null) {
            AiAppsLog.e(MODULE_TAG, "paramsJson is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        AiAppsFragmentManager aiAppsFragmentManager = aiAppsController.getAiAppsFragmentManager();
        if (aiAppsFragmentManager == null) {
            AiAppsLog.e(MODULE_TAG, "fragmentManager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        AiAppsFragment topAiAppsFragment = aiAppsFragmentManager.getTopAiAppsFragment();
        if (!topAiAppsFragment.getAiAppsBottomBarViewController().changeBottomBarStyle(optParamsAsJo.optString(COLOR), optParamsAsJo.optString(SELECTED_COLOR), optParamsAsJo.optString(BACKGROUND_COLOR), optParamsAsJo.optString(BORDER_STYLE))) {
            AiAppsLog.e(MODULE_TAG, "set bottom bar style fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }
}
