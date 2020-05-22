package com.baidu.swan.games.u.a.a;

import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.d.i;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.w.f;
/* loaded from: classes11.dex */
public abstract class a extends aa {
    private final String dcd;

    abstract boolean a(@NonNull com.baidu.swan.games.u.a.b.a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(j jVar, String str, String str2) {
        super(jVar, str);
        this.dcd = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        com.baidu.swan.apps.core.d.e QH = f.ahV().QH();
        if (QH == null) {
            com.baidu.swan.apps.console.c.e(this.dcd, "fragment manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.games.u.a.b.b bVar = (com.baidu.swan.games.u.a.b.b) QH.q(i.class);
        if (bVar == null) {
            com.baidu.swan.apps.console.c.e(this.dcd, "fragment is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return a(bVar.Zp(), unitedSchemeEntity, callbackHandler);
    }
}
