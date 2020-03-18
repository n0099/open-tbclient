package com.baidu.swan.bdprivate.c.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d extends ab {
    public d(j jVar) {
        super(jVar, "/swanAPI/getRealNameInfo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is empty");
            return false;
        }
        final String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "callback is empty");
            return false;
        } else if (!(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
            return false;
        } else {
            final boolean aO = com.baidu.swan.apps.setting.oauth.c.aO(optParamsAsJo);
            eVar.acS().a(context, "ppcert", aO, new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.bdprivate.c.a.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void D(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                    if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                        d.this.a((Activity) context, aO, callbackHandler, optString);
                    } else {
                        com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, optString);
                    }
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, boolean z, final CallbackHandler callbackHandler, final String str) {
        com.baidu.swan.apps.setting.b.a.a(activity, "ppcert", null, z, new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.b.a>() { // from class: com.baidu.swan.bdprivate.c.a.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(com.baidu.swan.apps.setting.b.a aVar) {
                com.baidu.swan.apps.console.c.i("OpenData", "onOpenDataCallback:: " + aVar.toString());
                if (!aVar.aeI()) {
                    com.baidu.swan.apps.setting.oauth.c.a(aVar, callbackHandler, str);
                } else {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(aVar.bTO, 0).toString());
                }
            }
        });
    }
}
