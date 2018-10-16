package com.baidu.searchbox.ng.ai.apps.system.compass.action;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsRouteMessage;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.system.compass.AiAppsCompassManager;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class StartCompassAction extends AiAppAction {
    public static final String ACTION_TYPE = "/swan/startCompass";
    private static final String KEY_DIRECTION = "direction";
    private static final String MODULE_TAG = "compass";

    public StartCompassAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, AiApp aiApp) {
        if (aiApp == null) {
            AiAppsLog.e(MODULE_TAG, "none aiApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal aiApp");
            return false;
        } else if (context == null) {
            AiAppsLog.e(MODULE_TAG, "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                AiAppsLog.e(MODULE_TAG, "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            final String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                AiAppsLog.e(MODULE_TAG, "cb is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            AiAppsLog.i(MODULE_TAG, AiAppsRouteMessage.TYPE_INIT);
            AiAppsCompassManager aiAppsCompassManager = AiAppsCompassManager.getInstance();
            aiAppsCompassManager.init(context);
            aiAppsCompassManager.setOnCompassChangeListener(new AiAppsCompassManager.OnCompassChangeListener() { // from class: com.baidu.searchbox.ng.ai.apps.system.compass.action.StartCompassAction.1
                @Override // com.baidu.searchbox.ng.ai.apps.system.compass.AiAppsCompassManager.OnCompassChangeListener
                public void OnCompassChange(float f) {
                    AiAppsLog.i(StartCompassAction.MODULE_TAG, "handle compass change, angle:" + f);
                    StartCompassAction.this.handleCompassChange(unitedSchemeEntity, callbackHandler, optString, f);
                }
            });
            AiAppsLog.i(MODULE_TAG, "start listen compass");
            aiAppsCompassManager.startListenCompass();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCompassChange(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, float f) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_DIRECTION, f);
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
        } catch (JSONException e) {
            AiAppsLog.e(MODULE_TAG, "handle compass,json error，" + e.toString());
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, "Json error").toString(), str);
        }
    }
}
