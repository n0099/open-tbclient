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
/* loaded from: classes9.dex */
public class a extends b {
    public a(j jVar) {
        super(jVar, "/swanAPI/addFavor");
    }

    @Override // com.baidu.swan.apps.scheme.actions.b.b
    protected void b(final com.baidu.swan.apps.runtime.e eVar, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final String str) {
        PMSAppInfo xV = com.baidu.swan.pms.database.a.bcv().xV(this.dGT);
        if (xV == null || TextUtils.isEmpty(xV.appId)) {
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
        SwanFavorDataManager.auO().b(this.dGT, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.scheme.actions.b.a.1
            @Override // com.baidu.swan.apps.favordata.a.a
            public void aop() {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("success", "1");
                } catch (JSONException e2) {
                    if (com.baidu.swan.apps.b.DEBUG) {
                        e2.printStackTrace();
                    }
                }
                if (a.this.dGU) {
                    com.baidu.swan.apps.database.favorite.a.atl();
                    if (com.baidu.swan.apps.menu.a.w(eVar.aIE())) {
                        com.baidu.swan.apps.menu.a.bX("addmyswan", ak.aOr().getPage());
                    } else {
                        com.baidu.swan.apps.res.widget.b.d.u(eVar.getApplicationContext(), a.h.aiapps_fav_success).jj(2).jf(2).aIs();
                    }
                }
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0).toString(), str);
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void aoq() {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("success", "0");
                } catch (JSONException e2) {
                    if (com.baidu.swan.apps.b.DEBUG) {
                        e2.printStackTrace();
                    }
                }
                if (a.this.dGU) {
                    com.baidu.swan.apps.res.widget.b.d.u(eVar.getApplicationContext(), a.h.aiapps_fav_fail).jj(2).aIs();
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
            this.dGT = this.dGU ? eVar.getAppId() : new JSONObject(param).optString("appid");
            return !TextUtils.isEmpty(this.dGT);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
