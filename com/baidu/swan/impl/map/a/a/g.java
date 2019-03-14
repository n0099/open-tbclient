package com.baidu.swan.impl.map.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.model.LatLng;
import com.baidu.swan.impl.map.item.c;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class g extends com.baidu.swan.impl.map.a.a<com.baidu.swan.apps.x.a.f> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = g.class.getSimpleName();

    public static g Qe() {
        return new g();
    }

    private boolean a(Context context, com.baidu.swan.apps.x.a.f fVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2) {
        com.baidu.swan.apps.console.c.i("map", "TranslateMarkerAction start");
        com.baidu.swan.apps.b.c.e ee = com.baidu.swan.apps.w.e.Ec().ee(fVar.aBD);
        if (!(ee instanceof com.baidu.swan.apps.b.c.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        com.baidu.swan.impl.map.item.b jc = com.baidu.swan.impl.map.c.PU().h((com.baidu.swan.apps.b.c.c) ee).jc(fVar.id);
        if (jc == null) {
            com.baidu.swan.apps.console.c.e("map", "can not find map by id " + fVar.id);
            return false;
        }
        return a(fVar, jc, bVar);
    }

    private boolean a(final com.baidu.swan.apps.x.a.f fVar, com.baidu.swan.impl.map.item.b bVar, final com.baidu.swan.apps.x.b bVar2) {
        if (!fVar.isValid()) {
            return false;
        }
        LatLng latLng = new LatLng(fVar.ayI.latitude, fVar.ayI.longitude);
        List<com.baidu.swan.impl.map.item.c> jd = bVar.jd(fVar.ayW);
        com.baidu.swan.apps.console.c.i("map", "TranslateMarkerAction animation start");
        if (jd != null) {
            for (com.baidu.swan.impl.map.item.c cVar : jd) {
                cVar.a(bVar, latLng, fVar.duration, new c.a() { // from class: com.baidu.swan.impl.map.a.a.g.1
                    @Override // com.baidu.swan.impl.map.item.c.a
                    public void onAnimationEnd() {
                        if (!TextUtils.isEmpty(fVar.callback)) {
                            bVar2.e(fVar.callback, null);
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
    public boolean a(Context context, com.baidu.swan.apps.x.a.f fVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2, JSONObject jSONObject) {
        return a(context, fVar, bVar, bVar2);
    }
}
