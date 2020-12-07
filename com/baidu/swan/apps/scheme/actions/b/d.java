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
/* loaded from: classes25.dex */
public class d extends b {
    public d(j jVar) {
        super(jVar, "/swanAPI/deleteFavor");
    }

    @Override // com.baidu.swan.apps.scheme.actions.b.b
    protected void b(final com.baidu.swan.apps.runtime.e eVar, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final String str) {
        SwanFavorDataManager.awR().b(this.dAW, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.scheme.actions.b.d.1
            @Override // com.baidu.swan.apps.favordata.a.b
            public void aqx() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("success", "1");
                } catch (JSONException e) {
                    if (com.baidu.swan.apps.b.DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (d.this.dAX) {
                    com.baidu.swan.apps.res.widget.b.d.t(eVar.getApplicationContext(), a.h.aiapps_cancel_fav_success).kG(2).showHighlightToast();
                }
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void aqy() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("success", "0");
                } catch (JSONException e) {
                    if (com.baidu.swan.apps.b.DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (d.this.dAX) {
                    com.baidu.swan.apps.res.widget.b.d.t(eVar.getApplicationContext(), a.h.aiapps_cancel_fav_fail).kG(2).showToast();
                }
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
            }
        }, com.baidu.swan.apps.env.c.c.awn().iQ(3).awo());
    }

    @Override // com.baidu.swan.apps.scheme.actions.b.b
    protected boolean b(com.baidu.swan.apps.runtime.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            return false;
        }
        try {
            this.dAW = this.dAX ? eVar.getAppId() : new JSONObject(param).optString("appid");
            return !TextUtils.isEmpty(this.dAW);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
