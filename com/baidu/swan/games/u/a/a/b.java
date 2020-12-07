package com.baidu.swan.games.u.a.a;

import android.support.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes25.dex */
public class b extends a {
    public b(j jVar) {
        super(jVar, "/swanAPI/hideShareMenu", "hideShareMenu");
    }

    @Override // com.baidu.swan.games.u.a.a.a
    boolean a(@NonNull com.baidu.swan.games.u.a.b.a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        aVar.aZs();
        c(unitedSchemeEntity, callbackHandler);
        return true;
    }
}
