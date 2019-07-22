package com.baidu.swan.apps.media.d.a;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes2.dex */
public class c extends g {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public c(String str) {
        super(str);
    }

    @Override // com.baidu.swan.apps.media.d.a.g
    public boolean a(com.baidu.swan.apps.media.d.a aVar, com.baidu.swan.apps.media.d.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        com.baidu.swan.apps.console.c.i("video", "open, video id:" + cVar.aBc + " slave id: " + cVar.aDU);
        aVar.Fl();
        a(aVar, cVar, unitedSchemeEntity, callbackHandler);
        return true;
    }

    private void a(com.baidu.swan.apps.media.d.a aVar, com.baidu.swan.apps.media.d.c cVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        aVar.d(cVar);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }
}
