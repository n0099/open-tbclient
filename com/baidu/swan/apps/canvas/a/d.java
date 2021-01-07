package com.baidu.swan.apps.canvas.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d extends a {
    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        super.a(unitedSchemeEntity, callbackHandler, z);
    }

    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ com.baidu.swan.apps.canvas.b.a c(UnitedSchemeEntity unitedSchemeEntity) {
        return super.c(unitedSchemeEntity);
    }

    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ JSONObject hQ(int i) {
        return super.hQ(i);
    }

    public d(j jVar) {
        super(jVar, "/swanAPI/canvas/insert");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        boolean z = false;
        com.baidu.swan.apps.canvas.b.a c = c(unitedSchemeEntity);
        if (c == null) {
            unitedSchemeEntity.result = hQ(201);
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "insert action parse model is null");
        } else if (context == null) {
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "context is null");
            unitedSchemeEntity.result = hQ(1001);
        } else {
            String str = c.cNO;
            com.baidu.swan.apps.model.a.a.a aVar = c.cNS;
            if (TextUtils.isEmpty(str) || aVar == null || !aVar.isValid()) {
                com.baidu.swan.apps.console.c.e("SwanAppCanvas", "canvas id is empty or position is null");
                unitedSchemeEntity.result = hQ(202);
            } else {
                com.baidu.swan.apps.component.b.c aox = new com.baidu.swan.apps.component.components.d.a(context, c).aox();
                z = aox.isSuccess();
                if (!z) {
                    com.baidu.swan.apps.console.c.e("SwanAppCanvas", "insert canvas fail: " + aox.msg);
                }
                a(unitedSchemeEntity, callbackHandler, z);
            }
        }
        return z;
    }
}
