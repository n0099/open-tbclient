package com.baidu.swan.apps.w;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    private CallbackHandler ddq;
    private UnitedSchemeEntity djb;

    private b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.djb = unitedSchemeEntity;
        this.ddq = callbackHandler;
    }

    public static b b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return new b(unitedSchemeEntity, callbackHandler);
    }

    public void onError(int i) {
        this.djb.result = UnitedSchemeUtility.wrapCallbackParams(i);
    }

    public void aH(JSONObject jSONObject) {
        this.djb.result = UnitedSchemeUtility.callCallback(this.ddq, this.djb, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
    }

    public void j(String str, int i, String str2) {
        UnitedSchemeUtility.safeCallback(this.ddq, this.djb, UnitedSchemeUtility.wrapCallbackParams(i, str2).toString(), str);
    }

    public void h(String str, JSONObject jSONObject) {
        UnitedSchemeUtility.safeCallback(this.ddq, this.djb, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }
}
