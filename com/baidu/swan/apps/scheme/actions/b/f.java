package com.baidu.swan.apps.scheme.actions.b;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f extends b {
    public f(j jVar) {
        super(jVar, "/swanAPI/topFavor");
    }

    @Override // com.baidu.swan.apps.scheme.actions.b.b
    protected void a(final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final String str) {
        SwanFavorDataManager.ZW().c(this.cqB, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.scheme.actions.b.f.1
            @Override // com.baidu.swan.apps.favordata.a.a
            public void aad() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("success", "1");
                } catch (JSONException e) {
                    if (com.baidu.swan.apps.b.DEBUG) {
                        e.printStackTrace();
                    }
                }
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void aae() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("success", "0");
                } catch (JSONException e) {
                    if (com.baidu.swan.apps.b.DEBUG) {
                        e.printStackTrace();
                    }
                }
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
            }
        });
    }

    @Override // com.baidu.swan.apps.scheme.actions.b.b
    protected boolean o(UnitedSchemeEntity unitedSchemeEntity) {
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            return false;
        }
        try {
            this.cqB = new JSONObject(param).optString("appid");
            return !TextUtils.isEmpty(this.cqB);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
