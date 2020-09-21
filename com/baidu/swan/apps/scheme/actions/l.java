package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes3.dex */
public class l extends aa {
    private com.baidu.swan.apps.adaptation.b.c cUE;

    public l(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/getSlaveIdSync");
    }

    public void f(com.baidu.swan.apps.adaptation.b.c cVar) {
        this.cUE = cVar;
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            Log.d("GetSlaveIdSyncAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (this.cUE == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("slaveId", this.cUE.abD());
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            return true;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("GetSlaveIdSyncAction", Log.getStackTraceString(e));
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
    }
}
