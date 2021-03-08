package com.baidu.swan.apps.canvas.a;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class g extends a {
    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        super.a(unitedSchemeEntity, callbackHandler, z);
    }

    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ com.baidu.swan.apps.canvas.b.a c(UnitedSchemeEntity unitedSchemeEntity) {
        return super.c(unitedSchemeEntity);
    }

    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ JSONObject gn(int i) {
        return super.gn(i);
    }

    public g(j jVar) {
        super(jVar, "/swanAPI/canvas/remove");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.canvas.b.a c = c(unitedSchemeEntity);
        if (c == null) {
            unitedSchemeEntity.result = gn(201);
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "remove action parse model is null");
            return false;
        }
        com.baidu.swan.apps.component.components.d.a aVar = (com.baidu.swan.apps.component.components.d.a) com.baidu.swan.apps.component.container.a.d(c);
        if (aVar == null) {
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "remove canvas fail: fina a null component");
            unitedSchemeEntity.result = gn(1001);
            return false;
        }
        com.baidu.swan.apps.component.b.c alg = aVar.alg();
        boolean isSuccess = alg.isSuccess();
        if (!isSuccess) {
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "remove canvas fail: " + alg.msg);
        }
        a(unitedSchemeEntity, callbackHandler, isSuccess);
        return isSuccess;
    }
}
