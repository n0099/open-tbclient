package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.k.g;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes11.dex */
public class v extends aa {
    public v(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/preloadSubPackage");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            com.baidu.swan.apps.console.c.e("PreloadSubPackage", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.console.c.e("PreloadSubPackage", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("PreloadSubPackage", "none cb");
            if (DEBUG) {
                Log.d("SwanAppAction", "preload subPackage cb is empty");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString2 = optParamsAsJo.optString("root");
        if (TextUtils.isEmpty(optString2)) {
            com.baidu.swan.apps.console.c.e("PreloadSubPackage", "subPackage root is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (eVar.nv(optString2) && eVar.nw(optString2)) {
            com.baidu.swan.apps.console.c.i("PreloadSubPackage", "subPackage have existed");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "subPackage have existed");
            return false;
        } else {
            String ny = eVar.ny(optString2);
            if (TextUtils.isEmpty(ny)) {
                com.baidu.swan.apps.console.c.i("PreloadSubPackage", "subPackage cannot find aps key");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            com.baidu.swan.apps.scheme.actions.k.g.a(eVar.id, eVar.getVersion(), optString2, ny, null, new g.a() { // from class: com.baidu.swan.apps.scheme.actions.v.1
                @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                public void hg(String str) {
                    com.baidu.swan.apps.console.c.i("PreloadSubPackage", "preload subPackage success");
                    UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0, "preload subPackage success").toString(), optString);
                }

                @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                public void el(int i) {
                    com.baidu.swan.apps.console.c.e("PreloadSubPackage", "preload subPackage failed");
                    UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, "No SubPackage").toString(), optString);
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
