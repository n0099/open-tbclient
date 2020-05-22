package com.baidu.swan.apps.x;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private UnitedSchemeEntity ciH;
    private CallbackHandler ciI;

    private b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.ciH = unitedSchemeEntity;
        this.ciI = callbackHandler;
    }

    public static b b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return new b(unitedSchemeEntity, callbackHandler);
    }

    public void onError(int i) {
        this.ciH.result = UnitedSchemeUtility.wrapCallbackParams(i);
    }

    public void aa(JSONObject jSONObject) {
        this.ciH.result = UnitedSchemeUtility.callCallback(this.ciI, this.ciH, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
    }

    public void g(String str, int i, String str2) {
        UnitedSchemeUtility.safeCallback(this.ciI, this.ciH, UnitedSchemeUtility.wrapCallbackParams(i, str2).toString(), str);
    }

    public void d(String str, JSONObject jSONObject) {
        UnitedSchemeUtility.safeCallback(this.ciI, this.ciH, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }
}
