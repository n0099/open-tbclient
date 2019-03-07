package com.baidu.swan.apps.canvas.a;

import android.content.Context;
import android.widget.AbsoluteLayout;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends a {
    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ AbsoluteLayout a(UnitedSchemeEntity unitedSchemeEntity, String str) {
        return super.a(unitedSchemeEntity, str);
    }

    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        super.a(unitedSchemeEntity, callbackHandler, z);
    }

    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ JSONObject bQ(int i) {
        return super.bQ(i);
    }

    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ com.baidu.swan.apps.canvas.c.a c(UnitedSchemeEntity unitedSchemeEntity) {
        return super.c(unitedSchemeEntity);
    }

    public d(j jVar) {
        super(jVar, "/swan/canvas/insert");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        boolean z = false;
        com.baidu.swan.apps.canvas.c.a c = c(unitedSchemeEntity);
        if (c == null) {
            unitedSchemeEntity.result = bQ(201);
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "insert action parse model is null");
        } else {
            AbsoluteLayout a = a(unitedSchemeEntity, c.aBC);
            if (a != null && com.baidu.swan.apps.canvas.a.ww().a(context, a, c)) {
                z = true;
            }
            a(unitedSchemeEntity, callbackHandler, z);
        }
        return z;
    }
}
