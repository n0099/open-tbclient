package com.baidu.swan.apps.w;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    private CallbackHandler cOu;
    private UnitedSchemeEntity cTZ;

    private b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.cTZ = unitedSchemeEntity;
        this.cOu = callbackHandler;
    }

    public static b b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return new b(unitedSchemeEntity, callbackHandler);
    }

    public void onError(int i) {
        this.cTZ.result = UnitedSchemeUtility.wrapCallbackParams(i);
    }

    public void ay(JSONObject jSONObject) {
        this.cTZ.result = UnitedSchemeUtility.callCallback(this.cOu, this.cTZ, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
    }

    public void i(String str, int i, String str2) {
        UnitedSchemeUtility.safeCallback(this.cOu, this.cTZ, UnitedSchemeUtility.wrapCallbackParams(i, str2).toString(), str);
    }

    public void d(String str, JSONObject jSONObject) {
        UnitedSchemeUtility.safeCallback(this.cOu, this.cTZ, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }
}
