package com.baidu.swan.apps.w;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    private UnitedSchemeEntity cpC;
    private CallbackHandler cpD;

    private b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.cpC = unitedSchemeEntity;
        this.cpD = callbackHandler;
    }

    public static b b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return new b(unitedSchemeEntity, callbackHandler);
    }

    public void onError(int i) {
        this.cpC.result = UnitedSchemeUtility.wrapCallbackParams(i);
    }

    public void aj(JSONObject jSONObject) {
        this.cpC.result = UnitedSchemeUtility.callCallback(this.cpD, this.cpC, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
    }

    public void g(String str, int i, String str2) {
        UnitedSchemeUtility.safeCallback(this.cpD, this.cpC, UnitedSchemeUtility.wrapCallbackParams(i, str2).toString(), str);
    }

    public void d(String str, JSONObject jSONObject) {
        UnitedSchemeUtility.safeCallback(this.cpD, this.cpC, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }
}
