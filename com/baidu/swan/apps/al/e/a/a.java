package com.baidu.swan.apps.al.e.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.al.e.a;
import com.baidu.swan.apps.api.module.k.k;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a extends aa {
    public a(j jVar) {
        super(jVar, "/swanAPI/startCompass");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            c.e(MapController.COMPASS_LAYER_TAG, "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (DEBUG) {
                Log.d("SwanAppAction", "startCompass --- illegal swanApp");
                return false;
            }
            return false;
        } else if (context == null) {
            c.e(MapController.COMPASS_LAYER_TAG, "none context");
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
                c.e(MapController.COMPASS_LAYER_TAG, "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                if (DEBUG) {
                    Log.d("SwanAppAction", "startCompass --- cb is empty");
                }
                c.e(MapController.COMPASS_LAYER_TAG, "cb is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            c.i(MapController.COMPASS_LAYER_TAG, OneKeyLoginSdkCall.l);
            final k kVar = new k("compassChange", optParamsAsJo, optString);
            com.baidu.swan.apps.al.e.a aNQ = com.baidu.swan.apps.al.e.a.aNQ();
            aNQ.init(context);
            aNQ.a(new a.InterfaceC0388a() { // from class: com.baidu.swan.apps.al.e.a.a.1
                @Override // com.baidu.swan.apps.al.e.a.InterfaceC0388a
                public void b(float f, int i) {
                    c.i(MapController.COMPASS_LAYER_TAG, "handle compass change, angle:" + f + ",accuracy: " + i);
                    a.this.a(unitedSchemeEntity, callbackHandler, kVar, f, i);
                }
            });
            c.i(MapController.COMPASS_LAYER_TAG, "start listen compass");
            aNQ.aNR();
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
            jSONObject.put("accuracy", com.baidu.swan.apps.al.e.a.lw(i));
            if (DEBUG) {
                Log.d("SwanAppAction", "compassAngle : " + jSONObject.toString());
            }
            kVar.a(unitedSchemeEntity, callbackHandler, jSONObject);
        } catch (JSONException e) {
            c.e(MapController.COMPASS_LAYER_TAG, "handle compass,json error，" + e.toString());
            kVar.a(unitedSchemeEntity, callbackHandler, "Json error");
        }
    }
}
