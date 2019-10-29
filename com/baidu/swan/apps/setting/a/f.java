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
public class f extends z {
    public f(j jVar) {
        super(jVar, "/swan/getUserInfo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            com.baidu.swan.games.r.c.g(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return false;
        } else if (TextUtils.isEmpty(bVar.getAppKey())) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId");
            com.baidu.swan.games.r.c.g(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId").toString());
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                com.baidu.swan.games.r.c.g(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                return false;
            }
            final String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                com.baidu.swan.games.r.c.g(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                return false;
            } else if (!(context instanceof Activity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
                com.baidu.swan.games.r.c.g(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString());
                return false;
            } else {
                com.baidu.swan.apps.setting.b.a.a((Activity) context, "snsapi_userinfo", "0", new com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.b.a>() { // from class: com.baidu.swan.apps.setting.a.f.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.an.d.a
                    /* renamed from: a */
                    public void B(com.baidu.swan.apps.setting.b.a aVar) {
                        JSONObject wrapCallbackParams;
                        com.baidu.swan.apps.console.c.i("OpenData", "onOpenDataCallback:: " + aVar.toString());
                        if (aVar.Sv()) {
                            wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(aVar.boV, 0);
                        } else {
                            wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "Permission denied;\n err by -> " + aVar.boW.toString(-200));
                            com.baidu.swan.games.r.c.g(callbackHandler, wrapCallbackParams.toString());
                        }
                        callbackHandler.handleSchemeDispatchCallback(optString, wrapCallbackParams.toString());
                    }
                });
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
    }
}
