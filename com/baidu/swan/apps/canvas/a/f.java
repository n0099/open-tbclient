package com.baidu.swan.apps.canvas.a;

import android.content.Context;
import android.text.TextUtils;
import android.widget.AbsoluteLayout;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends a {
    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ AbsoluteLayout a(UnitedSchemeEntity unitedSchemeEntity, String str) {
        return super.a(unitedSchemeEntity, str);
    }

    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        super.a(unitedSchemeEntity, callbackHandler, z);
    }

    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ JSONObject cM(int i) {
        return super.cM(i);
    }

    public f(j jVar) {
        super(jVar, "/swan/canvas/putImageData");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        com.baidu.swan.apps.core.d.d Fs;
        final com.baidu.swan.apps.canvas.c.e c = c(unitedSchemeEntity);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "CanvasPutImageData action parse model is null");
            unitedSchemeEntity.result = cM(201);
            return false;
        }
        if (TextUtils.isEmpty(c.aXp) && (Fs = com.baidu.swan.apps.w.e.LE().Fs()) != null) {
            c.aXp = Fs.Fc();
        }
        if (TextUtils.isEmpty(c.aXp) || TextUtils.isEmpty(c.id)) {
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "CanvasPutImageData slave id = " + c.aXp + " ; canvas id = " + c.id);
            unitedSchemeEntity.result = cM(201);
            return false;
        }
        final CanvasView b = com.baidu.swan.apps.canvas.a.CP().b(c);
        if (b == null) {
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "CanvasPutImageData canvas view is null");
            unitedSchemeEntity.result = cM(201);
            return false;
        }
        com.baidu.swan.apps.an.j.a(new Runnable() { // from class: com.baidu.swan.apps.canvas.a.f.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject wrapCallbackParams;
                if (c.CW()) {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(0);
                    b.f(c.CX(), c.CY());
                    b.postInvalidate();
                } else {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "error draw on canvas");
                }
                String str = c.callback;
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
    /* renamed from: g */
    public com.baidu.swan.apps.canvas.c.e c(UnitedSchemeEntity unitedSchemeEntity) {
        String str = unitedSchemeEntity.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new com.baidu.swan.apps.canvas.c.e(str);
    }
}
