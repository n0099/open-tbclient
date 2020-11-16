package com.baidu.swan.apps.scheme.actions.b;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends b {
    public d(j jVar) {
        super(jVar, "/swanAPI/deleteFavor");
    }

    @Override // com.baidu.swan.apps.scheme.actions.b.b
    protected void b(final com.baidu.swan.apps.runtime.e eVar, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final String str) {
        SwanFavorDataManager.atJ().b(this.dtX, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.scheme.actions.b.d.1
            @Override // com.baidu.swan.apps.favordata.a.b
            public void anp() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("success", "1");
                } catch (JSONException e) {
                    if (com.baidu.swan.apps.b.DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (d.this.dtY) {
                    com.baidu.swan.apps.res.widget.b.d.k(eVar.getApplicationContext(), a.h.aiapps_cancel_fav_success).ki(2).showHighlightToast();
                }
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void anq() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("success", "0");
                } catch (JSONException e) {
                    if (com.baidu.swan.apps.b.DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (d.this.dtY) {
                    com.baidu.swan.apps.res.widget.b.d.k(eVar.getApplicationContext(), a.h.aiapps_cancel_fav_fail).ki(2).showToast();
                }
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
            }
        }, com.baidu.swan.apps.env.c.c.atf().is(3).atg());
    }

    @Override // com.baidu.swan.apps.scheme.actions.b.b
    protected boolean b(com.baidu.swan.apps.runtime.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            return false;
        }
        try {
            this.dtX = this.dtY ? eVar.getAppId() : new JSONObject(param).optString("appid");
            return !TextUtils.isEmpty(this.dtX);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
