package com.baidu.swan.apps.scheme.actions.i;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ap.v;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.core.prefetch.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends aa {
    public a(j jVar) {
        super(jVar, "/swanAPI/prefetchAppData");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (DEBUG) {
            Log.d("PrefetchAppData", "handle entity: " + unitedSchemeEntity.getUri().toString());
        }
        String param = unitedSchemeEntity.getParam("params");
        JSONObject parseString = v.parseString(param);
        PrefetchEvent bC = bC(parseString);
        if (bC == null || !bC.isValid()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "invalid params: " + param);
            return false;
        } else if (!com.baidu.swan.apps.core.a.a.a.lr(parseString.optString("netconf", "1"))) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "Network limitation");
            return false;
        } else {
            d.ajJ().d(bC);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }

    private PrefetchEvent bC(@NonNull JSONObject jSONObject) {
        return new PrefetchEvent.a().md(jSONObject.optString("state")).mc(jSONObject.optString("schema")).me(jSONObject.optString("scene")).mb(jSONObject.optString("appKey")).ajI();
    }
}
