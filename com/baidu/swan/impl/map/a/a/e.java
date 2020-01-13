package com.baidu.swan.impl.map.a.a;

import android.content.Context;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.swan.apps.w.b.f;
import com.baidu.swan.impl.map.a.b.d;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e extends com.baidu.swan.impl.map.a.a<com.baidu.swan.apps.z.a.c> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = e.class.getSimpleName();

    public static e apv() {
        return new e();
    }

    private boolean d(final Context context, com.baidu.swan.apps.z.a.c cVar, com.baidu.swan.apps.z.b bVar, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.console.c.i("map", "MoveToLocationAction start");
        com.baidu.swan.apps.adaptation.b.e hg = com.baidu.swan.apps.y.f.UC().hg(cVar.bdW);
        if (!(hg instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        final com.baidu.swan.impl.map.b h = com.baidu.swan.impl.map.c.apm().h((com.baidu.swan.apps.adaptation.b.c) hg);
        final com.baidu.swan.impl.map.item.c pL = h.pL(cVar.bdV);
        if (pL == null) {
            com.baidu.swan.apps.console.c.e("map", "can not find map by id " + cVar.bdV);
            return false;
        } else if (!pL.isShowLocation) {
            com.baidu.swan.apps.console.c.w("map", "can not move to location because showLocation is not set");
            return false;
        } else {
            BDLocation apl = h.apl();
            if (apl == null || !h.apk()) {
                com.baidu.swan.impl.map.a.b.d.a(context, new d.a() { // from class: com.baidu.swan.impl.map.a.a.e.1
                    @Override // com.baidu.swan.impl.map.a.b.d.a
                    public void onSuccess() {
                        com.baidu.swan.apps.console.c.w("map", "location permission success");
                        e.this.a(context, pL, h);
                    }

                    @Override // com.baidu.swan.impl.map.a.b.d.a
                    public void onFail() {
                        com.baidu.swan.apps.console.c.w("map", "location permission fail");
                    }
                });
                return true;
            }
            pL.csp.getMap().animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(apl.getLatitude(), apl.getLongitude())));
            pL.csp.getMap().setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
            pL.csp.getMap().setMyLocationEnabled(true);
            pL.csp.getMap().setMyLocationData(new MyLocationData.Builder().accuracy(apl.getRadius()).latitude(apl.getLatitude()).longitude(apl.getLongitude()).build());
            com.baidu.swan.apps.console.c.i("map", "MoveToLocationAction end");
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, final com.baidu.swan.impl.map.item.c cVar, final com.baidu.swan.impl.map.b bVar) {
        com.baidu.swan.apps.w.a.RZ().a("gcj02", true, false, new f.a() { // from class: com.baidu.swan.impl.map.a.a.e.2
            @Override // com.baidu.swan.apps.w.b.f.a
            public void a(com.baidu.swan.apps.scheme.actions.f.b bVar2) {
                com.baidu.swan.apps.console.c.i("map", "get location " + bVar2.toJSON().toString());
                BaiduMap map = cVar.csp.getMap();
                map.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bVar2.latitude, bVar2.longitude)));
                map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                map.setMyLocationEnabled(true);
                map.setMyLocationData(new MyLocationData.Builder().accuracy((float) bVar2.bNM).latitude(bVar2.latitude).longitude(bVar2.longitude).build());
                bVar.eD(true);
            }

            @Override // com.baidu.swan.apps.w.b.f.a
            public void onFailed(int i) {
                com.baidu.swan.apps.console.c.i("map", "get location error " + i);
            }
        });
    }

    @Override // com.baidu.swan.impl.map.a.a
    protected boolean a(Context context, com.baidu.swan.apps.z.a.c cVar, com.baidu.swan.apps.z.b bVar, com.baidu.swan.apps.runtime.e eVar, JSONObject jSONObject) {
        return d(context, cVar, bVar, eVar);
    }
}
