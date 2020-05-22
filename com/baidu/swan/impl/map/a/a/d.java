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

    public static d aDP() {
        return new d();
    }

    private boolean a(Context context, com.baidu.swan.apps.x.a.b bVar, com.baidu.swan.apps.x.b bVar2, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.console.c.i("map", "IncludePointsAction start");
        com.baidu.swan.apps.adaptation.b.e jO = com.baidu.swan.apps.w.f.ahV().jO(bVar.bPG);
        if (!(jO instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        com.baidu.swan.impl.map.item.c sQ = com.baidu.swan.impl.map.c.aDH().h((com.baidu.swan.apps.adaptation.b.c) jO).sQ(bVar.bPF);
        if (sQ == null) {
            com.baidu.swan.apps.console.c.e("map", "can not find map by id " + bVar.bPF);
            return false;
        }
        com.baidu.swan.apps.console.c.i("map", "IncludePointsAction end");
        return a(bVar, sQ);
    }

    private boolean a(com.baidu.swan.apps.x.a.b bVar, com.baidu.swan.impl.map.item.c cVar) {
        if (bVar == null || !bVar.isValid()) {
            return false;
        }
        BaiduMap map = cVar.dgG.getMap();
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        Iterator<com.baidu.swan.apps.x.a.a.c> it = bVar.ciJ.iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.x.a.a.c next = it.next();
            builder.include(new LatLng(next.latitude, next.longitude));
        }
        map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build(), bVar.ciK[3], bVar.ciK[0], bVar.ciK[1], bVar.ciK[2]));
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.impl.map.a.a
    public boolean a(Context context, com.baidu.swan.apps.x.a.b bVar, com.baidu.swan.apps.x.b bVar2, com.baidu.swan.apps.runtime.e eVar, JSONObject jSONObject) {
        return a(context, bVar, bVar2, eVar);
    }
}
