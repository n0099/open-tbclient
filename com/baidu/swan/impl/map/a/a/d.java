package com.baidu.swan.impl.map.a.a;

import android.content.Context;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class d extends com.baidu.swan.impl.map.a.a<com.baidu.swan.apps.w.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = d.class.getSimpleName();

    public static d aWR() {
        return new d();
    }

    private boolean a(Context context, com.baidu.swan.apps.w.a.b bVar, com.baidu.swan.apps.w.b bVar2, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.console.c.i("map", "IncludePointsAction start");
        com.baidu.swan.apps.adaptation.b.e ns = com.baidu.swan.apps.v.f.axo().ns(bVar.cxS);
        if (!(ns instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        com.baidu.swan.impl.map.item.c xQ = com.baidu.swan.impl.map.c.aWJ().h((com.baidu.swan.apps.adaptation.b.c) ns).xQ(bVar.cxR);
        if (xQ == null) {
            com.baidu.swan.apps.console.c.e("map", "can not find map by id " + bVar.cxR);
            return false;
        }
        com.baidu.swan.apps.console.c.i("map", "IncludePointsAction end");
        return a(bVar, xQ);
    }

    private boolean a(com.baidu.swan.apps.w.a.b bVar, com.baidu.swan.impl.map.item.c cVar) {
        if (bVar == null || !bVar.isValid()) {
            return false;
        }
        BaiduMap map = cVar.dXR.getMap();
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        Iterator<com.baidu.swan.apps.w.a.a.c> it = bVar.cUa.iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.w.a.a.c next = it.next();
            builder.include(new LatLng(next.latitude, next.longitude));
        }
        map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build(), bVar.cUb[3], bVar.cUb[0], bVar.cUb[1], bVar.cUb[2]));
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.impl.map.a.a
    public boolean a(Context context, com.baidu.swan.apps.w.a.b bVar, com.baidu.swan.apps.w.b bVar2, com.baidu.swan.apps.runtime.e eVar, JSONObject jSONObject) {
        return a(context, bVar, bVar2, eVar);
    }
}
