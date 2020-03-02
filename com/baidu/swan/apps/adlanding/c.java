package com.baidu.swan.apps.adlanding;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
import com.baidu.swan.apps.y.f;
/* loaded from: classes11.dex */
public class c extends ab {
    public c(j jVar) {
        super(jVar, "/swanAPI/openAdLandingPage");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, e eVar) {
        if (DEBUG) {
            Log.d("OpenAdLandingPageAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        final String a = com.baidu.swan.apps.scheme.actions.k.a.a(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(a)) {
            com.baidu.swan.apps.console.c.i("AdLanding", "adLanding: url is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        final com.baidu.swan.apps.core.d.e GC = f.WS().GC();
        if (GC == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        eVar.acP().b(context, "mapp_i_open_adlanding", new com.baidu.swan.apps.as.d.b<h<b.d>>() { // from class: com.baidu.swan.apps.adlanding.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(h<b.d> hVar) {
                if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                    com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, unitedSchemeEntity);
                    return;
                }
                c.this.a(com.baidu.swan.apps.model.b.aX(a, a), GC);
                com.baidu.swan.apps.console.c.i("AdLanding", "open adLanding page success");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.model.b bVar, com.baidu.swan.apps.core.d.e eVar) {
        com.baidu.swan.apps.console.c.i("AdLanding", "openAdLanding: page url=" + bVar.mBaseUrl);
        eVar.hb("adLanding").Y(com.baidu.swan.apps.core.d.e.bof, com.baidu.swan.apps.core.d.e.boh).a("adLanding", bVar).Oz();
    }
}
