package com.baidu.swan.apps.scheme.actions.b;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends b {
    public a(j jVar) {
        super(jVar, "/swanAPI/addFavor");
    }

    @Override // com.baidu.swan.apps.scheme.actions.b.b
    protected void b(final com.baidu.swan.apps.runtime.e eVar, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final String str) {
        SwanFavorDataManager.aft().b(this.cJW, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.scheme.actions.b.a.1
            @Override // com.baidu.swan.apps.favordata.a.a
            public void aaa() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("success", "1");
                } catch (JSONException e) {
                    if (com.baidu.swan.apps.b.DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (a.this.cJX) {
                    com.baidu.swan.apps.database.favorite.a.aen();
                    if (com.baidu.swan.apps.x.a.J(eVar.arp())) {
                        com.baidu.swan.apps.x.a.bA("addmyswan", al.axg().getPage());
                    } else {
                        com.baidu.swan.apps.res.widget.b.d.k(eVar.getApplicationContext(), a.h.aiapps_fav_success).hc(2).gY(2).showToast();
                    }
                }
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void aab() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("success", "0");
                } catch (JSONException e) {
                    if (com.baidu.swan.apps.b.DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (a.this.cJX) {
                    com.baidu.swan.apps.res.widget.b.d.k(eVar.getApplicationContext(), a.h.aiapps_fav_fail).hc(2).showToast();
                }
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
            }
        });
    }

    @Override // com.baidu.swan.apps.scheme.actions.b.b
    protected boolean b(com.baidu.swan.apps.runtime.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            return false;
        }
        try {
            this.cJW = this.cJX ? eVar.getAppId() : new JSONObject(param).optString("appid");
            return !TextUtils.isEmpty(this.cJW);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
