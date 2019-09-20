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
        String xz;
        if (DEBUG) {
            Log.d("SwitchTabAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String b = a.b(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(b)) {
            com.baidu.swan.apps.console.c.e("switchTab", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        com.baidu.swan.apps.w.e GJ = com.baidu.swan.apps.w.e.GJ();
        final com.baidu.swan.apps.core.d.e vN = GJ.vN();
        if (vN == null) {
            com.baidu.swan.apps.console.c.e("switchTab", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b aq = com.baidu.swan.apps.model.b.aq(b, GJ.Gs());
        if (!ac.a(GJ.Gr(), aq)) {
            com.baidu.swan.apps.console.c.e("switchTab", "tab params error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        com.baidu.swan.apps.core.d.d Ax = vN.Ax();
        if (Ax == null || TextUtils.isEmpty(Ax.dQ(aq.azQ))) {
            final b.a A = com.baidu.swan.apps.core.i.b.A(GJ.Gv());
            xz = A.atZ.xz();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a.hj(xz), 0));
            com.baidu.swan.apps.core.i.b.a(A, new b.InterfaceC0148b() { // from class: com.baidu.swan.apps.scheme.actions.i.j.1
                @Override // com.baidu.swan.apps.core.i.b.InterfaceC0148b
                public void onReady() {
                    a.a(A.atZ, aq);
                    j.this.d(vN, aq);
                }
            });
        } else {
            xz = Ax.dQ(aq.azQ);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a.hj(xz), 0));
            d(vN, aq);
        }
        if (DEBUG) {
            Log.d("SwitchTabAction", "webview idx: " + xz);
        }
        com.baidu.swan.apps.console.c.i("switchTab", "create and load page");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.swan.apps.core.d.e eVar, com.baidu.swan.apps.model.b bVar) {
        eVar.dU("switchTab").B(0, 0).AE().d(bVar).AH();
    }
}
