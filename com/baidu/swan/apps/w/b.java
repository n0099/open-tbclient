package com.baidu.swan.apps.w;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    private CallbackHandler ctP;
    private UnitedSchemeEntity czy;

    private b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.czy = unitedSchemeEntity;
        this.ctP = callbackHandler;
    }

    public static b b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return new b(unitedSchemeEntity, callbackHandler);
    }

    public void onError(int i) {
        this.czy.result = UnitedSchemeUtility.wrapCallbackParams(i);
    }

    public void ao(JSONObject jSONObject) {
        this.czy.result = UnitedSchemeUtility.callCallback(this.ctP, this.czy, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
    }

    public void g(String str, int i, String str2) {
        UnitedSchemeUtility.safeCallback(this.ctP, this.czy, UnitedSchemeUtility.wrapCallbackParams(i, str2).toString(), str);
    }

    public void d(String str, JSONObject jSONObject) {
        UnitedSchemeUtility.safeCallback(this.ctP, this.czy, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }
}
