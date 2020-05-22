package com.baidu.swan.impl.map.a.a;

import android.content.Context;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.swan.apps.u.b.d;
import com.baidu.swan.impl.map.a.b.d;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class e extends com.baidu.swan.impl.map.a.a<com.baidu.swan.apps.x.a.c> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = e.class.getSimpleName();

    public static e aDQ() {
        return new e();
    }

    private boolean d(final Context context, com.baidu.swan.apps.x.a.c cVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.console.c.i("map", "MoveToLocationAction start");
        com.baidu.swan.apps.adaptation.b.e jO = com.baidu.swan.apps.w.f.ahV().jO(cVar.bPG);
        if (!(jO instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        final com.baidu.swan.impl.map.b h = com.baidu.swan.impl.map.c.aDH().h((com.baidu.swan.apps.adaptation.b.c) jO);
        final com.baidu.swan.impl.map.item.c sQ = h.sQ(cVar.bPF);
        if (sQ == null) {
            com.baidu.swan.apps.console.c.e("map", "can not find map by id " + cVar.bPF);
            return false;
        } else if (!sQ.isShowLocation) {
            com.baidu.swan.apps.console.c.w("map", "can not move to location because showLocation is not set");
            return false;
        } else {
            BDLocation aDG = h.aDG();
            if (aDG == null || !h.aDF()) {
                com.baidu.swan.impl.map.a.b.d.a(context, new d.a() { // from class: com.baidu.swan.impl.map.a.a.e.1
                    @Override // com.baidu.swan.impl.map.a.b.d.a
                    public void onSuccess() {
                        com.baidu.swan.apps.console.c.w("map", "location permission success");
                        e.this.a(context, sQ, h);
                    }

                    @Override // com.baidu.swan.impl.map.a.b.d.a
                    public void onFail() {
                        com.baidu.swan.apps.console.c.w("map", "location permission fail");
                    }
                });
                return true;
            }
            sQ.dgG.getMap().animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(aDG.getLatitude(), aDG.getLongitude())));
            sQ.dgG.getMap().setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
            sQ.dgG.getMap().setMyLocationEnabled(true);
            sQ.dgG.getMap().setMyLocationData(new MyLocationData.Builder().accuracy(aDG.getRadius()).latitude(aDG.getLatitude()).longitude(aDG.getLongitude()).build());
            com.baidu.swan.apps.console.c.i("map", "MoveToLocationAction end");
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, final com.baidu.swan.impl.map.item.c cVar, final com.baidu.swan.impl.map.b bVar) {
        com.baidu.swan.apps.u.a.afj().a("gcj02", true, false, new d.a() { // from class: com.baidu.swan.impl.map.a.a.e.2
            @Override // com.baidu.swan.apps.u.b.d.a
            public void a(com.baidu.swan.apps.scheme.actions.f.b bVar2) {
                com.baidu.swan.apps.console.c.i("map", "get location " + bVar2.toJSON().toString());
                BaiduMap map = cVar.dgG.getMap();
                map.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bVar2.latitude, bVar2.longitude)));
                map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                map.setMyLocationEnabled(true);
                map.setMyLocationData(new MyLocationData.Builder().accuracy((float) bVar2.cCQ).latitude(bVar2.latitude).longitude(bVar2.longitude).build());
                bVar.fT(true);
            }

            @Override // com.baidu.swan.apps.u.b.d.a
            public void onFailed(int i) {
                com.baidu.swan.apps.console.c.i("map", "get location error " + i);
            }
        });
    }

    @Override // com.baidu.swan.impl.map.a.a
    protected boolean a(Context context, com.baidu.swan.apps.x.a.c cVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.runtime.e eVar, JSONObject jSONObject) {
        return d(context, cVar, bVar, eVar);
    }
}
