package com.baidu.swan.impl.map.a.a;

import android.content.Context;
import com.baidu.mapapi.map.MapStatus;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a extends com.baidu.swan.impl.map.a.a<com.baidu.swan.apps.w.a.c> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = a.class.getSimpleName();

    public static a bbM() {
        return new a();
    }

    private boolean b(Context context, com.baidu.swan.apps.w.a.c cVar, com.baidu.swan.apps.w.b bVar, com.baidu.swan.apps.runtime.e eVar, JSONObject jSONObject) {
        com.baidu.swan.apps.console.c.i("map", "GetCenterLcationAction start");
        com.baidu.swan.apps.adaptation.b.e oj = com.baidu.swan.apps.v.f.aCp().oj(cVar.cIW);
        if (!(oj instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        com.baidu.swan.impl.map.item.c yG = com.baidu.swan.impl.map.c.bbH().h((com.baidu.swan.apps.adaptation.b.c) oj).yG(cVar.cIV);
        if (yG == null) {
            com.baidu.swan.apps.console.c.e("map", "can not find map by id " + cVar.cIV);
            return false;
        }
        MapStatus mapStatus = yG.ejb.getMap().getMapStatus();
        com.baidu.swan.apps.w.a.a.c cVar2 = new com.baidu.swan.apps.w.a.a.c();
        cVar2.latitude = mapStatus.target.latitude;
        cVar2.longitude = mapStatus.target.longitude;
        try {
            jSONObject.put("latitude", cVar2.latitude);
            jSONObject.put("longitude", cVar2.longitude);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.baidu.swan.apps.console.c.i("map", "GetCenterLocationAction end");
        return true;
    }

    @Override // com.baidu.swan.impl.map.a.a
    protected boolean a(Context context, com.baidu.swan.apps.w.a.c cVar, com.baidu.swan.apps.w.b bVar, com.baidu.swan.apps.runtime.e eVar, JSONObject jSONObject) {
        return b(context, cVar, bVar, eVar, jSONObject);
    }
}
