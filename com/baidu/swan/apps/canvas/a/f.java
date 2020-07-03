package com.baidu.swan.apps.canvas.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f extends a {
    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        super.a(unitedSchemeEntity, callbackHandler, z);
    }

    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ JSONObject eC(int i) {
        return super.eC(i);
    }

    public f(j jVar) {
        super(jVar, "/swanAPI/canvas/putImageData");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.core.d.d ZW;
        final com.baidu.swan.apps.canvas.b.e d = d(unitedSchemeEntity);
        if (d == null) {
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "CanvasPutImageData action parse model is null");
            unitedSchemeEntity.result = eC(201);
            return false;
        }
        if (TextUtils.isEmpty(d.bUu) && (ZW = com.baidu.swan.apps.w.f.ajb().ZW()) != null) {
            d.bUu = ZW.ZH();
        }
        if (TextUtils.isEmpty(d.bUu) || TextUtils.isEmpty(d.bUt)) {
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "CanvasPutImageData slave id = " + d.bUu + " ; canvas id = " + d.bUt);
            unitedSchemeEntity.result = eC(201);
            return false;
        }
        final CanvasView a = com.baidu.swan.apps.component.components.d.a.a.a(d);
        if (a == null) {
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "CanvasPutImageData canvas view is null");
            unitedSchemeEntity.result = eC(201);
            return false;
        }
        n.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.canvas.a.f.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject wrapCallbackParams;
                if (d.Wb()) {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(0);
                    a.g(d.Wc(), d.Wd());
                    a.postInvalidate();
                } else {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "error draw on canvas");
                }
                String str = d.callback;
                if (!TextUtils.isEmpty(str)) {
                    callbackHandler.handleSchemeDispatchCallback(str, wrapCallbackParams.toString());
                }
            }
        }, "CanvasPutImageDataAction");
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.canvas.a.a
    /* renamed from: h */
    public com.baidu.swan.apps.canvas.b.e d(UnitedSchemeEntity unitedSchemeEntity) {
        String str = unitedSchemeEntity.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new com.baidu.swan.apps.canvas.b.e(str);
    }
}
