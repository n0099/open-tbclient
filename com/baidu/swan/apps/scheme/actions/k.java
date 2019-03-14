package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class k extends y {
    private com.baidu.swan.apps.b.c.c aPx;

    public k(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/getSlaveIdSync");
    }

    public void f(com.baidu.swan.apps.b.c.c cVar) {
        this.aPx = cVar;
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("GetSlaveIdSyncAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (this.aPx == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("slaveId", this.aPx.we());
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
