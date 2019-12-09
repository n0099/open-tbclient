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
        String Cu;
        if (DEBUG) {
            Log.d("SwitchTabAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String b = a.b(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(b)) {
            com.baidu.swan.apps.console.c.e("switchTab", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        com.baidu.swan.apps.w.e LE = com.baidu.swan.apps.w.e.LE();
        final com.baidu.swan.apps.core.d.e AI = LE.AI();
        if (AI == null) {
            com.baidu.swan.apps.console.c.e("switchTab", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b ay = com.baidu.swan.apps.model.b.ay(b, LE.Ln());
        if (!ac.a(LE.Lm(), ay)) {
            com.baidu.swan.apps.console.c.e("switchTab", "tab params error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        com.baidu.swan.apps.core.d.d Ft = AI.Ft();
        if (Ft == null || TextUtils.isEmpty(Ft.ey(ay.aSM))) {
            final b.a z = com.baidu.swan.apps.core.i.b.z(LE.Lq());
            Cu = z.aMY.Cu();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a.hM(Cu), 0));
            com.baidu.swan.apps.core.i.b.a(z, new b.InterfaceC0175b() { // from class: com.baidu.swan.apps.scheme.actions.i.j.1
                @Override // com.baidu.swan.apps.core.i.b.InterfaceC0175b
                public void onReady() {
                    a.a(z.aMY, ay);
                    j.this.d(AI, ay);
                }
            });
        } else {
            Cu = Ft.ey(ay.aSM);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a.hM(Cu), 0));
            d(AI, ay);
        }
        if (DEBUG) {
            Log.d("SwitchTabAction", "webview idx: " + Cu);
        }
        com.baidu.swan.apps.console.c.i("switchTab", "create and load page");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.swan.apps.core.d.e eVar, com.baidu.swan.apps.model.b bVar) {
        eVar.eC("switchTab").F(0, 0).FA().d(bVar).FD();
    }
}
