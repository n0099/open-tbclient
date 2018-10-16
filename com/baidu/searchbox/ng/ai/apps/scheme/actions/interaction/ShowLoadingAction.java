package com.baidu.searchbox.ng.ai.apps.scheme.actions.interaction;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
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
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ShowLoadingAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/showLoading";
    private static final String MODULE_TAG = "showLoading";
    protected static final String TAG = "ShowLoadingAction";

    public ShowLoadingAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        LoadingView loadingView;
        if (!(context instanceof AiAppsActivity)) {
            AiAppsLog.e(MODULE_TAG, "context not support");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "context not support");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            AiAppsLog.e(MODULE_TAG, "none params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        AiAppsLog.i(MODULE_TAG, "handleShowLoading : joParams = \n" + optParamsAsJo);
        String optString = optParamsAsJo.optString("title");
        if (TextUtils.isEmpty(optString)) {
            AiAppsLog.e(MODULE_TAG, "none title");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        boolean optBoolean = optParamsAsJo.optBoolean("mask", false);
        AiAppsFragmentManager aiAppsFragmentManager = ((AiAppsActivity) context).getAiAppsFragmentManager();
        if (aiAppsFragmentManager == null) {
            AiAppsLog.e(MODULE_TAG, "none fragment");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none fragment");
            return false;
        }
        AiAppsBaseFragment topFragment = aiAppsFragmentManager.getTopFragment();
        if (!(topFragment instanceof FloatLayer.Holder)) {
            AiAppsLog.e(MODULE_TAG, "fragment not support");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragment not support");
            return false;
        }
        FloatLayer floatLayer = ((FloatLayer.Holder) topFragment).getFloatLayer();
        View view = floatLayer.getView();
        if (view instanceof LoadingView) {
            loadingView = (LoadingView) view;
        } else {
            loadingView = new LoadingView(context);
            floatLayer.show(loadingView);
        }
        if (!TextUtils.isEmpty(optString)) {
            loadingView.setMsg(optString);
        }
        floatLayer.setMask(optBoolean);
        AiAppsLog.i(MODULE_TAG, "show loading success");
        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }
}
