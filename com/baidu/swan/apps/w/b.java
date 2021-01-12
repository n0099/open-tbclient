package com.baidu.swan.apps.w;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    private CallbackHandler cZC;
    private UnitedSchemeEntity dfm;

    private b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.dfm = unitedSchemeEntity;
        this.cZC = callbackHandler;
    }

    public static b b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return new b(unitedSchemeEntity, callbackHandler);
    }

    public void onError(int i) {
        this.dfm.result = UnitedSchemeUtility.wrapCallbackParams(i);
    }

    public void aI(JSONObject jSONObject) {
        this.dfm.result = UnitedSchemeUtility.callCallback(this.cZC, this.dfm, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
    }

    public void j(String str, int i, String str2) {
        UnitedSchemeUtility.safeCallback(this.cZC, this.dfm, UnitedSchemeUtility.wrapCallbackParams(i, str2).toString(), str);
    }

    public void g(String str, JSONObject jSONObject) {
        UnitedSchemeUtility.safeCallback(this.cZC, this.dfm, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }
}
