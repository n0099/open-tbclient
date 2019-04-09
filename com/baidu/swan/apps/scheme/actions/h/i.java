package com.baidu.swan.apps.scheme.actions.h;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.core.h.b;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes2.dex */
public class i extends y {
    public i(j jVar) {
        super(jVar, "/swan/switchTab");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        String wd;
        if (DEBUG) {
            Log.d("SwitchTabAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String b = a.b(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(b)) {
            com.baidu.swan.apps.console.c.e("switchTab", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        com.baidu.swan.apps.w.e Ea = com.baidu.swan.apps.w.e.Ea();
        final com.baidu.swan.apps.core.c.e uy = Ea.uy();
        if (uy == null) {
            com.baidu.swan.apps.console.c.e("switchTab", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b ap = com.baidu.swan.apps.model.b.ap(b, Ea.DJ());
        if (!aa.a(Ea.DI(), ap)) {
            com.baidu.swan.apps.console.c.e("switchTab", "tab params error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        com.baidu.swan.apps.core.c.d yP = uy.yP();
        if (yP == null || TextUtils.isEmpty(yP.dX(ap.axM))) {
            final b.a x = com.baidu.swan.apps.core.h.b.x(Ea.DM());
            wd = x.asK.wd();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a.gH(wd), 0));
            com.baidu.swan.apps.core.h.b.a(x, new b.InterfaceC0134b() { // from class: com.baidu.swan.apps.scheme.actions.h.i.1
                @Override // com.baidu.swan.apps.core.h.b.InterfaceC0134b
                public void onReady() {
                    a.a(x.asK, ap);
                    i.this.d(uy, ap);
                }
            });
        } else {
            wd = yP.dX(ap.axM);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a.gH(wd), 0));
            d(uy, ap);
        }
        if (DEBUG) {
            Log.d("SwitchTabAction", "webview idx: " + wd);
        }
        com.baidu.swan.apps.console.c.i("switchTab", "create and load page");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.swan.apps.core.c.e eVar, com.baidu.swan.apps.model.b bVar) {
        eVar.ea("switchTab").A(0, 0).yW().d(bVar).yZ();
    }
}
