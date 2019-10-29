package com.baidu.swan.apps.scheme.actions.i;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.actions.z;
/* loaded from: classes2.dex */
public class b extends z {
    public b(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/exit");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        com.baidu.swan.apps.w.e.LD().exit();
        return true;
    }
}
