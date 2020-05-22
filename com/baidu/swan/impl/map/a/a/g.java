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

    public static g aDS() {
        return new g();
    }

    private boolean a(Context context, com.baidu.swan.apps.x.a.f fVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.console.c.i("map", "TranslateMarkerAction start");
        com.baidu.swan.apps.adaptation.b.e jO = com.baidu.swan.apps.w.f.ahV().jO(fVar.bPG);
        if (!(jO instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        com.baidu.swan.impl.map.item.c sQ = com.baidu.swan.impl.map.c.aDH().h((com.baidu.swan.apps.adaptation.b.c) jO).sQ(fVar.bPF);
        if (sQ == null) {
            com.baidu.swan.apps.console.c.e("map", "can not find map by id " + fVar.bPF);
            return false;
        }
        return a(fVar, sQ, bVar);
    }

    private boolean a(final com.baidu.swan.apps.x.a.f fVar, com.baidu.swan.impl.map.item.c cVar, final com.baidu.swan.apps.x.b bVar) {
        if (!fVar.isValid()) {
            return false;
        }
        LatLng latLng = new LatLng(fVar.ciL.latitude, fVar.ciL.longitude);
        List<com.baidu.swan.impl.map.item.b> sR = cVar.sR(fVar.cje);
        com.baidu.swan.apps.console.c.i("map", "TranslateMarkerAction animation start");
        if (sR != null) {
            for (com.baidu.swan.impl.map.item.b bVar2 : sR) {
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
