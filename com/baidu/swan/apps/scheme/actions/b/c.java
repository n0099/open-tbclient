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
    protected void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isFavor", com.baidu.swan.apps.database.favorite.a.hC(this.bRv) ? 1 : 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }

    @Override // com.baidu.swan.apps.scheme.actions.b.b
    protected boolean o(UnitedSchemeEntity unitedSchemeEntity) {
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            return false;
        }
        try {
            this.bRv = new JSONObject(param).optString("appid");
            return !TextUtils.isEmpty(this.bRv);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
