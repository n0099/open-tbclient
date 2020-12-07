package com.baidu.swan.apps.scheme.actions.k;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.actions.aa;
/* loaded from: classes25.dex */
public class b extends aa {
    public b(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/exit");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.v.f.aCp().exit();
        return true;
    }
}
