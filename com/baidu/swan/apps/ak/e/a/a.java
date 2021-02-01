package com.baidu.swan.apps.ak.e.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ak.e.a;
import com.baidu.swan.apps.api.module.k.k;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends aa {
    public a(j jVar) {
        super(jVar, "/swanAPI/startCompass");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            c.e("compass", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (DEBUG) {
                Log.d("SwanAppAction", "startCompass --- illegal swanApp");
                return false;
            }
            return false;
        } else if (context == null) {
            c.e("compass", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
            if (DEBUG) {
                Log.d("SwanAppAction", "startCompass --- illegal context");
                return false;
            }
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                if (DEBUG) {
                    Log.d("SwanAppAction", "startCompass --- params is empty");
                }
                c.e("compass", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                if (DEBUG) {
                    Log.d("SwanAppAction", "startCompass --- cb is empty");
                }
                c.e("compass", "cb is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            c.i("compass", OneKeyLoginSdkCall.l);
            final k kVar = new k("compassChange", optParamsAsJo, optString);
            com.baidu.swan.apps.ak.e.a aMG = com.baidu.swan.apps.ak.e.a.aMG();
            aMG.init(context);
            aMG.a(new a.InterfaceC0360a() { // from class: com.baidu.swan.apps.ak.e.a.a.1
                @Override // com.baidu.swan.apps.ak.e.a.InterfaceC0360a
                public void b(float f, int i) {
                    c.i("compass", "handle compass change, angle:" + f + ",accuracy: " + i);
                    a.this.a(unitedSchemeEntity, callbackHandler, kVar, f, i);
                }
            });
            c.i("compass", "start listen compass");
            aMG.aMH();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            kVar.a(unitedSchemeEntity, callbackHandler);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k kVar, float f, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("direction", f);
            jSONObject.put("accuracy", com.baidu.swan.apps.ak.e.a.jY(i));
            if (DEBUG) {
                Log.d("SwanAppAction", "compassAngle : " + jSONObject.toString());
            }
            kVar.a(unitedSchemeEntity, callbackHandler, jSONObject);
        } catch (JSONException e) {
            c.e("compass", "handle compass,json error，" + e.toString());
            kVar.a(unitedSchemeEntity, callbackHandler, "Json error");
        }
    }
}
