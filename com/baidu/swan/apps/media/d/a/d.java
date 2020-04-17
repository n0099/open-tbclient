package com.baidu.swan.apps.media.d.a;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes11.dex */
public class d extends c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public d(String str) {
        super(str);
    }

    @Override // com.baidu.swan.apps.media.d.a.c
    public boolean a(com.baidu.swan.apps.media.d.a aVar, com.baidu.swan.apps.media.d.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.console.c.i("vrvideo", "remove, video id:" + cVar.bYS + " slave id: " + cVar.bGJ);
        b(aVar, cVar, unitedSchemeEntity, callbackHandler);
        return true;
    }

    private void b(com.baidu.swan.apps.media.d.a aVar, com.baidu.swan.apps.media.d.c cVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        com.baidu.swan.apps.component.b.a d = com.baidu.swan.apps.component.container.a.d(cVar);
        if (d != null) {
            d.Sy();
        } else {
            com.baidu.swan.apps.component.e.a.aC("VrVideoRemoveAction", "remove with a null component");
        }
        aVar.onDestroy();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }
}
