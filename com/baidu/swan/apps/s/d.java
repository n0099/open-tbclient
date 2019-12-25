package com.baidu.swan.apps.s;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.component.components.f.a;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.y.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d extends ab {
    public d(j jVar) {
        super(jVar, "/swanAPI/openInput");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            Log.d("OpenInputAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        f Uf = f.Uf();
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.console.c.e("openInput", "paramsJson is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.core.d.e DP = Uf.DP();
        if (DP == null) {
            com.baidu.swan.apps.console.c.e("openInput", "fragmentManager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragmentManager is null");
            return false;
        }
        SwanAppActivity TQ = f.Uf().TQ();
        if (TQ == null) {
            com.baidu.swan.apps.console.c.e("openInput", "activity is null when add input");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "activity is null when add input");
            return false;
        }
        com.baidu.swan.apps.core.d.d LC = DP.LC();
        if (LC == null) {
            com.baidu.swan.apps.console.c.e("openInput", "fragment is null when add input");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragment is null when add input");
            return false;
        }
        com.baidu.swan.apps.component.components.f.b bVar = new com.baidu.swan.apps.component.components.f.b();
        try {
            bVar.parseFromJson(optParamsAsJo);
        } catch (JSONException e) {
            e.printStackTrace();
            com.baidu.swan.apps.console.c.e("OpenInputAction", "model parse exception:", e);
        }
        boolean isSuccess = new com.baidu.swan.apps.component.components.f.a(context, bVar, TQ, LC, new a.InterfaceC0220a() { // from class: com.baidu.swan.apps.s.d.1
            @Override // com.baidu.swan.apps.component.components.f.a.InterfaceC0220a
            public void b(String str, JSONObject jSONObject) {
                d.this.a(callbackHandler, 0, str, jSONObject);
            }
        }).HS().isSuccess();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(isSuccess ? 0 : 1001));
        return isSuccess;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CallbackHandler callbackHandler, int i, String str, JSONObject jSONObject) {
        if (DEBUG) {
            Log.d("OpenInputAction", "sendAsyncCallback, arg0: " + i + ", arg1: " + jSONObject);
        }
        if (!TextUtils.isEmpty(str)) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
        }
    }
}
