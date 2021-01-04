package com.baidu.swan.impl.map.a.a;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c extends com.baidu.swan.impl.map.a.a<com.baidu.swan.apps.w.a.c> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = c.class.getSimpleName();

    public static c beg() {
        return new c();
    }

    private boolean d(Context context, com.baidu.swan.apps.w.a.c cVar, com.baidu.swan.apps.w.b bVar, com.baidu.swan.apps.runtime.e eVar, JSONObject jSONObject) {
        com.baidu.swan.apps.console.c.i("map", "GetScaleAction start");
        com.baidu.swan.apps.adaptation.b.e ob = com.baidu.swan.apps.v.f.aDG().ob(cVar.cNP);
        if (!(ob instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        com.baidu.swan.impl.map.item.c yF = com.baidu.swan.impl.map.c.bdZ().h((com.baidu.swan.apps.adaptation.b.c) ob).yF(cVar.cNO);
        if (yF == null) {
            com.baidu.swan.apps.console.c.e("map", "can not find map by id " + cVar.cNO);
            return false;
        }
        try {
            jSONObject.put("scale", yF.esf.getMap().getMapStatus().zoom);
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
