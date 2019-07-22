package com.baidu.swan.apps.setting.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends z {
    public e(j jVar) {
        super(jVar, "/swan/getSwanId");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null) {
            com.baidu.swan.apps.console.c.e("getSwanId", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        } else if (TextUtils.isEmpty(bVar.getAppKey())) {
            com.baidu.swan.apps.console.c.e("getSwanId", "empty clientId");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId");
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                com.baidu.swan.apps.console.c.e("getSwanId", "empty joParams");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                com.baidu.swan.apps.console.c.e("getSwanId", "empty cb");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            }
            a(context, unitedSchemeEntity, callbackHandler, bVar, optString);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    private void a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar, final String str) {
        com.baidu.swan.apps.console.c.i("getSwanId", "getSwanId start");
        if (!SwanAppNetworkUtils.isNetworkConnected(context)) {
            com.baidu.swan.apps.console.c.e("getSwanId", "network_error");
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(10002, "network_error").toString(), str);
            return;
        }
        com.baidu.swan.apps.ae.e.Mv().aQQ.get().vZ().wA().x((Activity) context).g(new com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.g<JSONObject>>() { // from class: com.baidu.swan.apps.setting.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void D(com.baidu.swan.apps.setting.oauth.g<JSONObject> gVar) {
                if (gVar.isOk() && gVar.mData != null) {
                    String jSONObject = UnitedSchemeUtility.wrapCallbackParams(gVar.mData, 0).toString();
                    com.baidu.swan.apps.console.c.i("getSwanId", "getSwanId success");
                    UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, jSONObject, str);
                    return;
                }
                com.baidu.swan.apps.console.c.e("getSwanId", "getSwanId failed: internal_error");
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(10001, "internal_error").toString(), str);
            }
        }).No();
    }
}
