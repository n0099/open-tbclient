package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.i.g;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class u extends z {
    public u(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/preloadSubPackage");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null) {
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
        } else if (bVar.hn(optString2) && bVar.ho(optString2)) {
            com.baidu.swan.apps.console.c.i("PreloadSubPackage", "subPackage have existed");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "subPackage have existed");
            return false;
        } else {
            String hq = bVar.hq(optString2);
            if (TextUtils.isEmpty(hq)) {
                com.baidu.swan.apps.console.c.i("PreloadSubPackage", "subPackage cannot find aps key");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            com.baidu.swan.apps.scheme.actions.i.g.RT().a(bVar.Iz(), bVar.id, bVar.getVersion(), optString2, hq, com.baidu.swan.apps.w.e.LE().Ln(), null, new g.a() { // from class: com.baidu.swan.apps.scheme.actions.u.1
                @Override // com.baidu.swan.apps.scheme.actions.i.g.a
                public void fO(String str) {
                    com.baidu.swan.apps.console.c.i("PreloadSubPackage", "preload subPackage success");
                    UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0, "preload subPackage success").toString(), optString);
                }

                @Override // com.baidu.swan.apps.scheme.actions.i.g.a
                public void dF(int i) {
                    com.baidu.swan.apps.console.c.e("PreloadSubPackage", "preload subPackage failed");
                    UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, "No SubPackage").toString(), optString);
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
