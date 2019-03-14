package com.baidu.swan.apps.camera.a;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.view.container.SwanAppNAViewContainer;
/* loaded from: classes2.dex */
public class c extends a {
    public c(j jVar) {
        super(jVar, "/swan/camera/remove");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (!(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.model.a.a.a b = b(unitedSchemeEntity);
        if (com.baidu.swan.apps.w.e.Ec().eO(b.aBD) != null) {
            SwanAppNAViewContainer a = com.baidu.swan.apps.view.container.c.b.a(b, null);
            if (a != null) {
                a.MK();
            }
            com.baidu.swan.apps.camera.a.wn().dq(b.aBD);
            a(unitedSchemeEntity, callbackHandler, true);
            return true;
        }
        a(unitedSchemeEntity, callbackHandler, false);
        return false;
    }

    @Override // com.baidu.swan.apps.camera.a.a
    protected com.baidu.swan.apps.model.a.a.a b(UnitedSchemeEntity unitedSchemeEntity) {
        String a = a(unitedSchemeEntity);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("CameraRemoveAction", "parseData:" + a);
        }
        return new com.baidu.swan.apps.camera.d.a(a);
    }
}
