package com.baidu.searchbox.ng.ai.apps.scheme.actions.interaction;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.AiAppsActivity;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragmentManager;
import com.baidu.searchbox.ng.ai.apps.res.widget.floatlayer.FloatLayer;
import com.baidu.searchbox.ng.ai.apps.res.widget.loadingview.LoadingView;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes2.dex */
public class HideLoadingAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/hideLoading";
    private static final String MODULE_TAG = "hideLoading";
    protected static final String TAG = "HideLoadingAction";

    public HideLoadingAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        if (!(context instanceof AiAppsActivity)) {
            AiAppsLog.e(MODULE_TAG, "context not support");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "context not support");
            return false;
        }
        AiAppsFragmentManager aiAppsFragmentManager = ((AiAppsActivity) context).getAiAppsFragmentManager();
        if (aiAppsFragmentManager == null) {
            AiAppsLog.e(MODULE_TAG, "none fragmentManger");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none fragmentManger");
            return false;
        }
        AiAppsBaseFragment topFragment = aiAppsFragmentManager.getTopFragment();
        if (!(topFragment instanceof FloatLayer.Holder)) {
            AiAppsLog.e(MODULE_TAG, "fragment not support");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragment not support");
            return false;
        }
        FloatLayer floatLayer = ((FloatLayer.Holder) topFragment).getFloatLayer();
        if (floatLayer.getView() instanceof LoadingView) {
            floatLayer.reset();
        }
        AiAppsLog.i(MODULE_TAG, "hide loading success");
        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }
}
