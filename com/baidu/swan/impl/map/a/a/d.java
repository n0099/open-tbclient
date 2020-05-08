package com.baidu.swan.impl.map.a.a;

import android.content.Context;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class d extends com.baidu.swan.impl.map.a.a<com.baidu.swan.apps.z.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = d.class.getSimpleName();

    public static d azX() {
        return new d();
    }

    private boolean a(Context context, com.baidu.swan.apps.z.a.b bVar, com.baidu.swan.apps.z.b bVar2, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.console.c.i("map", "IncludePointsAction start");
        com.baidu.swan.apps.adaptation.b.e iI = com.baidu.swan.apps.y.f.aeJ().iI(bVar.bGO);
        if (!(iI instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        com.baidu.swan.impl.map.item.c rm = com.baidu.swan.impl.map.c.azP().h((com.baidu.swan.apps.adaptation.b.c) iI).rm(bVar.bGN);
        if (rm == null) {
            com.baidu.swan.apps.console.c.e("map", "can not find map by id " + bVar.bGN);
            return false;
        }
        com.baidu.swan.apps.console.c.i("map", "IncludePointsAction end");
        return a(bVar, rm);
    }

    private boolean a(com.baidu.swan.apps.z.a.b bVar, com.baidu.swan.impl.map.item.c cVar) {
        if (bVar == null || !bVar.isValid()) {
            return false;
        }
        BaiduMap map = cVar.cVF.getMap();
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        Iterator<com.baidu.swan.apps.z.a.a.c> it = bVar.bYh.iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.z.a.a.c next = it.next();
            builder.include(new LatLng(next.latitude, next.longitude));
        }
        map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build(), bVar.bYi[3], bVar.bYi[0], bVar.bYi[1], bVar.bYi[2]));
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.impl.map.a.a
    public boolean a(Context context, com.baidu.swan.apps.z.a.b bVar, com.baidu.swan.apps.z.b bVar2, com.baidu.swan.apps.runtime.e eVar, JSONObject jSONObject) {
        return a(context, bVar, bVar2, eVar);
    }
}
