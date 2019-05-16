package com.baidu.swan.apps.x;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    private UnitedSchemeEntity azG;
    private CallbackHandler azH;

    private b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.azG = unitedSchemeEntity;
        this.azH = callbackHandler;
    }

    public static b a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return new b(unitedSchemeEntity, callbackHandler);
    }

    public void onError(int i) {
        this.azG.result = UnitedSchemeUtility.wrapCallbackParams(i);
    }

    public void F(JSONObject jSONObject) {
        this.azG.result = UnitedSchemeUtility.callCallback(this.azH, this.azG, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
    }

    public void d(String str, int i, String str2) {
        UnitedSchemeUtility.safeCallback(this.azH, this.azG, UnitedSchemeUtility.wrapCallbackParams(i, str2).toString(), str);
    }

    public void e(String str, JSONObject jSONObject) {
        UnitedSchemeUtility.safeCallback(this.azH, this.azG, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }
}
