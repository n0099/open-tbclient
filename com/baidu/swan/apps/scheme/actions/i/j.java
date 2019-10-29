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
        String Ct;
        if (DEBUG) {
            Log.d("SwitchTabAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String b = a.b(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(b)) {
            com.baidu.swan.apps.console.c.e("switchTab", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        com.baidu.swan.apps.w.e LD = com.baidu.swan.apps.w.e.LD();
        final com.baidu.swan.apps.core.d.e AH = LD.AH();
        if (AH == null) {
            com.baidu.swan.apps.console.c.e("switchTab", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b ay = com.baidu.swan.apps.model.b.ay(b, LD.Lm());
        if (!ac.a(LD.Ll(), ay)) {
            com.baidu.swan.apps.console.c.e("switchTab", "tab params error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        com.baidu.swan.apps.core.d.d Fs = AH.Fs();
        if (Fs == null || TextUtils.isEmpty(Fs.ey(ay.aTe))) {
            final b.a z = com.baidu.swan.apps.core.i.b.z(LD.Lp());
            Ct = z.aNq.Ct();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a.hM(Ct), 0));
            com.baidu.swan.apps.core.i.b.a(z, new b.InterfaceC0180b() { // from class: com.baidu.swan.apps.scheme.actions.i.j.1
                @Override // com.baidu.swan.apps.core.i.b.InterfaceC0180b
                public void onReady() {
                    a.a(z.aNq, ay);
                    j.this.d(AH, ay);
                }
            });
        } else {
            Ct = Fs.ey(ay.aTe);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a.hM(Ct), 0));
            d(AH, ay);
        }
        if (DEBUG) {
            Log.d("SwitchTabAction", "webview idx: " + Ct);
        }
        com.baidu.swan.apps.console.c.i("switchTab", "create and load page");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.swan.apps.core.d.e eVar, com.baidu.swan.apps.model.b bVar) {
        eVar.eC("switchTab").H(0, 0).Fz().d(bVar).FC();
    }
}
