package com.baidu.swan.impl.map.a.a;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class c extends com.baidu.swan.impl.map.a.a<com.baidu.swan.apps.w.a.c> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = c.class.getSimpleName();

    public static c aZq() {
        return new c();
    }

    private boolean d(Context context, com.baidu.swan.apps.w.a.c cVar, com.baidu.swan.apps.w.b bVar, com.baidu.swan.apps.runtime.e eVar, JSONObject jSONObject) {
        com.baidu.swan.apps.console.c.i("map", "GetScaleAction start");
        com.baidu.swan.apps.adaptation.b.e nH = com.baidu.swan.apps.v.f.azO().nH(cVar.cDL);
        if (!(nH instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        com.baidu.swan.impl.map.item.c ye = com.baidu.swan.impl.map.c.aZj().h((com.baidu.swan.apps.adaptation.b.c) nH).ye(cVar.cDK);
        if (ye == null) {
            com.baidu.swan.apps.console.c.e("map", "can not find map by id " + cVar.cDK);
            return false;
        }
        try {
            jSONObject.put("scale", ye.edI.getMap().getMapStatus().zoom);
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
