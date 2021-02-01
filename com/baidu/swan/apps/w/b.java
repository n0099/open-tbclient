package com.baidu.swan.apps.w;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    private CallbackHandler dbO;
    private UnitedSchemeEntity dhx;

    private b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.dhx = unitedSchemeEntity;
        this.dbO = callbackHandler;
    }

    public static b b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return new b(unitedSchemeEntity, callbackHandler);
    }

    public void onError(int i) {
        this.dhx.result = UnitedSchemeUtility.wrapCallbackParams(i);
    }

    public void aF(JSONObject jSONObject) {
        this.dhx.result = UnitedSchemeUtility.callCallback(this.dbO, this.dhx, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
    }

    public void j(String str, int i, String str2) {
        UnitedSchemeUtility.safeCallback(this.dbO, this.dhx, UnitedSchemeUtility.wrapCallbackParams(i, str2).toString(), str);
    }

    public void g(String str, JSONObject jSONObject) {
        UnitedSchemeUtility.safeCallback(this.dbO, this.dhx, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }
}
