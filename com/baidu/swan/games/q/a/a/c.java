package com.baidu.swan.games.q.a.a;

import android.support.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes2.dex */
public class c extends a {
    public c(j jVar) {
        super(jVar, "/swan/showShareMenu", "showShareMenu");
    }

    @Override // com.baidu.swan.games.q.a.a.a
    boolean a(@NonNull com.baidu.swan.games.q.a.b.a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        aVar.XT();
        b(unitedSchemeEntity, callbackHandler);
        return true;
    }
}
