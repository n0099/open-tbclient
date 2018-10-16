package com.baidu.searchbox.ng.ai.apps.adlanding;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragmentManager;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.model.AiAppsPageParam;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.route.ActionUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes2.dex */
public class AdLandingAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/openAdWebPage";
    private static final boolean DEBUG = false;
    public static final String MODULE_TAG = "AdLanding";
    private static final String TAG = "AdLandingAction";

    public AdLandingAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        String parseUrlParams = ActionUtils.parseUrlParams(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(parseUrlParams)) {
            AiAppsLog.i(MODULE_TAG, "adLanding: url is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        AiAppsFragmentManager aiAppsFragmentManager = AiAppsController.getInstance().getAiAppsFragmentManager();
        if (aiAppsFragmentManager == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        openAdLanding(AiAppsPageParam.createObject(parseUrlParams, parseUrlParams), aiAppsFragmentManager);
        AiAppsLog.i(MODULE_TAG, "open adLanding page success");
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    private void openAdLanding(AiAppsPageParam aiAppsPageParam, AiAppsFragmentManager aiAppsFragmentManager) {
        AiAppsLog.i(MODULE_TAG, "openAdLanding: page url=" + aiAppsPageParam.mBaseUrl);
        aiAppsFragmentManager.createTransaction("adLanding").setCustomAnimations(AiAppsFragmentManager.ANIM_ENTER, AiAppsFragmentManager.ANIM_HOLD).pushFragment("adLanding", aiAppsPageParam).commitNow();
    }
}
