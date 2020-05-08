package com.baidu.swan.apps.z;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private UnitedSchemeEntity bYf;
    private CallbackHandler bYg;

    private b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.bYf = unitedSchemeEntity;
        this.bYg = callbackHandler;
    }

    public static b a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return new b(unitedSchemeEntity, callbackHandler);
    }

    public void onError(int i) {
        this.bYf.result = UnitedSchemeUtility.wrapCallbackParams(i);
    }

    public void V(JSONObject jSONObject) {
        this.bYf.result = UnitedSchemeUtility.callCallback(this.bYg, this.bYf, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
    }

    public void g(String str, int i, String str2) {
        UnitedSchemeUtility.safeCallback(this.bYg, this.bYf, UnitedSchemeUtility.wrapCallbackParams(i, str2).toString(), str);
    }

    public void d(String str, JSONObject jSONObject) {
        UnitedSchemeUtility.safeCallback(this.bYg, this.bYf, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }
}
