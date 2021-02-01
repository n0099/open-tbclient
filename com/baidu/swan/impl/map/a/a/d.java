package com.baidu.swan.impl.map.a.a;

import android.content.Context;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d extends com.baidu.swan.impl.map.a.a<com.baidu.swan.apps.w.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = d.class.getSimpleName();

    public static d baB() {
        return new d();
    }

    private boolean a(Context context, com.baidu.swan.apps.w.a.b bVar, com.baidu.swan.apps.w.b bVar2, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.console.c.i("map", "IncludePointsAction start");
        com.baidu.swan.apps.adaptation.b.e ni = com.baidu.swan.apps.v.f.aAl().ni(bVar.cLr);
        if (!(ni instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        com.baidu.swan.impl.map.item.c xN = com.baidu.swan.impl.map.c.bat().h((com.baidu.swan.apps.adaptation.b.c) ni).xN(bVar.cLq);
        if (xN == null) {
            com.baidu.swan.apps.console.c.e("map", "can not find map by id " + bVar.cLq);
            return false;
        }
        com.baidu.swan.apps.console.c.i("map", "IncludePointsAction end");
        return a(bVar, xN);
    }

    private boolean a(com.baidu.swan.apps.w.a.b bVar, com.baidu.swan.impl.map.item.c cVar) {
        if (bVar == null || !bVar.isValid()) {
            return false;
        }
        BaiduMap map = cVar.epz.getMap();
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        Iterator<com.baidu.swan.apps.w.a.a.c> it = bVar.dhy.iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.w.a.a.c next = it.next();
            builder.include(new LatLng(next.latitude, next.longitude));
        }
        map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build(), bVar.dhz[3], bVar.dhz[0], bVar.dhz[1], bVar.dhz[2]));
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.impl.map.a.a
    public boolean a(Context context, com.baidu.swan.apps.w.a.b bVar, com.baidu.swan.apps.w.b bVar2, com.baidu.swan.apps.runtime.e eVar, JSONObject jSONObject) {
        return a(context, bVar, bVar2, eVar);
    }
}
