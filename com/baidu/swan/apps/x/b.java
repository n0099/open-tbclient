package com.baidu.swan.apps.x;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    private UnitedSchemeEntity aAn;
    private CallbackHandler aAo;

    private b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.aAn = unitedSchemeEntity;
        this.aAo = callbackHandler;
    }

    public static b a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return new b(unitedSchemeEntity, callbackHandler);
    }

    public void onError(int i) {
        this.aAn.result = UnitedSchemeUtility.wrapCallbackParams(i);
    }

    public void F(JSONObject jSONObject) {
        this.aAn.result = UnitedSchemeUtility.callCallback(this.aAo, this.aAn, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
    }

    public void d(String str, int i, String str2) {
        UnitedSchemeUtility.safeCallback(this.aAo, this.aAn, UnitedSchemeUtility.wrapCallbackParams(i, str2).toString(), str);
    }

    public void e(String str, JSONObject jSONObject) {
        UnitedSchemeUtility.safeCallback(this.aAo, this.aAn, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }
}
