package com.baidu.swan.apps.scheme.actions.b;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.pms.model.PMSAppInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends b {
    public a(j jVar) {
        super(jVar, "/swanAPI/addFavor");
    }

    @Override // com.baidu.swan.apps.scheme.actions.b.b
    protected void b(final com.baidu.swan.apps.runtime.e eVar, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final String str) {
        PMSAppInfo xC = com.baidu.swan.pms.database.a.bci().xC(this.dEP);
        if (xC == null || TextUtils.isEmpty(xC.appId)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("success", "0");
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
            return;
        }
        SwanFavorDataManager.auq().b(this.dEP, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.scheme.actions.b.a.1
            @Override // com.baidu.swan.apps.favordata.a.a
            public void anR() {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("success", "1");
                } catch (JSONException e2) {
                    if (com.baidu.swan.apps.b.DEBUG) {
                        e2.printStackTrace();
                    }
                }
                if (a.this.dEQ) {
                    com.baidu.swan.apps.database.favorite.a.asN();
                    if (com.baidu.swan.apps.menu.a.C(eVar.aIl())) {
                        com.baidu.swan.apps.menu.a.cd("addmyswan", ak.aNY().getPage());
                    } else {
                        com.baidu.swan.apps.res.widget.b.d.u(eVar.getApplicationContext(), a.h.aiapps_fav_success).jg(2).jc(2).aHZ();
                    }
                }
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0).toString(), str);
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void anS() {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("success", "0");
                } catch (JSONException e2) {
                    if (com.baidu.swan.apps.b.DEBUG) {
                        e2.printStackTrace();
                    }
                }
                if (a.this.dEQ) {
                    com.baidu.swan.apps.res.widget.b.d.u(eVar.getApplicationContext(), a.h.aiapps_fav_fail).jg(2).aHZ();
                }
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0).toString(), str);
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
            this.dEP = this.dEQ ? eVar.getAppId() : new JSONObject(param).optString("appid");
            return !TextUtils.isEmpty(this.dEP);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
