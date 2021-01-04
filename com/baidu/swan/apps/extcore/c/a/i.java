package com.baidu.swan.apps.extcore.c.a;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class i extends aa {
    public i(j jVar) {
        super(jVar, "/swanAPI/debug/setReplaceSwanCoreConfig");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        final JSONObject b2 = b(unitedSchemeEntity, "params");
        if (b2 == null) {
            com.baidu.swan.apps.console.c.e("setReplaceSwanCoreConfig", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!b2.has("emitReplaceSwanCore")) {
            com.baidu.swan.apps.console.c.e("setReplaceSwanCoreConfig", "emitReplaceSwanCore is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            eVar.aMw().b(context, "mapp_cts_debug", new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.extcore.c.a.i.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: a */
                public void L(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                    if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                        com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, unitedSchemeEntity);
                        return;
                    }
                    boolean iQ = com.baidu.swan.apps.extcore.c.a.iQ(b2.optInt("emitReplaceSwanCore"));
                    if (iQ && !com.baidu.swan.apps.swancore.b.aPL()) {
                        com.baidu.swan.apps.res.widget.b.d.u(AppRuntime.getAppContext(), a.h.aiapps_debug_no_swan_core).aLS();
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, context.getResources().getString(a.h.aiapps_debug_no_swan_core));
                        return;
                    }
                    com.baidu.swan.apps.ad.a.a.gz(iQ);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    com.baidu.swan.apps.ad.a.a.arX();
                }
            });
            return true;
        }
    }
}
