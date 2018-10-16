package com.baidu.searchbox.ng.ai.apps.camera.action;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
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
abstract class AbsCameraAction extends AiAppAction {
    static final String KEY_CALLBACK_IMAGE_PATH = "tempImagePath";
    static final String KEY_CALLBACK_THUMB_PATH = "tempThumbPath";
    static final String KEY_CALLBACK_VIDEO_PATH = "tempVideoPath";
    static final String MODULE_TAG = "AiAppCamera";

    protected abstract AiAppsNaViewModel parseData(UnitedSchemeEntity unitedSchemeEntity);

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbsCameraAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher, String str) {
        super(unitedSchemeAiAppDispatcher, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getParamsValue(UnitedSchemeEntity unitedSchemeEntity) {
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
}
