package com.baidu.searchbox.ng.ai.apps.system.brightness.actions;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.system.brightness.utils.AiAppsBrightnessManager;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BrightnessAction extends AiAppAction {
    private static final boolean DEBUG = false;
    public static final String GET_BRIGHTNESS = "/swan/brightness/get";
    public static final String KEEP_SCREEN_ON = "/swan/brightness/keepScreenOn";
    private static final String KEY_BRIGHTNESS = "value";
    private static final String KEY_CALLBACK = "cb";
    private static final String KEY_KEEP_SCREEN_ON = "keepScreenOn";
    private static final String KEY_PARAMS = "params";
    private static final String MODULE_NAME = "/swan/brightness";
    private static final String MODULE_PATH = "/swan/brightness/";
    private static final String MODULE_TAG = "brightness";
    public static final String SET_BRIGHTNESS = "/swan/brightness/set";
    private static final String TAG = "Brightness";

    public BrightnessAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, MODULE_NAME);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handleSubAction(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, AiApp aiApp) {
        Activity activity;
        JSONObject jSONObject;
        boolean z;
        float f = -1.0f;
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (!(context instanceof Activity)) {
            activity = null;
        } else {
            activity = (Activity) context;
        }
        if (activity == null) {
            AiAppsLog.e(MODULE_TAG, "activity is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        int i = 1001;
        char c = 65535;
        switch (str.hashCode()) {
            case -1130635193:
                if (str.equals(GET_BRIGHTNESS)) {
                    c = 1;
                    break;
                }
                break;
            case -1130623661:
                if (str.equals(SET_BRIGHTNESS)) {
                    c = 0;
                    break;
                }
                break;
            case -589707201:
                if (str.equals(KEEP_SCREEN_ON)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (optParamsAsJo == null) {
                    AiAppsLog.e(MODULE_TAG, "paramsJson is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                String optString = optParamsAsJo.optString("value");
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        f = Float.parseFloat(optString);
                    } catch (Exception e) {
                    }
                }
                if (f < 0.0f || f > 1.0f) {
                    i = 202;
                    jSONObject = null;
                    z = false;
                    break;
                } else {
                    AiAppsBrightnessManager.getInstance().setBrightness(activity, f);
                    jSONObject = null;
                    z = true;
                    break;
                }
                break;
            case 1:
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("value", String.valueOf(AiAppsBrightnessManager.getInstance().getBrightness(activity)));
                    z = true;
                    break;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    z = true;
                    break;
                }
            case 2:
                if (optParamsAsJo == null) {
                    AiAppsLog.e(MODULE_TAG, "paramsJson is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                try {
                    AiAppsBrightnessManager.getInstance().setScreenOn(activity, optParamsAsJo.getBoolean(KEY_KEEP_SCREEN_ON));
                    jSONObject = null;
                    z = true;
                    break;
                } catch (JSONException e3) {
                    i = 202;
                    jSONObject = null;
                    z = false;
                    break;
                }
            default:
                jSONObject = null;
                z = false;
                break;
        }
        if (z) {
            if (jSONObject != null) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            }
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(i);
        }
        return z;
    }
}
