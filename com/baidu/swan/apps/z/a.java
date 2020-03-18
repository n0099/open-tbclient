package com.baidu.swan.apps.z;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.z.a.f;
import com.baidu.swan.apps.z.a.g;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends ab {
    public a(j jVar) {
        super(jVar, "/swanAPI/map");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (DEBUG) {
            Log.d("MapAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean e(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        boolean a;
        if (DEBUG) {
            Log.d("MapAction", "handleSubAction subAction: " + str);
        }
        c.i("map", "handleSubAction " + str);
        b a2 = b.a(unitedSchemeEntity, callbackHandler);
        char c = 65535;
        switch (str.hashCode()) {
            case -2079680864:
                if (str.equals("/swanAPI/map/translateMarker")) {
                    c = 3;
                    break;
                }
                break;
            case -2068557416:
                if (str.equals("/swanAPI/map/getCenterLocation")) {
                    c = '\t';
                    break;
                }
                break;
            case -398143716:
                if (str.equals("/swanAPI/map/getScale")) {
                    c = 7;
                    break;
                }
                break;
            case 51993511:
                if (str.equals("/swanAPI/map/openLocation")) {
                    c = 4;
                    break;
                }
                break;
            case 379323012:
                if (str.equals("/swanAPI/map/create")) {
                    c = 0;
                    break;
                }
                break;
            case 515840866:
                if (str.equals("/swanAPI/map/getRegion")) {
                    c = '\b';
                    break;
                }
                break;
            case 797006348:
                if (str.equals("/swanAPI/map/remove")) {
                    c = 2;
                    break;
                }
                break;
            case 892770897:
                if (str.equals("/swanAPI/map/update")) {
                    c = 1;
                    break;
                }
                break;
            case 1007473955:
                if (str.equals("/swanAPI/map/includePoints")) {
                    c = 6;
                    break;
                }
                break;
            case 1142165295:
                if (str.equals("/swanAPI/map/openWalkNavigation")) {
                    c = 11;
                    break;
                }
                break;
            case 1256916873:
                if (str.equals("/swanAPI/map/moveToLocation")) {
                    c = 5;
                    break;
                }
                break;
            case 1475857524:
                if (str.equals("/swanAPI/map/chooseLocation")) {
                    c = '\n';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                com.baidu.swan.apps.z.a.c a3 = a(unitedSchemeEntity, com.baidu.swan.apps.z.a.c.class);
                if (!a(a3, a2)) {
                    a = com.baidu.swan.apps.w.a.Uk().a(context, a3, a2, eVar);
                    break;
                } else {
                    a = false;
                    break;
                }
            case 1:
                com.baidu.swan.apps.z.a.c a4 = a(unitedSchemeEntity, com.baidu.swan.apps.z.a.c.class);
                if (!a(a4, a2)) {
                    a = com.baidu.swan.apps.w.a.Uk().b(context, a4, a2, eVar);
                    break;
                } else {
                    a = false;
                    break;
                }
            case 2:
                com.baidu.swan.apps.z.a.c a5 = a(unitedSchemeEntity, com.baidu.swan.apps.z.a.c.class);
                if (!a(a5, a2)) {
                    a = com.baidu.swan.apps.w.a.Uk().c(context, a5, a2, eVar);
                    break;
                } else {
                    a = false;
                    break;
                }
            case 3:
                f fVar = (f) a(unitedSchemeEntity, f.class);
                if (!a(fVar, a2)) {
                    a = com.baidu.swan.apps.w.a.Uk().a(context, fVar, a2, eVar);
                    break;
                } else {
                    a = false;
                    break;
                }
            case 4:
                com.baidu.swan.apps.z.a.e eVar2 = (com.baidu.swan.apps.z.a.e) a(unitedSchemeEntity, com.baidu.swan.apps.z.a.e.class);
                if (!a(eVar2, a2)) {
                    a = com.baidu.swan.apps.w.a.Uk().a(context, eVar2, a2, eVar);
                    break;
                } else {
                    a = false;
                    break;
                }
            case 5:
                com.baidu.swan.apps.z.a.c a6 = a(unitedSchemeEntity, com.baidu.swan.apps.z.a.c.class);
                if (!a(a6, a2)) {
                    a = com.baidu.swan.apps.w.a.Uk().d(context, a6, a2, eVar);
                    break;
                } else {
                    a = false;
                    break;
                }
            case 6:
                com.baidu.swan.apps.z.a.b bVar = (com.baidu.swan.apps.z.a.b) a(unitedSchemeEntity, com.baidu.swan.apps.z.a.b.class);
                if (!a(bVar, a2)) {
                    a = com.baidu.swan.apps.w.a.Uk().a(context, bVar, a2, eVar);
                    break;
                } else {
                    a = false;
                    break;
                }
            case 7:
                com.baidu.swan.apps.z.a.c a7 = a(unitedSchemeEntity, com.baidu.swan.apps.z.a.c.class);
                if (!a(a7, a2)) {
                    a = com.baidu.swan.apps.w.a.Uk().e(context, a7, a2, eVar);
                    break;
                } else {
                    a = false;
                    break;
                }
            case '\b':
                com.baidu.swan.apps.z.a.c a8 = a(unitedSchemeEntity, com.baidu.swan.apps.z.a.c.class);
                if (!a(a8, a2)) {
                    a = com.baidu.swan.apps.w.a.Uk().f(context, a8, a2, eVar);
                    break;
                } else {
                    a = false;
                    break;
                }
            case '\t':
                com.baidu.swan.apps.z.a.c a9 = a(unitedSchemeEntity, com.baidu.swan.apps.z.a.c.class);
                if (!a(a9, a2)) {
                    a = com.baidu.swan.apps.w.a.Uk().g(context, a9, a2, eVar);
                    break;
                } else {
                    a = false;
                    break;
                }
            case '\n':
                com.baidu.swan.apps.z.a.a aVar = (com.baidu.swan.apps.z.a.a) a(unitedSchemeEntity, com.baidu.swan.apps.z.a.a.class);
                if (!a(aVar, a2)) {
                    a = com.baidu.swan.apps.w.a.Uk().a(context, aVar, a2, eVar);
                    break;
                } else {
                    a = false;
                    break;
                }
            case 11:
                g gVar = (g) a(unitedSchemeEntity, g.class);
                if (!a(gVar, a2)) {
                    a = com.baidu.swan.apps.w.a.Uk().a(context, gVar, a2, eVar);
                    break;
                } else {
                    a = false;
                    break;
                }
            default:
                a = false;
                break;
        }
        return a || super.e(context, unitedSchemeEntity, callbackHandler, str, eVar);
    }

    protected <T extends com.baidu.swan.apps.z.a.c> T a(UnitedSchemeEntity unitedSchemeEntity, Class<T> cls) {
        T t;
        Exception e;
        JSONObject jSONObject;
        if (unitedSchemeEntity == null) {
            return null;
        }
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        if (params == null || params.isEmpty()) {
            c.e("map", "entity get Params is empty");
            return null;
        }
        String str = params.get("params");
        if (str == null) {
            c.e("map", "params string is empty");
            return null;
        }
        try {
            jSONObject = new JSONObject(str);
            t = cls.newInstance();
        } catch (Exception e2) {
            t = null;
            e = e2;
        }
        try {
            t.parseFromJson(jSONObject);
            return t;
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            c.e("map", "params json parse error");
            return t;
        }
    }

    private boolean a(com.baidu.swan.apps.z.a.c cVar, b bVar) {
        if (cVar == null) {
            c.e("map", "parse error, model is null");
            bVar.onError(202);
            return true;
        }
        if (TextUtils.isEmpty(cVar.biB)) {
            String ahj = ai.ahj();
            if (!TextUtils.isEmpty(ahj)) {
                cVar.biB = ahj;
            }
            c.w("map", "webView id is empty, use current webView");
        }
        if (ai.iS(cVar.biB) == null) {
            bVar.onError(202);
            c.e("map", "can not find weiView by id " + cVar.biB);
            return true;
        }
        return false;
    }
}
