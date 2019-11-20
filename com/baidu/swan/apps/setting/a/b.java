package com.baidu.swan.apps.setting.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends z {
    public b(j jVar) {
        super(jVar, "/swan/checkSession");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            com.baidu.swan.games.r.c.h(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return false;
        }
        String appKey = bVar.getAppKey();
        if (TextUtils.isEmpty(appKey)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId");
            com.baidu.swan.games.r.c.h(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId").toString());
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            com.baidu.swan.games.r.c.h(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
            return false;
        }
        final String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            com.baidu.swan.games.r.c.h(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
            return false;
        } else if (!bVar.Rg().isLogin(context)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(10004, "user not login");
            com.baidu.swan.games.r.c.h(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(10004, "user not login").toString());
            return true;
        } else {
            com.baidu.swan.apps.ae.e.Rt().bka.get().AY().Bz().c((Activity) context, appKey).g(new com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.g<JSONObject>>() { // from class: com.baidu.swan.apps.setting.a.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: a */
                public void B(com.baidu.swan.apps.setting.oauth.g<JSONObject> gVar) {
                    JSONObject wrapCallbackParams;
                    if (gVar.isOk() && b.this.aC(gVar.mData)) {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(gVar.mData.optJSONObject("data"), gVar.getErrorCode());
                    } else {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(gVar.getErrorCode());
                        com.baidu.swan.games.r.c.h(callbackHandler, wrapCallbackParams.toString());
                    }
                    callbackHandler.handleSchemeDispatchCallback(optString, wrapCallbackParams.toString());
                }
            }).Sk();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aC(JSONObject jSONObject) {
        return jSONObject != null && TextUtils.equals(jSONObject.optString("errno"), "0");
    }
}
