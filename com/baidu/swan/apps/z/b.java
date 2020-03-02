package com.baidu.swan.apps.z;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private UnitedSchemeEntity bzH;
    private CallbackHandler bzI;

    private b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.bzH = unitedSchemeEntity;
        this.bzI = callbackHandler;
    }

    public static b a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return new b(unitedSchemeEntity, callbackHandler);
    }

    public void onError(int i) {
        this.bzH.result = UnitedSchemeUtility.wrapCallbackParams(i);
    }

    public void K(JSONObject jSONObject) {
        this.bzH.result = UnitedSchemeUtility.callCallback(this.bzI, this.bzH, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
    }

    public void g(String str, int i, String str2) {
        UnitedSchemeUtility.safeCallback(this.bzI, this.bzH, UnitedSchemeUtility.wrapCallbackParams(i, str2).toString(), str);
    }

    public void c(String str, JSONObject jSONObject) {
        UnitedSchemeUtility.safeCallback(this.bzI, this.bzH, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }
}
