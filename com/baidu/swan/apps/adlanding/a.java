package com.baidu.swan.apps.adlanding;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.core.d.i;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.v.f;
/* loaded from: classes8.dex */
public class a extends aa {
    public a(j jVar) {
        super(jVar, "/swanAPI/openAdWebPage");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            Log.d("AdLandingAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String a = com.baidu.swan.apps.scheme.actions.k.a.a(unitedSchemeEntity, "params");
        String a2 = com.baidu.swan.apps.scheme.actions.k.a.a(unitedSchemeEntity, "params", "extraData");
        if (TextUtils.isEmpty(a)) {
            com.baidu.swan.apps.console.c.e("AdLanding", "adLanding: url is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (f.arY().XX() == null) {
            com.baidu.swan.apps.console.c.i("AdLandingAction", "open page failed");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else {
            com.baidu.swan.apps.model.b bP = com.baidu.swan.apps.model.b.bP(a, a);
            bP.mParams = a2;
            if (com.baidu.swan.apps.api.module.k.j.aco().isFullScreen()) {
                a(unitedSchemeEntity, bP);
            } else {
                b(unitedSchemeEntity, bP);
            }
            com.baidu.swan.apps.console.c.i("AdLanding", "open adLanding page finish");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    private void a(final UnitedSchemeEntity unitedSchemeEntity, final com.baidu.swan.apps.model.b bVar) {
        com.baidu.swan.apps.api.module.k.j.aco().acq();
        ak.c(new Runnable() { // from class: com.baidu.swan.apps.adlanding.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(unitedSchemeEntity, bVar);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UnitedSchemeEntity unitedSchemeEntity, com.baidu.swan.apps.model.b bVar) {
        if (!i.b("adLanding", bVar)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        }
    }
}
