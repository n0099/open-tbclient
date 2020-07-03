package com.baidu.swan.apps.scheme.actions.i;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.aq.t;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.core.prefetch.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes11.dex */
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
        JSONObject parseString = t.parseString(param);
        PrefetchEvent bm = bm(parseString);
        if (bm == null || !bm.isValid()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "invalid params: " + param);
            return false;
        } else if (!com.baidu.swan.apps.core.a.a.a.jk(parseString.optString("netconf", "1"))) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "Network limitation");
            return false;
        } else {
            d.abz().e(bm);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }

    private PrefetchEvent bm(@NonNull JSONObject jSONObject) {
        return new PrefetchEvent.a().jM(jSONObject.optString("state")).jL(jSONObject.optString("schema")).jN(jSONObject.optString(FaceBaseDTO.KEY_BUSINESS_SCENE)).jK(jSONObject.optString("appKey")).abx();
    }
}
