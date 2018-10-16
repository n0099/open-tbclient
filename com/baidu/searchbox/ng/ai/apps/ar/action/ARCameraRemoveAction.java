package com.baidu.searchbox.ng.ai.apps.ar.action;

import android.app.Activity;
import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.ar.model.ARCameraAttr;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.view.container.AiAppsNAViewContainer;
import com.baidu.searchbox.ng.ai.apps.view.container.util.NAViewFinder;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes2.dex */
public class ARCameraRemoveAction extends AbsARAction {
    private static final String ACTION_TYPE = "/swan/ARCamera/remove";

    public ARCameraRemoveAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        if (!(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        ARCameraAttr parseData = parseData(unitedSchemeEntity);
        if (AiAppsController.getInstance().getBdWebViewBySlaveId(parseData.slaveId) != null && parseData != null) {
            AiAppsNAViewContainer findNAViewContainer = NAViewFinder.findNAViewContainer(parseData, null);
            if (findNAViewContainer != null) {
                findNAViewContainer.removeView();
            }
            callback(unitedSchemeEntity, callbackHandler, true);
            return true;
        }
        callback(unitedSchemeEntity, callbackHandler, false);
        return false;
    }
}
