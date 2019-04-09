package com.baidu.swan.apps.setting.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends y {
    public f(j jVar) {
        super(jVar, "/swan/getUserInfo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        } else if (TextUtils.isEmpty(bVar.getAppKey())) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId");
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                return false;
            }
            final String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            } else if (!(context instanceof Activity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
                return false;
            } else {
                com.baidu.swan.apps.setting.b.a.a((Activity) context, "snsapi_userinfo", "0", new com.baidu.swan.apps.an.c.a<com.baidu.swan.apps.setting.b.a>() { // from class: com.baidu.swan.apps.setting.a.f.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.an.c.a
                    /* renamed from: a */
                    public void D(com.baidu.swan.apps.setting.b.a aVar) {
                        JSONObject wrapCallbackParams;
                        com.baidu.swan.apps.console.c.i("OpenData", "onOpenDataCallback:: " + aVar.toString());
                        if (aVar.Km()) {
                            wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(aVar.aRV, 0);
                        } else {
                            wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "Permission denied;\n err by -> " + aVar.aRW.toString(SapiErrorCode.NETWORK_FAILED));
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
