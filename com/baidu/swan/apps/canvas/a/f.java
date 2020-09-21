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
/* loaded from: classes3.dex */
public class f extends a {
    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        super.a(unitedSchemeEntity, callbackHandler, z);
    }

    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ JSONObject gK(int i) {
        return super.gK(i);
    }

    public f(j jVar) {
        super(jVar, "/swanAPI/canvas/putImageData");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.core.d.e ahX;
        final com.baidu.swan.apps.canvas.b.e d = d(unitedSchemeEntity);
        if (d == null) {
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "CanvasPutImageData action parse model is null");
            unitedSchemeEntity.result = gK(201);
            return false;
        }
        if (TextUtils.isEmpty(d.cda) && (ahX = com.baidu.swan.apps.v.f.asJ().ahX()) != null) {
            d.cda = ahX.ahG();
        }
        if (TextUtils.isEmpty(d.cda) || TextUtils.isEmpty(d.ccZ)) {
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "CanvasPutImageData slave id = " + d.cda + " ; canvas id = " + d.ccZ);
            unitedSchemeEntity.result = gK(201);
            return false;
        }
        final CanvasView a = com.baidu.swan.apps.component.components.d.a.a.a(d);
        if (a == null) {
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "CanvasPutImageData canvas view is null");
            unitedSchemeEntity.result = gK(201);
            return false;
        }
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.canvas.a.f.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject wrapCallbackParams;
                int adx = d.adx();
                if (adx != 0) {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(adx, f.this.gL(adx));
                } else {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(0);
                    a.g(d.ady(), d.adz());
                    a.postInvalidate();
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

    /* JADX INFO: Access modifiers changed from: private */
    public String gL(int i) {
        switch (i) {
            case 2001:
                return "data length invalid";
            case 2002:
                return "width / height must > 0";
            default:
                return "error draw on canvas";
        }
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
