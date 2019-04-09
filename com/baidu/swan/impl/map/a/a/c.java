package com.baidu.swan.impl.map.a.a;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c extends com.baidu.swan.impl.map.a.a<com.baidu.swan.apps.x.a.c> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = c.class.getSimpleName();

    public static c PY() {
        return new c();
    }

    private boolean d(Context context, com.baidu.swan.apps.x.a.c cVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2, JSONObject jSONObject) {
        com.baidu.swan.apps.console.c.i("map", "GetScaleAction start");
        com.baidu.swan.apps.b.c.e eg = com.baidu.swan.apps.w.e.Ea().eg(cVar.aBH);
        if (!(eg instanceof com.baidu.swan.apps.b.c.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        com.baidu.swan.impl.map.item.b jd = com.baidu.swan.impl.map.c.PS().h((com.baidu.swan.apps.b.c.c) eg).jd(cVar.id);
        if (jd == null) {
            com.baidu.swan.apps.console.c.e("map", "can not find map by id " + cVar.id);
            return false;
        }
        try {
            jSONObject.put("scale", jd.bhn.getMap().getMapStatus().zoom);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.baidu.swan.apps.console.c.i("map", "GetScaleAction end");
        return true;
    }

    @Override // com.baidu.swan.impl.map.a.a
    protected boolean a(Context context, com.baidu.swan.apps.x.a.c cVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2, JSONObject jSONObject) {
        return d(context, cVar, bVar, bVar2, jSONObject);
    }
}
