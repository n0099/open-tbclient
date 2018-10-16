package com.baidu.searchbox.ng.ai.apps.system.accelerometer.action;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.system.accelerometer.AiAppsAccelerometerManager;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class StartAccelerometerAction extends AiAppAction {
    public static final String ACTION_TYPE = "/swan/startAccelerometer";
    private static final String KEY_ACCELEROMETER_X = "x";
    private static final String KEY_ACCELEROMETER_Y = "y";
    private static final String KEY_ACCELEROMETER_Z = "z";
    private static final String MODULE_TAG = "accelerometer";
    private static final int NUMBER_ACCELEROMETER = 3;

    public StartAccelerometerAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
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
            AiAppsLog.i(MODULE_TAG, " init ");
            AiAppsAccelerometerManager aiAppsAccelerometerManager = AiAppsAccelerometerManager.getInstance();
            aiAppsAccelerometerManager.init(context);
            aiAppsAccelerometerManager.setOnAccelerometerChangeListener(new AiAppsAccelerometerManager.OnAccelerometerChangeListener() { // from class: com.baidu.searchbox.ng.ai.apps.system.accelerometer.action.StartAccelerometerAction.1
                @Override // com.baidu.searchbox.ng.ai.apps.system.accelerometer.AiAppsAccelerometerManager.OnAccelerometerChangeListener
                public void OnAccelerometerChange(double[] dArr) {
                    if (dArr == null || dArr.length != 3) {
                        AiAppsLog.e(StartAccelerometerAction.MODULE_TAG, "illegal accelerometers");
                        callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                        return;
                    }
                    AiAppsLog.i(StartAccelerometerAction.MODULE_TAG, "handle accelerometer change, x : " + dArr[0] + " y: " + dArr[1] + " z: " + dArr[2]);
                    StartAccelerometerAction.this.handleAccelerometerChange(unitedSchemeEntity, callbackHandler, optString, dArr);
                }
            });
            aiAppsAccelerometerManager.startListenAccelerometer();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAccelerometerChange(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, double[] dArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", dArr[0]);
            jSONObject.put("y", dArr[1]);
            jSONObject.put(KEY_ACCELEROMETER_Z, dArr[2]);
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
        } catch (JSONException e) {
            AiAppsLog.e(MODULE_TAG, "handle compass,json error，" + e.toString());
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, "Json error").toString(), str);
        }
    }
}
