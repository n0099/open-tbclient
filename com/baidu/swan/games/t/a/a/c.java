package com.baidu.swan.games.t.a.a;

import android.support.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes11.dex */
public class c extends a {
    public c(j jVar) {
        super(jVar, "/swanAPI/showShareMenu", "showShareMenu");
    }

    @Override // com.baidu.swan.games.t.a.a.a
    boolean a(@NonNull com.baidu.swan.games.t.a.b.a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        aVar.apw();
        b(unitedSchemeEntity, callbackHandler);
        return true;
    }
}
