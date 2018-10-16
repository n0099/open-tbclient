package com.baidu.searchbox.ng.ai.apps.textarea.action;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.textarea.info.TextAreaStatusInfo;
import com.baidu.searchbox.ng.ai.apps.textarea.parser.TextAreaBaseParser;
import com.baidu.searchbox.ng.ai.apps.textarea.parser.TextAreaSecondaryParser;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CloseTextAreaAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/closeTextarea";
    private static final String TAG = "CloseTextAreaAction";

    public CloseTextAreaAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        AiAppsLog.d(TAG, "closeTextAreaAction paramsJson: " + optParamsAsJo);
        String optString = optParamsAsJo.optString(TextAreaStatusInfo.ID);
        String optString2 = optParamsAsJo.optString("slaveId");
        String optString3 = optParamsAsJo.optString(AiAppsNaViewModel.KEY_PARENT_ID);
        TextAreaSecondaryParser textAreaSecondaryParser = TextAreaBaseParser.getInstance().getTextAreaSecondaryParser(optString2);
        if (textAreaSecondaryParser == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (!textAreaSecondaryParser.removeTextAreaById(false, optString2, optString, optString3)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }
}
