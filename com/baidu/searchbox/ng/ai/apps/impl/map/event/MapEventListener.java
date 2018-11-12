package com.baidu.searchbox.ng.ai.apps.impl.map.event;

import android.view.View;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.impl.map.item.MapViewItem;
import com.baidu.searchbox.ng.ai.apps.impl.map.item.MarkerViewItem;
/* loaded from: classes4.dex */
public class MapEventListener implements View.OnClickListener, BaiduMap.OnMapClickListener, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapRenderCallback, BaiduMap.OnMapStatusChangeListener, BaiduMap.OnMarkerClickListener, BaiduMap.OnMyLocationClickListener {
    private static final boolean DEBUG = false;
    private static final String TAG = MapEventListener.class.getSimpleName();
    private MapViewItem mMapViewItem;

    public MapEventListener(MapViewItem mapViewItem) {
        this.mMapViewItem = mapViewItem;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback
    public void onMapLoaded() {
        AiAppsLog.i("map", "onMapLoaded");
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapClickListener
    public void onMapClick(LatLng latLng) {
        MapEventHelper.mapTap(this.mMapViewItem, latLng);
        AiAppsLog.i("map", "onMapClick LatLng " + latLng);
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapClickListener
    public boolean onMapPoiClick(MapPoi mapPoi) {
        return false;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapRenderCallback
    public void onMapRenderFinished() {
        MapEventHelper.mapUpdate(this.mMapViewItem);
        AiAppsLog.i("map", "onMapRenderFinished");
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        MarkerViewItem markerViewItem = this.mMapViewItem.getMarkerViewItem(marker);
        if (markerViewItem != null) {
            MapEventHelper.markerTap(marker, this.mMapViewItem);
            markerViewItem.showCallout(this.mMapViewItem);
            AiAppsLog.i("map", "onMarkerClick marker id " + marker.getId());
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MapEventHelper.ControlTap(view, this.mMapViewItem);
        AiAppsLog.i("map", "Control View click");
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus) {
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChange(MapStatus mapStatus) {
        AiAppsLog.i("map", "onMapStatusChange");
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        MapEventHelper.regionChanged(this.mMapViewItem, mapStatus);
        AiAppsLog.i("map", "onMapStatusChangeFinish");
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMyLocationClickListener
    public boolean onMyLocationClick() {
        return false;
    }
}
