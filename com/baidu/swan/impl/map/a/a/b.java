package com.baidu.swan.impl.map.a.a;

import android.content.Context;
import com.baidu.mapapi.map.MapStatus;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class b extends com.baidu.swan.impl.map.a.a<com.baidu.swan.apps.x.a.c> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = b.class.getSimpleName();

    public static b aDN() {
        return new b();
    }

    private boolean c(Context context, com.baidu.swan.apps.x.a.c cVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.runtime.e eVar, JSONObject jSONObject) {
        com.baidu.swan.apps.console.c.i("map", "GetRegionAction start");
        com.baidu.swan.apps.adaptation.b.e jO = com.baidu.swan.apps.w.f.ahV().jO(cVar.bPG);
        if (!(jO instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        com.baidu.swan.impl.map.item.c sQ = com.baidu.swan.impl.map.c.aDH().h((com.baidu.swan.apps.adaptation.b.c) jO).sQ(cVar.bPF);
        if (sQ == null) {
            com.baidu.swan.apps.console.c.e("map", "can not find map by id " + cVar.bPF);
            return false;
        }
        MapStatus mapStatus = sQ.dgG.getMap().getMapStatus();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("latitude", mapStatus.bound.southwest.latitude);
            jSONObject3.put("longitude", mapStatus.bound.southwest.longitude);
            jSONObject2.put("latitude", mapStatus.bound.northeast.latitude);
            jSONObject2.put("longitude", mapStatus.bound.northeast.longitude);
            jSONObject.put("southwest", jSONObject3);
            jSONObject.put("northeast", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.baidu.swan.apps.console.c.i("map", "GetRegionAction end");
        return true;
    }

    @Override // com.baidu.swan.impl.map.a.a
    protected boolean a(Context context, com.baidu.swan.apps.x.a.c cVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.runtime.e eVar, JSONObject jSONObject) {
        return c(context, cVar, bVar, eVar, jSONObject);
    }
}
