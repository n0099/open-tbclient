package com.baidu.swan.apps.x;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    private UnitedSchemeEntity ayI;
    private CallbackHandler ayJ;

    private b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.ayI = unitedSchemeEntity;
        this.ayJ = callbackHandler;
    }

    public static b a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return new b(unitedSchemeEntity, callbackHandler);
    }

    public void onError(int i) {
        this.ayI.result = UnitedSchemeUtility.wrapCallbackParams(i);
    }

    public void H(JSONObject jSONObject) {
        this.ayI.result = UnitedSchemeUtility.callCallback(this.ayJ, this.ayI, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
    }

    public void d(String str, int i, String str2) {
        UnitedSchemeUtility.safeCallback(this.ayJ, this.ayI, UnitedSchemeUtility.wrapCallbackParams(i, str2).toString(), str);
    }

    public void e(String str, JSONObject jSONObject) {
        UnitedSchemeUtility.safeCallback(this.ayJ, this.ayI, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }
}
