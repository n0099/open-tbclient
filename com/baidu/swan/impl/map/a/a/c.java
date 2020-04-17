package com.baidu.swan.impl.map.a.a;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class c extends com.baidu.swan.impl.map.a.a<com.baidu.swan.apps.z.a.c> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = c.class.getSimpleName();

    public static c azW() {
        return new c();
    }

    private boolean d(Context context, com.baidu.swan.apps.z.a.c cVar, com.baidu.swan.apps.z.b bVar, com.baidu.swan.apps.runtime.e eVar, JSONObject jSONObject) {
        com.baidu.swan.apps.console.c.i("map", "GetScaleAction start");
        com.baidu.swan.apps.adaptation.b.e iI = com.baidu.swan.apps.y.f.aeK().iI(cVar.bGJ);
        if (!(iI instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        com.baidu.swan.impl.map.item.c rm = com.baidu.swan.impl.map.c.azP().h((com.baidu.swan.apps.adaptation.b.c) iI).rm(cVar.bGI);
        if (rm == null) {
            com.baidu.swan.apps.console.c.e("map", "can not find map by id " + cVar.bGI);
            return false;
        }
        try {
            jSONObject.put("scale", rm.cVA.getMap().getMapStatus().zoom);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.baidu.swan.apps.console.c.i("map", "GetScaleAction end");
        return true;
    }

    @Override // com.baidu.swan.impl.map.a.a
    protected boolean a(Context context, com.baidu.swan.apps.z.a.c cVar, com.baidu.swan.apps.z.b bVar, com.baidu.swan.apps.runtime.e eVar, JSONObject jSONObject) {
        return d(context, cVar, bVar, eVar, jSONObject);
    }
}
