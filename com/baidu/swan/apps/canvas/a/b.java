package com.baidu.swan.apps.canvas.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b extends a {
    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        super.a(unitedSchemeEntity, callbackHandler, z);
    }

    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ JSONObject gm(int i) {
        return super.gm(i);
    }

    public b(j jVar) {
        super(jVar, "/swanAPI/canvas/drawCanvas");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.canvas.b.b c = c(unitedSchemeEntity);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "draw model is null");
            unitedSchemeEntity.result = gm(201);
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "the params is empty");
            return false;
        }
        final String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(c.cLq)) {
            com.baidu.swan.apps.component.e.a.bk("SwanAppAction", "canvasId is empty ");
            unitedSchemeEntity.result = gm(201);
            return false;
        }
        if (TextUtils.isEmpty(c.cLr)) {
            com.baidu.swan.apps.component.e.a.bk("SwanAppAction", "drawCanvas slaveId is empty");
            com.baidu.swan.apps.core.d.e apy = com.baidu.swan.apps.v.f.aAl().apy();
            if (apy != null) {
                c.cLr = apy.apg();
            }
        }
        com.baidu.swan.apps.component.components.d.a aVar = (com.baidu.swan.apps.component.components.d.a) com.baidu.swan.apps.component.container.a.d(c);
        if (aVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the component is null");
            return false;
        }
        boolean a2 = aVar.a(c, new CanvasView.b() { // from class: com.baidu.swan.apps.canvas.a.b.1
            @Override // com.baidu.swan.apps.canvas.view.CanvasView.b
            public void akM() {
                if (optString != null) {
                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(0, "draw complete").toString());
                }
            }
        });
        a(unitedSchemeEntity, callbackHandler, a2);
        return a2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.canvas.a.a
    /* renamed from: d */
    public com.baidu.swan.apps.canvas.b.b c(UnitedSchemeEntity unitedSchemeEntity) {
        return new com.baidu.swan.apps.canvas.b.b(unitedSchemeEntity.getParams().get("params"));
    }
}
