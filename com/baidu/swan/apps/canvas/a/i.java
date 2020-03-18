package com.baidu.swan.apps.canvas.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class i extends a {
    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        super.a(unitedSchemeEntity, callbackHandler, z);
    }

    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ com.baidu.swan.apps.canvas.b.a d(UnitedSchemeEntity unitedSchemeEntity) {
        return super.d(unitedSchemeEntity);
    }

    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ JSONObject eb(int i) {
        return super.eb(i);
    }

    public i(j jVar) {
        super(jVar, "/swanAPI/canvas/update");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.canvas.b.a d = d(unitedSchemeEntity);
        if (d == null) {
            unitedSchemeEntity.result = eb(201);
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "update action parse model is null");
            return false;
        }
        String str = d.biA;
        com.baidu.swan.apps.model.a.a.a aVar = d.biE;
        if (TextUtils.isEmpty(str) || aVar == null || !aVar.isValid()) {
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "some params invalid");
            unitedSchemeEntity.result = eb(202);
            return false;
        }
        com.baidu.swan.apps.component.components.d.a aVar2 = (com.baidu.swan.apps.component.components.d.a) com.baidu.swan.apps.component.container.a.d(d);
        if (aVar2 == null) {
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "update canvas fail: fina a null component");
            unitedSchemeEntity.result = eb(1001);
            return false;
        }
        com.baidu.swan.apps.component.b.c a = aVar2.a((com.baidu.swan.apps.component.components.d.a) d);
        boolean isSuccess = a.isSuccess();
        if (!isSuccess) {
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "update canvas fail: " + a.msg);
        }
        a(unitedSchemeEntity, callbackHandler, isSuccess);
        return isSuccess;
    }
}
