package com.baidu.swan.apps.am.i;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends aa {
    public a(j jVar) {
        super(jVar, "/swanAPI/getAutoRotationSync");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            c.e("getAutoRotationSync", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (DEBUG) {
                Log.e("SwanAppAction", "getAutoRotationSync --- illegal swanApp");
                return false;
            }
            return false;
        } else if (context == null) {
            c.e("getAutoRotationSync", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
            if (DEBUG) {
                Log.e("SwanAppAction", "getAutoRotationSync --- illegal context");
                return false;
            }
            return false;
        } else {
            try {
                int i = Settings.System.getInt(context.getApplicationContext().getContentResolver(), "accelerometer_rotation");
                if (DEBUG) {
                    Log.d("SwanAppAction", "getAutoRotationSync --- isRotateOn: " + i);
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("isRotateOn", i != 0);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                    return true;
                } catch (JSONException e) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "json exception");
                    if (DEBUG) {
                        Log.e("SwanAppAction", "getAutoRotationSync --- json exception");
                        return false;
                    }
                    return false;
                }
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                    Log.e("SwanAppAction", "getAutoRotationSync --- can't get setting");
                    return false;
                }
                return false;
            }
        }
    }
}
