package com.baidu.swan.apps.r;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.r.b;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends z {
    public f(j jVar) {
        super(jVar, "/swan/openInput");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("OpenInputAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        com.baidu.swan.apps.w.e LE = com.baidu.swan.apps.w.e.LE();
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.console.c.e("openInput", "paramsJson is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.core.d.e AI = LE.AI();
        if (AI == null) {
            com.baidu.swan.apps.console.c.e("openInput", "fragmentManager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        b bVar2 = new b(AI.Fs(), new b.a() { // from class: com.baidu.swan.apps.r.f.1
            @Override // com.baidu.swan.apps.r.b.a
            public void d(String str, JSONObject jSONObject) {
                f.this.a(callbackHandler, 0, str, jSONObject);
            }
        });
        c.IT().c(bVar2);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(bVar2.a(context, i(unitedSchemeEntity), optParamsAsJo) ? 0 : 1001));
        return true;
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

    private String i(UnitedSchemeEntity unitedSchemeEntity) {
        String str = unitedSchemeEntity.getParams().get("params");
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str).optString("cb");
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
