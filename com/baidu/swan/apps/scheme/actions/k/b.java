package com.baidu.swan.apps.scheme.actions.k;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.actions.ab;
/* loaded from: classes9.dex */
public class b extends ab {
    public b(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/exit");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.y.f.Uf().exit();
        return true;
    }
}
