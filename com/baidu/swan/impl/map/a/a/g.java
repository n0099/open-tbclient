package com.baidu.swan.impl.map.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.model.LatLng;
import com.baidu.swan.impl.map.item.b;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class g extends com.baidu.swan.impl.map.a.a<com.baidu.swan.apps.x.a.f> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = g.class.getSimpleName();

    public static g aEY() {
        return new g();
    }

    private boolean a(Context context, com.baidu.swan.apps.x.a.f fVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.console.c.i("map", "TranslateMarkerAction start");
        com.baidu.swan.apps.adaptation.b.e jW = com.baidu.swan.apps.w.f.ajb().jW(fVar.bUu);
        if (!(jW instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        com.baidu.swan.impl.map.item.c sY = com.baidu.swan.impl.map.c.aEN().h((com.baidu.swan.apps.adaptation.b.c) jW).sY(fVar.bUt);
        if (sY == null) {
            com.baidu.swan.apps.console.c.e("map", "can not find map by id " + fVar.bUt);
            return false;
        }
        return a(fVar, sY, bVar);
    }

    private boolean a(final com.baidu.swan.apps.x.a.f fVar, com.baidu.swan.impl.map.item.c cVar, final com.baidu.swan.apps.x.b bVar) {
        if (!fVar.isValid()) {
            return false;
        }
        LatLng latLng = new LatLng(fVar.cnA.latitude, fVar.cnA.longitude);
        List<com.baidu.swan.impl.map.item.b> sZ = cVar.sZ(fVar.cnT);
        com.baidu.swan.apps.console.c.i("map", "TranslateMarkerAction animation start");
        if (sZ != null) {
            for (com.baidu.swan.impl.map.item.b bVar2 : sZ) {
                bVar2.a(cVar, latLng, fVar.duration, new b.a() { // from class: com.baidu.swan.impl.map.a.a.g.1
                    @Override // com.baidu.swan.impl.map.item.b.a
                    public void onAnimationEnd() {
                        if (!TextUtils.isEmpty(fVar.callback)) {
                            bVar.d(fVar.callback, null);
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
    public boolean a(Context context, com.baidu.swan.apps.x.a.f fVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.runtime.e eVar, JSONObject jSONObject) {
        return a(context, fVar, bVar, eVar);
    }
}
