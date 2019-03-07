package com.baidu.swan.apps.setting.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiGIDEvent;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends y {
    public b(j jVar) {
        super(jVar, "/swan/checkSession");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        String appKey = bVar.getAppKey();
        if (TextUtils.isEmpty(appKey)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        final String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            return false;
        } else if (!bVar.Jc().bk(context)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams((int) SapiGIDEvent.BUSINESS_GET_GID, "user not login");
            return true;
        } else {
            com.baidu.swan.apps.ae.e.Jo().aNY.get().uP().uT().c((Activity) context, appKey).c(new com.baidu.swan.apps.an.c.a<com.baidu.swan.apps.setting.oauth.g<JSONObject>>() { // from class: com.baidu.swan.apps.setting.a.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.c.a
                /* renamed from: a */
                public void D(com.baidu.swan.apps.setting.oauth.g<JSONObject> gVar) {
                    JSONObject wrapCallbackParams;
                    if (gVar.isOk() && b.this.ad(gVar.mData)) {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(gVar.mData.optJSONObject("data"), gVar.getErrorCode());
                    } else {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(gVar.getErrorCode());
                    }
                    callbackHandler.handleSchemeDispatchCallback(optString, wrapCallbackParams.toString());
                }
            }).Kc();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ad(JSONObject jSONObject) {
        return jSONObject != null && TextUtils.equals(jSONObject.optString("errno"), "0");
    }
}
