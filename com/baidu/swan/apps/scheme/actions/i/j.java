package com.baidu.swan.apps.scheme.actions.i;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.core.i.b;
import com.baidu.swan.apps.scheme.actions.z;
/* loaded from: classes2.dex */
public class j extends z {
    public j(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/switchTab");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        String wU;
        if (DEBUG) {
            Log.d("SwitchTabAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String b = a.b(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(b)) {
            com.baidu.swan.apps.console.c.e("switchTab", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        com.baidu.swan.apps.w.e FV = com.baidu.swan.apps.w.e.FV();
        final com.baidu.swan.apps.core.d.e vi = FV.vi();
        if (vi == null) {
            com.baidu.swan.apps.console.c.e("switchTab", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b aq = com.baidu.swan.apps.model.b.aq(b, FV.FE());
        if (!ac.a(FV.FD(), aq)) {
            com.baidu.swan.apps.console.c.e("switchTab", "tab params error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        com.baidu.swan.apps.core.d.d zM = vi.zM();
        if (zM == null || TextUtils.isEmpty(zM.dK(aq.ayL))) {
            final b.a x = com.baidu.swan.apps.core.i.b.x(FV.FH());
            wU = x.asY.wU();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a.hb(wU), 0));
            com.baidu.swan.apps.core.i.b.a(x, new b.InterfaceC0137b() { // from class: com.baidu.swan.apps.scheme.actions.i.j.1
                @Override // com.baidu.swan.apps.core.i.b.InterfaceC0137b
                public void onReady() {
                    a.a(x.asY, aq);
                    j.this.d(vi, aq);
                }
            });
        } else {
            wU = zM.dK(aq.ayL);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a.hb(wU), 0));
            d(vi, aq);
        }
        if (DEBUG) {
            Log.d("SwitchTabAction", "webview idx: " + wU);
        }
        com.baidu.swan.apps.console.c.i("switchTab", "create and load page");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.swan.apps.core.d.e eVar, com.baidu.swan.apps.model.b bVar) {
        eVar.dO("switchTab").y(0, 0).zT().d(bVar).zW();
    }
}
