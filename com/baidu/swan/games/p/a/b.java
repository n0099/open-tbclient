package com.baidu.swan.games.p.a;

import android.support.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes2.dex */
public class b extends a {
    public b(j jVar) {
        super(jVar, "/swan/hideShareMenu", "hideShareMenu");
    }

    @Override // com.baidu.swan.games.p.a.a
    boolean a(@NonNull com.baidu.swan.games.p.b.a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        aVar.OW();
        b(unitedSchemeEntity, callbackHandler);
        return true;
    }
}
