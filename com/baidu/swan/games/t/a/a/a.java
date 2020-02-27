package com.baidu.swan.games.t.a.a;

import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.d.i;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.y.f;
/* loaded from: classes11.dex */
public abstract class a extends ab {
    private final String crU;

    abstract boolean a(@NonNull com.baidu.swan.games.t.a.b.a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(j jVar, String str, String str2) {
        super(jVar, str);
        this.crU = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        com.baidu.swan.apps.core.d.e GA = f.WQ().GA();
        if (GA == null) {
            com.baidu.swan.apps.console.c.e(this.crU, "fragment manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.games.t.a.b.b bVar = (com.baidu.swan.games.t.a.b.b) GA.p(i.class);
        if (bVar == null) {
            com.baidu.swan.apps.console.c.e(this.crU, "fragment is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return a(bVar.OK(), unitedSchemeEntity, callbackHandler);
    }
}
