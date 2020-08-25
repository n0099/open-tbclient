package com.baidu.swan.impl.map.a.a;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class c extends com.baidu.swan.impl.map.a.a<com.baidu.swan.apps.w.a.c> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = c.class.getSimpleName();

    public static c aRB() {
        return new c();
    }

    private boolean d(Context context, com.baidu.swan.apps.w.a.c cVar, com.baidu.swan.apps.w.b bVar, com.baidu.swan.apps.runtime.e eVar, JSONObject jSONObject) {
        com.baidu.swan.apps.console.c.i("map", "GetScaleAction start");
        com.baidu.swan.apps.adaptation.b.e lT = com.baidu.swan.apps.v.f.arY().lT(cVar.caU);
        if (!(lT instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        com.baidu.swan.impl.map.item.c wr = com.baidu.swan.impl.map.c.aRu().h((com.baidu.swan.apps.adaptation.b.c) lT).wr(cVar.caT);
        if (wr == null) {
            com.baidu.swan.apps.console.c.e("map", "can not find map by id " + cVar.caT);
            return false;
        }
        try {
            jSONObject.put("scale", wr.dBo.getMap().getMapStatus().zoom);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.baidu.swan.apps.console.c.i("map", "GetScaleAction end");
        return true;
    }

    @Override // com.baidu.swan.impl.map.a.a
    protected boolean a(Context context, com.baidu.swan.apps.w.a.c cVar, com.baidu.swan.apps.w.b bVar, com.baidu.swan.apps.runtime.e eVar, JSONObject jSONObject) {
        return d(context, cVar, bVar, eVar, jSONObject);
    }
}
