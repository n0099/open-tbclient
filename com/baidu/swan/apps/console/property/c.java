package com.baidu.swan.apps.console.property;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.w.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends z {
    private a aoM;

    public c(j jVar) {
        super(jVar, "/swan/perfCat");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("SwanAppPropertyLogAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
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
                if (this.aoM == null) {
                    this.aoM = new a();
                }
                this.aoM.startMonitor();
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                com.baidu.swan.apps.console.c.i("SwanAppPropertyLogAction", " Start property log：");
                return true;
            case 1:
                JSONObject jSONObject = new JSONObject();
                if (this.aoM == null) {
                    com.baidu.swan.apps.console.c.e("SwanAppPropertyLogAction", "Property log never start");
                } else {
                    String ys = this.aoM.ys();
                    this.aoM = null;
                    e.GJ().Ag();
                    try {
                        jSONObject.put("wvID", e.GJ().Ag());
                        jSONObject.put("path", ys);
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
                    if (this.aoM != null) {
                        this.aoM.bT(optParamsAsJo.optInt("duration"));
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
