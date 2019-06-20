package com.baidu.swan.apps.d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes2.dex */
public class a extends z {
    public a(j jVar) {
        super(jVar, "/swan/openAdLandingPage");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("OpenAdLandingPageAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        final String b = com.baidu.swan.apps.scheme.actions.i.a.b(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(b)) {
            com.baidu.swan.apps.console.c.i("AdLanding", "adLanding: url is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        final e vi = com.baidu.swan.apps.w.e.FV().vi();
        if (vi == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        bVar.Lu().a((Activity) context, "mapp_i_open_adlanding", new com.baidu.swan.apps.an.d.a<Boolean>() { // from class: com.baidu.swan.apps.d.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: b */
            public void D(Boolean bool) {
                if (!bool.booleanValue()) {
                    com.baidu.swan.apps.console.c.i("AdLanding", "open adLanding page failed");
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, "Permission denied"));
                    return;
                }
                a.this.a(com.baidu.swan.apps.model.b.aq(b, b), vi);
                com.baidu.swan.apps.console.c.i("AdLanding", "open adLanding page success");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.model.b bVar, e eVar) {
        com.baidu.swan.apps.console.c.i("AdLanding", "openAdLanding: page url=" + bVar.mBaseUrl);
        eVar.dN("adLanding").y(e.aqT, e.aqV).a("adLanding", bVar).zW();
    }
}
