package com.baidu.swan.apps.canvas.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends a {
    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        super.a(unitedSchemeEntity, callbackHandler, z);
    }

    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ JSONObject gB(int i) {
        return super.gB(i);
    }

    public c(j jVar) {
        super(jVar, "/swanAPI/canvas/getImageData");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.core.d.e ahn;
        final com.baidu.swan.apps.canvas.b.c d = d(unitedSchemeEntity);
        if (d == null) {
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "CanvasGetImageData action parse model is null");
            unitedSchemeEntity.result = gB(201);
            return false;
        }
        if (TextUtils.isEmpty(d.caU) && (ahn = com.baidu.swan.apps.v.f.arY().ahn()) != null) {
            d.caU = ahn.agW();
        }
        if (TextUtils.isEmpty(d.caU) || TextUtils.isEmpty(d.caT)) {
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "CanvasGetImageData slave id = " + d.caU + " ; canvas id = " + d.caT);
            unitedSchemeEntity.result = gB(201);
            return false;
        }
        final CanvasView a = com.baidu.swan.apps.component.components.d.a.a.a(d);
        if (a == null) {
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "CanvasGetImageData canvas view is null");
            unitedSchemeEntity.result = gB(201);
            return false;
        }
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.canvas.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject aj = d.aj(a);
                String str = d.callback;
                if (!TextUtils.isEmpty(str)) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(aj, 0).toString());
                }
            }
        }, "CanvasGetImageDataAction");
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.canvas.a.a
    /* renamed from: f */
    public com.baidu.swan.apps.canvas.b.c d(UnitedSchemeEntity unitedSchemeEntity) {
        String str = unitedSchemeEntity.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new com.baidu.swan.apps.canvas.b.c(str);
    }
}
