package com.baidu.searchbox.ng.ai.apps.scheme.actions.www;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlaveManager;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes2.dex */
public class InsertWebViewAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/insertWebView";
    private static final String MODULE_TAG = "insertWebView";
    private static final String TAG = "InsertWebViewAction";

    public InsertWebViewAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        WWWParams parseWWWParams = WWWParams.parseWWWParams(unitedSchemeEntity);
        if (!parseWWWParams.isValid()) {
            AiAppsLog.e(MODULE_TAG, "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
        } else {
            AiAppsSlaveManager aiAppsSlaveManager = (AiAppsSlaveManager) AiAppsController.getInstance().getWebViewManager(parseWWWParams.slaveId);
            if (aiAppsSlaveManager == null) {
                AiAppsLog.e(MODULE_TAG, "viewManager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            } else if (!aiAppsSlaveManager.insertWebViewWidget(parseWWWParams)) {
                AiAppsLog.e(MODULE_TAG, "insert webview widget fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            } else {
                AiAppsLog.i(MODULE_TAG, "insert webview widget success");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            }
        }
        return true;
    }
}
