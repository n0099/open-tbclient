package com.baidu.swan.apps.scheme.actions.favorite;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends b {
    public d(j jVar) {
        super(jVar, "/swan/deleteFavor");
    }

    @Override // com.baidu.swan.apps.scheme.actions.favorite.b
    protected void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        if (com.baidu.swan.apps.database.favorite.a.eR(this.blO)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("success", "1");
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("success", "0");
        } catch (JSONException e2) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e2.printStackTrace();
            }
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0).toString(), str);
    }

    @Override // com.baidu.swan.apps.scheme.actions.favorite.b
    protected boolean k(UnitedSchemeEntity unitedSchemeEntity) {
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            return false;
        }
        try {
            this.blO = new JSONObject(param).optString("appid");
            return !TextUtils.isEmpty(this.blO);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
