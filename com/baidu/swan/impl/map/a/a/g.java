package com.baidu.swan.impl.map.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.model.LatLng;
import com.baidu.swan.impl.map.item.b;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class g extends com.baidu.swan.impl.map.a.a<com.baidu.swan.apps.w.a.f> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = g.class.getSimpleName();

    public static g baE() {
        return new g();
    }

    private boolean a(Context context, com.baidu.swan.apps.w.a.f fVar, com.baidu.swan.apps.w.b bVar, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.console.c.i("map", "TranslateMarkerAction start");
        com.baidu.swan.apps.adaptation.b.e ni = com.baidu.swan.apps.v.f.aAl().ni(fVar.cLr);
        if (!(ni instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        com.baidu.swan.impl.map.item.c xN = com.baidu.swan.impl.map.c.bat().h((com.baidu.swan.apps.adaptation.b.c) ni).xN(fVar.cLq);
        if (xN == null) {
            com.baidu.swan.apps.console.c.e("map", "can not find map by id " + fVar.cLq);
            return false;
        }
        return a(fVar, xN, bVar);
    }

    private boolean a(final com.baidu.swan.apps.w.a.f fVar, com.baidu.swan.impl.map.item.c cVar, final com.baidu.swan.apps.w.b bVar) {
        if (!fVar.isValid()) {
            return false;
        }
        LatLng latLng = new LatLng(fVar.dhA.latitude, fVar.dhA.longitude);
        List<com.baidu.swan.impl.map.item.b> xO = cVar.xO(fVar.dhT);
        com.baidu.swan.apps.console.c.i("map", "TranslateMarkerAction animation start");
        if (xO != null) {
            for (com.baidu.swan.impl.map.item.b bVar2 : xO) {
                bVar2.a(cVar, latLng, fVar.duration, new b.a() { // from class: com.baidu.swan.impl.map.a.a.g.1
                    @Override // com.baidu.swan.impl.map.item.b.a
                    public void onAnimationEnd() {
                        if (!TextUtils.isEmpty(fVar.callback)) {
                            bVar.g(fVar.callback, null);
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
