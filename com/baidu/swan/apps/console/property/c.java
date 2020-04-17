package com.baidu.swan.apps.console.property;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.y.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends ab {
    private a bJk;

    public c(j jVar) {
        super(jVar, "/swanAPI/perfCat");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (DEBUG) {
            Log.d("SwanAppPropertyLogAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean e(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
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
            case -322942229:
                if (str.equals("/swanAPI/perfCat/duration")) {
                    c = 2;
                    break;
                }
                break;
            case 227833272:
                if (str.equals("/swanAPI/perfCat/off")) {
                    c = 1;
                    break;
                }
                break;
            case 977180790:
                if (str.equals("/swanAPI/perfCat/on")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (this.bJk == null) {
                    this.bJk = new a();
                }
                this.bJk.startMonitor();
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                com.baidu.swan.apps.console.c.i("SwanAppPropertyLogAction", " Start property log：");
                return true;
            case 1:
                JSONObject jSONObject = new JSONObject();
                if (this.bJk == null) {
                    com.baidu.swan.apps.console.c.e("SwanAppPropertyLogAction", "Property log never start");
                } else {
                    String TR = this.bJk.TR();
                    this.bJk = null;
                    f.aeK().VQ();
                    try {
                        jSONObject.put("wvID", f.aeK().VQ());
                        jSONObject.put("path", TR);
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
                    if (this.bJk != null) {
                        this.bJk.es(optParamsAsJo.optInt("duration"));
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
