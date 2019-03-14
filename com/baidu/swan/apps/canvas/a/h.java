package com.baidu.swan.apps.canvas.a;

import android.content.Context;
import android.text.TextUtils;
import android.widget.AbsoluteLayout;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.swan.apps.scheme.j;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h extends a {
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

    public h(j jVar) {
        super(jVar, "/swan/canvas/toTempFilePath");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.ae.b bVar) {
        final String str;
        com.baidu.swan.apps.core.c.d yP;
        final com.baidu.swan.apps.canvas.c.f c = c(unitedSchemeEntity);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "CanvasToTempFilePath action parse model is null");
            unitedSchemeEntity.result = bQ(201);
            return false;
        }
        String gX = com.baidu.swan.apps.storage.b.gX(bVar.id);
        if (TextUtils.isEmpty(gX)) {
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "CanvasToTempFilePath cache path is empty");
            unitedSchemeEntity.result = bQ(201);
            return false;
        }
        String str2 = gX + File.separator + Calendar.getInstance().getTimeInMillis();
        if (c.wE()) {
            str = str2 + ".jpg";
        } else {
            str = str2 + ".png";
        }
        if (TextUtils.isEmpty(c.aBD) && (yP = com.baidu.swan.apps.w.e.Ec().yP()) != null) {
            c.aBD = yP.yB();
        }
        if (TextUtils.isEmpty(c.aBD) || TextUtils.isEmpty(c.id)) {
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "CanvasToTempFilePath slave id = " + c.aBD + " ; canvas id = " + c.id);
            unitedSchemeEntity.result = bQ(201);
            return false;
        }
        final CanvasView b = com.baidu.swan.apps.canvas.a.ww().b(c);
        if (b == null) {
            com.baidu.swan.apps.console.c.e("SwanAppCanvas", "CanvasToTempFilePath canvas view is null");
            unitedSchemeEntity.result = bQ(201);
            return false;
        }
        com.baidu.swan.apps.an.j.a(new Runnable() { // from class: com.baidu.swan.apps.canvas.a.h.1
            /* JADX WARN: Removed duplicated region for block: B:13:0x006a  */
            /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                String str3;
                JSONException e;
                boolean d = c.d(b, str);
                HashMap<String, String> params = unitedSchemeEntity.getParams();
                if (params != null && !params.isEmpty()) {
                    String str4 = params.get(LegoListActivityConfig.PARAMS);
                    JSONObject jSONObject = new JSONObject();
                    if (str4 == null) {
                        str3 = null;
                    } else {
                        try {
                            str3 = new JSONObject(str4).optString("cb");
                            try {
                                jSONObject.putOpt("tempFilePath", com.baidu.swan.apps.storage.b.aD(str, bVar.id) + "." + c.wF());
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
                        callbackHandler.handleSchemeDispatchCallback(str3, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, d ? 0 : 1001).toString());
                    }
                }
            }
        }, "tempFilePath");
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.canvas.a.a
    /* renamed from: h */
    public com.baidu.swan.apps.canvas.c.f c(UnitedSchemeEntity unitedSchemeEntity) {
        String str = unitedSchemeEntity.getParams().get(LegoListActivityConfig.PARAMS);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new com.baidu.swan.apps.canvas.c.f(str);
    }
}
