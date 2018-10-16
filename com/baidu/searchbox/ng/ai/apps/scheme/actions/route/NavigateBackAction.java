package com.baidu.searchbox.ng.ai.apps.scheme.actions.route;

import android.content.Context;
import android.text.TextUtils;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class NavigateBackAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/navigateBack";
    private static final boolean DEBUG = false;
    private static final int DEFAULT_DELTA = 1;
    private static final String MODULE_TAG = "navigateBack";
    private static final String TAG = "NavigateBackAction";

    public NavigateBackAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        int optInt;
        String str = unitedSchemeEntity.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            optInt = 1;
        } else {
            try {
                optInt = new JSONObject(str).optInt("delta", 1);
            } catch (JSONException e) {
                AiAppsLog.e("navigateBack", "params parse fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
        }
        AiAppsFragmentManager aiAppsFragmentManager = AiAppsController.getInstance().getAiAppsFragmentManager();
        if (aiAppsFragmentManager == null) {
            AiAppsLog.e("navigateBack", "fragmentManager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        if (optInt >= aiAppsFragmentManager.getFragmentCount()) {
            optInt = aiAppsFragmentManager.getFragmentCount() - 1;
        }
        aiAppsFragmentManager.createTransaction("navigateBack").setCustomAnimations(AiAppsFragmentManager.ANIM_HOLD, AiAppsFragmentManager.ANIM_EXIT).popFragment(optInt).commit();
        if (!(aiAppsFragmentManager.getTopFragment() instanceof AiAppsFragment)) {
            AiAppsLog.e("navigateBack", "top fragment error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        AiAppsFragment aiAppsFragment = (AiAppsFragment) aiAppsFragmentManager.getTopFragment();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(ActionUtils.buildRouteJSONData(aiAppsFragment != null ? aiAppsFragment.getSlaveWebViewId() : ""), 0));
        return true;
    }
}
