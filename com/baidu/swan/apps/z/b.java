package com.baidu.swan.apps.z;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    private UnitedSchemeEntity bvx;
    private CallbackHandler bvy;

    private b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.bvx = unitedSchemeEntity;
        this.bvy = callbackHandler;
    }

    public static b a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return new b(unitedSchemeEntity, callbackHandler);
    }

    public void onError(int i) {
        this.bvx.result = UnitedSchemeUtility.wrapCallbackParams(i);
    }

    public void K(JSONObject jSONObject) {
        this.bvx.result = UnitedSchemeUtility.callCallback(this.bvy, this.bvx, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
    }

    public void f(String str, int i, String str2) {
        UnitedSchemeUtility.safeCallback(this.bvy, this.bvx, UnitedSchemeUtility.wrapCallbackParams(i, str2).toString(), str);
    }

    public void c(String str, JSONObject jSONObject) {
        UnitedSchemeUtility.safeCallback(this.bvy, this.bvx, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }
}
