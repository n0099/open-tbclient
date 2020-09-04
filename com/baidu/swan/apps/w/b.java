package com.baidu.swan.apps.w;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    private CallbackHandler crL;
    private UnitedSchemeEntity cxx;

    private b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.cxx = unitedSchemeEntity;
        this.crL = callbackHandler;
    }

    public static b b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return new b(unitedSchemeEntity, callbackHandler);
    }

    public void onError(int i) {
        this.cxx.result = UnitedSchemeUtility.wrapCallbackParams(i);
    }

    public void al(JSONObject jSONObject) {
        this.cxx.result = UnitedSchemeUtility.callCallback(this.crL, this.cxx, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
    }

    public void g(String str, int i, String str2) {
        UnitedSchemeUtility.safeCallback(this.crL, this.cxx, UnitedSchemeUtility.wrapCallbackParams(i, str2).toString(), str);
    }

    public void d(String str, JSONObject jSONObject) {
        UnitedSchemeUtility.safeCallback(this.crL, this.cxx, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }
}
