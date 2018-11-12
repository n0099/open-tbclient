package com.baidu.searchbox.ng.ai.apps.impl.map.action.helper;

import android.content.Context;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.CircleOptions;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.map.Stroke;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.impl.map.MapViewHelper;
import com.baidu.searchbox.ng.ai.apps.impl.map.action.helper.LocationPermissionHelper;
import com.baidu.searchbox.ng.ai.apps.impl.map.event.MapEventListener;
import com.baidu.searchbox.ng.ai.apps.impl.map.item.MapViewItem;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.MapModel;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.CircleModel;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.ControlModel;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.CoordinateModel;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.MarkerModel;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.PolylineModel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class MapViewInitHelper {
    public static void initMapView(Context context, MapViewItem mapViewItem, MapModel mapModel, MapViewHelper mapViewHelper) {
        if (mapViewItem == null || mapModel == null || !mapModel.isValid()) {
            AiAppsLog.e("map", "initMapView model is invalid");
            return;
        }
        BaiduMap map = mapViewItem.mapView.getMap();
        MapEventListener mapEventListener = new MapEventListener(mapViewItem);
        mapViewItem.mapView.getMap().setOnMapClickListener(mapEventListener);
        mapViewItem.mapView.getMap().setOnMarkerClickListener(mapEventListener);
        mapViewItem.mapView.getMap().setOnMapLoadedCallback(mapEventListener);
        mapViewItem.mapView.getMap().setOnMapRenderCallbadk(mapEventListener);
        mapViewItem.mapView.getMap().setOnMapStatusChangeListener(mapEventListener);
        mapViewItem.mapView.getMap().setOnMyLocationClickListener(mapEventListener);
        map.getUiSettings().setRotateGesturesEnabled(false);
        mapViewItem.mapView.showZoomControls(false);
        map.getUiSettings().setOverlookingGesturesEnabled(false);
        if (mapModel.coordinate != null && mapModel.coordinate.isValid()) {
            AiAppsLog.i("map", "initMapView coordinate is " + mapModel.coordinate);
            map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(mapModel.coordinate.latitude, mapModel.coordinate.longitude)));
        }
        map.setMapStatus(MapStatusUpdateFactory.zoomTo((float) mapModel.scale));
        AiAppsLog.i("map", "initMapView scale is " + mapModel.scale);
        mapViewItem.isShowLocation = mapModel.isShowLocation;
        if (mapModel.isShowLocation) {
            startLocation(context, mapViewHelper);
        } else {
            mapViewHelper.triggerLocation(false);
        }
        if (mapModel.markers != null && mapModel.markers.size() > 0) {
            for (MarkerModel markerModel : mapModel.markers) {
                MarkerViewCreateHelper.createMarker(mapViewItem, markerModel);
                AiAppsLog.i("map", "initMapView createMarker id " + markerModel.id);
            }
        }
        if (mapModel.controls != null && mapModel.controls.size() > 0) {
            for (ControlModel controlModel : mapModel.controls) {
                ControlViewCreateHelper.createControl(mapViewItem, controlModel, mapEventListener);
                AiAppsLog.i("map", "initMapView createControl id " + controlModel.id);
            }
        }
        if (mapModel.polyline != null && mapModel.polyline.size() > 0) {
            for (PolylineModel polylineModel : mapModel.polyline) {
                if (polylineModel.isValid()) {
                    ArrayList arrayList = new ArrayList(polylineModel.coordinates.size());
                    Iterator<CoordinateModel> it = polylineModel.coordinates.iterator();
                    while (it.hasNext()) {
                        CoordinateModel next = it.next();
                        arrayList.add(new LatLng(next.latitude, next.longitude));
                    }
                    map.addOverlay(new PolylineOptions().points(arrayList).color(polylineModel.color).width((int) polylineModel.width).dottedLine(polylineModel.isDottedLine));
                    AiAppsLog.i("map", "initMapView createPoly");
                }
            }
        }
        if (mapModel.circles != null && mapModel.circles.size() > 0) {
            for (CircleModel circleModel : mapModel.circles) {
                if (circleModel.isValid()) {
                    map.addOverlay(new CircleOptions().center(new LatLng(circleModel.coordinate.latitude, circleModel.coordinate.longitude)).stroke(new Stroke((int) circleModel.strokeWidth, circleModel.color)).fillColor(circleModel.fillColor).radius(circleModel.radius));
                    AiAppsLog.i("map", "initMapView createCircle");
                }
            }
        }
        if (mapModel.includePoints != null && mapModel.includePoints.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (CoordinateModel coordinateModel : mapModel.includePoints) {
                builder.include(new LatLng(coordinateModel.latitude, coordinateModel.longitude));
            }
            map.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
            AiAppsLog.i("map", "initMapView includePoints");
        }
    }

    private static void startLocation(Context context, final MapViewHelper mapViewHelper) {
        LocationPermissionHelper.checkLocationPermission(context, new LocationPermissionHelper.PermissionCallback() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.action.helper.MapViewInitHelper.1
            @Override // com.baidu.searchbox.ng.ai.apps.impl.map.action.helper.LocationPermissionHelper.PermissionCallback
            public void onSuccess() {
                MapViewHelper.this.triggerLocation(true);
                AiAppsLog.i("map", "location permission success");
            }

            @Override // com.baidu.searchbox.ng.ai.apps.impl.map.action.helper.LocationPermissionHelper.PermissionCallback
            public void onFail() {
                AiAppsLog.i("map", "location permission fail");
            }
        });
    }
}
