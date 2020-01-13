package com.baidu.swan.apps.g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.as.ah;
import com.baidu.swan.apps.as.d.b;
import com.baidu.swan.apps.as.s;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends ab {
    public a(j jVar) {
        super(jVar, "/swanAPI/getLaunchAppInfo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        String optString = s.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        b(optString, callbackHandler);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    private void b(final String str, final CallbackHandler callbackHandler) {
        com.baidu.swan.apps.network.c.b.a.d(new b<Map<String, com.baidu.swan.apps.setting.oauth.e>>() { // from class: com.baidu.swan.apps.g.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: n */
            public void B(Map<String, com.baidu.swan.apps.setting.oauth.e> map) {
                if (map != null) {
                    a.this.a(str, callbackHandler, map);
                } else {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, CallbackHandler callbackHandler, Map<String, com.baidu.swan.apps.setting.oauth.e> map) {
        com.baidu.swan.apps.setting.oauth.e eVar = map.get("scope_open_app");
        if (eVar == null) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            return;
        }
        boolean z = eVar.forbidden;
        int aeI = ah.aeI();
        long aeJ = ah.aeJ();
        List<String> list = eVar.bPj;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str2 : list) {
                jSONArray.put(str2);
            }
            jSONObject.put("launchCount", aeI);
            jSONObject.put("visitDuration", aeJ);
            jSONObject.put("forbidden", z);
            jSONObject.put("ext", jSONArray);
            if (DEBUG) {
                Log.i("GetBehaviorInfoAction", "launchCount:" + aeI + " visitDuration:" + aeJ + " forbidden:" + z + " ext:" + jSONArray.toString());
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }
}
