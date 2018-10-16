package com.baidu.searchbox.ng.ai.apps.textarea.action;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.textarea.info.TextAreaStatusInfo;
import com.baidu.searchbox.ng.ai.apps.textarea.parser.TextAreaBaseParser;
import com.baidu.searchbox.ng.ai.apps.textarea.parser.TextAreaSecondaryParser;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class OpenTextAreaAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/openTextarea";
    private static final String TAG = "OpenTextAreaAction";
    private HashMap<String, String> mCallbackMap;

    public OpenTextAreaAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, AiApp aiApp) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        AiAppsLog.d(TAG, "OpenTextAreaAction paramsJson: " + optParamsAsJo);
        String optString = optParamsAsJo.optString(TextAreaStatusInfo.ID);
        String optString2 = optParamsAsJo.optString("slaveId");
        String optString3 = optParamsAsJo.optString("cb");
        if (this.mCallbackMap == null) {
            this.mCallbackMap = new HashMap<>();
        }
        this.mCallbackMap.put(optString, optString3);
        if (!TextAreaBaseParser.getInstance().getOrCreateSecondaryParser(optString2).addTextAreaEditText(new TextAreaSecondaryParser.SendAsyncCallback() { // from class: com.baidu.searchbox.ng.ai.apps.textarea.action.OpenTextAreaAction.1
            @Override // com.baidu.searchbox.ng.ai.apps.textarea.parser.TextAreaSecondaryParser.SendAsyncCallback
            public void callback(String str, JSONObject jSONObject) {
                OpenTextAreaAction.this.sendAsyncCallback(str, callbackHandler, 0, jSONObject);
            }
        }, context, optParamsAsJo)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAsyncCallback(String str, CallbackHandler callbackHandler, int i, JSONObject jSONObject) {
        AiAppsLog.d(TAG, "sendAsyncCallback, arg0: " + i + ", arg1: " + jSONObject);
        String str2 = this.mCallbackMap.get(str);
        if (!TextUtils.isEmpty(str2)) {
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        }
    }
}
