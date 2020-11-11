package com.baidu.swan.impl.map.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.model.LatLng;
import com.baidu.swan.impl.map.item.b;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class g extends com.baidu.swan.impl.map.a.a<com.baidu.swan.apps.w.a.f> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = g.class.getSimpleName();

    public static g aZu() {
        return new g();
    }

    private boolean a(Context context, com.baidu.swan.apps.w.a.f fVar, com.baidu.swan.apps.w.b bVar, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.console.c.i("map", "TranslateMarkerAction start");
        com.baidu.swan.apps.adaptation.b.e nH = com.baidu.swan.apps.v.f.azO().nH(fVar.cDL);
        if (!(nH instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        com.baidu.swan.impl.map.item.c ye = com.baidu.swan.impl.map.c.aZj().h((com.baidu.swan.apps.adaptation.b.c) nH).ye(fVar.cDK);
        if (ye == null) {
            com.baidu.swan.apps.console.c.e("map", "can not find map by id " + fVar.cDK);
            return false;
        }
        return a(fVar, ye, bVar);
    }

    private boolean a(final com.baidu.swan.apps.w.a.f fVar, com.baidu.swan.impl.map.item.c cVar, final com.baidu.swan.apps.w.b bVar) {
        if (!fVar.isValid()) {
            return false;
        }
        LatLng latLng = new LatLng(fVar.cZV.latitude, fVar.cZV.longitude);
        List<com.baidu.swan.impl.map.item.b> yf = cVar.yf(fVar.dao);
        com.baidu.swan.apps.console.c.i("map", "TranslateMarkerAction animation start");
        if (yf != null) {
            for (com.baidu.swan.impl.map.item.b bVar2 : yf) {
                bVar2.a(cVar, latLng, fVar.duration, new b.a() { // from class: com.baidu.swan.impl.map.a.a.g.1
                    @Override // com.baidu.swan.impl.map.item.b.a
                    public void onAnimationEnd() {
                        if (!TextUtils.isEmpty(fVar.callback)) {
                            bVar.f(fVar.callback, null);
                        }
                        com.baidu.swan.apps.console.c.i("map", "TranslateMarkerAction animation end");
                    }
                });
            }
        }
        com.baidu.swan.apps.console.c.i("map", "TranslateMarkerAction end");
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.impl.map.a.a
    public boolean a(Context context, com.baidu.swan.apps.w.a.f fVar, com.baidu.swan.apps.w.b bVar, com.baidu.swan.apps.runtime.e eVar, JSONObject jSONObject) {
        return a(context, fVar, bVar, eVar);
    }
}
