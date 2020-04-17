package com.baidu.swan.apps.canvas.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.swan.apps.scheme.j;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class h extends a {
    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        super.a(unitedSchemeEntity, callbackHandler, z);
    }

    @Override // com.baidu.swan.apps.canvas.a.a
    public /* bridge */ /* synthetic */ JSONObject eg(int i) {
        return super.eg(i);
    }

    public h(j jVar) {
        super(jVar, "/swanAPI/canvas/toTempFilePath");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar) {
        final String str;
        com.baidu.swan.apps.core.d.d Wf;
        final com.baidu.swan.apps.canvas.b.f d = d(unitedSchemeEntity);
        if (d == null) {
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "CanvasToTempFilePath action parse model is null");
            unitedSchemeEntity.result = eg(201);
            return false;
        }
        String nk = com.baidu.swan.apps.storage.b.nk(eVar.id);
        if (TextUtils.isEmpty(nk)) {
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "CanvasToTempFilePath cache path is empty");
            unitedSchemeEntity.result = eg(201);
            return false;
        }
        String str2 = nk + File.separator + Calendar.getInstance().getTimeInMillis();
        if (d.Sn()) {
            str = str2 + ".jpg";
        } else {
            str = str2 + ComboPraiseProvider.RES_NAME_PRAISE_NUMBER_SUFFIX;
        }
        if (TextUtils.isEmpty(d.bGJ) && (Wf = com.baidu.swan.apps.y.f.aeK().Wf()) != null) {
            d.bGJ = Wf.VQ();
        }
        if (TextUtils.isEmpty(d.bGJ) || TextUtils.isEmpty(d.bGI)) {
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "CanvasToTempFilePath slave id = " + d.bGJ + " ; canvas id = " + d.bGI);
            unitedSchemeEntity.result = eg(201);
            return false;
        }
        final CanvasView a = com.baidu.swan.apps.component.components.d.a.a.a(d);
        if (a == null) {
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "CanvasToTempFilePath canvas view is null");
            unitedSchemeEntity.result = eg(201);
            return false;
        }
        m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.canvas.a.h.1
            /* JADX WARN: Removed duplicated region for block: B:13:0x006a  */
            /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                String str3;
                JSONException e;
                boolean d2 = d.d(a, str);
                HashMap<String, String> params = unitedSchemeEntity.getParams();
                if (params != null && !params.isEmpty()) {
                    String str4 = params.get("params");
                    JSONObject jSONObject = new JSONObject();
                    if (str4 == null) {
                        str3 = null;
                    } else {
                        try {
                            str3 = new JSONObject(str4).optString("cb");
                            try {
                                jSONObject.putOpt("tempFilePath", com.baidu.swan.apps.storage.b.bA(str, eVar.id) + "." + d.So());
                            } catch (JSONException e2) {
                                e = e2;
                                e.printStackTrace();
                                if (TextUtils.isEmpty(str3)) {
                                }
                            }
                        } catch (JSONException e3) {
                            str3 = null;
                            e = e3;
                        }
                    }
                    if (TextUtils.isEmpty(str3)) {
                        callbackHandler.handleSchemeDispatchCallback(str3, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, d2 ? 0 : 1001).toString());
                    }
                }
            }
        }, "tempFilePath");
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.canvas.a.a
    /* renamed from: i */
    public com.baidu.swan.apps.canvas.b.f d(UnitedSchemeEntity unitedSchemeEntity) {
        String str = unitedSchemeEntity.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new com.baidu.swan.apps.canvas.b.f(str);
    }
}
