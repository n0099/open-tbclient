package com.baidu.swan.impl.map.a.a;

import android.content.Context;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.swan.apps.u.b.n;
import com.baidu.swan.impl.map.a.b.d;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e extends com.baidu.swan.impl.map.a.a<com.baidu.swan.apps.x.a.c> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = e.class.getSimpleName();

    public static e UE() {
        return new e();
    }

    private boolean d(final Context context, com.baidu.swan.apps.x.a.c cVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2) {
        com.baidu.swan.apps.console.c.i("map", "MoveToLocationAction start");
        com.baidu.swan.apps.b.c.e dY = com.baidu.swan.apps.w.e.GF().dY(cVar.aDU);
        if (!(dY instanceof com.baidu.swan.apps.b.c.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        final com.baidu.swan.impl.map.b h = com.baidu.swan.impl.map.c.Uw().h((com.baidu.swan.apps.b.c.c) dY);
        final com.baidu.swan.impl.map.item.b kj = h.kj(cVar.id);
        if (kj == null) {
            com.baidu.swan.apps.console.c.e("map", "can not find map by id " + cVar.id);
            return false;
        } else if (!kj.isShowLocation) {
            com.baidu.swan.apps.console.c.w("map", "can not move to location because showLocation is not set");
            return false;
        } else {
            BDLocation Uv = h.Uv();
            if (Uv == null || !h.Uu()) {
                com.baidu.swan.impl.map.a.b.d.a(context, new d.a() { // from class: com.baidu.swan.impl.map.a.a.e.1
                    @Override // com.baidu.swan.impl.map.a.b.d.a
                    public void onSuccess() {
                        com.baidu.swan.apps.console.c.w("map", "location permission success");
                        e.this.a(context, kj, h);
                    }

                    @Override // com.baidu.swan.impl.map.a.b.d.a
                    public void onFail() {
                        com.baidu.swan.apps.console.c.w("map", "location permission fail");
                    }
                });
                return true;
            }
            kj.bof.getMap().animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(Uv.getLatitude(), Uv.getLongitude())));
            kj.bof.getMap().setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
            kj.bof.getMap().setMyLocationEnabled(true);
            kj.bof.getMap().setMyLocationData(new MyLocationData.Builder().accuracy(Uv.getRadius()).latitude(Uv.getLatitude()).longitude(Uv.getLongitude()).build());
            com.baidu.swan.apps.console.c.i("map", "MoveToLocationAction end");
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, final com.baidu.swan.impl.map.item.b bVar, final com.baidu.swan.impl.map.b bVar2) {
        com.baidu.swan.apps.u.a.ED().a(CoordinateType.GCJ02, true, false, new n.a() { // from class: com.baidu.swan.impl.map.a.a.e.2
            @Override // com.baidu.swan.apps.u.b.n.a
            public void a(com.baidu.swan.apps.scheme.actions.e.b bVar3) {
                com.baidu.swan.apps.console.c.i("map", "get location " + bVar3.toJSON().toString());
                BaiduMap map = bVar.bof.getMap();
                map.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bVar3.latitude, bVar3.longitude)));
                map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                map.setMyLocationEnabled(true);
                map.setMyLocationData(new MyLocationData.Builder().accuracy((float) bVar3.aTw).latitude(bVar3.latitude).longitude(bVar3.longitude).build());
                bVar2.cW(true);
            }

            @Override // com.baidu.swan.apps.u.b.n.a
            public void cC(int i) {
                com.baidu.swan.apps.console.c.i("map", "get location error " + i);
            }
        });
    }

    @Override // com.baidu.swan.impl.map.a.a
    protected boolean a(Context context, com.baidu.swan.apps.x.a.c cVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2, JSONObject jSONObject) {
        return d(context, cVar, bVar, bVar2);
    }
}
