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
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
/* loaded from: classes2.dex */
public class i extends y {
    public i(j jVar) {
        super(jVar, "/swan/switchTab");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        String we;
        if (DEBUG) {
            Log.d("SwitchTabAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String b = a.b(unitedSchemeEntity, LegoListActivityConfig.PARAMS);
        if (TextUtils.isEmpty(b)) {
            com.baidu.swan.apps.console.c.e("switchTab", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        com.baidu.swan.apps.w.e Ec = com.baidu.swan.apps.w.e.Ec();
        final com.baidu.swan.apps.core.c.e uz = Ec.uz();
        if (uz == null) {
            com.baidu.swan.apps.console.c.e("switchTab", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b ap = com.baidu.swan.apps.model.b.ap(b, Ec.DL());
        if (!aa.a(Ec.DK(), ap)) {
            com.baidu.swan.apps.console.c.e("switchTab", "tab params error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        com.baidu.swan.apps.core.c.d yQ = uz.yQ();
        if (yQ == null || TextUtils.isEmpty(yQ.dV(ap.axI))) {
            final b.a x = com.baidu.swan.apps.core.h.b.x(Ec.DO());
            we = x.asF.we();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a.gG(we), 0));
            com.baidu.swan.apps.core.h.b.a(x, new b.InterfaceC0134b() { // from class: com.baidu.swan.apps.scheme.actions.h.i.1
                @Override // com.baidu.swan.apps.core.h.b.InterfaceC0134b
                public void onReady() {
                    a.a(x.asF, ap);
                    i.this.d(uz, ap);
                }
            });
        } else {
            we = yQ.dV(ap.axI);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a.gG(we), 0));
            d(uz, ap);
        }
        if (DEBUG) {
            Log.d("SwitchTabAction", "webview idx: " + we);
        }
        com.baidu.swan.apps.console.c.i("switchTab", "create and load page");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.swan.apps.core.c.e eVar, com.baidu.swan.apps.model.b bVar) {
        eVar.dY("switchTab").A(0, 0).yX().d(bVar).za();
    }
}
