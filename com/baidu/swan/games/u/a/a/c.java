package com.baidu.swan.games.u.a.a;

import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes9.dex */
public class c extends a {
    public c(j jVar) {
        super(jVar, "/swanAPI/showShareMenu", "showShareMenu");
    }

    @Override // com.baidu.swan.games.u.a.a.a
    boolean a(@NonNull com.baidu.swan.games.u.a.b.a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        aVar.bbL();
        c(unitedSchemeEntity, callbackHandler);
        return true;
    }
}
