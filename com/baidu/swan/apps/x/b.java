package com.baidu.swan.apps.x;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    private UnitedSchemeEntity ayH;
    private CallbackHandler ayI;

    private b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.ayH = unitedSchemeEntity;
        this.ayI = callbackHandler;
    }

    public static b a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return new b(unitedSchemeEntity, callbackHandler);
    }

    public void onError(int i) {
        this.ayH.result = UnitedSchemeUtility.wrapCallbackParams(i);
    }

    public void H(JSONObject jSONObject) {
        this.ayH.result = UnitedSchemeUtility.callCallback(this.ayI, this.ayH, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
    }

    public void d(String str, int i, String str2) {
        UnitedSchemeUtility.safeCallback(this.ayI, this.ayH, UnitedSchemeUtility.wrapCallbackParams(i, str2).toString(), str);
    }

    public void e(String str, JSONObject jSONObject) {
        UnitedSchemeUtility.safeCallback(this.ayI, this.ayH, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }
}
