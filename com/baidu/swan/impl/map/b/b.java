package com.baidu.swan.impl.map.b;

import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;
import com.baidu.swan.impl.map.item.c;
/* loaded from: classes24.dex */
public class b implements View.OnClickListener, BaiduMap.OnMapClickListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapRenderCallback, BaiduMap.OnMapStatusChangeListener, BaiduMap.OnMarkerClickListener, BaiduMap.OnMyLocationClickListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = b.class.getSimpleName();
    private c dCK;

    public b(@NonNull c cVar) {
        this.dCK = cVar;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        com.baidu.swan.apps.console.c.i("map", "onMapLoaded");
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapClickListener
    public void onMapClick(LatLng latLng) {
        a.a(this.dCK, latLng);
        com.baidu.swan.apps.console.c.i("map", "onMapClick LatLng " + latLng);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapClickListener
    public void onMapPoiClick(MapPoi mapPoi) {
        a.a(this.dCK, mapPoi);
        com.baidu.swan.apps.console.c.i("map", "onMapPoiClick MapPoi " + mapPoi.getPosition());
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapRenderCallback
    public void onMapRenderFinished() {
        a.b(this.dCK);
        com.baidu.swan.apps.console.c.i("map", "onMapRenderFinished");
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        com.baidu.swan.impl.map.item.b b = this.dCK.b(marker);
        if (b != null) {
            a.a(marker, this.dCK);
            b.c(this.dCK);
            com.baidu.swan.apps.console.c.i("map", "onMarkerClick marker id " + marker.getId());
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a.a(view, this.dCK);
        com.baidu.swan.apps.console.c.i("map", "Control View click");
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus) {
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChange(MapStatus mapStatus) {
        com.baidu.swan.apps.console.c.i("map", "onMapStatusChange");
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        a.a(this.dCK, mapStatus);
        com.baidu.swan.apps.console.c.i("map", "onMapStatusChangeFinish");
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMyLocationClickListener
    public boolean onMyLocationClick() {
        return false;
    }
}
