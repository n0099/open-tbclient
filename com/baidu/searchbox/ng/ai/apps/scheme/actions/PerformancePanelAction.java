package com.baidu.searchbox.ng.ai.apps.scheme.actions;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.performance.panel.PanelDataProvider;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PerformancePanelAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/performancePanel";
    private static final boolean DEBUG = false;
    private static final String KEY_ACTION_NAME = "actionName";
    private static final String KEY_DATA = "data";
    private static final String KEY_SLAVED_ID = "slaveId";
    private static final String KEY_TIMESTAMP = "timestamp";
    private static final String MODULE_NAME = "performancePanel";
    private static final String TAG = "performancePanel";

    public PerformancePanelAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        if (aiApp == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty aiApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        JSONArray optJSONArray = optParamsAsJo.optJSONArray("data");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty data");
            return false;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                PanelDataProvider.getInstance().onReceivedPerformanceData(optJSONObject.optString("slaveId"), optJSONObject.optString(KEY_ACTION_NAME), optJSONObject.optLong("timestamp", -1L));
            }
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }
}
