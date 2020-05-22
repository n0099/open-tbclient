package com.baidu.swan.apps.scheme.actions.b;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends b {
    public c(j jVar) {
        super(jVar, "/swanAPI/isFavor");
    }

    @Override // com.baidu.swan.apps.scheme.actions.b.b
    protected void b(com.baidu.swan.apps.runtime.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isFavor", com.baidu.swan.apps.database.favorite.a.jW(this.cCs) ? 1 : 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }

    @Override // com.baidu.swan.apps.scheme.actions.b.b
    protected boolean b(com.baidu.swan.apps.runtime.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            return false;
        }
        try {
            this.cCs = this.cCt ? eVar.getAppId() : new JSONObject(param).optString("appid");
            return !TextUtils.isEmpty(this.cCs);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
