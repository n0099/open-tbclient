package com.baidu.searchbox.ng.ai.apps.ar.action;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.ar.model.ARCameraAttr;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class AbsARAction extends AiAppAction {
    static final String KEY_CALLBACK_IMAGE_PATH = "tempImagePath";
    static final String KEY_CALLBACK_VIDEO_PATH = "tempVideoPath";
    private static final String TAG = "AbsARAction";

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbsARAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher, String str) {
        super(unitedSchemeAiAppDispatcher, str);
    }

    String getParamsValue(UnitedSchemeEntity unitedSchemeEntity) {
        return unitedSchemeEntity.getParams().get("params");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void callback(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, z ? 0 : -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean callBackWithData(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap<String, String> hashMap, String str) {
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        if (params == null || params.isEmpty() || hashMap == null) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                jSONObject.putOpt(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
        }
        if (TextUtils.isEmpty(str)) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
        } else {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ARCameraAttr parseData(UnitedSchemeEntity unitedSchemeEntity) {
        return new ARCameraAttr(getParamsValue(unitedSchemeEntity));
    }
}
