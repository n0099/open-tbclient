package com.baidu.swan.games.q.a.a;

import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.core.d.h;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes2.dex */
public abstract class a extends z {
    private final String bDh;

    abstract boolean a(@NonNull com.baidu.swan.games.q.a.b.a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(j jVar, String str, String str2) {
        super(jVar, str);
        this.bDh = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        e AI = com.baidu.swan.apps.w.e.LE().AI();
        if (AI == null) {
            com.baidu.swan.apps.console.c.e(this.bDh, "fragment manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.games.q.a.b.b bVar2 = (com.baidu.swan.games.q.a.b.b) AI.i(h.class);
        if (bVar2 == null) {
            com.baidu.swan.apps.console.c.e(this.bDh, "fragment is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return a(bVar2.FN(), unitedSchemeEntity, callbackHandler);
    }
}
