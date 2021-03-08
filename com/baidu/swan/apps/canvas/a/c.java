package com.baidu.swan.apps.canvas.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ao.p;
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
    public /* bridge */ /* synthetic */ JSONObject gn(int i) {
        return super.gn(i);
    }

    public c(j jVar) {
        super(jVar, "/swanAPI/canvas/getImageData");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.core.d.e apB;
        final com.baidu.swan.apps.canvas.b.c c = c(unitedSchemeEntity);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "CanvasGetImageData action parse model is null");
            unitedSchemeEntity.result = gn(201);
            return false;
        }
        if (TextUtils.isEmpty(c.cMR) && (apB = com.baidu.swan.apps.v.f.aAo().apB()) != null) {
            c.cMR = apB.apk();
        }
        if (TextUtils.isEmpty(c.cMR) || TextUtils.isEmpty(c.cMQ)) {
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "CanvasGetImageData slave id = " + c.cMR + " ; canvas id = " + c.cMQ);
            unitedSchemeEntity.result = gn(201);
            return false;
        }
        final CanvasView a2 = com.baidu.swan.apps.component.components.d.a.a.a(c);
        if (a2 == null) {
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "CanvasGetImageData canvas view is null");
            unitedSchemeEntity.result = gn(201);
            return false;
        }
        p.a(new Runnable() { // from class: com.baidu.swan.apps.canvas.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject ar = c.ar(a2);
                String str = c.callback;
                if (!TextUtils.isEmpty(str)) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(ar, 0).toString());
                }
            }
        }, "CanvasGetImageDataAction");
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.canvas.a.a
    /* renamed from: e */
    public com.baidu.swan.apps.canvas.b.c c(UnitedSchemeEntity unitedSchemeEntity) {
        String str = unitedSchemeEntity.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new com.baidu.swan.apps.canvas.b.c(str);
    }
}
