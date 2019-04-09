package com.baidu.swan.games.p.a;

import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.c.e;
import com.baidu.swan.apps.core.c.h;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes2.dex */
public abstract class a extends y {
    private final String bfi;

    abstract boolean a(@NonNull com.baidu.swan.games.p.b.a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(j jVar, String str, String str2) {
        super(jVar, str);
        this.bfi = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        e uy = com.baidu.swan.apps.w.e.Ea().uy();
        if (uy == null) {
            com.baidu.swan.apps.console.c.e(this.bfi, "fragment manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.games.p.b.b bVar2 = (com.baidu.swan.games.p.b.b) uy.l(h.class);
        if (bVar2 == null) {
            com.baidu.swan.apps.console.c.e(this.bfi, "fragment is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return a(bVar2.zi(), unitedSchemeEntity, callbackHandler);
    }
}
