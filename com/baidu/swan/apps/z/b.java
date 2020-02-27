package com.baidu.swan.apps.z;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private UnitedSchemeEntity bzG;
    private CallbackHandler bzH;

    private b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.bzG = unitedSchemeEntity;
        this.bzH = callbackHandler;
    }

    public static b a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return new b(unitedSchemeEntity, callbackHandler);
    }

    public void onError(int i) {
        this.bzG.result = UnitedSchemeUtility.wrapCallbackParams(i);
    }

    public void K(JSONObject jSONObject) {
        this.bzG.result = UnitedSchemeUtility.callCallback(this.bzH, this.bzG, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
    }

    public void g(String str, int i, String str2) {
        UnitedSchemeUtility.safeCallback(this.bzH, this.bzG, UnitedSchemeUtility.wrapCallbackParams(i, str2).toString(), str);
    }

    public void c(String str, JSONObject jSONObject) {
        UnitedSchemeUtility.safeCallback(this.bzH, this.bzG, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }
}
