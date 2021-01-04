package com.baidu.swan.apps.camera.a;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes9.dex */
public class c extends a {
    public c(j jVar) {
        super(jVar, "/swanAPI/camera/remove");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (!(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.component.components.c.a aVar = (com.baidu.swan.apps.component.components.c.a) com.baidu.swan.apps.component.container.a.d(b(unitedSchemeEntity));
        if (aVar != null) {
            com.baidu.swan.apps.component.b.c aoy = aVar.aoy();
            if (!aoy.isSuccess()) {
                com.baidu.swan.apps.console.c.e("CameraRemoveAction", "remove camera fail: " + aoy.msg);
            }
            a(unitedSchemeEntity, callbackHandler, true);
            return true;
        }
        a(unitedSchemeEntity, callbackHandler, false);
        return false;
    }

    @Override // com.baidu.swan.apps.camera.a.a
    protected com.baidu.swan.apps.component.b.b b(UnitedSchemeEntity unitedSchemeEntity) {
        String a2 = a(unitedSchemeEntity);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("CameraRemoveAction", "parseData:" + a2);
        }
        return new com.baidu.swan.apps.camera.d.a(a2);
    }
}
