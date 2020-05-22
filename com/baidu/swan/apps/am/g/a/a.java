package com.baidu.swan.apps.am.g.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.am.g.a;
import com.baidu.swan.apps.api.module.k.i;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends aa {
    public a(j jVar) {
        super(jVar, "/swanAPI/startDeviceMotion");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, e eVar) {
        int i;
        if (eVar == null) {
            c.e("StartDeviceMotionAction", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal swanApp");
            return false;
        } else if (context == null) {
            c.e("StartDeviceMotionAction", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal context");
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                c.e("StartDeviceMotionAction", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.e("StartDeviceMotionAction", "cb is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString2 = optParamsAsJo.optString("interval");
            if ("ui".equals(optString2)) {
                i = 2;
            } else {
                i = ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME.equals(optString2) ? 1 : 3;
            }
            c.d("StartDeviceMotionAction", "startSensor===");
            final i iVar = new i("deviceMotionChange", optParamsAsJo, optString);
            if (!com.baidu.swan.apps.am.g.a.asu().a(i, new a.InterfaceC0293a() { // from class: com.baidu.swan.apps.am.g.a.a.1
                @Override // com.baidu.swan.apps.am.g.a.InterfaceC0293a
                public void w(float[] fArr) {
                    if (fArr != null && fArr.length == 3) {
                        a.this.a(unitedSchemeEntity, callbackHandler, iVar, fArr);
                    }
                }
            })) {
                c.e("StartDeviceMotionAction", "start system sensor fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "start system sensor fail");
                return false;
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            iVar.a(unitedSchemeEntity, callbackHandler);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, i iVar, float[] fArr) {
        JSONObject jSONObject = new JSONObject();
        double[] dArr = new double[3];
        double d = fArr[0] - 1.5707963267948966d;
        if (d < 0.0d) {
            d += 6.283185307179586d;
        }
        dArr[0] = Math.toDegrees(d);
        dArr[1] = Math.toDegrees(-fArr[2]);
        dArr[2] = Math.toDegrees(-fArr[1]);
        if (DEBUG) {
            Log.i("SwanAppAction", "deviceMotionChange: " + Arrays.toString(dArr));
        }
        try {
            jSONObject.put("alpha", (float) dArr[0]);
            jSONObject.put("beta", (float) dArr[1]);
            jSONObject.put("gamma", (float) dArr[2]);
            iVar.a(unitedSchemeEntity, callbackHandler, jSONObject);
        } catch (JSONException e) {
            c.e("StartDeviceMotionAction", "handle orientation,json error，" + e.toString());
            iVar.a(unitedSchemeEntity, callbackHandler, "Json error");
        }
    }
}
