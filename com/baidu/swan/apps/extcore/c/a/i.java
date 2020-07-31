package com.baidu.swan.apps.extcore.c.a;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class i extends aa {
    private static final String cjR = i.class.getSimpleName();

    public i(j jVar) {
        super(jVar, "/swanAPI/debug/setReplaceSwanCoreConfig");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        final JSONObject b = b(unitedSchemeEntity, "params");
        if (b == null) {
            com.baidu.swan.apps.console.c.e(cjR, "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!b.has("emitReplaceSwanCore")) {
            com.baidu.swan.apps.console.c.e(cjR, "emitReplaceSwanCore is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            eVar.arH().b(context, "mapp_cts_debug", new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.extcore.c.a.i.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: a */
                public void H(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                    if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                        com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, unitedSchemeEntity);
                        return;
                    }
                    boolean fD = com.baidu.swan.apps.extcore.c.a.fD(b.optInt("emitReplaceSwanCore"));
                    if (fD && !com.baidu.swan.apps.swancore.b.ava()) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, context.getResources().getString(a.h.aiapps_debug_no_swan_core));
                        return;
                    }
                    com.baidu.swan.apps.ae.a.a.eO(fD);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    com.baidu.swan.apps.ae.a.a.aam();
                }
            });
            return true;
        }
    }
}
