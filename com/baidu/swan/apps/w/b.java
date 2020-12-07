package com.baidu.swan.apps.w;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class b {
    private CallbackHandler cZx;
    private UnitedSchemeEntity dfh;

    private b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.dfh = unitedSchemeEntity;
        this.cZx = callbackHandler;
    }

    public static b b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return new b(unitedSchemeEntity, callbackHandler);
    }

    public void onError(int i) {
        this.dfh.result = UnitedSchemeUtility.wrapCallbackParams(i);
    }

    public void aA(JSONObject jSONObject) {
        this.dfh.result = UnitedSchemeUtility.callCallback(this.cZx, this.dfh, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
    }

    public void j(String str, int i, String str2) {
        UnitedSchemeUtility.safeCallback(this.cZx, this.dfh, UnitedSchemeUtility.wrapCallbackParams(i, str2).toString(), str);
    }

    public void f(String str, JSONObject jSONObject) {
        UnitedSchemeUtility.safeCallback(this.cZx, this.dfh, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }
}
