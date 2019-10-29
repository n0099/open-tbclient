package com.baidu.swan.apps.x;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    private UnitedSchemeEntity aTZ;
    private CallbackHandler aUa;

    private b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.aTZ = unitedSchemeEntity;
        this.aUa = callbackHandler;
    }

    public static b a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return new b(unitedSchemeEntity, callbackHandler);
    }

    public void onError(int i) {
        this.aTZ.result = UnitedSchemeUtility.wrapCallbackParams(i);
    }

    public void ad(JSONObject jSONObject) {
        this.aTZ.result = UnitedSchemeUtility.callCallback(this.aUa, this.aTZ, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
    }

    public void f(String str, int i, String str2) {
        UnitedSchemeUtility.safeCallback(this.aUa, this.aTZ, UnitedSchemeUtility.wrapCallbackParams(i, str2).toString(), str);
    }

    public void e(String str, JSONObject jSONObject) {
        UnitedSchemeUtility.safeCallback(this.aUa, this.aTZ, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }
}
