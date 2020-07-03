package com.baidu.swan.apps.canvas.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends a {
    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        super.a(unitedSchemeEntity, callbackHandler, z);
    }

    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ JSONObject eC(int i) {
        return super.eC(i);
    }

    public b(j jVar) {
        super(jVar, "/swanAPI/canvas/drawCanvas");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.canvas.b.b d = d(unitedSchemeEntity);
        if (d == null) {
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "draw model is null");
            unitedSchemeEntity.result = eC(201);
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "the params is empty");
            return false;
        }
        final String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(d.bUt)) {
            com.baidu.swan.apps.component.e.a.aU("SwanAppAction", "canvasId is empty ");
            unitedSchemeEntity.result = eC(201);
            return false;
        }
        if (TextUtils.isEmpty(d.bUu)) {
            com.baidu.swan.apps.component.e.a.aU("SwanAppAction", "drawCanvas slaveId is empty");
            com.baidu.swan.apps.core.d.d ZW = com.baidu.swan.apps.w.f.ajb().ZW();
            if (ZW != null) {
                d.bUu = ZW.ZH();
            }
        }
        com.baidu.swan.apps.component.components.d.a aVar = (com.baidu.swan.apps.component.components.d.a) com.baidu.swan.apps.component.container.a.d(d);
        if (aVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the component is null");
            return false;
        }
        boolean a = aVar.a(d, new CanvasView.b() { // from class: com.baidu.swan.apps.canvas.a.b.1
            @Override // com.baidu.swan.apps.canvas.view.CanvasView.b
            public void VW() {
                if (optString != null) {
                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(0, "draw complete").toString());
                }
            }
        });
        a(unitedSchemeEntity, callbackHandler, a);
        return a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.canvas.a.a
    /* renamed from: e */
    public com.baidu.swan.apps.canvas.b.b d(UnitedSchemeEntity unitedSchemeEntity) {
        return new com.baidu.swan.apps.canvas.b.b(unitedSchemeEntity.getParams().get("params"));
    }
}
