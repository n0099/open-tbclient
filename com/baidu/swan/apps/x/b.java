package com.baidu.swan.apps.x;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    private UnitedSchemeEntity ayE;
    private CallbackHandler ayF;

    private b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.ayE = unitedSchemeEntity;
        this.ayF = callbackHandler;
    }

    public static b a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return new b(unitedSchemeEntity, callbackHandler);
    }

    public void onError(int i) {
        this.ayE.result = UnitedSchemeUtility.wrapCallbackParams(i);
    }

    public void H(JSONObject jSONObject) {
        this.ayE.result = UnitedSchemeUtility.callCallback(this.ayF, this.ayE, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
    }

    public void d(String str, int i, String str2) {
        UnitedSchemeUtility.safeCallback(this.ayF, this.ayE, UnitedSchemeUtility.wrapCallbackParams(i, str2).toString(), str);
    }

    public void e(String str, JSONObject jSONObject) {
        UnitedSchemeUtility.safeCallback(this.ayF, this.ayE, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }
}
