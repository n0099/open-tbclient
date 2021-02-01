package com.baidu.swan.apps.w;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.w.a.f;
import com.baidu.swan.apps.w.a.g;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends aa {
    public a(j jVar) {
        super(jVar, "/swanAPI/map");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (DEBUG) {
            Log.d("MapAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        boolean a2;
        if (DEBUG) {
            Log.d("MapAction", "handleSubAction subAction: " + str);
        }
        c.i("map", "handleSubAction " + str);
        b b2 = b.b(unitedSchemeEntity, callbackHandler);
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
                com.baidu.swan.apps.w.a.c a3 = a(unitedSchemeEntity, com.baidu.swan.apps.w.a.c.class);
                if (!a(a3, b2)) {
                    a2 = com.baidu.swan.apps.t.a.axh().a(context, a3, b2, eVar);
                    break;
                } else {
                    a2 = false;
                    break;
                }
            case 1:
                com.baidu.swan.apps.w.a.c a4 = a(unitedSchemeEntity, com.baidu.swan.apps.w.a.c.class);
                if (!a(a4, b2)) {
                    a2 = com.baidu.swan.apps.t.a.axh().b(context, a4, b2, eVar);
                    break;
                } else {
                    a2 = false;
                    break;
                }
            case 2:
                com.baidu.swan.apps.w.a.c a5 = a(unitedSchemeEntity, com.baidu.swan.apps.w.a.c.class);
                if (!a(a5, b2)) {
                    a2 = com.baidu.swan.apps.t.a.axh().c(context, a5, b2, eVar);
                    break;
                } else {
                    a2 = false;
                    break;
                }
            case 3:
                f fVar = (f) a(unitedSchemeEntity, f.class);
                if (!a(fVar, b2)) {
                    a2 = com.baidu.swan.apps.t.a.axh().a(context, fVar, b2, eVar);
                    break;
                } else {
                    a2 = false;
                    break;
                }
            case 4:
                com.baidu.swan.apps.w.a.e eVar2 = (com.baidu.swan.apps.w.a.e) a(unitedSchemeEntity, com.baidu.swan.apps.w.a.e.class);
                if (!a(eVar2, b2)) {
                    a2 = com.baidu.swan.apps.t.a.axh().a(context, eVar2, b2, eVar);
                    break;
                } else {
                    a2 = false;
                    break;
                }
            case 5:
                com.baidu.swan.apps.w.a.c a6 = a(unitedSchemeEntity, com.baidu.swan.apps.w.a.c.class);
                if (!a(a6, b2)) {
                    a2 = com.baidu.swan.apps.t.a.axh().d(context, a6, b2, eVar);
                    break;
                } else {
                    a2 = false;
                    break;
                }
            case 6:
                com.baidu.swan.apps.w.a.b bVar = (com.baidu.swan.apps.w.a.b) a(unitedSchemeEntity, com.baidu.swan.apps.w.a.b.class);
                if (!a(bVar, b2)) {
                    a2 = com.baidu.swan.apps.t.a.axh().a(context, bVar, b2, eVar);
                    break;
                } else {
                    a2 = false;
                    break;
                }
            case 7:
                com.baidu.swan.apps.w.a.c a7 = a(unitedSchemeEntity, com.baidu.swan.apps.w.a.c.class);
                if (!a(a7, b2)) {
                    a2 = com.baidu.swan.apps.t.a.axh().e(context, a7, b2, eVar);
                    break;
                } else {
                    a2 = false;
                    break;
                }
            case '\b':
                com.baidu.swan.apps.w.a.c a8 = a(unitedSchemeEntity, com.baidu.swan.apps.w.a.c.class);
                if (!a(a8, b2)) {
                    a2 = com.baidu.swan.apps.t.a.axh().f(context, a8, b2, eVar);
                    break;
                } else {
                    a2 = false;
                    break;
                }
            case '\t':
                com.baidu.swan.apps.w.a.c a9 = a(unitedSchemeEntity, com.baidu.swan.apps.w.a.c.class);
                if (!a(a9, b2)) {
                    a2 = com.baidu.swan.apps.t.a.axh().g(context, a9, b2, eVar);
                    break;
                } else {
                    a2 = false;
                    break;
                }
            case '\n':
                com.baidu.swan.apps.w.a.a aVar = (com.baidu.swan.apps.w.a.a) a(unitedSchemeEntity, com.baidu.swan.apps.w.a.a.class);
                if (!a(aVar, b2)) {
                    a2 = com.baidu.swan.apps.t.a.axh().a(context, aVar, b2, eVar);
                    break;
                } else {
                    a2 = false;
                    break;
                }
            case 11:
                g gVar = (g) a(unitedSchemeEntity, g.class);
                if (!a(gVar, b2)) {
                    a2 = com.baidu.swan.apps.t.a.axh().a(context, gVar, b2, eVar);
                    break;
                } else {
                    a2 = false;
                    break;
                }
            default:
                a2 = false;
                break;
        }
        return a2 || super.d(context, unitedSchemeEntity, callbackHandler, str, eVar);
    }

    protected <T extends com.baidu.swan.apps.w.a.c> T a(UnitedSchemeEntity unitedSchemeEntity, Class<T> cls) {
        T t;
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
        } catch (Exception e) {
            e = e;
            t = null;
        }
        try {
            t.parseFromJson(jSONObject);
            return t;
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            c.e("map", "params json parse error");
            return t;
        }
    }

    private boolean a(com.baidu.swan.apps.w.a.c cVar, b bVar) {
        if (cVar == null) {
            c.e("map", "parse error, model is null");
            bVar.onError(202);
            return true;
        }
        if (TextUtils.isEmpty(cVar.cLr)) {
            String aOn = ak.aOn();
            if (!TextUtils.isEmpty(aOn)) {
                cVar.cLr = aOn;
            }
            c.w("map", "webView id is empty, use current webView");
        }
        if (ak.po(cVar.cLr) == null) {
            bVar.onError(202);
            c.e("map", "can not find weiView by id " + cVar.cLr);
            return true;
        }
        return false;
    }
}
