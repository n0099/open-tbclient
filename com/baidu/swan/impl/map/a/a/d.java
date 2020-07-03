package com.baidu.swan.impl.map.a.a;

import android.content.Context;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class d extends com.baidu.swan.impl.map.a.a<com.baidu.swan.apps.x.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = d.class.getSimpleName();

    public static d aEV() {
        return new d();
    }

    private boolean a(Context context, com.baidu.swan.apps.x.a.b bVar, com.baidu.swan.apps.x.b bVar2, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.console.c.i("map", "IncludePointsAction start");
        com.baidu.swan.apps.adaptation.b.e jW = com.baidu.swan.apps.w.f.ajb().jW(bVar.bUu);
        if (!(jW instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        com.baidu.swan.impl.map.item.c sY = com.baidu.swan.impl.map.c.aEN().h((com.baidu.swan.apps.adaptation.b.c) jW).sY(bVar.bUt);
        if (sY == null) {
            com.baidu.swan.apps.console.c.e("map", "can not find map by id " + bVar.bUt);
            return false;
        }
        com.baidu.swan.apps.console.c.i("map", "IncludePointsAction end");
        return a(bVar, sY);
    }

    private boolean a(com.baidu.swan.apps.x.a.b bVar, com.baidu.swan.impl.map.item.c cVar) {
        if (bVar == null || !bVar.isValid()) {
            return false;
        }
        BaiduMap map = cVar.dls.getMap();
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        Iterator<com.baidu.swan.apps.x.a.a.c> it = bVar.cny.iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.x.a.a.c next = it.next();
            builder.include(new LatLng(next.latitude, next.longitude));
        }
        map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build(), bVar.cnz[3], bVar.cnz[0], bVar.cnz[1], bVar.cnz[2]));
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.impl.map.a.a
    public boolean a(Context context, com.baidu.swan.apps.x.a.b bVar, com.baidu.swan.apps.x.b bVar2, com.baidu.swan.apps.runtime.e eVar, JSONObject jSONObject) {
        return a(context, bVar, bVar2, eVar);
    }
}
