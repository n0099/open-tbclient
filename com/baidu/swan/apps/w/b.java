package com.baidu.swan.apps.w;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    private CallbackHandler det;
    private UnitedSchemeEntity dkb;

    private b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.dkb = unitedSchemeEntity;
        this.det = callbackHandler;
    }

    public static b b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return new b(unitedSchemeEntity, callbackHandler);
    }

    public void onError(int i) {
        this.dkb.result = UnitedSchemeUtility.wrapCallbackParams(i);
    }

    public void aI(JSONObject jSONObject) {
        this.dkb.result = UnitedSchemeUtility.callCallback(this.det, this.dkb, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
    }

    public void j(String str, int i, String str2) {
        UnitedSchemeUtility.safeCallback(this.det, this.dkb, UnitedSchemeUtility.wrapCallbackParams(i, str2).toString(), str);
    }

    public void g(String str, JSONObject jSONObject) {
        UnitedSchemeUtility.safeCallback(this.det, this.dkb, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }
}
