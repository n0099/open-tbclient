package com.baidu.swan.apps.al.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.al.b.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends aa {
    public b(j jVar) {
        super(jVar, "/swanAPI/startMediaVolumeListen");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            com.baidu.swan.apps.console.c.e("startMediaVolumeListen", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal swanApp");
            return false;
        } else if (context == null) {
            com.baidu.swan.apps.console.c.e("startMediaVolumeListen", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal context");
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                com.baidu.swan.apps.console.c.e("startMediaVolumeListen", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            final String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                com.baidu.swan.apps.console.c.e("startMediaVolumeListen", "cb is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString2 = optParamsAsJo.optString("id");
            if (TextUtils.isEmpty(optString2)) {
                com.baidu.swan.apps.console.c.e("startMediaVolumeListen", "id is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            d.aIO().a(optString2, new d.a() { // from class: com.baidu.swan.apps.al.b.b.1
                @Override // com.baidu.swan.apps.al.b.d.a
                public void kR(int i) {
                    b.this.a(i, callbackHandler, unitedSchemeEntity, optString);
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(double d, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
        JSONObject jSONObject = new JSONObject();
        int aIP = (int) ((d / d.aIO().aIP()) * 100.0d);
        if (aIP < 0) {
            aIP = 0;
        }
        int i = aIP <= 100 ? aIP : 100;
        try {
            jSONObject.put("volume", i);
            if (DEBUG) {
                Log.d("startMediaVolumeListen", "NewVolume: " + i);
            }
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
        } catch (JSONException e) {
            com.baidu.swan.apps.console.c.e("startMediaVolumeListen", "handle volume json error，" + e.toString());
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, "Json error").toString(), str);
        }
    }
}
