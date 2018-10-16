package com.baidu.searchbox.ng.ai.apps.scheme.actions.navigationbar;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragmentManager;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.runtime.config.AiAppsConfigData;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SetNavigationBarColorAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/setNavigationBarColor";
    private static final String ANIMATION = "animation";
    private static final String BACKGROUND_COLOR = "backgroundColor";
    private static final boolean DEBUG = false;
    private static final String DURATION = "duration";
    private static final String FRONT_COLOR = "frontColor";
    private static final String MODULE_TAG = "navigationColor";
    private static final String TAG = "BarColorAction";
    private static final String TIMING_FUNC = "timingFunc";

    public SetNavigationBarColorAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        AiAppsFragmentManager aiAppsFragmentManager = AiAppsController.getInstance().getAiAppsFragmentManager();
        if (aiAppsFragmentManager == null) {
            AiAppsLog.e(MODULE_TAG, "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (optParamsAsJo == null) {
            AiAppsLog.e(MODULE_TAG, "paramsJson is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            String optString = optParamsAsJo.optString(FRONT_COLOR);
            String optString2 = optParamsAsJo.optString(BACKGROUND_COLOR);
            JSONObject optJSONObject = optParamsAsJo.optJSONObject(ANIMATION);
            AiAppsBaseFragment topFragment = aiAppsFragmentManager.getTopFragment();
            if (!topFragment.setNavigationBarFrontColor(optString)) {
                AiAppsLog.e(MODULE_TAG, "set title color fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!topFragment.setActionBarBackgroundColor(AiAppsConfigData.parseColor(optString2))) {
                AiAppsLog.e(MODULE_TAG, "set title background fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                if (optJSONObject != null) {
                    topFragment.setActionBarAnimator(optJSONObject.optInt("duration"), optJSONObject.optString(TIMING_FUNC));
                    AiAppsLog.i(MODULE_TAG, "set action bar animator");
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        }
    }
}
