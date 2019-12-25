package com.baidu.swan.apps.ao.a.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ao.a.a;
import com.baidu.swan.apps.api.module.k.a;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends ab {
    public a(j jVar) {
        super(jVar, "/swanAPI/startAccelerometer");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
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
            final String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                if (DEBUG) {
                    Log.d("SwanAppAction", "startAccelerometer --- cb is empty");
                }
                c.e("accelerometer", "cb is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            c.i("accelerometer", " init ");
            com.baidu.swan.apps.ao.a.a acU = com.baidu.swan.apps.ao.a.a.acU();
            acU.init(context, a.C0214a.fI(optParamsAsJo.optString("interval")));
            acU.a(new a.InterfaceC0192a() { // from class: com.baidu.swan.apps.ao.a.a.a.1
                @Override // com.baidu.swan.apps.ao.a.a.InterfaceC0192a
                public void a(double[] dArr) {
                    if (dArr == null || dArr.length != 3) {
                        c.e("accelerometer", "illegal accelerometers");
                        callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                        return;
                    }
                    c.i("accelerometer", "handle accelerometer change, x : " + dArr[0] + " y: " + dArr[1] + " z: " + dArr[2]);
                    a.this.a(unitedSchemeEntity, callbackHandler, optString, dArr);
                    if (a.DEBUG) {
                        Log.d("SwanAppAction", "startAccelerometer --- accelerometer x: " + dArr[0] + " y: " + dArr[1] + " z: " + dArr[2]);
                    }
                }
            });
            acU.acV();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, double[] dArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Config.EVENT_HEAT_X, dArr[0]);
            jSONObject.put("y", dArr[1]);
            jSONObject.put("z", dArr[2]);
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
        } catch (JSONException e) {
            c.e("accelerometer", "handle compass,json error，" + e.toString());
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, "Json error").toString(), str);
        }
    }
}
