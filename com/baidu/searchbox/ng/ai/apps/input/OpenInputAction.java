package com.baidu.searchbox.ng.ai.apps.input;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragmentManager;
import com.baidu.searchbox.ng.ai.apps.input.InputEditTextController;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class OpenInputAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/openInput";
    protected static final boolean DEBUG = false;
    private static final String MODULE_TAG = "openInput";
    private static final String PARAM_ADD_CALLBACK = "cb";
    private static final String PARAM_PARAMS = "params";
    private static final String SLAVE_ID = "slaveId";
    protected static final String TAG = "OpenInputAction";
    private HashMap<String, String> mParamsHashMap;

    public OpenInputAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, AiApp aiApp) {
        this.mParamsHashMap = unitedSchemeEntity.getParams();
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        AiAppsController aiAppsController = AiAppsController.getInstance();
        if (optParamsAsJo == null) {
            AiAppsLog.e(MODULE_TAG, "paramsJson is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        AiAppsFragmentManager aiAppsFragmentManager = aiAppsController.getAiAppsFragmentManager();
        if (aiAppsFragmentManager == null) {
            AiAppsLog.e(MODULE_TAG, "fragmentManager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        InputEditTextController inputEditTextController = new InputEditTextController(aiAppsFragmentManager.getTopAiAppsFragment(), new InputEditTextController.SendAsyncCallback() { // from class: com.baidu.searchbox.ng.ai.apps.input.OpenInputAction.1
            @Override // com.baidu.searchbox.ng.ai.apps.input.InputEditTextController.SendAsyncCallback
            public void callback(JSONObject jSONObject) {
                OpenInputAction.this.sendAsyncCallback(callbackHandler, 0, jSONObject);
            }
        });
        InputEditTextProvider.getInstance().setInputEditTextController(inputEditTextController);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(inputEditTextController.addInputEditText(context, optParamsAsJo) ? 0 : 1001));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void sendAsyncCallback(CallbackHandler callbackHandler, int i, JSONObject jSONObject) {
        String optString;
        String str = this.mParamsHashMap.get("params");
        if (!TextUtils.isEmpty(str)) {
            try {
                optString = new JSONObject(str).optString("cb");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (TextUtils.isEmpty(optString)) {
                callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                return;
            }
            return;
        }
        optString = null;
        if (TextUtils.isEmpty(optString)) {
        }
    }
}
