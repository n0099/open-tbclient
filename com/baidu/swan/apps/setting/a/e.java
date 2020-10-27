package com.baidu.swan.apps.setting.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ap.v;
import com.baidu.swan.apps.api.module.h.a;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes10.dex */
public class e extends aa {
    public e(j jVar) {
        super(jVar, "/swanAPI/getSwanId");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            com.baidu.swan.apps.console.c.e("getSwanId", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
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
        if (com.baidu.swan.apps.performance.b.c.aBx()) {
            String string = eVar.aFg().getString(a.C0386a.b(eVar), (String) null);
            if (TextUtils.isEmpty(string)) {
                a(context, unitedSchemeEntity, callbackHandler, eVar, optString);
            } else {
                JSONObject parseString = v.parseString(string);
                JSONObject optJSONObject = parseString.optJSONObject("data");
                if (optJSONObject != null) {
                    String optString2 = optJSONObject.optString("swanid");
                    if (!TextUtils.isEmpty(optString2) && !TextUtils.equals("null", optString2)) {
                        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(parseString, 0).toString(), optString);
                        com.baidu.swan.apps.console.c.i("getSwanId", "getSwanId success");
                    } else {
                        a(context, unitedSchemeEntity, callbackHandler, eVar, optString);
                    }
                } else {
                    a(context, unitedSchemeEntity, callbackHandler, eVar, optString);
                }
            }
        } else {
            a(context, unitedSchemeEntity, callbackHandler, eVar, optString);
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    private void a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar, final String str) {
        com.baidu.swan.apps.console.c.i("getSwanId", "getSwanId start");
        if (!SwanAppNetworkUtils.isNetworkConnected(context)) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(10002, "network_error").toString(), str);
            com.baidu.swan.apps.console.c.e("getSwanId", "network_error");
            return;
        }
        com.baidu.swan.apps.runtime.d.aEQ().aES().adF().afw().bm(context).A(new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<JSONObject>>() { // from class: com.baidu.swan.apps.setting.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(com.baidu.swan.apps.setting.oauth.h<JSONObject> hVar) {
                if (hVar.isOk() && hVar.mData != null) {
                    UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(hVar.mData, 0).toString(), str);
                    if (eVar != null) {
                        eVar.aFg().putString(a.C0386a.b(eVar), hVar.mData.toString());
                    }
                    com.baidu.swan.apps.console.c.i("getSwanId", "getSwanId success");
                    return;
                }
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(10001, "internal_error").toString(), str);
                com.baidu.swan.apps.console.c.e("getSwanId", "getSwanId failed: internal_error");
            }
        }).aGL();
    }
}
