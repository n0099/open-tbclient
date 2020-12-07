package com.baidu.swan.apps.camera.a;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
abstract class a extends aa {
    protected abstract com.baidu.swan.apps.component.b.b c(UnitedSchemeEntity unitedSchemeEntity);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(j jVar, String str) {
        super(jVar, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b(UnitedSchemeEntity unitedSchemeEntity) {
        return unitedSchemeEntity.getParams().get("params");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, z ? 0 : -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap<String, String> hashMap, String str) {
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        if (params != null && !params.isEmpty() && hashMap != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    jSONObject.putOpt(entry.getKey(), entry.getValue());
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (TextUtils.isEmpty(str)) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            } else {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
            }
        }
    }
}
