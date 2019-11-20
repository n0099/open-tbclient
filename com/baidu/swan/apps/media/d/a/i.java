package com.baidu.swan.apps.media.d.a;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes2.dex */
public class i extends g {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public i(String str) {
        super(str);
    }

    @Override // com.baidu.swan.apps.media.d.a.g
    public boolean a(com.baidu.swan.apps.media.d.a aVar, com.baidu.swan.apps.media.d.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        com.baidu.swan.apps.console.c.i("video", "seek, video id:" + cVar.aUw + " slave id: " + cVar.aXp);
        a(aVar, cVar.mPos, unitedSchemeEntity, callbackHandler);
        return true;
    }

    private void a(com.baidu.swan.apps.media.d.a aVar, int i, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        aVar.seekTo(i * 1000);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }
}
