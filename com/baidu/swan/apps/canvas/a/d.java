package com.baidu.swan.apps.canvas.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d extends a {
    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        super.a(unitedSchemeEntity, callbackHandler, z);
    }

    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ com.baidu.swan.apps.canvas.b.a d(UnitedSchemeEntity unitedSchemeEntity) {
        return super.d(unitedSchemeEntity);
    }

    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ JSONObject dL(int i) {
        return super.dL(i);
    }

    public d(j jVar) {
        super(jVar, "/swanAPI/canvas/insert");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        boolean z = false;
        com.baidu.swan.apps.canvas.b.a d = d(unitedSchemeEntity);
        if (d == null) {
            unitedSchemeEntity.result = dL(201);
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "insert action parse model is null");
        } else if (context == null) {
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "context is null");
            unitedSchemeEntity.result = dL(1001);
        } else {
            String str = d.bdV;
            com.baidu.swan.apps.model.a.a.a aVar = d.bdZ;
            if (TextUtils.isEmpty(str) || aVar == null || !aVar.isValid()) {
                com.baidu.swan.apps.console.c.e("SwanAppCanvas", "canvas id is empty or position is null");
                unitedSchemeEntity.result = dL(202);
            } else {
                com.baidu.swan.apps.component.b.c Io = new com.baidu.swan.apps.component.components.d.a(context, d).Io();
                z = Io.isSuccess();
                if (!z) {
                    com.baidu.swan.apps.console.c.e("SwanAppCanvas", "insert canvas fail: " + Io.msg);
                }
                a(unitedSchemeEntity, callbackHandler, z);
            }
        }
        return z;
    }
}
