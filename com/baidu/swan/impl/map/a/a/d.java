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

    public static d PZ() {
        return new d();
    }

    private boolean a(Context context, com.baidu.swan.apps.x.a.b bVar, com.baidu.swan.apps.x.b bVar2, com.baidu.swan.apps.ae.b bVar3) {
        com.baidu.swan.apps.console.c.i("map", "IncludePointsAction start");
        com.baidu.swan.apps.b.c.e eg = com.baidu.swan.apps.w.e.Ea().eg(bVar.aBH);
        if (!(eg instanceof com.baidu.swan.apps.b.c.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        com.baidu.swan.impl.map.item.b jd = com.baidu.swan.impl.map.c.PS().h((com.baidu.swan.apps.b.c.c) eg).jd(bVar.id);
        if (jd == null) {
            com.baidu.swan.apps.console.c.e("map", "can not find map by id " + bVar.id);
            return false;
        }
        com.baidu.swan.apps.console.c.i("map", "IncludePointsAction end");
        return a(bVar, jd);
    }

    private boolean a(com.baidu.swan.apps.x.a.b bVar, com.baidu.swan.impl.map.item.b bVar2) {
        if (bVar == null || !bVar.isValid()) {
            return false;
        }
        BaiduMap map = bVar2.bhn.getMap();
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        Iterator<com.baidu.swan.apps.x.a.a.c> it = bVar.ayK.iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.x.a.a.c next = it.next();
            builder.include(new LatLng(next.latitude, next.longitude));
        }
        map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build(), bVar.ayL[3], bVar.ayL[0], bVar.ayL[1], bVar.ayL[2]));
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.impl.map.a.a
    public boolean a(Context context, com.baidu.swan.apps.x.a.b bVar, com.baidu.swan.apps.x.b bVar2, com.baidu.swan.apps.ae.b bVar3, JSONObject jSONObject) {
        return a(context, bVar, bVar2, bVar3);
    }
}
