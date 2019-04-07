package com.baidu.swan.apps.console.property;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.w.e;
import com.baidu.ubc.UBC;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends y {
    private a any;

    public c(j jVar) {
        super(jVar, "/swan/perfCat");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppPropertyLogAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppPropertyLogAction", "handleSubAction subAction: " + str);
        }
        if (!DEBUG) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(403));
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        char c = 65535;
        switch (str.hashCode()) {
            case -685585602:
                if (str.equals("/swan/perfCat/off")) {
                    c = 1;
                    break;
                }
                break;
            case -595035867:
                if (str.equals("/swan/perfCat/duration")) {
                    c = 2;
                    break;
                }
                break;
            case -160662992:
                if (str.equals("/swan/perfCat/on")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (this.any == null) {
                    this.any = new a();
                }
                this.any.startMonitor();
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                com.baidu.swan.apps.console.c.i("SwanAppPropertyLogAction", " Start property log：");
                return true;
            case 1:
                JSONObject jSONObject = new JSONObject();
                if (this.any == null) {
                    com.baidu.swan.apps.console.c.e("SwanAppPropertyLogAction", "Property log never start");
                } else {
                    String wR = this.any.wR();
                    this.any = null;
                    e.Ea().yA();
                    try {
                        jSONObject.put("wvID", e.Ea().yA());
                        jSONObject.put("path", wR);
                    } catch (JSONException e) {
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                    }
                    if (DEBUG) {
                        Log.d("SwanAppPropertyLogAction", "Video dispatch Params : " + jSONObject.toString());
                    }
                    com.baidu.swan.apps.console.c.i("SwanAppPropertyLogAction", "Stop property log");
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                return true;
            case 2:
                if (optParamsAsJo == null) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(202));
                } else {
                    if (this.any != null) {
                        this.any.bS(optParamsAsJo.optInt(UBC.CONTENT_KEY_DURATION));
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                }
                return true;
            default:
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201));
                return false;
        }
    }
}
