package com.baidu.searchbox.ng.ai.apps.input;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.EditText;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.util.AiAppJSONUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class UpdateInputAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/updateInput";
    private static final String KEY_COLOR = "color";
    private static final String KEY_VALUE = "value";
    private static final String MODULE_TAG = "updateInput";
    private static final int NO_INPUT_EDIT_TEXT = 1001;

    public UpdateInputAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        if (aiApp == null) {
            AiAppsLog.e(MODULE_TAG, "illegal aiApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal aiApp");
            return false;
        }
        EditText inputEditText = InputEditTextProvider.getInstance().getInputEditText();
        if (inputEditText == null) {
            AiAppsLog.e(MODULE_TAG, "input组件不存在");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "input组件不存在");
            return false;
        }
        JSONObject parseString = AiAppJSONUtils.parseString(unitedSchemeEntity.getParam("params"));
        inputEditText.removeTextChangedListener(InputEditTextProvider.getInstance().getTextWatcher());
        if (parseString.has(KEY_COLOR)) {
            AiAppsLog.i(MODULE_TAG, "update color start");
            try {
                inputEditText.setTextColor(Color.parseColor(parseString.optString(KEY_COLOR)));
            } catch (IllegalArgumentException e) {
                AiAppsLog.e(MODULE_TAG, "color 解析错误");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                inputEditText.addTextChangedListener(InputEditTextProvider.getInstance().getTextWatcher());
                return false;
            }
        }
        if (parseString.has("value")) {
            AiAppsLog.i(MODULE_TAG, "update text start");
            String optString = parseString.optString("value");
            if (!TextUtils.equals(optString, inputEditText.getText())) {
                inputEditText.setText(optString);
                inputEditText.setSelection(parseString.optString("value").length());
            }
        }
        inputEditText.addTextChangedListener(InputEditTextProvider.getInstance().getTextWatcher());
        InputEditTextController inputEditTextController = InputEditTextProvider.getInstance().getInputEditTextController();
        boolean updateInputTextVisible = inputEditTextController != null ? inputEditTextController.updateInputTextVisible(parseString) : false;
        AiAppsLog.i(MODULE_TAG, "update success");
        if (updateInputTextVisible) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, updateInputTextVisible ? 0 : 1001);
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 1001);
        }
        return true;
    }
}
