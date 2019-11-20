package com.baidu.swan.apps.x;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    private UnitedSchemeEntity aTH;
    private CallbackHandler aTI;

    private b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.aTH = unitedSchemeEntity;
        this.aTI = callbackHandler;
    }

    public static b a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return new b(unitedSchemeEntity, callbackHandler);
    }

    public void onError(int i) {
        this.aTH.result = UnitedSchemeUtility.wrapCallbackParams(i);
    }

    public void ae(JSONObject jSONObject) {
        this.aTH.result = UnitedSchemeUtility.callCallback(this.aTI, this.aTH, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
    }

    public void f(String str, int i, String str2) {
        UnitedSchemeUtility.safeCallback(this.aTI, this.aTH, UnitedSchemeUtility.wrapCallbackParams(i, str2).toString(), str);
    }

    public void e(String str, JSONObject jSONObject) {
        UnitedSchemeUtility.safeCallback(this.aTI, this.aTH, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }
}
