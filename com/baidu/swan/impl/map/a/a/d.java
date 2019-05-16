package com.baidu.swan.impl.map.a.a;

import android.content.Context;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d extends com.baidu.swan.impl.map.a.a<com.baidu.swan.apps.x.a.b> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = d.class.getSimpleName();

    public static d TL() {
        return new d();
    }

    private boolean a(Context context, com.baidu.swan.apps.x.a.b bVar, com.baidu.swan.apps.x.b bVar2, com.baidu.swan.apps.ae.b bVar3) {
        com.baidu.swan.apps.console.c.i("map", "IncludePointsAction start");
        com.baidu.swan.apps.b.c.e dU = com.baidu.swan.apps.w.e.FV().dU(bVar.aDm);
        if (!(dU instanceof com.baidu.swan.apps.b.c.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        com.baidu.swan.impl.map.item.b kc = com.baidu.swan.impl.map.c.TE().h((com.baidu.swan.apps.b.c.c) dU).kc(bVar.id);
        if (kc == null) {
            com.baidu.swan.apps.console.c.e("map", "can not find map by id " + bVar.id);
            return false;
        }
        com.baidu.swan.apps.console.c.i("map", "IncludePointsAction end");
        return a(bVar, kc);
    }

    private boolean a(com.baidu.swan.apps.x.a.b bVar, com.baidu.swan.impl.map.item.b bVar2) {
        if (bVar == null || !bVar.isValid()) {
            return false;
        }
        BaiduMap map = bVar2.bns.getMap();
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        Iterator<com.baidu.swan.apps.x.a.a.c> it = bVar.azI.iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.x.a.a.c next = it.next();
            builder.include(new LatLng(next.latitude, next.longitude));
        }
        map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build(), bVar.azJ[3], bVar.azJ[0], bVar.azJ[1], bVar.azJ[2]));
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.impl.map.a.a
    public boolean a(Context context, com.baidu.swan.apps.x.a.b bVar, com.baidu.swan.apps.x.b bVar2, com.baidu.swan.apps.ae.b bVar3, JSONObject jSONObject) {
        return a(context, bVar, bVar2, bVar3);
    }
}
