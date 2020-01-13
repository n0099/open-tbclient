package com.baidu.swan.apps.storage.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.ab;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes10.dex */
public class g extends ab {
    public g(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/getStorageSync");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        String optString = optParamsAsJo.optString("key");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty key");
            return false;
        }
        String string = eVar.aax().acS().getString(optString, "");
        try {
            JSONObject fJ = fJ(string);
            if (fJ == null) {
                fJ = new JSONObject();
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                fJ.put("data", string);
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(fJ, 0);
            return true;
        } catch (JSONException e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "JSONException");
            if (DEBUG) {
                e.printStackTrace();
            }
            return false;
        }
    }

    private JSONObject fJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("key")) {
                jSONObject.remove("key");
            }
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
