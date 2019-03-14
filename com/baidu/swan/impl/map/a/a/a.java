package com.baidu.swan.impl.map.a.a;

import android.content.Context;
import com.baidu.mapapi.map.MapStatus;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a extends com.baidu.swan.impl.map.a.a<com.baidu.swan.apps.x.a.c> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = a.class.getSimpleName();

    public static a PY() {
        return new a();
    }

    private boolean b(Context context, com.baidu.swan.apps.x.a.c cVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2, JSONObject jSONObject) {
        com.baidu.swan.apps.console.c.i("map", "GetCenterLcationAction start");
        com.baidu.swan.apps.b.c.e ee = com.baidu.swan.apps.w.e.Ec().ee(cVar.aBD);
        if (!(ee instanceof com.baidu.swan.apps.b.c.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        com.baidu.swan.impl.map.item.b jc = com.baidu.swan.impl.map.c.PU().h((com.baidu.swan.apps.b.c.c) ee).jc(cVar.id);
        if (jc == null) {
            com.baidu.swan.apps.console.c.e("map", "can not find map by id " + cVar.id);
            return false;
        }
        MapStatus mapStatus = jc.bhj.getMap().getMapStatus();
        com.baidu.swan.apps.x.a.a.c cVar2 = new com.baidu.swan.apps.x.a.a.c();
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
    protected boolean a(Context context, com.baidu.swan.apps.x.a.c cVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2, JSONObject jSONObject) {
        return b(context, cVar, bVar, bVar2, jSONObject);
    }
}
