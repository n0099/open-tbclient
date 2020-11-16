package com.baidu.swan.apps.w;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    private CallbackHandler cSD;
    private UnitedSchemeEntity cYi;

    private b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.cYi = unitedSchemeEntity;
        this.cSD = callbackHandler;
    }

    public static b b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return new b(unitedSchemeEntity, callbackHandler);
    }

    public void onError(int i) {
        this.cYi.result = UnitedSchemeUtility.wrapCallbackParams(i);
    }

    public void ay(JSONObject jSONObject) {
        this.cYi.result = UnitedSchemeUtility.callCallback(this.cSD, this.cYi, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
    }

    public void j(String str, int i, String str2) {
        UnitedSchemeUtility.safeCallback(this.cSD, this.cYi, UnitedSchemeUtility.wrapCallbackParams(i, str2).toString(), str);
    }

    public void f(String str, JSONObject jSONObject) {
        UnitedSchemeUtility.safeCallback(this.cSD, this.cYi, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }
}
