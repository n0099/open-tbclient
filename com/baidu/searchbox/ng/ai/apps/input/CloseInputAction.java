package com.baidu.searchbox.ng.ai.apps.input;

import android.content.Context;
import android.widget.EditText;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes2.dex */
public class CloseInputAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/closeInput";
    private static final String EVENT_NAME_BLUR = "blur";
    private static final String MODULE_TAG = "closeInput";
    private static final int NO_INPUT_EDIT_TEXT = 1001;

    public CloseInputAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        EditText inputEditText = InputEditTextProvider.getInstance().getInputEditText();
        if (inputEditText == null) {
            AiAppsLog.e(MODULE_TAG, "input组件不存在");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "input组件不存在");
            return false;
        } else if (AiAppsController.getInstance().getAiAppsFragmentManager() == null) {
            AiAppsLog.e(MODULE_TAG, "fragmentManager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            inputEditText.clearFocus();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }
}
