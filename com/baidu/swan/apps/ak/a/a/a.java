package com.baidu.swan.apps.ak.a.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ak.a.a;
import com.baidu.swan.apps.api.module.k.a;
import com.baidu.swan.apps.api.module.k.k;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends aa {
    public a(j jVar) {
        super(jVar, "/swanAPI/startAccelerometer");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            c.e("accelerometer", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (DEBUG) {
                Log.d("SwanAppAction", "startAccelerometer --- illegal swanApp");
                return false;
            }
            return false;
        } else if (context == null) {
            c.e("accelerometer", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
            if (DEBUG) {
                Log.d("SwanAppAction", "startAccelerometer --- illegal context");
                return false;
            }
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                if (DEBUG) {
                    Log.d("SwanAppAction", "startAccelerometer --- params is empty");
                }
                c.e("accelerometer", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                if (DEBUG) {
                    Log.d("SwanAppAction", "startAccelerometer --- cb is empty");
                }
                c.e("accelerometer", "cb is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            c.i("accelerometer", " init ");
            final k kVar = new k("accelerometerChange", optParamsAsJo, optString);
            com.baidu.swan.apps.ak.a.a aMB = com.baidu.swan.apps.ak.a.a.aMB();
            aMB.w(context, a.C0389a.lp(optParamsAsJo.optString("interval")));
            aMB.a(new a.InterfaceC0363a() { // from class: com.baidu.swan.apps.ak.a.a.a.1
                @Override // com.baidu.swan.apps.ak.a.a.InterfaceC0363a
                public void a(double[] dArr) {
                    if (dArr == null || dArr.length != 3) {
                        c.e("accelerometer", "illegal accelerometers");
                        return;
                    }
                    c.i("accelerometer", "handle accelerometer change, x : " + dArr[0] + " y: " + dArr[1] + " z: " + dArr[2]);
                    a.this.a(unitedSchemeEntity, callbackHandler, kVar, dArr);
                }
            });
            aMB.aMC();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            kVar.a(unitedSchemeEntity, callbackHandler);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k kVar, double[] dArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Config.EVENT_HEAT_X, dArr[0]);
            jSONObject.put("y", dArr[1]);
            jSONObject.put("z", dArr[2]);
            kVar.a(unitedSchemeEntity, callbackHandler, jSONObject);
        } catch (JSONException e) {
            c.e("accelerometer", "handle compass,json error，" + e.toString());
            kVar.a(unitedSchemeEntity, callbackHandler, "Json error");
        }
    }
}
