package com.baidu.swan.apps.x;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.x.a.e;
import com.baidu.swan.apps.x.a.f;
import com.baidu.swan.apps.x.a.g;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends y {
    public a(j jVar) {
        super(jVar, "/swan/map");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("MapAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, com.baidu.swan.apps.ae.b bVar) {
        boolean a;
        if (DEBUG) {
            Log.d("MapAction", "handleSubAction subAction: " + str);
        }
        c.i("map", "handleSubAction " + str);
        b a2 = b.a(unitedSchemeEntity, callbackHandler);
        char c = 65535;
        switch (str.hashCode()) {
            case -1733613079:
                if (str.equals("/swan/map/openWalkNavigation")) {
                    c = 11;
                    break;
                }
                break;
            case -1106368664:
                if (str.equals("/swan/map/getRegion")) {
                    c = '\b';
                    break;
                }
                break;
            case -758520770:
                if (str.equals("/swan/map/create")) {
                    c = 0;
                    break;
                }
                break;
            case -340837434:
                if (str.equals("/swan/map/remove")) {
                    c = 2;
                    break;
                }
                break;
            case -245072885:
                if (str.equals("/swan/map/update")) {
                    c = 1;
                    break;
                }
                break;
            case -220100127:
                if (str.equals("/swan/map/openLocation")) {
                    c = 4;
                    break;
                }
                break;
            case 332527518:
                if (str.equals("/swan/map/getCenterLocation")) {
                    c = '\t';
                    break;
                }
                break;
            case 877004326:
                if (str.equals("/swan/map/translateMarker")) {
                    c = 3;
                    break;
                }
                break;
            case 1162505769:
                if (str.equals("/swan/map/includePoints")) {
                    c = 6;
                    break;
                }
                break;
            case 1350642262:
                if (str.equals("/swan/map/getScale")) {
                    c = 7;
                    break;
                }
                break;
            case 1767935811:
                if (str.equals("/swan/map/moveToLocation")) {
                    c = 5;
                    break;
                }
                break;
            case 1986876462:
                if (str.equals("/swan/map/chooseLocation")) {
                    c = '\n';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                com.baidu.swan.apps.x.a.c a3 = a(unitedSchemeEntity, com.baidu.swan.apps.x.a.c.class);
                if (!a(a3, a2)) {
                    a = com.baidu.swan.apps.u.a.CJ().a(context, a3, a2, bVar);
                    break;
                } else {
                    a = false;
                    break;
                }
            case 1:
                com.baidu.swan.apps.x.a.c a4 = a(unitedSchemeEntity, com.baidu.swan.apps.x.a.c.class);
                if (!a(a4, a2)) {
                    a = com.baidu.swan.apps.u.a.CJ().b(context, a4, a2, bVar);
                    break;
                } else {
                    a = false;
                    break;
                }
            case 2:
                com.baidu.swan.apps.x.a.c a5 = a(unitedSchemeEntity, com.baidu.swan.apps.x.a.c.class);
                if (!a(a5, a2)) {
                    a = com.baidu.swan.apps.u.a.CJ().c(context, a5, a2, bVar);
                    break;
                } else {
                    a = false;
                    break;
                }
            case 3:
                f fVar = (f) a(unitedSchemeEntity, f.class);
                if (!a(fVar, a2)) {
                    a = com.baidu.swan.apps.u.a.CJ().a(context, fVar, a2, bVar);
                    break;
                } else {
                    a = false;
                    break;
                }
            case 4:
                e eVar = (e) a(unitedSchemeEntity, e.class);
                if (!a(eVar, a2)) {
                    a = com.baidu.swan.apps.u.a.CJ().a(context, eVar, a2, bVar);
                    break;
                } else {
                    a = false;
                    break;
                }
            case 5:
                com.baidu.swan.apps.x.a.c a6 = a(unitedSchemeEntity, com.baidu.swan.apps.x.a.c.class);
                if (!a(a6, a2)) {
                    a = com.baidu.swan.apps.u.a.CJ().d(context, a6, a2, bVar);
                    break;
                } else {
                    a = false;
                    break;
                }
            case 6:
                com.baidu.swan.apps.x.a.b bVar2 = (com.baidu.swan.apps.x.a.b) a(unitedSchemeEntity, com.baidu.swan.apps.x.a.b.class);
                if (!a(bVar2, a2)) {
                    a = com.baidu.swan.apps.u.a.CJ().a(context, bVar2, a2, bVar);
                    break;
                } else {
                    a = false;
                    break;
                }
            case 7:
                com.baidu.swan.apps.x.a.c a7 = a(unitedSchemeEntity, com.baidu.swan.apps.x.a.c.class);
                if (!a(a7, a2)) {
                    a = com.baidu.swan.apps.u.a.CJ().e(context, a7, a2, bVar);
                    break;
                } else {
                    a = false;
                    break;
                }
            case '\b':
                com.baidu.swan.apps.x.a.c a8 = a(unitedSchemeEntity, com.baidu.swan.apps.x.a.c.class);
                if (!a(a8, a2)) {
                    a = com.baidu.swan.apps.u.a.CJ().f(context, a8, a2, bVar);
                    break;
                } else {
                    a = false;
                    break;
                }
            case '\t':
                com.baidu.swan.apps.x.a.c a9 = a(unitedSchemeEntity, com.baidu.swan.apps.x.a.c.class);
                if (!a(a9, a2)) {
                    a = com.baidu.swan.apps.u.a.CJ().g(context, a9, a2, bVar);
                    break;
                } else {
                    a = false;
                    break;
                }
            case '\n':
                com.baidu.swan.apps.x.a.a aVar = (com.baidu.swan.apps.x.a.a) a(unitedSchemeEntity, com.baidu.swan.apps.x.a.a.class);
                if (!a(aVar, a2)) {
                    a = com.baidu.swan.apps.u.a.CJ().a(context, aVar, a2, bVar);
                    break;
                } else {
                    a = false;
                    break;
                }
            case 11:
                g gVar = (g) a(unitedSchemeEntity, g.class);
                if (!a(gVar, a2)) {
                    a = com.baidu.swan.apps.u.a.CJ().a(context, gVar, a2, bVar);
                    break;
                } else {
                    a = false;
                    break;
                }
            default:
                a = false;
                break;
        }
        return a || super.a(context, unitedSchemeEntity, callbackHandler, str, bVar);
    }

    protected <T extends com.baidu.swan.apps.x.a.c> T a(UnitedSchemeEntity unitedSchemeEntity, Class<T> cls) {
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
        String str = params.get(LegoListActivityConfig.PARAMS);
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

    private boolean a(com.baidu.swan.apps.x.a.c cVar, b bVar) {
        if (cVar == null) {
            c.e("map", "parse error, model is null");
            bVar.onError(202);
            return true;
        }
        if (TextUtils.isEmpty(cVar.aBD)) {
            String Mq = aa.Mq();
            if (!TextUtils.isEmpty(Mq)) {
                cVar.aBD = Mq;
            }
            c.w("map", "webView id is empty, use current webView");
        }
        if (aa.eO(cVar.aBD) == null) {
            bVar.onError(202);
            c.e("map", "can not find weiView by id " + cVar.aBD);
            return true;
        }
        return false;
    }
}
