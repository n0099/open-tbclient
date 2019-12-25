package com.baidu.swan.apps.z;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    private UnitedSchemeEntity buJ;
    private CallbackHandler buK;

    private b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.buJ = unitedSchemeEntity;
        this.buK = callbackHandler;
    }

    public static b a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return new b(unitedSchemeEntity, callbackHandler);
    }

    public void onError(int i) {
        this.buJ.result = UnitedSchemeUtility.wrapCallbackParams(i);
    }

    public void K(JSONObject jSONObject) {
        this.buJ.result = UnitedSchemeUtility.callCallback(this.buK, this.buJ, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
    }

    public void f(String str, int i, String str2) {
        UnitedSchemeUtility.safeCallback(this.buK, this.buJ, UnitedSchemeUtility.wrapCallbackParams(i, str2).toString(), str);
    }

    public void c(String str, JSONObject jSONObject) {
        UnitedSchemeUtility.safeCallback(this.buK, this.buJ, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }
}
